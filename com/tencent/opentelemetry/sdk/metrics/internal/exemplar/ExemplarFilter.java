package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ExemplarFilter {
    public static final IPatchRedirector $redirector_ = null;

    boolean shouldSampleMeasurement(double d16, Attributes attributes, Context context);

    boolean shouldSampleMeasurement(long j3, Attributes attributes, Context context);
}
