package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchUploadConfig {
    public boolean isDisableBdhUpload;
    public boolean isDisableQuicUpload;
    public boolean isStopOnNotWifi;
    public int maxConcurrentCount;
    public BatchUploadStrategy strategy = BatchUploadStrategy.values()[0];
    public BatchUploadBusinessConfig bizConfig = new BatchUploadBusinessConfig();

    public BatchUploadBusinessConfig getBizConfig() {
        return this.bizConfig;
    }

    public boolean getIsDisableBdhUpload() {
        return this.isDisableBdhUpload;
    }

    public boolean getIsDisableQuicUpload() {
        return this.isDisableQuicUpload;
    }

    public boolean getIsStopOnNotWifi() {
        return this.isStopOnNotWifi;
    }

    public int getMaxConcurrentCount() {
        return this.maxConcurrentCount;
    }

    public BatchUploadStrategy getStrategy() {
        return this.strategy;
    }
}
