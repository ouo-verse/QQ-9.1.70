package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPImage {
    public int displayIndex;
    public int height;
    public int imageType;
    public boolean isOrig;
    public int origSize;
    public int width;
    public String url = "";
    public ArrayList<GProMVPThumbImage> thumbImages = new ArrayList<>();

    public int getDisplayIndex() {
        return this.displayIndex;
    }

    public int getHeight() {
        return this.height;
    }

    public int getImageType() {
        return this.imageType;
    }

    public boolean getIsOrig() {
        return this.isOrig;
    }

    public int getOrigSize() {
        return this.origSize;
    }

    public ArrayList<GProMVPThumbImage> getThumbImages() {
        return this.thumbImages;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProMVPImage{width=" + this.width + ",height=" + this.height + JefsClass.INDEX_URL + this.url + ",isOrig=" + this.isOrig + ",origSize=" + this.origSize + ",imageType=" + this.imageType + ",displayIndex=" + this.displayIndex + ",thumbImages=" + this.thumbImages + ",}";
    }
}
