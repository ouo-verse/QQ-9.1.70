package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTencentDocsRsp {
    public String url = "";
    public String title = "";
    public String icon = "";
    public String platformName = "";
    public String permission = "";

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
        return "GProTencentDocsRsp{url=" + this.url + ",title=" + this.title + ",icon=" + this.icon + ",platformName=" + this.platformName + ",permission=" + this.permission + ",}";
    }
}
