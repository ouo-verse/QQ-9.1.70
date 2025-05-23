package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e extends JceStruct {
    static ArrayList<i> A;
    static ArrayList<i> B;
    static ArrayList<i> C;

    /* renamed from: v, reason: collision with root package name */
    static ArrayList<i> f336776v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    static ArrayList<i> f336777w;

    /* renamed from: x, reason: collision with root package name */
    static ArrayList<i> f336778x;

    /* renamed from: y, reason: collision with root package name */
    static ArrayList<i> f336779y;

    /* renamed from: z, reason: collision with root package name */
    static byte[] f336780z;

    /* renamed from: a, reason: collision with root package name */
    public int f336781a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<i> f336782b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<i> f336783c;

    /* renamed from: d, reason: collision with root package name */
    public int f336784d;

    /* renamed from: e, reason: collision with root package name */
    public int f336785e;

    /* renamed from: f, reason: collision with root package name */
    public byte f336786f;

    /* renamed from: g, reason: collision with root package name */
    public byte f336787g;

    /* renamed from: h, reason: collision with root package name */
    public int f336788h;

    /* renamed from: i, reason: collision with root package name */
    public int f336789i;

    /* renamed from: j, reason: collision with root package name */
    public long f336790j;

    /* renamed from: k, reason: collision with root package name */
    public int f336791k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<i> f336792l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<i> f336793m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f336794n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<i> f336795o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<i> f336796p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<i> f336797q;

    /* renamed from: r, reason: collision with root package name */
    public byte f336798r;

    /* renamed from: s, reason: collision with root package name */
    public int f336799s;

    /* renamed from: t, reason: collision with root package name */
    public String f336800t;

    /* renamed from: u, reason: collision with root package name */
    public byte f336801u;

    static {
        f336776v.add(new i());
        f336777w = new ArrayList<>();
        f336777w.add(new i());
        f336778x = new ArrayList<>();
        f336778x.add(new i());
        f336779y = new ArrayList<>();
        f336779y.add(new i());
        f336780z = r0;
        byte[] bArr = {0};
        A = new ArrayList<>();
        A.add(new i());
        B = new ArrayList<>();
        B.add(new i());
        C = new ArrayList<>();
        C.add(new i());
    }

    public e() {
        this.f336781a = 0;
        this.f336782b = null;
        this.f336783c = null;
        this.f336784d = 0;
        this.f336785e = 86400;
        this.f336786f = (byte) 0;
        this.f336787g = (byte) 0;
        this.f336788h = 1;
        this.f336789i = 5;
        this.f336790j = 0L;
        this.f336791k = 0;
        this.f336792l = null;
        this.f336793m = null;
        this.f336794n = null;
        this.f336795o = null;
        this.f336796p = null;
        this.f336797q = null;
        this.f336798r = (byte) 0;
        this.f336799s = 0;
        this.f336800t = "";
        this.f336801u = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336781a = jceInputStream.read(this.f336781a, 1, true);
        this.f336782b = (ArrayList) jceInputStream.read((JceInputStream) f336776v, 2, true);
        this.f336783c = (ArrayList) jceInputStream.read((JceInputStream) f336777w, 3, true);
        this.f336784d = jceInputStream.read(this.f336784d, 4, true);
        this.f336785e = jceInputStream.read(this.f336785e, 5, true);
        this.f336786f = jceInputStream.read(this.f336786f, 6, false);
        this.f336787g = jceInputStream.read(this.f336787g, 7, false);
        this.f336788h = jceInputStream.read(this.f336788h, 8, false);
        this.f336789i = jceInputStream.read(this.f336789i, 9, false);
        this.f336790j = jceInputStream.read(this.f336790j, 10, false);
        this.f336791k = jceInputStream.read(this.f336791k, 11, false);
        this.f336792l = (ArrayList) jceInputStream.read((JceInputStream) f336778x, 12, false);
        this.f336793m = (ArrayList) jceInputStream.read((JceInputStream) f336779y, 13, false);
        this.f336794n = jceInputStream.read(f336780z, 14, false);
        this.f336795o = (ArrayList) jceInputStream.read((JceInputStream) A, 15, false);
        this.f336796p = (ArrayList) jceInputStream.read((JceInputStream) B, 16, false);
        this.f336797q = (ArrayList) jceInputStream.read((JceInputStream) C, 17, false);
        this.f336798r = jceInputStream.read(this.f336798r, 18, false);
        this.f336799s = jceInputStream.read(this.f336799s, 19, false);
        this.f336800t = jceInputStream.readString(20, false);
        this.f336801u = jceInputStream.read(this.f336801u, 21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336781a, 1);
        jceOutputStream.write((Collection) this.f336782b, 2);
        jceOutputStream.write((Collection) this.f336783c, 3);
        jceOutputStream.write(this.f336784d, 4);
        jceOutputStream.write(this.f336785e, 5);
        jceOutputStream.write(this.f336786f, 6);
        jceOutputStream.write(this.f336787g, 7);
        jceOutputStream.write(this.f336788h, 8);
        jceOutputStream.write(this.f336789i, 9);
        jceOutputStream.write(this.f336790j, 10);
        jceOutputStream.write(this.f336791k, 11);
        ArrayList<i> arrayList = this.f336792l;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 12);
        }
        ArrayList<i> arrayList2 = this.f336793m;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 13);
        }
        byte[] bArr = this.f336794n;
        if (bArr != null) {
            jceOutputStream.write(bArr, 14);
        }
        ArrayList<i> arrayList3 = this.f336795o;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 15);
        }
        ArrayList<i> arrayList4 = this.f336796p;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 16);
        }
        ArrayList<i> arrayList5 = this.f336797q;
        if (arrayList5 != null) {
            jceOutputStream.write((Collection) arrayList5, 17);
        }
        jceOutputStream.write(this.f336798r, 18);
        jceOutputStream.write(this.f336799s, 19);
        String str = this.f336800t;
        if (str != null) {
            jceOutputStream.write(str, 20);
        }
        jceOutputStream.write(this.f336801u, 21);
    }

    public e(int i3, ArrayList<i> arrayList, ArrayList<i> arrayList2, int i16, int i17, byte b16, byte b17, int i18, int i19, long j3, int i26, ArrayList<i> arrayList3, ArrayList<i> arrayList4, byte[] bArr, ArrayList<i> arrayList5, ArrayList<i> arrayList6, ArrayList<i> arrayList7, byte b18, int i27, String str, byte b19) {
        this.f336781a = i3;
        this.f336782b = arrayList;
        this.f336783c = arrayList2;
        this.f336784d = i16;
        this.f336785e = i17;
        this.f336786f = b16;
        this.f336787g = b17;
        this.f336788h = i18;
        this.f336789i = i19;
        this.f336790j = j3;
        this.f336791k = i26;
        this.f336792l = arrayList3;
        this.f336793m = arrayList4;
        this.f336794n = bArr;
        this.f336795o = arrayList5;
        this.f336796p = arrayList6;
        this.f336797q = arrayList7;
        this.f336798r = b18;
        this.f336799s = i27;
        this.f336800t = str;
        this.f336801u = b19;
    }
}
