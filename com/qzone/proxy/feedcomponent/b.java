package com.qzone.proxy.feedcomponent;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static j f50142a;

    public static void b(String str, String str2, Throwable th5) {
        j jVar = f50142a;
        if (jVar != null) {
            jVar.d(str, str2, th5);
        } else {
            Log.d(str, str2, th5);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        j jVar = f50142a;
        if (jVar != null) {
            jVar.e(str, str2, th5);
        } else {
            Log.e(str, str2, th5);
        }
    }

    public static void f(String str, String str2, Throwable th5) {
        j jVar = f50142a;
        if (jVar != null) {
            jVar.i(str, str2, th5);
        } else {
            Log.i(str, str2, th5);
        }
    }

    public static boolean g() {
        j jVar = f50142a;
        if (jVar != null) {
            return jVar.isColorLevel();
        }
        return true;
    }

    public static void h(j jVar) {
        f50142a = jVar;
    }

    public static void j(String str, String str2, Throwable th5) {
        j jVar = f50142a;
        if (jVar != null) {
            jVar.w(str, str2, th5);
        } else {
            Log.w(str, str2, th5);
        }
    }

    public static void a(String str, String str2) {
        b(str, str2, null);
    }

    public static void c(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        f(str, str2, null);
    }

    public static void i(String str, String str2) {
        j(str, str2, null);
    }
}
