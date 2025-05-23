package com.tribe.async.async;

import com.tribe.async.reactive.StreamFunction;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class JobSegment<IN, OUT> extends StreamFunction<IN, OUT> {
    private JobContext mJobContext;

    public void attachJobContext(JobContext jobContext) {
        this.mJobContext = jobContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    public void call(IN in5) {
        if (this.mJobContext == null) {
            this.mJobContext = new StubJobContext();
        }
        runSegment(this.mJobContext, in5);
    }

    @Override // com.tribe.async.reactive.StreamFunction
    protected void onCancel() {
        JobContext jobContext = this.mJobContext;
        if (jobContext != null && (jobContext instanceof StubJobContext)) {
            ((StubJobContext) jobContext).setCanceled(true);
        }
    }

    protected abstract void runSegment(JobContext jobContext, IN in5);
}
