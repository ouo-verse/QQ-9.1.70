package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskCardProgress;

/* loaded from: classes17.dex */
public class GGProGuildTaskCardProgress implements IGProGuildTaskCardProgress {
    public final GProGuildTaskCardProgress mInfo;

    public GGProGuildTaskCardProgress(GProGuildTaskCardProgress gProGuildTaskCardProgress) {
        this.mInfo = gProGuildTaskCardProgress;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardProgress
    public int getCurState() {
        return this.mInfo.getCurState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardProgress
    public long getCurStatus() {
        return this.mInfo.getCurStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardProgress
    public long getRequireStatus() {
        return this.mInfo.getRequireStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardProgress
    public String toString() {
        return this.mInfo.toString();
    }
}
