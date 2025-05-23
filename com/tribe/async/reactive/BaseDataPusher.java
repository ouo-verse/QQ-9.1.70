package com.tribe.async.reactive;

/* loaded from: classes27.dex */
public class BaseDataPusher<T> extends DataPusher<T> {
    private volatile boolean mIsCanceled;
    protected Observer<T> mLastObserver;

    @Override // com.tribe.async.reactive.DataPusher
    public void cancel() {
        this.mIsCanceled = true;
        Observer<T> observer = this.mLastObserver;
        if (observer != null) {
            observer.onCancel();
        }
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
    }

    @Override // com.tribe.async.reactive.AsyncFunction
    public void apply(Observer<T> observer) {
        this.mLastObserver = observer;
        this.mIsCanceled = false;
    }
}
