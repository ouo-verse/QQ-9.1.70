package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface SpanBuilder {
    public static final IPatchRedirector $redirector_ = null;

    SpanBuilder addLink(SpanContext spanContext);

    SpanBuilder addLink(SpanContext spanContext, Attributes attributes);

    SpanBuilder setAllAttributes(Attributes attributes);

    <T> SpanBuilder setAttribute(AttributeKey<T> attributeKey, T t16);

    SpanBuilder setAttribute(String str, double d16);

    SpanBuilder setAttribute(String str, long j3);

    SpanBuilder setAttribute(String str, String str2);

    SpanBuilder setAttribute(String str, boolean z16);

    SpanBuilder setNoParent();

    SpanBuilder setParent(Context context);

    SpanBuilder setSpanKind(SpanKind spanKind);

    SpanBuilder setStartTimestamp(long j3, TimeUnit timeUnit);

    SpanBuilder setStartTimestamp(Instant instant);

    Span startSpan();

    Span startSpan(ExternalSpanData externalSpanData);
}
