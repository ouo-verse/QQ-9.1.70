package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TlsUtil {
    static IPatchRedirector $redirector_;

    TlsUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SSLSocketFactory sslSocketFactory(TrustManager trustManager) throws SSLException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{trustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e16) {
            throw new SSLException("Could not set trusted certificates for TLS connection, are they valid X.509 in PEM format?", e16);
        }
    }

    public static X509TrustManager trustManager(byte[] bArr) throws SSLException {
        Objects.requireNonNull(bArr, "trustedCertificatesPem");
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            int i3 = 0;
            while (byteArrayInputStream.available() > 0) {
                keyStore.setCertificateEntry("cert_" + i3, (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream));
                i3++;
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e16) {
            throw new SSLException("Could not build TrustManagerFactory from trustedCertificatesPem.", e16);
        }
    }
}
