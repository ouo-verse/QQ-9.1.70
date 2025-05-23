package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public long f336531a;

    /* renamed from: b, reason: collision with root package name */
    public long f336532b;

    /* renamed from: c, reason: collision with root package name */
    public byte f336533c;

    public c() {
        this.f336531a = 0L;
        this.f336532b = 0L;
        this.f336533c = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336531a = jceInputStream.read(this.f336531a, 0, true);
        this.f336532b = jceInputStream.read(this.f336532b, 1, true);
        this.f336533c = jceInputStream.read(this.f336533c, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336531a, 0);
        jceOutputStream.write(this.f336532b, 1);
        jceOutputStream.write(this.f336533c, 2);
    }

    public c(long j3, long j16, byte b16) {
        this.f336531a = j3;
        this.f336532b = j16;
        this.f336533c = b16;
    }
}
