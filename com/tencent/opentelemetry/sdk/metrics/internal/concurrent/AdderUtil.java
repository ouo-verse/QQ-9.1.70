package com.tencent.opentelemetry.sdk.metrics.internal.concurrent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AdderUtil {
    static IPatchRedirector $redirector_;

    AdderUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static DoubleAdder createDoubleAdder() {
        return new AtomicLongDoubleAdder();
    }

    public static LongAdder createLongAdder() {
        return new AtomicLongLongAdder();
    }
}
