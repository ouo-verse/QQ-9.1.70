package com.tencent.mobileqq.uftransfer.guild;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends com.tencent.mobileqq.uftransfer.api.e {

    /* renamed from: g, reason: collision with root package name */
    String f305227g;

    /* renamed from: h, reason: collision with root package name */
    String f305228h;

    /* renamed from: i, reason: collision with root package name */
    long f305229i;

    /* renamed from: j, reason: collision with root package name */
    String f305230j;

    public String m() {
        return this.f305228h;
    }

    public String n() {
        return this.f305230j;
    }

    public String o() {
        return this.f305227g;
    }

    public long p() {
        return this.f305229i;
    }

    public void q(String str) {
        this.f305228h = str;
    }

    public void r(String str) {
        this.f305230j = str;
    }

    public void s(String str) {
        this.f305227g = str;
    }

    public void t(long j3) {
        this.f305229i = j3;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.e
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" mGuildId = " + this.f305227g);
        sb5.append(" mChannelId = " + this.f305228h);
        return super.toString() + sb5.toString();
    }
}
