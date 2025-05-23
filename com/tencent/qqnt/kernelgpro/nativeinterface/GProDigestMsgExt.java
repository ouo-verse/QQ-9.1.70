package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDigestMsgExt {
    public byte[] bizExt = new byte[0];
    public byte[] pushMsg = new byte[0];

    public byte[] getBizExt() {
        return this.bizExt;
    }

    public byte[] getPushMsg() {
        return this.pushMsg;
    }

    public String toString() {
        return "GProDigestMsgExt{bizExt=" + this.bizExt + ",pushMsg=" + this.pushMsg + ",}";
    }
}
