package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupFileCommonResult {
    public String clientWording;
    public int retCode;
    public String retMsg;

    public GroupFileCommonResult() {
        this.retMsg = "";
        this.clientWording = "";
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public GroupFileCommonResult(int i3, String str, String str2) {
        this.retCode = i3;
        this.retMsg = str;
        this.clientWording = str2;
    }
}
