package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.internal.AttributeUtil;
import com.tencent.opentelemetry.sdk.logs.data.LogDataBuilder;
import com.tencent.opentelemetry.sdk.logs.data.Severity;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
final class SdkLogBuilder implements LogBuilder {
    static IPatchRedirector $redirector_;
    private final LogDataBuilder logDataBuilder;
    private final LogEmitterSharedState logEmitterSharedState;
    private final LogLimits logLimits;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLogBuilder(LogEmitterSharedState logEmitterSharedState, LogDataBuilder logDataBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) logEmitterSharedState, (Object) logDataBuilder);
            return;
        }
        this.logEmitterSharedState = logEmitterSharedState;
        this.logDataBuilder = logDataBuilder;
        this.logLimits = logEmitterSharedState.getLogLimits();
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public void emit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (this.logEmitterSharedState.hasBeenShutdown()) {
                return;
            }
            this.logEmitterSharedState.getLogProcessor().emit(this.logDataBuilder.build());
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public LogBuilder setAttributes(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) attributes);
        }
        this.logDataBuilder.setAttributes(AttributeUtil.applyAttributesLimit(attributes, this.logLimits.getMaxNumberOfAttributes(), this.logLimits.getMaxAttributeValueLength()));
        return this;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public LogBuilder setBody(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.logDataBuilder.setBody(str);
        return this;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public LogBuilder setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        this.logDataBuilder.setContext(context);
        return this;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public LogBuilder setEpoch(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        this.logDataBuilder.setEpoch(j3, timeUnit);
        return this;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public LogBuilder setSeverity(Severity severity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) severity);
        }
        this.logDataBuilder.setSeverity(severity);
        return this;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public LogBuilder setSeverityText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        this.logDataBuilder.setSeverityText(str);
        return this;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogBuilder
    public LogBuilder setEpoch(Instant instant) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) instant);
        }
        this.logDataBuilder.setEpoch(instant);
        return this;
    }
}
