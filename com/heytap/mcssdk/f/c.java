package com.heytap.mcssdk.f;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36186a = "mcssdk---";

    /* renamed from: b, reason: collision with root package name */
    private static String f36187b = "MCS";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f36188c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f36189d = false;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f36190e = true;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f36191f = true;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f36192g = true;

    /* renamed from: h, reason: collision with root package name */
    private static String f36193h = "-->";

    /* renamed from: i, reason: collision with root package name */
    private static boolean f36194i = true;

    public static String a() {
        return f36187b;
    }

    public static void b(String str) {
        if (f36190e && f36194i) {
            Log.d(f36186a, f36187b + f36193h + str);
        }
    }

    public static void c(String str) {
        if (f36189d && f36194i) {
            Log.i(f36186a, f36187b + f36193h + str);
        }
    }

    public static void d(String str) {
        if (f36191f && f36194i) {
            Log.w(f36186a, f36187b + f36193h + str);
        }
    }

    public static void e(String str) {
        if (f36192g && f36194i) {
            Log.e(f36186a, f36187b + f36193h + str);
        }
    }

    public static void f(String str) {
        f36187b = str;
    }

    public static void g(String str) {
        f36193h = str;
    }

    public static String h() {
        return f36193h;
    }

    public static void a(Exception exc) {
        if (!f36192g || exc == null) {
            return;
        }
        Log.e(f36186a, exc.getMessage());
    }

    public static void b(String str, String str2) {
        if (f36190e && f36194i) {
            Log.d(str, f36187b + f36193h + str2);
        }
    }

    public static void c(String str, String str2) {
        if (f36189d && f36194i) {
            Log.i(str, f36187b + f36193h + str2);
        }
    }

    public static void d(String str, String str2) {
        if (f36191f && f36194i) {
            Log.w(str, f36187b + f36193h + str2);
        }
    }

    public static void e(String str, String str2) {
        if (f36192g && f36194i) {
            Log.e(str, f36187b + f36193h + str2);
        }
    }

    public static void f(boolean z16) {
        f36194i = z16;
        boolean z17 = z16;
        f36188c = z17;
        f36190e = z17;
        f36189d = z17;
        f36191f = z17;
        f36192g = z17;
    }

    public static boolean g() {
        return f36194i;
    }

    public static void a(String str) {
        if (f36188c && f36194i) {
            Log.v(f36186a, f36187b + f36193h + str);
        }
    }

    public static void b(boolean z16) {
        f36190e = z16;
    }

    public static void c(boolean z16) {
        f36189d = z16;
    }

    public static void d(boolean z16) {
        f36191f = z16;
    }

    public static void e(boolean z16) {
        f36192g = z16;
    }

    public static boolean f() {
        return f36192g;
    }

    public static void a(String str, String str2) {
        if (f36188c && f36194i) {
            Log.v(str, f36187b + f36193h + str2);
        }
    }

    public static boolean b() {
        return f36188c;
    }

    public static boolean c() {
        return f36190e;
    }

    public static boolean d() {
        return f36189d;
    }

    public static boolean e() {
        return f36191f;
    }

    public static void a(String str, Throwable th5) {
        if (f36192g) {
            Log.e(str, th5.toString());
        }
    }

    public static void a(boolean z16) {
        f36188c = z16;
    }
}
