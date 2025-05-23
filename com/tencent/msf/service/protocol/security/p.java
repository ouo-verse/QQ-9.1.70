package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class p extends JceStruct {

    /* renamed from: f, reason: collision with root package name */
    static byte[] f336706f;

    /* renamed from: g, reason: collision with root package name */
    static byte[] f336707g;

    /* renamed from: h, reason: collision with root package name */
    static byte[] f336708h;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f336709a;

    /* renamed from: b, reason: collision with root package name */
    public String f336710b;

    /* renamed from: c, reason: collision with root package name */
    public String f336711c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f336712d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f336713e;

    public p() {
        this.f336709a = null;
        this.f336710b = "";
        this.f336711c = "";
        this.f336712d = null;
        this.f336713e = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336706f == null) {
            f336706f = r0;
            byte[] bArr = {0};
        }
        this.f336709a = jceInputStream.read(f336706f, 0, true);
        this.f336710b = jceInputStream.readString(1, true);
        this.f336711c = jceInputStream.readString(2, true);
        if (f336707g == null) {
            f336707g = r0;
            byte[] bArr2 = {0};
        }
        this.f336712d = jceInputStream.read(f336707g, 3, true);
        if (f336708h == null) {
            f336708h = r0;
            byte[] bArr3 = {0};
        }
        this.f336713e = jceInputStream.read(f336708h, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336709a, 0);
        jceOutputStream.write(this.f336710b, 1);
        jceOutputStream.write(this.f336711c, 2);
        jceOutputStream.write(this.f336712d, 3);
        byte[] bArr = this.f336713e;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
    }

    public p(byte[] bArr, String str, String str2, byte[] bArr2, byte[] bArr3) {
        this.f336709a = bArr;
        this.f336710b = str;
        this.f336711c = str2;
        this.f336712d = bArr2;
        this.f336713e = bArr3;
    }
}
