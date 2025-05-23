package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f389450a = false;

    private static void a(Class<?> cls, Context context) {
        if (!f389450a) {
            try {
                f389450a = true;
                cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
            } catch (Throwable th5) {
                jz4.c.m("mdid:load lib error " + th5);
            }
        }
    }

    public static boolean b(Context context) {
        try {
            Class<?> c16 = ii.c(context, "com.bun.miitmdid.core.JLibrary");
            if (c16 != null) {
                a(c16, context);
                return true;
            }
            return false;
        } catch (Throwable th5) {
            jz4.c.m("mdid:check error " + th5);
            return false;
        }
    }
}
