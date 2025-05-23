package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisTopicImage {
    public int isHotsearch;
    public byte[] imageUrl = new byte[0];
    public byte[] imageText = new byte[0];
    public byte[] jumpUrl = new byte[0];

    public byte[] getImageText() {
        return this.imageText;
    }

    public byte[] getImageUrl() {
        return this.imageUrl;
    }

    public int getIsHotsearch() {
        return this.isHotsearch;
    }

    public byte[] getJumpUrl() {
        return this.jumpUrl;
    }

    public String toString() {
        return "UfsDisTopicImage{imageUrl=" + this.imageUrl + ",imageText=" + this.imageText + ",jumpUrl=" + this.jumpUrl + ",isHotsearch=" + this.isHotsearch + ",}";
    }
}
