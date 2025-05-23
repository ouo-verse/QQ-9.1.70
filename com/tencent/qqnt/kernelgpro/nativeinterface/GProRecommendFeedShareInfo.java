package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendFeedShareInfo implements Serializable {
    long serialVersionUID;
    public String shareLink;
    public int shareType;

    public GProRecommendFeedShareInfo() {
        this.serialVersionUID = 1L;
        this.shareLink = "";
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public int getShareType() {
        return this.shareType;
    }

    public String toString() {
        return "GProRecommendFeedShareInfo{shareType=" + this.shareType + ",shareLink=" + this.shareLink + ",}";
    }

    public GProRecommendFeedShareInfo(int i3, String str) {
        this.serialVersionUID = 1L;
        this.shareType = i3;
        this.shareLink = str;
    }
}
