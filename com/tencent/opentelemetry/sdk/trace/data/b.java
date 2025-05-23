package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static LinkData a(SpanContext spanContext) {
        IPatchRedirector iPatchRedirector = LinkData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LinkData) iPatchRedirector.redirect((short) 1, (Object) spanContext);
        }
        return ImmutableLinkData.create(spanContext);
    }

    public static LinkData b(SpanContext spanContext, Attributes attributes) {
        IPatchRedirector iPatchRedirector = LinkData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LinkData) iPatchRedirector.redirect((short) 2, (Object) spanContext, (Object) attributes);
        }
        return ImmutableLinkData.create(spanContext, attributes);
    }

    public static LinkData c(SpanContext spanContext, Attributes attributes, int i3) {
        IPatchRedirector iPatchRedirector = LinkData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LinkData) iPatchRedirector.redirect((short) 3, (Object) spanContext, (Object) attributes, i3);
        }
        return ImmutableLinkData.create(spanContext, attributes, i3);
    }
}
