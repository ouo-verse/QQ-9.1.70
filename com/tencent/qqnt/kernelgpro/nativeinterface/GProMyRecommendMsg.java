package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMyRecommendMsg implements Serializable {
    public int businessType;
    public GProDiscoverStatus discoverStatus;
    public int flag;
    public int pointType;
    long serialVersionUID;

    public GProMyRecommendMsg() {
        this.serialVersionUID = 1L;
        this.discoverStatus = new GProDiscoverStatus();
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public GProDiscoverStatus getDiscoverStatus() {
        return this.discoverStatus;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getPointType() {
        return this.pointType;
    }

    public String toString() {
        return "GProMyRecommendMsg{flag=" + this.flag + ",businessType=" + this.businessType + ",discoverStatus=" + this.discoverStatus + ",pointType=" + this.pointType + ",}";
    }

    public GProMyRecommendMsg(int i3, int i16, GProDiscoverStatus gProDiscoverStatus, int i17) {
        this.serialVersionUID = 1L;
        new GProDiscoverStatus();
        this.flag = i3;
        this.businessType = i16;
        this.discoverStatus = gProDiscoverStatus;
        this.pointType = i17;
    }
}
