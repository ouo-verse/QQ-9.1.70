package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandTask {
    private static Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    public static void runTaskOnUiThread(Runnable runnable) {
        mMainThreadHandler.post(runnable);
    }

    public static void runTaskOnUiThreadDelay(Runnable runnable, long j3) {
        mMainThreadHandler.postDelayed(runnable, j3);
    }

    public void clearTask() {
        mMainThreadHandler.removeCallbacksAndMessages(null);
    }

    public void clearTask(Runnable runnable) {
        mMainThreadHandler.removeCallbacks(runnable);
    }

    public static void runTaskOnUiThreadIfNot(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            runTaskOnUiThread(runnable);
        } else {
            runnable.run();
        }
    }
}
