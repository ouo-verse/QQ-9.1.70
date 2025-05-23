package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class i extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336656d;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f336657a;

    /* renamed from: b, reason: collision with root package name */
    public String f336658b;

    /* renamed from: c, reason: collision with root package name */
    public String f336659c;

    public i() {
        this.f336657a = null;
        this.f336658b = "";
        this.f336659c = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336656d == null) {
            f336656d = r0;
            byte[] bArr = {0};
        }
        this.f336657a = jceInputStream.read(f336656d, 1, true);
        this.f336658b = jceInputStream.readString(2, true);
        this.f336659c = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336657a, 1);
        jceOutputStream.write(this.f336658b, 2);
        jceOutputStream.write(this.f336659c, 3);
    }

    public i(byte[] bArr, String str, String str2) {
        this.f336657a = bArr;
        this.f336658b = str;
        this.f336659c = str2;
    }
}
