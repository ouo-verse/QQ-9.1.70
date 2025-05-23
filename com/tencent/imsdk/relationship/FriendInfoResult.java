package com.tencent.imsdk.relationship;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FriendInfoResult implements Serializable {
    private int errorCode;
    private String errorMessage;
    private FriendInfo friendInfo;
    private int relationType;
    private String userID;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public FriendInfo getFriendInfo() {
        return this.friendInfo;
    }

    public int getRelationType() {
        return this.relationType;
    }

    public String getUserID() {
        return this.userID;
    }
}
