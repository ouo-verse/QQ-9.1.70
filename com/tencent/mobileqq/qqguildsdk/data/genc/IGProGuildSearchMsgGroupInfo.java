package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildSearchMsgGroupInfo extends Serializable {
    long getChannelId();

    String getChannelName();

    IGProGuildSearchGuildMsg getData();

    long getGuildId();

    long getMsgCnt();

    String getSummary();

    String toString();
}
