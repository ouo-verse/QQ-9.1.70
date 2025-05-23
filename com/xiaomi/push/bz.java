package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bz {

    /* renamed from: a, reason: collision with root package name */
    private static bg f388340a;

    /* renamed from: b, reason: collision with root package name */
    private static bl f388341b;

    public static void a(Context context) {
        c("onSendMsg");
        if (!g(context)) {
            return;
        }
        cw.g(context, System.currentTimeMillis(), d(context));
    }

    public static void b(Context context, ep epVar) {
        if (g(context)) {
            if (f388340a == null) {
                f388340a = new bg(context);
            }
            if (f388341b == null) {
                f388341b = new bl(context);
            }
            bg bgVar = f388340a;
            epVar.k(bgVar, bgVar);
            bl blVar = f388341b;
            epVar.z(blVar, blVar);
            c("startStats");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str) {
        bf.b("Push-PowerStats", str);
    }

    public static boolean d(Context context) {
        return ge.q(context);
    }

    public static void e(Context context) {
        c("onReceiveMsg");
        if (!g(context)) {
            return;
        }
        cw.k(context, System.currentTimeMillis(), d(context));
    }

    public static void f(Context context, ep epVar) {
        bg bgVar = f388340a;
        if (bgVar != null) {
            epVar.j(bgVar);
            f388340a = null;
        }
        bl blVar = f388341b;
        if (blVar != null) {
            epVar.y(blVar);
            f388341b = null;
        }
        c("stopStats");
    }

    private static boolean g(Context context) {
        return bf.c(context);
    }

    public static void h(Context context) {
        c("onPing");
        if (!g(context)) {
            return;
        }
        cw.l(context, System.currentTimeMillis(), d(context));
    }

    public static void i(Context context) {
        c("onPong");
        if (!g(context)) {
            return;
        }
        cw.m(context, System.currentTimeMillis(), d(context));
    }
}
