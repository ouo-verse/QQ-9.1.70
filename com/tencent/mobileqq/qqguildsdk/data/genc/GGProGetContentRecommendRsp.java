package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetContentRecommendRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetContentRecommendRsp implements IGProGetContentRecommendRsp {
    public final GProGetContentRecommendRsp mInfo;

    public GGProGetContentRecommendRsp(GProGetContentRecommendRsp gProGetContentRecommendRsp) {
        this.mInfo = gProGetContentRecommendRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp
    public IGProMVPExtInfo getExtInfo() {
        return new GGProMVPExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp
    public IGProNavigationList getNavigation() {
        return new GGProNavigationList(this.mInfo.getNavigation());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp
    public ArrayList<IGProRecommendContentItem> getRecommendList() {
        ArrayList<GProRecommendContentItem> recommendList = this.mInfo.getRecommendList();
        ArrayList<IGProRecommendContentItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendContentItem> it = recommendList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendContentItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetContentRecommendRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
