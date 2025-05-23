package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBannerInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetBannersRsp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetBannersRsp implements IGProGetBannersRsp {
    public final GProGetBannersRsp mInfo;

    public GGProGetBannersRsp(GProGetBannersRsp gProGetBannersRsp) {
        this.mInfo = gProGetBannersRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBannersRsp
    public ArrayList<IGProBannerInfo> getBannerInfos() {
        ArrayList<GProBannerInfo> bannerInfos = this.mInfo.getBannerInfos();
        ArrayList<IGProBannerInfo> arrayList = new ArrayList<>();
        Iterator<GProBannerInfo> it = bannerInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBannerInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBannersRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
