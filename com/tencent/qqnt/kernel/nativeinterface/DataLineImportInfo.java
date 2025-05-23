package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DataLineImportInfo {
    public long maxId;
    public int msgCount;
    public String tableName;

    public DataLineImportInfo() {
        this.tableName = "";
    }

    public long getMaxId() {
        return this.maxId;
    }

    public int getMsgCount() {
        return this.msgCount;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String toString() {
        return "DataLineImportInfo{tableName=" + this.tableName + ",msgCount=" + this.msgCount + ",maxId=" + this.maxId + ",}";
    }

    public DataLineImportInfo(String str, int i3, long j3) {
        this.tableName = str;
        this.msgCount = i3;
        this.maxId = j3;
    }
}
