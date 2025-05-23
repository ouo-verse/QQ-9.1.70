package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.Data;
import com.tencent.opentelemetry.sdk.metrics.data.GaugeData;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricDataType;
import com.tencent.opentelemetry.sdk.metrics.data.SumData;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryData;
import com.tencent.opentelemetry.sdk.resources.Resource;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class EmptyMetricData implements MetricData {
    static IPatchRedirector $redirector_;
    private static final EmptyMetricData INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23198);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new EmptyMetricData();
        }
    }

    EmptyMetricData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static MetricData getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public Data<?> getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Data) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        throw new UnsupportedOperationException("EmptyMetricData does not support getData().");
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        throw new UnsupportedOperationException("EmptyMetricData does not support getDescription().");
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ GaugeData getDoubleGaugeData() {
        return com.tencent.opentelemetry.sdk.metrics.data.a.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SumData getDoubleSumData() {
        return com.tencent.opentelemetry.sdk.metrics.data.a.b(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ HistogramData getHistogramData() {
        return com.tencent.opentelemetry.sdk.metrics.data.a.c(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InstrumentationScopeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        throw new UnsupportedOperationException("EmptyMetricData does not support getInstrumentationScopeInfo().");
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ GaugeData getLongGaugeData() {
        return com.tencent.opentelemetry.sdk.metrics.data.a.d(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SumData getLongSumData() {
        return com.tencent.opentelemetry.sdk.metrics.data.a.e(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        throw new UnsupportedOperationException("EmptyMetricData does not support getName().");
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public Resource getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Resource) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        throw new UnsupportedOperationException("EmptyMetricData does not support getResource().");
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public /* synthetic */ SummaryData getSummaryData() {
        return com.tencent.opentelemetry.sdk.metrics.data.a.f(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public MetricDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MetricDataType) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        throw new UnsupportedOperationException("EmptyMetricData does not support getType().");
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public String getUnit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        throw new UnsupportedOperationException("EmptyMetricData does not support getUnit().");
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }
}
