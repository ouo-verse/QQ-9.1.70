package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStVideoUrl implements Serializable {
    public boolean hasWatermark;
    public int levelType;
    public int transStatus;
    public int videoPrior;
    public int videoRate;
    long serialVersionUID = 1;
    public String playUrl = "";
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public boolean getHasWatermark() {
        return this.hasWatermark;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public int getTransStatus() {
        return this.transStatus;
    }

    public int getVideoPrior() {
        return this.videoPrior;
    }

    public int getVideoRate() {
        return this.videoRate;
    }

    public String toString() {
        return "GProStVideoUrl{levelType=" + this.levelType + ",playUrl=" + this.playUrl + ",videoPrior=" + this.videoPrior + ",videoRate=" + this.videoRate + ",transStatus=" + this.transStatus + ",busiData=" + this.busiData + ",hasWatermark=" + this.hasWatermark + ",}";
    }
}
