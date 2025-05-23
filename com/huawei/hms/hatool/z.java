package com.huawei.hms.hatool;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class z {
    public static String a(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null) {
            return c16.a();
        }
        return "";
    }

    public static boolean b(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null && c16.e()) {
            return true;
        }
        return false;
    }

    private static j0 c(String str, String str2) {
        s0 a16;
        l1 a17 = s.c().a(str);
        if (a17 != null && (a16 = a17.a(str2)) != null) {
            return a16.j();
        }
        return null;
    }

    public static String d(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null) {
            return c16.b();
        }
        return "";
    }

    public static boolean e(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null && c16.f()) {
            return true;
        }
        return false;
    }

    public static boolean f(String str, String str2) {
        s0 a16;
        l1 a17 = s.c().a(str);
        if (a17 != null && (a16 = a17.a(str2)) != null) {
            return a16.c();
        }
        return false;
    }

    public static String g(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null) {
            return c16.d();
        }
        return "";
    }

    public static boolean h(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null && c16.g()) {
            return true;
        }
        return false;
    }

    public static boolean i(String str, String str2) {
        s0 a16;
        l1 a17 = s.c().a(str);
        if (a17 != null && (a16 = a17.a(str2)) != null) {
            return a16.e();
        }
        return false;
    }

    public static String j(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null) {
            return c16.c();
        }
        return "";
    }

    public static boolean k(String str, String str2) {
        j0 c16 = c(str, str2);
        if (c16 != null && c16.h()) {
            return true;
        }
        return false;
    }
}
