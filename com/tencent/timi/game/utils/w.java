package com.tencent.timi.game.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes26.dex */
public class w {

    /* renamed from: b, reason: collision with root package name */
    private static final Handler f380312b = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f380311a = new Handler(ThreadManagerV2.getSubThreadLooper());

    public static void a(Runnable runnable) {
        b(runnable, 16);
    }

    public static void b(Runnable runnable, int i3) {
        ThreadManagerV2.excute(runnable, i3, null, true);
    }

    public static void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f380312b.post(runnable);
    }

    public static void d(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        f380312b.postDelayed(runnable, j3);
    }

    public static void e(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f380312b.removeCallbacks(runnable);
    }
}
