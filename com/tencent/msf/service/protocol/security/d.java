package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public int f336635a;

    /* renamed from: b, reason: collision with root package name */
    public int f336636b;

    /* renamed from: c, reason: collision with root package name */
    public int f336637c;

    /* renamed from: d, reason: collision with root package name */
    public int f336638d;

    /* renamed from: e, reason: collision with root package name */
    public String f336639e;

    /* renamed from: f, reason: collision with root package name */
    public int f336640f;

    /* renamed from: g, reason: collision with root package name */
    public String f336641g;

    /* renamed from: h, reason: collision with root package name */
    public String f336642h;

    /* renamed from: i, reason: collision with root package name */
    public int f336643i;

    public d() {
        this.f336635a = 0;
        this.f336636b = 0;
        this.f336637c = 0;
        this.f336638d = 0;
        this.f336639e = "";
        this.f336640f = 0;
        this.f336641g = "";
        this.f336642h = "";
        this.f336643i = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336635a = jceInputStream.read(this.f336635a, 0, true);
        this.f336636b = jceInputStream.read(this.f336636b, 1, true);
        this.f336637c = jceInputStream.read(this.f336637c, 2, true);
        this.f336638d = jceInputStream.read(this.f336638d, 3, true);
        this.f336639e = jceInputStream.readString(4, true);
        this.f336640f = jceInputStream.read(this.f336640f, 5, true);
        this.f336641g = jceInputStream.readString(6, true);
        this.f336642h = jceInputStream.readString(7, true);
        this.f336643i = jceInputStream.read(this.f336643i, 8, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336635a, 0);
        jceOutputStream.write(this.f336636b, 1);
        jceOutputStream.write(this.f336637c, 2);
        jceOutputStream.write(this.f336638d, 3);
        jceOutputStream.write(this.f336639e, 4);
        jceOutputStream.write(this.f336640f, 5);
        jceOutputStream.write(this.f336641g, 6);
        jceOutputStream.write(this.f336642h, 7);
        jceOutputStream.write(this.f336643i, 8);
    }

    public d(int i3, int i16, int i17, int i18, String str, int i19, String str2, String str3, int i26) {
        this.f336635a = i3;
        this.f336636b = i16;
        this.f336637c = i17;
        this.f336638d = i18;
        this.f336639e = str;
        this.f336640f = i19;
        this.f336641g = str2;
        this.f336642h = str3;
        this.f336643i = i26;
    }
}
