package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupTipsElem extends V2TIMElem {
    public static final int GROUP_TIPS_TYPE_INVALID = 0;
    public static final int V2TIM_GROUP_TIPS_TYPE_CANCEL_ADMIN = 6;
    public static final int V2TIM_GROUP_TIPS_TYPE_GROUP_INFO_CHANGE = 7;
    public static final int V2TIM_GROUP_TIPS_TYPE_INVITE = 2;
    public static final int V2TIM_GROUP_TIPS_TYPE_JOIN = 1;
    public static final int V2TIM_GROUP_TIPS_TYPE_KICKED = 4;
    public static final int V2TIM_GROUP_TIPS_TYPE_MEMBER_INFO_CHANGE = 8;
    public static final int V2TIM_GROUP_TIPS_TYPE_QUIT = 3;
    public static final int V2TIM_GROUP_TIPS_TYPE_SET_ADMIN = 5;

    private String getGroupType() {
        if (getElement() == null) {
            return null;
        }
        return ((GroupTipsElement) getElement()).getGroupType();
    }

    public List<V2TIMGroupChangeInfo> getGroupChangeInfoList() {
        if (getElement() == null) {
            return null;
        }
        List<GroupInfoChangeItem> groupInfoChangeItemList = ((GroupTipsElement) getElement()).getGroupInfoChangeItemList();
        ArrayList arrayList = new ArrayList();
        for (GroupInfoChangeItem groupInfoChangeItem : groupInfoChangeItemList) {
            V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
            v2TIMGroupChangeInfo.setGroupInfoChangeItem(groupInfoChangeItem);
            arrayList.add(v2TIMGroupChangeInfo);
        }
        return arrayList;
    }

    public String getGroupID() {
        if (getElement() == null) {
            return null;
        }
        return ((GroupTipsElement) getElement()).getGroupID();
    }

    public List<V2TIMGroupMemberChangeInfo> getMemberChangeInfoList() {
        if (getElement() == null) {
            return null;
        }
        List<GroupMemberInfoChangeItem> groupMemberInfoChangeItemList = ((GroupTipsElement) getElement()).getGroupMemberInfoChangeItemList();
        ArrayList arrayList = new ArrayList();
        for (GroupMemberInfoChangeItem groupMemberInfoChangeItem : groupMemberInfoChangeItemList) {
            V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
            v2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(groupMemberInfoChangeItem);
            arrayList.add(v2TIMGroupMemberChangeInfo);
        }
        return arrayList;
    }

    public int getMemberCount() {
        if (getElement() == null) {
            return 0;
        }
        return ((GroupTipsElement) getElement()).getGroupMemberCount();
    }

    public List<V2TIMGroupMemberInfo> getMemberList() {
        GroupTipsElement groupTipsElement;
        if (getElement() == null || (groupTipsElement = (GroupTipsElement) getElement()) == null) {
            return null;
        }
        List<GroupMemberInfo> targetGroupMemberInfoList = groupTipsElement.getTargetGroupMemberInfoList();
        List<UserInfo> targetUserInfoList = groupTipsElement.getTargetUserInfoList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (GroupMemberInfo groupMemberInfo : targetGroupMemberInfoList) {
            V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
            v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
            hashMap.put(groupMemberInfo.getUserID(), v2TIMGroupMemberInfo);
        }
        for (UserInfo userInfo : targetUserInfoList) {
            V2TIMGroupMemberInfo v2TIMGroupMemberInfo2 = (V2TIMGroupMemberInfo) hashMap.get(userInfo.getUserID());
            if (v2TIMGroupMemberInfo2 != null) {
                v2TIMGroupMemberInfo2.setUserInfo(userInfo);
                arrayList.add(v2TIMGroupMemberInfo2);
            }
        }
        return arrayList;
    }

    public V2TIMGroupMemberInfo getOpMember() {
        GroupTipsElement groupTipsElement;
        if (getElement() == null || (groupTipsElement = (GroupTipsElement) getElement()) == null) {
            return null;
        }
        GroupMemberInfo operatorGroupMemberInfo = groupTipsElement.getOperatorGroupMemberInfo();
        UserInfo operatorUserInfo = groupTipsElement.getOperatorUserInfo();
        V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
        v2TIMGroupMemberInfo.setGroupMemberInfo(operatorGroupMemberInfo);
        v2TIMGroupMemberInfo.setUserInfo(operatorUserInfo);
        return v2TIMGroupMemberInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (getGroupType().equals("Private") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getType() {
        GroupTipsElement groupTipsElement = (GroupTipsElement) getElement();
        if (groupTipsElement == null) {
            return 0;
        }
        int groupTipsType = groupTipsElement.getGroupTipsType();
        int i3 = 2;
        int i16 = 1;
        if (groupTipsType != 1) {
            i16 = 3;
            if (groupTipsType != 2) {
                i3 = 4;
                if (groupTipsType != 3) {
                    i16 = 5;
                    if (groupTipsType != 4) {
                        i3 = 6;
                        if (groupTipsType != 5) {
                            i16 = 7;
                            if (groupTipsType != 6) {
                                if (groupTipsType != 7) {
                                    return 0;
                                }
                                return 8;
                            }
                        }
                    }
                }
                return i3;
            }
            return i16;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        for (V2TIMGroupChangeInfo v2TIMGroupChangeInfo : getGroupChangeInfoList()) {
            sb5.append("sub type:");
            sb5.append(v2TIMGroupChangeInfo.getType());
            sb5.append(", key:");
            sb5.append(v2TIMGroupChangeInfo.getKey());
            sb5.append(", value:");
            sb5.append(v2TIMGroupChangeInfo.getValue());
            sb5.append("\n");
        }
        StringBuilder sb6 = new StringBuilder();
        for (V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo : getMemberChangeInfoList()) {
            sb6.append("userID:");
            sb6.append(v2TIMGroupMemberChangeInfo.getUserID());
            sb6.append(", muteTime:");
            sb6.append(v2TIMGroupMemberChangeInfo.getMuteTime());
            sb6.append("\n");
        }
        List<V2TIMGroupMemberInfo> memberList = getMemberList();
        StringBuilder sb7 = new StringBuilder();
        Iterator<V2TIMGroupMemberInfo> it = memberList.iterator();
        while (it.hasNext()) {
            sb7.append(it.next().toString());
            sb7.append("\n");
        }
        V2TIMGroupMemberInfo opMember = getOpMember();
        if (opMember != null) {
            str = opMember.toString();
        } else {
            str = "";
        }
        return "V2TIMGroupTipsElem--->groupID:" + getGroupID() + ", tips type:" + getType() + ", memberCount:" + getMemberCount() + "\n, memberList:\n" + sb7.toString() + ", groupChangedInfoList:\n" + sb5.toString() + ", memberChangedInfoList:\n" + sb6.toString() + ", opUser:" + str;
    }
}
