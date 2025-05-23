package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVUserStateChangeInfo;

/* loaded from: classes17.dex */
public class GGProAVUserStateChangeInfo implements IGProAVUserStateChangeInfo {
    public final GProAVUserStateChangeInfo mInfo;

    public GGProAVUserStateChangeInfo(GProAVUserStateChangeInfo gProAVUserStateChangeInfo) {
        this.mInfo = gProAVUserStateChangeInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo
    public String getChannelId() {
        return String.valueOf(this.mInfo.getChannelId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo
    public String getGuildId() {
        return String.valueOf(this.mInfo.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo
    public IGProAVShowMsgInfo getIGProAVShowMsgInfo() {
        return new GGProAVShowMsgInfo(this.mInfo.getShowInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo
    public es getUserCtlInfo() {
        return new q(this.mInfo.getUserCtlInfo());
    }
}
