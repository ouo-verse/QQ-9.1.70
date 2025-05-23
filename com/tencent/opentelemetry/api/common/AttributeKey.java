package com.tencent.opentelemetry.api.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface AttributeKey<T> {
    public static final IPatchRedirector $redirector_ = null;

    String getKey();

    AttributeType getType();
}
