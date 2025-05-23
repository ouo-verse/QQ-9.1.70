package com.tencent.qqlive.module.videoreport.task;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ThreadUtils {
    private static final AtomicInteger NUMBER = new AtomicInteger(1);
    private static final Executor EXECUTOR = ProxyExecutors.newFixedThreadPool(2, new ThreadFactory() { // from class: com.tencent.qqlive.module.videoreport.task.ThreadUtils.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new BaseThread(runnable, "vrpool-" + ThreadUtils.NUMBER.getAndIncrement() + "-thread");
        }
    });
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static IThreadTaskInterceptor sTaskInterceptor = null;

    public static void ensureRunOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (isMainThread()) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    public static void execTask(Runnable runnable) {
        if (runnable != null) {
            EXECUTOR.execute(runnable);
        }
    }

    public static Handler getMainHandler() {
        return HANDLER;
    }

    public static void injectTaskInterceptor(IThreadTaskInterceptor iThreadTaskInterceptor) {
        sTaskInterceptor = iThreadTaskInterceptor;
    }

    public static boolean isMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static void removeOnUiThread(Runnable runnable) {
        if (runnable != null) {
            HANDLER.removeCallbacks(runnable);
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null || shouldIntercept(runnable)) {
            return;
        }
        HANDLER.post(runnable);
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j3) {
        if (runnable != null) {
            HANDLER.postDelayed(runnable, j3);
        }
    }

    private static boolean shouldIntercept(Runnable runnable) {
        IThreadTaskInterceptor iThreadTaskInterceptor = sTaskInterceptor;
        if (iThreadTaskInterceptor != null && iThreadTaskInterceptor.shouldInterceptTask(runnable)) {
            return true;
        }
        return false;
    }

    private static boolean tryToRemoveInPendingTask(Runnable runnable) {
        IThreadTaskInterceptor iThreadTaskInterceptor = sTaskInterceptor;
        if (iThreadTaskInterceptor != null && iThreadTaskInterceptor.removePendingTask(runnable)) {
            return true;
        }
        return false;
    }

    public static void execTask(Runnable runnable, boolean z16) {
        if (runnable == null) {
            return;
        }
        if (z16) {
            runnable.run();
        } else {
            execTask(runnable);
        }
    }
}
