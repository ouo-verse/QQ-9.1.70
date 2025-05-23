package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMemberLevelInfo {
    public ArrayList<GroupMemberLevelName> levelNameNewList = new ArrayList<>();
    public int sysShowFlag;
    public int userShowFlag;
    public int userShowFlagNew;

    public ArrayList<GroupMemberLevelName> getLevelNameNewList() {
        return this.levelNameNewList;
    }

    public int getSysShowFlag() {
        return this.sysShowFlag;
    }

    public int getUserShowFlag() {
        return this.userShowFlag;
    }

    public int getUserShowFlagNew() {
        return this.userShowFlagNew;
    }

    public String toString() {
        return "GroupMemberLevelInfo{userShowFlag=" + this.userShowFlag + ",userShowFlagNew=" + this.userShowFlagNew + ",levelNameNewList=" + this.levelNameNewList + ",sysShowFlag=" + this.sysShowFlag + ",}";
    }
}
