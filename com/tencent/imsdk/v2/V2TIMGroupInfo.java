package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupMemberInfo;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupInfo implements Serializable {
    static final String GROUP_TYPE_INTERNAL_CHATROOM = "ChatRoom";
    static final String GROUP_TYPE_INTERNAL_PRIVATE = "Private";
    public static final int V2TIM_GROUP_ADD_ANY = 2;
    public static final int V2TIM_GROUP_ADD_AUTH = 1;
    public static final int V2TIM_GROUP_ADD_FORBID = 0;
    private final String TAG = "V2TIMGroupInfo";
    private GroupInfo groupInfo = new GroupInfo();
    private int modifyFlag = 0;

    public long getCreateTime() {
        return this.groupInfo.getCreateTime();
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.groupInfo.getCustomInfo();
    }

    public String getFaceUrl() {
        return this.groupInfo.getFaceUrl();
    }

    public int getGroupAddOpt() {
        long addOption = this.groupInfo.getAddOption();
        if (addOption == GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY) {
            return 2;
        }
        if (addOption == GroupInfo.GROUP_ADD_OPTION_FORBID_ANY) {
            return 0;
        }
        if (addOption != GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION) {
            return 2;
        }
        return 1;
    }

    public String getGroupID() {
        return this.groupInfo.getGroupID();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public String getGroupName() {
        return this.groupInfo.getGroupName();
    }

    public String getGroupType() {
        String groupType = this.groupInfo.getGroupType();
        if (groupType.equals(GROUP_TYPE_INTERNAL_PRIVATE)) {
            return V2TIMManager.GROUP_TYPE_WORK;
        }
        if (groupType.equals(GROUP_TYPE_INTERNAL_CHATROOM)) {
            return V2TIMManager.GROUP_TYPE_MEETING;
        }
        return groupType;
    }

    public String getIntroduction() {
        return this.groupInfo.getIntroduction();
    }

    public long getJoinTime() {
        return this.groupInfo.getGroupSelfInfo().getJoinTime();
    }

    public long getLastInfoTime() {
        return this.groupInfo.getGroupInfoTimestamp();
    }

    public long getLastMessageTime() {
        return this.groupInfo.getLastMessageTimestamp();
    }

    public int getMemberCount() {
        return (int) this.groupInfo.getMemberCount();
    }

    public long getMemberMaxCount() {
        return this.groupInfo.getMemberMaxCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getModifyFlag() {
        return this.modifyFlag;
    }

    public String getNotification() {
        return this.groupInfo.getNotification();
    }

    public int getOnlineCount() {
        return (int) this.groupInfo.getMemberOnlineCount();
    }

    public String getOwner() {
        return this.groupInfo.getOwnerUserID();
    }

    public int getRecvOpt() {
        int messageReceiveOption = this.groupInfo.getGroupSelfInfo().getMessageReceiveOption();
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
            return 0;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
            return 1;
        }
        if (messageReceiveOption != GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH) {
            return 0;
        }
        return 2;
    }

    public int getRole() {
        int role = this.groupInfo.getGroupSelfInfo().getRole();
        if (role == GroupMemberInfo.MEMBER_ROLE_MEMBER) {
            return 200;
        }
        if (role == GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR) {
            return 300;
        }
        if (role == GroupMemberInfo.MEMBER_ROLE_OWNER) {
            return 400;
        }
        return 0;
    }

    public boolean isAllMuted() {
        return this.groupInfo.isAllShutUp();
    }

    public void setAllMuted(boolean z16) {
        this.groupInfo.setAllShutUp(z16);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL);
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        if (map == null) {
            return;
        }
        this.groupInfo.setCustomInfo(map);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO);
    }

    public void setFaceUrl(String str) {
        this.groupInfo.setFaceUrl(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_FACE_URL);
    }

    public void setGroupAddOpt(int i3) {
        if (2 == i3) {
            this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY);
        } else if (i3 == 0) {
            this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_FORBID_ANY);
        } else if (1 == i3) {
            this.groupInfo.setAddOption(GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION);
        }
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_ADD_OPTION);
    }

    public void setGroupID(String str) {
        this.groupInfo.setGroupID(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public void setGroupName(String str) {
        this.groupInfo.setGroupName(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NAME);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (r4.equalsIgnoreCase(com.tencent.imsdk.v2.V2TIMManager.GROUP_TYPE_AVCHATROOM) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGroupType(String str) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMGroupInfo", "setGroupType error type is null");
            return;
        }
        if (!str.equalsIgnoreCase(V2TIMManager.GROUP_TYPE_WORK)) {
            if (!str.equalsIgnoreCase(V2TIMManager.GROUP_TYPE_MEETING)) {
                if (!str.equalsIgnoreCase(GROUP_TYPE_INTERNAL_PRIVATE)) {
                    if (!str.equalsIgnoreCase(GROUP_TYPE_INTERNAL_CHATROOM)) {
                        String str2 = "Public";
                        if (!str.equalsIgnoreCase("Public")) {
                            str2 = V2TIMManager.GROUP_TYPE_AVCHATROOM;
                        }
                        str = str2;
                        this.groupInfo.setGroupType(str);
                    }
                }
            }
            str = GROUP_TYPE_INTERNAL_CHATROOM;
            this.groupInfo.setGroupType(str);
        }
        str = GROUP_TYPE_INTERNAL_PRIVATE;
        this.groupInfo.setGroupType(str);
    }

    public void setIntroduction(String str) {
        this.groupInfo.setIntroduction(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_INTRODUCTION);
    }

    void setModifyFlag(int i3) {
        this.modifyFlag = i3;
    }

    public void setNotification(String str) {
        this.groupInfo.setNotification(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NOTIFICATION);
    }
}
