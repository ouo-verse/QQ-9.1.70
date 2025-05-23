package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class i extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public String f336822a;

    /* renamed from: b, reason: collision with root package name */
    public int f336823b;

    /* renamed from: c, reason: collision with root package name */
    public byte f336824c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336825d;

    /* renamed from: e, reason: collision with root package name */
    public byte f336826e;

    /* renamed from: f, reason: collision with root package name */
    public int f336827f;

    /* renamed from: g, reason: collision with root package name */
    public byte f336828g;

    /* renamed from: h, reason: collision with root package name */
    public String f336829h;

    /* renamed from: i, reason: collision with root package name */
    public String f336830i;

    /* renamed from: j, reason: collision with root package name */
    public long f336831j;

    public i() {
        this.f336822a = "";
        this.f336823b = 0;
        this.f336824c = (byte) 0;
        this.f336825d = (byte) 0;
        this.f336826e = (byte) 0;
        this.f336827f = 8;
        this.f336828g = (byte) 0;
        this.f336829h = "";
        this.f336830i = "";
        this.f336831j = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336822a = jceInputStream.readString(1, true);
        this.f336823b = jceInputStream.read(this.f336823b, 2, true);
        this.f336824c = jceInputStream.read(this.f336824c, 3, true);
        this.f336825d = jceInputStream.read(this.f336825d, 4, true);
        this.f336826e = jceInputStream.read(this.f336826e, 5, false);
        this.f336827f = jceInputStream.read(this.f336827f, 6, false);
        this.f336828g = jceInputStream.read(this.f336828g, 7, false);
        this.f336829h = jceInputStream.readString(8, false);
        this.f336830i = jceInputStream.readString(9, false);
        this.f336831j = jceInputStream.read(this.f336831j, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336822a, 1);
        jceOutputStream.write(this.f336823b, 2);
        jceOutputStream.write(this.f336824c, 3);
        jceOutputStream.write(this.f336825d, 4);
        jceOutputStream.write(this.f336826e, 5);
        jceOutputStream.write(this.f336827f, 6);
        jceOutputStream.write(this.f336828g, 7);
        String str = this.f336829h;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        String str2 = this.f336830i;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        jceOutputStream.write(this.f336831j, 10);
    }

    public i(String str, int i3, byte b16, byte b17, byte b18, int i16, byte b19, String str2, String str3, long j3) {
        this.f336822a = str;
        this.f336823b = i3;
        this.f336824c = b16;
        this.f336825d = b17;
        this.f336826e = b18;
        this.f336827f = i16;
        this.f336828g = b19;
        this.f336829h = str2;
        this.f336830i = str3;
        this.f336831j = j3;
    }
}
