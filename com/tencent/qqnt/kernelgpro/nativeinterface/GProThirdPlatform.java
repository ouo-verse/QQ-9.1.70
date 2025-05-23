package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProThirdPlatform implements Serializable {
    long serialVersionUID = 1;
    public String icon = "";
    public String name = "";

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProThirdPlatform{icon=" + this.icon + ",name=" + this.name + ",}";
    }
}
