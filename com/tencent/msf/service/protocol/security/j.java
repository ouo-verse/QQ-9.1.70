package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class j extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public int f336660a;

    /* renamed from: b, reason: collision with root package name */
    public int f336661b;

    public j() {
        this.f336660a = 0;
        this.f336661b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336660a = jceInputStream.read(this.f336660a, 0, true);
        this.f336661b = jceInputStream.read(this.f336661b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336660a, 0);
        jceOutputStream.write(this.f336661b, 1);
    }

    public j(int i3, int i16) {
        this.f336660a = i3;
        this.f336661b = i16;
    }
}
