package com.tencent.opentelemetry.otlp.logging;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.otlp.common.JsonLogRecordAdapter;
import com.tencent.opentelemetry.otlp.common.OkHttpExporter;
import com.tencent.opentelemetry.otlp.common.OtlpHttpExecutorService;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import com.tencent.opentelemetry.sdk.logs.export.LogExporter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import okhttp3.Headers;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpJsonLogExporter implements LogExporter {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private final OkHttpExporter delegate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            TAG = OtlpHttpJsonLogExporter.class.getSimpleName();
        }
    }

    public OtlpHttpJsonLogExporter(OkHttpExporter okHttpExporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) okHttpExporter);
        } else {
            this.delegate = okHttpExporter;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode export(Collection<LogData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this, (Object) collection);
        }
        CompletableResultCode completableResultCode = new CompletableResultCode();
        if (collection != null && !collection.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resource_logs", JsonLogRecordAdapter.toProtoResourceLogs(collection));
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
                    DefaultPrintLogger.e(TAG, "Failed to export logging", th5);
                }
                completableResultCode.fail();
                return completableResultCode;
            }
        }
        return completableResultCode.succeed();
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.logs.export.LogExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.delegate.shutdown();
    }
}
