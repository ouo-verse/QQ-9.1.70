package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.WebViewSSLCheckThread;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import java.security.cert.X509Certificate;

/* compiled from: P */
/* loaded from: classes2.dex */
public class WebViewSSLCheck {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37926a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, null, context, null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        String str2 = f37926a;
        g.c(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate a16 = com.huawei.secure.android.common.ssl.util.b.a(sslError.getCertificate());
        X509Certificate a17 = new j(context).a();
        g.a(str2, "checkServerCertificateNew: error certificate is : " + a16);
        if (com.huawei.secure.android.common.ssl.util.b.a(a17, a16)) {
            g.c(str2, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        g.b(str2, "checkServerCertificateNew: cancel");
        if (callback != null) {
            callback.onCancel(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return com.huawei.secure.android.common.ssl.util.b.a(x509Certificate, com.huawei.secure.android.common.ssl.util.b.a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(com.huawei.secure.android.common.ssl.util.b.a(str), sslError);
    }
}
