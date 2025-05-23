package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProRecommendQuickJoinItem extends Serializable {
    long getChannelId();

    long getGuildId();

    String getJoinSig();

    String getMainSource();

    String getSubSource();

    String toString();
}
