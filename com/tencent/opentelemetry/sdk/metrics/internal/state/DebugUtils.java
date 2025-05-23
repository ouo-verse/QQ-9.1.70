package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DebugUtils {
    static IPatchRedirector $redirector_;

    DebugUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String duplicateMetricErrorMessage(MetricDescriptor metricDescriptor, MetricDescriptor metricDescriptor2) {
        StringBuilder sb5 = new StringBuilder("Found duplicate metric definition: ");
        sb5.append(metricDescriptor.getName());
        sb5.append("\n");
        if (!metricDescriptor2.getName().equals(metricDescriptor2.getSourceInstrument().getName())) {
            sb5.append("\tVIEW defined\n");
            sb5.append(metricDescriptor2.getViewSourceInfo().multiLineDebugString());
            sb5.append("\tFROM instrument ");
            sb5.append(metricDescriptor2.getSourceInstrument().getName());
            sb5.append("\n");
            sb5.append(metricDescriptor2.getSourceInstrument().getSourceInfo().multiLineDebugString());
        } else {
            sb5.append(metricDescriptor2.getSourceInstrument().getSourceInfo().multiLineDebugString());
            sb5.append("\n");
        }
        sb5.append("Causes\n");
        if (!metricDescriptor.getName().equals(metricDescriptor2.getName())) {
            sb5.append("- Name [");
            sb5.append(metricDescriptor2.getName());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getName());
            sb5.append("]\n");
        }
        if (!metricDescriptor.getDescription().equals(metricDescriptor2.getDescription())) {
            sb5.append("- Description [");
            sb5.append(metricDescriptor2.getDescription());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getDescription());
            sb5.append("]\n");
        }
        if (!metricDescriptor.getAggregationName().equals(metricDescriptor2.getAggregationName())) {
            sb5.append("- Aggregation [");
            sb5.append(metricDescriptor2.getAggregationName());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getAggregationName());
            sb5.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getName().equals(metricDescriptor2.getSourceInstrument().getName())) {
            sb5.append("- InstrumentName [");
            sb5.append(metricDescriptor2.getSourceInstrument().getName());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getSourceInstrument().getName());
            sb5.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getDescription().equals(metricDescriptor2.getSourceInstrument().getDescription())) {
            sb5.append("- InstrumentDescription [");
            sb5.append(metricDescriptor2.getSourceInstrument().getDescription());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getSourceInstrument().getDescription());
            sb5.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getUnit().equals(metricDescriptor2.getSourceInstrument().getUnit())) {
            sb5.append("- InstrumentUnit [");
            sb5.append(metricDescriptor2.getSourceInstrument().getUnit());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getSourceInstrument().getUnit());
            sb5.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getType().equals(metricDescriptor2.getSourceInstrument().getType())) {
            sb5.append("- InstrumentType [");
            sb5.append(metricDescriptor2.getSourceInstrument().getType());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getSourceInstrument().getType());
            sb5.append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getValueType().equals(metricDescriptor2.getSourceInstrument().getValueType())) {
            sb5.append("- InstrumentValueType [");
            sb5.append(metricDescriptor2.getSourceInstrument().getValueType());
            sb5.append("] does not match [");
            sb5.append(metricDescriptor.getSourceInstrument().getValueType());
            sb5.append("]\n");
        }
        if (metricDescriptor.getName().equals(metricDescriptor.getSourceInstrument().getName())) {
            sb5.append("Original instrument registered with same name but is incompatible.\n");
            sb5.append(metricDescriptor.getSourceInstrument().getSourceInfo().multiLineDebugString());
            sb5.append("\n");
        } else {
            sb5.append("Conflicting view registered.\n");
            sb5.append(metricDescriptor.getViewSourceInfo().multiLineDebugString());
            sb5.append("FROM instrument ");
            sb5.append(metricDescriptor.getSourceInstrument().getName());
            sb5.append("\n");
            sb5.append(metricDescriptor.getSourceInstrument().getSourceInfo().multiLineDebugString());
            sb5.append("\n");
        }
        return sb5.toString();
    }
}
