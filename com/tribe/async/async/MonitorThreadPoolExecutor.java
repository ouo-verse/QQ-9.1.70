package com.tribe.async.async;

import android.os.SystemClock;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tribe.async.log.SLog;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes27.dex */
public class MonitorThreadPoolExecutor extends BaseThreadPoolExecutor {
    private static final int QUEUE_SIZE_LIMIT = 200;
    private static final long RUN_TIME_LIMIT = 120000;
    private static final String TAG = "async.boss.MonitorThreadPoolExecutor";
    private int mCore;
    private ThreadPoolMonitorListener mMonitorListener;
    private String mName;
    private int mQueueSizeLimit;
    private long mRunTimeLimit;
    private BlockingQueue<Runnable> mWorkerQueue;
    private final List<WorkerHolder> mWorkingRunnables;

    /* loaded from: classes27.dex */
    public interface ThreadPoolMonitorListener {
        void onQueueExceedLimit(String str, int i3);

        void onWorkerExceedTime(String str, List<Runnable> list, int i3);
    }

    public MonitorThreadPoolExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i3, i16, j3, timeUnit, blockingQueue);
        this.mWorkingRunnables = new LinkedList();
        this.mName = TAG;
        this.mRunTimeLimit = 120000L;
        this.mQueueSizeLimit = 200;
        this.mWorkerQueue = blockingQueue;
        this.mCore = i3;
    }

    private void checkRunning() {
        ArrayList arrayList;
        if (this.mMonitorListener == null) {
            return;
        }
        synchronized (this.mWorkingRunnables) {
            arrayList = null;
            if (this.mWorkingRunnables.size() > 0) {
                for (WorkerHolder workerHolder : this.mWorkingRunnables) {
                    if (workerHolder.getExecuteTime() > this.mRunTimeLimit) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(this.mWorkingRunnables.size());
                        }
                        Runnable runnable = workerHolder.get();
                        if (runnable != null) {
                            arrayList.add(runnable);
                        }
                    }
                }
            }
        }
        int size = this.mWorkerQueue.size();
        if (arrayList != null && arrayList.size() > 0) {
            this.mMonitorListener.onWorkerExceedTime(this.mName, arrayList, size);
        }
        if (size > this.mQueueSizeLimit) {
            this.mMonitorListener.onQueueExceedLimit(this.mName, size);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th5) {
        synchronized (this.mWorkingRunnables) {
            this.mWorkingRunnables.remove(new WorkerHolder(runnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        synchronized (this.mWorkingRunnables) {
            this.mWorkingRunnables.add(new WorkerHolder(runnable));
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(runnable);
        checkRunning();
    }

    public void setCore(int i3) {
        this.mCore = i3;
    }

    public void setMonitorListener(ThreadPoolMonitorListener threadPoolMonitorListener) {
        this.mMonitorListener = threadPoolMonitorListener;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setQueueSizeLimit(int i3) {
        this.mQueueSizeLimit = i3;
    }

    public void setRunTimeLimit(long j3) {
        this.mRunTimeLimit = j3;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        SLog.e(TAG, this.mName + " is terminated!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class WorkerHolder extends WeakReference<Runnable> {
        private long mExecuteStartTime;

        public WorkerHolder(Runnable runnable) {
            super(runnable);
            this.mExecuteStartTime = SystemClock.elapsedRealtime();
        }

        public static boolean objEquals(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }

        public boolean equals(Object obj) {
            if (obj instanceof WorkerHolder) {
                return objEquals(((WorkerHolder) obj).get(), get());
            }
            if (obj instanceof Runnable) {
                return objEquals(obj, get());
            }
            return false;
        }

        public long getExecuteTime() {
            return SystemClock.elapsedRealtime() - this.mExecuteStartTime;
        }

        public WorkerHolder(Runnable runnable, ReferenceQueue<? super Runnable> referenceQueue) {
            super(runnable, referenceQueue);
            this.mExecuteStartTime = SystemClock.elapsedRealtime();
        }
    }

    public MonitorThreadPoolExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i3, i16, j3, timeUnit, blockingQueue, threadFactory);
        this.mWorkingRunnables = new LinkedList();
        this.mName = TAG;
        this.mRunTimeLimit = 120000L;
        this.mQueueSizeLimit = 200;
        this.mWorkerQueue = blockingQueue;
        this.mCore = i3;
    }

    public MonitorThreadPoolExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i3, i16, j3, timeUnit, blockingQueue, rejectedExecutionHandler);
        this.mWorkingRunnables = new LinkedList();
        this.mName = TAG;
        this.mRunTimeLimit = 120000L;
        this.mQueueSizeLimit = 200;
        this.mWorkerQueue = blockingQueue;
        this.mCore = i3;
    }

    public MonitorThreadPoolExecutor(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i3, i16, j3, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.mWorkingRunnables = new LinkedList();
        this.mName = TAG;
        this.mRunTimeLimit = 120000L;
        this.mQueueSizeLimit = 200;
        this.mWorkerQueue = blockingQueue;
        this.mCore = i3;
    }
}
