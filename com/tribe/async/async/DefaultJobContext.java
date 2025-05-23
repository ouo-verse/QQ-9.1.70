package com.tribe.async.async;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tribe.async.async.JobContext;
import com.tribe.async.utils.AssertUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
class DefaultJobContext<Progress> implements JobContext<Progress> {

    @Nullable
    private JobContext.CancelListener mCancelListener;
    private volatile boolean mIsJobCancelled;
    private final SparseArray<Object> mValues = new SparseArray<>(1);
    private WeakReference<Worker<Progress, ?>> mWorkerRef;

    public DefaultJobContext(Worker<Progress, ?> worker) {
        AssertUtils.checkNotNull(worker);
        this.mWorkerRef = new WeakReference<>(worker);
    }

    @Override // com.tribe.async.async.JobContext
    public Object getValue(int i3) {
        return this.mValues.get(i3);
    }

    @Override // com.tribe.async.async.JobContext
    public boolean isJobCancelled() {
        return this.mIsJobCancelled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyCancelListener() {
        JobContext.CancelListener cancelListener = this.mCancelListener;
        if (cancelListener != null) {
            cancelListener.onCancel();
        }
    }

    @Override // com.tribe.async.async.JobContext
    public void publishJobProgress(Progress progress) {
        AssertUtils.checkNotNull(progress);
        Worker<Progress, ?> worker = this.mWorkerRef.get();
        if (worker != null) {
            worker.notifyProgress(progress);
        }
    }

    @Override // com.tribe.async.async.JobContext
    public void setCancelListener(@Nullable JobContext.CancelListener cancelListener) {
        this.mCancelListener = cancelListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setJobCancelled(boolean z16) {
        this.mIsJobCancelled = z16;
    }

    @Override // com.tribe.async.async.JobContext
    public void setValue(int i3, Object obj) {
        AssertUtils.checkNotNull(obj);
        this.mValues.put(i3, obj);
    }
}
