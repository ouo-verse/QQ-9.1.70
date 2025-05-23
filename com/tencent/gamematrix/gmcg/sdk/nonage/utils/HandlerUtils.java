package com.tencent.gamematrix.gmcg.sdk.nonage.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HandlerUtils {
    private static Handler mMainHandler = new Handler(Looper.getMainLooper());

    public static void addIdleHandler(MessageQueue.IdleHandler idleHandler) {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(idleHandler);
    }

    private static Handler handler() {
        return mMainHandler;
    }

    public static void post(Runnable runnable) {
        mMainHandler.post(runnable);
    }

    public static void postDelay(Runnable runnable, long j3) {
        mMainHandler.postDelayed(runnable, j3);
    }

    public static void removeCallbacks(Runnable runnable) {
        mMainHandler.removeCallbacks(runnable);
    }

    public static void removeIdleHandler(MessageQueue.IdleHandler idleHandler) {
        Looper.getMainLooper();
        Looper.myQueue().removeIdleHandler(idleHandler);
    }
}
