package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class IndexNode {
    public int bigDataAppid;
    public FileInfo fileInfo = new FileInfo();
    public String fileUuid = "";
    public int storeAppid;
    public int storeId;
    public int subType;
    public long ttl;
    public long uploadTime;

    public int getBigDataAppid() {
        return this.bigDataAppid;
    }

    public FileInfo getFileInfo() {
        return this.fileInfo;
    }

    public String getFileUuid() {
        return this.fileUuid;
    }

    public int getStoreAppid() {
        return this.storeAppid;
    }

    public int getStoreId() {
        return this.storeId;
    }

    public int getSubType() {
        return this.subType;
    }

    public long getTtl() {
        return this.ttl;
    }

    public long getUploadTime() {
        return this.uploadTime;
    }
}
