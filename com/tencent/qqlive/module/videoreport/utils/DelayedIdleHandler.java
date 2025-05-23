package com.tencent.qqlive.module.videoreport.utils;

import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.MainThread;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DelayedIdleHandler {
    private static final String TAG = "DelayedIdleHandler";
    private MessageQueue.IdleHandler mIdleHandler = new IdleHandler();
    private Map<DelayedRunnable, Runnable> mRunnableMap = new LinkedHashMap();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface DelayInvokeFrom {
        public static final int INVOKE_FROM_MAIN_IDLE = 0;
        public static final int INVOKE_FROM_MAIN_POST = 1;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class DelayedRunnable implements Runnable {
        @Override // java.lang.Runnable
        @Deprecated
        public void run() {
            run(1);
        }

        protected abstract void run(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class IdleHandler implements MessageQueue.IdleHandler {
        IdleHandler() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(DelayedIdleHandler.TAG, "onIdle");
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(DelayedIdleHandler.this.mRunnableMap.entrySet());
            DelayedIdleHandler.this.mRunnableMap.clear();
            for (Map.Entry entry : arrayList) {
                DelayedRunnable delayedRunnable = (DelayedRunnable) entry.getKey();
                com.tencent.qqlive.module.videoreport.task.ThreadUtils.removeOnUiThread((Runnable) entry.getValue());
                if (VideoReportInner.getInstance().isDebugMode()) {
                    Log.d(DelayedIdleHandler.TAG, "run by idle, task = " + delayedRunnable);
                }
                delayedRunnable.run(0);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class RunnableWrapper implements Runnable {
        private DelayedRunnable mTask;

        public RunnableWrapper(DelayedRunnable delayedRunnable) {
            this.mTask = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.d(DelayedIdleHandler.TAG, "run by handler, task = " + this.mTask);
            }
            this.mTask.run(1);
            DelayedIdleHandler.this.removeTaskFromMap(this.mTask);
            DelayedIdleHandler.this.removeIdleHandlerIfNeed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeIdleHandlerIfNeed() {
        if (this.mRunnableMap.isEmpty()) {
            Looper.myQueue().removeIdleHandler(this.mIdleHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable removeTaskFromMap(Runnable runnable) {
        return this.mRunnableMap.remove(runnable);
    }

    @MainThread
    public void post(DelayedRunnable delayedRunnable, long j3) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "receive task to delay:" + j3);
        }
        Runnable runnable = this.mRunnableMap.get(delayedRunnable);
        if (runnable != null) {
            com.tencent.qqlive.module.videoreport.task.ThreadUtils.removeOnUiThread(runnable);
            com.tencent.qqlive.module.videoreport.task.ThreadUtils.runOnUiThreadDelay(runnable, j3);
            return;
        }
        RunnableWrapper runnableWrapper = new RunnableWrapper(delayedRunnable);
        this.mRunnableMap.put(delayedRunnable, runnableWrapper);
        com.tencent.qqlive.module.videoreport.task.ThreadUtils.runOnUiThreadDelay(runnableWrapper, j3);
        Looper.myQueue().removeIdleHandler(this.mIdleHandler);
        Looper.myQueue().addIdleHandler(this.mIdleHandler);
    }

    @MainThread
    public void remove(DelayedRunnable delayedRunnable) {
        Runnable removeTaskFromMap = removeTaskFromMap(delayedRunnable);
        if (removeTaskFromMap != null) {
            com.tencent.qqlive.module.videoreport.task.ThreadUtils.removeOnUiThread(removeTaskFromMap);
        }
        removeIdleHandlerIfNeed();
    }
}
