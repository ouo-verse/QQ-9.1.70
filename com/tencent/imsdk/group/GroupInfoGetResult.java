package com.tencent.imsdk.group;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GroupInfoGetResult implements Serializable {
    private int errorCode;
    private String errorMessage;
    private String groupID;
    private GroupInfo groupInfo;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public void setErrorCode(int i3) {
        this.errorCode = i3;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }
}
