package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendLive;

/* loaded from: classes17.dex */
public class GGProContentRecommendLive implements IGProContentRecommendLive {
    public final GProContentRecommendLive mInfo;

    public GGProContentRecommendLive(GProContentRecommendLive gProContentRecommendLive) {
        this.mInfo = gProContentRecommendLive;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public IGProFeedGuildInfo getGuildInfo() {
        return new GGProFeedGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public byte[] getJoinSig() {
        return this.mInfo.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public String getLiveTitle() {
        return this.mInfo.getLiveTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public IGProContentRecommendStreamInfo getStreamInfo() {
        return new GGProContentRecommendStreamInfo(this.mInfo.getStreamInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public String toString() {
        return this.mInfo.toString();
    }
}
