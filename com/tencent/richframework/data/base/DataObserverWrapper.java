package com.tencent.richframework.data.base;

import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DataObserverWrapper<T> implements Observer<T> {
    private final WeakReference<Observer<T>> mWrfObserver;

    public DataObserverWrapper(Observer<T> observer) {
        this.mWrfObserver = new WeakReference<>(observer);
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(T t16) {
        Observer<T> observer = this.mWrfObserver.get();
        if (observer == null) {
            return;
        }
        observer.onChanged(t16);
    }
}
