package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IScreenAnimationRedTouchHelper;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.g;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScreenAnimationRedTouchHelperImpl implements IScreenAnimationRedTouchHelper {
    static IPatchRedirector $redirector_;

    public ScreenAnimationRedTouchHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IScreenAnimationRedTouchHelper
    public boolean downloadFile(String str, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) file)).booleanValue();
        }
        g gVar = new g(str, file);
        gVar.U = true;
        gVar.Q = true;
        gVar.f313008f = 2;
        gVar.X = true;
        if (((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.peekAppRuntime()) == 0 && file.exists() && file.length() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IScreenAnimationRedTouchHelper
    public long getLebaListItemResId(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, obj)).longValue();
        }
        if (!(obj instanceof n)) {
            return 0L;
        }
        return ((n) obj).f240504a;
    }
}
