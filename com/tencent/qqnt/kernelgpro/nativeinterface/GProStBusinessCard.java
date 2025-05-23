package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStBusinessCard implements Serializable {
    public int height;
    public boolean needShow;
    public int width;
    long serialVersionUID = 1;
    public String jumpSchemaUrl = "";

    public int getHeight() {
        return this.height;
    }

    public String getJumpSchemaUrl() {
        return this.jumpSchemaUrl;
    }

    public boolean getNeedShow() {
        return this.needShow;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProStBusinessCard{jumpSchemaUrl=" + this.jumpSchemaUrl + ",height=" + this.height + ",width=" + this.width + ",needShow=" + this.needShow + ",}";
    }
}
