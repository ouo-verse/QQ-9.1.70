package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class l extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public int f336866a;

    /* renamed from: b, reason: collision with root package name */
    public byte f336867b;

    /* renamed from: c, reason: collision with root package name */
    public byte f336868c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336869d;

    /* renamed from: e, reason: collision with root package name */
    public byte f336870e;

    public l() {
        this.f336866a = 0;
        this.f336867b = (byte) 0;
        this.f336868c = (byte) 0;
        this.f336869d = (byte) 0;
        this.f336870e = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336866a = jceInputStream.read(this.f336866a, 1, true);
        this.f336867b = jceInputStream.read(this.f336867b, 2, true);
        this.f336868c = jceInputStream.read(this.f336868c, 3, true);
        this.f336869d = jceInputStream.read(this.f336869d, 4, true);
        this.f336870e = jceInputStream.read(this.f336870e, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336866a, 1);
        jceOutputStream.write(this.f336867b, 2);
        jceOutputStream.write(this.f336868c, 3);
        jceOutputStream.write(this.f336869d, 4);
        jceOutputStream.write(this.f336870e, 5);
    }

    public l(int i3, byte b16, byte b17, byte b18, byte b19) {
        this.f336866a = i3;
        this.f336867b = b16;
        this.f336868c = b17;
        this.f336869d = b18;
        this.f336870e = b19;
    }
}
