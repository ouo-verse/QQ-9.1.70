package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class h extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public int f336510a;

    /* renamed from: b, reason: collision with root package name */
    public byte f336511b;

    /* renamed from: c, reason: collision with root package name */
    public int f336512c;

    /* renamed from: d, reason: collision with root package name */
    public int f336513d;

    /* renamed from: e, reason: collision with root package name */
    public String f336514e;

    /* renamed from: f, reason: collision with root package name */
    public String f336515f;

    /* renamed from: g, reason: collision with root package name */
    public String f336516g;

    /* renamed from: h, reason: collision with root package name */
    public int f336517h;

    /* renamed from: i, reason: collision with root package name */
    public byte f336518i;

    /* renamed from: j, reason: collision with root package name */
    public int f336519j;

    /* renamed from: k, reason: collision with root package name */
    public String f336520k;

    public h() {
        this.f336510a = 0;
        this.f336511b = (byte) 0;
        this.f336512c = 0;
        this.f336513d = 0;
        this.f336514e = "";
        this.f336515f = "";
        this.f336516g = "";
        this.f336517h = 0;
        this.f336518i = (byte) 1;
        this.f336519j = 0;
        this.f336520k = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336510a = jceInputStream.read(this.f336510a, 1, true);
        this.f336511b = jceInputStream.read(this.f336511b, 2, true);
        this.f336512c = jceInputStream.read(this.f336512c, 3, true);
        this.f336513d = jceInputStream.read(this.f336513d, 4, true);
        this.f336514e = jceInputStream.readString(5, false);
        this.f336515f = jceInputStream.readString(6, false);
        this.f336516g = jceInputStream.readString(7, false);
        this.f336517h = jceInputStream.read(this.f336517h, 8, false);
        this.f336518i = jceInputStream.read(this.f336518i, 9, false);
        this.f336519j = jceInputStream.read(this.f336519j, 10, false);
        this.f336520k = jceInputStream.readString(11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336510a, 1);
        jceOutputStream.write(this.f336511b, 2);
        jceOutputStream.write(this.f336512c, 3);
        jceOutputStream.write(this.f336513d, 4);
        String str = this.f336514e;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        String str2 = this.f336515f;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.f336516g;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.f336517h, 8);
        jceOutputStream.write(this.f336518i, 9);
        jceOutputStream.write(this.f336519j, 10);
        String str4 = this.f336520k;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
    }

    public h(int i3, byte b16, int i16, int i17, String str, String str2, String str3, int i18, byte b17, int i19, String str4) {
        this.f336510a = i3;
        this.f336511b = b16;
        this.f336512c = i16;
        this.f336513d = i17;
        this.f336514e = str;
        this.f336515f = str2;
        this.f336516g = str3;
        this.f336517h = i18;
        this.f336518i = b17;
        this.f336519j = i19;
        this.f336520k = str4;
    }
}
