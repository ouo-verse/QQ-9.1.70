package com.tencent.biz.pubaccount.weishi.util;

import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static final String f81804a = "weishi" + AppSetting.f99551k.replaceAll("\\.", "");

    public static void a(String str, int i3, String str2) {
        String str3 = f81804a + "-" + str;
        if (str2 == null) {
            str2 = "";
        }
        QLog.d(str3, i3, str2);
    }

    public static void c(String str, String str2) {
        if (QLog.isColorLevel()) {
            a(str, 2, str2);
        }
    }

    public static void d(String str) {
        e(f81804a, 1, str);
    }

    public static void e(String str, int i3, String str2) {
        String str3 = f81804a + "-" + str;
        if (str2 == null) {
            str2 = "";
        }
        QLog.e(str3, i3, str2);
    }

    public static String g(Throwable th5) {
        return Log.getStackTraceString(th5);
    }

    public static void h(String str, int i3, String str2) {
        String str3 = f81804a + "-" + str;
        if (str2 == null) {
            str2 = "";
        }
        QLog.i(str3, i3, str2);
    }

    public static void j(String str, String str2) {
        if (QLog.isColorLevel()) {
            h(str, 2, str2);
        }
    }

    public static void k(String str, int i3, String str2) {
        String str3 = f81804a + "-" + str;
        if (str2 == null) {
            str2 = "";
        }
        QLog.w(str3, i3, str2);
    }

    public static void m(String str, String str2) {
        if (QLog.isColorLevel()) {
            k(str, 2, str2);
        }
    }

    public static void b(String str, String str2) {
        a(str, 4, str2);
    }

    public static void f(String str, String str2) {
        e(str, 1, str2);
    }

    public static void i(String str, String str2) {
        h(str, 4, str2);
    }

    public static void l(String str, String str2) {
        k(str, 4, str2);
    }
}
