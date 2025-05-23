package com.tribe.async.async;

import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.async.MonitorThreadPoolExecutor;
import com.tribe.async.dispatch.AbsEventBatcher;
import com.tribe.async.log.SLog;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LightWeightExecutor extends AbsEventBatcher<Runnable> implements Executor {
    private static final int QUEUE_SIZE_LIMIT = 200;
    private static final long RUN_TIME_LIMIT = 120000;
    private static final String TAG = "async.boss.LightWeightExecutor";
    private final byte[] holderLock;
    private MonitorThreadPoolExecutor.ThreadPoolMonitorListener mMonitorListener;
    private int mQueueSizeLimit;
    private long mRunTimeLimit;
    private RunnableHolder mRunnableHolder;

    public LightWeightExecutor(Looper looper, int i3) {
        super(looper, new RunnableQueue(), i3);
        this.mRunTimeLimit = 120000L;
        this.mQueueSizeLimit = 200;
        this.holderLock = new byte[0];
    }

    private void checkRunning() {
        ArrayList arrayList;
        Runnable runnable;
        Runnable runnable2;
        if (this.mMonitorListener == null) {
            return;
        }
        int enqueueSize = getEnqueueSize();
        if (enqueueSize > this.mQueueSizeLimit) {
            this.mMonitorListener.onQueueExceedLimit(TAG, enqueueSize);
            SLog.d(TAG, "cur state = " + getCurState());
            synchronized (this.holderLock) {
                RunnableHolder runnableHolder = this.mRunnableHolder;
                if (runnableHolder != null && (runnable2 = runnableHolder.get()) != null) {
                    SLog.d(TAG, "cur runnable = " + runnable2);
                }
            }
            dumpAllEvent();
        }
        synchronized (this.holderLock) {
            RunnableHolder runnableHolder2 = this.mRunnableHolder;
            if (runnableHolder2 != null && (runnable = runnableHolder2.get()) != null && this.mRunnableHolder.getItemRunTimes() > this.mRunTimeLimit) {
                arrayList = new ArrayList();
                arrayList.add(runnable);
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            this.mMonitorListener.onWorkerExceedTime(TAG, arrayList, 1);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        enqueue(runnable);
        checkRunning();
    }

    public void setMonitorListener(MonitorThreadPoolExecutor.ThreadPoolMonitorListener threadPoolMonitorListener) {
        this.mMonitorListener = threadPoolMonitorListener;
    }

    public void setQueueSizeLimit(int i3) {
        this.mQueueSizeLimit = i3;
    }

    public void setRunTimeLimit(long j3) {
        this.mRunTimeLimit = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class RunnableHolder extends WeakReference<Runnable> {
        private long mRunStartTime;

        public RunnableHolder(Runnable runnable) {
            super(runnable);
            this.mRunStartTime = SystemClock.elapsedRealtime();
        }

        public long getItemRunTimes() {
            return SystemClock.elapsedRealtime() - this.mRunStartTime;
        }

        public RunnableHolder(Runnable runnable, ReferenceQueue<? super Runnable> referenceQueue) {
            super(runnable, referenceQueue);
            this.mRunStartTime = SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.dispatch.AbsEventBatcher
    public void handleItem(Runnable runnable) {
        synchronized (this.holderLock) {
            this.mRunnableHolder = new RunnableHolder(runnable);
        }
        runnable.run();
        synchronized (this.holderLock) {
            this.mRunnableHolder = null;
        }
    }
}
