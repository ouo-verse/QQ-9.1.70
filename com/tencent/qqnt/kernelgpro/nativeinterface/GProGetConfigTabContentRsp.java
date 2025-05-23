package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetConfigTabContentRsp {
    public GProTabContentCommonRsp commonRsp = new GProTabContentCommonRsp();
    public ArrayList<GProRecommendContentItem> bannerConfigList = new ArrayList<>();
    public ArrayList<GProRecommendContentItem> h5kuiklyConfigList = new ArrayList<>();

    public ArrayList<GProRecommendContentItem> getBannerConfigList() {
        return this.bannerConfigList;
    }

    public GProTabContentCommonRsp getCommonRsp() {
        return this.commonRsp;
    }

    public ArrayList<GProRecommendContentItem> getH5kuiklyConfigList() {
        return this.h5kuiklyConfigList;
    }

    public String toString() {
        return "GProGetConfigTabContentRsp{commonRsp=" + this.commonRsp + ",bannerConfigList=" + this.bannerConfigList + ",h5kuiklyConfigList=" + this.h5kuiklyConfigList + ",}";
    }
}
