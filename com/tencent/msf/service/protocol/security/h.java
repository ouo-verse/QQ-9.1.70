package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class h extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336654a;

    /* renamed from: b, reason: collision with root package name */
    public String f336655b;

    public h() {
        this.f336654a = "";
        this.f336655b = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336654a = jceInputStream.readString(0, true);
        this.f336655b = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336654a, 0);
        jceOutputStream.write(this.f336655b, 1);
    }

    public h(String str, String str2) {
        this.f336654a = str;
        this.f336655b = str2;
    }
}
