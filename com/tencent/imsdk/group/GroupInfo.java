package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GroupInfo implements Serializable {
    public static int GROUP_ADD_OPTION_ALLOW_ANY = 3;
    public static int GROUP_ADD_OPTION_FORBID_ANY = 1;
    public static int GROUP_ADD_OPTION_NEED_AUTHENTICATION = 2;
    public static long GROUP_INFO_MODIFY_FLAG_ADD_OPTION = 16;
    public static long GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO = 512;
    public static long GROUP_INFO_MODIFY_FLAG_FACE_URL = 8;
    public static long GROUP_INFO_MODIFY_FLAG_GROUP_SEARCHABLE = 128;
    public static long GROUP_INFO_MODIFY_FLAG_INTRODUCTION = 4;
    public static long GROUP_INFO_MODIFY_FLAG_MAX_MEMBER_NUM = 32;
    public static long GROUP_INFO_MODIFY_FLAG_MEMBER_VISIBLE = 64;
    public static long GROUP_INFO_MODIFY_FLAG_NAME = 1;
    public static long GROUP_INFO_MODIFY_FLAG_NONE = 0;
    public static long GROUP_INFO_MODIFY_FLAG_NOTIFICATION = 2;
    public static long GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL = 256;
    private int addOption;
    private long createTime;
    private String faceUrl;
    private String groupID;
    private long groupInfoTimestamp;
    private String groupName;
    private String groupType;
    private String introduction;
    private boolean isAllShutUp;
    private boolean isGroupMemberVisible;
    private boolean isGroupSearchable;
    private long lastMessageTimestamp;
    private long memberCount;
    private long memberMaxCount;
    private long memberOnlineCount;
    private String notification;
    private String ownerUserID;
    private Map<String, byte[]> customInfo = new HashMap();
    private GroupMemberInfo groupSelfInfo = new GroupMemberInfo();

    public int getAddOption() {
        return this.addOption;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.customInfo;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public long getGroupInfoTimestamp() {
        return this.groupInfoTimestamp;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public GroupMemberInfo getGroupSelfInfo() {
        return this.groupSelfInfo;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public long getLastMessageTimestamp() {
        return this.lastMessageTimestamp;
    }

    public long getMemberCount() {
        return this.memberCount;
    }

    public long getMemberMaxCount() {
        return this.memberMaxCount;
    }

    public long getMemberOnlineCount() {
        return this.memberOnlineCount;
    }

    public String getNotification() {
        return this.notification;
    }

    public String getOwnerUserID() {
        return this.ownerUserID;
    }

    public boolean isAllShutUp() {
        return this.isAllShutUp;
    }

    public boolean isGroupMemberVisible() {
        return this.isGroupMemberVisible;
    }

    public boolean isGroupSearchable() {
        return this.isGroupSearchable;
    }

    public void setAddOption(int i3) {
        this.addOption = i3;
    }

    public void setAllShutUp(boolean z16) {
        this.isAllShutUp = z16;
    }

    public void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        this.customInfo = map;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setGroupInfoTimestamp(long j3) {
        this.groupInfoTimestamp = j3;
    }

    public void setGroupMemberVisible(boolean z16) {
        this.isGroupMemberVisible = z16;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupSearchable(boolean z16) {
        this.isGroupSearchable = z16;
    }

    public void setGroupSelfInfo(GroupMemberInfo groupMemberInfo) {
        this.groupSelfInfo = groupMemberInfo;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setLastMessageTimestamp(long j3) {
        this.lastMessageTimestamp = j3;
    }

    public void setMemberCount(long j3) {
        this.memberCount = j3;
    }

    public void setMemberMaxCount(long j3) {
        this.memberMaxCount = j3;
    }

    public void setMemberOnlineCount(long j3) {
        this.memberOnlineCount = j3;
    }

    public void setNotification(String str) {
        this.notification = str;
    }

    public void setOwnerUserID(String str) {
        this.ownerUserID = str;
    }
}
