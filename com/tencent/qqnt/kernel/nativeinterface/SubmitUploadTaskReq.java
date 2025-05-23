package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SubmitUploadTaskReq {
    public String taskId = "";
    public TaskStatus status = TaskStatus.values()[0];

    public TaskStatus getStatus() {
        return this.status;
    }

    public String getTaskId() {
        return this.taskId;
    }
}
