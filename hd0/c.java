package hd0;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f404746a = b.b();

    public static void a(String str, String str2) {
        if (f404746a.a(3)) {
            f404746a.d(str, str2);
        }
    }

    public static void b(String str, String str2, Object obj) {
        if (f404746a.a(3)) {
            f404746a.d(str, j(str2, obj));
        }
    }

    public static void c(String str, String str2, Object obj, Object obj2) {
        if (f404746a.a(3)) {
            f404746a.d(str, j(str2, obj, obj2));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (f404746a.a(3)) {
            f404746a.d(str, j(str2, obj, obj2, obj3));
        }
    }

    public static void e(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f404746a.a(3)) {
            f404746a.d(str, j(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (f404746a.a(3)) {
            a(str, j(str2, objArr));
        }
    }

    public static void g(String str, String str2) {
        if (f404746a.a(6)) {
            f404746a.e(str, str2);
        }
    }

    public static void h(String str, String str2, Throwable th5) {
        if (f404746a.a(6)) {
            f404746a.e(str, str2, th5);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (f404746a.a(6)) {
            f404746a.e(str, j(str2, objArr));
        }
    }

    private static String j(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    public static void k(String str, String str2) {
        if (f404746a.a(4)) {
            f404746a.i(str, str2);
        }
    }

    public static void l(String str, String str2, Object obj) {
        if (f404746a.a(4)) {
            f404746a.i(str, j(str2, obj));
        }
    }

    public static void m(String str, String str2, Object obj, Object obj2) {
        if (f404746a.a(4)) {
            f404746a.i(str, j(str2, obj, obj2));
        }
    }

    public static void n(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (f404746a.a(4)) {
            f404746a.i(str, j(str2, obj, obj2, obj3));
        }
    }

    public static void o(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f404746a.a(4)) {
            f404746a.i(str, j(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void p(String str, String str2, Object... objArr) {
        if (f404746a.a(4)) {
            f404746a.i(str, j(str2, objArr));
        }
    }

    public static boolean q() {
        return QLog.isColorLevel();
    }

    public static void r(a aVar) {
        if (aVar != null) {
            f404746a = aVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void s(String str, String str2) {
        if (f404746a.a(2)) {
            f404746a.v(str, str2);
        }
    }

    public static void t(String str, String str2) {
        if (f404746a.a(5)) {
            f404746a.w(str, str2);
        }
    }

    public static void u(String str, String str2, Throwable th5) {
        if (f404746a.a(5)) {
            f404746a.w(str, str2, th5);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (f404746a.a(5)) {
            f404746a.w(str, j(str2, objArr));
        }
    }

    public static void w(String str, Throwable th5, String str2, Object... objArr) {
        if (f404746a.a(5)) {
            f404746a.w(str, j(str2, objArr), th5);
        }
    }
}
