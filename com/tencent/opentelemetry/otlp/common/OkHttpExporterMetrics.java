package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.metrics.LongCounter;
import com.tencent.opentelemetry.api.metrics.Meter;
import com.tencent.opentelemetry.api.metrics.MeterProvider;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OkHttpExporterMetrics {
    static IPatchRedirector $redirector_;
    private static final AttributeKey<Boolean> ATTRIBUTE_KEY_SUCCESS;
    private static final AttributeKey<String> ATTRIBUTE_KEY_TYPE;
    private final LongCounter exported;
    private final Attributes failedAttrs;
    private final LongCounter seen;
    private final Attributes seenAttrs;
    private final Attributes successAttrs;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            ATTRIBUTE_KEY_TYPE = com.tencent.opentelemetry.api.common.e.h("type");
            ATTRIBUTE_KEY_SUCCESS = com.tencent.opentelemetry.api.common.e.b("success");
        }
    }

    OkHttpExporterMetrics(Meter meter, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) meter, (Object) str);
            return;
        }
        Attributes build = com.tencent.opentelemetry.api.common.f.a().put((AttributeKey<AttributeKey<String>>) ATTRIBUTE_KEY_TYPE, (AttributeKey<String>) str).build();
        this.seenAttrs = build;
        this.seen = meter.counterBuilder("tpstelemetry_sdk_batch_process_counter_seen").build();
        this.exported = meter.counterBuilder("tpstelemetry_sdk_batch_process_counter").build();
        AttributesBuilder builder = build.toBuilder();
        AttributeKey<Boolean> attributeKey = ATTRIBUTE_KEY_SUCCESS;
        this.successAttrs = builder.put((AttributeKey<AttributeKey<Boolean>>) attributeKey, (AttributeKey<Boolean>) Boolean.TRUE).build();
        this.failedAttrs = build.toBuilder().put((AttributeKey<AttributeKey<Boolean>>) attributeKey, (AttributeKey<Boolean>) Boolean.FALSE).build();
    }

    public static OkHttpExporterMetrics createHttpJson(String str, MeterProvider meterProvider) {
        return new OkHttpExporterMetrics(meterProvider.get("tpstelemetry.exporters.otlp.http"), str);
    }

    public void addFailed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.exported.add(j3, this.failedAttrs);
        }
    }

    public void addSeen(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.seen.add(j3, this.seenAttrs);
        }
    }

    public void addSuccess(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.exported.add(j3, this.successAttrs);
        }
    }
}
