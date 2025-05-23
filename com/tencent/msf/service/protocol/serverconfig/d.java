package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d extends JceStruct {

    /* renamed from: a, reason: collision with root package name */
    public long f336762a;

    /* renamed from: b, reason: collision with root package name */
    public long f336763b;

    /* renamed from: c, reason: collision with root package name */
    public byte f336764c;

    /* renamed from: d, reason: collision with root package name */
    public String f336765d;

    /* renamed from: e, reason: collision with root package name */
    public int f336766e;

    /* renamed from: f, reason: collision with root package name */
    public long f336767f;

    /* renamed from: g, reason: collision with root package name */
    public String f336768g;

    /* renamed from: h, reason: collision with root package name */
    public long f336769h;

    /* renamed from: i, reason: collision with root package name */
    public long f336770i;

    /* renamed from: j, reason: collision with root package name */
    public long f336771j;

    /* renamed from: k, reason: collision with root package name */
    public byte f336772k;

    /* renamed from: l, reason: collision with root package name */
    public byte f336773l;

    /* renamed from: m, reason: collision with root package name */
    public long f336774m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f336775n;

    public d() {
        this.f336762a = 0L;
        this.f336763b = 0L;
        this.f336764c = (byte) 1;
        this.f336765d = "46000";
        this.f336766e = 0;
        this.f336767f = 0L;
        this.f336768g = "";
        this.f336769h = 0L;
        this.f336770i = 0L;
        this.f336771j = 0L;
        this.f336772k = (byte) 0;
        this.f336773l = (byte) 0;
        this.f336774m = 0L;
        this.f336775n = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336762a = jceInputStream.read(this.f336762a, 1, true);
        this.f336763b = jceInputStream.read(this.f336763b, 2, true);
        this.f336764c = jceInputStream.read(this.f336764c, 3, true);
        this.f336765d = jceInputStream.readString(4, true);
        this.f336766e = jceInputStream.read(this.f336766e, 5, true);
        this.f336767f = jceInputStream.read(this.f336767f, 6, true);
        this.f336768g = jceInputStream.readString(7, true);
        this.f336769h = jceInputStream.read(this.f336769h, 8, false);
        this.f336770i = jceInputStream.read(this.f336770i, 9, false);
        this.f336771j = jceInputStream.read(this.f336771j, 10, false);
        this.f336772k = jceInputStream.read(this.f336772k, 11, false);
        this.f336773l = jceInputStream.read(this.f336773l, 12, false);
        this.f336774m = jceInputStream.read(this.f336774m, 13, false);
        this.f336775n = jceInputStream.read(this.f336775n, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336762a, 1);
        jceOutputStream.write(this.f336763b, 2);
        jceOutputStream.write(this.f336764c, 3);
        jceOutputStream.write(this.f336765d, 4);
        jceOutputStream.write(this.f336766e, 5);
        jceOutputStream.write(this.f336767f, 6);
        jceOutputStream.write(this.f336768g, 7);
        jceOutputStream.write(this.f336769h, 8);
        jceOutputStream.write(this.f336770i, 9);
        jceOutputStream.write(this.f336771j, 10);
        jceOutputStream.write(this.f336772k, 11);
        jceOutputStream.write(this.f336773l, 12);
        jceOutputStream.write(this.f336774m, 13);
        jceOutputStream.write(this.f336775n, 14);
    }

    public d(long j3, long j16, byte b16, String str, int i3, long j17, String str2, long j18, long j19, long j26, byte b17, byte b18, long j27, boolean z16) {
        this.f336762a = j3;
        this.f336763b = j16;
        this.f336764c = b16;
        this.f336765d = str;
        this.f336766e = i3;
        this.f336767f = j17;
        this.f336768g = str2;
        this.f336769h = j18;
        this.f336770i = j19;
        this.f336771j = j26;
        this.f336772k = b17;
        this.f336773l = b18;
        this.f336774m = j27;
        this.f336775n = z16;
    }
}
