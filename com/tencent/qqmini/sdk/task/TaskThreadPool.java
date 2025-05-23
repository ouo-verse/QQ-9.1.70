package com.tencent.qqmini.sdk.task;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes23.dex */
public class TaskThreadPool {
    private static final int PERIOD_TASK_QOS = 100;
    private static final int SIZE_CORE_POOL = 3;
    private static final int SIZE_MAX_POOL = 4;
    private static final int SIZE_WORK_QUEUE = 100;
    private static final int TIME_KEEP_ALIVE = 5000;
    private final Runnable mAccessBufferThread;
    private final RejectedExecutionHandler mHandler;
    private final Queue<Runnable> mTaskQueue = new LinkedList();
    private final ThreadPoolExecutor mThreadPool;

    /* loaded from: classes23.dex */
    static class CustomThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        CustomThreadFactory(String str) {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.group = threadGroup;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(TextUtils.isEmpty(str) ? "threadpool" : str);
            sb5.append("-");
            sb5.append(poolNumber.getAndIncrement());
            sb5.append("-thread-");
            this.namePrefix = sb5.toString();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            if (baseThread.getPriority() != 5) {
                baseThread.setPriority(5);
            }
            return baseThread;
        }
    }

    public TaskThreadPool(String str, int i3, int i16) {
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() { // from class: com.tencent.qqmini.sdk.task.TaskThreadPool.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                TaskThreadPool.this.mTaskQueue.offer(runnable);
            }
        };
        this.mHandler = rejectedExecutionHandler;
        this.mAccessBufferThread = new Runnable() { // from class: com.tencent.qqmini.sdk.task.TaskThreadPool.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TaskThreadPool.this.hasMoreAcquire()) {
                        TaskThreadPool.this.mThreadPool.execute((Runnable) TaskThreadPool.this.mTaskQueue.poll());
                    }
                } catch (Throwable th5) {
                    QMLog.e("ThreadPool", "", th5);
                }
            }
        };
        this.mThreadPool = new BaseThreadPoolExecutor(i3, i16, 5000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new CustomThreadFactory(str), rejectedExecutionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMoreAcquire() {
        return !this.mTaskQueue.isEmpty();
    }

    public void addExecuteTask(Runnable runnable) {
        if (runnable != null) {
            this.mThreadPool.execute(runnable);
        }
    }

    protected boolean isTaskEnd() {
        if (this.mThreadPool.getActiveCount() == 0) {
            return true;
        }
        return false;
    }

    public void perpare() {
        if (this.mThreadPool.isShutdown() && !this.mThreadPool.prestartCoreThread()) {
            this.mThreadPool.prestartAllCoreThreads();
        }
    }

    public void shutdown() {
        this.mTaskQueue.clear();
        this.mThreadPool.shutdown();
    }
}
