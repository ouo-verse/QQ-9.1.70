package com.tencent.mobileqq.qqguildsdk.tianjige;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mqq.BuildConfig;
import com.tencent.opentelemetry.api.OpenTelemetry;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.config.ConfigConstants;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.logging.IPrinterLogger;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanBuilder;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.opentelemetry.api.trace.TraceFlags;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.context.propagation.TextMapGetter;
import com.tencent.opentelemetry.otlp.trace.OtlpHttpJsonSpanExporterBuilder;
import com.tencent.opentelemetry.sdk.OpenTelemetrySdk;
import com.tencent.opentelemetry.sdk.resources.AttributeResource;
import com.tencent.opentelemetry.sdk.trace.SdkTracerProvider;
import com.tencent.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h implements IPrinterLogger {

    /* renamed from: h, reason: collision with root package name */
    private static h f268522h;

    /* renamed from: a, reason: collision with root package name */
    private e f268523a;

    /* renamed from: b, reason: collision with root package name */
    private OpenTelemetry f268524b;

    /* renamed from: c, reason: collision with root package name */
    private SdkTracerProvider f268525c;

    /* renamed from: d, reason: collision with root package name */
    private String f268526d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f268527e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f268528f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f268529g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements TextMapGetter<Map<String, String>> {
        a() {
        }

        @Override // com.tencent.opentelemetry.context.propagation.TextMapGetter
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get(Map<String, String> map, String str) {
            return map.get(str);
        }

        @Override // com.tencent.opentelemetry.context.propagation.TextMapGetter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Iterable<String> keys(Map<String, String> map) {
            return map.keySet();
        }
    }

    h() {
        g(f.a());
    }

    private Context c(String str) {
        a aVar = new a();
        HashMap hashMap = new HashMap();
        hashMap.put(W3CTraceContextPropagator.TRACE_PARENT, str);
        return this.f268524b.getPropagators().getTextMapPropagator().extract(com.tencent.opentelemetry.context.e.k(), hashMap, aVar);
    }

    public static h f() {
        if (f268522h == null) {
            synchronized (h.class) {
                if (f268522h == null) {
                    f268522h = new h();
                }
            }
        }
        return f268522h;
    }

    private void h(boolean z16) {
        if (z16) {
            try {
                if (n()) {
                    this.f268525c.setResource(AttributeResource.buildResource());
                    QLog.i("OpenTelemetryWrapperImpl", 1, "update openTelemetry config");
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("OpenTelemetryWrapperImpl", 1, "initTrace error:" + th5.toString());
                return;
            }
        }
        this.f268525c = SdkTracerProvider.builder().addSpanProcessor(BatchSpanProcessor.builder(new OtlpHttpJsonSpanExporterBuilder().setEndpoint(ConfigConstants.DEFAULT_TRACE_SERVICE_ADDRESS).addHeader(ConfigConstants.TENANT_KEY, this.f268523a.d()).setCompression("gzip").setOkHttpUpload("OkHttp").build()).setMaxExportBatchSize(256).setMaxQueueSize(1024).setExporterTimeout(TimeUnit.MILLISECONDS.toNanos(15000L)).build()).setResource(AttributeResource.buildResource()).setSampler(new d()).build();
        this.f268524b = OpenTelemetrySdk.builder().setTracerProvider(this.f268525c).setPropagators(com.tencent.opentelemetry.context.propagation.a.a(W3CTraceContextPropagator.getInstance())).build();
        QLog.i("OpenTelemetryWrapperImpl", 1, "init openTelemetry success");
    }

    private boolean k(e eVar) {
        e eVar2 = this.f268523a;
        if (eVar2 == null || !TextUtils.equals(eVar2.f(), eVar.f()) || !TextUtils.equals(this.f268523a.e(), eVar.e()) || e.h() != e.h()) {
            return true;
        }
        return false;
    }

    private boolean l(e eVar) {
        if (eVar == null) {
            QLog.i("OpenTelemetryWrapperImpl", 1, "config set null");
            return false;
        }
        if (!k(eVar) && n()) {
            return false;
        }
        return true;
    }

    private boolean n() {
        if (this.f268525c != null && this.f268524b != null) {
            return true;
        }
        return false;
    }

    private void o(String str, Throwable th5) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f268528f < 10000) {
                this.f268529g++;
                return;
            }
            if (this.f268529g > 0) {
                QLog.e("OpenTelemetryWrapperImpl", 1, this.f268529g + " error msg is detected in last 10s. to get full details, please modify code: OpenTelemetryWrapper.printOpenTelemetryError");
            }
            this.f268528f = currentTimeMillis;
            QLog.e("OpenTelemetryWrapperImpl", 1, str, th5);
            this.f268529g = 0;
        } catch (Exception unused) {
        }
    }

    private void s(e eVar) {
        String str;
        if (eVar == null) {
            return;
        }
        int i3 = 0;
        try {
            i3 = InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), BaseApplication.getContext().getPackageName(), 0).versionCode;
        } catch (Exception e16) {
            QLog.i("OpenTelemetryWrapperImpl", 1, "get versionCode err:" + e16.getMessage());
        }
        try {
            boolean l3 = com.tencent.mobileqq.qqguildsdk.util.j.l();
            this.f268527e = l3;
            if (l3) {
                str = "test";
            } else {
                str = "formal";
            }
            this.f268526d = str;
            AttributeResource.withAttributes(com.tencent.opentelemetry.api.common.f.a().put("app_version", eVar.a()).build());
            AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
            a16.put(ConfigConstants.CONSTANT_TENANT_ID_KEY, eVar.d());
            a16.put(ConfigConstants.CONSTANT_TENANT_NAME_KEY, eVar.d());
            a16.put((AttributeKey<AttributeKey<String>>) ResourceAttributes.SERVICE_NAME, (AttributeKey<String>) "qq-android-guild");
            a16.put(INetChannelCallback.KEY_TINY_ID, eVar.e());
            a16.put("platform", "Android");
            a16.put("uin", eVar.f());
            a16.put("dev_model", i.b().c());
            a16.put("dev_brand", i.b().a());
            a16.put("os_ver", i.b().d());
            a16.put("version_code", i3);
            AttributeResource.addAttributes(a16.build());
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "setAttributeResource error:" + th5.toString());
        }
    }

    private void t(Span span) {
        if (span == null) {
            return;
        }
        span.setAttribute(MosaicConstants$JsProperty.PROP_ENV, this.f268526d);
    }

    public void a(Span span) {
        b(span, StatusCode.OK);
    }

    public void b(Span span, StatusCode statusCode) {
        if (span == null) {
            return;
        }
        try {
            span.end();
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2) {
        o(str2, null);
    }

    public void g(e eVar) {
        try {
            if (!l(eVar)) {
                return;
            }
            this.f268523a = eVar;
            if (!e.h()) {
                QLog.i("OpenTelemetryWrapperImpl", 2, "switch not on");
                return;
            }
            s(this.f268523a);
            h(true);
            DefaultPrintLogger.registerLogger(this);
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "init error:" + th5.toString());
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public boolean isColorLevel() {
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    /* renamed from: isDebug */
    public boolean getIsDebug() {
        return this.f268527e;
    }

    public boolean j() {
        e eVar = this.f268523a;
        if (eVar != null && eVar.g()) {
            return true;
        }
        return false;
    }

    public boolean m(Span span) {
        TraceFlags traceFlags;
        if (span == null || span.getSpanContext() == null || (traceFlags = span.getSpanContext().getTraceFlags()) == null || !traceFlags.isSampled() || !j()) {
            return false;
        }
        return true;
    }

    public void p(g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            Span v3 = v(gVar.b());
            if (v3 == null) {
                return;
            }
            Map<String, String> c16 = gVar.c();
            if (c16 != null) {
                for (Map.Entry<String, String> entry : c16.entrySet()) {
                    v3.setAttribute(entry.getKey(), entry.getValue());
                }
            }
            a(v3);
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "report error:" + th5.toString());
        }
    }

    public void q(Span span, g gVar) {
        if (span != null && gVar != null) {
            try {
                AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
                Map<String, String> c16 = gVar.c();
                if (c16 != null) {
                    for (Map.Entry<String, String> entry : c16.entrySet()) {
                        a16.put(entry.getKey(), entry.getValue());
                    }
                }
                span.addEvent(gVar.b(), a16.build());
            } catch (Throwable th5) {
                QLog.e("OpenTelemetryWrapperImpl", 1, "report error:" + th5.toString());
            }
        }
    }

    public void r(Span span, Map<String, String> map) {
        if (span != null && map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    span.setAttribute(entry.getKey(), entry.getValue());
                }
            } catch (Exception e16) {
                QLog.e("OpenTelemetryWrapperImpl", 1, "setAttribute error:" + e16.toString());
            }
        }
    }

    public void u(Span span, StatusCode statusCode) {
        if (span == null) {
            return;
        }
        try {
            span.setStatus(statusCode);
        } catch (Exception e16) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "setStatusCode error:" + e16.toString());
        }
    }

    public Span v(String str) {
        return w(str, "", "", "");
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2) {
    }

    public void x(String str) {
        if (this.f268523a != null && !TextUtils.isEmpty(str) && !TextUtils.equals(str, this.f268523a.e())) {
            e a16 = f.a();
            if (a16 != null) {
                a16.i(str);
            }
            g(a16);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2, Throwable th5) {
        o(str2, th5);
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2, Throwable th5) {
    }

    public Span w(String str, String str2, String str3, String str4) {
        OpenTelemetry openTelemetry = this.f268524b;
        if (openTelemetry != null && this.f268525c != null) {
            try {
                Tracer tracer = openTelemetry.getTracer(BuildConfig.LIBRARY_PACKAGE_NAME, this.f268523a.a());
                if (!TextUtils.isEmpty(str2)) {
                    AttributeResource.addAttributes(com.tencent.opentelemetry.api.common.f.c(ResourceAttributes.SERVICE_NAME, str2));
                    this.f268525c.setResource(AttributeResource.buildResource());
                }
                SpanBuilder spanKind = tracer.spanBuilder(str).setSpanKind(SpanKind.CLIENT);
                spanKind.setAttribute(d.f268501d, str4.equals("") ? this.f268523a.b() : this.f268523a.c());
                if (!TextUtils.isEmpty(str3)) {
                    spanKind.setParent(c(str3));
                }
                Span startSpan = spanKind.startSpan();
                t(startSpan);
                return startSpan;
            } catch (Throwable th5) {
                QLog.e("OpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
            }
        }
        return null;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void d(String str, String str2) {
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void i(String str, String str2) {
    }
}
