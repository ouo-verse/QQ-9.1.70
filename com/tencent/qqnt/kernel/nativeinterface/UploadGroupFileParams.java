package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class UploadGroupFileParams {
    public long fileModelId;
    public String fileName;
    public String filePath;

    public UploadGroupFileParams() {
        this.fileName = "";
        this.filePath = "";
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public UploadGroupFileParams(String str, String str2, long j3) {
        this.fileName = str;
        this.filePath = str2;
        this.fileModelId = j3;
    }
}
