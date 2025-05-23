package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProExtendInfo implements Serializable {
    long serialVersionUID = 1;
    public GProGray gray = new GProGray();

    public GProGray getGray() {
        return this.gray;
    }

    public void setGray(GProGray gProGray) {
        this.gray = gProGray;
    }

    public String toString() {
        return "GProExtendInfo{gray=" + this.gray + ",}";
    }
}
