package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProThumbImage implements Serializable {
    public int height;
    public int level;
    long serialVersionUID;
    public String url;
    public int width;

    public GProThumbImage() {
        this.serialVersionUID = 1L;
        this.url = "";
    }

    public int getHeight() {
        return this.height;
    }

    public int getLevel() {
        return this.level;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProThumbImage{level=" + this.level + JefsClass.INDEX_URL + this.url + ",width=" + this.width + ",height=" + this.height + ",}";
    }

    public GProThumbImage(int i3, String str, int i16, int i17) {
        this.serialVersionUID = 1L;
        this.level = i3;
        this.url = str;
        this.width = i16;
        this.height = i17;
    }
}
