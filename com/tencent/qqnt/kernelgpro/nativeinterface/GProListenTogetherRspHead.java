package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProListenTogetherRspHead {
    public GProConfirmOption confirmOption = new GProConfirmOption();
    public int modCode;

    public GProConfirmOption getConfirmOption() {
        return this.confirmOption;
    }

    public int getModCode() {
        return this.modCode;
    }

    public String toString() {
        return "GProListenTogetherRspHead{modCode=" + this.modCode + ",confirmOption=" + this.confirmOption + ",}";
    }
}
