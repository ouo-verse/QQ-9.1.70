package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGetRecommendV2Rsp implements Serializable {
    public GProBannerBlockList banners;
    public byte[] cookies;
    public int discoverType;
    public GProRecommendExtInfo extInfo;
    public GProPopBlockList popups;
    long serialVersionUID;
    public GProRecommendV2TracksBlockList tracks;

    public GProGetRecommendV2Rsp() {
        this.serialVersionUID = 1L;
        this.banners = new GProBannerBlockList();
        this.tracks = new GProRecommendV2TracksBlockList();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
        this.popups = new GProPopBlockList();
    }

    public GProBannerBlockList getBanners() {
        return this.banners;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getDiscoverType() {
        return this.discoverType;
    }

    public GProRecommendExtInfo getExtInfo() {
        return this.extInfo;
    }

    public GProPopBlockList getPopups() {
        return this.popups;
    }

    public GProRecommendV2TracksBlockList getTracks() {
        return this.tracks;
    }

    public String toString() {
        return "GProGetRecommendV2Rsp{discoverType=" + this.discoverType + ",banners=" + this.banners + ",tracks=" + this.tracks + ",extInfo=" + this.extInfo + ",cookies=" + this.cookies + ",popups=" + this.popups + ",}";
    }

    public GProGetRecommendV2Rsp(int i3, GProBannerBlockList gProBannerBlockList, GProRecommendV2TracksBlockList gProRecommendV2TracksBlockList, GProRecommendExtInfo gProRecommendExtInfo, byte[] bArr, GProPopBlockList gProPopBlockList) {
        this.serialVersionUID = 1L;
        this.banners = new GProBannerBlockList();
        this.tracks = new GProRecommendV2TracksBlockList();
        this.extInfo = new GProRecommendExtInfo();
        this.cookies = new byte[0];
        new GProPopBlockList();
        this.discoverType = i3;
        this.banners = gProBannerBlockList;
        this.tracks = gProRecommendV2TracksBlockList;
        this.extInfo = gProRecommendExtInfo;
        this.cookies = bArr;
        this.popups = gProPopBlockList;
    }
}
