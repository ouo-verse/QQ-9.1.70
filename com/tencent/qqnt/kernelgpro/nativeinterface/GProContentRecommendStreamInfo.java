package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentRecommendStreamInfo implements Serializable {
    long serialVersionUID = 1;
    public String rtmpUrl = "";
    public String flvUrl = "";

    public String getFlvUrl() {
        return this.flvUrl;
    }

    public String getRtmpUrl() {
        return this.rtmpUrl;
    }

    public String toString() {
        return "GProContentRecommendStreamInfo{rtmpUrl=" + this.rtmpUrl + ",flvUrl=" + this.flvUrl + ",}";
    }
}
