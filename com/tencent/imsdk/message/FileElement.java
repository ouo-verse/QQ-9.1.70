package com.tencent.imsdk.message;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FileElement extends MessageBaseElement {
    private int fileBusinessID;
    private int fileDownloadFlag;
    private String fileDownloadUrl;
    private String fileName;
    private String filePath;
    private int fileSize;
    private String fileUUID;

    public FileElement() {
        setElementType(6);
    }

    public int getFileBusinessID() {
        return this.fileBusinessID;
    }

    public int getFileDownloadFlag() {
        return this.fileDownloadFlag;
    }

    public String getFileDownloadUrl() {
        return this.fileDownloadUrl;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getFileUUID() {
        return this.fileUUID;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.imsdk.message.MessageBaseElement
    public boolean update(MessageBaseElement messageBaseElement) {
        if (this.elementType == messageBaseElement.elementType) {
            FileElement fileElement = (FileElement) messageBaseElement;
            if (this.filePath.equals(fileElement.filePath)) {
                this.fileUUID = fileElement.fileUUID;
                this.fileName = fileElement.fileName;
                this.fileSize = fileElement.fileSize;
                this.fileDownloadFlag = fileElement.fileDownloadFlag;
                this.fileDownloadUrl = fileElement.fileDownloadUrl;
                this.fileBusinessID = fileElement.fileBusinessID;
                return true;
            }
            return false;
        }
        return false;
    }
}
