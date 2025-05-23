package com.tencent.qqnt.http.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes24.dex */
public final /* synthetic */ class d {
    public static void a(e eVar, b bVar) {
        IPatchRedirector iPatchRedirector = e.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) eVar, (Object) bVar);
        }
    }

    public static void b(e eVar, b bVar) {
        IPatchRedirector iPatchRedirector = e.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) eVar, (Object) bVar);
        }
    }

    public static void c(e eVar, b bVar) {
        IPatchRedirector iPatchRedirector = e.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) eVar, (Object) bVar);
        }
    }

    public static void d(e eVar, b bVar, f fVar) {
        IPatchRedirector iPatchRedirector = e.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) eVar, (Object) bVar, (Object) fVar);
        }
    }

    public static void e(e eVar, URL url) {
        IPatchRedirector iPatchRedirector = e.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) eVar, (Object) url);
        }
    }
}
