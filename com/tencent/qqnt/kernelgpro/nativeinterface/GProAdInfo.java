package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAdInfo implements Serializable {
    public int adId;
    public int adType;
    public String jumpUrl;
    public String picUrl;
    long serialVersionUID;
    public String subTitle;
    public String tag;
    public String title;

    public GProAdInfo() {
        this.serialVersionUID = 1L;
        this.title = "";
        this.subTitle = "";
        this.tag = "";
        this.picUrl = "";
        this.jumpUrl = "";
    }

    public int getAdId() {
        return this.adId;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProAdInfo{title=" + this.title + ",subTitle=" + this.subTitle + ",tag=" + this.tag + ",picUrl=" + this.picUrl + ",jumpUrl=" + this.jumpUrl + ",adId=" + this.adId + ",adType=" + this.adType + ",}";
    }

    public GProAdInfo(String str, String str2, String str3, String str4, String str5, int i3, int i16) {
        this.serialVersionUID = 1L;
        this.title = str;
        this.subTitle = str2;
        this.tag = str3;
        this.picUrl = str4;
        this.jumpUrl = str5;
        this.adId = i3;
        this.adType = i16;
    }
}
