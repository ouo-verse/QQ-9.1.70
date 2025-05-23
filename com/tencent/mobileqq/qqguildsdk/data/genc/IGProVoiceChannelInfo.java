package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProVoiceChannelInfo extends Serializable {
    int getActualMaxNum();

    int getAllowOtherRaiseHand();

    int getInviteSpeakState();

    int getMemberMaxNum();

    int getNoMemberMaxLimit();

    int getSpeakMode();

    int getSpeakSecond();

    int getVoiceQueueState();

    int getVoicingControlMode();

    String toString();
}
