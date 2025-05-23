package com.tencent.timi.game.utils;

import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes26.dex */
public class l {
    public static void a(String str, int i3, String str2) {
        k.f380303a.a(str2);
        QLog.d(str, i3, str2);
    }

    public static void b(String str, String str2) {
        k.f380303a.a(str2);
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    public static void c(String str, int i3, String str2) {
        k.f380303a.a(str2);
        QLog.e(str, i3, str2);
    }

    public static void d(String str, int i3, String str2, Throwable th5) {
        k.f380303a.a(str2);
        QLog.e(str, i3, str2, th5);
    }

    public static void e(String str, String str2) {
        k.f380303a.a(str2);
        QLog.e(str, 1, str2);
    }

    public static void f(String str, String str2, Throwable th5) {
        k.f380303a.a(str2);
        QLog.e(str, 1, str2, th5);
    }

    public static String g(long j3) {
        return "";
    }

    public static void h(String str, int i3, String str2) {
        k.f380303a.a(str2);
        QLog.i(str, i3, str2);
    }

    public static void i(String str, String str2) {
        k.f380303a.a(str2);
        QLog.i(str, 1, str2);
    }

    public static String j(long j3) {
        return LogUtil.getSafePrintUin(String.valueOf(j3));
    }

    public static void k(String str, int i3, String str2) {
        k.f380303a.a(str2);
        QLog.w(str, i3, str2);
    }

    public static void l(String str, int i3, String str2, Throwable th5) {
        k.f380303a.a(str2);
        QLog.w(str, i3, str2, th5);
    }

    public static void m(String str, String str2) {
        k.f380303a.a(str2);
        if (QLog.isColorLevel()) {
            QLog.w(str, 2, str2);
        }
    }

    public static void n(String str, String str2, Throwable th5) {
        k.f380303a.a(str2);
        if (QLog.isColorLevel()) {
            QLog.w(str, 2, str2, th5);
        }
    }
}
