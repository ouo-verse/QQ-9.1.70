package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public class ResultStream<R> extends Stream<R> {
    private R mResult;

    public ResultStream(R r16) {
        AssertUtils.checkNotNull(r16);
        this.mResult = r16;
        attachDataSupplier(new BaseDataPusher<R>() { // from class: com.tribe.async.reactive.ResultStream.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tribe.async.reactive.BaseDataPusher, com.tribe.async.reactive.AsyncFunction
            public void apply(Observer<R> observer) {
                super.apply((Observer) observer);
                observer.onNext(ResultStream.this.mResult);
                observer.onComplete();
            }
        });
    }
}
