package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceChannelInfo;

/* loaded from: classes17.dex */
public class GGProVoiceChannelInfo implements IGProVoiceChannelInfo {
    public final GProVoiceChannelInfo mInfo;

    public GGProVoiceChannelInfo(GProVoiceChannelInfo gProVoiceChannelInfo) {
        this.mInfo = gProVoiceChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getActualMaxNum() {
        return this.mInfo.getActualMaxNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getAllowOtherRaiseHand() {
        return this.mInfo.getAllowOtherRaiseHand();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getInviteSpeakState() {
        return this.mInfo.getInviteSpeakState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getMemberMaxNum() {
        return this.mInfo.getMemberMaxNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getNoMemberMaxLimit() {
        return this.mInfo.getNoMemberMaxLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getSpeakMode() {
        return this.mInfo.getSpeakMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getSpeakSecond() {
        return this.mInfo.getSpeakSecond();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getVoiceQueueState() {
        return this.mInfo.getVoiceQueueState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public int getVoicingControlMode() {
        return this.mInfo.getVoicingControlMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
