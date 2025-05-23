package com.tencent.luggage.wxa.er;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(String str, boolean z16) {
        b(str, !z16);
    }

    public static void b(String str, boolean z16) {
        if (z16) {
            return;
        }
        a(str);
    }

    public static void c(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        e(str, obj, obj2);
    }

    public static void d(String str, Object obj, Object obj2) {
        a(f(str, obj, obj2));
    }

    public static void e(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        a(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static String f(String str, Object obj, Object obj2) {
        String str2;
        if (str != null && str.length() > 0) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }

    public static void a(boolean z16) {
        a((String) null, z16);
    }

    public static void b(boolean z16) {
        b((String) null, z16);
    }

    public static void c(Object obj, Object obj2) {
        c(null, obj, obj2);
    }

    public static void a(String str) {
        if (str == null) {
            throw new RuntimeException(str);
        }
        throw new RuntimeException(str);
    }

    public static void b(Object obj) {
        if (obj != null) {
            b("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void b(String str, Object obj) {
        b(str, obj == null);
    }

    public static void a(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null || !obj.equals(obj2)) {
            d(str, obj, obj2);
        }
    }

    public static void b(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            b(str);
        }
    }

    public static void b(Object obj, Object obj2) {
        b(null, obj, obj2);
    }

    public static void a(Object obj, Object obj2) {
        a((String) null, obj, obj2);
    }

    public static void b(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        a(str2 + "expected not same");
    }

    public static void a(String str, String str2, String str3) {
        if (str2 == null && str3 == null) {
            return;
        }
        if (str2 == null || !str2.equals(str3)) {
            if (str == null) {
                str = "";
            }
            throw new RuntimeException(str);
        }
    }

    public static void a(String str, String str2) {
        a((String) null, str, str2);
    }

    public static void a(String str, long j3, long j16) {
        a(str, Long.valueOf(j3), Long.valueOf(j16));
    }

    public static void a(long j3, long j16) {
        a((String) null, j3, j16);
    }

    public static void a(String str, int i3, int i16) {
        a(str, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static void a(int i3, int i16) {
        a((String) null, i3, i16);
    }

    public static void a(Object obj) {
        a((String) null, obj);
    }

    public static void a(String str, Object obj) {
        b(str, obj != null);
    }
}
