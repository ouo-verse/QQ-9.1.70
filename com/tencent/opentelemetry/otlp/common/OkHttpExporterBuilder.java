package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.metrics.MeterProvider;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OkHttpExporterBuilder {
    static IPatchRedirector $redirector_ = null;
    public static final long DEFAULT_TIMEOUT_SECS = 30;
    private boolean compressionEnabled;
    private String endpoint;

    @Nullable
    private Headers.Builder headersBuilder;
    private MeterProvider meterProvider;
    private boolean okHttpUploadEnabled;
    private long timeoutNanos;

    @Nullable
    private byte[] trustedCertificatesPem;
    private final String type;

    public OkHttpExporterBuilder(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.timeoutNanos = TimeUnit.SECONDS.toNanos(30L);
        this.compressionEnabled = false;
        this.okHttpUploadEnabled = false;
        this.meterProvider = com.tencent.opentelemetry.api.metrics.a.c();
        this.type = str;
        this.endpoint = str2;
    }

    public OkHttpExporterBuilder addHeader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        if (this.headersBuilder == null) {
            this.headersBuilder = new Headers.Builder();
        }
        this.headersBuilder.add(str, str2);
        return this;
    }

    public OkHttpExporter build() {
        Headers build;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (OkHttpExporter) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder connectTimeout = new OkHttpClient.Builder().readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).connectionPool(new ConnectionPool(30, 60000L, timeUnit)).retryOnConnectionFailure(true).connectTimeout(30000L, timeUnit);
        byte[] bArr = this.trustedCertificatesPem;
        if (bArr != null) {
            try {
                X509TrustManager trustManager = TlsUtil.trustManager(bArr);
                connectTimeout.sslSocketFactory(TlsUtil.sslSocketFactory(trustManager), trustManager);
            } catch (SSLException e16) {
                throw new IllegalStateException("Could not set trusted certificate for OTLP HTTP connection, are they valid X.509 in PEM format?", e16);
            }
        } else {
            try {
                connectTimeout.sslSocketFactory(new OtlpHttpSSLSocketFactory(), new OtlpHttpX509TrustManager());
            } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException e17) {
                throw new IllegalStateException("Could not set trusted certificate for OTLP HTTP connection, are they valid X.509 in PEM format?", e17);
            }
        }
        Headers.Builder builder = this.headersBuilder;
        if (builder == null) {
            build = null;
        } else {
            build = builder.build();
        }
        return new OkHttpExporter(this.type, connectTimeout.build(), this.meterProvider, this.endpoint, build, this.compressionEnabled, this.okHttpUploadEnabled);
    }

    public OkHttpExporterBuilder setCompression(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (str.equals("gzip")) {
            this.compressionEnabled = true;
        }
        return this;
    }

    public OkHttpExporterBuilder setEndpoint(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        try {
            URI uri = new URI(str);
            if (uri.getScheme() != null && (uri.getScheme().equals("http") || uri.getScheme().equals("https"))) {
                this.endpoint = str;
                return this;
            }
            throw new IllegalArgumentException("Invalid endpoint, must start with http:// or https://: " + uri);
        } catch (URISyntaxException e16) {
            throw new IllegalArgumentException("Invalid endpoint, must be a URL: " + str, e16);
        }
    }

    public OkHttpExporterBuilder setMeterProvider(MeterProvider meterProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) meterProvider);
        }
        this.meterProvider = meterProvider;
        return this;
    }

    public OkHttpExporterBuilder setOkHttpUpload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (str.equals("OkHttp")) {
            this.okHttpUploadEnabled = true;
        }
        return this;
    }

    public OkHttpExporterBuilder setTimeout(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        this.timeoutNanos = timeUnit.toNanos(j3);
        return this;
    }

    public OkHttpExporterBuilder setTrustedCertificates(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
        }
        this.trustedCertificatesPem = bArr;
        return this;
    }

    public OkHttpExporterBuilder setTimeout(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? setTimeout(j3, TimeUnit.NANOSECONDS) : (OkHttpExporterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, j3);
    }
}
