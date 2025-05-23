package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WTLoginRecordSnapshot {
    public long a2GenerateTime;
    public int appid;
    public long expireTime;
    public long uin;
    public String uid = "";

    /* renamed from: a1, reason: collision with root package name */
    public byte[] f422864a1 = new byte[0];
    public byte[] a1Key = new byte[0];
    public byte[] noPicSig = new byte[0];

    /* renamed from: a2, reason: collision with root package name */
    public byte[] f422865a2 = new byte[0];
    public byte[] a2Key = new byte[0];

    /* renamed from: d2, reason: collision with root package name */
    public byte[] f422866d2 = new byte[0];
    public byte[] d2Key = new byte[0];
    public String account = "";

    public byte[] getA1() {
        return this.f422864a1;
    }

    public byte[] getA1Key() {
        return this.a1Key;
    }

    public byte[] getA2() {
        return this.f422865a2;
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
        return this.f422866d2;
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
        return "WTLoginRecord{uin=" + this.uin + ",appid=" + this.appid + ",uid=" + this.uid + ",a1=" + util.buf_to_string(this.f422864a1) + ",a1Key=" + util.buf_to_string(this.a1Key) + ",noPicSig=" + util.buf_to_string(this.noPicSig) + ",a2=" + util.buf_to_string(this.f422865a2) + ",a2Key" + util.buf_to_string(this.a2Key) + ",d2=" + util.buf_to_string(this.f422866d2) + ",d2Key=" + util.buf_to_string(this.d2Key) + ",a2GenerateTime=" + this.a2GenerateTime + ",expireTime=" + this.expireTime + ",account=" + this.account + ",}";
    }
}
