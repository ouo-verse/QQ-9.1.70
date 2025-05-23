package com.qq.e.comm.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MainHandler {
    private static Handler mainHandler;

    private static Handler getMain() {
        if (mainHandler == null) {
            mainHandler = new Handler(Looper.getMainLooper());
        }
        return mainHandler;
    }

    public static boolean isMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static final boolean post(Runnable runnable) {
        return getMain().post(runnable);
    }

    public static final boolean postDelayed(Runnable runnable, long j3) {
        return getMain().postDelayed(runnable, j3);
    }

    public static final void removeCallbacks(Runnable runnable) {
        getMain().removeCallbacks(runnable);
    }

    public static final void removeCallbacksAndMessages(Object obj) {
        getMain().removeCallbacksAndMessages(obj);
    }

    public static void runOnMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (isMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }
}
