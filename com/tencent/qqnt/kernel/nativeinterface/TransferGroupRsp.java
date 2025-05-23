package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TransferGroupRsp {
    public long groupCode;
    public int result;
    public String oldOwner = "";
    public String lastedOwner = "";
    public String strErrorInfo = "";
    public String strClientPrompt = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getLastedOwner() {
        return this.lastedOwner;
    }

    public String getOldOwner() {
        return this.oldOwner;
    }

    public int getResult() {
        return this.result;
    }

    public String getStrClientPrompt() {
        return this.strClientPrompt;
    }

    public String getStrErrorInfo() {
        return this.strErrorInfo;
    }

    public String toString() {
        return "TransferGroupRsp{groupCode=" + this.groupCode + ",oldOwner=" + this.oldOwner + ",lastedOwner=" + this.lastedOwner + ",result=" + this.result + ",strErrorInfo=" + this.strErrorInfo + ",strClientPrompt=" + this.strClientPrompt + ",}";
    }
}
