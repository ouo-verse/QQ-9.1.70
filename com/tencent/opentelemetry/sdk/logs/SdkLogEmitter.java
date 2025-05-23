package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.logs.data.LogDataBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkLogEmitter implements LogEmitter {
    static IPatchRedirector $redirector_;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final LogEmitterSharedState logEmitterSharedState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLogEmitter(LogEmitterSharedState logEmitterSharedState, InstrumentationScopeInfo instrumentationScopeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) logEmitterSharedState, (Object) instrumentationScopeInfo);
        } else {
            this.logEmitterSharedState = logEmitterSharedState;
            this.instrumentationScopeInfo = instrumentationScopeInfo;
        }
    }

    InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogEmitter
    public LogBuilder logBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogBuilder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new SdkLogBuilder(this.logEmitterSharedState, LogDataBuilder.create(this.logEmitterSharedState.getResource(), this.instrumentationScopeInfo, this.logEmitterSharedState.getClock()));
    }
}
