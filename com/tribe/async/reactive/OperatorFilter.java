package com.tribe.async.reactive;

import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OperatorFilter<T> extends Operator<T, T> {
    private final Predicate<T> mPredicate;

    public OperatorFilter(Predicate<T> predicate) {
        AssertUtils.checkNotNull(predicate);
        this.mPredicate = predicate;
    }

    @Override // com.tribe.async.reactive.Function
    public Observer<T> apply(final Observer<T> observer) {
        AssertUtils.checkNotNull(observer);
        return new SimpleObserver<T>() { // from class: com.tribe.async.reactive.OperatorFilter.1
            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onComplete() {
                observer.onComplete();
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onError(@NonNull java.lang.Error error) {
                observer.onError(error);
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onNext(T t16) {
                if (OperatorFilter.this.mPredicate.test(t16)) {
                    observer.onNext(t16);
                }
            }
        };
    }
}
