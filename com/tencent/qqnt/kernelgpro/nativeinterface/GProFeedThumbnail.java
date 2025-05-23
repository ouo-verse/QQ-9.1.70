package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProFeedThumbnail implements Serializable {
    public boolean isVideoCover;
    long serialVersionUID = 1;
    public String url = "";

    public boolean getIsVideoCover() {
        return this.isVideoCover;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProFeedThumbnail{url=" + this.url + ",isVideoCover=" + this.isVideoCover + ",}";
    }
}
