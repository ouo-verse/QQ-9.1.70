package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProFetchRecommendChannelRsp extends Serializable {
    long getChannelId();

    String getChannelName();

    String getGuildCoverUrl();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    String getGuildProfile();
}
