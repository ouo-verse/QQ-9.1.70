package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.sdk.metrics.data.LongExemplarData;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableLongExemplarData implements LongExemplarData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableLongExemplarData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static LongExemplarData create(Attributes attributes, long j3, SpanContext spanContext, long j16) {
        return new AutoValue_ImmutableLongExemplarData(attributes, j3, spanContext, j16);
    }
}
