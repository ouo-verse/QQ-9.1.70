package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ResumePausedTasksAfterDeviceStatusReq {
    public FlashTransferPauseReason pauseReason = FlashTransferPauseReason.values()[0];
    public int seq;

    public FlashTransferPauseReason getPauseReason() {
        return this.pauseReason;
    }

    public int getSeq() {
        return this.seq;
    }
}
