package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class g {
    public static void a(ObservableLongUpDownCounter observableLongUpDownCounter) {
        IPatchRedirector iPatchRedirector = ObservableLongUpDownCounter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) observableLongUpDownCounter);
        }
    }
}
