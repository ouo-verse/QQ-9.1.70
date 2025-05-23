package com.tencent.opentelemetry.context.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes22.dex */
public interface ContextPropagators {
    public static final IPatchRedirector $redirector_ = null;

    TextMapPropagator getTextMapPropagator();
}
