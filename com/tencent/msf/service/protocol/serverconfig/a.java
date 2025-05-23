package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a extends JceStruct {

    /* renamed from: g, reason: collision with root package name */
    static l f336741g = new l();

    /* renamed from: h, reason: collision with root package name */
    static l f336742h = new l();

    /* renamed from: a, reason: collision with root package name */
    public int f336743a;

    /* renamed from: b, reason: collision with root package name */
    public l f336744b;

    /* renamed from: c, reason: collision with root package name */
    public l f336745c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336746d;

    /* renamed from: e, reason: collision with root package name */
    public int f336747e;

    /* renamed from: f, reason: collision with root package name */
    public long f336748f;

    public a() {
        this.f336743a = 0;
        this.f336744b = null;
        this.f336745c = null;
        this.f336746d = (byte) 0;
        this.f336747e = 0;
        this.f336748f = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336743a = jceInputStream.read(this.f336743a, 1, true);
        this.f336744b = (l) jceInputStream.read((JceStruct) f336741g, 2, false);
        this.f336745c = (l) jceInputStream.read((JceStruct) f336742h, 3, false);
        this.f336746d = jceInputStream.read(this.f336746d, 4, false);
        this.f336747e = jceInputStream.read(this.f336747e, 5, false);
        this.f336748f = jceInputStream.read(this.f336748f, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336743a, 1);
        l lVar = this.f336744b;
        if (lVar != null) {
            jceOutputStream.write((JceStruct) lVar, 2);
        }
        l lVar2 = this.f336745c;
        if (lVar2 != null) {
            jceOutputStream.write((JceStruct) lVar2, 3);
        }
        jceOutputStream.write(this.f336746d, 4);
        jceOutputStream.write(this.f336747e, 5);
        jceOutputStream.write(this.f336748f, 6);
    }

    public a(int i3, l lVar, l lVar2, byte b16, int i16, long j3) {
        this.f336743a = i3;
        this.f336744b = lVar;
        this.f336745c = lVar2;
        this.f336746d = b16;
        this.f336747e = i16;
        this.f336748f = j3;
    }
}
