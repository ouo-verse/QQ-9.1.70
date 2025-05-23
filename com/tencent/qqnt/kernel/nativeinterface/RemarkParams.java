package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class RemarkParams {
    public String remark;
    public RemarkSignExtInfo signInfo;
    public String uid;

    public RemarkParams() {
        this.uid = "";
        this.remark = "";
    }

    public String getRemark() {
        return this.remark;
    }

    public RemarkSignExtInfo getSignInfo() {
        return this.signInfo;
    }

    public String getUid() {
        return this.uid;
    }

    public RemarkParams(String str, String str2, RemarkSignExtInfo remarkSignExtInfo) {
        this.uid = str;
        this.remark = str2;
        this.signInfo = remarkSignExtInfo;
    }
}
