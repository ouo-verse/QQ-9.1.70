package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IdGenerator {
    public static final IPatchRedirector $redirector_ = null;

    String generateSpanId();

    String generateTraceId();
}
