package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStGuidePublishBubble {
    public String idd = "";
    public GProStImage backgroundImage = new GProStImage();
    public String jumpUrl = "";

    public GProStImage getBackgroundImage() {
        return this.backgroundImage;
    }

    public String getIdd() {
        return this.idd;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String toString() {
        return "GProStGuidePublishBubble{idd=" + this.idd + ",backgroundImage=" + this.backgroundImage + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
