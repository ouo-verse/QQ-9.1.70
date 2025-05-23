package com.tencent.mobileqq.soload.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IWadlSoDownloader;
import com.tencent.mobileqq.vip.g;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements b {
    static IPatchRedirector $redirector_;

    public f() {
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
        return true;
    }

    @Override // com.tencent.mobileqq.soload.download.b
    public int b(g gVar, AppRuntime appRuntime, m03.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, gVar, appRuntime, aVar)).intValue();
        }
        return ((IWadlSoDownloader) QRoute.api(IWadlSoDownloader.class)).startDownload(gVar, aVar);
    }
}
