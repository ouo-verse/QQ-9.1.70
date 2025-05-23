package com.tencent.mobileqq.minigame.api.http;

import com.tencent.mobileqq.minigame.utils.GameLog;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CustomX509TrustManager implements X509TrustManager {
    public static final String MINIGAME_TAG = "[minigame] CustomX509TrustManager";
    X509TrustManager sunJSSEX509TrustManager;

    /* JADX WARN: Removed duplicated region for block: B:10:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    CustomX509TrustManager() throws Exception {
        KeyStore keyStore;
        FileInputStream fileInputStream;
        Throwable th5;
        Exception e16;
        GameLog gameLog;
        StringBuilder sb5;
        try {
            keyStore = KeyStore.getInstance("JKS");
        } catch (Exception e17) {
            GameLog.getInstance().e(MINIGAME_TAG, "[CustomX509TrustManager] KeyStore.getInstance Exception:" + e17.toString());
            keyStore = null;
        }
        TrustManager[] trustManagerArr = new TrustManager[0];
        if (keyStore != null) {
            try {
                fileInputStream = new FileInputStream("trustedCerts");
            } catch (Exception e18) {
                fileInputStream = null;
                e16 = e18;
            } catch (Throwable th6) {
                fileInputStream = null;
                th5 = th6;
                if (fileInputStream != null) {
                }
                throw th5;
            }
            try {
                try {
                    keyStore.load(fileInputStream, "passphrase".toCharArray());
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                    trustManagerFactory.init(keyStore);
                    trustManagerArr = trustManagerFactory.getTrustManagers();
                    fileInputStream.close();
                    try {
                        fileInputStream.close();
                    } catch (Exception e19) {
                        e = e19;
                        gameLog = GameLog.getInstance();
                        sb5 = new StringBuilder();
                        sb5.append("[CustomX509TrustManager] in.close Exception:");
                        sb5.append(e.toString());
                        gameLog.e(MINIGAME_TAG, sb5.toString());
                        while (r4 < trustManagerArr.length) {
                        }
                        throw new Exception("Couldn't initialize");
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e26) {
                            GameLog.getInstance().e(MINIGAME_TAG, "[CustomX509TrustManager] in.close Exception:" + e26.toString());
                        }
                    }
                    throw th5;
                }
            } catch (Exception e27) {
                e16 = e27;
                GameLog.getInstance().e(MINIGAME_TAG, "[CustomX509TrustManager] getTrustManagers Exception:" + e16.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e28) {
                        e = e28;
                        gameLog = GameLog.getInstance();
                        sb5 = new StringBuilder();
                        sb5.append("[CustomX509TrustManager] in.close Exception:");
                        sb5.append(e.toString());
                        gameLog.e(MINIGAME_TAG, sb5.toString());
                        while (r4 < trustManagerArr.length) {
                        }
                        throw new Exception("Couldn't initialize");
                    }
                }
                while (r4 < trustManagerArr.length) {
                }
                throw new Exception("Couldn't initialize");
            }
        } else {
            TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory2.init((KeyStore) null);
            trustManagerArr = trustManagerFactory2.getTrustManagers();
        }
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                this.sunJSSEX509TrustManager = (X509TrustManager) trustManager;
                return;
            }
        }
        throw new Exception("Couldn't initialize");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.sunJSSEX509TrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.sunJSSEX509TrustManager.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.sunJSSEX509TrustManager.getAcceptedIssuers();
    }
}
