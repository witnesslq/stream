package com.sdu.scala.func

import java.sql.Date
import java.text.SimpleDateFormat

/**
  * @author hanhan.zhang
  * */
object FunctionStudy {

  // 本地函数
  def getArraySum(numberArray : Array[Int]) : Int = {
    // 定义本地函数[只能在定义的函数内部使用,外部禁止使用]
    def arraySum(numberArray : Array[Int]) : Int = {
      numberArray.sum
    }
    // 调用本地函数
    arraySum(numberArray)
  }

  // 函数文本
  var increase = (x : Int) => x + 1

  // 函数参数
  def getTime(timestamp : Long, f: (Long) => String) : String = {
    "当前时间: " + f(timestamp)
  }

  // 柯里化函数: def add(x : Int)(y : Int) = x + y
  // 柯里化实质: def add(x : Int)(y : Int) = (y : Int ) => x + y
  def get(name : String, f1 : String => String)(age : Int, f2 : Int => String): String = {
    // 决定调用顺序
    f2(age) + f1(name)
  }

  def main(args: Array[String]): Unit = {
    println("本地函数: " + getArraySum(Array(1, 2, 3)))
    println("函数文本: " + increase(1))

    println("函数参数: " + getTime(System.currentTimeMillis() ,timestamp => {
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp))
    }))

    println("柯里化函数: " + get("Lily", name => {
      println("调用参数函数f1")
      "My name is " + name + ", "
    })(16, age => {
      println("调用参数函数f2")
      "age is " + age
    }))
  }
}
