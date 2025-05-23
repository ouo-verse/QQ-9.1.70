package com.tencent.ark;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkDispatchTask {
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    protected static final String LOG_TAG = "ArkApp.DispatchTask";
    private static volatile ArkDispatchTask instance;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final Handler mSubHandler;
    private HandlerThread mSubThread;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class BlockingRunnable implements Runnable {
        private volatile boolean mDone = false;
        private final Runnable mTask;

        public BlockingRunnable(Runnable runnable) {
            this.mTask = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mTask.run();
                synchronized (this) {
                    this.mDone = true;
                    notifyAll();
                }
            } catch (Throwable th5) {
                synchronized (this) {
                    this.mDone = true;
                    notifyAll();
                    throw th5;
                }
            }
        }

        public boolean send(Handler handler) {
            synchronized (this) {
                if (!ArkDispatchTask.postImpl(handler, this, 0L)) {
                    return false;
                }
                while (!this.mDone) {
                    try {
                        LockMethodProxy.wait(this);
                    } catch (InterruptedException e16) {
                        Logger.logD(ArkDispatchTask.LOG_TAG, "DispatchTask.exception: " + e16.getLocalizedMessage());
                    }
                }
                return true;
            }
        }
    }

    ArkDispatchTask() {
        HandlerThread createHandlerThread = ENV.createHandlerThread("ArkAppThread");
        this.mSubThread = createHandlerThread;
        if (createHandlerThread == null) {
            this.mSubThread = new BaseHandlerThread("ArkAppThread", -1);
            Logger.logD(LOG_TAG, "ENV not init thread use Ark's HandlerThread");
        }
        this.mSubThread.start();
        this.mSubHandler = new Handler(this.mSubThread.getLooper());
    }

    public static ArkDispatchTask getInstance() {
        if (instance == null) {
            synchronized (ArkDispatchTask.class) {
                if (instance == null) {
                    instance = new ArkDispatchTask();
                }
            }
        }
        return instance;
    }

    static final boolean postImpl(Handler handler, Runnable runnable, long j3) {
        Message obtain = Message.obtain(handler, runnable);
        ThreadMessageHandler.IMPL.setAsynchronous(obtain, true);
        return handler.sendMessageDelayed(obtain, j3);
    }

    public boolean CheckQueueValid(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.logD(LOG_TAG, "DispatchTask.CheckQueueValid false, queuekey is empty ");
            return false;
        }
        return true;
    }

    public boolean isMainThread() {
        if (this.mMainHandler.getLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public boolean isTaskThread() {
        if (this.mMainHandler.getLooper() != Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public void post(String str, Runnable runnable) {
        if (runnable != null && CheckQueueValid(str)) {
            try {
                ArkDispatchQueue.asyncRun(str, runnable);
            } catch (UnsatisfiedLinkError e16) {
                Logger.logE(LOG_TAG, "DispatchTask.post.exception: " + e16.getLocalizedMessage());
            }
        }
    }

    public void postDelayed(String str, Runnable runnable, long j3) {
        if (runnable != null && CheckQueueValid(str)) {
            try {
                ArkDispatchQueue.asyncRun(str, runnable, j3);
            } catch (UnsatisfiedLinkError e16) {
                Logger.logE(LOG_TAG, "DispatchTask.postDelayed.exception: " + e16.getLocalizedMessage());
            }
        }
    }

    public void postToArkThread(Runnable runnable) {
        Handler handler;
        if (runnable != null && (handler = this.mSubHandler) != null) {
            postImpl(handler, runnable, 0L);
        }
    }

    public void postToArkThreadDelay(Runnable runnable, long j3) {
        Handler handler;
        if (runnable != null && (handler = this.mSubHandler) != null) {
            postImpl(handler, runnable, j3);
        }
    }

    public void postToMainThread(Runnable runnable) {
        Handler handler;
        if (runnable != null && (handler = this.mMainHandler) != null) {
            postImpl(handler, runnable, 0L);
        }
    }

    public void postToMainThreadDelayed(Runnable runnable, long j3) {
        Handler handler;
        if (runnable != null && (handler = this.mMainHandler) != null) {
            handler.postDelayed(runnable, j3);
        }
    }

    public void removeTaskInMainThread(Runnable runnable) {
        Handler handler;
        if (runnable != null && (handler = this.mMainHandler) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void send(String str, Runnable runnable) {
        if (runnable != null && CheckQueueValid(str)) {
            try {
                ArkDispatchQueue.syncRun(str, runnable);
            } catch (UnsatisfiedLinkError e16) {
                Logger.logE(LOG_TAG, "DispatchTask.send.exception: " + e16.getLocalizedMessage());
            }
        }
    }
}
