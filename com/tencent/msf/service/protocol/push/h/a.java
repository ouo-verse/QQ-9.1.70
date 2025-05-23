package com.tencent.msf.service.protocol.push.h;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public long f336572a;

    /* renamed from: b, reason: collision with root package name */
    public int f336573b;

    /* renamed from: c, reason: collision with root package name */
    public String f336574c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f336575d;

    public a() {
        this.f336572a = 0L;
        this.f336573b = 0;
        this.f336574c = "";
        this.f336575d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336572a = jceInputStream.read(this.f336572a, 0, false);
        this.f336573b = jceInputStream.read(this.f336573b, 1, false);
        this.f336574c = jceInputStream.readString(2, false);
        this.f336575d = jceInputStream.read(this.f336575d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336572a, 0);
        jceOutputStream.write(this.f336573b, 1);
        String str = this.f336574c;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        byte[] bArr = this.f336575d;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
    }

    public a(long j3, int i3, String str, byte[] bArr) {
        this.f336572a = j3;
        this.f336573b = i3;
        this.f336574c = str;
        this.f336575d = bArr;
    }
}
