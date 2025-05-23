package com.tencent.mtt.hippy.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UIThreadUtils {
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static void assertOnUiThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        } else {
            throw new RuntimeException("must run on ui thread!");
        }
    }

    public static boolean isOnUiThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static void runOnUiThread(Runnable runnable) {
        sMainHandler.post(runnable);
    }
}
