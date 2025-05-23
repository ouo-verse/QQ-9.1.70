package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class d {
    public static SpanBuilder a(final SpanBuilder spanBuilder, Attributes attributes) {
        IPatchRedirector iPatchRedirector = SpanBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 1, (Object) spanBuilder, (Object) attributes);
        }
        if (attributes != null && !attributes.isEmpty()) {
            attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.api.trace.c
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    d.c(SpanBuilder.this, (AttributeKey) obj, obj2);
                }
            });
        }
        return spanBuilder;
    }

    public static SpanBuilder b(SpanBuilder spanBuilder, Instant instant) {
        long epochSecond;
        int nano;
        IPatchRedirector iPatchRedirector = SpanBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanBuilder) iPatchRedirector.redirect((short) 2, (Object) spanBuilder, (Object) instant);
        }
        if (instant == null) {
            return spanBuilder;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        epochSecond = instant.getEpochSecond();
        long nanos = timeUnit.toNanos(epochSecond);
        nano = instant.getNano();
        return spanBuilder.setStartTimestamp(nanos + nano, TimeUnit.NANOSECONDS);
    }

    public static /* synthetic */ void c(SpanBuilder spanBuilder, AttributeKey attributeKey, Object obj) {
        IPatchRedirector iPatchRedirector = SpanBuilder.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) spanBuilder, (Object) attributeKey, obj);
        } else {
            spanBuilder.setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
        }
    }
}
