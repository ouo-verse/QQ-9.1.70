package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.ImplicitContextKeyed;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface Span extends ImplicitContextKeyed {
    public static final IPatchRedirector $redirector_ = null;

    Span addEvent(String str);

    Span addEvent(String str, long j3, TimeUnit timeUnit);

    Span addEvent(String str, Attributes attributes);

    Span addEvent(String str, Attributes attributes, long j3, TimeUnit timeUnit);

    Span addEvent(String str, Attributes attributes, Instant instant);

    Span addEvent(String str, Instant instant);

    void end();

    void end(long j3, TimeUnit timeUnit);

    void end(Instant instant);

    SpanContext getSpanContext();

    boolean isRecording();

    Span recordException(Throwable th5);

    Span recordException(Throwable th5, Attributes attributes);

    Span setAllAttributes(Attributes attributes);

    Span setAttribute(AttributeKey<Long> attributeKey, int i3);

    <T> Span setAttribute(AttributeKey<T> attributeKey, T t16);

    Span setAttribute(String str, double d16);

    Span setAttribute(String str, long j3);

    Span setAttribute(String str, String str2);

    Span setAttribute(String str, boolean z16);

    Span setStatus(StatusCode statusCode);

    Span setStatus(StatusCode statusCode, String str);

    @Override // com.tencent.opentelemetry.context.ImplicitContextKeyed
    Context storeInContext(Context context);

    Span updateName(String str);
}
