package com.tencent.qqmini.sdk.launcher.core.model;

/* loaded from: classes23.dex */
public class MiniAdPosInfo {
    public int height;
    public int left;
    public int top;
    public int width;

    public MiniAdPosInfo(int i3, int i16, int i17, int i18) {
        this.left = i3;
        this.top = i16;
        this.width = i17;
        this.height = i18;
    }

    public String toString() {
        return "MiniAdPosInfo{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + '}';
    }
}
