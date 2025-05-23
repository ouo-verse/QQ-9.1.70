package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProFeed implements Serializable {
    public String feedId;
    long serialVersionUID;

    public GProFeed() {
        this.serialVersionUID = 1L;
        this.feedId = "";
    }

    public String getFeedId() {
        return this.feedId;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public String toString() {
        return "GProFeed{feedId=" + this.feedId + ",}";
    }

    public GProFeed(String str) {
        this.serialVersionUID = 1L;
        this.feedId = str;
    }
}
