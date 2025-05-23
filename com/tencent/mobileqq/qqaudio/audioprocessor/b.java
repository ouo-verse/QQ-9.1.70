package com.tencent.mobileqq.qqaudio.audioprocessor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<c> f262206d;

    /* renamed from: e, reason: collision with root package name */
    private d f262207e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f262206d = new ArrayList<>();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.c
    public c.a a(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c.a) iPatchRedirector.redirect((short) 7, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        c.a aVar = new c.a(bArr, i3, i16);
        Iterator<c> it = this.f262206d.iterator();
        while (it.hasNext()) {
            c next = it.next();
            d dVar = this.f262207e;
            if (dVar != null) {
                dVar.b(next, aVar);
            }
            aVar = next.a(aVar.f262210c, aVar.f262209b, aVar.f262208a);
            if (aVar == null || aVar.f262210c == null || aVar.f262208a == 0) {
                break;
            }
            d dVar2 = this.f262207e;
            if (dVar2 != null) {
                dVar2.a(next, aVar);
            }
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void b(int i3, int i16, int i17) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Iterator<c> it = this.f262206d.iterator();
        while (it.hasNext()) {
            it.next().b(i3, i16, i17);
        }
    }

    public void c(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f262206d.add(cVar);
        }
    }

    public void d(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else {
            this.f262207e = dVar;
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void release() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<c> it = this.f262206d.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }
}
