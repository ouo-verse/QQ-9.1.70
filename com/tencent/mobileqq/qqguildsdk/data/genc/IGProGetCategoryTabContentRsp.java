package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetCategoryTabContentRsp extends Serializable {
    IGProTabContentCommonRsp getCommonRsp();

    IGProRecommendCategory getFeaturedCategory();

    ArrayList<IGProRecommendItem> getFeaturedGuilds();

    String getFeaturedTitle();

    ArrayList<IGProRecommendContentItem> getHotActivities();

    String getHotTitle();

    String toString();
}
