package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProCommThirdShareInfo implements Serializable {
    long serialVersionUID = 1;
    public String imageUrl = "";
    public String title = "";
    public String stringAbstract = "";
    public String redirectUrl = "";

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public String getStringAbstract() {
        return this.stringAbstract;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProCommThirdShareInfo{imageUrl=" + this.imageUrl + ",title=" + this.title + ",stringAbstract=" + this.stringAbstract + ",redirectUrl=" + this.redirectUrl + ",}";
    }
}
