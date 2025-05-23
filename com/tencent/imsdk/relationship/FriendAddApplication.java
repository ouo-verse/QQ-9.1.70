package com.tencent.imsdk.relationship;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FriendAddApplication implements Serializable {
    private String addSource;
    private int addType;
    private String addWording;
    private String groupName;
    private String remark;
    private String userID;

    public void setAddSource(String str) {
        this.addSource = str;
    }

    public void setAddType(int i3) {
        this.addType = i3;
    }

    public void setAddWording(String str) {
        this.addWording = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
