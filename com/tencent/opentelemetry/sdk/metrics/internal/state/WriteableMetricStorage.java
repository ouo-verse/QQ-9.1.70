package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface WriteableMetricStorage {
    public static final IPatchRedirector $redirector_ = null;

    BoundStorageHandle bind(Attributes attributes);

    void recordDouble(double d16, Attributes attributes, Context context);

    void recordLong(long j3, Attributes attributes, Context context);
}
