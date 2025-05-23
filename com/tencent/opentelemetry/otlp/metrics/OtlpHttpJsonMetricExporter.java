package com.tencent.opentelemetry.otlp.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.otlp.common.JsonMetricAdapter;
import com.tencent.opentelemetry.otlp.common.OkHttpExporter;
import com.tencent.opentelemetry.otlp.common.OtlpHttpExecutorService;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.export.MetricExporter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;
import okhttp3.Headers;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpJsonMetricExporter implements MetricExporter {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private final Function<InstrumentType, AggregationTemporality> aggregationTemporalityFunction;
    private final OkHttpExporter delegate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            TAG = OtlpHttpJsonMetricExporter.class.getName();
        }
    }

    public OtlpHttpJsonMetricExporter(OkHttpExporter okHttpExporter, Function<InstrumentType, AggregationTemporality> function) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) okHttpExporter, (Object) function);
        } else {
            this.delegate = okHttpExporter;
            this.aggregationTemporalityFunction = function;
        }
    }

    public static OtlpHttpJsonMetricExporterBuilder builder() {
        return new OtlpHttpJsonMetricExporterBuilder();
    }

    public static OtlpHttpJsonMetricExporter getDefault() {
        return builder().build();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode export(Collection<MetricData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this, (Object) collection);
        }
        CompletableResultCode completableResultCode = new CompletableResultCode();
        if (collection != null && !collection.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resource_metrics", JsonMetricAdapter.toJsonResourceMetrics(collection));
                OkHttpExporter okHttpExporter = this.delegate;
                if (!okHttpExporter.okHttpUploadEnabled) {
                    HashMap hashMap = new HashMap();
                    Headers headers = this.delegate.headers;
                    Objects.requireNonNull(headers);
                    for (String str : headers.names()) {
                        hashMap.put(str, this.delegate.headers.get(str));
                    }
                    return OtlpHttpExecutorService.export(TAG, this.delegate.endpoint, hashMap, jSONObject.toString());
                }
                return okHttpExporter.export(jSONObject, collection.size());
            } catch (Throwable th5) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Failed to export metrics", th5);
                }
                completableResultCode.fail();
                return completableResultCode;
            }
        }
        return completableResultCode.succeed();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        Object apply;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            apply = this.aggregationTemporalityFunction.apply(instrumentType);
            return (AggregationTemporality) apply;
        }
        return (AggregationTemporality) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentType);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.delegate.shutdown();
    }
}
