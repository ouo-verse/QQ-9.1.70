package com.tencent.superplayer.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import com.tencent.thumbplayer.core.utils.TPThreadPool;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ThreadUtil {
    private static final int CORE_POOL_SIZE = 2;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE;
    private static volatile Handler sMainThreadHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static volatile HandlerThread sSubThread;
    private static volatile Handler sSubThreadHandler;
    private static final ThreadFactory sThreadFactory;
    private static volatile Executor sThreadPool;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class DebugHandlerThread extends BaseHandlerThread {
        @Override // android.os.HandlerThread
        public Looper getLooper() {
            LogUtil.e("DebugHandlerThread", "getLooper start, alive=" + isAlive());
            Looper looper = super.getLooper();
            LogUtil.e("DebugHandlerThread", "getLooper finished looper=" + looper + ", alive=" + isAlive());
            return looper;
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            LogUtil.e("DebugHandlerThread", "onLooperPrepared");
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.e("DebugHandlerThread", "start run");
            super.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class SPSafeHandlerThreadWrapper extends BaseHandlerThread {

        /* renamed from: m, reason: collision with root package name */
        private HandlerThread f374000m;

        public SPSafeHandlerThreadWrapper(HandlerThread handlerThread) {
            super("SPSafeHandlerThreadWrapper");
            this.f374000m = handlerThread;
        }

        @Override // android.os.HandlerThread
        public Looper getLooper() {
            return this.f374000m.getLooper();
        }

        @Override // android.os.HandlerThread
        public boolean quit() {
            LogUtil.e("SPSafeHandlerThreadWrapper", "unsupport operation quit");
            return true;
        }

        @Override // android.os.HandlerThread
        public boolean quitSafely() {
            LogUtil.e("SPSafeHandlerThreadWrapper", "unsupport operation quitSafely");
            return true;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.e("SPSafeHandlerThreadWrapper", "unsupport operation run");
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, java.lang.Thread
        public synchronized void start() {
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        MAXIMUM_POOL_SIZE = (availableProcessors * 2) + 1;
        sThreadFactory = new ThreadFactory() { // from class: com.tencent.superplayer.utils.ThreadUtil.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new BaseThread(runnable, "SuperPlayerThreadPool #" + this.mCount.getAndIncrement());
            }
        };
        sPoolWorkQueue = new LinkedBlockingQueue(128);
    }

    public static Handler getSubThreadHandler() {
        if (sSubThreadHandler == null) {
            synchronized (ThreadUtil.class) {
                if (sSubThreadHandler == null) {
                    sSubThreadHandler = new Handler(getSubThreadLooper());
                }
            }
        }
        return sSubThreadHandler;
    }

    public static Looper getSubThreadLooper() {
        Looper looper;
        synchronized (ThreadUtil.class) {
            initSubThreadHandler();
            looper = sSubThread.getLooper();
        }
        return looper;
    }

    private static void initMainThreadHandler() {
        if (sMainThreadHandler == null) {
            synchronized (ThreadUtil.class) {
                if (sMainThreadHandler == null) {
                    Looper mainLooper = Looper.getMainLooper();
                    if (mainLooper != null) {
                        sMainThreadHandler = new Handler(mainLooper);
                    } else {
                        sMainThreadHandler = null;
                        throw new IllegalStateException("cannot get UI Thread looper!");
                    }
                }
            }
        }
    }

    private static void initSubThreadHandler() {
        if (sSubThread == null) {
            synchronized (ThreadUtil.class) {
                if (sSubThread == null) {
                    sSubThread = new BaseHandlerThread("SuperPlayerSubThread");
                    sSubThread.start();
                }
            }
        }
    }

    public static void runOnThreadPool(@NonNull Runnable runnable) {
        if (sThreadPool == null) {
            synchronized (ThreadUtil.class) {
                if (sThreadPool == null) {
                    BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(2, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
                    baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
                    sThreadPool = baseThreadPoolExecutor;
                }
            }
        }
        sThreadPool.execute(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        initMainThreadHandler();
        if (sMainThreadHandler != null) {
            sMainThreadHandler.postDelayed(runnable, j3);
        }
    }

    public static void setCustomThread(HandlerThread handlerThread, Executor executor) {
        sThreadPool = executor;
        if (handlerThread != null) {
            sSubThread = new SPSafeHandlerThreadWrapper(handlerThread);
        }
        TPThreadPool.setCustomThread(handlerThread, executor);
        TVKThreadUtil.setCustomThread(handlerThread, executor);
        if (CommonUtil.n()) {
            TVKThreadPool.setCustomThread(handlerThread, executor);
        }
    }
}
