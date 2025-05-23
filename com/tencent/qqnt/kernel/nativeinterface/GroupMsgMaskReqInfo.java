package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMsgMaskReqInfo {
    public int clientType;
    public long groupCode;
    public int option;
    public long rootCode;
    public ArrayList<GroupMsgMaskMemberInfo> rptMsgMemberInfo = new ArrayList<>();

    public int getClientType() {
        return this.clientType;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getOption() {
        return this.option;
    }

    public long getRootCode() {
        return this.rootCode;
    }

    public ArrayList<GroupMsgMaskMemberInfo> getRptMsgMemberInfo() {
        return this.rptMsgMemberInfo;
    }

    public String toString() {
        return "GroupMsgMaskReqInfo{groupCode=" + this.groupCode + ",rptMsgMemberInfo=" + this.rptMsgMemberInfo + ",option=" + this.option + ",clientType=" + this.clientType + ",rootCode=" + this.rootCode + ",}";
    }
}
