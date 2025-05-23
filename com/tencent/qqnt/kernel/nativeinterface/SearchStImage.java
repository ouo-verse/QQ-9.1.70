package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchStImage {
    public int height;
    public int width;
    public String picUrl = "";
    public String layerPicUrl = "";

    public int getHeight() {
        return this.height;
    }

    public String getLayerPicUrl() {
        return this.layerPicUrl;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "SearchStImage{width=" + this.width + ",height=" + this.height + ",picUrl=" + this.picUrl + ",layerPicUrl=" + this.layerPicUrl + ",}";
    }
}
