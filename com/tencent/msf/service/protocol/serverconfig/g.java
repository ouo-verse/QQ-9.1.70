package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class g extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336806d;

    /* renamed from: a, reason: collision with root package name */
    public int f336807a;

    /* renamed from: b, reason: collision with root package name */
    public long f336808b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f336809c;

    static {
        f336806d = r0;
        byte[] bArr = {0};
    }

    public g() {
        this.f336807a = 0;
        this.f336808b = 0L;
        this.f336809c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336807a = jceInputStream.read(this.f336807a, 1, true);
        this.f336808b = jceInputStream.read(this.f336808b, 2, true);
        this.f336809c = jceInputStream.read(f336806d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336807a, 1);
        jceOutputStream.write(this.f336808b, 2);
        byte[] bArr = this.f336809c;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public g(int i3, long j3, byte[] bArr) {
        this.f336807a = i3;
        this.f336808b = j3;
        this.f336809c = bArr;
    }
}
