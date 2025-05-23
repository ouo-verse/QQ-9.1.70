package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAVUserStateChangeInfo extends Serializable {
    String getChannelId();

    String getGuildId();

    IGProAVShowMsgInfo getIGProAVShowMsgInfo();

    String getMsg();

    long getTinyId();

    es getUserCtlInfo();
}
