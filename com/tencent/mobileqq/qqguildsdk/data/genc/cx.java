package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cx {

    /* renamed from: a, reason: collision with root package name */
    protected String f266357a = "";

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f266358b = new byte[0];

    public byte[] a() {
        return this.f266358b;
    }

    public String b() {
        return this.f266357a;
    }

    public void c(byte[] bArr) {
        this.f266358b = bArr;
    }

    public void d(String str) {
        this.f266357a = str;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProItemCbData{mStatData=");
        sb5.append(this.f266357a);
        sb5.append("mCbExtData.length=");
        byte[] bArr = this.f266358b;
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
