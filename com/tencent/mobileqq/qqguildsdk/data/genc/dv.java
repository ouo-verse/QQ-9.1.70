package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class dv {

    /* renamed from: a, reason: collision with root package name */
    protected byte[] f266449a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    protected String f266450b = "";

    public String a() {
        return this.f266450b;
    }

    public byte[] b() {
        return this.f266449a;
    }

    public void c(String str) {
        this.f266450b = str;
    }

    public void d(byte[] bArr) {
        this.f266449a = bArr;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProReportShareAttaReq{mAttaData.length=");
        byte[] bArr = this.f266449a;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mAttaContentId=");
        sb5.append(this.f266450b);
        sb5.append("}");
        return sb5.toString();
    }
}
