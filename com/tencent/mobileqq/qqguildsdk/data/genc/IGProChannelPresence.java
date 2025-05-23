package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProChannelPresence extends Serializable {
    long getChannelId();

    int getChannelType();

    String getCurrentMemberNum();

    IGProGuildLiveInfo getGuildLiveInfo();

    ArrayList<IGProChannelPresenceMemberInfo> getMemberInfos();

    IGProVoicePresence0x11bc getVoicePresence();

    String toString();
}
