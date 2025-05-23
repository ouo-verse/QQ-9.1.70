package com.vivo.push.util;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final t f387930a = new s();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f387931b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f387932c;

    static {
        c();
    }

    public static boolean a() {
        return f387931b;
    }

    public static boolean b() {
        return f387931b && f387932c;
    }

    private static void c() {
        f387931b = ag.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int d(String str, String str2) {
        return f387930a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f387930a.e(str, str2);
    }

    public static void a(boolean z16) {
        c();
        f387932c = z16;
    }

    public static int c(String str, String str2) {
        return f387930a.c(str, str2);
    }

    public static int b(String str, String str2) {
        return f387930a.b(str, str2);
    }

    public static void c(Context context, String str) {
        f387930a.c(context, str);
    }

    public static int a(String str, String str2) {
        return f387930a.a(str, str2);
    }

    public static int b(String str, String str2, Throwable th5) {
        return f387930a.b(str, str2, th5);
    }

    public static int a(String str, Throwable th5) {
        return f387930a.a(str, th5);
    }

    public static void b(Context context, String str) {
        f387930a.b(context, str);
    }

    public static int a(String str, String str2, Throwable th5) {
        return f387930a.a(str, str2, th5);
    }

    public static void b(String str) {
        if (f387931b) {
            f387930a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static String a(Throwable th5) {
        return f387930a.a(th5);
    }

    public static void a(Context context, String str) {
        f387930a.a(context, str);
    }

    public static void a(String str) {
        if (f387931b) {
            f387930a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static void a(int i3, String str) {
        a("RunTimeException", "code: " + i3 + ", exceptionMsg: " + str);
    }
}
