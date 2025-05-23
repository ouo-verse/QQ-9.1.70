package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchFeedGroupInfo;

/* loaded from: classes17.dex */
public class GGProGuildSearchFeedGroupInfo implements IGProGuildSearchFeedGroupInfo {
    public final GProGuildSearchFeedGroupInfo mInfo;

    public GGProGuildSearchFeedGroupInfo(GProGuildSearchFeedGroupInfo gProGuildSearchFeedGroupInfo) {
        this.mInfo = gProGuildSearchFeedGroupInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo
    public long getFeedCnt() {
        return this.mInfo.getFeedCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
