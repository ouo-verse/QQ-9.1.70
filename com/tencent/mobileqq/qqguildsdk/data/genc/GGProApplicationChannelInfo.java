package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProApplicationChannelInfo;

/* loaded from: classes17.dex */
public class GGProApplicationChannelInfo implements IGProApplicationChannelInfo {
    public final GProApplicationChannelInfo mInfo;

    public GGProApplicationChannelInfo(GProApplicationChannelInfo gProApplicationChannelInfo) {
        this.mInfo = gProApplicationChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public String getAppChannelIcon() {
        return this.mInfo.getAppChannelIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public int getAppChannelJumpType() {
        return this.mInfo.getAppChannelJumpType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public String getAppChannelJumpUrl() {
        return this.mInfo.getAppChannelJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public int getAppQyyFlag() {
        return this.mInfo.getAppQyyFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public long getApplicationId() {
        return this.mInfo.getApplicationId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public int getExternalUrlRequestStatus() {
        return this.mInfo.getExternalUrlRequestStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public String getStrAppChannelId() {
        return this.mInfo.getStrAppChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public String getStrJumpSecret() {
        return this.mInfo.getStrJumpSecret();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
