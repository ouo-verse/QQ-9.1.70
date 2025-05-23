package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class c {
    public static void a(ObservableDoubleGauge observableDoubleGauge) {
        IPatchRedirector iPatchRedirector = ObservableDoubleGauge.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) observableDoubleGauge);
        }
    }
}
