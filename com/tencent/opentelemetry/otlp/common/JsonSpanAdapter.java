package com.tencent.opentelemetry.otlp.common;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.sdk.trace.data.EventData;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import com.tencent.opentelemetry.sdk.trace.data.StatusData;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class JsonSpanAdapter {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.otlp.common.JsonSpanAdapter$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$api$trace$SpanKind;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9398);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[SpanKind.values().length];
            $SwitchMap$com$tencent$opentelemetry$api$trace$SpanKind = iArr;
            try {
                iArr[SpanKind.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$SpanKind[SpanKind.SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$SpanKind[SpanKind.CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$SpanKind[SpanKind.PRODUCER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$SpanKind[SpanKind.CONSUMER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[StatusCode.values().length];
            $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode = iArr2;
            try {
                iArr2[StatusCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode[StatusCode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode[StatusCode.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    JsonSpanAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static JSONObject buildInstrumentationLibrarySpan(InstrumentationScopeInfo instrumentationScopeInfo, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scope", JsonCommonAdapter.toProtoInstrumentationLibrary(instrumentationScopeInfo));
        jSONObject.put("spans", jSONArray);
        if (instrumentationScopeInfo.getSchemaUrl() != null) {
            jSONObject.put(QZoneAdTianshuFeedData.KEY_SCHEMA_URL, instrumentationScopeInfo.getSchemaUrl());
        }
        return jSONObject;
    }

    private static Map<Resource, Map<InstrumentationScopeInfo, JSONArray>> groupByResourceAndLibrary(Collection<SpanData> collection) throws JSONException {
        Object computeIfAbsent;
        Object computeIfAbsent2;
        HashMap hashMap = new HashMap();
        for (SpanData spanData : collection) {
            computeIfAbsent = hashMap.computeIfAbsent(spanData.getResource(), new Function() { // from class: com.tencent.opentelemetry.otlp.common.s
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Map lambda$groupByResourceAndLibrary$2;
                    lambda$groupByResourceAndLibrary$2 = JsonSpanAdapter.lambda$groupByResourceAndLibrary$2((Resource) obj);
                    return lambda$groupByResourceAndLibrary$2;
                }
            });
            computeIfAbsent2 = ((Map) computeIfAbsent).computeIfAbsent(spanData.getInstrumentationScopeInfo(), new Function() { // from class: com.tencent.opentelemetry.otlp.common.t
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    JSONArray lambda$groupByResourceAndLibrary$3;
                    lambda$groupByResourceAndLibrary$3 = JsonSpanAdapter.lambda$groupByResourceAndLibrary$3((InstrumentationScopeInfo) obj);
                    return lambda$groupByResourceAndLibrary$3;
                }
            });
            ((JSONArray) computeIfAbsent2).mo162put(toProtoSpan(spanData));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$groupByResourceAndLibrary$2(Resource resource) {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONArray lambda$groupByResourceAndLibrary$3(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toJsonResourceSpans$0(JSONArray jSONArray, InstrumentationScopeInfo instrumentationScopeInfo, JSONArray jSONArray2) {
        try {
            jSONArray.mo162put(buildInstrumentationLibrarySpan(instrumentationScopeInfo, jSONArray2));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonSpanAdapter", "toJsonResourceSpans put instrumentationLibrarySpan error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toJsonResourceSpans$1(JSONArray jSONArray, Resource resource, Map map) {
        JSONObject jSONObject = new JSONObject();
        if (resource.getSchemaUrl() != null) {
            try {
                jSONObject.put(QZoneAdTianshuFeedData.KEY_SCHEMA_URL, resource.getSchemaUrl());
            } catch (JSONException unused) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e("JsonSpanAdapter", "toJsonResourceSpans put schema_url error");
                }
            }
        }
        final JSONArray jSONArray2 = new JSONArray();
        map.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.r
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonSpanAdapter.lambda$toJsonResourceSpans$0(JSONArray.this, (InstrumentationScopeInfo) obj, (JSONArray) obj2);
            }
        });
        try {
            jSONObject.put("scope_spans", jSONArray2);
            jSONObject.put("resource", JsonResourceAdapter.toProtoResource(resource));
        } catch (JSONException unused2) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonSpanAdapter", "toJsonResourceSpans put instrumentation_library_spans or resource error");
            }
        }
        jSONArray.mo162put(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toProtoSpan$4(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            jSONArray.mo162put(JsonCommonAdapter.toJsonAttribute(attributeKey, obj));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonSpanAdapter", "toProtoSpan error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toProtoSpanEvent$5(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            jSONArray.mo162put(JsonCommonAdapter.toJsonAttribute(attributeKey, obj));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonSpanAdapter", "toProtoSpanEvent error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toProtoSpanLink$6(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            jSONArray.mo162put(JsonCommonAdapter.toJsonAttribute(attributeKey, obj));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonSpanAdapter", "toProtoSpanLink error");
            }
        }
    }

    public static JSONArray toJsonResourceSpans(Collection<SpanData> collection) throws JSONException {
        Map<Resource, Map<InstrumentationScopeInfo, JSONArray>> groupByResourceAndLibrary = groupByResourceAndLibrary(collection);
        final JSONArray jSONArray = new JSONArray();
        groupByResourceAndLibrary.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.u
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonSpanAdapter.lambda$toJsonResourceSpans$1(JSONArray.this, (Resource) obj, (Map) obj2);
            }
        });
        return jSONArray;
    }

    static JSONObject toProtoSpan(SpanData spanData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("trace_id", spanData.getSpanContext().getTraceId());
        jSONObject.put(TraceSpan.KEY_SPAN_ID, spanData.getSpanContext().getSpanId());
        if (spanData.getParentSpanContext().isValid()) {
            jSONObject.put(TraceSpan.KEY_PARENT_SPAN_ID, spanData.getParentSpanContext().getSpanId());
        }
        jSONObject.put("name", spanData.getName());
        jSONObject.put("kind", toProtoSpanKind(spanData.getKind()));
        jSONObject.put("start_time_unix_nano", spanData.getStartEpochNanos());
        jSONObject.put("end_time_unix_nano", spanData.getEndEpochNanos());
        final JSONArray jSONArray = new JSONArray();
        spanData.getAttributes().forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.q
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonSpanAdapter.lambda$toProtoSpan$4(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
        jSONObject.put("attributes", jSONArray);
        jSONObject.put("dropped_attributes_count", spanData.getTotalAttributeCount() - spanData.getAttributes().size());
        JSONArray jSONArray2 = new JSONArray();
        Iterator<EventData> it = spanData.getEvents().iterator();
        while (it.hasNext()) {
            jSONArray2.mo162put(toProtoSpanEvent(it.next()));
        }
        jSONObject.put(LinkReportConstant$GlobalKey.EVENTS, jSONArray2);
        jSONObject.put("dropped_events_count", spanData.getTotalRecordedEvents() - spanData.getEvents().size());
        JSONArray jSONArray3 = new JSONArray();
        Iterator<LinkData> it5 = spanData.getLinks().iterator();
        while (it5.hasNext()) {
            jSONArray3.mo162put(toProtoSpanLink(it5.next()));
        }
        jSONObject.put("links", jSONArray3);
        jSONObject.put("dropped_links_count", spanData.getTotalRecordedLinks() - spanData.getLinks().size());
        jSONObject.put("status", toStatusProto(spanData.getStatus()));
        return jSONObject;
    }

    static JSONObject toProtoSpanEvent(EventData eventData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", eventData.getName());
        jSONObject.put("time_unix_nano", eventData.getEpochNanos());
        final JSONArray jSONArray = new JSONArray();
        eventData.getAttributes().forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.o
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonSpanAdapter.lambda$toProtoSpanEvent$5(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
        jSONObject.put("attributes", jSONArray);
        jSONObject.put("dropped_attributes_count", eventData.getTotalAttributeCount() - eventData.getAttributes().size());
        return jSONObject;
    }

    static String toProtoSpanKind(SpanKind spanKind) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$api$trace$SpanKind[spanKind.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "UNRECOGNIZED";
                        }
                        return "SPAN_KIND_CONSUMER";
                    }
                    return "SPAN_KIND_PRODUCER";
                }
                return "SPAN_KIND_CLIENT";
            }
            return "SPAN_KIND_SERVER";
        }
        return "SPAN_KIND_INTERNAL";
    }

    static JSONObject toProtoSpanLink(LinkData linkData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("trace_id", linkData.getSpanContext().getTraceId());
        jSONObject.put(TraceSpan.KEY_SPAN_ID, linkData.getSpanContext().getSpanId());
        final JSONArray jSONArray = new JSONArray();
        Attributes attributes = linkData.getAttributes();
        attributes.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.p
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonSpanAdapter.lambda$toProtoSpanLink$6(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
        jSONObject.put("attributes", jSONArray);
        jSONObject.put("dropped_attributes_count", linkData.getTotalAttributeCount() - attributes.size());
        return jSONObject;
    }

    static JSONObject toStatusProto(StatusData statusData) throws JSONException {
        JSONObject jSONObject;
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$api$trace$StatusCode[statusData.getStatusCode().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                jSONObject = new JSONObject();
                jSONObject.put("code", "STATUS_CODE_UNSET");
            } else {
                jSONObject = new JSONObject();
                jSONObject.put("code", "STATUS_CODE_ERROR");
            }
        } else {
            jSONObject = new JSONObject();
            jSONObject.put("code", "STATUS_CODE_OK");
        }
        if (statusData.getDescription().isEmpty()) {
            return jSONObject;
        }
        jSONObject.put("message", statusData.getDescription());
        return jSONObject;
    }
}
