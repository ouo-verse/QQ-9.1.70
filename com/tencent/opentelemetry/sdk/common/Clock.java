package com.tencent.opentelemetry.sdk.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface Clock {
    public static final IPatchRedirector $redirector_ = null;

    long nanoTime();

    long now();
}
