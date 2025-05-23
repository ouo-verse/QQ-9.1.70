package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    protected long f266656a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266657b;

    /* renamed from: c, reason: collision with root package name */
    protected int f266658c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f266659d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f266660e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f266661f;

    /* renamed from: g, reason: collision with root package name */
    protected int f266662g;

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f266663h = new byte[0];

    public long a() {
        return this.f266657b;
    }

    public long b() {
        return this.f266656a;
    }

    public boolean c() {
        return this.f266659d;
    }

    public byte[] d() {
        return this.f266663h;
    }

    public int e() {
        return this.f266662g;
    }

    public int f() {
        return this.f266658c;
    }

    public boolean g() {
        return this.f266660e;
    }

    public boolean h() {
        return this.f266661f;
    }

    public void i(long j3) {
        this.f266657b = j3;
    }

    public void j(long j3) {
        this.f266656a = j3;
    }

    public void k(boolean z16) {
        this.f266659d = z16;
    }

    public void l(byte[] bArr) {
        this.f266663h = bArr;
    }

    public void m(int i3) {
        this.f266662g = i3;
    }

    public void n(int i3) {
        this.f266658c = i3;
    }

    public void o(boolean z16) {
        this.f266660e = z16;
    }

    public void p(boolean z16) {
        this.f266661f = z16;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProAudioLiveUserListReq{mGuildId=");
        sb5.append(this.f266656a);
        sb5.append("mChannelId=");
        sb5.append(this.f266657b);
        sb5.append("mOnceGetNum=");
        sb5.append(this.f266658c);
        sb5.append("mNeedChannelState=");
        sb5.append(this.f266659d);
        sb5.append("mOnlyHandUpList=");
        sb5.append(this.f266660e);
        sb5.append("mOnlySpeakOrderList=");
        sb5.append(this.f266661f);
        sb5.append("mNumIndex=");
        sb5.append(this.f266662g);
        sb5.append("mNeedDecodeData.length=");
        byte[] bArr = this.f266663h;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("}");
        return sb5.toString();
    }
}
