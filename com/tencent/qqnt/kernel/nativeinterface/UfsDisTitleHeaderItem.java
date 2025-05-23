package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisTitleHeaderItem {
    public int headerType;
    public byte[] title = new byte[0];
    public byte[] iconUrl = new byte[0];
    public byte[] mornText = new byte[0];
    public byte[] mornUrl = new byte[0];
    public byte[] qqIndexJumpUrl = new byte[0];

    public int getHeaderType() {
        return this.headerType;
    }

    public byte[] getIconUrl() {
        return this.iconUrl;
    }

    public byte[] getMornText() {
        return this.mornText;
    }

    public byte[] getMornUrl() {
        return this.mornUrl;
    }

    public byte[] getQqIndexJumpUrl() {
        return this.qqIndexJumpUrl;
    }

    public byte[] getTitle() {
        return this.title;
    }

    public String toString() {
        return "UfsDisTitleHeaderItem{title=" + this.title + ",iconUrl=" + this.iconUrl + ",mornText=" + this.mornText + ",mornUrl=" + this.mornUrl + ",headerType=" + this.headerType + ",qqIndexJumpUrl=" + this.qqIndexJumpUrl + ",}";
    }
}
