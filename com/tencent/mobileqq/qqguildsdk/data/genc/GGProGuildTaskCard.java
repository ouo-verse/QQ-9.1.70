package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskCard;

/* loaded from: classes17.dex */
public class GGProGuildTaskCard implements IGProGuildTaskCard {
    public final GProGuildTaskCard mInfo;

    public GGProGuildTaskCard(GProGuildTaskCard gProGuildTaskCard) {
        this.mInfo = gProGuildTaskCard;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCard
    public long getTaskId() {
        return this.mInfo.getTaskId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCard
    public IGProGuildTaskCardInfo getTaskInfo() {
        return new GGProGuildTaskCardInfo(this.mInfo.getTaskInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCard
    public IGProGuildTaskCardProgress getTaskProgress() {
        return new GGProGuildTaskCardProgress(this.mInfo.getTaskProgress());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCard
    public String toString() {
        return this.mInfo.toString();
    }
}
