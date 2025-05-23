package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisGifInfoItem {
    public byte[] gifUrl = new byte[0];
    public byte[] gifUrlNight = new byte[0];
    public byte[] gifId = new byte[0];

    public byte[] getGifId() {
        return this.gifId;
    }

    public byte[] getGifUrl() {
        return this.gifUrl;
    }

    public byte[] getGifUrlNight() {
        return this.gifUrlNight;
    }

    public String toString() {
        return "UfsDisGifInfoItem{gifUrl=" + this.gifUrl + ",gifUrlNight=" + this.gifUrlNight + ",gifId=" + this.gifId + ",}";
    }
}
