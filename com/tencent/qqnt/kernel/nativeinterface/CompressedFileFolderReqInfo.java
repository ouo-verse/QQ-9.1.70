package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CompressedFileFolderReqInfo {
    public int count;
    public int reqDepth;
    public String parentId = "";
    public byte[] paginationInfo = new byte[0];
    public FileFilterType filterType = FileFilterType.values()[0];

    public int getCount() {
        return this.count;
    }

    public FileFilterType getFilterType() {
        return this.filterType;
    }

    public byte[] getPaginationInfo() {
        return this.paginationInfo;
    }

    public String getParentId() {
        return this.parentId;
    }

    public int getReqDepth() {
        return this.reqDepth;
    }
}
