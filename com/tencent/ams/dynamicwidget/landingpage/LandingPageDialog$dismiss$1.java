package com.tencent.ams.dynamicwidget.landingpage;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
final class LandingPageDialog$dismiss$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LandingPageDialog this$0;

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            LandingPageDialog.j(null);
            com.tencent.ams.dynamicwidget.utils.b.f70218a.c("LandingPageDialog", "dismiss removeFromDecorView");
            throw null;
        }
    }
}
