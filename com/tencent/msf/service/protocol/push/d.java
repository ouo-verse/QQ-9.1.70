package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d extends JceStruct {

    /* renamed from: v, reason: collision with root package name */
    static byte[] f336534v;

    /* renamed from: w, reason: collision with root package name */
    static ArrayList<Long> f336535w = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    public long f336536a;

    /* renamed from: b, reason: collision with root package name */
    public long f336537b;

    /* renamed from: c, reason: collision with root package name */
    public String f336538c;

    /* renamed from: d, reason: collision with root package name */
    public int f336539d;

    /* renamed from: e, reason: collision with root package name */
    public byte f336540e;

    /* renamed from: f, reason: collision with root package name */
    public byte f336541f;

    /* renamed from: g, reason: collision with root package name */
    public byte f336542g;

    /* renamed from: h, reason: collision with root package name */
    public int f336543h;

    /* renamed from: i, reason: collision with root package name */
    public int f336544i;

    /* renamed from: j, reason: collision with root package name */
    public int f336545j;

    /* renamed from: k, reason: collision with root package name */
    public int f336546k;

    /* renamed from: l, reason: collision with root package name */
    public int f336547l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f336548m;

    /* renamed from: n, reason: collision with root package name */
    public String f336549n;

    /* renamed from: o, reason: collision with root package name */
    public String f336550o;

    /* renamed from: p, reason: collision with root package name */
    public String f336551p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<Long> f336552q;

    /* renamed from: r, reason: collision with root package name */
    public long f336553r;

    /* renamed from: s, reason: collision with root package name */
    public long f336554s;

    /* renamed from: t, reason: collision with root package name */
    public int f336555t;

    /* renamed from: u, reason: collision with root package name */
    public byte f336556u;

    static {
        f336534v = r0;
        byte[] bArr = {0};
        f336535w.add(0L);
    }

    public d() {
        this.f336536a = 0L;
        this.f336537b = 0L;
        this.f336538c = "";
        this.f336539d = 11;
        this.f336540e = (byte) 0;
        this.f336541f = (byte) 0;
        this.f336542g = (byte) 0;
        this.f336543h = 0;
        this.f336544i = 0;
        this.f336545j = 0;
        this.f336546k = 0;
        this.f336547l = 0;
        this.f336548m = null;
        this.f336549n = "";
        this.f336550o = "";
        this.f336551p = "";
        this.f336552q = null;
        this.f336553r = 0L;
        this.f336554s = 0L;
        this.f336555t = 0;
        this.f336556u = (byte) 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336536a = jceInputStream.read(this.f336536a, 0, true);
        this.f336537b = jceInputStream.read(this.f336537b, 1, true);
        this.f336538c = jceInputStream.readString(2, true);
        this.f336539d = jceInputStream.read(this.f336539d, 3, false);
        this.f336540e = jceInputStream.read(this.f336540e, 4, false);
        this.f336541f = jceInputStream.read(this.f336541f, 5, false);
        this.f336542g = jceInputStream.read(this.f336542g, 6, false);
        this.f336543h = jceInputStream.read(this.f336543h, 7, false);
        this.f336544i = jceInputStream.read(this.f336544i, 8, false);
        this.f336545j = jceInputStream.read(this.f336545j, 9, false);
        this.f336546k = jceInputStream.read(this.f336546k, 10, false);
        this.f336547l = jceInputStream.read(this.f336547l, 11, false);
        this.f336548m = jceInputStream.read(f336534v, 12, false);
        this.f336549n = jceInputStream.readString(13, false);
        this.f336550o = jceInputStream.readString(14, false);
        this.f336551p = jceInputStream.readString(15, false);
        this.f336552q = (ArrayList) jceInputStream.read((JceInputStream) f336535w, 16, false);
        this.f336553r = jceInputStream.read(this.f336553r, 17, false);
        this.f336554s = jceInputStream.read(this.f336554s, 18, false);
        this.f336555t = jceInputStream.read(this.f336555t, 19, false);
        this.f336556u = jceInputStream.read(this.f336556u, 20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336536a, 0);
        jceOutputStream.write(this.f336537b, 1);
        jceOutputStream.write(this.f336538c, 2);
        jceOutputStream.write(this.f336539d, 3);
        jceOutputStream.write(this.f336540e, 4);
        jceOutputStream.write(this.f336541f, 5);
        jceOutputStream.write(this.f336542g, 6);
        jceOutputStream.write(this.f336543h, 7);
        jceOutputStream.write(this.f336544i, 8);
        jceOutputStream.write(this.f336545j, 9);
        jceOutputStream.write(this.f336546k, 10);
        jceOutputStream.write(this.f336547l, 11);
        byte[] bArr = this.f336548m;
        if (bArr != null) {
            jceOutputStream.write(bArr, 12);
        }
        String str = this.f336549n;
        if (str != null) {
            jceOutputStream.write(str, 13);
        }
        String str2 = this.f336550o;
        if (str2 != null) {
            jceOutputStream.write(str2, 14);
        }
        String str3 = this.f336551p;
        if (str3 != null) {
            jceOutputStream.write(str3, 15);
        }
        ArrayList<Long> arrayList = this.f336552q;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 16);
        }
        jceOutputStream.write(this.f336553r, 17);
        jceOutputStream.write(this.f336554s, 18);
        jceOutputStream.write(this.f336555t, 19);
        jceOutputStream.write(this.f336556u, 20);
    }

    public d(long j3, long j16, String str, int i3, byte b16, byte b17, byte b18, int i16, int i17, int i18, int i19, int i26, byte[] bArr, String str2, String str3, String str4, ArrayList<Long> arrayList, long j17, long j18, int i27, byte b19) {
        this.f336536a = j3;
        this.f336537b = j16;
        this.f336538c = str;
        this.f336539d = i3;
        this.f336540e = b16;
        this.f336541f = b17;
        this.f336542g = b18;
        this.f336543h = i16;
        this.f336544i = i17;
        this.f336545j = i18;
        this.f336546k = i19;
        this.f336547l = i26;
        this.f336548m = bArr;
        this.f336549n = str2;
        this.f336550o = str3;
        this.f336551p = str4;
        this.f336552q = arrayList;
        this.f336553r = j17;
        this.f336554s = j18;
        this.f336555t = i27;
        this.f336556u = b19;
    }
}
