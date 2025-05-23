package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class eg {

    /* renamed from: a, reason: collision with root package name */
    protected long f266504a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266505b;

    /* renamed from: e, reason: collision with root package name */
    protected int f266508e;

    /* renamed from: c, reason: collision with root package name */
    protected String f266506c = "";

    /* renamed from: d, reason: collision with root package name */
    protected byte[] f266507d = new byte[0];

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<Long> f266509f = new ArrayList<>();

    public ArrayList<Long> a() {
        return this.f266509f;
    }

    public byte[] b() {
        return this.f266507d;
    }

    public int c() {
        return this.f266508e;
    }

    public long d() {
        return this.f266505b;
    }

    public String e() {
        return this.f266506c;
    }

    public long f() {
        return this.f266504a;
    }

    public void g(ArrayList<Long> arrayList) {
        this.f266509f = arrayList;
    }

    public void h(byte[] bArr) {
        this.f266507d = bArr;
    }

    public void i(int i3) {
        this.f266508e = i3;
    }

    public void j(long j3) {
        this.f266505b = j3;
    }

    public void k(String str) {
        this.f266506c = str;
    }

    public void l(long j3) {
        this.f266504a = j3;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProSearchGuildFeedsReq{mTinyId=");
        sb5.append(this.f266504a);
        sb5.append("mGuildId=");
        sb5.append(this.f266505b);
        sb5.append("mQuery=");
        sb5.append(this.f266506c);
        sb5.append("mCookie.length=");
        byte[] bArr = this.f266507d;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mFeedType=");
        sb5.append(this.f266508e);
        sb5.append("mChannelIds=");
        sb5.append(this.f266509f);
        sb5.append("}");
        return sb5.toString();
    }
}
