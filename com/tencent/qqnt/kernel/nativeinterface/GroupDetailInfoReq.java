package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupDetailInfoReq {
    public int appid;
    public int clientGroupFlagExt;
    public int clientGroupInfoSeq;
    public long groupCode;
    public int lastGetGroupNameTime;
    public GroupDetailInfoFilter filter = new GroupDetailInfoFilter();
    public String groupInfoToken = "";

    public int getAppid() {
        return this.appid;
    }

    public int getClientGroupFlagExt() {
        return this.clientGroupFlagExt;
    }

    public int getClientGroupInfoSeq() {
        return this.clientGroupInfoSeq;
    }

    public GroupDetailInfoFilter getFilter() {
        return this.filter;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupInfoToken() {
        return this.groupInfoToken;
    }

    public int getLastGetGroupNameTime() {
        return this.lastGetGroupNameTime;
    }

    public String toString() {
        return "GroupDetailInfoReq{appid=" + this.appid + ",groupCode=" + this.groupCode + ",filter=" + this.filter + ",lastGetGroupNameTime=" + this.lastGetGroupNameTime + ",clientGroupInfoSeq=" + this.clientGroupInfoSeq + ",clientGroupFlagExt=" + this.clientGroupFlagExt + ",groupInfoToken=" + this.groupInfoToken + ",}";
    }
}
