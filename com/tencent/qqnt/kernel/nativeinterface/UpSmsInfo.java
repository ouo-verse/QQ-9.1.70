package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UpSmsInfo {
    public String port = "";
    public String content = "";
    public String tips = "";
    public String prompt = "";
    public String buttonMsg = "";
    public String maskPhone = "";

    public String getButtonMsg() {
        return this.buttonMsg;
    }

    public String getContent() {
        return this.content;
    }

    public String getMaskPhone() {
        return this.maskPhone;
    }

    public String getPort() {
        return this.port;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public String getTips() {
        return this.tips;
    }

    public String toString() {
        return "UpSmsInfo{port=" + this.port + ",content=" + this.content + ",tips=" + this.tips + ",prompt=" + this.prompt + ",buttonMsg=" + this.buttonMsg + ",maskPhone=" + this.maskPhone + ",}";
    }
}
