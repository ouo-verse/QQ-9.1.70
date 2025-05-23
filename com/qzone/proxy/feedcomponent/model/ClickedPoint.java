package com.qzone.proxy.feedcomponent.model;

/* loaded from: classes39.dex */
public class ClickedPoint {
    public int bottom;
    public int left;
    public int marginLeft;
    public int marginTop;
    public int right;
    public int top;

    public ClickedPoint(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.marginLeft = i3;
        this.marginTop = i16;
        this.left = i17;
        this.top = i18;
        this.right = i19;
        this.bottom = i26;
    }

    public int getHeight() {
        return this.bottom - this.top;
    }

    public int getLeft() {
        return this.marginLeft;
    }

    public int getTop() {
        return this.marginTop;
    }

    public int getWidth() {
        return this.right - this.left;
    }
}
