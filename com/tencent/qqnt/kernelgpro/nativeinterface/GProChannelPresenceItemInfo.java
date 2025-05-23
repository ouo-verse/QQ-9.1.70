package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProChannelPresenceItemInfo {
    public int jumpType;
    public String text = "";
    public String jumpUrl = "";

    public int getJumpType() {
        return this.jumpType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProChannelPresenceItemInfo{text=" + this.text + ",jumpUrl=" + this.jumpUrl + ",jumpType=" + this.jumpType + ",}";
    }
}
