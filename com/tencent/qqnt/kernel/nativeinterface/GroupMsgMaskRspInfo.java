package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMsgMaskRspInfo {
    public String errorMsg = "";
    public long groupCode;
    public int result;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "GroupMsgMaskRspInfo{groupCode=" + this.groupCode + ",result=" + this.result + ",errorMsg=" + this.errorMsg + ",}";
    }
}
