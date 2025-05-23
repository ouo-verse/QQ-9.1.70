package com.tribe.async.reactive;

import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Stream<Result> {
    private DataPusher<Result> mDataPusher;

    public static <R> Stream<R> fromArray(R[] rArr) {
        AssertUtils.checkNotNull(rArr);
        return new ArrayStream(rArr);
    }

    public static <R> Stream<R> fromDataPusher(@NonNull DataPusher<R> dataPusher) {
        AssertUtils.checkNotNull(dataPusher);
        Stream<R> stream = new Stream<>();
        stream.attachDataSupplier(dataPusher);
        return stream;
    }

    public static <R> Stream<R> fromIterator(Iterator<R> it) {
        AssertUtils.checkNotNull(it);
        return new IteratorStream(it);
    }

    public static <R> Stream<R> of(R r16) {
        AssertUtils.checkNotNull(r16);
        return new ResultStream(r16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachDataSupplier(@NonNull DataPusher<Result> dataPusher) {
        this.mDataPusher = dataPusher;
    }

    public void cancel() {
        DataPusher<Result> dataPusher = this.mDataPusher;
        if (dataPusher != null) {
            dataPusher.cancel();
            return;
        }
        throw new RuntimeException("Please call attachDataSupplier before cancel.");
    }

    public Stream<Result> filter(Predicate<Result> predicate) {
        return (Stream<Result>) lift(new OperatorFilter(predicate));
    }

    public <R> Stream<R> lift(Operator<Result, R> operator) {
        AssertUtils.checkNotNull(operator);
        Stream<R> stream = new Stream<>();
        stream.attachDataSupplier(new OperatorDataPusher(this.mDataPusher, operator));
        return stream;
    }

    public <R> Stream<R> map(StreamFunction<Result, R> streamFunction) {
        AssertUtils.checkNotNull(streamFunction);
        return lift(new OperatorMap(streamFunction));
    }

    public void subscribe(Observer<Result> observer) {
        AssertUtils.checkNotNull(observer);
        DataPusher<Result> dataPusher = this.mDataPusher;
        if (dataPusher != null) {
            dataPusher.apply(observer);
            return;
        }
        throw new RuntimeException("Please call attachDataSupplier before subscribe.");
    }
}
