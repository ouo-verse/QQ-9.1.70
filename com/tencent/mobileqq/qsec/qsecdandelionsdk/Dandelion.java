package com.tencent.mobileqq.qsec.qsecdandelionsdk;

import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class Dandelion {
    static IPatchRedirector $redirector_ = null;
    private static boolean isInit = false;
    private static final String sVersion = "0.0.4";

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final Dandelion f276821a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13397);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f276821a = new Dandelion(null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            isInit = false;
        }
    }

    /* synthetic */ Dandelion(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
    }

    private native byte[] energy(Object obj, Object obj2);

    public static Dandelion getInstance() {
        return b.f276821a;
    }

    public byte[] fly(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bArr);
        }
        byte[] bytes = "".getBytes();
        if (!isInit && e.b().i()) {
            init();
        }
        if (isInit) {
            try {
                return energy(str, bArr);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return bytes;
            }
        }
        return bytes;
    }

    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return sVersion;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            isInit = true;
        }
    }

    Dandelion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
