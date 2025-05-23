package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.ChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendVoiceChannel;

/* loaded from: classes17.dex */
public class GGProRecommendVoiceChannel implements IGProRecommendVoiceChannel {
    public final GProRecommendVoiceChannel mInfo;

    public GGProRecommendVoiceChannel(GProRecommendVoiceChannel gProRecommendVoiceChannel) {
        this.mInfo = gProRecommendVoiceChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendVoiceChannel
    public IGProRecommendCoverInfo getCover() {
        return new GGProRecommendCoverInfo(this.mInfo.getCover());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendVoiceChannel
    public IAudioChannelMemberInfos getVoiceChannel() {
        return new ChannelMemberInfos(this.mInfo.getVoiceChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendVoiceChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
