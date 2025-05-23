package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.EmptyMetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class EmptyMetricStorage implements SynchronousMetricStorage {
    static IPatchRedirector $redirector_;
    static final EmptyMetricStorage INSTANCE;
    private final MetricDescriptor descriptor;
    private final BoundStorageHandle emptyHandle;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new EmptyMetricStorage();
        }
    }

    EmptyMetricStorage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.descriptor = MetricDescriptor.create("", "", "");
            this.emptyHandle = new BoundStorageHandle() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.EmptyMetricStorage.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmptyMetricStorage.this);
                    }
                }

                @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
                public void recordDouble(double d16, Attributes attributes, Context context) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, Double.valueOf(d16), attributes, context);
                    }
                }

                @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
                public void recordLong(long j3, Attributes attributes, Context context) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
                    }
                }

                @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
                public void release() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this);
                    }
                }
            };
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public BoundStorageHandle bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BoundStorageHandle) iPatchRedirector.redirect((short) 3, (Object) this, (Object) attributes);
        }
        return this.emptyHandle;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricData collectAndReset(CollectionInfo collectionInfo, Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MetricData) iPatchRedirector.redirect((short) 4, this, collectionInfo, resource, instrumentationScopeInfo, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
        }
        return EmptyMetricData.getInstance();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricDescriptor getMetricDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MetricDescriptor) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.descriptor;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public /* synthetic */ boolean isEmpty() {
        return j.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public /* synthetic */ void recordDouble(double d16, Attributes attributes, Context context) {
        t.a(this, d16, attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public /* synthetic */ void recordLong(long j3, Attributes attributes, Context context) {
        t.b(this, j3, attributes, context);
    }
}
