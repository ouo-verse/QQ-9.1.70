package com.tencent.opentelemetry.sdk.trace.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.f;
import com.tencent.opentelemetry.api.trace.SpanContext;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableLinkData implements LinkData {
    static IPatchRedirector $redirector_;
    private static final Attributes DEFAULT_ATTRIBUTE_COLLECTION;
    private static final int DEFAULT_ATTRIBUTE_COUNT = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEFAULT_ATTRIBUTE_COLLECTION = f.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableLinkData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkData create(SpanContext spanContext) {
        return new AutoValue_ImmutableLinkData(spanContext, DEFAULT_ATTRIBUTE_COLLECTION, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkData create(SpanContext spanContext, Attributes attributes) {
        return new AutoValue_ImmutableLinkData(spanContext, attributes, attributes.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkData create(SpanContext spanContext, Attributes attributes, int i3) {
        return new AutoValue_ImmutableLinkData(spanContext, attributes, i3);
    }
}
