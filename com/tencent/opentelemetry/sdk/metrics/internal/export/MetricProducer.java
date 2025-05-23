package com.tencent.opentelemetry.sdk.metrics.internal.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.export.CollectionRegistration;
import java.util.Collection;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes22.dex */
public interface MetricProducer extends CollectionRegistration {
    public static final IPatchRedirector $redirector_ = null;

    Collection<MetricData> collectAllMetrics();
}
