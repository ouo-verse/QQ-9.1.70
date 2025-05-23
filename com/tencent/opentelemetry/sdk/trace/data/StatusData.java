package com.tencent.opentelemetry.sdk.trace.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.trace.StatusCode;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface StatusData {
    public static final IPatchRedirector $redirector_ = null;

    String getDescription();

    StatusCode getStatusCode();
}
