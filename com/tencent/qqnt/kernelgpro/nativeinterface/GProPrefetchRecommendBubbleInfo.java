package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPrefetchRecommendBubbleInfo implements Serializable {
    public boolean isDisplay;
    long serialVersionUID;
    public String tips;

    public GProPrefetchRecommendBubbleInfo() {
        this.serialVersionUID = 1L;
        this.tips = "";
    }

    public boolean getIsDisplay() {
        return this.isDisplay;
    }

    public String getTips() {
        return this.tips;
    }

    public String toString() {
        return "GProPrefetchRecommendBubbleInfo{isDisplay=" + this.isDisplay + ",tips=" + this.tips + ",}";
    }

    public GProPrefetchRecommendBubbleInfo(boolean z16, String str) {
        this.serialVersionUID = 1L;
        this.isDisplay = z16;
        this.tips = str;
    }
}
