package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserBarNodePermission implements Serializable {
    public int nodeType;
    long serialVersionUID = 1;
    public int visibleType;

    public GProUserBarNodePermission() {
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public int getVisibleType() {
        return this.visibleType;
    }

    public String toString() {
        return "GProUserBarNodePermission{nodeType=" + this.nodeType + ",visibleType=" + this.visibleType + ",}";
    }

    public GProUserBarNodePermission(int i3, int i16) {
        this.nodeType = i3;
        this.visibleType = i16;
    }
}
