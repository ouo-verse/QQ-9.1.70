package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProNewUserGuideData implements Serializable {
    public String animationUrl;
    long serialVersionUID;
    public int tabExposeFlag;

    public GProNewUserGuideData() {
        this.serialVersionUID = 1L;
        this.animationUrl = "";
    }

    public String getAnimationUrl() {
        return this.animationUrl;
    }

    public int getTabExposeFlag() {
        return this.tabExposeFlag;
    }

    public String toString() {
        return "GProNewUserGuideData{animationUrl=" + this.animationUrl + ",tabExposeFlag=" + this.tabExposeFlag + ",}";
    }

    public GProNewUserGuideData(String str, int i3) {
        this.serialVersionUID = 1L;
        this.animationUrl = str;
        this.tabExposeFlag = i3;
    }
}
