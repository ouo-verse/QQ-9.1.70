package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RevealDoufuInfo {
    public long bid;
    public String uid;
    public String uuid;

    public RevealDoufuInfo() {
        this.uid = "";
        this.uuid = "";
    }

    public long getBid() {
        return this.bid;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public RevealDoufuInfo(String str, long j3, String str2) {
        this.uid = str;
        this.bid = j3;
        this.uuid = str2;
    }
}
