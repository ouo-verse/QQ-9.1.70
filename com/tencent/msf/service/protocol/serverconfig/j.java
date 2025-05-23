package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class j extends JceStruct {

    /* renamed from: q, reason: collision with root package name */
    static ArrayList<k> f336832q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    static ArrayList<k> f336833r;

    /* renamed from: s, reason: collision with root package name */
    static ArrayList<k> f336834s;

    /* renamed from: t, reason: collision with root package name */
    static ArrayList<k> f336835t;

    /* renamed from: u, reason: collision with root package name */
    static ArrayList<k> f336836u;

    /* renamed from: v, reason: collision with root package name */
    static ArrayList<k> f336837v;

    /* renamed from: w, reason: collision with root package name */
    static ArrayList<k> f336838w;

    /* renamed from: x, reason: collision with root package name */
    static ArrayList<k> f336839x;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<k> f336840a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<k> f336841b;

    /* renamed from: c, reason: collision with root package name */
    public int f336842c;

    /* renamed from: d, reason: collision with root package name */
    public byte f336843d;

    /* renamed from: e, reason: collision with root package name */
    public byte f336844e;

    /* renamed from: f, reason: collision with root package name */
    public int f336845f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<k> f336846g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<k> f336847h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<k> f336848i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<k> f336849j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<k> f336850k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<k> f336851l;

    /* renamed from: m, reason: collision with root package name */
    public byte f336852m;

    /* renamed from: n, reason: collision with root package name */
    public int f336853n;

    /* renamed from: o, reason: collision with root package name */
    public String f336854o;

    /* renamed from: p, reason: collision with root package name */
    public byte f336855p;

    static {
        f336832q.add(new k());
        f336833r = new ArrayList<>();
        f336833r.add(new k());
        f336834s = new ArrayList<>();
        f336834s.add(new k());
        f336835t = new ArrayList<>();
        f336835t.add(new k());
        f336836u = new ArrayList<>();
        f336836u.add(new k());
        f336837v = new ArrayList<>();
        f336837v.add(new k());
        f336838w = new ArrayList<>();
        f336838w.add(new k());
        f336839x = new ArrayList<>();
        f336839x.add(new k());
    }

    public j() {
        this.f336840a = null;
        this.f336841b = null;
        this.f336842c = 0;
        this.f336843d = (byte) 0;
        this.f336844e = (byte) 0;
        this.f336845f = 1;
        this.f336846g = null;
        this.f336847h = null;
        this.f336848i = null;
        this.f336849j = null;
        this.f336850k = null;
        this.f336851l = null;
        this.f336852m = (byte) 0;
        this.f336853n = 0;
        this.f336854o = "";
        this.f336855p = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f336840a = (ArrayList) jceInputStream.read((JceInputStream) f336832q, 1, true);
        this.f336841b = (ArrayList) jceInputStream.read((JceInputStream) f336833r, 3, true);
        this.f336842c = jceInputStream.read(this.f336842c, 4, true);
        this.f336843d = jceInputStream.read(this.f336843d, 5, false);
        this.f336844e = jceInputStream.read(this.f336844e, 6, false);
        this.f336845f = jceInputStream.read(this.f336845f, 7, false);
        this.f336846g = (ArrayList) jceInputStream.read((JceInputStream) f336834s, 8, false);
        this.f336847h = (ArrayList) jceInputStream.read((JceInputStream) f336835t, 9, false);
        this.f336848i = (ArrayList) jceInputStream.read((JceInputStream) f336836u, 10, false);
        this.f336849j = (ArrayList) jceInputStream.read((JceInputStream) f336837v, 11, false);
        this.f336850k = (ArrayList) jceInputStream.read((JceInputStream) f336838w, 12, false);
        this.f336851l = (ArrayList) jceInputStream.read((JceInputStream) f336839x, 13, false);
        this.f336852m = jceInputStream.read(this.f336852m, 14, false);
        this.f336853n = jceInputStream.read(this.f336853n, 15, false);
        this.f336854o = jceInputStream.readString(16, false);
        this.f336855p = jceInputStream.read(this.f336855p, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.f336840a, 1);
        jceOutputStream.write((Collection) this.f336841b, 3);
        jceOutputStream.write(this.f336842c, 4);
        jceOutputStream.write(this.f336843d, 5);
        jceOutputStream.write(this.f336844e, 6);
        jceOutputStream.write(this.f336845f, 7);
        ArrayList<k> arrayList = this.f336846g;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 8);
        }
        ArrayList<k> arrayList2 = this.f336847h;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 9);
        }
        ArrayList<k> arrayList3 = this.f336848i;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 10);
        }
        ArrayList<k> arrayList4 = this.f336849j;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 11);
        }
        ArrayList<k> arrayList5 = this.f336850k;
        if (arrayList5 != null) {
            jceOutputStream.write((Collection) arrayList5, 12);
        }
        ArrayList<k> arrayList6 = this.f336851l;
        if (arrayList6 != null) {
            jceOutputStream.write((Collection) arrayList6, 13);
        }
        jceOutputStream.write(this.f336852m, 14);
        jceOutputStream.write(this.f336853n, 15);
        String str = this.f336854o;
        if (str != null) {
            jceOutputStream.write(str, 16);
        }
        jceOutputStream.write(this.f336855p, 17);
    }

    public j(ArrayList<k> arrayList, ArrayList<k> arrayList2, int i3, byte b16, byte b17, int i16, ArrayList<k> arrayList3, ArrayList<k> arrayList4, ArrayList<k> arrayList5, ArrayList<k> arrayList6, ArrayList<k> arrayList7, ArrayList<k> arrayList8, byte b18, int i17, String str, byte b19) {
        this.f336840a = arrayList;
        this.f336841b = arrayList2;
        this.f336842c = i3;
        this.f336843d = b16;
        this.f336844e = b17;
        this.f336845f = i16;
        this.f336846g = arrayList3;
        this.f336847h = arrayList4;
        this.f336848i = arrayList5;
        this.f336849j = arrayList6;
        this.f336850k = arrayList7;
        this.f336851l = arrayList8;
        this.f336852m = b18;
        this.f336853n = i17;
        this.f336854o = str;
        this.f336855p = b19;
    }
}
