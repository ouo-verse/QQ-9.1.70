package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ExemplarReservoir {
    public static final IPatchRedirector $redirector_ = null;

    List<ExemplarData> collectAndReset(Attributes attributes);

    void offerMeasurement(double d16, Attributes attributes, Context context);

    void offerMeasurement(long j3, Attributes attributes, Context context);
}
