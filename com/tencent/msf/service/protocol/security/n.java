package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class n extends JceStruct {

    /* renamed from: h, reason: collision with root package name */
    static byte[] f336690h;

    /* renamed from: i, reason: collision with root package name */
    static byte[] f336691i;

    /* renamed from: j, reason: collision with root package name */
    static byte[] f336692j;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f336693a;

    /* renamed from: b, reason: collision with root package name */
    public String f336694b;

    /* renamed from: c, reason: collision with root package name */
    public String f336695c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336696d;

    /* renamed from: e, reason: collision with root package name */
    public byte f336697e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f336698f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f336699g;

    public n() {
        this.f336693a = null;
        this.f336694b = "";
        this.f336695c = "";
        this.f336696d = (byte) 0;
        this.f336697e = (byte) 0;
        this.f336698f = null;
        this.f336699g = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336690h == null) {
            f336690h = r0;
            byte[] bArr = {0};
        }
        this.f336693a = jceInputStream.read(f336690h, 0, true);
        this.f336694b = jceInputStream.readString(1, true);
        this.f336695c = jceInputStream.readString(2, false);
        this.f336696d = jceInputStream.read(this.f336696d, 3, false);
        this.f336697e = jceInputStream.read(this.f336697e, 4, false);
        if (f336691i == null) {
            f336691i = r0;
            byte[] bArr2 = {0};
        }
        this.f336698f = jceInputStream.read(f336691i, 5, false);
        if (f336692j == null) {
            f336692j = r0;
            byte[] bArr3 = {0};
        }
        this.f336699g = jceInputStream.read(f336692j, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336693a, 0);
        jceOutputStream.write(this.f336694b, 1);
        String str = this.f336695c;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.f336696d, 3);
        jceOutputStream.write(this.f336697e, 4);
        byte[] bArr = this.f336698f;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        byte[] bArr2 = this.f336699g;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 6);
        }
    }

    public n(byte[] bArr, String str, String str2, byte b16, byte b17, byte[] bArr2, byte[] bArr3) {
        this.f336693a = bArr;
        this.f336694b = str;
        this.f336695c = str2;
        this.f336696d = b16;
        this.f336697e = b17;
        this.f336698f = bArr2;
        this.f336699g = bArr3;
    }
}
