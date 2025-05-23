package com.tencent.qqlive.module.videoreport.task.base;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HandlerScheduledFuture<T> extends FutureTask<T> implements RunnableScheduledFuture<T> {
    private int count;
    private long mDelay;
    private Handler mHandler;
    private long mInit;
    private final long mPeriodic;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduledFuture(Runnable runnable, Handler handler, long j3, long j16) {
        super(runnable, null);
        this.mHandler = handler;
        this.mDelay = j3;
        this.mPeriodic = j16;
        this.mInit = SystemClock.uptimeMillis();
    }

    private void reExecutePeriodic(Runnable runnable, long j3) {
        this.mHandler.postAtTime(this, j3);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        boolean cancel = super.cancel(z16);
        if (cancel) {
            this.mHandler.removeCallbacks(this);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.mDelay;
    }

    @Override // java.util.concurrent.RunnableScheduledFuture
    public boolean isPeriodic() {
        if (this.mPeriodic > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        boolean isPeriodic = isPeriodic();
        if (isCancelled()) {
            cancel(false);
            return;
        }
        if (!isPeriodic) {
            super.run();
        } else if (super.runAndReset()) {
            this.count++;
            reExecutePeriodic(this, setNextRunTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long setNextRunTime() {
        return this.mInit + this.mDelay + (this.count * this.mPeriodic);
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        if (delayed == this) {
            return 0;
        }
        long delay = this.mDelay - delayed.getDelay(TimeUnit.MILLISECONDS);
        if (delay < 0) {
            return -1;
        }
        return delay > 0 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduledFuture(Callable<T> callable, Handler handler, long j3, long j16) {
        super(callable);
        this.mHandler = handler;
        this.mDelay = j3;
        this.mPeriodic = j16;
        this.mInit = SystemClock.uptimeMillis();
    }
}
