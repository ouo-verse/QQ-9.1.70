package com.tencent.mobileqq.teamwork;

import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements X509TrustManager {

    /* renamed from: a, reason: collision with root package name */
    X509TrustManager f292116a;

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (r6 == null) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c() throws Exception {
        KeyStore keyStore;
        FileInputStream fileInputStream;
        Exception e16;
        FileInputStream fileInputStream2 = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
        } catch (Exception e17) {
            QLog.e("CustomX509TrustManager", 1, "CustomX509TrustManager KeyStore exp: " + e17.toString());
            keyStore = null;
        }
        TrustManager[] trustManagerArr = new TrustManager[0];
        if (keyStore != null) {
            try {
                fileInputStream = new FileInputStream("trustedCerts");
            } catch (Exception e18) {
                fileInputStream = null;
                e16 = e18;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    keyStore.load(fileInputStream, "passphrase".toCharArray());
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                    trustManagerFactory.init(keyStore);
                    trustManagerArr = trustManagerFactory.getTrustManagers();
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e16 = e19;
                QLog.e("CustomX509TrustManager", 1, "CustomX509TrustManager exp: " + e16.toString());
            }
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
        } else {
            TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory2.init((KeyStore) null);
            trustManagerArr = trustManagerFactory2.getTrustManagers();
        }
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                this.f292116a = (X509TrustManager) trustManager;
                return;
            }
        }
        throw new Exception("Couldn't initialize");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f292116a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f292116a.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.f292116a.getAcceptedIssuers();
    }
}
