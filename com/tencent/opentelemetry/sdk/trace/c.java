package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class c {
    public static IdGenerator a() {
        IPatchRedirector iPatchRedirector = IdGenerator.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (IdGenerator) iPatchRedirector.redirect((short) 1);
        }
        return RandomIdGenerator.INSTANCE;
    }
}
