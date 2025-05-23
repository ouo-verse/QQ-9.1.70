package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProPollingData extends Serializable {
    long getChannelId();

    byte[] getCookie();

    ArrayList<fe> getFeedMsgAbstracts();

    boolean getForcePolling();

    long getGuildId();

    IGProLiveResultItem getLiveResultItem();

    ArrayList<fe> getMsgAbstracts();

    int getType();

    long getUpdateTime();

    long getVersion();

    IAudioChannelMemberInfos getVoiceChannel();
}
