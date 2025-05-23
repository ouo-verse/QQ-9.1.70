package com.tencent.gamematrix.gmcg.base.task;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGTaskHandler {
    public static final int DETECTION_NET_DELAY_MESSAGE = 0;
    private static final String TAG = "CGTaskHandler";
    private static final CGSingletonHelper<CGTaskHandler> sInstance = new CGSingletonHelper<CGTaskHandler>() { // from class: com.tencent.gamematrix.gmcg.base.task.CGTaskHandler.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public CGTaskHandler create() {
            return new CGTaskHandler();
        }
    };
    private Object lock;
    private Handler mWorkHandler;
    private HandlerThread mWorkThread;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class TaskWorkHandler extends Handler {
        public TaskWorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                CGLog.w("TaskWorkHandler message is null!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static abstract class WorkTask implements Runnable {
        private volatile boolean isCancelled;

        public void cancel() {
            this.isCancelled = true;
        }

        public abstract void doRun();

        @Override // java.lang.Runnable
        public void run() {
            if (!this.isCancelled) {
                doRun();
            }
        }
    }

    public static CGTaskHandler get() {
        return sInstance.get();
    }

    private void startWorkThread() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("com.tencent.gamematrix.gmbase.task.workThread", 10);
        this.mWorkThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mWorkHandler = new TaskWorkHandler(this.mWorkThread.getLooper());
    }

    public void runMessage(Message message) {
        Handler handler;
        if (message != null && (handler = this.mWorkHandler) != null) {
            handler.sendMessage(message);
        } else {
            CGLog.w("message or handler is null when runMessage!");
        }
    }

    public WorkTask schedule(final Runnable runnable) {
        WorkTask workTask = new WorkTask() { // from class: com.tencent.gamematrix.gmcg.base.task.CGTaskHandler.2
            @Override // com.tencent.gamematrix.gmcg.base.task.CGTaskHandler.WorkTask
            public void doRun() {
                runnable.run();
            }
        };
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.post(workTask);
        }
        return workTask;
    }

    @TargetApi(18)
    public void stopWorkThread() {
        HandlerThread handlerThread = this.mWorkThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mWorkThread = null;
        }
        if (this.mWorkHandler != null) {
            this.mWorkHandler = null;
        }
    }

    CGTaskHandler() {
        this.lock = new Object();
        startWorkThread();
    }
}
