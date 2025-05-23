package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;

/* loaded from: classes27.dex */
public class ParallelStream {
    private DataPusher mDataPusher;

    ParallelStream() {
    }

    public static <IN, OUT> ParallelStream of(StreamFunction<IN, OUT> streamFunction, IN in5) {
        AssertUtils.checkNotNull(streamFunction);
        ParallelStream parallelStream = new ParallelStream();
        parallelStream.attachDataSupplier(new ParallelDataPusher(streamFunction, in5));
        return parallelStream;
    }

    protected void attachDataSupplier(@NonNull DataPusher dataPusher) {
        this.mDataPusher = dataPusher;
    }

    public void cancel() {
        DataPusher dataPusher = this.mDataPusher;
        if (dataPusher != null) {
            dataPusher.cancel();
            return;
        }
        throw new RuntimeException("Please call attachDataSupplier before cancel.");
    }

    public <IN, OUT> ParallelStream map(StreamFunction<IN, OUT> streamFunction, IN in5) {
        AssertUtils.checkNotNull(streamFunction);
        ParallelStream parallelStream = new ParallelStream();
        parallelStream.attachDataSupplier(new ParallelDataPusher(this.mDataPusher, streamFunction, in5));
        return parallelStream;
    }

    public void subscribe(Observer observer) {
        AssertUtils.checkNotNull(observer);
        DataPusher dataPusher = this.mDataPusher;
        if (dataPusher != null) {
            dataPusher.apply(observer);
            return;
        }
        throw new RuntimeException("Please call attachDataSupplier before subscribe.");
    }
}
