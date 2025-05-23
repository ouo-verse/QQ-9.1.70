package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetCategoryTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetCategoryTabContentRsp implements IGProGetCategoryTabContentRsp {
    public final GProGetCategoryTabContentRsp mInfo;

    public GGProGetCategoryTabContentRsp(GProGetCategoryTabContentRsp gProGetCategoryTabContentRsp) {
        this.mInfo = gProGetCategoryTabContentRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp
    public IGProTabContentCommonRsp getCommonRsp() {
        return new GGProTabContentCommonRsp(this.mInfo.getCommonRsp());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp
    public IGProRecommendCategory getFeaturedCategory() {
        return new GGProRecommendCategory(this.mInfo.getFeaturedCategory());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp
    public ArrayList<IGProRecommendItem> getFeaturedGuilds() {
        ArrayList<GProRecommendItem> featuredGuilds = this.mInfo.getFeaturedGuilds();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = featuredGuilds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp
    public String getFeaturedTitle() {
        return this.mInfo.getFeaturedTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp
    public ArrayList<IGProRecommendContentItem> getHotActivities() {
        ArrayList<GProRecommendContentItem> hotActivities = this.mInfo.getHotActivities();
        ArrayList<IGProRecommendContentItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendContentItem> it = hotActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendContentItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp
    public String getHotTitle() {
        return this.mInfo.getHotTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryTabContentRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
