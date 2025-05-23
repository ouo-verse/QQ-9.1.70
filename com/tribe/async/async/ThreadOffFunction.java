package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThreadOffFunction<IN> extends StreamFunction<IN, IN> {
    private Future mFuture;
    private final int mJobType;
    private boolean mNeedSchedule;
    private final String mTAG;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class ThreadOffErrJob extends Job<Error, Void, Error> {
        ThreadOffErrJob(String str) {
            super(str + ".error");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        public Error doInBackground(@NonNull JobContext jobContext, @Nullable Error... errorArr) {
            AssertUtils.checkNotNull(errorArr);
            AssertUtils.assertTrue(errorArr.length > 0);
            Error error = errorArr[0];
            ThreadOffFunction.this.notifyError(error);
            return error;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class ThreadOffJob extends Job<IN, Void, IN> {
        @Override // com.tribe.async.async.Job
        protected IN doInBackground(@NonNull JobContext jobContext, @Nullable IN... inArr) {
            if (inArr == null || inArr.length <= 0) {
                ThreadOffFunction.this.notifyResult(null);
                return null;
            }
            ThreadOffFunction.this.notifyResult(inArr[0]);
            return inArr[0];
        }

        ThreadOffJob(String str) {
            super(str);
        }
    }

    public ThreadOffFunction(int i3) {
        this("ThreadOffFunction", i3);
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void call(IN in5) {
        ThreadOffJob threadOffJob = new ThreadOffJob(this.mTAG);
        threadOffJob.setJobType(this.mJobType);
        if (this.mNeedSchedule) {
            this.mFuture = Bosses.get().scheduleJob(threadOffJob, in5);
        } else {
            this.mFuture = Bosses.get().postJob(threadOffJob, in5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    public void error(Error error) {
        ThreadOffErrJob threadOffErrJob = new ThreadOffErrJob(this.mTAG);
        threadOffErrJob.setJobType(this.mJobType);
        if (this.mNeedSchedule) {
            this.mFuture = Bosses.get().scheduleJob(threadOffErrJob, error);
        } else {
            this.mFuture = Bosses.get().postJob(threadOffErrJob, error);
        }
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void onCancel() {
        Future future = this.mFuture;
        if (future == null) {
            return;
        }
        if (this.mNeedSchedule) {
            Bosses.get().cancelJob(this.mFuture, true);
        } else {
            future.cancel(true);
        }
    }

    public void setNeedSchedule(boolean z16) {
        this.mNeedSchedule = z16;
    }

    public ThreadOffFunction(@NonNull String str, int i3) {
        this.mJobType = i3;
        this.mTAG = str;
    }
}
