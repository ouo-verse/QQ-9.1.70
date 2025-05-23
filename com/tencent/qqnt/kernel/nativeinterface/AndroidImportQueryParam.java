package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class AndroidImportQueryParam {
    public int count;
    public boolean isQuickDb;
    public long startIndex;
    public String tableName;

    public AndroidImportQueryParam() {
        this.tableName = "";
    }

    public int getCount() {
        return this.count;
    }

    public boolean getIsQuickDb() {
        return this.isQuickDb;
    }

    public long getStartIndex() {
        return this.startIndex;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String toString() {
        return "AndroidImportQueryParam{tableName=" + this.tableName + ",startIndex=" + this.startIndex + ",count=" + this.count + ",isQuickDb=" + this.isQuickDb + ",}";
    }

    public AndroidImportQueryParam(String str, long j3, int i3, boolean z16) {
        this.tableName = str;
        this.startIndex = j3;
        this.count = i3;
        this.isQuickDb = z16;
    }
}
