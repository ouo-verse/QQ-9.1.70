package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelCreateInfo {
    public long appId;
    public ArrayList<GProAuthControlSwitchInfo> authControlSwitchInfoList;
    public ArrayList<GProBindMembers> bindMembersList;
    public ArrayList<GProBindRoleGroups> bindRoleGroupsList;
    public int categoryIndex;
    public int channelType;
    public int cloneMsgNotifyType;
    public String iconUrl;
    public int indexInCategory;
    public String linkChannelUrl;
    public int livePermission;
    public ArrayList<Long> liveableMembers;
    public ArrayList<Long> liveableRoleGroupIds;
    public int msgNotifyType;
    public String name;
    public String operationTitle;
    public int operationType;
    public ArrayList<Long> privateMembers;
    public int privateType;
    public ArrayList<Long> roleGroupIds;
    public int speakPermission;
    public ArrayList<Integer> specialTypeList;
    public int subTypeId;
    public int useMsgNotifyType;
    public int visibleType;

    public GProChannelCreateInfo() {
        this.name = "";
        this.specialTypeList = new ArrayList<>();
        this.privateMembers = new ArrayList<>();
        this.roleGroupIds = new ArrayList<>();
        this.liveableMembers = new ArrayList<>();
        this.liveableRoleGroupIds = new ArrayList<>();
        this.authControlSwitchInfoList = new ArrayList<>();
        this.bindRoleGroupsList = new ArrayList<>();
        this.bindMembersList = new ArrayList<>();
        this.iconUrl = "";
        this.operationTitle = "";
        this.linkChannelUrl = "";
    }

    public long getAppId() {
        return this.appId;
    }

    public ArrayList<GProAuthControlSwitchInfo> getAuthControlSwitchInfoList() {
        return this.authControlSwitchInfoList;
    }

    public ArrayList<GProBindMembers> getBindMembersList() {
        return this.bindMembersList;
    }

    public ArrayList<GProBindRoleGroups> getBindRoleGroupsList() {
        return this.bindRoleGroupsList;
    }

    public int getCategoryIndex() {
        return this.categoryIndex;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public int getCloneMsgNotifyType() {
        return this.cloneMsgNotifyType;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getIndexInCategory() {
        return this.indexInCategory;
    }

    public String getLinkChannelUrl() {
        return this.linkChannelUrl;
    }

    public int getLivePermission() {
        return this.livePermission;
    }

    public ArrayList<Long> getLiveableMembers() {
        return this.liveableMembers;
    }

    public ArrayList<Long> getLiveableRoleGroupIds() {
        return this.liveableRoleGroupIds;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public String getName() {
        return this.name;
    }

    public String getOperationTitle() {
        return this.operationTitle;
    }

    public int getOperationType() {
        return this.operationType;
    }

    public ArrayList<Long> getPrivateMembers() {
        return this.privateMembers;
    }

    public int getPrivateType() {
        return this.privateType;
    }

    public ArrayList<Long> getRoleGroupIds() {
        return this.roleGroupIds;
    }

    public int getSpeakPermission() {
        return this.speakPermission;
    }

    public ArrayList<Integer> getSpecialTypeList() {
        return this.specialTypeList;
    }

    public int getSubTypeId() {
        return this.subTypeId;
    }

    public int getUseMsgNotifyType() {
        return this.useMsgNotifyType;
    }

    public int getVisibleType() {
        return this.visibleType;
    }

    public String toString() {
        return "GProChannelCreateInfo{name=" + this.name + ",msgNotifyType=" + this.msgNotifyType + ",channelType=" + this.channelType + ",speakPermission=" + this.speakPermission + ",categoryIndex=" + this.categoryIndex + ",indexInCategory=" + this.indexInCategory + ",appId=" + this.appId + ",privateType=" + this.privateType + ",specialTypeList=" + this.specialTypeList + ",privateMembers=" + this.privateMembers + ",roleGroupIds=" + this.roleGroupIds + ",subTypeId=" + this.subTypeId + ",useMsgNotifyType=" + this.useMsgNotifyType + ",visibleType=" + this.visibleType + ",livePermission=" + this.livePermission + ",liveableMembers=" + this.liveableMembers + ",liveableRoleGroupIds=" + this.liveableRoleGroupIds + ",authControlSwitchInfoList=" + this.authControlSwitchInfoList + ",bindRoleGroupsList=" + this.bindRoleGroupsList + ",bindMembersList=" + this.bindMembersList + ",cloneMsgNotifyType=" + this.cloneMsgNotifyType + ",operationType=" + this.operationType + ",iconUrl=" + this.iconUrl + ",operationTitle=" + this.operationTitle + ",linkChannelUrl=" + this.linkChannelUrl + ",}";
    }

    public GProChannelCreateInfo(String str, int i3, int i16, int i17, int i18, int i19, long j3, int i26, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2, ArrayList<Long> arrayList3, int i27, int i28, int i29, int i36, ArrayList<Long> arrayList4, ArrayList<Long> arrayList5, ArrayList<GProAuthControlSwitchInfo> arrayList6, ArrayList<GProBindRoleGroups> arrayList7, ArrayList<GProBindMembers> arrayList8, int i37, int i38, String str2, String str3, String str4) {
        this.name = "";
        this.specialTypeList = new ArrayList<>();
        this.privateMembers = new ArrayList<>();
        this.roleGroupIds = new ArrayList<>();
        this.liveableMembers = new ArrayList<>();
        this.liveableRoleGroupIds = new ArrayList<>();
        this.authControlSwitchInfoList = new ArrayList<>();
        this.bindRoleGroupsList = new ArrayList<>();
        new ArrayList();
        this.name = str;
        this.msgNotifyType = i3;
        this.channelType = i16;
        this.speakPermission = i17;
        this.categoryIndex = i18;
        this.indexInCategory = i19;
        this.appId = j3;
        this.privateType = i26;
        this.specialTypeList = arrayList;
        this.privateMembers = arrayList2;
        this.roleGroupIds = arrayList3;
        this.subTypeId = i27;
        this.useMsgNotifyType = i28;
        this.visibleType = i29;
        this.livePermission = i36;
        this.liveableMembers = arrayList4;
        this.liveableRoleGroupIds = arrayList5;
        this.authControlSwitchInfoList = arrayList6;
        this.bindRoleGroupsList = arrayList7;
        this.bindMembersList = arrayList8;
        this.cloneMsgNotifyType = i37;
        this.operationType = i38;
        this.iconUrl = str2;
        this.operationTitle = str3;
        this.linkChannelUrl = str4;
    }
}
