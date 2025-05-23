package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendCard implements Serializable {
    public int cardType;
    long serialVersionUID = 1;
    public byte[] data = new byte[0];
    public String title = "";
    public String iconUrl = "";

    public int getCardType() {
        return this.cardType;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProRecommendCard{cardType=" + this.cardType + ",data=" + this.data + ",title=" + this.title + ",iconUrl=" + this.iconUrl + ",}";
    }
}
