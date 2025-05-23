package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FlashTransferThumbnailInfo {
    public String fileSetId = "";
    public String fileId = "";
    public Specification spec = Specification.values()[0];
    public String url = "";

    public String getFileId() {
        return this.fileId;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public Specification getSpec() {
        return this.spec;
    }

    public String getUrl() {
        return this.url;
    }
}
