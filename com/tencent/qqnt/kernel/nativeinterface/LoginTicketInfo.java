package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LoginTicketInfo {
    public long appId;
    public long expireTime;
    public long generateTime;
    public long nextRefreshTime;

    /* renamed from: a1, reason: collision with root package name */
    public byte[] f359192a1 = new byte[0];

    /* renamed from: a2, reason: collision with root package name */
    public byte[] f359193a2 = new byte[0];

    /* renamed from: d2, reason: collision with root package name */
    public byte[] f359194d2 = new byte[0];
    public byte[] d2Key = new byte[0];

    public byte[] getA1() {
        return this.f359192a1;
    }

    public byte[] getA2() {
        return this.f359193a2;
    }

    public long getAppId() {
        return this.appId;
    }

    public byte[] getD2() {
        return this.f359194d2;
    }

    public byte[] getD2Key() {
        return this.d2Key;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public long getGenerateTime() {
        return this.generateTime;
    }

    public long getNextRefreshTime() {
        return this.nextRefreshTime;
    }

    public String toString() {
        return "LoginTicketInfo{a1=" + this.f359192a1 + ",a2=" + this.f359193a2 + ",d2=" + this.f359194d2 + ",d2Key=" + this.d2Key + ",generateTime=" + this.generateTime + ",nextRefreshTime=" + this.nextRefreshTime + ",expireTime=" + this.expireTime + ",appId=" + this.appId + ",}";
    }
}
