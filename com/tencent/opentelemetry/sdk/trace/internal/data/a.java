package com.tencent.opentelemetry.sdk.trace.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static ExceptionEventData a(long j3, Throwable th5, Attributes attributes) {
        IPatchRedirector iPatchRedirector = ExceptionEventData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ExceptionEventData) iPatchRedirector.redirect((short) 1, Long.valueOf(j3), th5, attributes);
        }
        return ImmutableExceptionEventData.create(j3, th5, attributes);
    }
}
