package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bc {
    public static Map<String, String> a(Context context, hb hbVar) {
        jz4.c.m("pepa listener or container is null");
        return null;
    }

    public static void b(Context context, hb hbVar) {
        jz4.c.m("handle msg wrong");
    }

    public static void c(Context context, hb hbVar, he heVar) {
        jz4.c.B("The Listener of EventProcessor must be set. Please check extension plugin initialization.");
    }

    public static void d(hb hbVar) {
        jz4.c.m("pepa clearMessage is null");
    }

    public static void e(String str) {
        jz4.c.m("pepa clearMessage is null");
    }

    public static boolean f(Context context, hb hbVar, boolean z16) {
        jz4.c.m("pepa judement listener or container is null");
        return false;
    }

    public static boolean g(hb hbVar) {
        jz4.c.m("pepa handleReceiveMessage is null");
        return false;
    }
}
