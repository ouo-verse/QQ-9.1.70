package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPTencentDocsContent implements Serializable {
    public int docType;
    long serialVersionUID = 1;
    public String url = "";
    public String title = "";
    public String icon = "";
    public String platformName = "";
    public String permission = "";

    public int getDocType() {
        return this.docType;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getPermission() {
        return this.permission;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProMVPTencentDocsContent{url=" + this.url + ",title=" + this.title + ",icon=" + this.icon + ",platformName=" + this.platformName + ",permission=" + this.permission + ",docType=" + this.docType + ",}";
    }
}
