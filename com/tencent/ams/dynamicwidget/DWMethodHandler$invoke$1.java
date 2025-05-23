package com.tencent.ams.dynamicwidget;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/ams/dynamicwidget/DWMethodHandler$invoke$1", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class DWMethodHandler$invoke$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ DWMethodHandler this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            DWMethodHandler.b(null, DWMethodHandler.d(null), DWMethodHandler.c(null));
        }
    }
}
