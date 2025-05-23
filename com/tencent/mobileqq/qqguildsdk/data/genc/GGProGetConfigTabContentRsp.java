package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetConfigTabContentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetConfigTabContentRsp implements IGProGetConfigTabContentRsp {
    public final GProGetConfigTabContentRsp mInfo;

    public GGProGetConfigTabContentRsp(GProGetConfigTabContentRsp gProGetConfigTabContentRsp) {
        this.mInfo = gProGetConfigTabContentRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetConfigTabContentRsp
    public ArrayList<IGProRecommendContentItem> getBannerConfigList() {
        ArrayList<GProRecommendContentItem> bannerConfigList = this.mInfo.getBannerConfigList();
        ArrayList<IGProRecommendContentItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendContentItem> it = bannerConfigList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendContentItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetConfigTabContentRsp
    public IGProTabContentCommonRsp getCommonRsp() {
        return new GGProTabContentCommonRsp(this.mInfo.getCommonRsp());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetConfigTabContentRsp
    public ArrayList<IGProRecommendContentItem> getH5kuiklyConfigList() {
        ArrayList<GProRecommendContentItem> h5kuiklyConfigList = this.mInfo.getH5kuiklyConfigList();
        ArrayList<IGProRecommendContentItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendContentItem> it = h5kuiklyConfigList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendContentItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetConfigTabContentRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
