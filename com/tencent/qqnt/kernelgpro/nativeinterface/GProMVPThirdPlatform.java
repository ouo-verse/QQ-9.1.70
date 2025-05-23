package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPThirdPlatform implements Serializable {
    public String icon;
    public String name;
    long serialVersionUID;

    public GProMVPThirdPlatform() {
        this.serialVersionUID = 1L;
        this.icon = "";
        this.name = "";
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProMVPThirdPlatform{icon=" + this.icon + ",name=" + this.name + ",}";
    }

    public GProMVPThirdPlatform(String str, String str2) {
        this.serialVersionUID = 1L;
        this.icon = str;
        this.name = str2;
    }
}
