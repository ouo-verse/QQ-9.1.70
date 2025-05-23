package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendCoverInfo implements Serializable {
    public String flvStreamUrl;
    public String imageUrl;
    long serialVersionUID;
    public String streamUrl;
    public int type;

    public GProRecommendCoverInfo() {
        this.serialVersionUID = 1L;
        this.imageUrl = "";
        this.streamUrl = "";
        this.flvStreamUrl = "";
    }

    public String getFlvStreamUrl() {
        return this.flvStreamUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getStreamUrl() {
        return this.streamUrl;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendCoverInfo{type=" + this.type + ",imageUrl=" + this.imageUrl + ",streamUrl=" + this.streamUrl + ",flvStreamUrl=" + this.flvStreamUrl + ",}";
    }

    public GProRecommendCoverInfo(int i3, String str, String str2, String str3) {
        this.serialVersionUID = 1L;
        this.type = i3;
        this.imageUrl = str;
        this.streamUrl = str2;
        this.flvStreamUrl = str3;
    }
}
