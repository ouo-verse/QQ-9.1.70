package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetBannersRsp {
    public ArrayList<GProBannerInfo> bannerInfos;

    public GProGetBannersRsp() {
        this.bannerInfos = new ArrayList<>();
    }

    public ArrayList<GProBannerInfo> getBannerInfos() {
        return this.bannerInfos;
    }

    public String toString() {
        return "GProGetBannersRsp{bannerInfos=" + this.bannerInfos + ",}";
    }

    public GProGetBannersRsp(ArrayList<GProBannerInfo> arrayList) {
        new ArrayList();
        this.bannerInfos = arrayList;
    }
}
