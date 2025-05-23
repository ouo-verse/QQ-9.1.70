package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class d {
    public static void a(ObservableDoubleUpDownCounter observableDoubleUpDownCounter) {
        IPatchRedirector iPatchRedirector = ObservableDoubleUpDownCounter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) observableDoubleUpDownCounter);
        }
    }
}
