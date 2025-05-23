package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes22.dex */
public interface TracerProvider {
    public static final IPatchRedirector $redirector_ = null;

    Tracer get(String str);

    Tracer get(String str, String str2);

    TracerBuilder tracerBuilder(String str);
}
