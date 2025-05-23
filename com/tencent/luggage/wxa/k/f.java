package com.tencent.luggage.wxa.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static n f131297a = g.a();

    public static void a(n nVar) {
        if (nVar != null) {
            f131297a = nVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void b(String str, String str2, Object obj) {
        if (f131297a.a(4)) {
            f131297a.i(str, a(str2, obj));
        }
    }

    public static void c(String str, String str2) {
        if (f131297a.a(4)) {
            f131297a.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f131297a.a(5)) {
            f131297a.w(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (f131297a.a(3)) {
            f131297a.d(str, str2);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f131297a.a(4)) {
            f131297a.i(str, a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Throwable th5) {
        if (f131297a.a(5)) {
            f131297a.a(str, str2, th5);
        }
    }

    public static void a(String str, String str2, Object obj) {
        if (f131297a.a(3)) {
            f131297a.d(str, a(str2, obj));
        }
    }

    public static void b(String str, String str2, Throwable th5) {
        if (f131297a.a(4)) {
            f131297a.i(str, str2, th5);
        }
    }

    public static void a(String str, String str2, Object obj, Object obj2) {
        if (f131297a.a(4)) {
            f131297a.i(str, a(str2, obj, obj2));
        }
    }

    public static void b(String str, String str2) {
        if (f131297a.a(6)) {
            f131297a.e(str, str2);
        }
    }

    public static void a(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (f131297a.a(4)) {
            f131297a.i(str, a(str2, obj, obj2, obj3));
        }
    }

    public static void a(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f131297a.a(4)) {
            f131297a.i(str, a(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f131297a.a(6)) {
            f131297a.e(str, a(str2, objArr));
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        if (f131297a.a(6)) {
            f131297a.e(str, str2, th5);
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }
}
