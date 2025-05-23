package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProEncryptTextRsp {
    public String encryptedText;
    public boolean isPassed;

    public GProEncryptTextRsp() {
        this.encryptedText = "";
    }

    public String getEncryptedText() {
        return this.encryptedText;
    }

    public boolean getIsPassed() {
        return this.isPassed;
    }

    public String toString() {
        return "GProEncryptTextRsp{isPassed=" + this.isPassed + ",encryptedText=" + this.encryptedText + ",}";
    }

    public GProEncryptTextRsp(boolean z16, String str) {
        this.isPassed = z16;
        this.encryptedText = str;
    }
}
