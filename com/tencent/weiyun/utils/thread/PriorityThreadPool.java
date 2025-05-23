package com.tencent.weiyun.utils.thread;

import android.annotation.TargetApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.utils.thread.ThreadPool;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes27.dex */
public class PriorityThreadPool extends ThreadPool {
    static IPatchRedirector $redirector_;

    /* loaded from: classes27.dex */
    public static class Priority {
        static IPatchRedirector $redirector_;
        public static final Priority HIGH;
        public static final Priority LOW;
        public static final Priority NORMAL;
        public final boolean fifo;
        public final int priority;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10608);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            LOW = new Priority(-1, true);
            NORMAL = new Priority(0, true);
            HIGH = new Priority(1, false);
        }

        public Priority(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                this.priority = i3;
                this.fifo = z16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class PriorityJob<T> implements ThreadPool.Job<T>, Comparable<PriorityJob> {
        static IPatchRedirector $redirector_;
        private static final AtomicLong SEQ;
        private final boolean mFifo;
        private final ThreadPool.Job<T> mJob;
        private final int mPriority;
        private final long mSeqNum;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10441);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                SEQ = new AtomicLong(0L);
            }
        }

        public PriorityJob(ThreadPool.Job<T> job, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, job, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.mJob = job;
            this.mPriority = i3;
            this.mFifo = z16;
            this.mSeqNum = SEQ.getAndIncrement();
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

        @Override // com.tencent.weiyun.utils.thread.ThreadPool.Job
        public T run(ThreadPool.JobContext jobContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext);
            }
            return this.mJob.run(jobContext);
        }

        @Override // java.lang.Comparable
        public int compareTo(PriorityJob priorityJob) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) priorityJob)).intValue();
            }
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
        this("priority-thread-pool", 4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public <T> Future<T> submit(ThreadPool.Job<T> job, FutureListener<T> futureListener, Priority priority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Future) iPatchRedirector.redirect((short) 4, this, job, futureListener, priority);
        }
        if (priority == null) {
            priority = Priority.NORMAL;
        }
        return super.submit(new PriorityJob(job, priority.priority, priority.fifo), futureListener);
    }

    public PriorityThreadPool(String str, int i3) {
        super(str, i3, i3, new PriorityBlockingQueue());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
    }

    @TargetApi(9)
    public PriorityThreadPool(String str, int i3, long j3, TimeUnit timeUnit) {
        super(str, i3, j3, timeUnit, new PriorityBlockingQueue());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), timeUnit);
    }

    public <T> Future<T> submit(ThreadPool.Job<T> job, Priority priority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? submit(job, null, priority) : (Future) iPatchRedirector.redirect((short) 5, (Object) this, (Object) job, (Object) priority);
    }

    @Override // com.tencent.weiyun.utils.thread.ThreadPool
    public <T> Future<T> submit(ThreadPool.Job<T> job, FutureListener<T> futureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? submit(job, futureListener, null) : (Future) iPatchRedirector.redirect((short) 6, (Object) this, (Object) job, (Object) futureListener);
    }

    @Override // com.tencent.weiyun.utils.thread.ThreadPool
    public <T> Future<T> submit(ThreadPool.Job<T> job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? submit(job, null, null) : (Future) iPatchRedirector.redirect((short) 7, (Object) this, (Object) job);
    }
}
