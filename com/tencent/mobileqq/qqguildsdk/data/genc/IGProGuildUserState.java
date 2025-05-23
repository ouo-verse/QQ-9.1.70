package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildUserState extends Serializable {
    long getChannelId();

    long getGuildId();

    boolean getHasEnteredChannel();

    String toString();
}
