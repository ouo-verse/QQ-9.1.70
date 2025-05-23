package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class UpdateFlashTransferParam {
    public String fileSetId = "";
    public String name = "";
    public FileSetStatus status = FileSetStatus.values()[0];

    public String getFileSetId() {
        return this.fileSetId;
    }

    public String getName() {
        return this.name;
    }

    public FileSetStatus getStatus() {
        return this.status;
    }
}
