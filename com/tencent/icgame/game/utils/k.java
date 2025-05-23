package com.tencent.icgame.game.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f116104a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f116104a.post(runnable);
    }

    public static void c(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        f116104a.postDelayed(runnable, j3);
    }

    public static void d(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f116104a.removeCallbacks(runnable);
    }
}
