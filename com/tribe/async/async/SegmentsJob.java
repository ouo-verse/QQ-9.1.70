package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.reactive.StreamFunction;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SegmentsJob<IN, PROGRESS, OUT> extends Job<IN, PROGRESS, OUT> {
    private Error mError;
    private JobSegment<IN, OUT> mJobSegment;
    private OUT mResult;

    public SegmentsJob() {
        this("SegmentsJob");
    }

    public void attachJobSegment(JobSegment<IN, OUT> jobSegment) {
        this.mJobSegment = jobSegment;
    }

    @Override // com.tribe.async.async.Job
    protected OUT doInBackground(@NonNull JobContext jobContext, @Nullable IN... inArr) {
        JobSegment<IN, OUT> jobSegment = this.mJobSegment;
        if (jobSegment != null) {
            jobSegment.attachJobContext(jobContext);
            this.mJobSegment.observe(new InnerStreamFunctionListener());
            if (inArr != null && inArr.length > 0) {
                this.mJobSegment.apply(inArr[0]);
            } else {
                this.mJobSegment.apply(null);
            }
            return this.mResult;
        }
        throw new RuntimeException("Please call attachJobSegment first.");
    }

    public Error getError() {
        return this.mError;
    }

    public OUT getResult() {
        return this.mResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.Job
    public void onCancelled() {
        this.mJobSegment.cancel();
    }

    public SegmentsJob(@NonNull String str) {
        super(str);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class InnerStreamFunctionListener implements StreamFunction.StreamFunctionListener<OUT> {
        InnerStreamFunctionListener() {
        }

        @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
        public void onError(Error error) {
            SegmentsJob.this.mError = error;
        }

        @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
        public void onResult(OUT out) {
            SegmentsJob.this.mResult = out;
        }

        @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
        public void onCancel() {
        }
    }
}
