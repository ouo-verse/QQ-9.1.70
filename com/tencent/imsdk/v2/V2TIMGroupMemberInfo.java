package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupMemberInfo implements Serializable {
    GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
    UserInfo userInfo;

    public String getFaceUrl() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getFaceUrl())) {
            return this.groupMemberInfo.getFaceUrl();
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            return userInfo.getFaceUrl();
        }
        return "";
    }

    public String getFriendRemark() {
        return this.groupMemberInfo.getFriendRemark();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupMemberInfo getGroupMemberInfo() {
        return this.groupMemberInfo;
    }

    public String getNameCard() {
        return this.groupMemberInfo.getNameCard();
    }

    public String getNickName() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getNickname())) {
            return this.groupMemberInfo.getNickname();
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            return userInfo.getNickname();
        }
        return "";
    }

    public String getUserID() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getUserID())) {
            return this.groupMemberInfo.getUserID();
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            return userInfo.getUserID();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupMemberInfo(GroupMemberInfo groupMemberInfo) {
        this.groupMemberInfo = groupMemberInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString() {
        return "V2TIMGroupMemberInfo--->userID:" + getUserID() + ", nickName:" + getNickName() + ", nameCard:" + getNameCard() + ", friendRemark:" + getFriendRemark() + ", faceUrl:" + getFaceUrl();
    }
}
