package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelMedalInfo;

/* loaded from: classes17.dex */
public class GGProChannelMedalInfo implements IGProChannelMedalInfo {
    public final GProChannelMedalInfo mInfo;

    public GGProChannelMedalInfo(GProChannelMedalInfo gProChannelMedalInfo) {
        this.mInfo = gProChannelMedalInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelMedalInfo
    public long getExpireTime() {
        return this.mInfo.getExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelMedalInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelMedalInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelMedalInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
