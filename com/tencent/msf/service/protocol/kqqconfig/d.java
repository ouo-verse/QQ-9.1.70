package com.tencent.msf.service.protocol.kqqconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public int f336486a;

    /* renamed from: b, reason: collision with root package name */
    public int f336487b;

    /* renamed from: c, reason: collision with root package name */
    public int f336488c;

    /* renamed from: d, reason: collision with root package name */
    public String f336489d;

    /* renamed from: e, reason: collision with root package name */
    public int f336490e;

    /* renamed from: f, reason: collision with root package name */
    public String f336491f;

    /* renamed from: g, reason: collision with root package name */
    public int f336492g;

    public d() {
        this.f336486a = 0;
        this.f336487b = 0;
        this.f336488c = 0;
        this.f336489d = "";
        this.f336490e = 0;
        this.f336491f = "";
        this.f336492g = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336486a = jceInputStream.read(this.f336486a, 1, true);
        this.f336487b = jceInputStream.read(this.f336487b, 2, false);
        this.f336488c = jceInputStream.read(this.f336488c, 3, false);
        this.f336489d = jceInputStream.readString(4, false);
        this.f336490e = jceInputStream.read(this.f336490e, 5, false);
        this.f336491f = jceInputStream.readString(6, false);
        this.f336492g = jceInputStream.read(this.f336492g, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336486a, 1);
        jceOutputStream.write(this.f336487b, 2);
        jceOutputStream.write(this.f336488c, 3);
        String str = this.f336489d;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.f336490e, 5);
        String str2 = this.f336491f;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.f336492g, 7);
    }

    public d(int i3, int i16, int i17, String str, int i18, String str2, int i19) {
        this.f336486a = i3;
        this.f336487b = i16;
        this.f336488c = i17;
        this.f336489d = str;
        this.f336490e = i18;
        this.f336491f = str2;
        this.f336492g = i19;
    }
}
