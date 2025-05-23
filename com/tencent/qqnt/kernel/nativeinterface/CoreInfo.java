package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CoreInfo {
    public String nick;
    public String remark;
    public String uid;
    public long uin;

    public CoreInfo() {
        this.uid = "";
    }

    public String getNick() {
        return this.nick;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public CoreInfo(String str, long j3, String str2, String str3) {
        this.uid = str;
        this.uin = j3;
        this.nick = str2;
        this.remark = str3;
    }
}
