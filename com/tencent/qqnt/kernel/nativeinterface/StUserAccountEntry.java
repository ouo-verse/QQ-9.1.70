package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StUserAccountEntry {
    public StUserAccountBaseMate account;
    public String uid;

    public StUserAccountEntry() {
        this.uid = "";
        this.account = new StUserAccountBaseMate();
    }

    public StUserAccountBaseMate getAccount() {
        return this.account;
    }

    public String getUid() {
        return this.uid;
    }

    public StUserAccountEntry(String str, StUserAccountBaseMate stUserAccountBaseMate) {
        this.uid = "";
        new StUserAccountBaseMate();
        this.uid = str;
        this.account = stUserAccountBaseMate;
    }
}
