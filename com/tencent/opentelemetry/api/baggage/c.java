package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class c {
    public static BaggageEntryMetadata a(String str) {
        IPatchRedirector iPatchRedirector = BaggageEntryMetadata.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaggageEntryMetadata) iPatchRedirector.redirect((short) 2, (Object) str);
        }
        return ImmutableEntryMetadata.create(str);
    }

    public static BaggageEntryMetadata b() {
        IPatchRedirector iPatchRedirector = BaggageEntryMetadata.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (BaggageEntryMetadata) iPatchRedirector.redirect((short) 1);
        }
        return ImmutableEntryMetadata.EMPTY;
    }
}
