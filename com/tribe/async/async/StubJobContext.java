package com.tribe.async.async;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tribe.async.async.JobContext;
import com.tribe.async.utils.AssertUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class StubJobContext implements JobContext {
    private JobContext.CancelListener mCancelListener;
    private volatile boolean mCanceled;
    private final SparseArray<Object> mValues = new SparseArray<>(1);

    @Override // com.tribe.async.async.JobContext
    @Nullable
    public Object getValue(int i3) {
        Object obj;
        synchronized (this.mValues) {
            obj = this.mValues.get(i3);
        }
        return obj;
    }

    @Override // com.tribe.async.async.JobContext
    public boolean isJobCancelled() {
        return this.mCanceled;
    }

    @Override // com.tribe.async.async.JobContext
    public void setCancelListener(@Nullable JobContext.CancelListener cancelListener) {
        this.mCancelListener = cancelListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanceled(boolean z16) {
        JobContext.CancelListener cancelListener;
        this.mCanceled = z16;
        if (z16 && (cancelListener = this.mCancelListener) != null) {
            cancelListener.onCancel();
        }
    }

    @Override // com.tribe.async.async.JobContext
    public void setValue(int i3, Object obj) {
        AssertUtils.checkNotNull(obj);
        synchronized (this.mValues) {
            this.mValues.put(i3, obj);
        }
    }

    @Override // com.tribe.async.async.JobContext
    public void publishJobProgress(Object obj) {
    }
}
