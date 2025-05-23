package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class l extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336674d;

    /* renamed from: e, reason: collision with root package name */
    static byte[] f336675e;

    /* renamed from: a, reason: collision with root package name */
    public int f336676a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f336677b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f336678c;

    public l() {
        this.f336676a = 0;
        this.f336677b = null;
        this.f336678c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336676a = jceInputStream.read(this.f336676a, 0, true);
        if (f336674d == null) {
            f336674d = r0;
            byte[] bArr = {0};
        }
        this.f336677b = jceInputStream.read(f336674d, 1, true);
        if (f336675e == null) {
            f336675e = r0;
            byte[] bArr2 = {0};
        }
        this.f336678c = jceInputStream.read(f336675e, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336676a, 0);
        jceOutputStream.write(this.f336677b, 1);
        jceOutputStream.write(this.f336678c, 2);
    }

    public l(int i3, byte[] bArr, byte[] bArr2) {
        this.f336676a = i3;
        this.f336677b = bArr;
        this.f336678c = bArr2;
    }
}
