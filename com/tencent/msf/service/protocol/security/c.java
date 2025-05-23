package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public int f336634a;

    public c() {
        this.f336634a = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336634a = jceInputStream.read(this.f336634a, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336634a, 0);
    }

    public c(int i3) {
        this.f336634a = i3;
    }
}
