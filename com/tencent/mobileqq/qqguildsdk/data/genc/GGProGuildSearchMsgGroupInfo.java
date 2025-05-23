package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchMsgGroupInfo;

/* loaded from: classes17.dex */
public class GGProGuildSearchMsgGroupInfo implements IGProGuildSearchMsgGroupInfo {
    public final GProGuildSearchMsgGroupInfo mInfo;

    public GGProGuildSearchMsgGroupInfo(GProGuildSearchMsgGroupInfo gProGuildSearchMsgGroupInfo) {
        this.mInfo = gProGuildSearchMsgGroupInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchMsgGroupInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchMsgGroupInfo
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchMsgGroupInfo
    public IGProGuildSearchGuildMsg getData() {
        return new GGProGuildSearchGuildMsg(this.mInfo.getData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchMsgGroupInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchMsgGroupInfo
    public long getMsgCnt() {
        return this.mInfo.getMsgCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchMsgGroupInfo
    public String getSummary() {
        return this.mInfo.getSummary();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchMsgGroupInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
