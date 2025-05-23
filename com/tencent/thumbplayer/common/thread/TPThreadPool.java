package com.tencent.thumbplayer.common.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPThreadPool {
    private static final int CORE_POOL_SIZE = 4;
    private static final String DEFAULT_HANDLER_THREAD_NAME = "TPHandlerThread";
    private static final int MAX_POOL_SIZE = 20;
    private static final String SHARED_HANDLER_THREAD_NAME = "TPSHThread";
    private static final TPThreadPool sInstance = new TPThreadPool();
    private static final Handler sMainThreadHandler = new Handler(Looper.getMainLooper());
    private static volatile HandlerThread sSharedHandlerThread = null;
    private static volatile boolean sIsSharedHandlerThreadStarted = false;
    private static volatile ExecutorService sSharedSingleThreadExecutor = null;
    private static volatile ExecutorService sSharedThreadPoolExecutor = null;
    private static volatile ScheduledExecutorService sSharedScheduledExecutor = null;

    /* loaded from: classes26.dex */
    private static class TPThreadPoolExecutor {
        private static final long IDLE_THREAD_KEEP_ALIVE_TIME_SEC = 60;
        private static final int QUEUE_CAPACITY = 20;
        private static final String TAG = "TPThreadPoolExecutor";
        private static final String THREAD_NAME_PREFIX_MULTI = "TPMulti_";
        private static final String THREAD_NAME_PREFIX_SCHEDULED = "TPScheduled_";
        private static final String THREAD_NAME_PREFIX_SINGLE = "TPSingle_";

        TPThreadPoolExecutor() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$newMultipleThreadExecutor$1(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                TPLogUtil.i(TAG, "[rejectedExecution] waiting for available space to enqueue again");
                threadPoolExecutor.getQueue().put(runnable);
                TPLogUtil.i(TAG, "[rejectedExecution] done");
            } catch (InterruptedException e16) {
                TPLogUtil.e(TAG, e16, "[rejectedExecution] InterruptedException encountered:");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Thread lambda$newSingleThreadExecutor$0(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setName("TPSingle_1");
            return baseThread;
        }

        public static ExecutorService newMultipleThreadExecutor(int i3, int i16) {
            return new BaseThreadPoolExecutor(i3, i16, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new ThreadFactory() { // from class: com.tencent.thumbplayer.common.thread.TPThreadPool.TPThreadPoolExecutor.1
                private final AtomicInteger mThreadCounter = new AtomicInteger(0);

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    BaseThread baseThread = new BaseThread(runnable);
                    baseThread.setName(TPThreadPoolExecutor.THREAD_NAME_PREFIX_MULTI + this.mThreadCounter.incrementAndGet());
                    return baseThread;
                }
            }, new RejectedExecutionHandler() { // from class: com.tencent.thumbplayer.common.thread.b
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    TPThreadPool.TPThreadPoolExecutor.lambda$newMultipleThreadExecutor$1(runnable, threadPoolExecutor);
                }
            });
        }

        public static ScheduledExecutorService newScheduledThreadPool(int i3) {
            return ProxyExecutors.newScheduledThreadPool(i3, new ThreadFactory() { // from class: com.tencent.thumbplayer.common.thread.TPThreadPool.TPThreadPoolExecutor.2
                private final AtomicInteger mThreadCounter = new AtomicInteger(0);

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    BaseThread baseThread = new BaseThread(runnable);
                    baseThread.setName(TPThreadPoolExecutor.THREAD_NAME_PREFIX_SCHEDULED + this.mThreadCounter.incrementAndGet());
                    return baseThread;
                }
            });
        }

        public static ExecutorService newSingleThreadExecutor() {
            return ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.thumbplayer.common.thread.a
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread lambda$newSingleThreadExecutor$0;
                    lambda$newSingleThreadExecutor$0 = TPThreadPool.TPThreadPoolExecutor.lambda$newSingleThreadExecutor$0(runnable);
                    return lambda$newSingleThreadExecutor$0;
                }
            });
        }
    }

    TPThreadPool() {
    }

    public static TPThreadPool getInstance() {
        return sInstance;
    }

    public HandlerThread obtainHandleThread(String str) {
        return obtainHandleThread(str, 0);
    }

    public ScheduledExecutorService obtainScheduledExecutorService() {
        if (sSharedScheduledExecutor == null) {
            synchronized (TPThreadPool.class) {
                if (sSharedScheduledExecutor == null) {
                    sSharedScheduledExecutor = TPThreadPoolExecutor.newScheduledThreadPool(4);
                }
            }
        }
        return sSharedScheduledExecutor;
    }

    public HandlerThread obtainSharedHandlerThread() {
        if (!sIsSharedHandlerThreadStarted) {
            synchronized (TPThreadPool.class) {
                if (!sIsSharedHandlerThreadStarted) {
                    sSharedHandlerThread = new BaseHandlerThread(SHARED_HANDLER_THREAD_NAME);
                    sSharedHandlerThread.start();
                    sIsSharedHandlerThreadStarted = true;
                }
            }
        }
        return sSharedHandlerThread;
    }

    public ExecutorService obtainSharedSingleThreadExecutor() {
        if (sSharedSingleThreadExecutor == null) {
            synchronized (TPThreadPool.class) {
                if (sSharedSingleThreadExecutor == null) {
                    sSharedSingleThreadExecutor = TPThreadPoolExecutor.newSingleThreadExecutor();
                }
            }
        }
        return sSharedSingleThreadExecutor;
    }

    public ExecutorService obtainSharedThreadPoolExecutor() {
        if (sSharedThreadPoolExecutor == null) {
            synchronized (TPThreadPool.class) {
                if (sSharedThreadPoolExecutor == null) {
                    sSharedThreadPoolExecutor = TPThreadPoolExecutor.newMultipleThreadExecutor(4, 20);
                }
            }
        }
        return sSharedThreadPoolExecutor;
    }

    public void postDelayedRunnableOnMainThread(Runnable runnable, long j3) {
        sMainThreadHandler.postDelayed(runnable, j3);
    }

    public void postRunnableOnMainThread(Runnable runnable) {
        sMainThreadHandler.post(runnable);
    }

    public void postRunnableOnMainThreadFront(Runnable runnable) {
        sMainThreadHandler.postAtFrontOfQueue(runnable);
    }

    public void recycle(HandlerThread handlerThread, Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (handlerThread != null && !handlerThread.equals(sSharedHandlerThread)) {
            handlerThread.quit();
        }
    }

    public HandlerThread obtainHandleThread(String str, int i3) {
        if (i3 >= 19 || i3 <= -19) {
            i3 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_HANDLER_THREAD_NAME;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, i3);
        baseHandlerThread.start();
        return baseHandlerThread;
    }
}
