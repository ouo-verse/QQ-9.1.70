package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface LinkData {
    public static final IPatchRedirector $redirector_ = null;

    Attributes getAttributes();

    SpanContext getSpanContext();

    int getTotalAttributeCount();
}
