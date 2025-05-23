package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTransVideo implements Serializable {
    public String playUrl;
    public int prior;
    public int rate;
    long serialVersionUID;
    public int specification;

    public GProTransVideo() {
        this.serialVersionUID = 1L;
        this.playUrl = "";
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public int getPrior() {
        return this.prior;
    }

    public int getRate() {
        return this.rate;
    }

    public int getSpecification() {
        return this.specification;
    }

    public String toString() {
        return "GProTransVideo{specification=" + this.specification + ",playUrl=" + this.playUrl + ",prior=" + this.prior + ",rate=" + this.rate + ",}";
    }

    public GProTransVideo(int i3, String str, int i16, int i17) {
        this.serialVersionUID = 1L;
        this.specification = i3;
        this.playUrl = str;
        this.prior = i16;
        this.rate = i17;
    }
}
