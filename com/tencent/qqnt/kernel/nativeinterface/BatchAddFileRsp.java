package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchAddFileRsp {
    public long currReqSerialNumber;
    public String taskId = "";
    public String fileSetId = "";
    public ArrayList<File> fileList = new ArrayList<>();

    public long getCurrReqSerialNumber() {
        return this.currReqSerialNumber;
    }

    public ArrayList<File> getFileList() {
        return this.fileList;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public String getTaskId() {
        return this.taskId;
    }
}
