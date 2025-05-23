package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReqToGroup {
    public long groupCode;
    public int sourceId;
    public int sourceSubId;
    public byte[] richMsg = new byte[0];
    public String applyMsg = "";
    public String token = "";
    public String auth = "";
    public String noVerifyAuth = "";
    public byte[] transInfo = new byte[0];

    public String getApplyMsg() {
        return this.applyMsg;
    }

    public String getAuth() {
        return this.auth;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getNoVerifyAuth() {
        return this.noVerifyAuth;
    }

    public byte[] getRichMsg() {
        return this.richMsg;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public int getSourceSubId() {
        return this.sourceSubId;
    }

    public String getToken() {
        return this.token;
    }

    public byte[] getTransInfo() {
        return this.transInfo;
    }

    public String toString() {
        return "ReqToGroup{groupCode=" + this.groupCode + ",sourceId=" + this.sourceId + ",sourceSubId=" + this.sourceSubId + ",richMsg=" + this.richMsg + ",applyMsg=" + this.applyMsg + ",token=" + this.token + ",auth=" + this.auth + ",noVerifyAuth=" + this.noVerifyAuth + ",transInfo=" + this.transInfo + ",}";
    }
}
