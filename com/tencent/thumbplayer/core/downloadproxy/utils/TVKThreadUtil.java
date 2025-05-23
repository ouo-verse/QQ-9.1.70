package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TVKThreadUtil {
    private static volatile Handler mMainThreadHandler;
    private static volatile ScheduledExecutorService mScheduler;
    private static volatile Handler sCustomThreadHandler;

    public static ScheduledExecutorService getScheduledExecutorServiceInstance() {
        if (mScheduler == null) {
            synchronized (TVKThreadUtil.class) {
                if (mScheduler == null) {
                    mScheduler = ProxyExecutors.newScheduledThreadPool(4);
                }
            }
        }
        return mScheduler;
    }

    private static void initMainThreadHandler() {
        if (mMainThreadHandler != null) {
            return;
        }
        synchronized (TVKThreadUtil.class) {
            if (mMainThreadHandler != null) {
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                mMainThreadHandler = new Handler(mainLooper);
            } else {
                mMainThreadHandler = null;
            }
        }
    }

    private static boolean isCustomThreadIsAlive() {
        if (sCustomThreadHandler != null && sCustomThreadHandler.getLooper() != null && sCustomThreadHandler.getLooper().getThread().isAlive()) {
            return true;
        }
        return false;
    }

    public static void postRunnableInCustomThread(Runnable runnable) {
        if (sCustomThreadHandler != null && isCustomThreadIsAlive()) {
            sCustomThreadHandler.post(runnable);
        } else {
            postRunnableOnMainThread(runnable);
        }
    }

    public static void postRunnableOnMainThread(Runnable runnable) {
        initMainThreadHandler();
        if (mMainThreadHandler != null) {
            mMainThreadHandler.post(runnable);
        }
    }

    public static void setCustomThread(HandlerThread handlerThread, Executor executor) {
        if (handlerThread == null || sCustomThreadHandler != null) {
            return;
        }
        synchronized (TVKThreadUtil.class) {
            if (sCustomThreadHandler != null) {
                return;
            }
            sCustomThreadHandler = new Handler(handlerThread.getLooper());
        }
    }
}
