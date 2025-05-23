package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetHotLiveRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetHotLiveRsp implements IGProGetHotLiveRsp {
    public final GProGetHotLiveRsp mInfo;

    public GGProGetHotLiveRsp(GProGetHotLiveRsp gProGetHotLiveRsp) {
        this.mInfo = gProGetHotLiveRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotLiveRsp
    public byte[] getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotLiveRsp
    public IGProRecommendExtInfo getExtInfo() {
        return new GGProRecommendExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotLiveRsp
    public ArrayList<IGProRecommendItem> getRecommendList() {
        ArrayList<GProRecommendItem> recommendList = this.mInfo.getRecommendList();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = recommendList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotLiveRsp
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetHotLiveRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
