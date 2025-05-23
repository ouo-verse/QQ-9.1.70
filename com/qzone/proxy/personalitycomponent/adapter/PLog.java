package com.qzone.proxy.personalitycomponent.adapter;

import android.util.Log;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
public class PLog {
    public static int CLR = 2;
    public static int DEV = 4;
    public static int USR = 1;

    public static void d(String str, String str2) {
        QZLog.d(str, CLR, str2);
    }

    public static void e(String str, String str2) {
        QZLog.e(str, str2, (Throwable) null);
    }

    public static void i(String str, int i3, String str2) {
        QZLog.i(str, i3, str2);
    }

    public static boolean isColorLevel() {
        return QZLog.isColorLevel();
    }

    public static boolean isDevelopLevel() {
        return QZLog.isDevelopLevel();
    }

    public static void v(String str, String str2) {
        QZLog.d(str, CLR, str2);
    }

    public static void w(String str, String str2) {
        QZLog.w(str, str2, (Throwable) null);
    }

    public static void d(String str, int i3, String str2) {
        QZLog.d(str, i3, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        QZLog.e(str, str2, th5);
    }

    public static void i(String str, int i3, String str2, Throwable th5) {
        QZLog.i(str, i3, str2 + ",ex:" + Log.getStackTraceString(th5));
    }

    public static void v(String str, String str2, Throwable th5) {
        String stackTraceString = Log.getStackTraceString(th5);
        QZLog.d(str, CLR, str2 + ",ex:" + stackTraceString);
    }

    public static void w(String str, String str2, Throwable th5) {
        QZLog.w(str, str2, th5);
    }

    public static void d(String str, int i3, String str2, Throwable th5) {
        QZLog.d(str, i3, str2 + ",ex:" + Log.getStackTraceString(th5));
    }
}
