package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ReplyAbsPicElement {
    public int picHeight;
    public String picText;
    public int picWidth;

    public ReplyAbsPicElement() {
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public String getPicText() {
        return this.picText;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    public String toString() {
        return "ReplyAbsPicElement{picWidth=" + this.picWidth + ",picHeight=" + this.picHeight + ",picText=" + this.picText + ",}";
    }

    public ReplyAbsPicElement(int i3, int i16, String str) {
        this.picWidth = i3;
        this.picHeight = i16;
        this.picText = str;
    }
}
