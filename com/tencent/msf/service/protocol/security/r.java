package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class r extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static byte[] f336718e;

    /* renamed from: a, reason: collision with root package name */
    public int f336719a;

    /* renamed from: b, reason: collision with root package name */
    public int f336720b;

    /* renamed from: c, reason: collision with root package name */
    public int f336721c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f336722d;

    public r() {
        this.f336719a = 0;
        this.f336720b = 0;
        this.f336721c = 0;
        this.f336722d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336719a = jceInputStream.read(this.f336719a, 0, true);
        this.f336720b = jceInputStream.read(this.f336720b, 1, true);
        this.f336721c = jceInputStream.read(this.f336721c, 2, true);
        if (f336718e == null) {
            f336718e = r0;
            byte[] bArr = {0};
        }
        this.f336722d = jceInputStream.read(f336718e, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336719a, 0);
        jceOutputStream.write(this.f336720b, 1);
        jceOutputStream.write(this.f336721c, 2);
        jceOutputStream.write(this.f336722d, 3);
    }

    public r(int i3, int i16, int i17, byte[] bArr) {
        this.f336719a = i3;
        this.f336720b = i16;
        this.f336721c = i17;
        this.f336722d = bArr;
    }
}
