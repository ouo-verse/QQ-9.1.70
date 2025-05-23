package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface EventData {
    public static final IPatchRedirector $redirector_ = null;

    Attributes getAttributes();

    int getDroppedAttributesCount();

    long getEpochNanos();

    String getName();

    int getTotalAttributeCount();
}
