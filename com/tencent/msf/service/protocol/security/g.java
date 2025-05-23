package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class g extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public int f336652a;

    /* renamed from: b, reason: collision with root package name */
    public int f336653b;

    public g() {
        this.f336652a = 0;
        this.f336653b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336652a = jceInputStream.read(this.f336652a, 0, true);
        this.f336653b = jceInputStream.read(this.f336653b, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336652a, 0);
        jceOutputStream.write(this.f336653b, 1);
    }

    public g(int i3, int i16) {
        this.f336652a = i3;
        this.f336653b = i16;
    }
}
