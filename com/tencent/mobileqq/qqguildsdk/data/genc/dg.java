package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class dg {

    /* renamed from: a, reason: collision with root package name */
    protected String f266383a = "";

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f266384b = new byte[0];

    public String a() {
        return this.f266383a;
    }

    public byte[] b() {
        return this.f266384b;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProKVPair{mKey=");
        sb5.append(this.f266383a);
        sb5.append("mValue.length=");
        byte[] bArr = this.f266384b;
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
