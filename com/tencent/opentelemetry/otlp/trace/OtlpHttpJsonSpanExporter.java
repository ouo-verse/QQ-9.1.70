package com.tencent.opentelemetry.otlp.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.otlp.common.JsonSpanAdapter;
import com.tencent.opentelemetry.otlp.common.OkHttpExporter;
import com.tencent.opentelemetry.otlp.common.OtlpHttpExecutorService;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import com.tencent.opentelemetry.sdk.trace.export.SpanExporter;
import com.tencent.opentelemetry.sdk.trace.export.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import okhttp3.Headers;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpJsonSpanExporter implements SpanExporter {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private final OkHttpExporter delegate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8488);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            TAG = OtlpHttpJsonSpanExporter.class.getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OtlpHttpJsonSpanExporter(OkHttpExporter okHttpExporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) okHttpExporter);
        } else {
            this.delegate = okHttpExporter;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this, (Object) collection);
        }
        CompletableResultCode completableResultCode = new CompletableResultCode();
        if (collection != null && !collection.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resource_spans", JsonSpanAdapter.toJsonResourceSpans(collection));
                OkHttpExporter okHttpExporter = this.delegate;
                if (!okHttpExporter.okHttpUploadEnabled) {
                    HashMap hashMap = new HashMap();
                    Headers headers = this.delegate.headers;
                    Objects.requireNonNull(headers);
                    for (String str : headers.names()) {
                        hashMap.put(str, this.delegate.headers.get(str));
                    }
                    return OtlpHttpExecutorService.export(TAG, this.delegate.endpoint, hashMap, jSONObject.toString());
                }
                return okHttpExporter.export(jSONObject, collection.size());
            } catch (Throwable th5) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.e(TAG, "Failed to export spans", th5);
                }
                completableResultCode.fail();
                return completableResultCode;
            }
        }
        return completableResultCode.succeed();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.delegate.shutdown();
    }
}
