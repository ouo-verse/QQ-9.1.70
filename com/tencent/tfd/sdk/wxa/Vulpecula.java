package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tfd.sdk.wxa.Ginkgo;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Vulpecula {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static volatile Ginkgo f375744a;

    public Vulpecula() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Ginkgo a() {
        try {
            return new Ginkgo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Ginkgo.Cif a(String str) {
        Ginkgo.Cif cif;
        Ginkgo.Cfor cfor = new Ginkgo.Cfor(str, str, 5000L);
        try {
            if (f375744a == null) {
                synchronized (Vulpecula.class) {
                    if (f375744a == null) {
                        f375744a = a();
                    }
                }
            }
            cif = f375744a.a(cfor);
        } catch (Exception e16) {
            if (((e16 instanceof IOException) || (e16 instanceof InterruptedException)) && f375744a != null) {
                synchronized (Vulpecula.class) {
                    if (f375744a != null) {
                        Ginkgo ginkgo = f375744a;
                        ginkgo.getClass();
                        try {
                            ginkgo.a();
                        } catch (Throwable unused) {
                        }
                        f375744a = null;
                    }
                }
            }
            cif = null;
        }
        return cif == null ? new Ginkgo.Cif("", "e") : cif;
    }
}
