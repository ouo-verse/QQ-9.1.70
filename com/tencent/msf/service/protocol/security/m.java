package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class m extends JceStruct {

    /* renamed from: i, reason: collision with root package name */
    static byte[] f336679i;

    /* renamed from: j, reason: collision with root package name */
    static byte[] f336680j;

    /* renamed from: k, reason: collision with root package name */
    static byte[] f336681k;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f336682a;

    /* renamed from: b, reason: collision with root package name */
    public String f336683b;

    /* renamed from: c, reason: collision with root package name */
    public String f336684c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336685d;

    /* renamed from: e, reason: collision with root package name */
    public String f336686e;

    /* renamed from: f, reason: collision with root package name */
    public byte f336687f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f336688g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f336689h;

    public m() {
        this.f336682a = null;
        this.f336683b = "";
        this.f336684c = "";
        this.f336685d = (byte) 0;
        this.f336686e = "";
        this.f336687f = (byte) 0;
        this.f336688g = null;
        this.f336689h = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f336679i == null) {
            f336679i = r0;
            byte[] bArr = {0};
        }
        this.f336682a = jceInputStream.read(f336679i, 0, true);
        this.f336683b = jceInputStream.readString(1, true);
        this.f336684c = jceInputStream.readString(2, true);
        this.f336685d = jceInputStream.read(this.f336685d, 3, false);
        this.f336686e = jceInputStream.readString(4, false);
        this.f336687f = jceInputStream.read(this.f336687f, 5, false);
        if (f336680j == null) {
            f336680j = r0;
            byte[] bArr2 = {0};
        }
        this.f336688g = jceInputStream.read(f336680j, 6, false);
        if (f336681k == null) {
            f336681k = r0;
            byte[] bArr3 = {0};
        }
        this.f336689h = jceInputStream.read(f336681k, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336682a, 0);
        jceOutputStream.write(this.f336683b, 1);
        jceOutputStream.write(this.f336684c, 2);
        jceOutputStream.write(this.f336685d, 3);
        String str = this.f336686e;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.f336687f, 5);
        byte[] bArr = this.f336688g;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        byte[] bArr2 = this.f336689h;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 7);
        }
    }

    public m(byte[] bArr, String str, String str2, byte b16, String str3, byte b17, byte[] bArr2, byte[] bArr3) {
        this.f336682a = bArr;
        this.f336683b = str;
        this.f336684c = str2;
        this.f336685d = b16;
        this.f336686e = str3;
        this.f336687f = b17;
        this.f336688g = bArr2;
        this.f336689h = bArr3;
    }
}
