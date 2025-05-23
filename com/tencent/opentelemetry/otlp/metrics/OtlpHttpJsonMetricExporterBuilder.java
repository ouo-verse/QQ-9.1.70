package com.tencent.opentelemetry.otlp.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.internal.Utils;
import com.tencent.opentelemetry.otlp.common.OkHttpExporterBuilder;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpJsonMetricExporterBuilder {
    static IPatchRedirector $redirector_ = null;
    private static final Function<InstrumentType, AggregationTemporality> DEFAULT_AGGREGATION_TEMPORALITY_FUNCTION;
    private static final String DEFAULT_ENDPOINT = "https://tpstelemetry.tencent.com/v1/metrics";
    private Function<InstrumentType, AggregationTemporality> aggregationTemporalityFunction;
    private final OkHttpExporterBuilder delegate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            DEFAULT_AGGREGATION_TEMPORALITY_FUNCTION = new Function() { // from class: com.tencent.opentelemetry.otlp.metrics.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return com.tencent.opentelemetry.sdk.metrics.export.a.b((InstrumentType) obj);
                }
            };
        }
    }

    public OtlpHttpJsonMetricExporterBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.aggregationTemporalityFunction = DEFAULT_AGGREGATION_TEMPORALITY_FUNCTION;
            this.delegate = new OkHttpExporterBuilder("metrics", "https://tpstelemetry.tencent.com/v1/metrics");
        }
    }

    public OtlpHttpJsonMetricExporterBuilder addHeader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        this.delegate.addHeader(str, str2);
        return this;
    }

    public OtlpHttpJsonMetricExporter build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (OtlpHttpJsonMetricExporter) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new OtlpHttpJsonMetricExporter(this.delegate.build(), this.aggregationTemporalityFunction);
    }

    public OtlpHttpJsonMetricExporterBuilder setAggregationTemporality(Function<InstrumentType, AggregationTemporality> function) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) function);
        }
        Objects.requireNonNull(function, "aggregationTemporalityFunction");
        this.aggregationTemporalityFunction = function;
        return this;
    }

    public OtlpHttpJsonMetricExporterBuilder setCompression(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "compressionMethod");
        if (!str.equals("gzip") && !str.equals("none")) {
            z16 = false;
        } else {
            z16 = true;
        }
        Utils.checkArgument(z16, "Unsupported compression method. Supported compression methods include: gzip, none.");
        this.delegate.setCompression(str);
        return this;
    }

    public OtlpHttpJsonMetricExporterBuilder setEndpoint(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "endpoint");
        this.delegate.setEndpoint(str);
        return this;
    }

    public OtlpHttpJsonMetricExporterBuilder setOkHttpUpload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "okHttpMethod");
        this.delegate.setOkHttpUpload(str);
        return this;
    }

    public OtlpHttpJsonMetricExporterBuilder setTimeout(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j3 >= 0, "timeout must be non-negative");
        this.delegate.setTimeout(j3, timeUnit);
        return this;
    }

    public OtlpHttpJsonMetricExporterBuilder setTrustedCertificates(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
        }
        this.delegate.setTrustedCertificates(bArr);
        return this;
    }

    public OtlpHttpJsonMetricExporterBuilder setTimeout(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? setTimeout(j3, TimeUnit.NANOSECONDS) : (OtlpHttpJsonMetricExporterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, j3);
    }
}
