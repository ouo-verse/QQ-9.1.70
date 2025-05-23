package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class f extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336802d;

    /* renamed from: a, reason: collision with root package name */
    public int f336803a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f336804b;

    /* renamed from: c, reason: collision with root package name */
    public long f336805c;

    static {
        f336802d = r0;
        byte[] bArr = {0};
    }

    public f() {
        this.f336803a = 0;
        this.f336804b = null;
        this.f336805c = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336803a = jceInputStream.read(this.f336803a, 1, true);
        this.f336804b = jceInputStream.read(f336802d, 2, true);
        this.f336805c = jceInputStream.read(this.f336805c, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336803a, 1);
        jceOutputStream.write(this.f336804b, 2);
        jceOutputStream.write(this.f336805c, 3);
    }

    public f(int i3, byte[] bArr, long j3) {
        this.f336803a = i3;
        this.f336804b = bArr;
        this.f336805c = j3;
    }
}
