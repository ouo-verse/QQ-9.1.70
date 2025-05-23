package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static void a(ObservableDoubleCounter observableDoubleCounter) {
        IPatchRedirector iPatchRedirector = ObservableDoubleCounter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) observableDoubleCounter);
        }
    }
}
