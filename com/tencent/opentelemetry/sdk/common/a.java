package com.tencent.opentelemetry.sdk.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.internal.SystemClock;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static Clock a() {
        IPatchRedirector iPatchRedirector = Clock.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Clock) iPatchRedirector.redirect((short) 1);
        }
        return SystemClock.getInstance();
    }
}
