package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendVoice;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProContentRecommendVoice implements IGProContentRecommendVoice {
    public final GProContentRecommendVoice mInfo;

    public GGProContentRecommendVoice(GProContentRecommendVoice gProContentRecommendVoice) {
        this.mInfo = gProContentRecommendVoice;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public IGProFeedGuildInfo getGuildInfo() {
        return new GGProFeedGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public byte[] getJoinSig() {
        return this.mInfo.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public ArrayList<String> getMemberAvatarList() {
        return this.mInfo.getMemberAvatarList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public IGProContentRecommendStreamInfo getScreenStreamUrl() {
        return new GGProContentRecommendStreamInfo(this.mInfo.getScreenStreamUrl());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public String getThemeSessionId() {
        return this.mInfo.getThemeSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public int getThemeType() {
        return this.mInfo.getThemeType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public String getVoiceTitle() {
        return this.mInfo.getVoiceTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendVoice
    public String toString() {
        return this.mInfo.toString();
    }
}
