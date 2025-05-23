package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class WTLoginRecord {
    public long a2GenerateTime;
    public int appid;
    public long expireTime;
    public long uin;
    public String uid = "";

    /* renamed from: a1, reason: collision with root package name */
    public byte[] f359236a1 = new byte[0];
    public byte[] a1Key = new byte[0];
    public byte[] noPicSig = new byte[0];

    /* renamed from: a2, reason: collision with root package name */
    public byte[] f359237a2 = new byte[0];
    public byte[] a2Key = new byte[0];

    /* renamed from: d2, reason: collision with root package name */
    public byte[] f359238d2 = new byte[0];
    public byte[] d2Key = new byte[0];
    public String account = "";

    public byte[] getA1() {
        return this.f359236a1;
    }

    public byte[] getA1Key() {
        return this.a1Key;
    }

    public byte[] getA2() {
        return this.f359237a2;
    }

    public long getA2GenerateTime() {
        return this.a2GenerateTime;
    }

    public byte[] getA2Key() {
        return this.a2Key;
    }

    public String getAccount() {
        return this.account;
    }

    public int getAppid() {
        return this.appid;
    }

    public byte[] getD2() {
        return this.f359238d2;
    }

    public byte[] getD2Key() {
        return this.d2Key;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public byte[] getNoPicSig() {
        return this.noPicSig;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "WTLoginRecord{uin=" + this.uin + ",appid=" + this.appid + ",uid=" + this.uid + ",a1=" + this.f359236a1 + ",a1Key=" + this.a1Key + ",noPicSig=" + this.noPicSig + ",a2=" + this.f359237a2 + ",a2Key=" + this.a2Key + ",d2=" + this.f359238d2 + ",d2Key=" + this.d2Key + ",a2GenerateTime=" + this.a2GenerateTime + ",expireTime=" + this.expireTime + ",account=" + this.account + ",}";
    }
}
