package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBroadcastHelperTransNotifyInfo {
    public long fileErrCode;
    public String fileErrMsg;
    public String filePath;
    public long fileProgress;
    public long fileSpeed;
    public long totalSize;
    public int trasferStatus;

    public GProBroadcastHelperTransNotifyInfo() {
        this.fileErrMsg = "";
        this.filePath = "";
    }

    public long getFileErrCode() {
        return this.fileErrCode;
    }

    public String getFileErrMsg() {
        return this.fileErrMsg;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileProgress() {
        return this.fileProgress;
    }

    public long getFileSpeed() {
        return this.fileSpeed;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getTrasferStatus() {
        return this.trasferStatus;
    }

    public String toString() {
        return "GProBroadcastHelperTransNotifyInfo{fileProgress=" + this.fileProgress + ",fileSpeed=" + this.fileSpeed + ",fileErrCode=" + this.fileErrCode + ",fileErrMsg=" + this.fileErrMsg + ",filePath=" + this.filePath + ",totalSize=" + this.totalSize + ",trasferStatus=" + this.trasferStatus + ",}";
    }

    public GProBroadcastHelperTransNotifyInfo(long j3, long j16, long j17, String str, String str2, long j18, int i3) {
        this.fileProgress = j3;
        this.fileSpeed = j16;
        this.fileErrCode = j17;
        this.fileErrMsg = str;
        this.filePath = str2;
        this.totalSize = j18;
        this.trasferStatus = i3;
    }
}
