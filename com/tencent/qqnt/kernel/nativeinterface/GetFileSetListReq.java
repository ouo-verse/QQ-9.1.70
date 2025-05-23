package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFileSetListReq {
    public boolean isUseCache;
    public int limit;
    public FileSetListType listType = FileSetListType.values()[0];
    public byte[] paginationInfo = new byte[0];
    public int seq;

    public boolean getIsUseCache() {
        return this.isUseCache;
    }

    public int getLimit() {
        return this.limit;
    }

    public FileSetListType getListType() {
        return this.listType;
    }

    public byte[] getPaginationInfo() {
        return this.paginationInfo;
    }

    public int getSeq() {
        return this.seq;
    }
}
