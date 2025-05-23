package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProVoiceChannelInfo implements Serializable {
    public int actualMaxNum;
    public int allowOtherRaiseHand;
    public int inviteSpeakState;
    public int memberMaxNum;
    public int noMemberMaxLimit;
    long serialVersionUID = 1;
    public int speakMode;
    public int speakSecond;
    public int voiceQueueState;
    public int voicingControlMode;

    public int getActualMaxNum() {
        return this.actualMaxNum;
    }

    public int getAllowOtherRaiseHand() {
        return this.allowOtherRaiseHand;
    }

    public int getInviteSpeakState() {
        return this.inviteSpeakState;
    }

    public int getMemberMaxNum() {
        return this.memberMaxNum;
    }

    public int getNoMemberMaxLimit() {
        return this.noMemberMaxLimit;
    }

    public int getSpeakMode() {
        return this.speakMode;
    }

    public int getSpeakSecond() {
        return this.speakSecond;
    }

    public int getVoiceQueueState() {
        return this.voiceQueueState;
    }

    public int getVoicingControlMode() {
        return this.voicingControlMode;
    }

    public String toString() {
        return "GProVoiceChannelInfo{memberMaxNum=" + this.memberMaxNum + ",voicingControlMode=" + this.voicingControlMode + ",allowOtherRaiseHand=" + this.allowOtherRaiseHand + ",noMemberMaxLimit=" + this.noMemberMaxLimit + ",actualMaxNum=" + this.actualMaxNum + ",speakMode=" + this.speakMode + ",speakSecond=" + this.speakSecond + ",voiceQueueState=" + this.voiceQueueState + ",inviteSpeakState=" + this.inviteSpeakState + ",}";
    }
}
