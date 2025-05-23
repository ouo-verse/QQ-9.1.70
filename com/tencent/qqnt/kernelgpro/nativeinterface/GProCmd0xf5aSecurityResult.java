package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCmd0xf5aSecurityResult {
    public long action;
    public String prompt = "";
    public String detail = "";

    public long getAction() {
        return this.action;
    }

    public String getDetail() {
        return this.detail;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public String toString() {
        return "GProCmd0xf5aSecurityResult{action=" + this.action + ",prompt=" + this.prompt + ",detail=" + this.detail + ",}";
    }
}
