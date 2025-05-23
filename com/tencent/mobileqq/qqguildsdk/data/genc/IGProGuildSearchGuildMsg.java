package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildSearchGuildMsg extends Serializable {
    String getAvatar();

    long getChannelId();

    long getGuildId();

    long getMsgSeq();

    String getMsgTxt();

    String getNickName();

    String getPic();

    long getTimeStamp();

    long getTinyId();

    int getUserType();

    String getVideo();

    String toString();
}
