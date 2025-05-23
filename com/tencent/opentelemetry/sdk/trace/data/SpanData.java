package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface SpanData {
    public static final IPatchRedirector $redirector_ = null;

    Attributes getAttributes();

    long getEndEpochNanos();

    List<EventData> getEvents();

    InstrumentationLibraryInfo getInstrumentationLibraryInfo();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    SpanKind getKind();

    List<LinkData> getLinks();

    String getName();

    SpanContext getParentSpanContext();

    String getParentSpanId();

    Resource getResource();

    SpanContext getSpanContext();

    String getSpanId();

    long getStartEpochNanos();

    StatusData getStatus();

    int getTotalAttributeCount();

    int getTotalRecordedEvents();

    int getTotalRecordedLinks();

    String getTraceId();

    boolean hasEnded();
}
