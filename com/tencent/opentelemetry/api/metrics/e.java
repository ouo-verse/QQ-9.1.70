package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class e {
    public static void a(ObservableLongCounter observableLongCounter) {
        IPatchRedirector iPatchRedirector = ObservableLongCounter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) observableLongCounter);
        }
    }
}
