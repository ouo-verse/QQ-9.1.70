package com.tencent.wcdb.extension.fts;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import ww4.a;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MMFtsTokenizer implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final a f384433a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f384433a = new MMFtsTokenizer();
        }
    }

    MMFtsTokenizer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native void nativeInitialize(long j3, long j16);

    @Override // ww4.a
    public void a(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            nativeInitialize(j3, j16);
        }
    }
}
