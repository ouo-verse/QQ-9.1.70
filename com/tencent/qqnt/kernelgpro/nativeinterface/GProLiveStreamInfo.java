package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLiveStreamInfo implements Serializable {
    public long anchorId;
    long serialVersionUID = 1;
    public String url = "";
    public String flvUrl = "";

    public long getAnchorId() {
        return this.anchorId;
    }

    public String getFlvUrl() {
        return this.flvUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProLiveStreamInfo{url=" + this.url + ",anchorId=" + this.anchorId + ",flvUrl=" + this.flvUrl + ",}";
    }
}
