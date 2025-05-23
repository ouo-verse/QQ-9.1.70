package com.tencent.qqlive.tvkplayer.tools.utils;

import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes23.dex */
public class TVKThreadPoolExecutor {
    private static final String TAG = "TVKPlayer[TVKThreadPool]";
    private static final long THREAD_KEEP_ALIVE_TIME = 60;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class BackupQueueRecheckPolicy implements RejectedExecutionHandler {
        private static final String HIGH_PRIORITY_PREFIX = "HighPriorityRejectHandler";
        private static final int HIGH_PRIORITY_TASK_RECHECK_DELAY_MS = 100;
        private static final String NORMAL_PRIORITY_PREFIX = "NormalPriorityRejectHandler";
        private static final int NORMAL_PRIORITY_TASK_RECHECK_DELAY_MS = 500;
        private final Queue<Runnable> mBackupQueue = new ConcurrentLinkedQueue();
        private final boolean mIsHighPriorityRejectPolicy;
        private final boolean mIsThrowExceptionWhenReject;
        private final String mRejectHandlerName;
        private final Timer mTimer;

        public BackupQueueRecheckPolicy(boolean z16) {
            this.mIsHighPriorityRejectPolicy = z16;
            if (z16) {
                this.mRejectHandlerName = HIGH_PRIORITY_PREFIX;
            } else {
                this.mRejectHandlerName = NORMAL_PRIORITY_PREFIX;
            }
            this.mTimer = new BaseTimer(this.mRejectHandlerName, true);
            this.mIsThrowExceptionWhenReject = TVKMediaPlayerConfig.PlayerConfig.throw_exception_when_threadpool_reject_execution;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            int i3;
            if (!this.mIsThrowExceptionWhenReject) {
                this.mBackupQueue.add(runnable);
                TVKLogUtil.e(TVKThreadPoolExecutor.TAG, this.mRejectHandlerName + ", rejectedExecution, put task into backup queue, backupQueueSize=" + this.mBackupQueue.size());
                if (this.mIsHighPriorityRejectPolicy) {
                    i3 = 100;
                } else {
                    i3 = 500;
                }
                this.mTimer.schedule(new BackupQueueRecheckTimerTask(this.mTimer, this.mBackupQueue, threadPoolExecutor, this.mRejectHandlerName, i3), i3);
                return;
            }
            throw new RuntimeException(this.mRejectHandlerName + " rejectedExecution, should not happen");
        }
    }

    /* loaded from: classes23.dex */
    private static class BackupQueueRecheckTimerTask extends TimerTask {
        private final Queue<Runnable> mBackupQueue;
        private final ThreadPoolExecutor mExecutor;
        private final int mRecheckDelayMs;
        private final String mRejectHandlerName;
        private final Timer mTimer;

        public BackupQueueRecheckTimerTask(Timer timer, Queue<Runnable> queue, ThreadPoolExecutor threadPoolExecutor, String str, int i3) {
            this.mTimer = timer;
            this.mBackupQueue = queue;
            this.mExecutor = threadPoolExecutor;
            this.mRejectHandlerName = str;
            this.mRecheckDelayMs = i3;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int remainingCapacity = this.mExecutor.getQueue().remainingCapacity();
            int min = Math.min(remainingCapacity, this.mBackupQueue.size());
            TVKLogUtil.i(TVKThreadPoolExecutor.TAG, this.mRejectHandlerName + ".executor.workQueue.remainingCapacity=" + remainingCapacity + ", mBackupQueue.size()=" + this.mBackupQueue.size());
            for (int i3 = 0; i3 < min; i3++) {
                Runnable poll = this.mBackupQueue.poll();
                if (poll != null) {
                    TVKLogUtil.i(TVKThreadPoolExecutor.TAG, this.mRejectHandlerName + " poll a task from backup queue, submit to executor, remainingCapacity=" + remainingCapacity + ", backupQueueSize=" + this.mBackupQueue.size());
                    this.mExecutor.submit(poll);
                }
            }
            if (this.mBackupQueue.size() > 0) {
                TVKLogUtil.i(TVKThreadPoolExecutor.TAG, this.mRejectHandlerName + " remain some task in backup queue, size=" + this.mBackupQueue.size() + ", schedule a sec delay TimerTask");
                Timer timer = this.mTimer;
                timer.schedule(new BackupQueueRecheckTimerTask(timer, this.mBackupQueue, this.mExecutor, this.mRejectHandlerName, this.mRecheckDelayMs), (long) this.mRecheckDelayMs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class HighPriorityThreadFactory implements ThreadFactory {
        private static final String HIGH_PRIORITY_THREAD_NAME_PREFIX = "TVKVip#";
        private final AtomicInteger mThreadCount;

        HighPriorityThreadFactory() {
            this.mThreadCount = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setPriority(10);
            String str = HIGH_PRIORITY_THREAD_NAME_PREFIX + this.mThreadCount.incrementAndGet();
            baseThread.setName(str);
            TVKLogUtil.i(TVKThreadPoolExecutor.TAG, "generate a new thread, name=" + str);
            return baseThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class NormalPriorityThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME_PREFIX = "TVKNormal#";
        private final AtomicInteger mThreadCount;

        NormalPriorityThreadFactory() {
            this.mThreadCount = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setPriority(5);
            baseThread.setName(THREAD_NAME_PREFIX + this.mThreadCount.incrementAndGet());
            return baseThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class ScheduledThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME_PREFIX = "TVKScheduled#";
        private final AtomicInteger mThreadCount;

        ScheduledThreadFactory() {
            this.mThreadCount = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setPriority(5);
            baseThread.setName(THREAD_NAME_PREFIX + this.mThreadCount.incrementAndGet());
            return baseThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class SingleThreadFactory implements ThreadFactory {
        private static final String SINGLE_PRIORITY_THREAD_NAME = "TVKSingle";

        SingleThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setPriority(5);
            baseThread.setName(SINGLE_PRIORITY_THREAD_NAME);
            return baseThread;
        }
    }

    public static ExecutorService newHighPriorityThreadExecutor(int i3, int i16, int i17) {
        return new BaseThreadPoolExecutor(i3, i16, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(i17), new HighPriorityThreadFactory(), new BackupQueueRecheckPolicy(true));
    }

    public static ExecutorService newNormalPriorityThreadExecutor(int i3, int i16, int i17) {
        return new BaseThreadPoolExecutor(i3, i16, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(i17), new NormalPriorityThreadFactory(), new BackupQueueRecheckPolicy(false));
    }

    public static ScheduledExecutorService newScheduledThreadExecutor(int i3) {
        return ProxyExecutors.newScheduledThreadPool(i3, new ScheduledThreadFactory());
    }

    public static ExecutorService newSingleThreadExecutor() {
        return ProxyExecutors.newSingleThreadExecutor(new SingleThreadFactory());
    }
}
