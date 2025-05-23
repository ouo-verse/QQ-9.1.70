package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProCmd0xf5dGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildTaskJoinChannelRsp extends Serializable {
    long getChannelId();

    IGProCmd0xf5dGuildInfo getGuildChannels();

    long getGuildId();

    IGProGuildInfo getGuildInfo();

    String toString();
}
