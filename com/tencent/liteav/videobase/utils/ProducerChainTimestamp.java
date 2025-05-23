package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.concurrent.atomic.AtomicLong;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class ProducerChainTimestamp {
    private AtomicLong mCaptureTimestamp = new AtomicLong(0);
    private AtomicLong mPreprocessTimestamp = new AtomicLong(0);
    private AtomicLong mEncodeTimestamp = new AtomicLong(0);
    private AtomicLong mEncodeFinishTimestamp = new AtomicLong(0);

    public void copy(ProducerChainTimestamp producerChainTimestamp) {
        this.mCaptureTimestamp = producerChainTimestamp.mCaptureTimestamp;
        this.mPreprocessTimestamp = producerChainTimestamp.mPreprocessTimestamp;
        this.mEncodeTimestamp = producerChainTimestamp.mEncodeTimestamp;
        this.mEncodeFinishTimestamp = producerChainTimestamp.mEncodeFinishTimestamp;
    }

    public long getCaptureTimestamp() {
        return this.mCaptureTimestamp.get();
    }

    public long getEncodeFinishTimestamp() {
        return this.mEncodeFinishTimestamp.get();
    }

    public long getEncodeTimestamp() {
        return this.mEncodeTimestamp.get();
    }

    public long getPreprocessTimestamp() {
        return this.mPreprocessTimestamp.get();
    }

    public void setCaptureTimestamp(long j3) {
        this.mCaptureTimestamp.set(j3);
    }

    public void setEncodeFinishTimestamp(long j3) {
        this.mEncodeFinishTimestamp.set(j3);
    }

    public void setEncodeTimestamp(long j3) {
        this.mEncodeTimestamp.set(j3);
    }

    public void setPreprocessTimestamp(long j3) {
        this.mPreprocessTimestamp.set(j3);
    }
}
