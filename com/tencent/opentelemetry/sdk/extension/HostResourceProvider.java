package com.tencent.opentelemetry.sdk.extension;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.autoconfigure.ConfigProperties;
import com.tencent.opentelemetry.sdk.autoconfigure.spi.ResourceProvider;
import com.tencent.opentelemetry.sdk.resources.Resource;

/* loaded from: classes22.dex */
public final class HostResourceProvider implements ResourceProvider {
    static IPatchRedirector $redirector_;

    public HostResourceProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.autoconfigure.spi.ResourceProvider
    public Resource createResource(ConfigProperties configProperties) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Resource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) configProperties);
        }
        return HostResource.get();
    }
}
