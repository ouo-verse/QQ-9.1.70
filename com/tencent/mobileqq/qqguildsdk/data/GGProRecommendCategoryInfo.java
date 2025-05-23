package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCategoryInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProRecommendCategoryInfo implements IGProRecommendCategoryInfo {
    public final GProRecommendCategoryInfo mInfo;

    public GGProRecommendCategoryInfo(GProRecommendCategoryInfo gProRecommendCategoryInfo) {
        this.mInfo = gProRecommendCategoryInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendCategoryInfo
    public long getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendCategoryInfo
    public int getCategoryIndex() {
        return this.mInfo.getCategoryIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendCategoryInfo
    public String getCategoryName() {
        return this.mInfo.getCategoryName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendCategoryInfo
    public ArrayList<IGProChannel> getChannelInfoList() {
        ArrayList<GProChannel> channelInfoList = this.mInfo.getChannelInfoList();
        ArrayList<IGProChannel> arrayList = new ArrayList<>();
        Iterator<GProChannel> it = channelInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannel(it.next()));
        }
        return arrayList;
    }
}
