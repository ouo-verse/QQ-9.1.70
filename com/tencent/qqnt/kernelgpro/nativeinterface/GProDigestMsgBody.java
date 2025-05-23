package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDigestMsgBody {
    public byte[] msgDigest = new byte[0];
    public byte[] highLight = new byte[0];

    public byte[] getHighLight() {
        return this.highLight;
    }

    public byte[] getMsgDigest() {
        return this.msgDigest;
    }

    public String toString() {
        return "GProDigestMsgBody{msgDigest=" + this.msgDigest + ",highLight=" + this.highLight + ",}";
    }
}
