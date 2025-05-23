package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.l;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Olive {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static volatile l f382967a;

    public Olive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static l a(String str) {
        try {
            return new l(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static l.Cif b(String str) {
        l.Cif cif;
        l.Cfor cfor = new l.Cfor(str, str, 5000L);
        try {
            if (f382967a == null) {
                synchronized (Olive.class) {
                    if (f382967a == null) {
                        f382967a = a("sh");
                    }
                }
            }
            cif = f382967a.a(cfor);
        } catch (Exception e16) {
            if (((e16 instanceof IOException) || (e16 instanceof InterruptedException)) && f382967a != null) {
                synchronized (Olive.class) {
                    if (f382967a != null) {
                        l lVar = f382967a;
                        lVar.getClass();
                        try {
                            lVar.a();
                        } catch (Throwable unused) {
                        }
                        f382967a = null;
                    }
                }
            }
            cif = null;
        }
        if (cif == null) {
            return new l.Cif(cfor.f383392a, 2, "", "e");
        }
        return cif;
    }
}
