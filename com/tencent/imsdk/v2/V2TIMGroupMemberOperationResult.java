package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberOperationResult;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupMemberOperationResult implements Serializable {
    public static final int OPERATION_RESULT_FAIL = 0;
    public static final int OPERATION_RESULT_INVALID = 2;
    public static final int OPERATION_RESULT_OVERLIMIT = 4;
    public static final int OPERATION_RESULT_PENDING = 3;
    public static final int OPERATION_RESULT_SUCC = 1;
    GroupMemberOperationResult groupMemberOperationResult = new GroupMemberOperationResult();

    public String getMemberID() {
        return this.groupMemberOperationResult.getUserID();
    }

    public int getResult() {
        int status = this.groupMemberOperationResult.getStatus();
        if (status == GroupMemberOperationResult.OPERATION_RESULT_FAIL) {
            return 0;
        }
        if (status == GroupMemberOperationResult.OPERATION_RESULT_INVALID) {
            return 2;
        }
        if (status == GroupMemberOperationResult.OPERATION_RESULT_PENDING) {
            return 3;
        }
        if (status == GroupMemberOperationResult.OPERATION_RESULT_SUCCESS) {
            return 1;
        }
        if (status != GroupMemberOperationResult.OPERATION_RESULT_OVERLIMIT) {
            return 0;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupMemberOperationResult(GroupMemberOperationResult groupMemberOperationResult) {
        this.groupMemberOperationResult = groupMemberOperationResult;
    }
}
