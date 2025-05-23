package com.tencent.opentelemetry.sdk.logs.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue.CopyAnnotations
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class LogDataImpl implements LogData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogDataImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogDataImpl create(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j3, SpanContext spanContext, Severity severity, @Nullable String str, Body body, Attributes attributes) {
        return new AutoValue_LogDataImpl(resource, instrumentationScopeInfo, j3, spanContext, severity, str, body, attributes);
    }
}
