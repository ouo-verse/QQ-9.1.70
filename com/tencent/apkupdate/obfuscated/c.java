package com.tencent.apkupdate.obfuscated;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.DataInputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public short f72504a;

    /* renamed from: b, reason: collision with root package name */
    public short f72505b;

    /* renamed from: c, reason: collision with root package name */
    public short f72506c;

    /* renamed from: d, reason: collision with root package name */
    public short f72507d;

    /* renamed from: e, reason: collision with root package name */
    public int f72508e;

    /* renamed from: f, reason: collision with root package name */
    public int f72509f;

    /* renamed from: g, reason: collision with root package name */
    public short f72510g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f72511h;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(DataInputStream dataInputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataInputStream);
            return;
        }
        this.f72504a = a.d(dataInputStream.readShort());
        this.f72505b = a.d(dataInputStream.readShort());
        this.f72506c = a.d(dataInputStream.readShort());
        this.f72507d = a.d(dataInputStream.readShort());
        this.f72508e = a.a(dataInputStream.readInt());
        this.f72509f = a.a(dataInputStream.readInt());
        int d16 = a.d(dataInputStream.readShort());
        this.f72510g = d16;
        byte[] bArr = new byte[d16];
        this.f72511h = bArr;
        dataInputStream.read(bArr, 0, d16);
    }
}
