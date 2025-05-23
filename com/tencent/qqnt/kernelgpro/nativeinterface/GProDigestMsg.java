package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDigestMsg {
    public GProDigestMsgHead head = new GProDigestMsgHead();
    public GProDigestMsgBody body = new GProDigestMsgBody();
    public GProDigestMsgExt ext = new GProDigestMsgExt();

    public GProDigestMsgBody getBody() {
        return this.body;
    }

    public GProDigestMsgExt getExt() {
        return this.ext;
    }

    public GProDigestMsgHead getHead() {
        return this.head;
    }

    public String toString() {
        return "GProDigestMsg{head=" + this.head + ",body=" + this.body + ",ext=" + this.ext + ",}";
    }
}
