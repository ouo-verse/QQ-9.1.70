package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static ExemplarFilter a() {
        IPatchRedirector iPatchRedirector = ExemplarFilter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ExemplarFilter) iPatchRedirector.redirect((short) 2);
        }
        return AlwaysSampleFilter.INSTANCE;
    }

    public static ExemplarFilter b() {
        IPatchRedirector iPatchRedirector = ExemplarFilter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ExemplarFilter) iPatchRedirector.redirect((short) 3);
        }
        return NeverSampleFilter.INSTANCE;
    }

    public static ExemplarFilter c() {
        IPatchRedirector iPatchRedirector = ExemplarFilter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ExemplarFilter) iPatchRedirector.redirect((short) 1);
        }
        return WithTraceExemplarFilter.INSTANCE;
    }
}
