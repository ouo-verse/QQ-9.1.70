package com.tencent.imsdk.relationship;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FriendOperationResult implements Serializable {
    private int resultCode;
    private String resultInfo;
    private String userID;

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public String getUserID() {
        return this.userID;
    }
}
