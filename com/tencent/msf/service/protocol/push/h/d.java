package com.tencent.msf.service.protocol.push.h;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d extends JceStruct {
    static ArrayList<a> A = new ArrayList<>();
    static byte[] B;
    static byte[] C;
    static byte[] D;
    static ArrayList<e> E;
    static ArrayList<c> F;

    /* renamed from: a, reason: collision with root package name */
    public short f336591a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<a> f336592b;

    /* renamed from: c, reason: collision with root package name */
    public long f336593c;

    /* renamed from: d, reason: collision with root package name */
    public long f336594d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f336595e;

    /* renamed from: f, reason: collision with root package name */
    public long f336596f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f336597g;

    /* renamed from: h, reason: collision with root package name */
    public long f336598h;

    /* renamed from: i, reason: collision with root package name */
    public long f336599i;

    /* renamed from: j, reason: collision with root package name */
    public long f336600j;

    /* renamed from: k, reason: collision with root package name */
    public long f336601k;

    /* renamed from: l, reason: collision with root package name */
    public long f336602l;

    /* renamed from: m, reason: collision with root package name */
    public long f336603m;

    /* renamed from: n, reason: collision with root package name */
    public long f336604n;

    /* renamed from: o, reason: collision with root package name */
    public short f336605o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f336606p;

    /* renamed from: q, reason: collision with root package name */
    public String f336607q;

    /* renamed from: r, reason: collision with root package name */
    public short f336608r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<e> f336609s;

    /* renamed from: t, reason: collision with root package name */
    public String f336610t;

    /* renamed from: u, reason: collision with root package name */
    public String f336611u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<c> f336612v;

    /* renamed from: w, reason: collision with root package name */
    public long f336613w;

    /* renamed from: x, reason: collision with root package name */
    public long f336614x;

    /* renamed from: y, reason: collision with root package name */
    public short f336615y;

    /* renamed from: z, reason: collision with root package name */
    public short f336616z;

    static {
        A.add(new a());
        B = r1;
        byte[] bArr = {0};
        C = r1;
        byte[] bArr2 = {0};
        D = r0;
        byte[] bArr3 = {0};
        E = new ArrayList<>();
        E.add(new e());
        F = new ArrayList<>();
        F.add(new c());
    }

    public d() {
        this.f336591a = (short) 0;
        this.f336592b = null;
        this.f336593c = 0L;
        this.f336594d = 0L;
        this.f336595e = null;
        this.f336596f = 0L;
        this.f336597g = null;
        this.f336598h = 0L;
        this.f336599i = 0L;
        this.f336600j = 0L;
        this.f336601k = 0L;
        this.f336602l = 0L;
        this.f336603m = 0L;
        this.f336604n = 0L;
        this.f336605o = (short) 0;
        this.f336606p = null;
        this.f336607q = "";
        this.f336608r = (short) 0;
        this.f336609s = null;
        this.f336610t = "";
        this.f336611u = "";
        this.f336612v = null;
        this.f336613w = 0L;
        this.f336614x = 0L;
        this.f336615y = (short) 0;
        this.f336616z = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336591a = jceInputStream.read(this.f336591a, 0, false);
        this.f336592b = (ArrayList) jceInputStream.read((JceInputStream) A, 1, false);
        this.f336593c = jceInputStream.read(this.f336593c, 2, false);
        this.f336594d = jceInputStream.read(this.f336594d, 3, false);
        this.f336595e = jceInputStream.read(B, 4, false);
        this.f336596f = jceInputStream.read(this.f336596f, 5, false);
        this.f336597g = jceInputStream.read(C, 6, false);
        this.f336598h = jceInputStream.read(this.f336598h, 7, false);
        this.f336599i = jceInputStream.read(this.f336599i, 8, false);
        this.f336600j = jceInputStream.read(this.f336600j, 9, false);
        this.f336601k = jceInputStream.read(this.f336601k, 10, false);
        this.f336602l = jceInputStream.read(this.f336602l, 11, false);
        this.f336603m = jceInputStream.read(this.f336603m, 12, false);
        this.f336604n = jceInputStream.read(this.f336604n, 13, false);
        this.f336605o = jceInputStream.read(this.f336605o, 14, false);
        this.f336606p = jceInputStream.read(D, 15, false);
        this.f336607q = jceInputStream.readString(16, false);
        this.f336608r = jceInputStream.read(this.f336608r, 17, false);
        this.f336609s = (ArrayList) jceInputStream.read((JceInputStream) E, 18, false);
        this.f336610t = jceInputStream.readString(19, false);
        this.f336611u = jceInputStream.readString(20, false);
        this.f336612v = (ArrayList) jceInputStream.read((JceInputStream) F, 21, false);
        this.f336613w = jceInputStream.read(this.f336613w, 22, false);
        this.f336614x = jceInputStream.read(this.f336614x, 23, false);
        this.f336615y = jceInputStream.read(this.f336615y, 24, false);
        this.f336616z = jceInputStream.read(this.f336616z, 25, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336591a, 0);
        ArrayList<a> arrayList = this.f336592b;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.f336593c, 2);
        jceOutputStream.write(this.f336594d, 3);
        byte[] bArr = this.f336595e;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        jceOutputStream.write(this.f336596f, 5);
        byte[] bArr2 = this.f336597g;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 6);
        }
        jceOutputStream.write(this.f336598h, 7);
        jceOutputStream.write(this.f336599i, 8);
        jceOutputStream.write(this.f336600j, 9);
        jceOutputStream.write(this.f336601k, 10);
        jceOutputStream.write(this.f336602l, 11);
        jceOutputStream.write(this.f336603m, 12);
        jceOutputStream.write(this.f336604n, 13);
        jceOutputStream.write(this.f336605o, 14);
        byte[] bArr3 = this.f336606p;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 15);
        }
        String str = this.f336607q;
        if (str != null) {
            jceOutputStream.write(str, 16);
        }
        jceOutputStream.write(this.f336608r, 17);
        ArrayList<e> arrayList2 = this.f336609s;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 18);
        }
        String str2 = this.f336610t;
        if (str2 != null) {
            jceOutputStream.write(str2, 19);
        }
        String str3 = this.f336611u;
        if (str3 != null) {
            jceOutputStream.write(str3, 20);
        }
        ArrayList<c> arrayList3 = this.f336612v;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 21);
        }
        jceOutputStream.write(this.f336613w, 22);
        jceOutputStream.write(this.f336614x, 23);
        jceOutputStream.write(this.f336615y, 24);
        jceOutputStream.write(this.f336616z, 25);
    }

    public d(short s16, ArrayList<a> arrayList, long j3, long j16, byte[] bArr, long j17, byte[] bArr2, long j18, long j19, long j26, long j27, long j28, long j29, long j36, short s17, byte[] bArr3, String str, short s18, ArrayList<e> arrayList2, String str2, String str3, ArrayList<c> arrayList3, long j37, long j38, short s19, short s26) {
        this.f336591a = s16;
        this.f336592b = arrayList;
        this.f336593c = j3;
        this.f336594d = j16;
        this.f336595e = bArr;
        this.f336596f = j17;
        this.f336597g = bArr2;
        this.f336598h = j18;
        this.f336599i = j19;
        this.f336600j = j26;
        this.f336601k = j27;
        this.f336602l = j28;
        this.f336603m = j29;
        this.f336604n = j36;
        this.f336605o = s17;
        this.f336606p = bArr3;
        this.f336607q = str;
        this.f336608r = s18;
        this.f336609s = arrayList2;
        this.f336610t = str2;
        this.f336611u = str3;
        this.f336612v = arrayList3;
        this.f336613w = j37;
        this.f336614x = j38;
        this.f336615y = s19;
        this.f336616z = s26;
    }
}
