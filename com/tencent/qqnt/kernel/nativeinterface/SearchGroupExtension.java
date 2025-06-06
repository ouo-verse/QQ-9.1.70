package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroupExtension {
    public long exactSearch;
    public int joinGroupFlag;
    public String groupName = "";
    public String groupCode = "";
    public String joinGroupAuth = "";

    public long getExactSearch() {
        return this.exactSearch;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getJoinGroupAuth() {
        return this.joinGroupAuth;
    }

    public int getJoinGroupFlag() {
        return this.joinGroupFlag;
    }

    public String toString() {
        return "SearchGroupExtension{groupName=" + this.groupName + ",groupCode=" + this.groupCode + ",exactSearch=" + this.exactSearch + ",joinGroupAuth=" + this.joinGroupAuth + ",joinGroupFlag=" + this.joinGroupFlag + ",}";
    }
}
