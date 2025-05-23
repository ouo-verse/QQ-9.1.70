package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFaceAuthInfo {
    public int faceAuthStatus;
    public String verifyUrl;

    public GProFaceAuthInfo() {
        this.verifyUrl = "";
    }

    public int getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GProFaceAuthInfo{faceAuthStatus=" + this.faceAuthStatus + ",verifyUrl=" + this.verifyUrl + ",}";
    }

    public GProFaceAuthInfo(int i3, String str) {
        this.faceAuthStatus = i3;
        this.verifyUrl = str;
    }
}
