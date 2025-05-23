package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    protected int f266170a;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f266172c;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f266175f;

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f266171b = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<ey> f266173d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    protected v f266174e = new v();

    public byte[] a() {
        return this.f266171b;
    }

    public int b() {
        return this.f266170a;
    }

    public v c() {
        return this.f266174e;
    }

    public boolean d() {
        return this.f266175f;
    }

    public boolean e() {
        return this.f266172c;
    }

    public ArrayList<ey> f() {
        return this.f266173d;
    }

    public void g(byte[] bArr) {
        this.f266171b = bArr;
    }

    public void h(int i3) {
        this.f266170a = i3;
    }

    public void i(v vVar) {
        this.f266174e = vVar;
    }

    public void j(boolean z16) {
        this.f266175f = z16;
    }

    public void k(boolean z16) {
        this.f266172c = z16;
    }

    public void l(ArrayList<ey> arrayList) {
        this.f266173d = arrayList;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProFetchShareInfo0x10c3Req{mBusinessType=");
        sb5.append(this.f266170a);
        sb5.append("mBusinessParam.length=");
        byte[] bArr = this.f266171b;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mIsShortLink=");
        sb5.append(this.f266172c);
        sb5.append("mUrlParams=");
        sb5.append(this.f266173d);
        sb5.append("mFilter=");
        sb5.append(this.f266174e);
        sb5.append("mIsEncry=");
        sb5.append(this.f266175f);
        sb5.append("}");
        return sb5.toString();
    }
}
