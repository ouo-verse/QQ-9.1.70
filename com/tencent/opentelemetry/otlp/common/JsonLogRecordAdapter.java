package com.tencent.opentelemetry.otlp.common;

import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import com.tencent.opentelemetry.sdk.logs.data.Severity;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsonLogRecordAdapter {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.otlp.common.JsonLogRecordAdapter$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9476);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Severity.values().length];
            $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity = iArr;
            try {
                iArr[Severity.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.TRACE2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.TRACE3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.TRACE4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.DEBUG2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.DEBUG3.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.DEBUG4.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.INFO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.INFO2.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.INFO3.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.INFO4.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.ERROR2.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.ERROR3.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.ERROR4.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.FATAL.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.FATAL2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.FATAL3.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[Severity.FATAL4.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public JsonLogRecordAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static Map<Resource, Map<InstrumentationScopeInfo, JSONArray>> groupByResourceAndLibrary(Collection<LogData> collection) throws JSONException {
        Object computeIfAbsent;
        Object computeIfAbsent2;
        HashMap hashMap = new HashMap();
        for (LogData logData : collection) {
            computeIfAbsent = hashMap.computeIfAbsent(logData.getResource(), new Function() { // from class: com.tencent.opentelemetry.otlp.common.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Map lambda$groupByResourceAndLibrary$0;
                    lambda$groupByResourceAndLibrary$0 = JsonLogRecordAdapter.lambda$groupByResourceAndLibrary$0((Resource) obj);
                    return lambda$groupByResourceAndLibrary$0;
                }
            });
            computeIfAbsent2 = ((Map) computeIfAbsent).computeIfAbsent(logData.getInstrumentationScopeInfo(), new Function() { // from class: com.tencent.opentelemetry.otlp.common.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    JSONArray lambda$groupByResourceAndLibrary$1;
                    lambda$groupByResourceAndLibrary$1 = JsonLogRecordAdapter.lambda$groupByResourceAndLibrary$1((InstrumentationScopeInfo) obj);
                    return lambda$groupByResourceAndLibrary$1;
                }
            });
            ((JSONArray) computeIfAbsent2).mo162put(toProtoLogRecord(logData));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$groupByResourceAndLibrary$0(Resource resource) {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONArray lambda$groupByResourceAndLibrary$1(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toProtoLogRecord$2(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            jSONArray.mo162put(JsonCommonAdapter.toJsonAttribute(attributeKey, obj));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonLogRecordAdapter", "toProtoLogRecord error");
            }
        }
    }

    static JSONObject toProtoLogRecord(LogData logData) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("trace_id", logData.getSpanContext().getTraceId());
        jSONObject.put(TraceSpan.KEY_SPAN_ID, logData.getSpanContext().getSpanId());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("string_value", logData.getBody().asString());
        jSONObject.put("body", jSONObject2);
        jSONObject.put("time_unix_nano", logData.getEpochNanos());
        jSONObject.put("severity_number", toProtoSeverityNumber(logData.getSeverity()));
        jSONObject.put("severity_text", logData.getSeverityText());
        jSONObject.put(WadlProxyConsts.FLAGS, 1);
        final JSONArray jSONArray = new JSONArray();
        logData.getAttributes().forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.d
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonLogRecordAdapter.lambda$toProtoLogRecord$2(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
        jSONObject.put("attributes", jSONArray);
        return jSONObject;
    }

    public static JSONArray toProtoResourceLogs(Collection<LogData> collection) throws JSONException {
        Map<Resource, Map<InstrumentationScopeInfo, JSONArray>> groupByResourceAndLibrary = groupByResourceAndLibrary(collection);
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Resource, Map<InstrumentationScopeInfo, JSONArray>> entry : groupByResourceAndLibrary.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<InstrumentationScopeInfo, JSONArray> entry2 : entry.getValue().entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("instrumentation_library", JsonCommonAdapter.toProtoInstrumentationLibrary(entry2.getKey()));
                jSONObject2.put("logs", entry2.getValue());
                jSONArray2.mo162put(jSONObject2);
            }
            jSONObject.put("instrumentation_library_logs", jSONArray2);
            jSONObject.put("resource", JsonCommonAdapter.toProtoResource(entry.getKey()));
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    static String toProtoSeverityNumber(Severity severity) {
        switch (AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[severity.ordinal()]) {
            case 1:
                return "SEVERITY_NUMBER_TRACE";
            case 2:
                return "SEVERITY_NUMBER_TRACE2";
            case 3:
                return "SEVERITY_NUMBER_TRACE3";
            case 4:
                return "SEVERITY_NUMBER_TRACE4";
            case 5:
                return "SEVERITY_NUMBER_DEBUG";
            case 6:
                return "SEVERITY_NUMBER_DEBUG2";
            case 7:
                return "SEVERITY_NUMBER_DEBUG3";
            case 8:
                return "SEVERITY_NUMBER_DEBUG4";
            case 9:
                return "SEVERITY_NUMBER_INFO";
            case 10:
                return "SEVERITY_NUMBER_INFO2";
            case 11:
                return "SEVERITY_NUMBER_INFO3";
            case 12:
                return "SEVERITY_NUMBER_INFO4";
            default:
                return toProtoSeverityNumber2(severity);
        }
    }

    static String toProtoSeverityNumber2(Severity severity) {
        switch (AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$logs$data$Severity[severity.ordinal()]) {
            case 13:
                return "SEVERITY_NUMBER_ERROR";
            case 14:
                return "SEVERITY_NUMBER_ERROR2";
            case 15:
                return "SEVERITY_NUMBER_ERROR3";
            case 16:
                return "SEVERITY_NUMBER_ERROR4";
            case 17:
                return "SEVERITY_NUMBER_FATAL";
            case 18:
                return "SEVERITY_NUMBER_FATAL2";
            case 19:
                return "SEVERITY_NUMBER_FATAL3";
            case 20:
                return "SEVERITY_NUMBER_FATAL4";
            default:
                return "UNRECOGNIZED";
        }
    }
}
