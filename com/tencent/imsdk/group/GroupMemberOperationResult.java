package com.tencent.imsdk.group;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GroupMemberOperationResult implements Serializable {
    public static int OPERATION_RESULT_FAIL = 1;
    public static int OPERATION_RESULT_INVALID = 3;
    public static int OPERATION_RESULT_OVERLIMIT = 5;
    public static int OPERATION_RESULT_PENDING = 4;
    public static int OPERATION_RESULT_SUCCESS = 2;
    private int status;
    private String userID;

    public int getStatus() {
        return this.status;
    }

    public String getUserID() {
        return this.userID;
    }
}
