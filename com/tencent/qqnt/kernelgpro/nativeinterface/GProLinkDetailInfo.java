package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLinkDetailInfo implements Serializable {
    public String longUrl;
    long serialVersionUID;

    public GProLinkDetailInfo() {
        this.serialVersionUID = 1L;
        this.longUrl = "";
    }

    public String getLongUrl() {
        return this.longUrl;
    }

    public String toString() {
        return "GProLinkDetailInfo{longUrl=" + this.longUrl + ",}";
    }

    public GProLinkDetailInfo(String str) {
        this.serialVersionUID = 1L;
        this.longUrl = str;
    }
}
