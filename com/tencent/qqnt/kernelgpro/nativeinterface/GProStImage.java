package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStImage implements Serializable {
    public int displayIndex;
    public int height;
    public boolean isGif;
    public boolean isOrig;
    public int origSize;
    public int width;
    long serialVersionUID = 1;
    public String picUrl = "";
    public ArrayList<GProStImageUrl> vecImageUrlList = new ArrayList<>();
    public String picId = "";
    public byte[] busiData = new byte[0];
    public String imageMD5 = "";
    public String layerPicUrl = "";
    public String patternId = "";

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getDisplayIndex() {
        return this.displayIndex;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageMD5() {
        return this.imageMD5;
    }

    public boolean getIsGif() {
        return this.isGif;
    }

    public boolean getIsOrig() {
        return this.isOrig;
    }

    public String getLayerPicUrl() {
        return this.layerPicUrl;
    }

    public int getOrigSize() {
        return this.origSize;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getPicId() {
        return this.picId;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public ArrayList<GProStImageUrl> getVecImageUrlList() {
        return this.vecImageUrlList;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProStImage{width=" + this.width + ",height=" + this.height + ",picUrl=" + this.picUrl + ",vecImageUrlList=" + this.vecImageUrlList + ",picId=" + this.picId + ",busiData=" + this.busiData + ",imageMD5=" + this.imageMD5 + ",layerPicUrl=" + this.layerPicUrl + ",patternId=" + this.patternId + ",displayIndex=" + this.displayIndex + ",origSize=" + this.origSize + ",isOrig=" + this.isOrig + ",isGif=" + this.isGif + ",}";
    }
}
