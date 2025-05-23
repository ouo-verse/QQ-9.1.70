package com.tencent.opentelemetry.sdk.ntp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import d3.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AndroidSyncResponseCache {
    static IPatchRedirector $redirector_;
    public static c syncResponseCache;

    public AndroidSyncResponseCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void registerSyncResponseCache(c cVar) {
    }
}
