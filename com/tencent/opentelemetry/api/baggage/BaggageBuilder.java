package com.tencent.opentelemetry.api.baggage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface BaggageBuilder {
    public static final IPatchRedirector $redirector_ = null;

    Baggage build();

    BaggageBuilder put(String str, String str2);

    BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata);

    BaggageBuilder remove(String str);
}
