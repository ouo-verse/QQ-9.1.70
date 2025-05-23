package com.qzone.proxy.feedcomponent.util;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j {
    public static void a(String str, int i3, String str2) {
        QLog.d(str, i3, str2);
    }

    public static void b(String str, int i3, String str2, Throwable th5) {
        QLog.d(str, i3, str2, th5);
    }

    public static void e(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
    }

    public static boolean g() {
        return QLog.isColorLevel();
    }

    public static final boolean h() {
        return QLog.isDevelopLevel();
    }

    public static void k(Throwable th5) {
        j("exception", "", th5);
    }

    public static void c(String str, String str2) {
        QLog.e(str, 1, str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
    }

    public static void f(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    public static void j(String str, String str2, Throwable th5) {
        QLog.w(str, 1, str2, th5);
    }

    public static void i(String str, String str2) {
        QLog.w(str, 1, str2, null);
    }
}
