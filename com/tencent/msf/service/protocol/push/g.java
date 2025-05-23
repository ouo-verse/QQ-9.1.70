package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class g extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public long f336569a;

    /* renamed from: b, reason: collision with root package name */
    public byte f336570b;

    /* renamed from: c, reason: collision with root package name */
    public String f336571c;

    public g() {
        this.f336569a = 0L;
        this.f336570b = (byte) 0;
        this.f336571c = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336569a = jceInputStream.read(this.f336569a, 0, true);
        this.f336570b = jceInputStream.read(this.f336570b, 1, true);
        this.f336571c = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336569a, 0);
        jceOutputStream.write(this.f336570b, 1);
        jceOutputStream.write(this.f336571c, 2);
    }

    public g(long j3, byte b16, String str) {
        this.f336569a = j3;
        this.f336570b = b16;
        this.f336571c = str;
    }
}
