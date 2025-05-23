package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProDiscoveryData implements Serializable {
    public String animationUrl;
    public int playAnimationFlag;
    long serialVersionUID;
    public int useModel;

    public GProDiscoveryData() {
        this.serialVersionUID = 1L;
        this.animationUrl = "";
    }

    public String getAnimationUrl() {
        return this.animationUrl;
    }

    public int getPlayAnimationFlag() {
        return this.playAnimationFlag;
    }

    public int getUseModel() {
        return this.useModel;
    }

    public String toString() {
        return "GProDiscoveryData{useModel=" + this.useModel + ",playAnimationFlag=" + this.playAnimationFlag + ",animationUrl=" + this.animationUrl + ",}";
    }

    public GProDiscoveryData(int i3, int i16, String str) {
        this.serialVersionUID = 1L;
        this.useModel = i3;
        this.playAnimationFlag = i16;
        this.animationUrl = str;
    }
}
