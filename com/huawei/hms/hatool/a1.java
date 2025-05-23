package com.huawei.hms.hatool;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a1 {
    public static void a(String str, String str2, long j3) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            h16.a(j3);
        }
    }

    public static int b(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.d();
        }
        return 7;
    }

    public static boolean c(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.g();
        }
        return true;
    }

    public static String d(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.f();
        }
        return "";
    }

    public static boolean e(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.i();
        }
        return false;
    }

    public static String f(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.h();
        }
        return "";
    }

    public static String g(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.n();
        }
        return "";
    }

    private static s0 h(String str, String str2) {
        l1 a16 = s.c().a(str);
        if (a16 != null) {
            if ("alltype".equals(str2)) {
                s0 a17 = a16.a("oper");
                if (a17 == null) {
                    return a16.a("maint");
                }
                return a17;
            }
            return a16.a(str2);
        }
        return null;
    }

    public static Map<String, String> i(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.k();
        }
        return null;
    }

    public static long j(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.l();
        }
        return 0L;
    }

    public static int k(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.b();
        }
        return 10;
    }

    public static String l(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.o();
        }
        return "";
    }

    public static String m(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.q();
        }
        return "";
    }

    public static String n(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.m();
        }
        return "";
    }

    public static String o(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.p();
        }
        return "";
    }

    public static boolean a(String str, String str2) {
        s0 h16 = h(str, str2);
        if (h16 != null) {
            return h16.a();
        }
        return true;
    }
}
