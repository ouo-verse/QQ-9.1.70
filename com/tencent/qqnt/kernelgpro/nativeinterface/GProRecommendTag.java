package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendTag implements Serializable {
    public String icon;
    public String name;
    long serialVersionUID;

    public GProRecommendTag() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.icon = "";
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProRecommendTag{name=" + this.name + ",icon=" + this.icon + ",}";
    }

    public GProRecommendTag(String str, String str2) {
        this.serialVersionUID = 1L;
        this.name = str;
        this.icon = str2;
    }
}
