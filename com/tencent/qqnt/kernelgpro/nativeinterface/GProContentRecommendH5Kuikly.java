package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentRecommendH5Kuikly implements Serializable {
    public int jumpUrlType;
    long serialVersionUID = 1;
    public String title = "";
    public String name = "";
    public String iconUrl = "";
    public String jumpUrl = "";

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getJumpUrlType() {
        return this.jumpUrlType;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProContentRecommendH5Kuikly{title=" + this.title + ",name=" + this.name + ",iconUrl=" + this.iconUrl + ",jumpUrl=" + this.jumpUrl + ",jumpUrlType=" + this.jumpUrlType + ",}";
    }
}
