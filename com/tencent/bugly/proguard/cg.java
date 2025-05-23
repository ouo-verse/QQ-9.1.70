package com.tencent.bugly.proguard;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class cg extends m implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f98393d;

    /* renamed from: a, reason: collision with root package name */
    public byte f98394a;

    /* renamed from: b, reason: collision with root package name */
    public String f98395b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f98396c;

    public cg() {
        this.f98394a = (byte) 0;
        this.f98395b = "";
        this.f98396c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98394a, 0);
        lVar.a(this.f98395b, 1);
        byte[] bArr = this.f98396c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    public cg(byte b16, String str, byte[] bArr) {
        this.f98394a = b16;
        this.f98395b = str;
        this.f98396c = bArr;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98394a = kVar.a(this.f98394a, 0, true);
        this.f98395b = kVar.b(1, true);
        if (f98393d == null) {
            f98393d = r0;
            byte[] bArr = {0};
        }
        this.f98396c = kVar.c(2, false);
    }
}
