package com.tribe.async.reactive;

import android.support.annotation.NonNull;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public class OperatorMap<UP, DOWN> extends Operator<UP, DOWN> {
    private final StreamFunction<UP, DOWN> mTransform;

    public OperatorMap(StreamFunction<UP, DOWN> streamFunction) {
        AssertUtils.checkNotNull(streamFunction);
        this.mTransform = streamFunction;
    }

    @Override // com.tribe.async.reactive.Function
    public Observer<UP> apply(final Observer<DOWN> observer) {
        AssertUtils.checkNotNull(observer);
        this.mTransform.observe(new StreamFunction.StreamFunctionListener<DOWN>() { // from class: com.tribe.async.reactive.OperatorMap.1
            @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
            public void onCancel() {
                observer.onCancel();
            }

            @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
            public void onError(java.lang.Error error) {
                observer.onError(error);
            }

            @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
            public void onResult(DOWN down) {
                observer.onNext(down);
            }
        });
        return new SimpleObserver<UP>() { // from class: com.tribe.async.reactive.OperatorMap.2
            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onCancel() {
                OperatorMap.this.mTransform.cancel();
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onComplete() {
                observer.onComplete();
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onError(@NonNull java.lang.Error error) {
                OperatorMap.this.mTransform.error(error);
            }

            @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
            public void onNext(UP up5) {
                OperatorMap.this.mTransform.apply(up5);
            }
        };
    }
}
