package com.tencent.apkupdate.obfuscated;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public short f72482a;

    /* renamed from: b, reason: collision with root package name */
    public short f72483b;

    /* renamed from: c, reason: collision with root package name */
    public short f72484c;

    /* renamed from: d, reason: collision with root package name */
    public short f72485d;

    /* renamed from: e, reason: collision with root package name */
    public short f72486e;

    /* renamed from: f, reason: collision with root package name */
    public short f72487f;

    /* renamed from: g, reason: collision with root package name */
    public int f72488g;

    /* renamed from: h, reason: collision with root package name */
    public int f72489h;

    /* renamed from: i, reason: collision with root package name */
    public int f72490i;

    /* renamed from: j, reason: collision with root package name */
    public short f72491j;

    /* renamed from: k, reason: collision with root package name */
    public short f72492k;

    /* renamed from: l, reason: collision with root package name */
    public short f72493l;

    /* renamed from: m, reason: collision with root package name */
    public short f72494m;

    /* renamed from: n, reason: collision with root package name */
    public short f72495n;

    /* renamed from: o, reason: collision with root package name */
    public short f72496o;

    /* renamed from: p, reason: collision with root package name */
    public int f72497p;

    /* renamed from: q, reason: collision with root package name */
    public int f72498q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f72499r;

    /* renamed from: s, reason: collision with root package name */
    public byte[] f72500s;

    /* renamed from: t, reason: collision with root package name */
    public byte[] f72501t;

    /* renamed from: u, reason: collision with root package name */
    public byte[] f72502u;

    /* renamed from: v, reason: collision with root package name */
    public byte[] f72503v;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(DataInputStream dataInputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataInputStream);
            return;
        }
        this.f72482a = dataInputStream.readShort();
        this.f72483b = dataInputStream.readShort();
        this.f72484c = dataInputStream.readShort();
        this.f72485d = dataInputStream.readShort();
        this.f72486e = dataInputStream.readShort();
        this.f72487f = dataInputStream.readShort();
        this.f72488g = dataInputStream.readInt();
        this.f72489h = dataInputStream.readInt();
        this.f72490i = dataInputStream.readInt();
        this.f72491j = dataInputStream.readShort();
        this.f72492k = dataInputStream.readShort();
        this.f72493l = dataInputStream.readShort();
        this.f72494m = dataInputStream.readShort();
        this.f72495n = dataInputStream.readShort();
        this.f72496o = dataInputStream.readShort();
        this.f72497p = dataInputStream.readInt();
        this.f72498q = dataInputStream.readInt();
        this.f72499r = dataInputStream.readBoolean();
        int i3 = this.f72491j;
        byte[] bArr = new byte[i3];
        this.f72500s = bArr;
        this.f72501t = new byte[this.f72492k];
        this.f72502u = new byte[this.f72493l];
        this.f72503v = new byte[this.f72494m];
        dataInputStream.read(bArr, 0, i3);
        dataInputStream.read(this.f72501t, 0, this.f72492k);
        dataInputStream.read(this.f72502u, 0, this.f72493l);
        dataInputStream.read(this.f72503v, 0, this.f72494m);
    }

    public void b(DataOutputStream dataOutputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataOutputStream);
            return;
        }
        dataOutputStream.writeInt(1347092738);
        dataOutputStream.writeShort(a.d(this.f72482a));
        dataOutputStream.writeShort(a.d(this.f72483b));
        dataOutputStream.writeShort(a.d(this.f72484c));
        dataOutputStream.writeShort(a.d(this.f72485d));
        dataOutputStream.writeShort(a.d(this.f72486e));
        dataOutputStream.writeShort(a.d(this.f72487f));
        dataOutputStream.writeInt(a.a(this.f72488g));
        dataOutputStream.writeInt(a.a(this.f72489h));
        dataOutputStream.writeInt(a.a(this.f72490i));
        dataOutputStream.writeShort(a.d(this.f72491j));
        dataOutputStream.writeShort(a.d(this.f72493l));
        dataOutputStream.writeShort(a.d(this.f72494m));
        dataOutputStream.writeShort(a.d(this.f72495n));
        dataOutputStream.writeShort(a.d(this.f72496o));
        dataOutputStream.writeInt(a.a(this.f72497p));
        dataOutputStream.writeInt(a.a(this.f72498q));
        if (this.f72491j > 0) {
            dataOutputStream.write(this.f72500s);
        }
        if (this.f72493l > 0) {
            dataOutputStream.write(this.f72502u);
        }
        if (this.f72494m > 0) {
            dataOutputStream.write(this.f72503v);
        }
    }
}
