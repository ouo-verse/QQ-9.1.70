package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProUserChannelStateInfo extends Serializable {
    long getChannelId();

    long getGuildId();

    int getPlatform();

    long getTinyId();

    int getUserState();

    long getUserStateSeq();
}
