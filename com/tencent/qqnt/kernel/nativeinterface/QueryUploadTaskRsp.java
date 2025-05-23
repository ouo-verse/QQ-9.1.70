package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QueryUploadTaskRsp {
    public TaskStatus status = TaskStatus.values()[0];
    public ArrayList<Integer> retryReqSerialNumbers = new ArrayList<>();
    public String reqTag = "";
    public ArrayList<File> fileList = new ArrayList<>();
    public ArrayList<ClientRetryFileInfo> needRetryFileList = new ArrayList<>();
    public ClientPollControl pollControl = new ClientPollControl();

    public ArrayList<File> getFileList() {
        return this.fileList;
    }

    public ArrayList<ClientRetryFileInfo> getNeedRetryFileList() {
        return this.needRetryFileList;
    }

    public ClientPollControl getPollControl() {
        return this.pollControl;
    }

    public String getReqTag() {
        return this.reqTag;
    }

    public ArrayList<Integer> getRetryReqSerialNumbers() {
        return this.retryReqSerialNumbers;
    }

    public TaskStatus getStatus() {
        return this.status;
    }
}
