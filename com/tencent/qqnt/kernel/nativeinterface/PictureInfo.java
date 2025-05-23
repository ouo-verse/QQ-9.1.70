package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PictureInfo {
    public String urlPath = "";
    public PicUrlExtInfo extInfo = new PicUrlExtInfo();
    public String domain = "";

    public String getDomain() {
        return this.domain;
    }

    public PicUrlExtInfo getExtInfo() {
        return this.extInfo;
    }

    public String getUrlPath() {
        return this.urlPath;
    }
}
