package com.tencent.open.agent.util;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class t {
    public static void a(String str, String str2, Throwable th5) {
        QLog.d("SDK_LOGIN." + str, 1, str2, th5);
    }

    public static void b(String str, Object... objArr) {
        QLog.d("SDK_LOGIN." + str, 1, objArr);
    }

    public static void c(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("SDK_LOGIN." + str, 2, str2);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        QLog.e("SDK_LOGIN." + str, 1, str2, th5);
    }

    public static void e(String str, Object... objArr) {
        QLog.e("SDK_LOGIN." + str, 1, objArr);
    }

    public static void f(String str, String str2) {
        QLog.i("SDK_LOGIN." + str, 1, str2);
    }

    public static void g(String str, String str2, Throwable th5) {
        QLog.i("SDK_LOGIN." + str, 1, str2, th5);
    }
}
