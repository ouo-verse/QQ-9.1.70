package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LastTofu {
    public long busiID;
    public String busiUUID;
    public DeleteStatus deleteFlag;

    public LastTofu() {
        this.busiUUID = "";
    }

    public long getBusiID() {
        return this.busiID;
    }

    public String getBusiUUID() {
        return this.busiUUID;
    }

    public DeleteStatus getDeleteFlag() {
        return this.deleteFlag;
    }

    public LastTofu(long j3, String str, DeleteStatus deleteStatus) {
        this.busiID = j3;
        this.busiUUID = str;
        this.deleteFlag = deleteStatus;
    }
}
