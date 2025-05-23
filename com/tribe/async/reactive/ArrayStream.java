package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
class ArrayStream<R> extends Stream<R> {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class ArrayDataPusher<R> extends BaseDataPusher<R> {
        private final R[] mArray;

        public ArrayDataPusher(R[] rArr) {
            AssertUtils.checkNotNull(rArr);
            this.mArray = rArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tribe.async.reactive.BaseDataPusher, com.tribe.async.reactive.AsyncFunction
        public void apply(Observer<R> observer) {
            super.apply((Observer) observer);
            for (R r16 : this.mArray) {
                if (isCanceled()) {
                    break;
                }
                AssertUtils.checkNotNull(r16);
                observer.onNext(r16);
            }
            observer.onComplete();
        }
    }

    public ArrayStream(R[] rArr) {
        AssertUtils.checkNotNull(rArr);
        attachDataSupplier(new ArrayDataPusher(rArr));
    }
}
