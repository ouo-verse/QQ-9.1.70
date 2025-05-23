package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class ConsumerChainTimestamp {
    private AtomicLong mDeliverTimestamp = new AtomicLong(0);
    private AtomicLong mDecodeFinishTimestamp = new AtomicLong(0);
    private AtomicLong mRenderFinishTimestamp = new AtomicLong(0);

    public void copy(ConsumerChainTimestamp consumerChainTimestamp) {
        this.mDeliverTimestamp = consumerChainTimestamp.mDeliverTimestamp;
        this.mDecodeFinishTimestamp = consumerChainTimestamp.mDecodeFinishTimestamp;
        this.mRenderFinishTimestamp = consumerChainTimestamp.mRenderFinishTimestamp;
    }

    public long getDecodeFinishTimestamp() {
        return this.mDecodeFinishTimestamp.get();
    }

    public long getDeliverTimestamp() {
        return this.mDeliverTimestamp.get();
    }

    public long getRenderFinishTimestamp() {
        return this.mRenderFinishTimestamp.get();
    }

    public void setDecodeFinishTimestamp(long j3) {
        this.mDecodeFinishTimestamp.set(j3);
    }

    public void setDeliverTimestamp(long j3) {
        this.mDeliverTimestamp.set(j3);
    }

    public void setRenderFinishTimestamp(long j3) {
        this.mRenderFinishTimestamp.set(j3);
    }
}
