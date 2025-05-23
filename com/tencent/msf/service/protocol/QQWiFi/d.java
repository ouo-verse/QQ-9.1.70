package com.tencent.msf.service.protocol.QQWiFi;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336464a;

    /* renamed from: b, reason: collision with root package name */
    public String f336465b;

    /* renamed from: c, reason: collision with root package name */
    public short f336466c;

    public d() {
        this.f336464a = "";
        this.f336465b = "";
        this.f336466c = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336464a = jceInputStream.readString(0, true);
        this.f336465b = jceInputStream.readString(1, false);
        this.f336466c = jceInputStream.read(this.f336466c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336464a, 0);
        String str = this.f336465b;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.f336466c, 2);
    }

    public d(String str, String str2, short s16) {
        this.f336464a = str;
        this.f336465b = str2;
        this.f336466c = s16;
    }
}
