package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskCardInfo;

/* loaded from: classes17.dex */
public class GGProGuildTaskCardInfo implements IGProGuildTaskCardInfo {
    public final GProGuildTaskCardInfo mInfo;

    public GGProGuildTaskCardInfo(GProGuildTaskCardInfo gProGuildTaskCardInfo) {
        this.mInfo = gProGuildTaskCardInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public String getBackgroundImg() {
        return this.mInfo.getBackgroundImg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public IGProGuildTaskCardText getButton() {
        return new GGProGuildTaskCardText(this.mInfo.getButton());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public String getIconImg() {
        return this.mInfo.getIconImg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public IGProGuildTaskCardLineText getMainTitle() {
        return new GGProGuildTaskCardLineText(this.mInfo.getMainTitle());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public IGProGuildTaskCardLineText getProgressComment() {
        return new GGProGuildTaskCardLineText(this.mInfo.getProgressComment());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public IGProGuildTaskCardLineText getSubTitle() {
        return new GGProGuildTaskCardLineText(this.mInfo.getSubTitle());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public int getTaskType() {
        return this.mInfo.getTaskType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
