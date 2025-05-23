package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTextMedalInfo {
    public int colorBg;
    public int colorText;
    public long expireTime;
    public String name;

    public GProTextMedalInfo() {
        this.name = "";
    }

    public int getColorBg() {
        return this.colorBg;
    }

    public int getColorText() {
        return this.colorText;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProTextMedalInfo{name=" + this.name + ",expireTime=" + this.expireTime + ",colorText=" + this.colorText + ",colorBg=" + this.colorBg + ",}";
    }

    public GProTextMedalInfo(String str, long j3, int i3, int i16) {
        this.name = str;
        this.expireTime = j3;
        this.colorText = i3;
        this.colorBg = i16;
    }
}
