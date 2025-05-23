package com.tencent.mobileqq.tianjige.metric;

import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.config.ConfigConstants;
import com.tencent.opentelemetry.api.logging.IPrinterLogger;
import com.tencent.opentelemetry.api.metrics.DoubleHistogram;
import com.tencent.opentelemetry.api.metrics.LongCounter;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.opentelemetry.otlp.metrics.OtlpHttpJsonMetricExporter;
import com.tencent.opentelemetry.otlp.metrics.OtlpHttpJsonMetricExporterBuilder;
import com.tencent.opentelemetry.sdk.metrics.Aggregation;
import com.tencent.opentelemetry.sdk.metrics.InstrumentSelector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.SdkMeterProvider;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.export.PeriodicMetricReaderBuilder;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramUtils;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import mqq.app.MainService;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements IPrinterLogger {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static String f292987g;

    /* renamed from: h, reason: collision with root package name */
    public static String f292988h;

    /* renamed from: i, reason: collision with root package name */
    public static String f292989i;

    /* renamed from: a, reason: collision with root package name */
    private int f292990a;

    /* renamed from: b, reason: collision with root package name */
    private long f292991b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.tianjige.a f292992c;

    /* renamed from: d, reason: collision with root package name */
    private SdkMeterProvider f292993d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f292994e;

    /* renamed from: f, reason: collision with root package name */
    private AttributesBuilder f292995f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f292996a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43764);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[InstrumentType.values().length];
            f292996a = iArr;
            try {
                iArr[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f292996a[InstrumentType.OBSERVABLE_UP_DOWN_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f292996a[InstrumentType.COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f292996a[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f292996a[InstrumentType.HISTOGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        f292987g = "ipv4";
        f292988h = "normal_network";
        f292989i = "wifi";
    }

    public h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f292991b = 0L;
        this.f292990a = i3;
        this.f292995f = com.tencent.opentelemetry.api.common.f.a();
    }

    private SdkMeterProvider g(Aggregation aggregation) {
        OtlpHttpJsonMetricExporter build = new OtlpHttpJsonMetricExporterBuilder().setEndpoint(ConfigConstants.DEFAULT_METRIC_SERVICE_ADDRESS).addHeader(ConfigConstants.TENANT_KEY, this.f292992c.c()).setCompression("gzip").setOkHttpUpload("OkHttp").setAggregationTemporality(new Function() { // from class: com.tencent.mobileqq.tianjige.metric.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                AggregationTemporality o16;
                o16 = h.o((InstrumentType) obj);
                return o16;
            }
        }).build();
        if (aggregation == null) {
            aggregation = com.tencent.opentelemetry.sdk.metrics.b.d(ExplicitBucketHistogramUtils.DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES);
        }
        SdkMeterProvider build2 = SdkMeterProvider.builder().setResource(Resource.create(this.f292995f.build())).registerView(InstrumentSelector.builder().setType(InstrumentType.COUNTER).setName("counter").build(), View.builder().setAggregation(com.tencent.opentelemetry.sdk.metrics.b.f()).setAttributesProcessor(AttributesProcessor.noop()).appendAllBaggageAttributes().build()).registerView(InstrumentSelector.builder().setType(InstrumentType.HISTOGRAM).setName("*").build(), View.builder().setAggregation(aggregation).setAttributesProcessor(AttributesProcessor.noop()).appendAllBaggageAttributes().build()).registerMetricReader(new PeriodicMetricReaderBuilder(build).setInterval(10000L, TimeUnit.MILLISECONDS).build()).build();
        QLog.i("MetricRecorder", 1, "init metric success");
        return build2;
    }

    private void h(com.tencent.mobileqq.tianjige.a aVar) {
        try {
            if (!n(aVar)) {
                return;
            }
            this.f292992c = aVar;
            if (!aVar.f()) {
                return;
            }
            q(this.f292992c);
            j();
        } catch (Throwable th5) {
            QLog.e("MetricRecorder", 1, "init error:" + th5.toString());
        }
    }

    private void j() {
        this.f292993d = g(null);
    }

    private LongCounter k(String str, String str2, String str3) {
        if (m() && this.f292993d != null) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("MetricRecorder", 1, "innerCreateCounter error: metricName empty");
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "1";
            }
            return this.f292993d.meterBuilder("qq_app_meter_counter").setInstrumentationVersion("1.0.0").build().counterBuilder(str).setDescription(str2).setUnit(str3).build();
        }
        QLog.e("MetricRecorder", 1, "innerCreateCounter error: invalid condition");
        return null;
    }

    private DoubleHistogram l(String str, String str2, String str3, Double[] dArr) {
        Aggregation d16;
        if (!m()) {
            QLog.e("MetricRecorder", 1, "innerCreateHistogram error: invalid condition");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("MetricRecorder", 1, "innerCreateHistogram error: metricName empty");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "ms";
        }
        if (dArr != null) {
            try {
                d16 = com.tencent.opentelemetry.sdk.metrics.b.d(Collections.unmodifiableList(Arrays.asList(dArr)));
            } catch (Exception e16) {
                QLog.e("MetricRecorder", 1, "innerCreateHistogram error: " + e16);
                return null;
            }
        } else {
            d16 = null;
        }
        return g(d16).meterBuilder("qq_app_meter_histogram").setInstrumentationVersion("1.0.0").build().histogramBuilder(str).setDescription(str2).setUnit(str3).build();
    }

    private boolean n(com.tencent.mobileqq.tianjige.a aVar) {
        if (aVar != null && this.f292993d == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AggregationTemporality o(InstrumentType instrumentType) {
        int i3 = a.f292996a[instrumentType.ordinal()];
        if (i3 != 1 && i3 != 2) {
            return AggregationTemporality.DELTA;
        }
        return AggregationTemporality.CUMULATIVE;
    }

    private void p(String str, Throwable th5) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f292991b < 10000) {
                return;
            }
            this.f292991b = currentTimeMillis;
            QLog.e("MetricRecorder", 1, str, th5);
        } catch (Exception e16) {
            QLog.e("MetricRecorder", 1, "printTJGMetricError: " + e16);
        }
    }

    private void q(com.tencent.mobileqq.tianjige.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            this.f292995f.put(ConfigConstants.CONSTANT_TENANT_ID_KEY, aVar.c()).put(ConfigConstants.CONSTANT_TENANT_NAME_KEY, aVar.c()).put("dev_model", com.tencent.mobileqq.tianjige.g.b().c()).put("dev_brand", com.tencent.mobileqq.tianjige.g.b().a());
        } catch (Throwable th5) {
            QLog.e("MetricRecorder", 1, "setAttributeResource error:" + th5);
        }
    }

    private void r(com.tencent.mobileqq.tianjige.a aVar) {
        if (aVar == null) {
            this.f292994e = false;
        } else {
            this.f292994e = aVar.f();
        }
    }

    public static void t(FromServiceMsg fromServiceMsg) {
        String str;
        String str2;
        String str3;
        if (fromServiceMsg == null) {
            return;
        }
        Object attribute = fromServiceMsg.getAttribute(MainService.TO_SERVICE_MSG_AFTER_SENT);
        if (!(attribute instanceof ToServiceMsg)) {
            return;
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) attribute;
        Boolean bool = Boolean.FALSE;
        if (((Boolean) toServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue()) {
            str = "bad_network";
        } else {
            str = "normal_network";
        }
        f292988h = str;
        if (((String) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IP_FAMILY, "")).equals("IPv4")) {
            str2 = "ipv4";
        } else {
            str2 = "ipv6";
        }
        f292987g = str2;
        if (((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IS_WIFI, bool)).booleanValue()) {
            str3 = "wifi";
        } else {
            str3 = DeviceType.DeviceCategory.MOBILE;
        }
        f292989i = str3;
    }

    public com.tencent.mobileqq.tianjige.metric.a b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.tianjige.metric.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return c(str, str, "1");
    }

    public com.tencent.mobileqq.tianjige.metric.a c(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.tianjige.metric.a) iPatchRedirector.redirect((short) 4, this, str, str2, str3);
        }
        return com.tencent.mobileqq.tianjige.metric.a.d(k(str, str2, str3), str, str2, str3);
    }

    public void d(String str, String str2, String str3, Consumer<ObservableDoubleMeasurement> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, consumer);
            return;
        }
        if (m() && this.f292993d != null) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("MetricRecorder", 1, "innerCreateCounter error: metricName empty");
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "1";
            }
            this.f292993d.meterBuilder("qq_app_meter_gauge").setInstrumentationVersion("1.0.0").build().gaugeBuilder(str).setDescription(str2).setUnit(str3).buildWithCallback(consumer);
            return;
        }
        QLog.e("MetricRecorder", 1, "innerCreateCounter error: invalid condition");
    }

    public d e(String str, String str2, String str3, Double[] dArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? d.a(l(str, str2, str3, dArr), str, str2, str3) : (d) iPatchRedirector.redirect((short) 6, this, str, str2, str3, dArr);
    }

    public d f(String str, Double[] dArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) dArr);
        }
        return e(str, str, "ms", dArr);
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
        } else if (AppSetting.u()) {
            QLog.i("MetricRecorder", 4, str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public boolean isColorLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    /* renamed from: isDebug */
    public boolean getIsDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return SSODebugUtil.isTestEnv();
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f292994e;
    }

    public void s(com.tencent.mobileqq.tianjige.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            h(aVar);
            r(aVar);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
        } else if (AppSetting.u()) {
            QLog.w("MetricRecorder", 4, str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            p(str2, null);
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, th5);
        } else if (AppSetting.u()) {
            QLog.w("MetricRecorder", 4, str2, th5);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            p(str2, th5);
        } else {
            iPatchRedirector.redirect((short) 17, this, str, str2, th5);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        } else if (AppSetting.u()) {
            QLog.d("MetricRecorder", 4, str2);
        }
    }
}
