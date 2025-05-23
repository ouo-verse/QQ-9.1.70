package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisHotSearchItem {
    public int showType;
    public int wzTs;
    public byte[] imgUrl = new byte[0];
    public byte[] title = new byte[0];
    public byte[] detailText = new byte[0];
    public byte[] jumpUrl = new byte[0];
    public byte[] markTextColor = new byte[0];
    public byte[] markBgColor = new byte[0];
    public byte[] imgBgUrl = new byte[0];
    public byte[] textColor = new byte[0];
    public byte[] rightIconUrl = new byte[0];
    public byte[] recallWord = new byte[0];
    public byte[] itemExt = new byte[0];

    public byte[] getDetailText() {
        return this.detailText;
    }

    public byte[] getImgBgUrl() {
        return this.imgBgUrl;
    }

    public byte[] getImgUrl() {
        return this.imgUrl;
    }

    public byte[] getItemExt() {
        return this.itemExt;
    }

    public byte[] getJumpUrl() {
        return this.jumpUrl;
    }

    public byte[] getMarkBgColor() {
        return this.markBgColor;
    }

    public byte[] getMarkTextColor() {
        return this.markTextColor;
    }

    public byte[] getRecallWord() {
        return this.recallWord;
    }

    public byte[] getRightIconUrl() {
        return this.rightIconUrl;
    }

    public int getShowType() {
        return this.showType;
    }

    public byte[] getTextColor() {
        return this.textColor;
    }

    public byte[] getTitle() {
        return this.title;
    }

    public int getWzTs() {
        return this.wzTs;
    }

    public String toString() {
        return "UfsDisHotSearchItem{showType=" + this.showType + ",imgUrl=" + this.imgUrl + ",title=" + this.title + ",detailText=" + this.detailText + ",jumpUrl=" + this.jumpUrl + ",markTextColor=" + this.markTextColor + ",markBgColor=" + this.markBgColor + ",imgBgUrl=" + this.imgBgUrl + ",textColor=" + this.textColor + ",rightIconUrl=" + this.rightIconUrl + ",wzTs=" + this.wzTs + ",recallWord=" + this.recallWord + ",itemExt=" + this.itemExt + ",}";
    }
}
