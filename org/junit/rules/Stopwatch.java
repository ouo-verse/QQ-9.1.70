package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Stopwatch implements TestRule {
    private final Clock clock;
    private volatile long endNanos;
    private volatile long startNanos;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Clock {
        Clock() {
        }

        public long nanoTime() {
            return System.nanoTime();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class InternalWatcher extends TestWatcher {
        InternalWatcher() {
        }

        @Override // org.junit.rules.TestWatcher
        protected void failed(Throwable th5, Description description) {
            Stopwatch.this.stopping();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.failed(stopwatch.getNanos(), th5, description);
        }

        @Override // org.junit.rules.TestWatcher
        protected void finished(Description description) {
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.finished(stopwatch.getNanos(), description);
        }

        @Override // org.junit.rules.TestWatcher
        protected void skipped(AssumptionViolatedException assumptionViolatedException, Description description) {
            Stopwatch.this.stopping();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.skipped(stopwatch.getNanos(), assumptionViolatedException, description);
        }

        @Override // org.junit.rules.TestWatcher
        protected void starting(Description description) {
            Stopwatch.this.starting();
        }

        @Override // org.junit.rules.TestWatcher
        protected void succeeded(Description description) {
            Stopwatch.this.stopping();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.succeeded(stopwatch.getNanos(), description);
        }
    }

    public Stopwatch() {
        this(new Clock());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getNanos() {
        if (this.startNanos != 0) {
            long j3 = this.endNanos;
            if (j3 == 0) {
                j3 = this.clock.nanoTime();
            }
            return j3 - this.startNanos;
        }
        throw new IllegalStateException("Test has not started");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void starting() {
        this.startNanos = this.clock.nanoTime();
        this.endNanos = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopping() {
        this.endNanos = this.clock.nanoTime();
    }

    @Override // org.junit.rules.TestRule
    public final Statement apply(Statement statement, Description description) {
        return new InternalWatcher().apply(statement, description);
    }

    public long runtime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanos(), TimeUnit.NANOSECONDS);
    }

    Stopwatch(Clock clock) {
        this.clock = clock;
    }

    protected void finished(long j3, Description description) {
    }

    protected void succeeded(long j3, Description description) {
    }

    protected void failed(long j3, Throwable th5, Description description) {
    }

    protected void skipped(long j3, AssumptionViolatedException assumptionViolatedException, Description description) {
    }
}
