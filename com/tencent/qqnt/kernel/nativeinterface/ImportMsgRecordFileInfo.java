package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ImportMsgRecordFileInfo {
    public ArrayList<ImportMsgFilePath> filePaths;
    public int fileStatus;
    public int fileType;
    public String fileUuid;

    public ImportMsgRecordFileInfo() {
        this.fileUuid = "";
        this.filePaths = new ArrayList<>();
    }

    public ArrayList<ImportMsgFilePath> getFilePaths() {
        return this.filePaths;
    }

    public int getFileStatus() {
        return this.fileStatus;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public String toString() {
        return "ImportMsgRecordFileInfo{fileType=" + this.fileType + ",fileStatus=" + this.fileStatus + ",fileUuid=" + this.fileUuid + ",filePaths=" + this.filePaths + ",}";
    }

    public ImportMsgRecordFileInfo(int i3, int i16, String str, ArrayList<ImportMsgFilePath> arrayList) {
        this.fileUuid = "";
        new ArrayList();
        this.fileType = i3;
        this.fileStatus = i16;
        this.fileUuid = str;
        this.filePaths = arrayList;
    }
}
