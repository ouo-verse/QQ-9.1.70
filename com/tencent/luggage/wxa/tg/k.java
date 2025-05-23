package com.tencent.luggage.wxa.tg;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            h.a(3, "SSLUtil", "checkClientTrusted");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (com.tencent.luggage.wxa.og.a.a().n()) {
                int i3 = 0;
                while (i3 < x509CertificateArr.length) {
                    X509Certificate x509Certificate = x509CertificateArr[i3];
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(" Server certificate ");
                    i3++;
                    sb5.append(i3);
                    sb5.append(":");
                    h.a(3, "SSLUtil", sb5.toString());
                    h.a(3, "SSLUtil", "  Subject DN: " + x509Certificate.getSubjectX500Principal());
                    h.a(3, "SSLUtil", "  Issuer DN: " + x509Certificate.getIssuerX500Principal());
                    h.a(3, "SSLUtil", "  Signature Algorithm: " + x509Certificate.getSigAlgName());
                    h.a(3, "SSLUtil", "  Valid from: " + x509Certificate.getNotBefore());
                    h.a(3, "SSLUtil", "  Valid until: " + x509Certificate.getNotAfter());
                    h.a(3, "SSLUtil", "  Serial #: " + x509Certificate.getSerialNumber().toString(16));
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            h.a(3, "SSLUtil", "verifying " + str);
            return true;
        }
    }

    public static boolean a(HttpsURLConnection httpsURLConnection) {
        TrustManager[] trustManagerArr = {new a()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(new b());
            return true;
        } catch (Exception e16) {
            h.a(6, "SSLUtil", "disableSSLCertVerify failed " + e16);
            return false;
        }
    }
}
