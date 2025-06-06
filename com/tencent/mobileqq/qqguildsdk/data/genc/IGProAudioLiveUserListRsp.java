package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAudioLiveUserListRsp extends Serializable {
    IAudioChannelMemberInfos getChannelMemberInfo();

    IGProChannelUserNum getChannelUserNum();

    IAudioChannelMemberInfos getHandUpMemberInfo();

    boolean getIsEndPage();

    long getNextReadInterval();

    IAudioChannelMemberInfos getSpeakOrderMemberInfo();

    String toString();
}
