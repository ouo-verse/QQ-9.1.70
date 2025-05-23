package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class WithTraceExemplarFilter implements ExemplarFilter {
    static IPatchRedirector $redirector_;
    static final ExemplarFilter INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new WithTraceExemplarFilter();
        }
    }

    WithTraceExemplarFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean hasSampledTrace(Context context) {
        return com.tencent.opentelemetry.api.trace.b.q(context).getSpanContext().isSampled();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public boolean shouldSampleMeasurement(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? hasSampledTrace(context) : ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context)).booleanValue();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter
    public boolean shouldSampleMeasurement(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? hasSampledTrace(context) : ((Boolean) iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes, context)).booleanValue();
    }
}
