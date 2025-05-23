package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProImage implements Serializable {
    public int displayIndex;
    public int height;
    public int imageType;
    public boolean isOrig;
    public int origSize;
    long serialVersionUID;
    public ArrayList<GProThumbImage> thumbImages;
    public String url;
    public int width;

    public GProImage() {
        this.serialVersionUID = 1L;
        this.url = "";
        this.thumbImages = new ArrayList<>();
    }

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

    public ArrayList<GProThumbImage> getThumbImages() {
        return this.thumbImages;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProImage{width=" + this.width + ",height=" + this.height + JefsClass.INDEX_URL + this.url + ",isOrig=" + this.isOrig + ",origSize=" + this.origSize + ",imageType=" + this.imageType + ",displayIndex=" + this.displayIndex + ",thumbImages=" + this.thumbImages + ",}";
    }

    public GProImage(int i3, int i16, String str, boolean z16, int i17, int i18, int i19, ArrayList<GProThumbImage> arrayList) {
        this.serialVersionUID = 1L;
        this.url = "";
        new ArrayList();
        this.width = i3;
        this.height = i16;
        this.url = str;
        this.isOrig = z16;
        this.origSize = i17;
        this.imageType = i18;
        this.displayIndex = i19;
        this.thumbImages = arrayList;
    }
}
