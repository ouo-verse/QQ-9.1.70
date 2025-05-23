package com.tencent.opentelemetry.sdk.logs.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.b;
import com.tencent.opentelemetry.api.trace.e;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LogDataBuilder {
    static IPatchRedirector $redirector_;
    private Attributes attributes;
    private Body body;
    private final Clock clock;
    private long epochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final Resource resource;
    private Severity severity;

    @Nullable
    private String severityText;
    private SpanContext spanContext;

    LogDataBuilder(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resource, instrumentationScopeInfo, clock);
            return;
        }
        this.spanContext = e.g();
        this.severity = Severity.UNDEFINED_SEVERITY_NUMBER;
        this.body = a.a();
        this.attributes = f.b();
        this.resource = resource;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.clock = clock;
    }

    public static LogDataBuilder create(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo) {
        return create(resource, instrumentationScopeInfo, com.tencent.opentelemetry.sdk.common.a.a());
    }

    public LogData build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LogData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.epochNanos == 0) {
            this.epochNanos = this.clock.now();
        }
        return LogDataImpl.create(this.resource, this.instrumentationScopeInfo, this.epochNanos, this.spanContext, this.severity, this.severityText, this.body, this.attributes);
    }

    public LogDataBuilder setAttributes(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) attributes);
        }
        this.attributes = attributes;
        return this;
    }

    public LogDataBuilder setBody(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        this.body = a.b(str);
        return this;
    }

    public LogDataBuilder setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        return setSpanContext(b.q(context).getSpanContext());
    }

    public LogDataBuilder setEpoch(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        this.epochNanos = timeUnit.toNanos(j3);
        return this;
    }

    public LogDataBuilder setSeverity(Severity severity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) severity);
        }
        this.severity = severity;
        return this;
    }

    public LogDataBuilder setSeverityText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.severityText = str;
        return this;
    }

    public LogDataBuilder setSpanContext(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) spanContext);
        }
        if (spanContext == null) {
            spanContext = e.g();
        }
        this.spanContext = spanContext;
        return this;
    }

    public static LogDataBuilder create(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, Clock clock) {
        return new LogDataBuilder(resource, instrumentationScopeInfo, clock);
    }

    public LogDataBuilder setEpoch(Instant instant) {
        long epochSecond;
        int nano;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LogDataBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) instant);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        epochSecond = instant.getEpochSecond();
        long nanos = timeUnit.toNanos(epochSecond);
        nano = instant.getNano();
        this.epochNanos = nanos + nano;
        return this;
    }
}
