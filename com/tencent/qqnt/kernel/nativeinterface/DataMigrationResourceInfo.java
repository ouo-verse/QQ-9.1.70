package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DataMigrationResourceInfo {
    public String extraData;
    public String filePath;
    public long fileSize;
    public long msgRandom;
    public long msgSeq;
    public int msgSubType;
    public int msgType;

    public DataMigrationResourceInfo() {
        this.filePath = "";
        this.extraData = "";
    }

    public String getExtraData() {
        return this.extraData;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getMsgRandom() {
        return this.msgRandom;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public int getMsgSubType() {
        return this.msgSubType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String toString() {
        return "DataMigrationResourceInfo{msgSeq=" + this.msgSeq + ",msgRandom=" + this.msgRandom + ",msgType=" + this.msgType + ",msgSubType=" + this.msgSubType + ",filePath=" + this.filePath + ",fileSize=" + this.fileSize + ",extraData=" + this.extraData + ",}";
    }

    public DataMigrationResourceInfo(long j3, long j16, int i3, int i16, String str, long j17, String str2) {
        this.msgSeq = j3;
        this.msgRandom = j16;
        this.msgType = i3;
        this.msgSubType = i16;
        this.filePath = str;
        this.fileSize = j17;
        this.extraData = str2;
    }
}
