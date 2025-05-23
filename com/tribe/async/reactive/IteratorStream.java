package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
class IteratorStream<R> extends Stream<R> {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class IteratorDataPusher<R> extends BaseDataPusher<R> {
        private final Iterator<R> mIterator;

        public IteratorDataPusher(Iterator<R> it) {
            AssertUtils.checkNotNull(it);
            this.mIterator = it;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tribe.async.reactive.BaseDataPusher, com.tribe.async.reactive.AsyncFunction
        public void apply(Observer<R> observer) {
            super.apply((Observer) observer);
            while (this.mIterator.hasNext() && !isCanceled()) {
                R next = this.mIterator.next();
                AssertUtils.checkNotNull(next);
                observer.onNext(next);
            }
            observer.onComplete();
        }
    }

    public IteratorStream(Iterator<R> it) {
        AssertUtils.checkNotNull(it);
        attachDataSupplier(new IteratorDataPusher(it));
    }
}
