package com.tencent.opentelemetry.sdk.logs.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class AutoValue_LogDataImpl extends LogDataImpl {
    static IPatchRedirector $redirector_;
    private final Attributes attributes;
    private final Body body;
    private final long epochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final Resource resource;
    private final Severity severity;
    private final String severityText;
    private final SpanContext spanContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LogDataImpl(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j3, SpanContext spanContext, Severity severity, @Nullable String str, Body body, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resource, instrumentationScopeInfo, Long.valueOf(j3), spanContext, severity, str, body, attributes);
            return;
        }
        if (resource != null) {
            this.resource = resource;
            if (instrumentationScopeInfo != null) {
                this.instrumentationScopeInfo = instrumentationScopeInfo;
                this.epochNanos = j3;
                if (spanContext != null) {
                    this.spanContext = spanContext;
                    if (severity != null) {
                        this.severity = severity;
                        this.severityText = str;
                        if (body != null) {
                            this.body = body;
                            if (attributes != null) {
                                this.attributes = attributes;
                                return;
                            }
                            throw new NullPointerException("Null attributes");
                        }
                        throw new NullPointerException("Null body");
                    }
                    throw new NullPointerException("Null severity");
                }
                throw new NullPointerException("Null spanContext");
            }
            throw new NullPointerException("Null instrumentationScopeInfo");
        }
        throw new NullPointerException("Null resource");
    }

    public boolean equals(Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogDataImpl)) {
            return false;
        }
        LogDataImpl logDataImpl = (LogDataImpl) obj;
        if (this.resource.equals(logDataImpl.getResource()) && this.instrumentationScopeInfo.equals(logDataImpl.getInstrumentationScopeInfo()) && this.epochNanos == logDataImpl.getEpochNanos() && this.spanContext.equals(logDataImpl.getSpanContext()) && this.severity.equals(logDataImpl.getSeverity()) && ((str = this.severityText) != null ? str.equals(logDataImpl.getSeverityText()) : logDataImpl.getSeverityText() == null) && this.body.equals(logDataImpl.getBody()) && this.attributes.equals(logDataImpl.getAttributes())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    public Attributes getAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Attributes) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.attributes;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    public Body getBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Body) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.body;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    public long getEpochNanos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.epochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InstrumentationScopeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.instrumentationScopeInfo;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    public Resource getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Resource) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.resource;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    public Severity getSeverity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Severity) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.severity;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    @Nullable
    public String getSeverityText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.severityText;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.data.LogData
    public SpanContext getSpanContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SpanContext) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.spanContext;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int hashCode2 = (((this.resource.hashCode() ^ 1000003) * 1000003) ^ this.instrumentationScopeInfo.hashCode()) * 1000003;
        long j3 = this.epochNanos;
        int hashCode3 = (((((hashCode2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.spanContext.hashCode()) * 1000003) ^ this.severity.hashCode()) * 1000003;
        String str = this.severityText;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((hashCode3 ^ hashCode) * 1000003) ^ this.body.hashCode()) * 1000003) ^ this.attributes.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "LogDataImpl{resource=" + this.resource + ", instrumentationScopeInfo=" + this.instrumentationScopeInfo + ", epochNanos=" + this.epochNanos + ", spanContext=" + this.spanContext + ", severity=" + this.severity + ", severityText=" + this.severityText + ", body=" + this.body + ", attributes=" + this.attributes + "}";
    }
}
