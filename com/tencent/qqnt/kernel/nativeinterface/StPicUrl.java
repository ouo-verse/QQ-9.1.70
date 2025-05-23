package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class StPicUrl {
    public int height;
    public String url;
    public int width;

    public StPicUrl() {
        this.url = "";
    }

    public int getHeight() {
        return this.height;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public StPicUrl(String str, int i3, int i16) {
        this.url = str;
        this.width = i3;
        this.height = i16;
    }
}
