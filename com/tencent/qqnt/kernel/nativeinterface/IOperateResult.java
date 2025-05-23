package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class IOperateResult {
    public int code;
    public String errMsg;

    public IOperateResult() {
        this.errMsg = "";
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String toString() {
        return "IOperateResult{code=" + this.code + ",errMsg=" + this.errMsg + ",}";
    }

    public IOperateResult(int i3, String str) {
        this.code = i3;
        this.errMsg = str;
    }
}
