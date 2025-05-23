package com.tencent.opentelemetry.sdk.trace.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.trace.data.EventData;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ExceptionEventData extends EventData {
    public static final IPatchRedirector $redirector_ = null;

    Attributes getAdditionalAttributes();

    Throwable getException();
}
