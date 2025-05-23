package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RegisterIdentityLimit {
    public String handleUrl;
    public String prompt;
    public int type;
    public UpSmsInfo upSmsInfo;

    public String getHandleUrl() {
        return this.handleUrl;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public int getType() {
        return this.type;
    }

    public UpSmsInfo getUpSmsInfo() {
        return this.upSmsInfo;
    }

    public String toString() {
        return "RegisterIdentityLimit{type=" + this.type + ",handleUrl=" + this.handleUrl + ",prompt=" + this.prompt + ",upSmsInfo=" + this.upSmsInfo + ",}";
    }
}
