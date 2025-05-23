package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetRecommendTabContentRsp {
    public GProTabContentCommonRsp commonRsp = new GProTabContentCommonRsp();
    public ArrayList<GProGuild> myGuilds = new ArrayList<>();
    public ArrayList<GProGuild> recentGuilds = new ArrayList<>();
    public GProRecommendCategory featuredCategory = new GProRecommendCategory();
    public ArrayList<GProRecommendItem> featuredGuilds = new ArrayList<>();
    public ArrayList<GProRecommendContentItem> hotActivities = new ArrayList<>();
    public String featuredTitle = "";
    public String hotTitle = "";
    public String featuredSubTitle = "";

    public GProTabContentCommonRsp getCommonRsp() {
        return this.commonRsp;
    }

    public GProRecommendCategory getFeaturedCategory() {
        return this.featuredCategory;
    }

    public ArrayList<GProRecommendItem> getFeaturedGuilds() {
        return this.featuredGuilds;
    }

    public String getFeaturedSubTitle() {
        return this.featuredSubTitle;
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

    public ArrayList<GProGuild> getMyGuilds() {
        return this.myGuilds;
    }

    public ArrayList<GProGuild> getRecentGuilds() {
        return this.recentGuilds;
    }

    public String toString() {
        return "GProGetRecommendTabContentRsp{commonRsp=" + this.commonRsp + ",myGuilds=" + this.myGuilds + ",recentGuilds=" + this.recentGuilds + ",featuredCategory=" + this.featuredCategory + ",featuredGuilds=" + this.featuredGuilds + ",hotActivities=" + this.hotActivities + ",featuredTitle=" + this.featuredTitle + ",hotTitle=" + this.hotTitle + ",featuredSubTitle=" + this.featuredSubTitle + ",}";
    }
}
