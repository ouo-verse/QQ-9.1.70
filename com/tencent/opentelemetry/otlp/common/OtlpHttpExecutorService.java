package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.function.BiConsumer;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpExecutorService {
    static IPatchRedirector $redirector_;
    static ExecutorService executorService;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            executorService = ProxyExecutors.newCachedThreadPool();
        }
    }

    public OtlpHttpExecutorService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static CompletableResultCode export(final String str, final String str2, final Map<String, String> map, final String str3) {
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        try {
            return (CompletableResultCode) executorService.submit(new Callable() { // from class: com.tencent.opentelemetry.otlp.common.v
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    CompletableResultCode lambda$export$0;
                    lambda$export$0 = OtlpHttpExecutorService.lambda$export$0(str2, map, str3, str, completableResultCode);
                    return lambda$export$0;
                }
            }).get();
        } catch (Throwable th5) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e(str, "Failed to export", th5);
            }
            completableResultCode.fail();
            return completableResultCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletableResultCode lambda$export$0(String str, Map map, String str2, String str3, CompletableResultCode completableResultCode) throws Exception {
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        Objects.requireNonNull(httpsURLConnection);
        map.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.w
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                httpsURLConnection.setRequestProperty((String) obj, (String) obj2);
            }
        });
        httpsURLConnection.setSSLSocketFactory(new OtlpHttpSSLSocketFactory());
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("content-type", "application/json");
        httpsURLConnection.setRequestProperty("Connection", "keep-alive");
        httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        httpsURLConnection.setChunkedStreamingMode(str2.length());
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setReadTimeout(30000);
        httpsURLConnection.setConnectTimeout(30000);
        if (DefaultPrintLogger.isDebug()) {
            DefaultPrintLogger.i(str3, "requestJson:" + str2 + "\n");
        }
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        try {
            byte[] bytes = str2.getBytes();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.flush();
            outputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.i(str3, "responseCode: " + responseCode);
            }
            if (responseCode == 200) {
                completableResultCode.succeed();
            } else {
                completableResultCode.fail();
            }
            return completableResultCode;
        } catch (Throwable th5) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }
}
