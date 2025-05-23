package com.tencent.gcloud.plugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GCloudAppLifecycle extends com.gcore.gcloud.plugin.GCloudAppLifecycle {
    static IPatchRedirector $redirector_;

    public GCloudAppLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
