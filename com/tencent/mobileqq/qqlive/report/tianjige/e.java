package com.tencent.mobileqq.qqlive.report.tianjige;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mqq.BuildConfig;
import com.tencent.opentelemetry.api.OpenTelemetry;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.config.ConfigConstants;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.logging.IPrinterLogger;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.opentelemetry.api.trace.TraceFlags;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import com.tencent.opentelemetry.otlp.trace.OtlpHttpJsonSpanExporterBuilder;
import com.tencent.opentelemetry.sdk.OpenTelemetrySdk;
import com.tencent.opentelemetry.sdk.resources.AttributeResource;
import com.tencent.opentelemetry.sdk.trace.SdkTracerProvider;
import com.tencent.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e implements IPrinterLogger {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private c f271458a;

    /* renamed from: b, reason: collision with root package name */
    private OpenTelemetry f271459b;

    /* renamed from: c, reason: collision with root package name */
    private SdkTracerProvider f271460c;

    /* renamed from: d, reason: collision with root package name */
    private String f271461d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f271462e;

    /* renamed from: f, reason: collision with root package name */
    private long f271463f;

    /* renamed from: g, reason: collision with root package name */
    private int f271464g;

    public e(String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        this.f271462e = false;
        this.f271463f = 0L;
        this.f271464g = 0;
        b(d.a(str, aVar));
    }

    private void c() {
        try {
            if (l()) {
                this.f271460c.setResource(AttributeResource.buildResource());
                QLog.i("OpenTelemetryWrapperImpl", 1, "update openTelemetry config");
                return;
            }
            this.f271460c = SdkTracerProvider.builder().addSpanProcessor(BatchSpanProcessor.builder(new OtlpHttpJsonSpanExporterBuilder().setEndpoint(ConfigConstants.DEFAULT_TRACE_SERVICE_ADDRESS).addHeader(ConfigConstants.TENANT_KEY, this.f271458a.c()).setCompression("gzip").setOkHttpUpload("OkHttp").build()).build()).setResource(AttributeResource.buildResource()).setSampler(com.tencent.opentelemetry.sdk.trace.samplers.a.e(this.f271458a.b())).build();
            this.f271459b = OpenTelemetrySdk.builder().setTracerProvider(this.f271460c).setPropagators(com.tencent.opentelemetry.context.propagation.a.a(W3CTraceContextPropagator.getInstance())).build();
            QLog.i("OpenTelemetryWrapperImpl", 1, "init openTelemetry success");
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "initTrace error:" + th5.toString());
        }
    }

    private boolean g(c cVar) {
        c cVar2 = this.f271458a;
        if (cVar2 == null || !TextUtils.equals(cVar2.e(), cVar.e()) || !TextUtils.equals(this.f271458a.d(), cVar.d())) {
            return true;
        }
        return false;
    }

    private boolean j(c cVar) {
        if (cVar == null) {
            QLog.i("OpenTelemetryWrapperImpl", 1, "config set null");
            return false;
        }
        if (!g(cVar) && l()) {
            return false;
        }
        return true;
    }

    private boolean l() {
        if (this.f271460c != null && this.f271459b != null) {
            return true;
        }
        return false;
    }

    private void m(String str, Throwable th5) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f271463f < 10000) {
                this.f271464g++;
                return;
            }
            if (this.f271464g > 0) {
                QLog.e("OpenTelemetryWrapperImpl", 1, this.f271464g + " error msg is detected in last 10s. to get full details, please modify code: OpenTelemetryWrapper.printOpenTelemetryError");
            }
            this.f271463f = currentTimeMillis;
            QLog.e("OpenTelemetryWrapperImpl", 1, str, th5);
            this.f271464g = 0;
        } catch (Exception unused) {
        }
    }

    private void o(c cVar) {
        String str;
        if (cVar == null) {
            return;
        }
        try {
            boolean isTestEnv = SSODebugUtil.isTestEnv();
            this.f271462e = isTestEnv;
            if (isTestEnv) {
                str = "test";
            } else {
                str = "formal";
            }
            this.f271461d = str;
            AttributeResource.withAttributes(com.tencent.opentelemetry.api.common.f.a().put("app_version", cVar.a()).build());
            AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
            a16.put(ConfigConstants.CONSTANT_TENANT_ID_KEY, cVar.c());
            a16.put(ConfigConstants.CONSTANT_TENANT_NAME_KEY, cVar.c());
            a16.put(INetChannelCallback.KEY_TINY_ID, cVar.d());
            a16.put("platform", "Android");
            a16.put("uin", cVar.e());
            a16.put("dev_model", f.b().c());
            a16.put("dev_brand", f.b().a());
            a16.put("os_ver", f.b().d());
            AttributeResource.addAttributes(a16.build());
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "setAttributeResource error:" + th5.toString());
        }
    }

    private void p(Span span) {
        if (span == null) {
            return;
        }
        span.setAttribute(MosaicConstants$JsProperty.PROP_ENV, this.f271461d);
    }

    public void a(Span span, StatusCode statusCode) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) span, (Object) statusCode);
            return;
        }
        if (span == null) {
            return;
        }
        boolean z17 = false;
        if (h() && statusCode == StatusCode.ERROR) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (f() || z16) {
            z17 = true;
        }
        if (!z17) {
            return;
        }
        try {
            span.end();
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
        }
    }

    public void b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        try {
            if (!j(cVar)) {
                return;
            }
            this.f271458a = cVar;
            o(cVar);
            c();
            DefaultPrintLogger.registerLogger(this);
        } catch (Throwable th5) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "init error:" + th5);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            m(str2, null);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) str2);
        }
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        c cVar = this.f271458a;
        if (cVar != null && cVar.f()) {
            return true;
        }
        return false;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        c cVar = this.f271458a;
        if (cVar != null && cVar.g()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public boolean isColorLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    /* renamed from: isDebug */
    public boolean getIsDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f271462e;
    }

    public boolean k(Span span) {
        TraceFlags traceFlags;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) span)).booleanValue();
        }
        if (span == null || span.getSpanContext() == null || (traceFlags = span.getSpanContext().getTraceFlags()) == null || !traceFlags.isSampled() || !f()) {
            return false;
        }
        return true;
    }

    public void n(Span span, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) span, (Object) map);
            return;
        }
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

    public void q(Span span, StatusCode statusCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) span, (Object) statusCode);
            return;
        }
        if (span == null) {
            return;
        }
        try {
            span.setStatus(statusCode);
        } catch (Exception e16) {
            QLog.e("OpenTelemetryWrapperImpl", 1, "setStatusCode error:" + e16.toString());
        }
    }

    public Span r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Span) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return s(str, "");
    }

    public Span s(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Span) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
        OpenTelemetry openTelemetry = this.f271459b;
        if (openTelemetry != null && this.f271460c != null) {
            try {
                Tracer tracer = openTelemetry.getTracer(BuildConfig.LIBRARY_PACKAGE_NAME, this.f271458a.a());
                if (!TextUtils.isEmpty(str2)) {
                    AttributeResource.addAttributes(com.tencent.opentelemetry.api.common.f.c(ResourceAttributes.SERVICE_NAME, str2));
                    this.f271460c.setResource(AttributeResource.buildResource());
                }
                Span startSpan = tracer.spanBuilder(str).setSpanKind(SpanKind.CLIENT).startSpan();
                p(startSpan);
                return startSpan;
            } catch (Throwable th5) {
                QLog.e("OpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
            }
        }
        return null;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            m(str2, th5);
        } else {
            iPatchRedirector.redirect((short) 21, this, str, str2, th5);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, this, str, str2, th5);
    }
}
