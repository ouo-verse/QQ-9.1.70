package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class JoinGroupVerifyReq {
    public int eduSupportNoVerify;
    public long groupCode;
    public long uin;
    public String joinGroupAuth = "";
    public JoinGroupVerifyReqExt ext = new JoinGroupVerifyReqExt();

    public int getEduSupportNoVerify() {
        return this.eduSupportNoVerify;
    }

    public JoinGroupVerifyReqExt getExt() {
        return this.ext;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getJoinGroupAuth() {
        return this.joinGroupAuth;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "JoinGroupVerifyReq{groupCode=" + this.groupCode + ",uin=" + this.uin + ",joinGroupAuth=" + this.joinGroupAuth + ",eduSupportNoVerify=" + this.eduSupportNoVerify + ",ext=" + this.ext + ",}";
    }
}
