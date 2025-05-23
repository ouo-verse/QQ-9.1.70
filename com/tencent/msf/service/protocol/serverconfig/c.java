package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c extends JceStruct {

    /* renamed from: e, reason: collision with root package name */
    static byte[] f336757e;

    /* renamed from: a, reason: collision with root package name */
    public long f336758a;

    /* renamed from: b, reason: collision with root package name */
    public long f336759b;

    /* renamed from: c, reason: collision with root package name */
    public String f336760c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f336761d;

    static {
        f336757e = r0;
        byte[] bArr = {0};
    }

    public c() {
        this.f336758a = 0L;
        this.f336759b = 0L;
        this.f336760c = "";
        this.f336761d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336758a = jceInputStream.read(this.f336758a, 1, true);
        this.f336759b = jceInputStream.read(this.f336759b, 2, true);
        this.f336760c = jceInputStream.readString(3, true);
        this.f336761d = jceInputStream.read(f336757e, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336758a, 1);
        jceOutputStream.write(this.f336759b, 2);
        jceOutputStream.write(this.f336760c, 3);
        jceOutputStream.write(this.f336761d, 4);
    }

    public c(long j3, long j16, String str, byte[] bArr) {
        this.f336758a = j3;
        this.f336759b = j16;
        this.f336760c = str;
        this.f336761d = bArr;
    }
}
