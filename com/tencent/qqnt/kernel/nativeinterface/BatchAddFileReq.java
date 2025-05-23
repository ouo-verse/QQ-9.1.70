package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchAddFileReq {
    public long currReqSerialNumber;
    public int lastReqSerialNumber;
    public BusiScene scene = BusiScene.values()[0];
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

    public int getLastReqSerialNumber() {
        return this.lastReqSerialNumber;
    }

    public BusiScene getScene() {
        return this.scene;
    }

    public String getTaskId() {
        return this.taskId;
    }
}
