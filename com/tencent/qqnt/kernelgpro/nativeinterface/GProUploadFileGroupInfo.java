package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUploadFileGroupInfo implements Serializable {
    public int errorCode;
    public long totalFileSize;
    public long totalUploadFileSize;
    long serialVersionUID = 1;
    public String fileGroupId = "";
    public GProUploadStatus uploadStatus = GProUploadStatus.values()[0];
    public String errorMsg = "";
    public ArrayList<String> childFileIds = new ArrayList<>();
    public String extInfo = "";

    public ArrayList<String> getChildFileIds() {
        return this.childFileIds;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public String getFileGroupId() {
        return this.fileGroupId;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public long getTotalUploadFileSize() {
        return this.totalUploadFileSize;
    }

    public GProUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public String toString() {
        return "GProUploadFileGroupInfo{fileGroupId=" + this.fileGroupId + ",uploadStatus=" + this.uploadStatus + ",totalFileSize=" + this.totalFileSize + ",totalUploadFileSize=" + this.totalUploadFileSize + ",errorCode=" + this.errorCode + ",errorMsg=" + this.errorMsg + ",childFileIds=" + this.childFileIds + ",extInfo=" + this.extInfo + ",}";
    }
}
