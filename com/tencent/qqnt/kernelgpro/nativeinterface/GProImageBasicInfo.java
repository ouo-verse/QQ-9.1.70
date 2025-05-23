package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProImageBasicInfo implements Serializable {
    public int height;
    public int width;
    long serialVersionUID = 1;
    public String picUrl = "";

    public int getHeight() {
        return this.height;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProImageBasicInfo{picUrl=" + this.picUrl + ",width=" + this.width + ",height=" + this.height + ",}";
    }
}
