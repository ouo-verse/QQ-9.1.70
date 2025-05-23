package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class k extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336856a;

    /* renamed from: b, reason: collision with root package name */
    public int f336857b;

    /* renamed from: c, reason: collision with root package name */
    public byte f336858c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336859d;

    /* renamed from: e, reason: collision with root package name */
    public byte f336860e;

    /* renamed from: f, reason: collision with root package name */
    public int f336861f;

    /* renamed from: g, reason: collision with root package name */
    public byte f336862g;

    /* renamed from: h, reason: collision with root package name */
    public String f336863h;

    /* renamed from: i, reason: collision with root package name */
    public String f336864i;

    /* renamed from: j, reason: collision with root package name */
    public long f336865j;

    public k() {
        this.f336856a = "";
        this.f336857b = 0;
        this.f336858c = (byte) 0;
        this.f336859d = (byte) 0;
        this.f336860e = (byte) 0;
        this.f336861f = 8;
        this.f336862g = (byte) 0;
        this.f336863h = "";
        this.f336864i = "";
        this.f336865j = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336856a = jceInputStream.readString(1, true);
        this.f336857b = jceInputStream.read(this.f336857b, 2, true);
        this.f336858c = jceInputStream.read(this.f336858c, 3, true);
        this.f336859d = jceInputStream.read(this.f336859d, 4, true);
        this.f336860e = jceInputStream.read(this.f336860e, 5, false);
        this.f336861f = jceInputStream.read(this.f336861f, 6, false);
        this.f336862g = jceInputStream.read(this.f336862g, 7, false);
        this.f336863h = jceInputStream.readString(8, false);
        this.f336864i = jceInputStream.readString(9, false);
        this.f336865j = jceInputStream.read(this.f336865j, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336856a, 1);
        jceOutputStream.write(this.f336857b, 2);
        jceOutputStream.write(this.f336858c, 3);
        jceOutputStream.write(this.f336859d, 4);
        jceOutputStream.write(this.f336860e, 5);
        jceOutputStream.write(this.f336861f, 6);
        jceOutputStream.write(this.f336862g, 7);
        String str = this.f336863h;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        String str2 = this.f336864i;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        jceOutputStream.write(this.f336865j, 10);
    }

    public k(String str, int i3, byte b16, byte b17, byte b18, int i16, byte b19, String str2, String str3, long j3) {
        this.f336856a = str;
        this.f336857b = i3;
        this.f336858c = b16;
        this.f336859d = b17;
        this.f336860e = b18;
        this.f336861f = i16;
        this.f336862g = b19;
        this.f336863h = str2;
        this.f336864i = str3;
        this.f336865j = j3;
    }
}
