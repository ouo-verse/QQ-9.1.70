package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProUserGiftRankInfo extends Serializable {
    long getChannelId();

    long getGuildId();

    String getJumpUrl();

    String getRankInfo();

    int getTopNum();

    IGProUser getUserInfo();
}
