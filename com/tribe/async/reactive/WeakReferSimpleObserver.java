package com.tribe.async.reactive;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WeakReferSimpleObserver<R, T> implements Observer<T> {
    public static final String TAG = "async.WeakReferSimpleObserver";
    private WeakReference<R> mSimpleObserverWeakReference;

    public WeakReferSimpleObserver(R r16) {
        this.mSimpleObserverWeakReference = new WeakReference<>(r16);
    }

    public void onCancel(@NonNull R r16) {
    }

    public void onComplete(@NonNull R r16) {
    }

    public void onError(@NonNull R r16, @NonNull java.lang.Error error) {
    }

    public void onNext(@NonNull R r16, T t16) {
    }

    @Override // com.tribe.async.reactive.Observer
    public final void onCancel() {
        R r16 = this.mSimpleObserverWeakReference.get();
        if (r16 != null) {
            onCancel(r16);
        } else {
            SLog.v(TAG, "UI is null");
        }
    }

    @Override // com.tribe.async.reactive.Observer
    public final void onComplete() {
        R r16 = this.mSimpleObserverWeakReference.get();
        if (r16 != null) {
            onComplete(r16);
        } else {
            SLog.v(TAG, "UI is null");
        }
    }

    @Override // com.tribe.async.reactive.Observer
    public final void onError(@NonNull java.lang.Error error) {
        R r16 = this.mSimpleObserverWeakReference.get();
        if (r16 != null) {
            onError(r16, error);
        } else {
            SLog.v(TAG, "UI is null");
        }
    }

    @Override // com.tribe.async.reactive.Observer
    public final void onNext(T t16) {
        R r16 = this.mSimpleObserverWeakReference.get();
        if (r16 != null) {
            onNext(r16, t16);
        } else {
            SLog.v(TAG, "UI is null");
        }
    }
}
