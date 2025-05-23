package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFDLStChannelInfo {
    public GProFDLStSign sign;

    public GProFDLStChannelInfo() {
        this.sign = new GProFDLStSign();
    }

    public GProFDLStSign getSign() {
        return this.sign;
    }

    public String toString() {
        return "GProFDLStChannelInfo{sign=" + this.sign + ",}";
    }

    public GProFDLStChannelInfo(GProFDLStSign gProFDLStSign) {
        new GProFDLStSign();
        this.sign = gProFDLStSign;
    }
}
