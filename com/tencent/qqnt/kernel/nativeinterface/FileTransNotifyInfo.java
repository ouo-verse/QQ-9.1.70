package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileTransNotifyInfo {
    public int businessId;
    public Integer chatType;
    public String clientMsg;
    public CommonFileInfo commonFileInfo;
    public int fileDownType;
    public long fileErrCode;
    public String fileErrMsg;
    public String fileId;
    public long fileModelId;
    public String filePath;
    public long fileProgress;
    public long fileSpeed;
    public long fileSrvErrCode;
    public long msgElementId;
    public long msgId;
    public MsgRecord msgRecord;
    public int step;
    public int thumbSize;
    public long totalSize;
    public int trasferStatus;
    public Long userTotalSpacePerDay;
    public Long userUsedSpacePerDay;

    public FileTransNotifyInfo() {
        this.fileId = "";
        this.fileErrMsg = "";
        this.filePath = "";
        this.clientMsg = "";
    }

    public int getBusinessId() {
        return this.businessId;
    }

    public Integer getChatType() {
        return this.chatType;
    }

    public String getClientMsg() {
        return this.clientMsg;
    }

    public CommonFileInfo getCommonFileInfo() {
        return this.commonFileInfo;
    }

    public int getFileDownType() {
        return this.fileDownType;
    }

    public long getFileErrCode() {
        return this.fileErrCode;
    }

    public String getFileErrMsg() {
        return this.fileErrMsg;
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileModelId() {
        return this.fileModelId;
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

    public long getFileSrvErrCode() {
        return this.fileSrvErrCode;
    }

    public long getMsgElementId() {
        return this.msgElementId;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    public int getStep() {
        return this.step;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getTrasferStatus() {
        return this.trasferStatus;
    }

    public Long getUserTotalSpacePerDay() {
        return this.userTotalSpacePerDay;
    }

    public Long getUserUsedSpacePerDay() {
        return this.userUsedSpacePerDay;
    }

    public String toString() {
        return "FileTransNotifyInfo{fileModelId=" + this.fileModelId + ",msgElementId=" + this.msgElementId + ",msgId=" + this.msgId + ",fileId=" + this.fileId + ",fileProgress=" + this.fileProgress + ",fileSpeed=" + this.fileSpeed + ",fileErrCode=" + this.fileErrCode + ",fileErrMsg=" + this.fileErrMsg + ",fileDownType=" + this.fileDownType + ",thumbSize=" + this.thumbSize + ",filePath=" + this.filePath + ",totalSize=" + this.totalSize + ",trasferStatus=" + this.trasferStatus + ",step=" + this.step + ",commonFileInfo=" + this.commonFileInfo + ",fileSrvErrCode=" + this.fileSrvErrCode + ",clientMsg=" + this.clientMsg + ",businessId=" + this.businessId + ",userTotalSpacePerDay=" + this.userTotalSpacePerDay + ",userUsedSpacePerDay=" + this.userUsedSpacePerDay + ",msgRecord=" + this.msgRecord + ",chatType=" + this.chatType + ",}";
    }

    public FileTransNotifyInfo(long j3, long j16, long j17, String str, long j18, long j19, long j26, String str2, int i3, int i16, String str3, long j27, int i17, int i18, CommonFileInfo commonFileInfo, long j28, String str4, int i19, Long l3, Long l16, MsgRecord msgRecord, Integer num) {
        this.fileModelId = j3;
        this.msgElementId = j16;
        this.msgId = j17;
        this.fileId = str;
        this.fileProgress = j18;
        this.fileSpeed = j19;
        this.fileErrCode = j26;
        this.fileErrMsg = str2;
        this.fileDownType = i3;
        this.thumbSize = i16;
        this.filePath = str3;
        this.totalSize = j27;
        this.trasferStatus = i17;
        this.step = i18;
        this.commonFileInfo = commonFileInfo;
        this.fileSrvErrCode = j28;
        this.clientMsg = str4;
        this.businessId = i19;
        this.userTotalSpacePerDay = l3;
        this.userUsedSpacePerDay = l16;
        this.msgRecord = msgRecord;
        this.chatType = num;
    }
}
