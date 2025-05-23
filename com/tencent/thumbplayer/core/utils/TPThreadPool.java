package com.tencent.thumbplayer.core.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes26.dex */
public class TPThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 20;
    private static final String PRE_THREAD_NAME = "TPCoreThread";
    private static final String SHARE_THREAD_NAME = "TPCoreSHThread";
    private static final String TAG = "TPCore[TPThreadPool]";
    private static volatile Executor sCustomExecutor;
    private static volatile HandlerThread sHandlerThread;
    private static volatile TPThreadPool sInstance;
    private static volatile Handler sMainThreadHandler;
    private static volatile ScheduledExecutorService sScheduler;
    private static volatile ExecutorService sShareSingleExecutor;
    private static int sShareThreadCount;

    TPThreadPool() {
    }

    public static TPThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (TPThreadPool.class) {
                if (sInstance == null) {
                    sInstance = new TPThreadPool();
                }
            }
        }
        return sInstance;
    }

    private static void initHandlerThread() {
        synchronized (TPThreadPool.class) {
            if (sHandlerThread == null) {
                sHandlerThread = new BaseHandlerThread(SHARE_THREAD_NAME);
                sHandlerThread.start();
            } else if (!sHandlerThread.isAlive()) {
                sHandlerThread.start();
            }
            if (sHandlerThread.getLooper() == null) {
                sHandlerThread.quit();
                sHandlerThread = new BaseHandlerThread(SHARE_THREAD_NAME);
                sHandlerThread.start();
            }
        }
    }

    private static void initMainThreadHandler() {
        if (sMainThreadHandler != null) {
            return;
        }
        synchronized (TPThreadPool.class) {
            if (sMainThreadHandler != null) {
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                sMainThreadHandler = new Handler(mainLooper);
            } else {
                sMainThreadHandler = null;
                TPNativeLog.printLog(0, TAG, "cannot get thread looper");
            }
        }
    }

    public static void setCustomThread(HandlerThread handlerThread, Executor executor) {
        sHandlerThread = handlerThread;
        sCustomExecutor = executor;
    }

    public HandlerThread obtainHandleThread(String str) {
        return obtainHandleThread(str, 0);
    }

    public ScheduledExecutorService obtainScheduledExecutorService() {
        if (sScheduler == null) {
            synchronized (TPThreadPool.class) {
                if (sScheduler == null) {
                    sScheduler = ProxyExecutors.newScheduledThreadPool(1);
                }
            }
        }
        return sScheduler;
    }

    public HandlerThread obtainShareThread() {
        HandlerThread handlerThread;
        initHandlerThread();
        synchronized (TPThreadPool.class) {
            sShareThreadCount++;
            TPNativeLog.printLog(2, TAG, "handlerThread obtainShareThread mShareThreadCount:" + sShareThreadCount);
            handlerThread = sHandlerThread;
        }
        return handlerThread;
    }

    public ExecutorService obtainSingleThreadExecutor() {
        if (sShareSingleExecutor == null) {
            synchronized (TPThreadPool.class) {
                if (sShareSingleExecutor == null) {
                    sShareSingleExecutor = ProxyExecutors.newSingleThreadExecutor();
                }
            }
        }
        return sShareSingleExecutor;
    }

    public Executor obtainThreadExecutor() {
        if (sCustomExecutor == null) {
            synchronized (TPThreadPool.class) {
                if (sCustomExecutor == null) {
                    sCustomExecutor = TPThreadPoolExecutor.newCustomThreadExecutor(1, 20);
                }
            }
        }
        return sCustomExecutor;
    }

    public void postDelayRunnableOnMainThread(Runnable runnable, long j3) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postDelayed(runnable, j3);
        }
    }

    public void postRunnableOnMainThread(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.post(runnable);
        }
    }

    public void postRunnableOnMainThreadFront(Runnable runnable) {
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postAtFrontOfQueue(runnable);
        }
    }

    public void recycle(HandlerThread handlerThread, Handler handler) {
        if (handlerThread == null) {
            return;
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (handlerThread.equals(sHandlerThread)) {
            synchronized (TPThreadPool.class) {
                sShareThreadCount--;
                TPNativeLog.printLog(2, TAG, "handlerThread recycle mShareThreadCount:" + sShareThreadCount);
            }
            return;
        }
        handlerThread.quit();
    }

    public HandlerThread obtainHandleThread(String str, int i3) {
        if (i3 >= 19 || i3 <= -19) {
            i3 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = PRE_THREAD_NAME;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, i3);
        baseHandlerThread.start();
        return baseHandlerThread;
    }
}
