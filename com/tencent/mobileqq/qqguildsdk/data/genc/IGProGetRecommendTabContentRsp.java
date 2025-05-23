package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetRecommendTabContentRsp extends Serializable {
    IGProTabContentCommonRsp getCommonRsp();

    IGProRecommendCategory getFeaturedCategory();

    ArrayList<IGProRecommendItem> getFeaturedGuilds();

    String getFeaturedSubTitle();

    String getFeaturedTitle();

    ArrayList<IGProRecommendContentItem> getHotActivities();

    String getHotTitle();

    ArrayList<IGProGuildInfo> getMyGuilds();

    ArrayList<IGProGuildInfo> getRecentGuilds();

    String toString();
}
