package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecommendTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetRecommendTabContentRsp implements IGProGetRecommendTabContentRsp {
    public final GProGetRecommendTabContentRsp mInfo;

    public GGProGetRecommendTabContentRsp(GProGetRecommendTabContentRsp gProGetRecommendTabContentRsp) {
        this.mInfo = gProGetRecommendTabContentRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public IGProTabContentCommonRsp getCommonRsp() {
        return new GGProTabContentCommonRsp(this.mInfo.getCommonRsp());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public IGProRecommendCategory getFeaturedCategory() {
        return new GGProRecommendCategory(this.mInfo.getFeaturedCategory());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public ArrayList<IGProRecommendItem> getFeaturedGuilds() {
        ArrayList<GProRecommendItem> featuredGuilds = this.mInfo.getFeaturedGuilds();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = featuredGuilds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public String getFeaturedSubTitle() {
        return this.mInfo.getFeaturedSubTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public String getFeaturedTitle() {
        return this.mInfo.getFeaturedTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public ArrayList<IGProRecommendContentItem> getHotActivities() {
        ArrayList<GProRecommendContentItem> hotActivities = this.mInfo.getHotActivities();
        ArrayList<IGProRecommendContentItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendContentItem> it = hotActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendContentItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public String getHotTitle() {
        return this.mInfo.getHotTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public ArrayList<IGProGuildInfo> getMyGuilds() {
        ArrayList<GProGuild> myGuilds = this.mInfo.getMyGuilds();
        ArrayList<IGProGuildInfo> arrayList = new ArrayList<>();
        Iterator<GProGuild> it = myGuilds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public ArrayList<IGProGuildInfo> getRecentGuilds() {
        ArrayList<GProGuild> recentGuilds = this.mInfo.getRecentGuilds();
        ArrayList<IGProGuildInfo> arrayList = new ArrayList<>();
        Iterator<GProGuild> it = recentGuilds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTabContentRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
