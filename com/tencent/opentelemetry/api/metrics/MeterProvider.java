package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes22.dex */
public interface MeterProvider {
    public static final IPatchRedirector $redirector_ = null;

    Meter get(String str);

    Meter get(String str, String str2, String str3);

    MeterBuilder meterBuilder(String str);
}
