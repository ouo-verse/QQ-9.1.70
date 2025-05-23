package com.tencent.oskplayer.util;

import com.tencent.oskplayer.PlayerConfig;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SSLUtil {
    static final String TAG = "SSLUtil";

    @Deprecated
    public static boolean disableSSLCertVerify(HttpsURLConnection httpsURLConnection) {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.tencent.oskplayer.util.SSLUtil.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                PlayerUtils.log(3, SSLUtil.TAG, "checkClientTrusted");
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                if (PlayerConfig.g().isDebugVersion()) {
                    int i3 = 0;
                    while (i3 < x509CertificateArr.length) {
                        X509Certificate x509Certificate = x509CertificateArr[i3];
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(" Server certificate ");
                        i3++;
                        sb5.append(i3);
                        sb5.append(":");
                        PlayerUtils.log(3, SSLUtil.TAG, sb5.toString());
                        PlayerUtils.log(3, SSLUtil.TAG, "  Subject DN: " + x509Certificate.getSubjectX500Principal());
                        PlayerUtils.log(3, SSLUtil.TAG, "  Issuer DN: " + x509Certificate.getIssuerX500Principal());
                        PlayerUtils.log(3, SSLUtil.TAG, "  Signature Algorithm: " + x509Certificate.getSigAlgName());
                        PlayerUtils.log(3, SSLUtil.TAG, "  Valid from: " + x509Certificate.getNotBefore());
                        PlayerUtils.log(3, SSLUtil.TAG, "  Valid until: " + x509Certificate.getNotAfter());
                        PlayerUtils.log(3, SSLUtil.TAG, "  Serial #: " + x509Certificate.getSerialNumber().toString(16));
                    }
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.tencent.oskplayer.util.SSLUtil.2
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    PlayerUtils.log(3, SSLUtil.TAG, "verifying " + str);
                    return true;
                }
            });
            return true;
        } catch (Exception e16) {
            PlayerUtils.log(6, TAG, "disableSSLCertVerify failed " + e16);
            return false;
        }
    }
}
