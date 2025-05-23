package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class DataLineImportQueryParam {
    public int readCount;
    public long startIndex;
    public String tableName;

    public DataLineImportQueryParam() {
        this.tableName = "";
    }

    public int getReadCount() {
        return this.readCount;
    }

    public long getStartIndex() {
        return this.startIndex;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String toString() {
        return "DataLineImportQueryParam{tableName=" + this.tableName + ",startIndex=" + this.startIndex + ",readCount=" + this.readCount + ",}";
    }

    public DataLineImportQueryParam(String str, long j3, int i3) {
        this.tableName = str;
        this.startIndex = j3;
        this.readCount = i3;
    }
}
