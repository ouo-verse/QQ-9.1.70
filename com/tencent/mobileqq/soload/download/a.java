package com.tencent.mobileqq.soload.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soload.download.b
    public boolean a(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar)).booleanValue();
        }
        if (gVar.f313023u && DownloaderFactory.E(gVar.f313004c)) {
            gVar.f313006d = -101;
            gVar.y(-1);
            gVar.n();
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.soload.download.b
    public int b(g gVar, AppRuntime appRuntime, m03.a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, gVar, appRuntime, aVar)).intValue();
        }
        int o16 = DownloaderFactory.o(gVar, appRuntime);
        if (aVar != null) {
            if (o16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.onDownloadFinish(z16);
        }
        return o16;
    }
}
