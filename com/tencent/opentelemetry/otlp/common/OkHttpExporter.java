package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.MeterProvider;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OkHttpExporter {
    static IPatchRedirector $redirector_;
    private final OkHttpClient client;
    private final boolean compressionEnabled;
    public final String endpoint;
    private final OkHttpExporterMetrics exporterMetrics;

    @Nullable
    public final Headers headers;
    public final boolean okHttpUploadEnabled;
    private final String type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpExporter(String str, OkHttpClient okHttpClient, MeterProvider meterProvider, String str2, @Nullable Headers headers, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, okHttpClient, meterProvider, str2, headers, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.type = str;
        this.client = okHttpClient;
        this.endpoint = str2;
        this.headers = headers;
        this.compressionEnabled = z16;
        this.okHttpUploadEnabled = z17;
        this.exporterMetrics = OkHttpExporterMetrics.createHttpJson(str, meterProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeResponse(Response response) {
        if (response != null) {
            try {
                if (response.body() != null) {
                    response.body().close();
                }
            } catch (Throwable th5) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(this.type, "close response failed, e", th5);
                }
            }
        }
    }

    private static RequestBody gzipRequestBody(RequestBody requestBody) {
        return new RequestBody() { // from class: com.tencent.opentelemetry.otlp.common.OkHttpExporter.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RequestBody.this);
                }
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
                }
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* renamed from: contentType */
            public MediaType getContentType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (MediaType) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return RequestBody.this.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) bufferedSink);
                    return;
                }
                BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                RequestBody.this.writeTo(buffer);
                buffer.close();
            }
        };
    }

    public CompletableResultCode export(JSONObject jSONObject, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject, i3);
        }
        this.exporterMetrics.addSeen(i3);
        if (DefaultPrintLogger.isDebug()) {
            DefaultPrintLogger.i(this.type, "requestJson:" + jSONObject.toString() + "\n");
        }
        RequestBody create = RequestBody.create((MediaType) null, jSONObject.toString());
        Request.Builder url = new Request.Builder().url(this.endpoint);
        Headers headers = this.headers;
        if (headers != null) {
            url.headers(headers);
        }
        url.header("Content-Type", "application/json");
        if (this.compressionEnabled) {
            url.addHeader("Content-Encoding", "gzip");
            url.post(gzipRequestBody(create));
        } else {
            url.post(create);
        }
        CompletableResultCode completableResultCode = new CompletableResultCode();
        this.client.newCall(url.build()).enqueue(new Callback(i3, completableResultCode) { // from class: com.tencent.opentelemetry.otlp.common.OkHttpExporter.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$numItems;
            final /* synthetic */ CompletableResultCode val$result;

            {
                this.val$numItems = i3;
                this.val$result = completableResultCode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, OkHttpExporter.this, Integer.valueOf(i3), completableResultCode);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) call, (Object) iOException);
                    return;
                }
                OkHttpExporter.this.exporterMetrics.addFailed(this.val$numItems);
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(OkHttpExporter.this.type, "Failed to export " + OkHttpExporter.this.type + "s. The request could not be executed. Full error message:", iOException);
                }
                this.val$result.fail();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) call, (Object) response);
                    return;
                }
                int code = response.code();
                if (!response.isSuccessful()) {
                    OkHttpExporter.this.closeResponse(response);
                    OkHttpExporter.this.exporterMetrics.addFailed(this.val$numItems);
                    if (DefaultPrintLogger.isDebug()) {
                        DefaultPrintLogger.e(OkHttpExporter.this.type, "Failed to export " + OkHttpExporter.this.type + "s. Server responded with HTTP status code " + code);
                    }
                    this.val$result.fail();
                    return;
                }
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.d(OkHttpExporter.this.type, "export success. responseCode=" + code);
                }
                OkHttpExporter.this.closeResponse(response);
                OkHttpExporter.this.exporterMetrics.addSuccess(this.val$numItems);
                this.val$result.succeed();
            }
        });
        return completableResultCode;
    }

    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CompletableResultCode ofSuccess = CompletableResultCode.ofSuccess();
        this.client.dispatcher().cancelAll();
        this.client.dispatcher().executorService().shutdownNow();
        this.client.connectionPool().evictAll();
        return ofSuccess;
    }
}
