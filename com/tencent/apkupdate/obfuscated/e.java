package com.tencent.apkupdate.obfuscated;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.DataOutputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f72513a;

    /* renamed from: b, reason: collision with root package name */
    public short f72514b;

    /* renamed from: c, reason: collision with root package name */
    public short f72515c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f72516d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f72517e;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(b bVar, DataOutputStream dataOutputStream) {
        bVar.f72498q = dataOutputStream.size();
        dataOutputStream.writeInt(1347093252);
        dataOutputStream.writeShort(a.d(bVar.f72483b));
        dataOutputStream.writeShort(a.d(bVar.f72484c));
        dataOutputStream.writeShort(a.d(bVar.f72485d));
        dataOutputStream.writeShort(a.d(bVar.f72486e));
        dataOutputStream.writeShort(a.d(bVar.f72487f));
        if ((bVar.f72484c & 8) == 8) {
            dataOutputStream.writeInt(a.a(0));
            dataOutputStream.writeInt(a.a(0));
            dataOutputStream.writeInt(a.a(0));
        } else {
            dataOutputStream.writeInt(a.a(bVar.f72488g));
            dataOutputStream.writeInt(a.a(bVar.f72489h));
            dataOutputStream.writeInt(a.a(bVar.f72490i));
        }
        dataOutputStream.writeShort(a.d(bVar.f72491j));
        dataOutputStream.writeShort(a.d(bVar.f72492k));
        if (bVar.f72491j > 0) {
            dataOutputStream.write(bVar.f72500s);
        }
        if (bVar.f72492k > 0) {
            dataOutputStream.write(bVar.f72501t);
        }
    }
}
