package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPWeixinOfficialAccountsContent implements Serializable {
    long serialVersionUID = 1;
    public String url = "";
    public String title = "";
    public String icon = "";
    public String author = "";

    public String getAuthor() {
        return this.author;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProMVPWeixinOfficialAccountsContent{url=" + this.url + ",title=" + this.title + ",icon=" + this.icon + ",author=" + this.author + ",}";
    }
}
