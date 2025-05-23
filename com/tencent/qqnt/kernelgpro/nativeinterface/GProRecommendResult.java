package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRecommendResult {
    public int type;
    public GProRecommendInfo recommendInfo = new GProRecommendInfo();
    public GProRecommendGroupInfo recommendGroupInfo = new GProRecommendGroupInfo();
    public GProRecommendCardInfo recommendCardInfo = new GProRecommendCardInfo();

    public GProRecommendCardInfo getRecommendCardInfo() {
        return this.recommendCardInfo;
    }

    public GProRecommendGroupInfo getRecommendGroupInfo() {
        return this.recommendGroupInfo;
    }

    public GProRecommendInfo getRecommendInfo() {
        return this.recommendInfo;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendResult{recommendInfo=" + this.recommendInfo + ",recommendGroupInfo=" + this.recommendGroupInfo + ",type=" + this.type + ",recommendCardInfo=" + this.recommendCardInfo + ",}";
    }
}
