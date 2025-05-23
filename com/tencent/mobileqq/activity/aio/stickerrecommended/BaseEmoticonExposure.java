package com.tencent.mobileqq.activity.aio.stickerrecommended;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseEmoticonExposure implements IEmoticonExposure {
    private long mStartExposed;
    private long mTotalExposedTime;

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonExposure
    public void endExposed(long j3) {
        long j16 = this.mStartExposed;
        if (j16 != 0) {
            this.mTotalExposedTime += j3 - j16;
            this.mStartExposed = 0L;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonExposure
    public long exposedTime() {
        return this.mTotalExposedTime;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonExposure
    public void startExposed(long j3) {
        this.mStartExposed = j3;
    }
}
