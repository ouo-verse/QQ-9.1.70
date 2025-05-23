package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static BaggageBuilder a(BaggageBuilder baggageBuilder, String str, String str2) {
        IPatchRedirector iPatchRedirector = BaggageBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (BaggageBuilder) iPatchRedirector.redirect((short) 1, (Object) baggageBuilder, (Object) str, (Object) str2);
        }
        return baggageBuilder.put(str, str2, c.b());
    }
}
