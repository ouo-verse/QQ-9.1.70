package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProScheduleChannelInfo extends Serializable {
    long getChannelId();

    String getChannelName();

    long getGuildId();

    boolean getHasJoin();

    boolean getIsPrivate();

    int getType();

    String toString();
}
