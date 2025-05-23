package com.tencent.imsdk.group;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GroupManager {
    private GroupListener mGroupInternalListener;
    private GroupListener mGroupListener;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class GroupManagerHolder {
        private static final GroupManager groupManager = new GroupManager();

        GroupManagerHolder() {
        }
    }

    public static GroupManager getInstance() {
        return GroupManagerHolder.groupManager;
    }

    private void initGroupListener() {
        if (this.mGroupInternalListener == null) {
            this.mGroupInternalListener = new GroupListener() { // from class: com.tencent.imsdk.group.GroupManager.1
                @Override // com.tencent.imsdk.group.GroupListener
                public void onApplicationProcessed(final String str, final GroupMemberInfo groupMemberInfo, final boolean z16, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onApplicationProcessed(str, groupMemberInfo, z16, str2);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGrantAdministrator(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGrantAdministrator(str, groupMemberInfo, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupAttributeChanged(final String str, final Map<String, String> map) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.16
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupAttributeChanged(str, map);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupCreated(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupCreated(str);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupDismissed(final String str, final GroupMemberInfo groupMemberInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupDismissed(str, groupMemberInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupInfoChanged(final String str, final List<GroupInfoChangeItem> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupInfoChanged(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onGroupRecycled(final String str, final GroupMemberInfo groupMemberInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onGroupRecycled(str, groupMemberInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberEnter(final String str, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberEnter(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberInfoChanged(final String str, final List<GroupMemberInfoChangeItem> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberInfoChanged(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberInvited(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberInvited(str, groupMemberInfo, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberKicked(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberKicked(str, groupMemberInfo, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onMemberLeave(final String str, final GroupMemberInfo groupMemberInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onMemberLeave(str, groupMemberInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onQuitFromGroup(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onQuitFromGroup(str);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onReceiveJoinApplication(final String str, final GroupMemberInfo groupMemberInfo, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onReceiveJoinApplication(str, groupMemberInfo, str2);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onReceiveRESTCustomData(final String str, final byte[] bArr) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onReceiveRESTCustomData(str, bArr);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.group.GroupListener
                public void onRevokeAdministrator(final String str, final GroupMemberInfo groupMemberInfo, final List<GroupMemberInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.group.GroupManager.1.13
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupManager.this.mGroupListener != null) {
                                GroupManager.this.mGroupListener.onRevokeAdministrator(str, groupMemberInfo, list);
                            }
                        }
                    });
                }
            };
        }
        nativeSetGroupListener(this.mGroupInternalListener);
    }

    public void acceptGroupApplication(GroupApplication groupApplication, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
            }
        } else {
            groupApplication.setResponseType(GroupApplication.RESPONSE_TYPE_AGREE);
            groupApplication.setResponseMessage(str);
            nativeResponseGroupApplication(groupApplication, iMCallback);
        }
    }

    public void createGroup(String str, String str2, String str3, IMCallback<String> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
            }
        } else {
            GroupInfo groupInfo = new GroupInfo();
            groupInfo.setGroupID(str2);
            groupInfo.setGroupType(str);
            groupInfo.setGroupName(str3);
            nativeCreateGroup(groupInfo, null, iMCallback);
        }
    }

    public void deleteGroupAttributes(String str, List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteGroupAttributes(str, list, iMCallback);
    }

    public void dismissGroup(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDismissGroup(str, iMCallback);
    }

    public void getGroupApplicationList(IMCallback<GroupApplicationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupApplicationList(iMCallback);
    }

    public void getGroupAttributes(String str, List<String> list, IMCallback<Map<String, String>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupAttributes(str, list, iMCallback);
    }

    public void getGroupMemberList(String str, int i3, long j3, IMCallback<GroupMemberInfoResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupMemberList(str, i3, j3, iMCallback);
    }

    public void getGroupMembersInfo(String str, List<String> list, IMCallback<List<GroupMemberInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupMembersInfo(str, list, iMCallback);
    }

    public void getGroupOnlineMemberCount(String str, IMCallback<Integer> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupOnlineMemberCount(str, iMCallback);
    }

    public void getGroupsInfo(List<String> list, IMCallback<List<GroupInfoGetResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupsInfo(list, iMCallback);
    }

    public void getJoinedGroupList(IMCallback<List<GroupInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetJoinedGroupList(iMCallback);
    }

    public void init() {
        initGroupListener();
    }

    public void initGroupAttributes(String str, HashMap<String, String> hashMap, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeInitGroupAttributes(str, hashMap, iMCallback);
    }

    public void inviteUserToGroup(String str, List<String> list, IMCallback<List<GroupMemberOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeInviteGroupMembers(str, list, "", iMCallback);
    }

    public void joinGroup(String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeJoinGroup(str, str2, iMCallback);
    }

    public void kickGroupMember(String str, List<String> list, String str2, IMCallback<List<GroupMemberOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteGroupMembers(str, list, str2, iMCallback);
    }

    public void muteGroupMember(String str, String str2, int i3, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeMuteGroupMember(str, str2, i3, iMCallback);
    }

    protected native void nativeCreateGroup(GroupInfo groupInfo, List<GroupMemberInfo> list, IMCallback<String> iMCallback);

    protected native void nativeDeleteGroupAttributes(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteGroupMembers(String str, List<String> list, String str2, IMCallback iMCallback);

    protected native void nativeDismissGroup(String str, IMCallback iMCallback);

    protected native void nativeGetGroupApplicationList(IMCallback iMCallback);

    protected native void nativeGetGroupAttributes(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeGetGroupMemberList(String str, int i3, long j3, IMCallback iMCallback);

    protected native void nativeGetGroupMembersInfo(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeGetGroupOnlineMemberCount(String str, IMCallback iMCallback);

    protected native void nativeGetGroupsInfo(List<String> list, IMCallback iMCallback);

    protected native void nativeGetJoinedGroupList(IMCallback iMCallback);

    protected native void nativeInitGroupAttributes(String str, Map<String, String> map, IMCallback iMCallback);

    protected native void nativeInviteGroupMembers(String str, List<String> list, String str2, IMCallback iMCallback);

    protected native void nativeJoinGroup(String str, String str2, IMCallback iMCallback);

    protected native void nativeMuteGroupMember(String str, String str2, int i3, IMCallback iMCallback);

    protected native void nativeQuitGroup(String str, IMCallback iMCallback);

    protected native void nativeResponseGroupApplication(GroupApplication groupApplication, IMCallback iMCallback);

    protected native void nativeSearchGroupMembersInfo(GroupMemberSearchParam groupMemberSearchParam, IMCallback iMCallback);

    protected native void nativeSearchGroups(GroupSearchParam groupSearchParam, IMCallback iMCallback);

    protected native void nativeSetGroupApplicationListRead(IMCallback iMCallback);

    protected native void nativeSetGroupInfo(GroupInfoModifyParam groupInfoModifyParam, IMCallback iMCallback);

    protected native void nativeSetGroupListener(GroupListener groupListener);

    protected native void nativeSetGroupMemberInfo(GroupMemberInfoModifyParam groupMemberInfoModifyParam, IMCallback iMCallback);

    protected native void nativeSetGroupMemberRole(String str, String str2, int i3, IMCallback iMCallback);

    protected native void nativeSetGroupMessageReceiveOption(String str, int i3, IMCallback iMCallback);

    protected native void nativeSetGroupOwner(String str, String str2, IMCallback iMCallback);

    protected native void nativeUpdateGroupAttributes(String str, Map<String, String> map, IMCallback iMCallback);

    public void quitGroup(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeQuitGroup(str, iMCallback);
    }

    public void refuseGroupApplication(GroupApplication groupApplication, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
            }
        } else {
            groupApplication.setResponseType(GroupApplication.RESPONSE_TYPE_REFUSE);
            groupApplication.setResponseMessage(str);
            nativeResponseGroupApplication(groupApplication, iMCallback);
        }
    }

    public void searchGroupMembersInfo(GroupMemberSearchParam groupMemberSearchParam, IMCallback<HashMap<String, List<GroupMemberInfo>>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSearchGroupMembersInfo(groupMemberSearchParam, iMCallback);
    }

    public void searchGroups(GroupSearchParam groupSearchParam, IMCallback<List<GroupInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSearchGroups(groupSearchParam, iMCallback);
    }

    public void setGroupApplicationRead(IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupApplicationListRead(iMCallback);
    }

    public void setGroupAttributes(String str, HashMap<String, String> hashMap, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeUpdateGroupAttributes(str, hashMap, iMCallback);
    }

    public void setGroupInfo(GroupInfoModifyParam groupInfoModifyParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupInfo(groupInfoModifyParam, iMCallback);
    }

    public void setGroupListener(GroupListener groupListener) {
        this.mGroupListener = groupListener;
    }

    public void setGroupMemberInfo(GroupMemberInfoModifyParam groupMemberInfoModifyParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupMemberInfo(groupMemberInfoModifyParam, iMCallback);
    }

    public void setGroupMemberRole(String str, String str2, int i3, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupMemberRole(str, str2, i3, iMCallback);
    }

    public void setGroupReceiveMessageOpt(String str, int i3, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupMessageReceiveOption(str, i3, iMCallback);
    }

    public void transferGroupOwner(String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupOwner(str, str2, iMCallback);
    }

    public void createGroup(GroupInfo groupInfo, List<GroupMemberInfo> list, IMCallback<String> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeCreateGroup(groupInfo, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(6013, "sdk not init");
        }
    }
}
