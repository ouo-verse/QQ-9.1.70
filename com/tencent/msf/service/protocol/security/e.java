package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336644d;

    /* renamed from: a, reason: collision with root package name */
    public int f336645a;

    /* renamed from: b, reason: collision with root package name */
    public int f336646b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f336647c;

    public e() {
        this.f336645a = 0;
        this.f336646b = 0;
        this.f336647c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336645a = jceInputStream.read(this.f336645a, 0, true);
        this.f336646b = jceInputStream.read(this.f336646b, 1, true);
        if (f336644d == null) {
            f336644d = r0;
            byte[] bArr = {0};
        }
        this.f336647c = jceInputStream.read(f336644d, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336645a, 0);
        jceOutputStream.write(this.f336646b, 1);
        jceOutputStream.write(this.f336647c, 2);
    }

    public e(int i3, int i16, byte[] bArr) {
        this.f336645a = i3;
        this.f336646b = i16;
        this.f336647c = bArr;
    }
}
