package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class j {
    public static boolean a(MetricStorage metricStorage) {
        IPatchRedirector iPatchRedirector = MetricStorage.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) metricStorage)).booleanValue();
        }
        if (metricStorage == EmptyMetricStorage.INSTANCE) {
            return true;
        }
        return false;
    }
}
