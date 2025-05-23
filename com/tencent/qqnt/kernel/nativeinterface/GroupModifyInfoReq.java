package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupModifyInfoReq {
    public long groupCode;
    public int groupOpenAppid;
    public long operatorUin;
    public GroupModifyInfoFilter filter = new GroupModifyInfoFilter();
    public GroupModifyInfo modifyInfo = new GroupModifyInfo();

    public GroupModifyInfoFilter getFilter() {
        return this.filter;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupOpenAppid() {
        return this.groupOpenAppid;
    }

    public GroupModifyInfo getModifyInfo() {
        return this.modifyInfo;
    }

    public long getOperatorUin() {
        return this.operatorUin;
    }

    public String toString() {
        return "GroupModifyInfoReq{groupCode=" + this.groupCode + ",filter=" + this.filter + ",modifyInfo=" + this.modifyInfo + ",operatorUin=" + this.operatorUin + ",groupOpenAppid=" + this.groupOpenAppid + ",}";
    }
}
