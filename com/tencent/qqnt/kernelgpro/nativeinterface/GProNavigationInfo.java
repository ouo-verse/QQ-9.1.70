package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProNavigationInfo implements Serializable {
    public int jumpUrlType;
    public boolean showBubble;
    long serialVersionUID = 1;
    public String iconUrl = "";
    public String title = "";
    public String jumpUrl = "";
    public String bubbleDesc = "";

    public String getBubbleDesc() {
        return this.bubbleDesc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getJumpUrlType() {
        return this.jumpUrlType;
    }

    public boolean getShowBubble() {
        return this.showBubble;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProNavigationInfo{iconUrl=" + this.iconUrl + ",title=" + this.title + ",jumpUrl=" + this.jumpUrl + ",jumpUrlType=" + this.jumpUrlType + ",showBubble=" + this.showBubble + ",bubbleDesc=" + this.bubbleDesc + ",}";
    }
}
