package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProMVPThumbImage {
    public int height;
    public int level;
    public String url = "";
    public int width;

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
        return "GProMVPThumbImage{level=" + this.level + JefsClass.INDEX_URL + this.url + ",width=" + this.width + ",height=" + this.height + ",}";
    }
}
