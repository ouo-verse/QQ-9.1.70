package com.tencent.open.base;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f340973a = true;

    /* renamed from: b, reason: collision with root package name */
    protected static String f340974b = "";

    static {
        f340974b += ".*[S|s][I|i][D|d].*";
        f340974b += "|.*==.*";
        f340974b += "|.*[U|u][I|i][N|n].*";
        f340974b += "|.*%3d%3d.*";
        f340974b += "|.*[V|v][K|k][E|e][Y|y]";
    }

    public static void a(String str, String str2) {
        g(2, str, str2, null);
    }

    public static void b(String str, String str2, Throwable th5) {
        g(2, str, str2, th5);
    }

    public static void c(String str, String str2) {
        g(4, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th5) {
        g(4, str, str2, th5);
    }

    public static void e(String str, String str2) {
        g(1, str, str2, null);
    }

    public static boolean f() {
        return f340973a;
    }

    protected static void g(int i3, String str, String str2, Throwable th5) {
        if (f340973a) {
            if (i3 == 1) {
                if (th5 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(str, 2, "::" + str2);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i(str, 2, "::" + str2, th5);
                }
            }
            if (i3 == 2 || i3 == 0) {
                if (th5 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "::" + str2);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "::" + str2, th5);
                }
            }
            if (i3 == 3) {
                if (th5 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w(str, 2, "::" + str2);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.w(str, 2, "::" + str2, th5);
                }
            }
            if (i3 == 4) {
                if (th5 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e(str, 2, "::" + str2);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(str, 2, "::" + str2, th5);
                }
            }
        }
    }

    public static void h(String str, String str2) {
        g(0, str, str2, null);
    }

    public static void i(String str, String str2) {
        g(3, str, str2, null);
    }

    public static void j(String str, String str2, Throwable th5) {
        g(3, str, str2, th5);
    }
}
