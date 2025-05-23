package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class k extends JceStruct {

    /* renamed from: k, reason: collision with root package name */
    static byte[] f336662k;

    /* renamed from: l, reason: collision with root package name */
    static byte[] f336663l;

    /* renamed from: a, reason: collision with root package name */
    public int f336664a;

    /* renamed from: b, reason: collision with root package name */
    public int f336665b;

    /* renamed from: c, reason: collision with root package name */
    public int f336666c;

    /* renamed from: d, reason: collision with root package name */
    public String f336667d;

    /* renamed from: e, reason: collision with root package name */
    public int f336668e;

    /* renamed from: f, reason: collision with root package name */
    public int f336669f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f336670g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f336671h;

    /* renamed from: i, reason: collision with root package name */
    public int f336672i;

    /* renamed from: j, reason: collision with root package name */
    public int f336673j;

    public k() {
        this.f336664a = 0;
        this.f336665b = 0;
        this.f336666c = 0;
        this.f336667d = "";
        this.f336668e = 0;
        this.f336669f = 0;
        this.f336670g = null;
        this.f336671h = null;
        this.f336672i = 0;
        this.f336673j = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336664a = jceInputStream.read(this.f336664a, 0, true);
        this.f336665b = jceInputStream.read(this.f336665b, 1, true);
        this.f336666c = jceInputStream.read(this.f336666c, 2, true);
        this.f336667d = jceInputStream.readString(3, true);
        this.f336668e = jceInputStream.read(this.f336668e, 4, true);
        this.f336669f = jceInputStream.read(this.f336669f, 5, true);
        if (f336662k == null) {
            f336662k = r0;
            byte[] bArr = {0};
        }
        this.f336670g = jceInputStream.read(f336662k, 6, true);
        if (f336663l == null) {
            f336663l = r0;
            byte[] bArr2 = {0};
        }
        this.f336671h = jceInputStream.read(f336663l, 7, true);
        this.f336672i = jceInputStream.read(this.f336672i, 8, true);
        this.f336673j = jceInputStream.read(this.f336673j, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336664a, 0);
        jceOutputStream.write(this.f336665b, 1);
        jceOutputStream.write(this.f336666c, 2);
        jceOutputStream.write(this.f336667d, 3);
        jceOutputStream.write(this.f336668e, 4);
        jceOutputStream.write(this.f336669f, 5);
        jceOutputStream.write(this.f336670g, 6);
        jceOutputStream.write(this.f336671h, 7);
        jceOutputStream.write(this.f336672i, 8);
        jceOutputStream.write(this.f336673j, 9);
    }

    public k(int i3, int i16, int i17, String str, int i18, int i19, byte[] bArr, byte[] bArr2, int i26, int i27) {
        this.f336664a = i3;
        this.f336665b = i16;
        this.f336666c = i17;
        this.f336667d = str;
        this.f336668e = i18;
        this.f336669f = i19;
        this.f336670g = bArr;
        this.f336671h = bArr2;
        this.f336672i = i26;
        this.f336673j = i27;
    }
}
