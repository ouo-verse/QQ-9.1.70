package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Worker<Progress, Result> extends FutureTask<Result> implements Dispatcher.Dispatchable {
    private static final String TAG = "async.boss.Worker";
    private Exception mException;
    private CopyOnWriteArrayList<FutureListener<Progress, Result>> mFutureListeners;
    private final Job<?, Progress, Result> mJob;
    private final DefaultJobContext<Progress> mJobContext;
    private Result mResult;

    public Worker(Job<?, Progress, Result> job) {
        super(job);
        this.mFutureListeners = new CopyOnWriteArrayList<>();
        DefaultJobContext<Progress> defaultJobContext = new DefaultJobContext<>(this);
        this.mJobContext = defaultJobContext;
        this.mJob = job;
        job.setJobContext(defaultJobContext);
    }

    private void notifyCanceled() {
        Iterator<FutureListener<Progress, Result>> it = this.mFutureListeners.iterator();
        while (it.hasNext()) {
            it.next().onFutureCanceled();
        }
        this.mJobContext.notifyCancelListener();
    }

    private void notifyDone(Result result) {
        Iterator<FutureListener<Progress, Result>> it = this.mFutureListeners.iterator();
        while (it.hasNext()) {
            it.next().onFutureDone(result);
        }
        this.mJob.onResult(this.mResult);
    }

    public void addFutureListener(FutureListener<Progress, Result> futureListener) {
        AssertUtils.checkNotNull(futureListener);
        this.mFutureListeners.add(futureListener);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        this.mJobContext.setJobCancelled(true);
        this.mJob.onCancelled();
        super.cancel(z16);
        return true;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        if (isCancelled()) {
            notifyCanceled();
        } else {
            try {
                this.mResult = get();
            } catch (InterruptedException e16) {
                this.mException = e16;
                SLog.e(TAG, "InterruptedException", e16);
            } catch (ExecutionException e17) {
                this.mException = e17;
                throw new RuntimeException("ExecutionException", e17);
            }
            notifyDone(this.mResult);
        }
        this.mJobContext.setCancelListener(null);
    }

    @Nullable
    public Exception getException() {
        return this.mException;
    }

    @NonNull
    public Job getJob() {
        return this.mJob;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getJobType() {
        return this.mJob.getJobType();
    }

    @Nullable
    public Result getResult() {
        return this.mResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyProgress(Progress progress) {
        Iterator<FutureListener<Progress, Result>> it = this.mFutureListeners.iterator();
        while (it.hasNext()) {
            it.next().onFutureProgress(progress);
        }
    }

    public void removeFutureListener(FutureListener<Progress, Result> futureListener) {
        AssertUtils.checkNotNull(futureListener);
        this.mFutureListeners.remove(futureListener);
    }

    @Override // java.util.concurrent.FutureTask
    public String toString() {
        return "Worker:" + this.mJob.toString();
    }
}
