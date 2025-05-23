package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ImportRecentUser {
    public int type;
    public String uin;

    public ImportRecentUser() {
        this.uin = "";
    }

    public int getType() {
        return this.type;
    }

    public String getUin() {
        return this.uin;
    }

    public String toString() {
        return "ImportRecentUser{uin=" + this.uin + ",type=" + this.type + ",}";
    }

    public ImportRecentUser(String str, int i3) {
        this.uin = str;
        this.type = i3;
    }
}
