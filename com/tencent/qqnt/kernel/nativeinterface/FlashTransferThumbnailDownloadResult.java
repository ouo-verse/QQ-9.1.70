package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FlashTransferThumbnailDownloadResult {
    public int result;
    public FlashTransferThumbnailInfo originInfo = new FlashTransferThumbnailInfo();
    public String thumbnailDiskPath = "";

    public FlashTransferThumbnailInfo getOriginInfo() {
        return this.originInfo;
    }

    public int getResult() {
        return this.result;
    }

    public String getThumbnailDiskPath() {
        return this.thumbnailDiskPath;
    }
}
