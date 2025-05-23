package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FlashTransferUploadThumbnailInfo {
    public int result;
    public String errMsg = "";
    public String fileSetId = "";
    public String cliFileId = "";
    public String thumbnailPath = "";

    public String getCliFileId() {
        return this.cliFileId;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public int getResult() {
        return this.result;
    }

    public String getThumbnailPath() {
        return this.thumbnailPath;
    }
}
