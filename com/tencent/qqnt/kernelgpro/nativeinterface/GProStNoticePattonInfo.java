package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStNoticePattonInfo {
    public int pattonType;
    public GProStPlainTxtInfo plainTxt = new GProStPlainTxtInfo();

    public int getPattonType() {
        return this.pattonType;
    }

    public GProStPlainTxtInfo getPlainTxt() {
        return this.plainTxt;
    }

    public String toString() {
        return "GProStNoticePattonInfo{pattonType=" + this.pattonType + ",plainTxt=" + this.plainTxt + ",}";
    }
}
