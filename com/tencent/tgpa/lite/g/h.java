package com.tencent.tgpa.lite.g;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f375977a = false;

    private static void a(String str, String str2) {
        if (!f375977a || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    private static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        Log.e(str, str2);
    }

    private static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        Log.i(str, str2);
    }

    private static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        Log.w(str, str2);
    }

    public static void a(String str, Throwable th5) {
        b("TGPALite", str);
        b("TGPALite", th5.getMessage());
    }

    public static void b(String str, Object... objArr) {
        b("TGPALite", String.format(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        c("TGPALite", String.format(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        d("TGPALite", String.format(str, objArr));
    }

    public static void a(String str, Object... objArr) {
        a("TGPALite", String.format(str, objArr));
    }

    public static void a(boolean z16) {
        f375977a = z16;
    }
}
