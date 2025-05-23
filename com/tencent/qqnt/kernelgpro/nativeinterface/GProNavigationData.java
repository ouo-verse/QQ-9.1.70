package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProNavigationData implements Serializable {
    public int type;
    long serialVersionUID = 1;
    public String name = "";
    public String icon = "";
    public String jumpLink = "";

    public String getIcon() {
        return this.icon;
    }

    public String getJumpLink() {
        return this.jumpLink;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProNavigationData{name=" + this.name + ",icon=" + this.icon + ",jumpLink=" + this.jumpLink + ",type=" + this.type + ",}";
    }
}
