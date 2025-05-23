package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProEncryptTextReq {
    public String appId;
    public String originalText;

    public GProEncryptTextReq() {
        this.appId = "";
        this.originalText = "";
    }

    public String getAppId() {
        return this.appId;
    }

    public String getOriginalText() {
        return this.originalText;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setOriginalText(String str) {
        this.originalText = str;
    }

    public String toString() {
        return "GProEncryptTextReq{appId=" + this.appId + ",originalText=" + this.originalText + ",}";
    }

    public GProEncryptTextReq(String str, String str2) {
        this.appId = str;
        this.originalText = str2;
    }
}
