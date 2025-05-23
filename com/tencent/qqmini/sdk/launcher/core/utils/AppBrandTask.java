package com.tencent.qqmini.sdk.launcher.core.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandTask {
    private static Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    public static void runTaskOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            runnable.run();
        } else {
            mMainThreadHandler.post(runnable);
        }
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
}
