package com.tencent.richframework.data.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class WeakMutableLiveData<T> extends MutableLiveData<T> {
    private WeakReference<T> mDataWeak;
    private final MutableLiveData<WeakReference<T>> mLiveDataProxy;
    private final Map<Observer<? super T>, Observer<WeakReference>> mObserverReferenceMap;

    public WeakMutableLiveData(T t16) {
        super(null);
        this.mObserverReferenceMap = new ConcurrentHashMap();
        WeakReference<T> weakReference = new WeakReference<>(t16);
        this.mDataWeak = weakReference;
        this.mLiveDataProxy = new MutableLiveData<>(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserverChange(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return;
        }
        Iterator<Observer<? super T>> it = this.mObserverReferenceMap.keySet().iterator();
        while (it.hasNext()) {
            it.next().onChanged(weakReference.get());
        }
    }

    @Override // androidx.lifecycle.LiveData
    @Nullable
    public T getValue() {
        WeakReference<T> weakReference = this.mDataWeak;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        Observer<WeakReference<T>> observer2 = new Observer<WeakReference<T>>() { // from class: com.tencent.richframework.data.base.WeakMutableLiveData.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(WeakReference<T> weakReference) {
                WeakMutableLiveData.this.notifyObserverChange(weakReference);
            }
        };
        this.mObserverReferenceMap.put(observer, observer2);
        this.mLiveDataProxy.observe(lifecycleOwner, observer2);
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(@NonNull Observer<? super T> observer) {
        Observer<WeakReference<T>> observer2 = new Observer<WeakReference<T>>() { // from class: com.tencent.richframework.data.base.WeakMutableLiveData.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(WeakReference<T> weakReference) {
                WeakMutableLiveData.this.notifyObserverChange(weakReference);
            }
        };
        this.mObserverReferenceMap.put(observer, observer2);
        this.mLiveDataProxy.observeForever(observer2);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t16) {
        WeakReference<T> weakReference = new WeakReference<>(t16);
        this.mDataWeak = weakReference;
        this.mLiveDataProxy.postValue(weakReference);
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NonNull Observer<? super T> observer) {
        this.mObserverReferenceMap.remove(observer);
        this.mLiveDataProxy.removeObserver(this.mObserverReferenceMap.get(observer));
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t16) {
        WeakReference<T> weakReference = new WeakReference<>(t16);
        this.mDataWeak = weakReference;
        this.mLiveDataProxy.setValue(weakReference);
    }

    public WeakMutableLiveData() {
        this(null);
    }
}
