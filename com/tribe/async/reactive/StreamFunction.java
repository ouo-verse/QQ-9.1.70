package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class StreamFunction<IN, OUT> implements AsyncFunction<IN> {
    private StreamFunctionListener<OUT> mDownListener;
    private volatile boolean mIsCanceled;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface StreamFunctionListener<OUT> {
        void onCancel();

        void onError(java.lang.Error error);

        void onResult(OUT out);
    }

    @Override // com.tribe.async.reactive.AsyncFunction
    public final void apply(IN in5) {
        this.mIsCanceled = false;
        call(in5);
    }

    protected abstract void call(IN in5);

    public final void cancel() {
        this.mIsCanceled = true;
        StreamFunctionListener<OUT> streamFunctionListener = this.mDownListener;
        if (streamFunctionListener != null) {
            streamFunctionListener.onCancel();
        }
        onCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void error(java.lang.Error error) {
        notifyError(error);
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyError(java.lang.Error error) {
        AssertUtils.checkNotNull(error);
        if (this.mDownListener == null) {
            AssertUtils.fail("Please call observe first.", new Object[0]);
        }
        this.mDownListener.onError(error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyResult(OUT out) {
        if (this.mDownListener == null) {
            AssertUtils.fail("Please call observe first.", new Object[0]);
        }
        this.mDownListener.onResult(out);
    }

    public final void observe(StreamFunctionListener<OUT> streamFunctionListener) {
        this.mDownListener = streamFunctionListener;
    }

    protected void onCancel() {
    }
}
