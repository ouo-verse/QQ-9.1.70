package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface SpanContext {
    public static final IPatchRedirector $redirector_ = null;

    String getSpanId();

    byte[] getSpanIdBytes();

    TraceFlags getTraceFlags();

    String getTraceId();

    byte[] getTraceIdBytes();

    TraceState getTraceState();

    boolean isRemote();

    boolean isSampled();

    boolean isValid();
}
