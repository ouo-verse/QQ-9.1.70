package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface MetricStorage {
    public static final IPatchRedirector $redirector_ = null;

    MetricData collectAndReset(CollectionInfo collectionInfo, Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j3, long j16, boolean z16);

    MetricDescriptor getMetricDescriptor();

    boolean isEmpty();
}
