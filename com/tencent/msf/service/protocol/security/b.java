package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b extends JceStruct {

    /* renamed from: g, reason: collision with root package name */
    static byte[] f336625g;

    /* renamed from: h, reason: collision with root package name */
    static byte[] f336626h;

    /* renamed from: i, reason: collision with root package name */
    static byte[] f336627i;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f336628a;

    /* renamed from: b, reason: collision with root package name */
    public int f336629b;

    /* renamed from: c, reason: collision with root package name */
    public int f336630c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f336631d;

    /* renamed from: e, reason: collision with root package name */
    public int f336632e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f336633f;

    public b() {
        this.f336628a = null;
        this.f336629b = 0;
        this.f336630c = 0;
        this.f336631d = null;
        this.f336632e = 0;
        this.f336633f = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336625g == null) {
            f336625g = r0;
            byte[] bArr = {0};
        }
        this.f336628a = jceInputStream.read(f336625g, 0, true);
        this.f336629b = jceInputStream.read(this.f336629b, 1, true);
        this.f336630c = jceInputStream.read(this.f336630c, 2, true);
        if (f336626h == null) {
            f336626h = r0;
            byte[] bArr2 = {0};
        }
        this.f336631d = jceInputStream.read(f336626h, 3, true);
        this.f336632e = jceInputStream.read(this.f336632e, 4, true);
        if (f336627i == null) {
            f336627i = r0;
            byte[] bArr3 = {0};
        }
        this.f336633f = jceInputStream.read(f336627i, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336628a, 0);
        jceOutputStream.write(this.f336629b, 1);
        jceOutputStream.write(this.f336630c, 2);
        jceOutputStream.write(this.f336631d, 3);
        jceOutputStream.write(this.f336632e, 4);
        byte[] bArr = this.f336633f;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
    }

    public b(byte[] bArr, int i3, int i16, byte[] bArr2, int i17, byte[] bArr3) {
        this.f336628a = bArr;
        this.f336629b = i3;
        this.f336630c = i16;
        this.f336631d = bArr2;
        this.f336632e = i17;
        this.f336633f = bArr3;
    }
}
