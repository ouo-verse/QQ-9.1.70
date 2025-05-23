package com.tencent.mm.vfs;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CancellationSignalBeforeJB {
    private boolean mCancelInProgress;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void cancel() {
        synchronized (this) {
            if (this.mIsCanceled) {
                return;
            }
            this.mIsCanceled = true;
            this.mCancelInProgress = true;
            OnCancelListener onCancelListener = this.mOnCancelListener;
            if (onCancelListener != null) {
                try {
                    onCancelListener.onCancel();
                } catch (Throwable th5) {
                    synchronized (this) {
                        this.mCancelInProgress = false;
                        notifyAll();
                        throw th5;
                    }
                }
            }
            synchronized (this) {
                this.mCancelInProgress = false;
                notifyAll();
            }
        }
    }

    public boolean isCanceled() {
        boolean z16;
        synchronized (this) {
            z16 = this.mIsCanceled;
        }
        return z16;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            waitForCancelFinishedLocked();
            if (this.mOnCancelListener == onCancelListener) {
                return;
            }
            this.mOnCancelListener = onCancelListener;
            if (this.mIsCanceled && onCancelListener != null) {
                onCancelListener.onCancel();
            }
        }
    }

    public void throwIfCanceled() {
        if (!isCanceled()) {
        } else {
            throw new OperationCanceledException();
        }
    }
}
