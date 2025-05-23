package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class f extends JceStruct {

    /* renamed from: c, reason: collision with root package name */
    static byte[] f336648c;

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336649d;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f336650a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f336651b;

    public f() {
        this.f336650a = null;
        this.f336651b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336648c == null) {
            f336648c = r0;
            byte[] bArr = {0};
        }
        this.f336650a = jceInputStream.read(f336648c, 0, true);
        if (f336649d == null) {
            f336649d = r0;
            byte[] bArr2 = {0};
        }
        this.f336651b = jceInputStream.read(f336649d, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336650a, 0);
        jceOutputStream.write(this.f336651b, 1);
    }

    public f(byte[] bArr, byte[] bArr2) {
        this.f336650a = bArr;
        this.f336651b = bArr2;
    }
}
