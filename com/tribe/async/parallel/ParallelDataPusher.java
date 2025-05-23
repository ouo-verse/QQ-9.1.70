package com.tribe.async.parallel;

import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;

/* loaded from: classes27.dex */
class ParallelDataPusher<IN, OUT> extends DataPusher {

    /* renamed from: in, reason: collision with root package name */
    private IN f386995in;
    private StreamFunction<IN, OUT> mFunction;
    private DataPusher mUpDataPusher;

    public ParallelDataPusher(StreamFunction<IN, OUT> streamFunction, IN in5) {
        this.mUpDataPusher = null;
        this.mFunction = streamFunction;
        this.f386995in = in5;
        AssertUtils.checkNotNull(streamFunction);
    }

    @Override // com.tribe.async.parallel.DataPusher
    public void cancel() {
        this.mFunction.cancel();
    }

    @Override // com.tribe.async.reactive.AsyncFunction
    public void apply(final Observer observer) {
        AssertUtils.checkNotNull(observer);
        observer.addObserverFunction(Integer.valueOf(this.mFunction.hashCode()));
        DataPusher dataPusher = this.mUpDataPusher;
        if (dataPusher != null) {
            dataPusher.apply(observer);
        }
        this.mFunction.observe(new StreamFunction.StreamFunctionListener<OUT>() { // from class: com.tribe.async.parallel.ParallelDataPusher.1
            @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
            public void onCancel() {
                observer.onStreamCancel();
            }

            @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
            public void onError(Error error) {
                observer.onOneFunctionErr(Integer.valueOf(ParallelDataPusher.this.mFunction.hashCode()), error);
            }

            @Override // com.tribe.async.reactive.StreamFunction.StreamFunctionListener
            public void onResult(OUT out) {
                observer.onOneFunctionSuc(Integer.valueOf(ParallelDataPusher.this.mFunction.hashCode()), out);
            }
        });
        this.mFunction.apply(this.f386995in);
    }

    public ParallelDataPusher(DataPusher dataPusher, StreamFunction<IN, OUT> streamFunction, IN in5) {
        this.mUpDataPusher = dataPusher;
        this.mFunction = streamFunction;
        this.f386995in = in5;
        AssertUtils.checkNotNull(dataPusher);
        AssertUtils.checkNotNull(streamFunction);
    }
}
