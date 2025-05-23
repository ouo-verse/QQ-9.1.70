package com.tribe.async.reactive;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Observer<T> {
    void onCancel();

    void onComplete();

    void onError(@NonNull java.lang.Error error);

    void onNext(T t16);
}
