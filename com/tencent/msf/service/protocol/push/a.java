package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336523d;

    /* renamed from: a, reason: collision with root package name */
    public long f336524a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f336525b;

    /* renamed from: c, reason: collision with root package name */
    public int f336526c;

    static {
        f336523d = r0;
        byte[] bArr = {0};
    }

    public a() {
        this.f336524a = 0L;
        this.f336525b = null;
        this.f336526c = 11;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336524a = jceInputStream.read(this.f336524a, 0, true);
        this.f336525b = jceInputStream.read(f336523d, 1, true);
        this.f336526c = jceInputStream.read(this.f336526c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336524a, 0);
        jceOutputStream.write(this.f336525b, 1);
        jceOutputStream.write(this.f336526c, 2);
    }

    public a(long j3, byte[] bArr, int i3) {
        this.f336524a = j3;
        this.f336525b = bArr;
        this.f336526c = i3;
    }
}
