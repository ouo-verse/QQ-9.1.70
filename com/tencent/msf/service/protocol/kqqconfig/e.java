package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336493a;

    /* renamed from: b, reason: collision with root package name */
    public int f336494b;

    /* renamed from: c, reason: collision with root package name */
    public byte f336495c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336496d;

    /* renamed from: e, reason: collision with root package name */
    public byte f336497e;

    /* renamed from: f, reason: collision with root package name */
    public int f336498f;

    /* renamed from: g, reason: collision with root package name */
    public String f336499g;

    /* renamed from: h, reason: collision with root package name */
    public String f336500h;

    public e() {
        this.f336493a = "";
        this.f336494b = 0;
        this.f336495c = (byte) 0;
        this.f336496d = (byte) 0;
        this.f336497e = (byte) 0;
        this.f336498f = 10;
        this.f336499g = "";
        this.f336500h = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336493a = jceInputStream.readString(1, true);
        this.f336494b = jceInputStream.read(this.f336494b, 2, true);
        this.f336495c = jceInputStream.read(this.f336495c, 3, true);
        this.f336496d = jceInputStream.read(this.f336496d, 4, true);
        this.f336497e = jceInputStream.read(this.f336497e, 5, false);
        this.f336498f = jceInputStream.read(this.f336498f, 6, false);
        this.f336499g = jceInputStream.readString(7, true);
        this.f336500h = jceInputStream.readString(8, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336493a, 1);
        jceOutputStream.write(this.f336494b, 2);
        jceOutputStream.write(this.f336495c, 3);
        jceOutputStream.write(this.f336496d, 4);
        jceOutputStream.write(this.f336497e, 5);
        jceOutputStream.write(this.f336498f, 6);
        jceOutputStream.write(this.f336499g, 7);
        jceOutputStream.write(this.f336500h, 8);
    }

    public e(String str, int i3, byte b16, byte b17, byte b18, int i16, String str2, String str3) {
        this.f336493a = str;
        this.f336494b = i3;
        this.f336495c = b16;
        this.f336496d = b17;
        this.f336497e = b18;
        this.f336498f = i16;
        this.f336499g = str2;
        this.f336500h = str3;
    }
}
