package com.tencent.msf.service.protocol.push.h;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b extends JceStruct {

    /* renamed from: j, reason: collision with root package name */
    static ArrayList<a> f336576j;

    /* renamed from: k, reason: collision with root package name */
    static ArrayList<byte[]> f336577k;

    /* renamed from: l, reason: collision with root package name */
    static ArrayList<Long> f336578l;

    /* renamed from: m, reason: collision with root package name */
    static ArrayList<byte[]> f336579m;

    /* renamed from: a, reason: collision with root package name */
    public short f336580a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<a> f336581b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<byte[]> f336582c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<Long> f336583d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<byte[]> f336584e;

    /* renamed from: f, reason: collision with root package name */
    public long f336585f;

    /* renamed from: g, reason: collision with root package name */
    public long f336586g;

    /* renamed from: h, reason: collision with root package name */
    public long f336587h;

    /* renamed from: i, reason: collision with root package name */
    public long f336588i;

    public b() {
        this.f336580a = (short) 0;
        this.f336581b = null;
        this.f336582c = null;
        this.f336583d = null;
        this.f336584e = null;
        this.f336585f = 0L;
        this.f336586g = 0L;
        this.f336587h = 0L;
        this.f336588i = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336580a = jceInputStream.read(this.f336580a, 0, false);
        if (f336576j == null) {
            f336576j = new ArrayList<>();
            f336576j.add(new a());
        }
        this.f336581b = (ArrayList) jceInputStream.read((JceInputStream) f336576j, 1, false);
        if (f336577k == null) {
            ArrayList<byte[]> arrayList = new ArrayList<>();
            f336577k = arrayList;
            arrayList.add(new byte[]{0});
        }
        this.f336582c = (ArrayList) jceInputStream.read((JceInputStream) f336577k, 2, false);
        if (f336578l == null) {
            f336578l = new ArrayList<>();
            f336578l.add(0L);
        }
        this.f336583d = (ArrayList) jceInputStream.read((JceInputStream) f336578l, 3, false);
        if (f336579m == null) {
            ArrayList<byte[]> arrayList2 = new ArrayList<>();
            f336579m = arrayList2;
            arrayList2.add(new byte[]{0});
        }
        this.f336584e = (ArrayList) jceInputStream.read((JceInputStream) f336579m, 4, false);
        this.f336585f = jceInputStream.read(this.f336585f, 5, false);
        this.f336586g = jceInputStream.read(this.f336586g, 6, false);
        this.f336587h = jceInputStream.read(this.f336587h, 7, false);
        this.f336588i = jceInputStream.read(this.f336588i, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f336580a, 0);
        ArrayList<a> arrayList = this.f336581b;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<byte[]> arrayList2 = this.f336582c;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
        ArrayList<Long> arrayList3 = this.f336583d;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 3);
        }
        ArrayList<byte[]> arrayList4 = this.f336584e;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 4);
        }
        jceOutputStream.write(this.f336585f, 5);
        jceOutputStream.write(this.f336586g, 6);
        jceOutputStream.write(this.f336587h, 7);
        jceOutputStream.write(this.f336588i, 8);
    }

    public b(short s16, ArrayList<a> arrayList, ArrayList<byte[]> arrayList2, ArrayList<Long> arrayList3, ArrayList<byte[]> arrayList4, long j3, long j16, long j17, long j18) {
        this.f336580a = s16;
        this.f336581b = arrayList;
        this.f336582c = arrayList2;
        this.f336583d = arrayList3;
        this.f336584e = arrayList4;
        this.f336585f = j3;
        this.f336586g = j16;
        this.f336587h = j17;
        this.f336588i = j18;
    }
}
