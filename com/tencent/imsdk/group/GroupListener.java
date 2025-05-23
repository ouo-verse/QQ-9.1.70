package com.tencent.imsdk.group;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class GroupListener {
    public void onGroupCreated(String str) {
    }

    public void onQuitFromGroup(String str) {
    }

    public void onGroupAttributeChanged(String str, Map<String, String> map) {
    }

    public void onGroupDismissed(String str, GroupMemberInfo groupMemberInfo) {
    }

    public void onGroupInfoChanged(String str, List<GroupInfoChangeItem> list) {
    }

    public void onGroupRecycled(String str, GroupMemberInfo groupMemberInfo) {
    }

    public void onMemberEnter(String str, List<GroupMemberInfo> list) {
    }

    public void onMemberInfoChanged(String str, List<GroupMemberInfoChangeItem> list) {
    }

    public void onMemberLeave(String str, GroupMemberInfo groupMemberInfo) {
    }

    public void onReceiveRESTCustomData(String str, byte[] bArr) {
    }

    public void onGrantAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onMemberInvited(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onMemberKicked(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onReceiveJoinApplication(String str, GroupMemberInfo groupMemberInfo, String str2) {
    }

    public void onRevokeAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
    }

    public void onApplicationProcessed(String str, GroupMemberInfo groupMemberInfo, boolean z16, String str2) {
    }
}
