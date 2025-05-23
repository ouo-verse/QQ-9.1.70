package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;

/* compiled from: P */
/* loaded from: classes15.dex */
public class p implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    MsfCore f248905a;

    /* renamed from: b, reason: collision with root package name */
    private final t f248906b;

    public p(MsfCore msfCore, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) tVar);
        } else {
            this.f248905a = msfCore;
            this.f248906b = tVar;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.e
    public byte[] a(com.tencent.mobileqq.msf.core.d dVar, String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? bArr : (byte[]) iPatchRedirector.redirect((short) 3, this, dVar, str, str2, bArr);
    }

    @Override // com.tencent.mobileqq.msf.core.net.e
    public void a(MsfSocketInputBuffer msfSocketInputBuffer, int i3) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msfSocketInputBuffer, i3);
            return;
        }
        int bufferlen = msfSocketInputBuffer.getBufferlen();
        byte[] bArr = new byte[bufferlen];
        System.arraycopy(msfSocketInputBuffer.getBuffer(), 0, bArr, 0, bufferlen);
        this.f248906b.a(bArr, i3);
    }

    @Override // com.tencent.mobileqq.msf.core.net.e
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f248906b.h();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
