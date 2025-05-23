package com.tencent.mobileqq.tianjige;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mqq.BuildConfig;
import com.tencent.opentelemetry.api.OpenTelemetry;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.config.ConfigConstants;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.logging.IPrinterLogger;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanBuilder;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import com.tencent.opentelemetry.otlp.trace.OtlpHttpJsonSpanExporterBuilder;
import com.tencent.opentelemetry.sdk.OpenTelemetrySdk;
import com.tencent.opentelemetry.sdk.resources.AttributeResource;
import com.tencent.opentelemetry.sdk.trace.SdkTracerProvider;
import com.tencent.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements IPrinterLogger {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f292925a;

    /* renamed from: b, reason: collision with root package name */
    private a f292926b;

    /* renamed from: c, reason: collision with root package name */
    private OpenTelemetry f292927c;

    /* renamed from: d, reason: collision with root package name */
    private SdkTracerProvider f292928d;

    /* renamed from: e, reason: collision with root package name */
    private long f292929e;

    /* renamed from: f, reason: collision with root package name */
    private int f292930f;

    /* renamed from: g, reason: collision with root package name */
    private String f292931g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f292932h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f292929e = 0L;
        this.f292930f = 0;
        this.f292932h = false;
        this.f292925a = i3;
    }

    private void f() {
        try {
            if (k()) {
                this.f292928d.setResource(AttributeResource.buildResource());
                QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "update openTelemetry config");
                return;
            }
            a aVar = this.f292926b;
            if (aVar == null) {
                QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "mConfig == null");
                return;
            }
            this.f292928d = SdkTracerProvider.builder().addSpanProcessor(BatchSpanProcessor.builder(new OtlpHttpJsonSpanExporterBuilder().setEndpoint(ConfigConstants.DEFAULT_TRACE_SERVICE_ADDRESS).addHeader(ConfigConstants.TENANT_KEY, this.f292926b.c()).setCompression("gzip").setOkHttpUpload("OkHttp").build()).setMaxExportBatchSize(256).setMaxQueueSize(1024).setExporterTimeout(TimeUnit.MILLISECONDS.toNanos(15000L)).build()).setResource(AttributeResource.buildResource()).setSampler(com.tencent.opentelemetry.sdk.trace.samplers.a.e(aVar.b())).build();
            this.f292927c = OpenTelemetrySdk.builder().setTracerProvider(this.f292928d).setPropagators(com.tencent.opentelemetry.context.propagation.a.a(W3CTraceContextPropagator.getInstance())).build();
            QLog.i("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "mBusinessId = " + this.f292925a + " init openTelemetry success");
        } catch (Throwable th5) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "initTrace error:" + th5.toString());
        }
    }

    private boolean g(a aVar) {
        a aVar2 = this.f292926b;
        if (aVar2 == null || !TextUtils.equals(aVar2.e(), aVar.e()) || !TextUtils.equals(this.f292926b.d(), aVar.d()) || this.f292926b.f() != aVar.f()) {
            return true;
        }
        return false;
    }

    private boolean h(a aVar) {
        if (aVar == null) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "config set null");
            return false;
        }
        if (!g(aVar) && k()) {
            return false;
        }
        return true;
    }

    private boolean k() {
        if (this.f292928d != null && this.f292927c != null) {
            return true;
        }
        return false;
    }

    private void l(String str, Throwable th5) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f292929e < 10000) {
                this.f292930f++;
                return;
            }
            if (this.f292930f > 0) {
                QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, this.f292930f + " error msg is detected in last 10s. to get full details, please modify code: OpenTelemetryWrapper.printOpenTelemetryError");
            }
            this.f292929e = currentTimeMillis;
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, str, th5);
            this.f292930f = 0;
        } catch (Exception e16) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "printOpenTelemetryError: " + e16);
        }
    }

    private void r(a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        try {
            boolean isTestEnv = SSODebugUtil.isTestEnv();
            this.f292932h = isTestEnv;
            if (isTestEnv) {
                str = "test";
            } else {
                str = "formal";
            }
            this.f292931g = str;
            AttributeResource.withAttributes(com.tencent.opentelemetry.api.common.f.a().put("app_version", aVar.a()).build());
            AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
            a16.put(ConfigConstants.CONSTANT_TENANT_ID_KEY, aVar.c());
            a16.put(ConfigConstants.CONSTANT_TENANT_NAME_KEY, aVar.c());
            a16.put(INetChannelCallback.KEY_TINY_ID, aVar.d());
            a16.put("platform", "Android");
            a16.put("uin", aVar.e());
            a16.put("dev_model", g.b().c());
            a16.put("dev_brand", g.b().a());
            a16.put("os_ver", g.b().d());
            a16.put("build_type", "public");
            AttributeResource.addAttributes(a16.build());
        } catch (Throwable th5) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "setAttributeResource error:" + th5.toString());
        }
    }

    public void a(Span span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) span);
            return;
        }
        if (span == null) {
            return;
        }
        try {
            span.end();
        } catch (Throwable th5) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f292925a;
    }

    public void c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        try {
            if (!h(aVar)) {
                return;
            }
            this.f292926b = aVar;
            if (!aVar.f()) {
                return;
            }
            r(this.f292926b);
            f();
            DefaultPrintLogger.registerLogger(this);
        } catch (Throwable th5) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "init error:" + th5.toString());
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            l(str2, null);
        } else {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public boolean isColorLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    /* renamed from: isDebug */
    public boolean getIsDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f292932h;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        a aVar = this.f292926b;
        if (aVar == null) {
            return false;
        }
        return aVar.f();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            if (!k()) {
                return;
            }
            a aVar = this.f292926b;
            if (aVar != null && !aVar.f()) {
                return;
            }
            this.f292928d.reopen();
        } catch (Throwable th5) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "reopen error:" + th5.toString());
        }
    }

    public void n(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        try {
            Span u16 = u(bVar.b(), null);
            if (u16 == null) {
                return;
            }
            Map<String, String> c16 = bVar.c();
            if (c16 != null) {
                for (Map.Entry<String, String> entry : c16.entrySet()) {
                    u16.setAttribute(entry.getKey(), entry.getValue());
                }
                u16.setAttribute(MosaicConstants$JsProperty.PROP_ENV, this.f292931g);
            }
            a(u16);
        } catch (Throwable th5) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "report error:" + th5.toString());
        }
    }

    public void o(Span span, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) span, (Object) bVar);
            return;
        }
        if (span != null && bVar != null) {
            try {
                AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
                Map<String, String> c16 = bVar.c();
                if (c16 != null) {
                    for (Map.Entry<String, String> entry : c16.entrySet()) {
                        a16.put(entry.getKey(), entry.getValue());
                    }
                }
                span.addEvent(bVar.b(), a16.build());
            } catch (Throwable th5) {
                QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "report error:" + th5.toString());
            }
        }
    }

    public void p(com.tencent.mobileqq.tianjige.external.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
            return;
        }
        OpenTelemetry openTelemetry = this.f292927c;
        if (openTelemetry != null && this.f292928d != null) {
            aVar.a(openTelemetry.getTracer(BuildConfig.LIBRARY_PACKAGE_NAME, this.f292926b.a()));
        }
    }

    public void q(Span span, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) span, (Object) map);
            return;
        }
        if (span != null && map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    span.setAttribute(entry.getKey(), entry.getValue());
                }
                span.setAttribute(MosaicConstants$JsProperty.PROP_ENV, this.f292931g);
            } catch (Exception e16) {
                QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "setAttribute error:" + e16.toString());
            }
        }
    }

    public void s(Span span, StatusCode statusCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) span, (Object) statusCode);
            return;
        }
        if (span == null) {
            return;
        }
        try {
            span.setStatus(statusCode);
        } catch (Exception e16) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "setStatusCode error:" + e16.toString());
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            if (!k()) {
                return;
            }
            a aVar = this.f292926b;
            if (aVar != null && !aVar.f()) {
                return;
            }
            this.f292928d.shutdown();
        } catch (Throwable th5) {
            QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "shutdown error:" + th5.toString());
        }
    }

    public Span u(String str, Span span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Span) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) span);
        }
        return v(str, "", span);
    }

    public Span v(String str, String str2, Span span) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Span) iPatchRedirector.redirect((short) 7, this, str, str2, span);
        }
        OpenTelemetry openTelemetry = this.f292927c;
        if (openTelemetry != null && this.f292928d != null) {
            try {
                Tracer tracer = openTelemetry.getTracer(BuildConfig.LIBRARY_PACKAGE_NAME, this.f292926b.a());
                if (!TextUtils.isEmpty(str2)) {
                    AttributeResource.addAttributes(com.tencent.opentelemetry.api.common.f.c(com.tencent.opentelemetry.api.common.e.h("service.name"), str2));
                    this.f292928d.setResource(AttributeResource.buildResource());
                }
                SpanBuilder spanKind = tracer.spanBuilder(str).setSpanKind(SpanKind.CLIENT);
                if (span != null) {
                    return spanKind.setParent(com.tencent.opentelemetry.context.e.k().with(span)).startSpan();
                }
                return spanKind.startSpan();
            } catch (Throwable th5) {
                QLog.e("QQOpenTelemetry.OpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
            }
        }
        return null;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            l(str2, th5);
        } else {
            iPatchRedirector.redirect((short) 23, this, str, str2, th5);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, this, str, str2, th5);
    }

    public void w(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
        } else {
            if (attributes == null || this.f292928d == null) {
                return;
            }
            AttributeResource.addAttributes(attributes);
            this.f292928d.setResource(AttributeResource.buildResource());
        }
    }
}
