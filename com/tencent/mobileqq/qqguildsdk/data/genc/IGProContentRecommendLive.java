package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProContentRecommendLive extends Serializable {
    long getChannelId();

    int getChannelType();

    String getCover();

    long getGuildId();

    IGProFeedGuildInfo getGuildInfo();

    byte[] getJoinSig();

    String getLiveTitle();

    long getRoomId();

    IGProContentRecommendStreamInfo getStreamInfo();

    String toString();
}
