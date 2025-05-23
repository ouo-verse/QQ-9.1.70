package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;
import java.util.concurrent.Future;

/* loaded from: classes27.dex */
public abstract class ParallelJobSegment<IN, OUT> extends StreamFunction<IN, OUT> {
    private Future mFuture;
    private int mJobType;
    private boolean mNeedSchedule;
    private String mTAG;

    /* loaded from: classes27.dex */
    private class ThreadOffErrJob extends Job<Error, Void, Error> {
        ThreadOffErrJob(ParallelJobSegment parallelJobSegment) {
            this("ParallelJobSegment.ThreadOffErrJob");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        public Error doInBackground(@NonNull JobContext jobContext, @Nullable Error... errorArr) {
            AssertUtils.checkNotNull(errorArr);
            AssertUtils.assertTrue(errorArr.length > 0);
            Error error = errorArr[0];
            ParallelJobSegment.this.notifyError(error);
            return error;
        }

        ThreadOffErrJob(String str) {
            super(str);
        }
    }

    /* loaded from: classes27.dex */
    private class ThreadOffJob extends Job<IN, Void, IN> {
        @Override // com.tribe.async.async.Job
        protected IN doInBackground(@NonNull JobContext jobContext, @Nullable IN... inArr) {
            if (inArr != null && inArr.length > 0) {
                ParallelJobSegment.this.runSegment(jobContext, inArr[0]);
                return inArr[0];
            }
            ParallelJobSegment.this.runSegment(jobContext, null);
            return null;
        }

        @Deprecated
        ThreadOffJob(ParallelJobSegment parallelJobSegment) {
            this("ParallelJobSegment.ThreadOffJob");
        }

        ThreadOffJob(String str) {
            super(str);
        }
    }

    @Deprecated
    public ParallelJobSegment(int i3) {
        this("ParallelJobSegment", i3);
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

    protected abstract void runSegment(JobContext jobContext, IN in5);

    public void setNeedSchedule(boolean z16) {
        this.mNeedSchedule = z16;
    }

    public ParallelJobSegment(String str) {
        this(str, 2);
    }

    public ParallelJobSegment(@NonNull String str, int i3) {
        this.mTAG = str;
        this.mJobType = i3;
    }
}
