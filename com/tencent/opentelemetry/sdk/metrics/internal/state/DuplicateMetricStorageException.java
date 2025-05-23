package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;

/* compiled from: P */
/* loaded from: classes22.dex */
class DuplicateMetricStorageException extends IllegalArgumentException {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 1547329629200005982L;
    private final MetricDescriptor conflict;
    private final MetricDescriptor existing;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DuplicateMetricStorageException(MetricDescriptor metricDescriptor, MetricDescriptor metricDescriptor2, String str) {
        super(str + " Found previous metric: " + metricDescriptor + ", cannot register metric: " + metricDescriptor2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, metricDescriptor, metricDescriptor2, str);
        } else {
            this.existing = metricDescriptor;
            this.conflict = metricDescriptor2;
        }
    }

    public MetricDescriptor getConflict() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MetricDescriptor) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.conflict;
    }

    public MetricDescriptor getExisting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MetricDescriptor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.existing;
    }
}
