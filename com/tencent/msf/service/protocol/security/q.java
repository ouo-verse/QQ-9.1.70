package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class q extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336714d;

    /* renamed from: a, reason: collision with root package name */
    public long f336715a;

    /* renamed from: b, reason: collision with root package name */
    public int f336716b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f336717c;

    public q() {
        this.f336715a = 0L;
        this.f336716b = 0;
        this.f336717c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336715a = jceInputStream.read(this.f336715a, 0, true);
        this.f336716b = jceInputStream.read(this.f336716b, 1, true);
        if (f336714d == null) {
            f336714d = r0;
            byte[] bArr = {0};
        }
        this.f336717c = jceInputStream.read(f336714d, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336715a, 0);
        jceOutputStream.write(this.f336716b, 1);
        jceOutputStream.write(this.f336717c, 2);
    }

    public q(long j3, int i3, byte[] bArr) {
        this.f336715a = j3;
        this.f336716b = i3;
        this.f336717c = bArr;
    }
}
