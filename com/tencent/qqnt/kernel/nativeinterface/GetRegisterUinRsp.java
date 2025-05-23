package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetRegisterUinRsp {
    public String errorMsg = "";
    public String registerSucceedToken = "";
    public int retCode;
    public long uin;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getRegisterSucceedToken() {
        return this.registerSucceedToken;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GetRegisterUinRsp{retCode=" + this.retCode + ",errorMsg=" + this.errorMsg + ",uin=" + this.uin + ",registerSucceedToken=" + this.registerSucceedToken + ",}";
    }
}
