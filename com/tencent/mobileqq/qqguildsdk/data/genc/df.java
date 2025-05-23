package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class df {

    /* renamed from: a, reason: collision with root package name */
    protected String f266381a = "";

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f266382b = new byte[0];

    public String a() {
        return this.f266381a;
    }

    public byte[] b() {
        return this.f266382b;
    }

    public void c(String str) {
        this.f266381a = str;
    }

    public void d(byte[] bArr) {
        this.f266382b = bArr;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProKVNode{mKey=");
        sb5.append(this.f266381a);
        sb5.append("mValue.length=");
        byte[] bArr = this.f266382b;
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
