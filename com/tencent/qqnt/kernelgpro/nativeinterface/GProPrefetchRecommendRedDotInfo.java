package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPrefetchRecommendRedDotInfo implements Serializable {
    public boolean isDisplay;
    long serialVersionUID = 1;

    public GProPrefetchRecommendRedDotInfo() {
    }

    public boolean getIsDisplay() {
        return this.isDisplay;
    }

    public String toString() {
        return "GProPrefetchRecommendRedDotInfo{isDisplay=" + this.isDisplay + ",}";
    }

    public GProPrefetchRecommendRedDotInfo(boolean z16) {
        this.isDisplay = z16;
    }
}
