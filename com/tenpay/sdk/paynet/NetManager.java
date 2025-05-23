package com.tenpay.sdk.paynet;

import android.content.Context;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.NetBean;
import com.tenpay.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetManager {
    private static final String CONFIG_MODULE = "qwallet_cert";
    private static final int EEROR_CERT = 668816;
    private static final String TAG = "NetManager";
    private static NetManager manager;
    private SSLSocketFactory sslFactory = null;
    private final String tenReg = String.format("^[A-Za-z]+.%s", Cgi.TENPAY_DOMAIN);
    private final List<String> hostList = new ArrayList();

    /* renamed from: hv, reason: collision with root package name */
    private final HostnameVerifier f386919hv = new HostnameVerifier() { // from class: com.tenpay.sdk.paynet.NetManager.1
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            QwLog.i("hostname = " + str + " session = " + sSLSession);
            if (str == null) {
                return false;
            }
            if (NetManager.this.isIp(str) || str.matches(NetManager.this.tenReg)) {
                return true;
            }
            QwLog.i("verify no tenpay host..." + NetManager.this.hostList.size());
            return NetManager.this.hostList.contains(str);
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class TenTrustManager implements X509TrustManager {
        private X509TrustManager defTM;
        private List<X509TrustManager> localTmList;
        private final WeakReference<Context> mRefContext;

        public TenTrustManager(Context context, List<X509TrustManager> list) throws Exception {
            this.mRefContext = new WeakReference<>(context);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            this.defTM = NetManager.getX509Tm(trustManagerFactory.getTrustManagers());
            this.localTmList = list;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            QwLog.i("chain = " + x509CertificateArr + " authType = " + str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            QwLog.i("chain = " + x509CertificateArr.length + " authType = " + str);
            try {
                this.defTM.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                VACDReportUtil.a("QWalletStat", "cert.system.check", null, null, 0, "system cert error cerify.");
                int i3 = 0;
                for (int i16 = 0; i16 < this.localTmList.size(); i16++) {
                    try {
                        this.localTmList.get(i16).checkServerTrusted(x509CertificateArr, str);
                        break;
                    } catch (Exception unused2) {
                        i3++;
                    }
                }
                QwLog.i("excepCount = " + i3);
                if (i3 == this.localTmList.size()) {
                    QLog.e(NetManager.TAG, 1, "", new CertificateException("no certificate trusted..."));
                }
            }
            NetBean.mTLSEndTime = System.currentTimeMillis();
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            QwLog.i("get the accepted issues, if server check client.");
            return null;
        }
    }

    NetManager() {
        QwLog.i("creater...");
    }

    private static TrustManager[] genLocalTm(InputStream[] inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i3 = 0;
                int i16 = 0;
                while (i3 < length) {
                    InputStream inputStream = inputStreamArr[i3];
                    keyStore.setCertificateEntry(Integer.toString(i16), certificateFactory.generateCertificate(inputStream));
                    Utils.closeObject(inputStream);
                    i3++;
                    i16++;
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X509TrustManager getX509Tm(TrustManager[] trustManagerArr) {
        if (trustManagerArr != null) {
            for (TrustManager trustManager : trustManagerArr) {
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            return null;
        }
        return null;
    }

    public static NetManager instance() {
        NetManager netManager;
        synchronized (NetManager.class) {
            if (manager == null) {
                manager = new NetManager();
            }
            netManager = manager;
        }
        return netManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isIp(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (!(byName instanceof Inet4Address)) {
                if (!(byName instanceof Inet6Address)) {
                    return false;
                }
            }
            return true;
        } catch (UnknownHostException e16) {
            QLog.e(TAG, 1, "", e16);
            return false;
        }
    }

    public boolean addNameVerifyHost(HttpsURLConnection httpsURLConnection, String str) {
        httpsURLConnection.setHostnameVerifier(this.f386919hv);
        if (!this.hostList.contains(str) && !str.matches(this.tenReg) && this.hostList.add(str)) {
            return true;
        }
        return false;
    }

    public SSLSocketFactory getSSLFactory(Context context) {
        SSLSocketFactory sSLSocketFactory = this.sslFactory;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : TenpayCertificate.getCA()) {
                X509TrustManager x509Tm = getX509Tm(genLocalTm(new InputStream[]{new ByteArrayInputStream(str.getBytes())}));
                if (x509Tm != null) {
                    arrayList.add(x509Tm);
                }
            }
            if (arrayList.size() > 0) {
                TenTrustManager tenTrustManager = new TenTrustManager(context, arrayList);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{tenTrustManager}, new SecureRandom());
                SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                this.sslFactory = socketFactory;
                return socketFactory;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        return null;
    }
}
