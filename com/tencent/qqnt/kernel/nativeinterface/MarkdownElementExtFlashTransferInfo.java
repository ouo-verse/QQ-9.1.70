package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MarkdownElementExtFlashTransferInfo {
    public long fileSize;
    public String filesetId;
    public String name;
    public Picture thnumbnail;

    public MarkdownElementExtFlashTransferInfo() {
        this.filesetId = "";
        this.name = "";
        this.thnumbnail = new Picture();
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFilesetId() {
        return this.filesetId;
    }

    public String getName() {
        return this.name;
    }

    public Picture getThnumbnail() {
        return this.thnumbnail;
    }

    public String toString() {
        return "MarkdownElementExtFlashTransferInfo{filesetId=" + this.filesetId + ",name=" + this.name + ",fileSize=" + this.fileSize + ",thnumbnail=" + this.thnumbnail + ",}";
    }

    public MarkdownElementExtFlashTransferInfo(String str, String str2, long j3, Picture picture) {
        this.filesetId = "";
        this.name = "";
        new Picture();
        this.filesetId = str;
        this.name = str2;
        this.fileSize = j3;
        this.thnumbnail = picture;
    }
}
