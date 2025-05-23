package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleChannelInfo;

/* loaded from: classes17.dex */
public class GGProScheduleChannelInfo implements IGProScheduleChannelInfo {
    public final GProScheduleChannelInfo mInfo;

    public GGProScheduleChannelInfo(GProScheduleChannelInfo gProScheduleChannelInfo) {
        this.mInfo = gProScheduleChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleChannelInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleChannelInfo
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleChannelInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleChannelInfo
    public boolean getHasJoin() {
        return this.mInfo.getHasJoin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleChannelInfo
    public boolean getIsPrivate() {
        return this.mInfo.getIsPrivate();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleChannelInfo
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
