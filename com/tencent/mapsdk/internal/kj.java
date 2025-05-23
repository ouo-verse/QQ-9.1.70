package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kj extends ka {

    /* renamed from: a, reason: collision with root package name */
    public String f148981a;

    public kj() {
    }

    @Override // com.tencent.mapsdk.internal.ka
    public final int a() {
        return b().length;
    }

    @Override // com.tencent.mapsdk.internal.ka
    public final byte[] b() {
        String str = this.f148981a;
        if (str != null) {
            return str.getBytes();
        }
        return new byte[0];
    }

    public final String toString() {
        return "StringData{strData='" + this.f148981a + "'}";
    }

    kj(String str) {
        this.f148981a = str;
    }

    @Override // com.tencent.mapsdk.internal.ka
    public final void a(byte[] bArr) {
        this.f148981a = new String(bArr);
    }
}
