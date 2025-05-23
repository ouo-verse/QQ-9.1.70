package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProLiveGearInfo {
    public Integer bitRate;
    public Integer level;
    public String name;
    public Integer pixelsX;
    public Integer pixelsY;

    public Integer getBitRate() {
        return this.bitRate;
    }

    public Integer getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPixelsX() {
        return this.pixelsX;
    }

    public Integer getPixelsY() {
        return this.pixelsY;
    }

    public String toString() {
        return "GProLiveGearInfo{level=" + this.level + ",bitRate=" + this.bitRate + ",name=" + this.name + ",pixelsX=" + this.pixelsX + ",pixelsY=" + this.pixelsY + ",}";
    }
}
