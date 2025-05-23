package com.tencent.opentelemetry.sdk.metrics.internal.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static SourceInfo a() {
        IPatchRedirector iPatchRedirector = SourceInfo.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SourceInfo) iPatchRedirector.redirect((short) 2);
        }
        return new StackTraceSourceInfo(Thread.currentThread().getStackTrace());
    }

    public static SourceInfo b() {
        IPatchRedirector iPatchRedirector = SourceInfo.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SourceInfo) iPatchRedirector.redirect((short) 1);
        }
        return NoSourceInfo.INSTANCE;
    }
}
