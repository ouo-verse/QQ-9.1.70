package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStImageUrl implements Serializable {
    public int height;
    public int levelType;
    public int width;
    long serialVersionUID = 1;
    public String url = "";
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProStImageUrl{levelType=" + this.levelType + JefsClass.INDEX_URL + this.url + ",width=" + this.width + ",height=" + this.height + ",busiData=" + this.busiData + ",}";
    }
}
