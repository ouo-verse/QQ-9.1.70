package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class f {
    public static void a(ObservableLongGauge observableLongGauge) {
        IPatchRedirector iPatchRedirector = ObservableLongGauge.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) observableLongGauge);
        }
    }
}
