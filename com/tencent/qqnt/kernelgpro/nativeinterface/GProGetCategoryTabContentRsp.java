package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetCategoryTabContentRsp {
    public GProTabContentCommonRsp commonRsp = new GProTabContentCommonRsp();
    public String featuredTitle = "";
    public GProRecommendCategory featuredCategory = new GProRecommendCategory();
    public ArrayList<GProRecommendItem> featuredGuilds = new ArrayList<>();
    public String hotTitle = "";
    public ArrayList<GProRecommendContentItem> hotActivities = new ArrayList<>();

    public GProTabContentCommonRsp getCommonRsp() {
        return this.commonRsp;
    }

    public GProRecommendCategory getFeaturedCategory() {
        return this.featuredCategory;
    }

    public ArrayList<GProRecommendItem> getFeaturedGuilds() {
        return this.featuredGuilds;
    }

    public String getFeaturedTitle() {
        return this.featuredTitle;
    }

    public ArrayList<GProRecommendContentItem> getHotActivities() {
        return this.hotActivities;
    }

    public String getHotTitle() {
        return this.hotTitle;
    }

    public String toString() {
        return "GProGetCategoryTabContentRsp{commonRsp=" + this.commonRsp + ",featuredTitle=" + this.featuredTitle + ",featuredCategory=" + this.featuredCategory + ",featuredGuilds=" + this.featuredGuilds + ",hotTitle=" + this.hotTitle + ",hotActivities=" + this.hotActivities + ",}";
    }
}
