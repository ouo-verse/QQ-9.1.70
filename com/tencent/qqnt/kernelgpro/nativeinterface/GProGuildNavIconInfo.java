package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildNavIconInfo {
    public long iconId;
    public String iconName;
    public String iconUrl;

    public GProGuildNavIconInfo() {
        this.iconUrl = "";
        this.iconName = "";
    }

    public long getIconId() {
        return this.iconId;
    }

    public String getIconName() {
        return this.iconName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String toString() {
        return "GProGuildNavIconInfo{iconId=" + this.iconId + ",iconUrl=" + this.iconUrl + ",iconName=" + this.iconName + ",}";
    }

    public GProGuildNavIconInfo(long j3, String str, String str2) {
        this.iconId = j3;
        this.iconUrl = str;
        this.iconName = str2;
    }
}
