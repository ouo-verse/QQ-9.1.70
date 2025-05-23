package com.tencent.opentelemetry.sdk.extension;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class HostResource {
    static IPatchRedirector $redirector_;
    private static final Resource INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = buildResource();
        }
    }

    HostResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static Resource buildResource() {
        String str;
        AttributesBuilder a16 = f.a();
        try {
            a16.put((AttributeKey<AttributeKey<String>>) ResourceAttributes.HOST_NAME, (AttributeKey<String>) InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException unused) {
        }
        try {
            str = System.getProperty("os.arch");
        } catch (SecurityException unused2) {
            str = null;
        }
        if (str != null) {
            a16.put((AttributeKey<AttributeKey<String>>) ResourceAttributes.HOST_ARCH, (AttributeKey<String>) str);
        }
        return Resource.create(a16.build(), "https://opentelemetry.io/schemas/1.4.0");
    }

    public static Resource get() {
        return INSTANCE;
    }
}
