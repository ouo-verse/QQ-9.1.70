package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableDoubleExemplarData implements DoubleExemplarData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableDoubleExemplarData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static DoubleExemplarData create(Attributes attributes, long j3, SpanContext spanContext, double d16) {
        return new AutoValue_ImmutableDoubleExemplarData(attributes, j3, spanContext, d16);
    }
}
