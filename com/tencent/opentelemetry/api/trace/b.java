package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static Span a(Span span, String str) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Span) iPatchRedirector.redirect((short) 12, (Object) span, (Object) str);
        }
        return span.addEvent(str, com.tencent.opentelemetry.api.common.f.b());
    }

    public static Span b(Span span, String str, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Span) iPatchRedirector.redirect((short) 13, span, str, Long.valueOf(j3), timeUnit);
        }
        return span.addEvent(str, com.tencent.opentelemetry.api.common.f.b(), j3, timeUnit);
    }

    public static Span c(Span span, String str, Attributes attributes, Instant instant) {
        long epochSecond;
        int nano;
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Span) iPatchRedirector.redirect((short) 15, span, str, attributes, instant);
        }
        if (instant == null) {
            return span.addEvent(str, attributes);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        epochSecond = instant.getEpochSecond();
        long nanos = timeUnit.toNanos(epochSecond);
        nano = instant.getNano();
        return span.addEvent(str, attributes, nanos + nano, TimeUnit.NANOSECONDS);
    }

    public static Span d(Span span, String str, Instant instant) {
        long epochSecond;
        int nano;
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Span) iPatchRedirector.redirect((short) 14, (Object) span, (Object) str, (Object) instant);
        }
        if (instant == null) {
            return span.addEvent(str);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        epochSecond = instant.getEpochSecond();
        long nanos = timeUnit.toNanos(epochSecond);
        nano = instant.getNano();
        return span.addEvent(str, nanos + nano, TimeUnit.NANOSECONDS);
    }

    public static void e(Span span, Instant instant) {
        long epochSecond;
        int nano;
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) span, (Object) instant);
            return;
        }
        if (instant == null) {
            span.end();
            return;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        epochSecond = instant.getEpochSecond();
        long nanos = timeUnit.toNanos(epochSecond);
        nano = instant.getNano();
        span.end(nanos + nano, TimeUnit.NANOSECONDS);
    }

    public static Span f(Span span, Throwable th5) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Span) iPatchRedirector.redirect((short) 17, (Object) span, (Object) th5);
        }
        return span.recordException(th5, com.tencent.opentelemetry.api.common.f.b());
    }

    public static Span g(final Span span, Attributes attributes) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Span) iPatchRedirector.redirect((short) 11, (Object) span, (Object) attributes);
        }
        if (attributes != null && !attributes.isEmpty()) {
            attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.api.trace.a
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    b.o(Span.this, (AttributeKey) obj, obj2);
                }
            });
        }
        return span;
    }

    public static Span h(Span span, AttributeKey attributeKey, int i3) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Span) iPatchRedirector.redirect((short) 10, (Object) span, (Object) attributeKey, i3);
        }
        return span.setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) Long.valueOf(i3));
    }

    public static Span i(Span span, String str, double d16) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Span) iPatchRedirector.redirect((short) 8, span, str, Double.valueOf(d16));
        }
        return span.setAttribute((AttributeKey<AttributeKey<Double>>) com.tencent.opentelemetry.api.common.e.d(str), (AttributeKey<Double>) Double.valueOf(d16));
    }

    public static Span j(Span span, String str, long j3) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Span) iPatchRedirector.redirect((short) 7, span, str, Long.valueOf(j3));
        }
        return span.setAttribute((AttributeKey<AttributeKey<Long>>) com.tencent.opentelemetry.api.common.e.f(str), (AttributeKey<Long>) Long.valueOf(j3));
    }

    public static Span k(Span span, String str, String str2) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Span) iPatchRedirector.redirect((short) 6, (Object) span, (Object) str, (Object) str2);
        }
        return span.setAttribute((AttributeKey<AttributeKey<String>>) com.tencent.opentelemetry.api.common.e.h(str), (AttributeKey<String>) str2);
    }

    public static Span l(Span span, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Span) iPatchRedirector.redirect((short) 9, span, str, Boolean.valueOf(z16));
        }
        return span.setAttribute((AttributeKey<AttributeKey<Boolean>>) com.tencent.opentelemetry.api.common.e.b(str), (AttributeKey<Boolean>) Boolean.valueOf(z16));
    }

    public static Span m(Span span, StatusCode statusCode) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Span) iPatchRedirector.redirect((short) 16, (Object) span, (Object) statusCode);
        }
        return span.setStatus(statusCode, "");
    }

    public static Context n(Span span, Context context) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Context) iPatchRedirector.redirect((short) 19, (Object) span, (Object) context);
        }
        return context.with(SpanContextKey.KEY, span);
    }

    public static /* synthetic */ void o(Span span, AttributeKey attributeKey, Object obj) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) span, (Object) attributeKey, obj);
        } else {
            span.setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
        }
    }

    public static Span p() {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Span) iPatchRedirector.redirect((short) 1);
        }
        Span span = (Span) com.tencent.opentelemetry.context.e.k().get(SpanContextKey.KEY);
        if (span == null) {
            return s();
        }
        return span;
    }

    public static Span q(Context context) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Span) iPatchRedirector.redirect((short) 2, (Object) context);
        }
        if (context == null) {
            return s();
        }
        Span span = (Span) context.get(SpanContextKey.KEY);
        if (span == null) {
            return s();
        }
        return span;
    }

    @Nullable
    public static Span r(Context context) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Span) iPatchRedirector.redirect((short) 3, (Object) context);
        }
        if (context == null) {
            return null;
        }
        return (Span) context.get(SpanContextKey.KEY);
    }

    public static Span s() {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Span) iPatchRedirector.redirect((short) 4);
        }
        return PropagatedSpan.INVALID;
    }

    public static Span t(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = Span.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Span) iPatchRedirector.redirect((short) 5, (Object) spanContext);
        }
        if (spanContext != null && spanContext.isValid()) {
            return PropagatedSpan.create(spanContext);
        }
        return s();
    }
}
