package com.tencent.opentelemetry.sdk.metrics.internal.descriptor;

import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.InstrumentValueType;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregationUtil;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.a;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class MetricDescriptor {
    static IPatchRedirector $redirector_;
    private final AtomicReference<SourceInfo> viewSourceInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MetricDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewSourceInfo = new AtomicReference<>();
        }
    }

    public static MetricDescriptor create(String str, String str2, String str3) {
        return create(View.builder().build(), a.a(), InstrumentDescriptor.create(str, str2, str3, InstrumentType.OBSERVABLE_GAUGE, InstrumentValueType.DOUBLE));
    }

    public String getAggregationName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return AggregationUtil.aggregationName(getView().getAggregation());
    }

    public abstract String getDescription();

    public abstract String getName();

    public abstract InstrumentDescriptor getSourceInstrument();

    public abstract View getView();

    public final SourceInfo getViewSourceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SourceInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SourceInfo sourceInfo = this.viewSourceInfo.get();
        if (sourceInfo == null) {
            return a.b();
        }
        return sourceInfo;
    }

    @Memoized
    public abstract int hashCode();

    public boolean isCompatibleWith(MetricDescriptor metricDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) metricDescriptor)).booleanValue();
        }
        if (getName().equals(metricDescriptor.getName()) && getDescription().equals(metricDescriptor.getDescription()) && getAggregationName().equals(metricDescriptor.getAggregationName()) && getSourceInstrument().getName().equals(metricDescriptor.getSourceInstrument().getName()) && getSourceInstrument().getDescription().equals(metricDescriptor.getSourceInstrument().getDescription()) && getSourceInstrument().getUnit().equals(metricDescriptor.getSourceInstrument().getUnit()) && getSourceInstrument().getType().equals(metricDescriptor.getSourceInstrument().getType()) && getSourceInstrument().getValueType().equals(metricDescriptor.getSourceInstrument().getValueType())) {
            return true;
        }
        return false;
    }

    public static MetricDescriptor create(View view, SourceInfo sourceInfo, InstrumentDescriptor instrumentDescriptor) {
        AutoValue_MetricDescriptor autoValue_MetricDescriptor = new AutoValue_MetricDescriptor(view.getName() == null ? instrumentDescriptor.getName() : view.getName(), view.getDescription() == null ? instrumentDescriptor.getDescription() : view.getDescription(), view, instrumentDescriptor);
        ((MetricDescriptor) autoValue_MetricDescriptor).viewSourceInfo.set(sourceInfo);
        return autoValue_MetricDescriptor;
    }
}
