package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37986a = "SecurityComp10200300: ";

    public static void a(String str, String str2) {
    }

    public static void b(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void d(String str, String str2) {
        Log.v(a(str), str2);
    }

    public static void e(String str, String str2) {
        Log.w(a(str), str2);
    }

    public static void a(String str, String str2, Throwable th5) {
        Log.e(a(str), str2, th5);
    }

    private static String a(String str) {
        return f37986a + str;
    }
}
