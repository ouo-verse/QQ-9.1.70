package org.junit.internal.runners.statements;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.Thread;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FailOnTimeout extends Statement {
    private final boolean lookForStuckThread;
    private final Statement originalStatement;
    private volatile ThreadGroup threadGroup;
    private final TimeUnit timeUnit;
    private final long timeout;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private boolean lookForStuckThread;
        private long timeout;
        private TimeUnit unit;

        public FailOnTimeout build(Statement statement) {
            if (statement != null) {
                return new FailOnTimeout(this, statement);
            }
            throw new NullPointerException("statement cannot be null");
        }

        public Builder withLookingForStuckThread(boolean z16) {
            this.lookForStuckThread = z16;
            return this;
        }

        public Builder withTimeout(long j3, TimeUnit timeUnit) {
            if (j3 >= 0) {
                if (timeUnit != null) {
                    this.timeout = j3;
                    this.unit = timeUnit;
                    return this;
                }
                throw new NullPointerException("TimeUnit cannot be null");
            }
            throw new IllegalArgumentException("timeout must be non-negative");
        }

        Builder() {
            this.lookForStuckThread = false;
            this.timeout = 0L;
            this.unit = TimeUnit.SECONDS;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class CallableStatement implements Callable<Throwable> {
        private final CountDownLatch startLatch;

        CallableStatement() {
            this.startLatch = new CountDownLatch(1);
        }

        public void awaitStarted() throws InterruptedException {
            this.startLatch.await();
        }

        @Override // java.util.concurrent.Callable
        public Throwable call() throws Exception {
            try {
                this.startLatch.countDown();
                FailOnTimeout.this.originalStatement.evaluate();
                return null;
            } catch (Exception e16) {
                throw e16;
            } catch (Throwable th5) {
                return th5;
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private Thread[] copyThreads(Thread[] threadArr, int i3) {
        int min = Math.min(i3, threadArr.length);
        Thread[] threadArr2 = new Thread[min];
        for (int i16 = 0; i16 < min; i16++) {
            threadArr2[i16] = threadArr[i16];
        }
        return threadArr2;
    }

    private long cpuTime(Thread thread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (threadMXBean.isThreadCpuTimeSupported()) {
            try {
                return threadMXBean.getThreadCpuTime(thread.getId());
            } catch (UnsupportedOperationException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    private Exception createTimeoutException(Thread thread) {
        Thread thread2;
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (this.lookForStuckThread) {
            thread2 = getStuckThread(thread);
        } else {
            thread2 = null;
        }
        TestTimedOutException testTimedOutException = new TestTimedOutException(this.timeout, this.timeUnit);
        if (stackTrace != null) {
            testTimedOutException.setStackTrace(stackTrace);
            thread.interrupt();
        }
        if (thread2 != null) {
            Exception exc = new Exception("Appears to be stuck in thread " + thread2.getName());
            exc.setStackTrace(getStackTrace(thread2));
            return new MultipleFailureException(Arrays.asList(testTimedOutException, exc));
        }
        return testTimedOutException;
    }

    private Throwable getResult(FutureTask<Throwable> futureTask, Thread thread) {
        try {
            long j3 = this.timeout;
            if (j3 > 0) {
                return futureTask.get(j3, this.timeUnit);
            }
            return futureTask.get();
        } catch (InterruptedException e16) {
            return e16;
        } catch (ExecutionException e17) {
            return e17.getCause();
        } catch (TimeoutException unused) {
            return createTimeoutException(thread);
        }
    }

    private StackTraceElement[] getStackTrace(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException unused) {
            return new StackTraceElement[0];
        }
    }

    private Thread getStuckThread(Thread thread) {
        Thread[] threadArray;
        if (this.threadGroup == null || (threadArray = getThreadArray(this.threadGroup)) == null) {
            return null;
        }
        long j3 = 0;
        Thread thread2 = null;
        for (Thread thread3 : threadArray) {
            if (thread3.getState() == Thread.State.RUNNABLE) {
                long cpuTime = cpuTime(thread3);
                if (thread2 == null || cpuTime > j3) {
                    thread2 = thread3;
                    j3 = cpuTime;
                }
            }
        }
        if (thread2 == thread) {
            return null;
        }
        return thread2;
    }

    private Thread[] getThreadArray(ThreadGroup threadGroup) {
        int max = Math.max(threadGroup.activeCount() * 2, 100);
        int i3 = 0;
        do {
            Thread[] threadArr = new Thread[max];
            int enumerate = threadGroup.enumerate(threadArr);
            if (enumerate < max) {
                return copyThreads(threadArr, enumerate);
            }
            max += 100;
            i3++;
        } while (i3 < 5);
        return null;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        CallableStatement callableStatement = new CallableStatement();
        FutureTask<Throwable> futureTask = new FutureTask<>(callableStatement);
        this.threadGroup = new ThreadGroup("FailOnTimeoutGroup");
        BaseThread baseThread = new BaseThread(this.threadGroup, futureTask, "Time-limited test");
        baseThread.setDaemon(true);
        baseThread.start();
        callableStatement.awaitStarted();
        Throwable result = getResult(futureTask, baseThread);
        if (result == null) {
        } else {
            throw result;
        }
    }

    @Deprecated
    public FailOnTimeout(Statement statement, long j3) {
        this(builder().withTimeout(j3, TimeUnit.MILLISECONDS), statement);
    }

    FailOnTimeout(Builder builder, Statement statement) {
        this.threadGroup = null;
        this.originalStatement = statement;
        this.timeout = builder.timeout;
        this.timeUnit = builder.unit;
        this.lookForStuckThread = builder.lookForStuckThread;
    }
}
