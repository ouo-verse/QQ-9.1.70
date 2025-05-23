package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRealNameAuthInfo {
    public int result;
    public String tipsContent;
    public String verifyUrl;

    public GProRealNameAuthInfo() {
        this.verifyUrl = "";
        this.tipsContent = "";
    }

    public int getResult() {
        return this.result;
    }

    public String getTipsContent() {
        return this.tipsContent;
    }

    public String getVerifyUrl() {
        return this.verifyUrl;
    }

    public String toString() {
        return "GProRealNameAuthInfo{result=" + this.result + ",verifyUrl=" + this.verifyUrl + ",tipsContent=" + this.tipsContent + ",}";
    }

    public GProRealNameAuthInfo(int i3, String str, String str2) {
        this.result = i3;
        this.verifyUrl = str;
        this.tipsContent = str2;
    }
}
