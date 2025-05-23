package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisOperationItem {
    public byte[] leftTitle = new byte[0];
    public byte[] rightTitle = new byte[0];
    public byte[] detailText = new byte[0];
    public byte[] imgUrl = new byte[0];
    public byte[] jumpUrl = new byte[0];

    public byte[] getDetailText() {
        return this.detailText;
    }

    public byte[] getImgUrl() {
        return this.imgUrl;
    }

    public byte[] getJumpUrl() {
        return this.jumpUrl;
    }

    public byte[] getLeftTitle() {
        return this.leftTitle;
    }

    public byte[] getRightTitle() {
        return this.rightTitle;
    }

    public String toString() {
        return "UfsDisOperationItem{leftTitle=" + this.leftTitle + ",rightTitle=" + this.rightTitle + ",detailText=" + this.detailText + ",imgUrl=" + this.imgUrl + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
