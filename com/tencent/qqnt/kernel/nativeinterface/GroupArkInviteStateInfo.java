package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupArkInviteStateInfo {
    public ArrayList<Long> friendsUins;
    public int groupFriendsNum;
    public int groupMembersNum;
    public int status;

    public GroupArkInviteStateInfo() {
        this.friendsUins = new ArrayList<>();
    }

    public ArrayList<Long> getFriendsUins() {
        return this.friendsUins;
    }

    public int getGroupFriendsNum() {
        return this.groupFriendsNum;
    }

    public int getGroupMembersNum() {
        return this.groupMembersNum;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GroupArkInviteStateInfo{groupMembersNum=" + this.groupMembersNum + ",groupFriendsNum=" + this.groupFriendsNum + ",friendsUins=" + this.friendsUins + ",status=" + this.status + ",}";
    }

    public GroupArkInviteStateInfo(int i3, int i16, ArrayList<Long> arrayList, int i17) {
        new ArrayList();
        this.groupMembersNum = i3;
        this.groupFriendsNum = i16;
        this.friendsUins = arrayList;
        this.status = i17;
    }
}
