package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetUserList {
    public int getNum;
    public long startIndex;
    public long startUin;
    public int uint32GetType;
    public int uint32SortType;

    public int getGetNum() {
        return this.getNum;
    }

    public long getStartIndex() {
        return this.startIndex;
    }

    public long getStartUin() {
        return this.startUin;
    }

    public int getUint32GetType() {
        return this.uint32GetType;
    }

    public int getUint32SortType() {
        return this.uint32SortType;
    }

    public String toString() {
        return "GProGetUserList{uint32GetType=" + this.uint32GetType + ",uint32SortType=" + this.uint32SortType + ",startIndex=" + this.startIndex + ",startUin=" + this.startUin + ",getNum=" + this.getNum + ",}";
    }
}
