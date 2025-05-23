package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Iframe {
    public byte[] iframeSig = new byte[0];
    public byte[] iframeRandstr = new byte[0];
    public byte[] iframeSid = new byte[0];

    public byte[] getIframeRandstr() {
        return this.iframeRandstr;
    }

    public byte[] getIframeSid() {
        return this.iframeSid;
    }

    public byte[] getIframeSig() {
        return this.iframeSig;
    }

    public String toString() {
        return "Iframe{iframeSig=" + this.iframeSig + ",iframeRandstr=" + this.iframeRandstr + ",iframeSid=" + this.iframeSid + ",}";
    }
}
