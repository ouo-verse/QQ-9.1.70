package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SubGroupSimpleInfo {
    public long groupCode;
    public String groupName = "";
    public long memberMaxNum;
    public long memberNum;

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getMemberMaxNum() {
        return this.memberMaxNum;
    }

    public long getMemberNum() {
        return this.memberNum;
    }

    public String toString() {
        return "SubGroupSimpleInfo{groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",memberNum=" + this.memberNum + ",memberMaxNum=" + this.memberMaxNum + ",}";
    }
}
