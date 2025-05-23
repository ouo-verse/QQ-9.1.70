package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentRecommendSchema implements Serializable {
    long serialVersionUID = 1;
    public String cover = "";
    public String jumpUrl = "";

    public String getCover() {
        return this.cover;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String toString() {
        return "GProContentRecommendSchema{cover=" + this.cover + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
