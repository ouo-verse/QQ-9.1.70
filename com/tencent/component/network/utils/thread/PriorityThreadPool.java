package com.tencent.component.network.utils.thread;

import com.tencent.component.network.utils.thread.ThreadPool;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class PriorityThreadPool extends ThreadPool {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class InstanceHolder {
        public static final PriorityThreadPool INSTANCE = new PriorityThreadPool();

        InstanceHolder() {
        }
    }

    /* loaded from: classes5.dex */
    public static class Priority {
        public final boolean fifo;
        public final int priority;
        public static final Priority LOW = new Priority(-1, true);
        public static final Priority NORMAL = new Priority(0, true);
        public static final Priority HIGH = new Priority(1, false);

        public Priority(int i3, boolean z16) {
            this.priority = i3;
            this.fifo = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PriorityJob<T> implements ThreadPool.Job<T>, Comparable<PriorityJob> {
        private static final AtomicLong SEQ = new AtomicLong(0);
        private final boolean mFifo;
        private final ThreadPool.Job<T> mJob;
        private final int mPriority;
        private final long mSeqNum = SEQ.getAndIncrement();

        public PriorityJob(ThreadPool.Job<T> job, int i3, boolean z16) {
            this.mJob = job;
            this.mPriority = i3;
            this.mFifo = z16;
        }

        private int subCompareTo(PriorityJob priorityJob) {
            int i3;
            long j3 = this.mSeqNum;
            long j16 = priorityJob.mSeqNum;
            if (j3 < j16) {
                i3 = -1;
            } else if (j3 > j16) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!this.mFifo) {
                return -i3;
            }
            return i3;
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
        public T run(ThreadPool.JobContext jobContext) {
            try {
                String name = Thread.currentThread().getName();
                String substring = name.substring(0, name.indexOf(" sub:") + 5);
                Thread.currentThread().setName(substring + this.mJob.getClass().toString());
            } catch (Exception unused) {
            }
            return this.mJob.run(jobContext);
        }

        @Override // java.lang.Comparable
        public int compareTo(PriorityJob priorityJob) {
            int i3 = this.mPriority;
            int i16 = priorityJob.mPriority;
            if (i3 > i16) {
                return -1;
            }
            if (i3 < i16) {
                return 1;
            }
            return subCompareTo(priorityJob);
        }
    }

    public PriorityThreadPool() {
        this("priority-thread-pool", ThreadPool.DEFAULT_POOL_SIZE);
    }

    public static PriorityThreadPool getDefault() {
        return InstanceHolder.INSTANCE;
    }

    public <T> Future<T> submit(ThreadPool.Job<T> job, FutureListener<T> futureListener, Priority priority) {
        if (priority == null) {
            priority = Priority.NORMAL;
        }
        return super.submit(new PriorityJob(job, priority.priority, priority.fifo), futureListener);
    }

    public PriorityThreadPool(Executor executor) {
        super(executor);
    }

    public PriorityThreadPool(String str, int i3) {
        super(str, i3, i3, new PriorityBlockingQueue());
    }

    public <T> Future<T> submit(ThreadPool.Job<T> job, Priority priority) {
        return submit(job, null, priority);
    }

    @Override // com.tencent.component.network.utils.thread.ThreadPool
    public <T> Future<T> submit(ThreadPool.Job<T> job, FutureListener<T> futureListener) {
        return submit(job, futureListener, null);
    }

    @Override // com.tencent.component.network.utils.thread.ThreadPool
    public <T> Future<T> submit(ThreadPool.Job<T> job) {
        return submit(job, null, null);
    }
}
