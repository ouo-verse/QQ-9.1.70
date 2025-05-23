package com.tencent.luggage.wxa.tn;

import android.os.Looper;
import android.os.Process;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static b0 f141554a;

    public static void a(int i3) {
        try {
            Process.setThreadPriority(i3);
            w.d("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i3));
        } catch (Exception e16) {
            w.d("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i3), e16.getMessage());
            w.a("MicroMsg.MMHandlerThread", e16, "", new Object[0]);
        }
    }

    public static boolean b() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a().b(runnable);
    }

    public static b0 a() {
        if (f141554a == null) {
            f141554a = new b0(Looper.getMainLooper());
        }
        return f141554a;
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a().a(runnable);
    }

    public static void a(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        a().a(runnable, j3);
    }
}
