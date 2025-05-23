package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OtlpHttpNetworkInterceptor implements Interceptor {
    static IPatchRedirector $redirector_;
    private static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            TAG = OtlpHttpNetworkInterceptor.class.getName();
        }
    }

    public OtlpHttpNetworkInterceptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String getRequestBody(Request request) {
        RequestBody body;
        if (request == null || (body = request.body()) == null) {
            return "";
        }
        try {
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            return buffer.readString(Charset.forName("utf-8"));
        } catch (IOException e16) {
            if (!DefaultPrintLogger.isDebug()) {
                return "";
            }
            DefaultPrintLogger.e(TAG, "OtlpHttpNetworkInterceptor getRequestBody e:", e16);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e6  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        String str;
        String str2;
        Exception exc;
        Response response;
        String str3;
        String str4;
        String format;
        Request request;
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Response) iPatchRedirector.redirect((short) 2, (Object) this, (Object) chain);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str5 = null;
        try {
            request = chain.request();
            str3 = request.url().getUrl();
        } catch (Exception e16) {
            exc = e16;
            response = null;
            str = null;
            str3 = null;
        } catch (Throwable th5) {
            th = th5;
            str = null;
            str2 = null;
            String valueOf2 = String.valueOf(System.currentTimeMillis() - currentTimeMillis);
            if (DefaultPrintLogger.isDebug()) {
            }
            throw th;
        }
        try {
            try {
                getRequestBody(request);
                Response proceed = chain.proceed(request);
                try {
                    str2 = proceed.body().string();
                    try {
                        str5 = String.valueOf(proceed.code());
                        response = proceed.newBuilder().body(ResponseBody.create(proceed.body().get$contentType(), str2)).build();
                        valueOf = String.valueOf(System.currentTimeMillis() - currentTimeMillis);
                    } catch (Exception e17) {
                        exc = e17;
                        response = proceed;
                        str = str5;
                        str5 = str2;
                        try {
                            if (DefaultPrintLogger.isDebug()) {
                                DefaultPrintLogger.e(TAG, "OtlpHttpNetworkInterceptor intercept e:", exc);
                            }
                            String valueOf3 = String.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            if (DefaultPrintLogger.isDebug()) {
                                str4 = TAG;
                                format = String.format("responseTime= %s, requestUrl= %s, responseCode= %s, result= %s", valueOf3, str3, str, str5);
                                DefaultPrintLogger.d(str4, format);
                            }
                            return response;
                        } catch (Throwable th6) {
                            th = th6;
                            str2 = str5;
                            str5 = str3;
                            String valueOf22 = String.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            if (DefaultPrintLogger.isDebug()) {
                                DefaultPrintLogger.d(TAG, String.format("responseTime= %s, requestUrl= %s, responseCode= %s, result= %s", valueOf22, str5, str, str2));
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        str = str5;
                        str5 = str3;
                        String valueOf222 = String.valueOf(System.currentTimeMillis() - currentTimeMillis);
                        if (DefaultPrintLogger.isDebug()) {
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    exc = e18;
                    response = proceed;
                    str = null;
                }
            } catch (Exception e19) {
                exc = e19;
                response = null;
                str = null;
            }
            if (DefaultPrintLogger.isDebug()) {
                str4 = TAG;
                format = String.format("responseTime= %s, requestUrl= %s, responseCode= %s, result= %s", valueOf, str3, str5, str2);
                DefaultPrintLogger.d(str4, format);
            }
            return response;
        } catch (Throwable th8) {
            th = th8;
            str = null;
            str2 = null;
        }
    }
}
