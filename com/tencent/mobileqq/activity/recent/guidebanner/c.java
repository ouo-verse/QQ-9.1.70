package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_8410;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<AppInterface> f185599d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f185599d = new WeakReference<>(appInterface);
        }
    }

    private void a(oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410) {
        int i3;
        if (oidb_0x59f_guidelines_8410.uint32_banner_status.has()) {
            i3 = oidb_0x59f_guidelines_8410.uint32_banner_status.get();
        } else {
            i3 = -1;
        }
        QLog.d("InnerNewerGuideBannerObserver", 1, "onGetNewerGuideBanner status: " + i3);
        AppInterface appInterface = this.f185599d.get();
        if (appInterface != null) {
            b newerGuideManager = ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).getNewerGuideManager(appInterface);
            newerGuideManager.f(oidb_0x59f_guidelines_8410);
            appInterface.removeObserver(this);
            newerGuideManager.f185596e = null;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else if (i3 == 0 && z16 && (obj instanceof oidb_0x59f$Guidelines_8410)) {
            a((oidb_0x59f$Guidelines_8410) obj);
        }
    }
}
