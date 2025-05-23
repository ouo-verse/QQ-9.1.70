package com.tencent.opentelemetry.otlp.common;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.DoublePointData;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.GaugeData;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramData;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData;
import com.tencent.opentelemetry.sdk.metrics.data.LongExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.LongPointData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.data.MetricDataType;
import com.tencent.opentelemetry.sdk.metrics.data.SumData;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryData;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryPointData;
import com.tencent.opentelemetry.sdk.metrics.data.ValueAtQuantile;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class JsonMetricAdapter {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.otlp.common.JsonMetricAdapter$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$AggregationTemporality;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9437);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AggregationTemporality.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$AggregationTemporality = iArr;
            try {
                iArr[AggregationTemporality.CUMULATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$AggregationTemporality[AggregationTemporality.DELTA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[MetricDataType.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType = iArr2;
            try {
                iArr2[MetricDataType.LONG_SUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType[MetricDataType.DOUBLE_SUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType[MetricDataType.SUMMARY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType[MetricDataType.LONG_GAUGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType[MetricDataType.DOUBLE_GAUGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType[MetricDataType.HISTOGRAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    JsonMetricAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static JSONObject buildInstrumentationLibraryMetrics(Map.Entry<InstrumentationScopeInfo, JSONArray> entry) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("instrumentation_library", JsonCommonAdapter.toProtoInstrumentationLibrary(entry.getKey()));
        jSONObject.put("metrics", entry.getValue());
        if (entry.getKey().getSchemaUrl() != null) {
            jSONObject.put(QZoneAdTianshuFeedData.KEY_SCHEMA_URL, entry.getKey().getSchemaUrl());
        }
        return jSONObject;
    }

    private static JSONObject buildResourceMetrics(Resource resource, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("instrumentation_library_metrics", jSONArray);
        jSONObject.putOpt("resource", JsonResourceAdapter.toProtoResource(resource));
        String schemaUrl = resource.getSchemaUrl();
        if (schemaUrl != null) {
            jSONObject.put(QZoneAdTianshuFeedData.KEY_SCHEMA_URL, schemaUrl);
        }
        return jSONObject;
    }

    private static void fillAttributes(Attributes attributes, final JSONArray jSONArray) {
        attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.f
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonMetricAdapter.lambda$fillAttributes$7(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
    }

    private static void fillIntSumAttributes(Attributes attributes, final JSONArray jSONArray) {
        attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.j
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonMetricAdapter.lambda$fillIntSumAttributes$6(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
    }

    private static Map<Resource, Map<InstrumentationScopeInfo, JSONArray>> groupByResourceAndLibrary(Collection<MetricData> collection) throws JSONException {
        Object computeIfAbsent;
        HashMap hashMap = new HashMap();
        for (MetricData metricData : collection) {
            if (!metricData.isEmpty()) {
                Resource resource = metricData.getResource();
                Map map = (Map) hashMap.get(metricData.getResource());
                if (map == null) {
                    map = new HashMap();
                    hashMap.put(resource, map);
                }
                computeIfAbsent = map.computeIfAbsent(metricData.getInstrumentationScopeInfo(), new Function() { // from class: com.tencent.opentelemetry.otlp.common.k
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        JSONArray lambda$groupByResourceAndLibrary$0;
                        lambda$groupByResourceAndLibrary$0 = JsonMetricAdapter.lambda$groupByResourceAndLibrary$0((InstrumentationScopeInfo) obj);
                        return lambda$groupByResourceAndLibrary$0;
                    }
                });
                ((JSONArray) computeIfAbsent).mo162put(toProtoMetric(metricData));
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fillAttributes$7(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            jSONArray.mo162put(JsonCommonAdapter.toJsonAttribute(attributeKey, obj));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonMetricAdapter", "fillAttributes error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fillIntSumAttributes$6(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", attributeKey.getKey());
            jSONObject.put("value", obj.toString());
            jSONArray.mo162put(jSONObject);
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonMetricAdapter", "fillIntSumAttributes error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONArray lambda$groupByResourceAndLibrary$0(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toDoubleDataPoints$2(JSONArray jSONArray, ExemplarData exemplarData) {
        try {
            jSONArray.mo162put(toExemplar(exemplarData));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonMetricAdapter", "toDoubleDataPoints error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toHistogramDataPoints$3(JSONArray jSONArray, ExemplarData exemplarData) {
        try {
            jSONArray.mo162put(toExemplar(exemplarData));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonMetricAdapter", "toHistogramDataPoints error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toIntDataPoints$1(JSONArray jSONArray, ExemplarData exemplarData) {
        try {
            jSONArray.mo162put(toExemplar(exemplarData));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonMetricAdapter", "toIntDataPoints error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toIntSumDataPoints$4(JSONArray jSONArray, ExemplarData exemplarData) {
        try {
            jSONArray.mo162put(toIntExemplar(exemplarData));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonMetricAdapter", "toIntSumDataPoints error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toProtoLabels$5(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", attributeKey.getKey());
            jSONObject.put("value", obj.toString());
            jSONArray.mo162put(jSONObject);
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonMetricAdapter", "toProtoLabels error");
            }
        }
    }

    private static String mapToTemporality(AggregationTemporality aggregationTemporality) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$AggregationTemporality[aggregationTemporality.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return "AGGREGATION_TEMPORALITY_UNSPECIFIED";
            }
            return "AGGREGATION_TEMPORALITY_DELTA";
        }
        return "AGGREGATION_TEMPORALITY_CUMULATIVE";
    }

    static JSONArray toDoubleDataPoints(Collection<DoublePointData> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (DoublePointData doublePointData : collection) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time_unix_nano", doublePointData.getStartEpochNanos());
            jSONObject.put("time_unix_nano", doublePointData.getEpochNanos());
            jSONObject.put("as_double", doublePointData.getValue());
            JSONArray jSONArray2 = new JSONArray();
            fillAttributes(doublePointData.getAttributes(), jSONArray2);
            if (jSONArray2.length() > 0) {
                jSONObject.put("attributes", jSONArray2);
            }
            final JSONArray jSONArray3 = new JSONArray();
            doublePointData.getExemplars().forEach(new Consumer() { // from class: com.tencent.opentelemetry.otlp.common.l
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    JsonMetricAdapter.lambda$toDoubleDataPoints$2(JSONArray.this, (ExemplarData) obj);
                }
            });
            if (jSONArray3.length() > 0) {
                jSONObject.put("exemplars", jSONArray3);
            }
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    static JSONObject toExemplar(ExemplarData exemplarData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("time_unix_nano", exemplarData.getEpochNanos());
        if (exemplarData.getSpanContext() != null) {
            jSONObject.put(TraceSpan.KEY_SPAN_ID, exemplarData.getSpanContext().getSpanId());
        }
        if (exemplarData.getSpanContext() != null) {
            jSONObject.put("trace_id", exemplarData.getSpanContext().getTraceId());
        }
        JSONArray jSONArray = new JSONArray();
        fillAttributes(exemplarData.getFilteredAttributes(), jSONArray);
        if (jSONArray.length() > 0) {
            jSONObject.put("filtered_attributes", jSONArray);
        }
        if (exemplarData instanceof LongExemplarData) {
            jSONObject.put("as_int", ((LongExemplarData) exemplarData).getValue());
        } else if (exemplarData instanceof DoubleExemplarData) {
            jSONObject.put("as_double", ((DoubleExemplarData) exemplarData).getValue());
        }
        return jSONObject;
    }

    static JSONArray toHistogramDataPoints(Collection<HistogramPointData> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (HistogramPointData histogramPointData : collection) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time_unix_nano", histogramPointData.getStartEpochNanos());
            jSONObject.put("time_unix_nano", histogramPointData.getEpochNanos());
            jSONObject.put("count", histogramPointData.getCount());
            jSONObject.put("sum", histogramPointData.getSum());
            jSONObject.put("bucket_counts", new JSONArray((Collection) histogramPointData.getCounts()));
            List<Double> boundaries = histogramPointData.getBoundaries();
            if (!boundaries.isEmpty()) {
                jSONObject.put("explicit_bounds", new JSONArray((Collection) boundaries));
            }
            JSONArray jSONArray2 = new JSONArray();
            fillAttributes(histogramPointData.getAttributes(), jSONArray2);
            if (jSONArray2.length() > 0) {
                jSONObject.put("attributes", jSONArray2);
            }
            final JSONArray jSONArray3 = new JSONArray();
            histogramPointData.getExemplars().forEach(new Consumer() { // from class: com.tencent.opentelemetry.otlp.common.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    JsonMetricAdapter.lambda$toHistogramDataPoints$3(JSONArray.this, (ExemplarData) obj);
                }
            });
            if (jSONArray3.length() > 0) {
                jSONObject.put("exemplars", jSONArray3);
            }
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    static JSONArray toIntDataPoints(Collection<LongPointData> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (LongPointData longPointData : collection) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time_unix_nano", longPointData.getStartEpochNanos());
            jSONObject.put("time_unix_nano", longPointData.getEpochNanos());
            jSONObject.put("as_int", longPointData.getValue());
            JSONArray jSONArray2 = new JSONArray();
            fillAttributes(longPointData.getAttributes(), jSONArray2);
            jSONObject.put("attributes", jSONArray2);
            final JSONArray jSONArray3 = new JSONArray();
            longPointData.getExemplars().forEach(new Consumer() { // from class: com.tencent.opentelemetry.otlp.common.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    JsonMetricAdapter.lambda$toIntDataPoints$1(JSONArray.this, (ExemplarData) obj);
                }
            });
            jSONObject.put("exemplars", jSONArray3);
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    static JSONObject toIntExemplar(ExemplarData exemplarData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("time_unix_nano", exemplarData.getEpochNanos());
        if (exemplarData.getSpanContext() != null) {
            jSONObject.put(TraceSpan.KEY_SPAN_ID, exemplarData.getSpanContext().getSpanId());
        }
        if (exemplarData.getSpanContext() != null) {
            jSONObject.put("trace_id", exemplarData.getSpanContext().getTraceId());
        }
        fillIntSumAttributes(exemplarData.getFilteredAttributes(), new JSONArray());
        jSONObject.put("value", ((LongExemplarData) exemplarData).getValue());
        return jSONObject;
    }

    static JSONArray toIntSumDataPoints(Collection<LongPointData> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (LongPointData longPointData : collection) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time_unix_nano", longPointData.getStartEpochNanos());
            jSONObject.put("time_unix_nano", longPointData.getEpochNanos());
            jSONObject.put("value", longPointData.getValue());
            final JSONArray jSONArray2 = new JSONArray();
            longPointData.getExemplars().forEach(new Consumer() { // from class: com.tencent.opentelemetry.otlp.common.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    JsonMetricAdapter.lambda$toIntSumDataPoints$4(JSONArray.this, (ExemplarData) obj);
                }
            });
            if (jSONArray2.length() > 0) {
                jSONObject.put("exemplars", jSONArray2);
            }
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray toJsonResourceMetrics(Collection<MetricData> collection) throws JSONException {
        Map<Resource, Map<InstrumentationScopeInfo, JSONArray>> groupByResourceAndLibrary = groupByResourceAndLibrary(collection);
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Resource, Map<InstrumentationScopeInfo, JSONArray>> entry : groupByResourceAndLibrary.entrySet()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<Map.Entry<InstrumentationScopeInfo, JSONArray>> it = entry.getValue().entrySet().iterator();
            while (it.hasNext()) {
                jSONArray2.mo162put(buildInstrumentationLibraryMetrics(it.next()));
            }
            jSONArray.mo162put(buildResourceMetrics(entry.getKey(), jSONArray2));
        }
        return jSONArray;
    }

    static JSONArray toProtoLabels(Attributes attributes) throws JSONException {
        final JSONArray jSONArray = new JSONArray();
        attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.g
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonMetricAdapter.lambda$toProtoLabels$5(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
        return jSONArray;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0109, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static JSONObject toProtoMetric(MetricData metricData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", metricData.getName());
        jSONObject.put("description", metricData.getDescription());
        jSONObject.put("unit", metricData.getUnit());
        switch (AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$data$MetricDataType[metricData.getType().ordinal()]) {
            case 1:
                SumData<LongPointData> longSumData = metricData.getLongSumData();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("is_monotonic", longSumData.isMonotonic());
                jSONObject2.put("aggregation_temporality", mapToTemporality(longSumData.getAggregationTemporality()));
                jSONObject2.put("data_points", toIntDataPoints(longSumData.getPoints()));
                jSONObject.put("sum", jSONObject2);
                break;
            case 2:
                SumData<DoublePointData> doubleSumData = metricData.getDoubleSumData();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_monotonic", doubleSumData.isMonotonic());
                jSONObject3.put("aggregation_temporality", mapToTemporality(doubleSumData.getAggregationTemporality()));
                jSONObject3.put("data_points", toDoubleDataPoints(doubleSumData.getPoints()));
                jSONObject.put("sum", jSONObject3);
                break;
            case 3:
                SummaryData summaryData = metricData.getSummaryData();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("data_points", toSummaryDataPoints(summaryData.getPoints()));
                jSONObject.put("summary", jSONObject4);
                break;
            case 4:
                GaugeData<LongPointData> longGaugeData = metricData.getLongGaugeData();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("data_points", toIntDataPoints(longGaugeData.getPoints()));
                jSONObject.put("gauge", jSONObject5);
                break;
            case 5:
                GaugeData<DoublePointData> doubleGaugeData = metricData.getDoubleGaugeData();
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("data_points", toDoubleDataPoints(doubleGaugeData.getPoints()));
                jSONObject.put("gauge", jSONObject6);
                break;
            case 6:
                HistogramData histogramData = metricData.getHistogramData();
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("aggregation_temporality", mapToTemporality(histogramData.getAggregationTemporality()));
                jSONObject7.put("data_points", toHistogramDataPoints(histogramData.getPoints()));
                jSONObject.put(GcInfoStatHelper.GcInfo.GC_COUNT_RATE_HISTOGRAM, jSONObject7);
                break;
        }
    }

    static JSONArray toSummaryDataPoints(Collection<SummaryPointData> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (SummaryPointData summaryPointData : collection) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time_unix_nano", summaryPointData.getStartEpochNanos());
            jSONObject.put("time_unix_nano", summaryPointData.getEpochNanos());
            jSONObject.put("count", summaryPointData.getCount());
            jSONObject.put("sum", summaryPointData.getSum());
            JSONArray jSONArray2 = new JSONArray();
            fillAttributes(summaryPointData.getAttributes(), jSONArray2);
            if (jSONArray2.length() > 0) {
                jSONObject.put("attributes", jSONArray2);
            }
            if (!summaryPointData.getValues().isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (ValueAtQuantile valueAtQuantile : summaryPointData.getValues()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("quantile", valueAtQuantile.getQuantile() / 100.0d);
                    jSONObject2.put("value", valueAtQuantile.getValue());
                    jSONArray3.mo162put(jSONObject2);
                }
                jSONObject.put("quantile_values", jSONArray3);
            }
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }
}
