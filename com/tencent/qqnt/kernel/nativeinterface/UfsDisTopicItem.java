package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisTopicItem {
    public int isHotsearch;
    public byte[] traitTitle = new byte[0];
    public byte[] titleColor = new byte[0];
    public byte[] configTime = new byte[0];
    public byte[] configColor = new byte[0];
    public byte[] jumpUrl = new byte[0];

    public byte[] getConfigColor() {
        return this.configColor;
    }

    public byte[] getConfigTime() {
        return this.configTime;
    }

    public int getIsHotsearch() {
        return this.isHotsearch;
    }

    public byte[] getJumpUrl() {
        return this.jumpUrl;
    }

    public byte[] getTitleColor() {
        return this.titleColor;
    }

    public byte[] getTraitTitle() {
        return this.traitTitle;
    }

    public String toString() {
        return "UfsDisTopicItem{traitTitle=" + this.traitTitle + ",titleColor=" + this.titleColor + ",configTime=" + this.configTime + ",configColor=" + this.configColor + ",jumpUrl=" + this.jumpUrl + ",isHotsearch=" + this.isHotsearch + ",}";
    }
}
