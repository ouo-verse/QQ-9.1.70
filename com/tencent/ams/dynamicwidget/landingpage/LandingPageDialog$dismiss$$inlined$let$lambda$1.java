package com.tencent.ams.dynamicwidget.landingpage;

import android.view.WindowManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/ams/dynamicwidget/landingpage/LandingPageDialog$dismiss$2$1"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
final class LandingPageDialog$dismiss$$inlined$let$lambda$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ WindowManager f70202d;
    final /* synthetic */ LandingPageDialog this$0;

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f70202d.removeView(LandingPageDialog.i(null));
            com.tencent.ams.dynamicwidget.utils.b.f70218a.c("LandingPageDialog", "dismiss removeFromWindow");
            throw null;
        }
    }
}
