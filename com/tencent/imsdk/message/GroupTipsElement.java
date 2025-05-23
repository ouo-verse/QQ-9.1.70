package com.tencent.imsdk.message;

import android.text.TextUtils;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GroupTipsElement extends MessageBaseElement {
    public static final int GROUP_TIPS_TYPE_GRANT_ADMINISTRATOR = 4;
    public static final int GROUP_TIPS_TYPE_GROUP_INFO_CHANGE = 6;
    public static final int GROUP_TIPS_TYPE_GROUP_MEMBER_INFO_CHANGE = 7;
    public static final int GROUP_TIPS_TYPE_JOIN = 1;
    public static final int GROUP_TIPS_TYPE_KICK = 3;
    public static final int GROUP_TIPS_TYPE_NONE = 0;
    public static final int GROUP_TIPS_TYPE_QUIT = 2;
    public static final int GROUP_TIPS_TYPE_REVOKE_ADMINISTRATOR = 5;
    private String groupID;
    private int groupMemberCount;
    private String groupName;
    private int groupTipsType;
    private String groupType;
    private GroupMemberInfo operatorGroupMemberInfo;
    private String operatorPlatForm;
    private String operatorUserID;
    private UserInfo operatorUserInfo;
    private List<String> targetUserIDList = new ArrayList();
    private List<UserInfo> targetUserInfoList = new ArrayList();
    private List<GroupMemberInfo> targetGroupMemberInfoList = new ArrayList();
    private List<GroupInfoChangeItem> groupInfoChangeItemList = new ArrayList();
    private List<GroupMemberInfoChangeItem> groupMemberInfoChangeItemList = new ArrayList();

    void addGroupInfoChangeItem(GroupInfoChangeItem groupInfoChangeItem) {
        if (groupInfoChangeItem == null) {
            return;
        }
        this.groupInfoChangeItemList.add(groupInfoChangeItem);
    }

    void addGroupMemberInfoChangeItem(GroupMemberInfoChangeItem groupMemberInfoChangeItem) {
        if (groupMemberInfoChangeItem == null) {
            return;
        }
        this.groupMemberInfoChangeItemList.add(groupMemberInfoChangeItem);
    }

    void addTargetGroupMemberInfo(GroupMemberInfo groupMemberInfo) {
        if (groupMemberInfo == null) {
            return;
        }
        this.targetGroupMemberInfoList.add(groupMemberInfo);
    }

    void addTargetUserID(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.targetUserIDList.add(str);
    }

    void addTargetUserInfo(UserInfo userInfo) {
        this.targetUserInfoList.add(userInfo);
    }

    public String getGroupID() {
        return this.groupID;
    }

    public List<GroupInfoChangeItem> getGroupInfoChangeItemList() {
        return this.groupInfoChangeItemList;
    }

    public int getGroupMemberCount() {
        return this.groupMemberCount;
    }

    public List<GroupMemberInfoChangeItem> getGroupMemberInfoChangeItemList() {
        return this.groupMemberInfoChangeItemList;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getGroupTipsType() {
        return this.groupTipsType;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public GroupMemberInfo getOperatorGroupMemberInfo() {
        return this.operatorGroupMemberInfo;
    }

    public String getOperatorPlatForm() {
        return this.operatorPlatForm;
    }

    public String getOperatorUserID() {
        return this.operatorUserID;
    }

    public UserInfo getOperatorUserInfo() {
        return this.operatorUserInfo;
    }

    public List<GroupMemberInfo> getTargetGroupMemberInfoList() {
        return this.targetGroupMemberInfoList;
    }

    public List<String> getTargetUserIDList() {
        return this.targetUserIDList;
    }

    public List<UserInfo> getTargetUserInfoList() {
        return this.targetUserInfoList;
    }
}
