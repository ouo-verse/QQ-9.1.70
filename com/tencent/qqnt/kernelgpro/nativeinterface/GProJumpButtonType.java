package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProJumpButtonType {
    public int type;
    public GProJumpButtonParamH5 paramH5 = new GProJumpButtonParamH5();
    public String paramCustomize = "";

    public String getParamCustomize() {
        return this.paramCustomize;
    }

    public GProJumpButtonParamH5 getParamH5() {
        return this.paramH5;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProJumpButtonType{type=" + this.type + ",paramH5=" + this.paramH5 + ",paramCustomize=" + this.paramCustomize + ",}";
    }
}
