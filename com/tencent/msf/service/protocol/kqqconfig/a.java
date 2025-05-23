package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a extends JceStruct {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f336470d;

    /* renamed from: a, reason: collision with root package name */
    public byte f336471a;

    /* renamed from: b, reason: collision with root package name */
    public String f336472b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f336473c;

    public a() {
        this.f336471a = (byte) 0;
        this.f336472b = "";
        this.f336473c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336471a = jceInputStream.read(this.f336471a, 1, true);
        this.f336472b = jceInputStream.readString(3, true);
        if (f336470d == null) {
            f336470d = r0;
            byte[] bArr = {0};
        }
        this.f336473c = jceInputStream.read(f336470d, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336471a, 1);
        jceOutputStream.write(this.f336472b, 3);
        byte[] bArr = this.f336473c;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
    }

    public a(byte b16, String str, byte[] bArr) {
        this.f336471a = b16;
        this.f336472b = str;
        this.f336473c = bArr;
    }
}
