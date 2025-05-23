package com.tencent.opentelemetry.otlp.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.Utils;
import com.tencent.opentelemetry.otlp.common.OkHttpExporterBuilder;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpJsonSpanExporterBuilder {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_ENDPOINT = "https://tpstelemetry.tencent.com/v1/trace";
    private final OkHttpExporterBuilder delegate;

    public OtlpHttpJsonSpanExporterBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.delegate = new OkHttpExporterBuilder("traces", "https://tpstelemetry.tencent.com/v1/trace");
        }
    }

    public OtlpHttpJsonSpanExporterBuilder addHeader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (OtlpHttpJsonSpanExporterBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        this.delegate.addHeader(str, str2);
        return this;
    }

    public OtlpHttpJsonSpanExporter build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (OtlpHttpJsonSpanExporter) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new OtlpHttpJsonSpanExporter(this.delegate.build());
    }

    public OtlpHttpJsonSpanExporterBuilder setCompression(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OtlpHttpJsonSpanExporterBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
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

    public OtlpHttpJsonSpanExporterBuilder setEndpoint(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (OtlpHttpJsonSpanExporterBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "endpoint");
        this.delegate.setEndpoint(str);
        return this;
    }

    public OtlpHttpJsonSpanExporterBuilder setOkHttpUpload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (OtlpHttpJsonSpanExporterBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "okHttpMethod");
        this.delegate.setOkHttpUpload(str);
        return this;
    }

    public OtlpHttpJsonSpanExporterBuilder setTimeout(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OtlpHttpJsonSpanExporterBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j3 >= 0, "timeout must be non-negative");
        this.delegate.setTimeout(j3, timeUnit);
        return this;
    }

    public OtlpHttpJsonSpanExporterBuilder setTrustedCertificates(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (OtlpHttpJsonSpanExporterBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
        }
        this.delegate.setTrustedCertificates(bArr);
        return this;
    }

    public OtlpHttpJsonSpanExporterBuilder setTimeout(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? setTimeout(j3, TimeUnit.NANOSECONDS) : (OtlpHttpJsonSpanExporterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, j3);
    }
}
