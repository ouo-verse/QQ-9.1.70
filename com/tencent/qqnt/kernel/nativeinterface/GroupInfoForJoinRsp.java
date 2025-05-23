package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupInfoForJoinRsp {
    public int appPrivilegeFlag;
    public long groupCode;
    public int groupFlagExt;
    public int groupFlagExt3;
    public int groupOption;
    public String groupQuestion = "";
    public String groupAnswer = "";

    public int getAppPrivilegeFlag() {
        return this.appPrivilegeFlag;
    }

    public String getGroupAnswer() {
        return this.groupAnswer;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupFlagExt() {
        return this.groupFlagExt;
    }

    public int getGroupFlagExt3() {
        return this.groupFlagExt3;
    }

    public int getGroupOption() {
        return this.groupOption;
    }

    public String getGroupQuestion() {
        return this.groupQuestion;
    }

    public String toString() {
        return "GroupInfoForJoinRsp{groupCode=" + this.groupCode + ",groupOption=" + this.groupOption + ",groupQuestion=" + this.groupQuestion + ",groupAnswer=" + this.groupAnswer + ",appPrivilegeFlag=" + this.appPrivilegeFlag + ",groupFlagExt=" + this.groupFlagExt + ",groupFlagExt3=" + this.groupFlagExt3 + ",}";
    }
}
