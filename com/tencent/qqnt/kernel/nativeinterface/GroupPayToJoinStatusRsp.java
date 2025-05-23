package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GroupPayToJoinStatusRsp {
    public int appPrivilegeFlag;
    public long groupCode;
    public int moneyForAddGroup;

    public int getAppPrivilegeFlag() {
        return this.appPrivilegeFlag;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getMoneyForAddGroup() {
        return this.moneyForAddGroup;
    }

    public String toString() {
        return "GroupPayToJoinStatusRsp{groupCode=" + this.groupCode + ",appPrivilegeFlag=" + this.appPrivilegeFlag + ",moneyForAddGroup=" + this.moneyForAddGroup + ",}";
    }
}
