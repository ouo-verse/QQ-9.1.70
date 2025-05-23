package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class o extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static byte[] f336700e;

    /* renamed from: f, reason: collision with root package name */
    static byte[] f336701f;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f336702a;

    /* renamed from: b, reason: collision with root package name */
    public String f336703b;

    /* renamed from: c, reason: collision with root package name */
    public String f336704c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f336705d;

    public o() {
        this.f336702a = null;
        this.f336703b = "";
        this.f336704c = "";
        this.f336705d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336700e == null) {
            f336700e = r0;
            byte[] bArr = {0};
        }
        this.f336702a = jceInputStream.read(f336700e, 0, true);
        this.f336703b = jceInputStream.readString(1, true);
        this.f336704c = jceInputStream.readString(2, true);
        if (f336701f == null) {
            f336701f = r0;
            byte[] bArr2 = {0};
        }
        this.f336705d = jceInputStream.read(f336701f, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336702a, 0);
        jceOutputStream.write(this.f336703b, 1);
        jceOutputStream.write(this.f336704c, 2);
        jceOutputStream.write(this.f336705d, 3);
    }

    public o(byte[] bArr, String str, String str2, byte[] bArr2) {
        this.f336702a = bArr;
        this.f336703b = str;
        this.f336704c = str2;
        this.f336705d = bArr2;
    }
}
