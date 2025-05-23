package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.Data;
import com.tencent.opentelemetry.sdk.metrics.data.MetricDataType;
import com.tencent.opentelemetry.sdk.resources.Resource;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableMetricData extends ImmutableMetricData {
    static IPatchRedirector $redirector_;
    private final Data<?> data;
    private final String description;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final String name;
    private final Resource resource;
    private final MetricDataType type;
    private final String unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, String str, String str2, String str3, MetricDataType metricDataType, Data<?> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resource, instrumentationScopeInfo, str, str2, str3, metricDataType, data);
            return;
        }
        if (resource != null) {
            this.resource = resource;
            if (instrumentationScopeInfo != null) {
                this.instrumentationScopeInfo = instrumentationScopeInfo;
                if (str != null) {
                    this.name = str;
                    if (str2 != null) {
                        this.description = str2;
                        if (str3 != null) {
                            this.unit = str3;
                            if (metricDataType != null) {
                                this.type = metricDataType;
                                if (data != null) {
                                    this.data = data;
                                    return;
                                }
                                throw new NullPointerException("Null data");
                            }
                            throw new NullPointerException("Null type");
                        }
                        throw new NullPointerException("Null unit");
                    }
                    throw new NullPointerException("Null description");
                }
                throw new NullPointerException("Null name");
            }
            throw new NullPointerException("Null instrumentationScopeInfo");
        }
        throw new NullPointerException("Null resource");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableMetricData)) {
            return false;
        }
        ImmutableMetricData immutableMetricData = (ImmutableMetricData) obj;
        if (this.resource.equals(immutableMetricData.getResource()) && this.instrumentationScopeInfo.equals(immutableMetricData.getInstrumentationScopeInfo()) && this.name.equals(immutableMetricData.getName()) && this.description.equals(immutableMetricData.getDescription()) && this.unit.equals(immutableMetricData.getUnit()) && this.type.equals(immutableMetricData.getType()) && this.data.equals(immutableMetricData.getData())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public Data<?> getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Data) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.data;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.description;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InstrumentationScopeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.instrumentationScopeInfo;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.name;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public Resource getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Resource) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.resource;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public MetricDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MetricDataType) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.type;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.MetricData
    public String getUnit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.unit;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return ((((((((((((this.resource.hashCode() ^ 1000003) * 1000003) ^ this.instrumentationScopeInfo.hashCode()) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.unit.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.data.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "ImmutableMetricData{resource=" + this.resource + ", instrumentationScopeInfo=" + this.instrumentationScopeInfo + ", name=" + this.name + ", description=" + this.description + ", unit=" + this.unit + ", type=" + this.type + ", data=" + this.data + "}";
    }
}
