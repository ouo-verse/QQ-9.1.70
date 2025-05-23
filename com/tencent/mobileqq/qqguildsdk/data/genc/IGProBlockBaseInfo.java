package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProBlockBaseInfo extends Serializable {
    IGProRecommendV2Channel getChannel();

    IGProRecommendsV2Feed getFeed();

    IGProRecommendShareInfo getShareInfo();

    int getType();

    String toString();
}
