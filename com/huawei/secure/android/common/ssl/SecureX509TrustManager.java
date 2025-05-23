package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SecureX509TrustManager implements X509TrustManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f37918c = "SecureX509TrustManager";

    /* renamed from: d, reason: collision with root package name */
    public static final String f37919d = "hmsrootcas.bks";

    /* renamed from: e, reason: collision with root package name */
    private static final String f37920e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final String f37921f = "X509";

    /* renamed from: g, reason: collision with root package name */
    private static final String f37922g = "bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f37923h = "AndroidCAStore";

    /* renamed from: a, reason: collision with root package name */
    protected List<X509TrustManager> f37924a;

    /* renamed from: b, reason: collision with root package name */
    private X509Certificate[] f37925b;

    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    private void a() {
        g.c(f37918c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance(f37923h);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f37921f);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f37924a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | KeyStoreException | NoSuchAlgorithmException | CertificateException e16) {
            g.b(f37918c, "loadSystemCA: exception : " + e16.getMessage());
        }
        g.a(f37918c, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(f37918c, "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.f37924a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e16) {
                g.b(f37918c, "checkServerTrusted CertificateException" + e16.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        g.c(f37918c, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
        long currentTimeMillis = System.currentTimeMillis();
        int length = x509CertificateArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            X509Certificate x509Certificate = x509CertificateArr[i3];
            String str2 = f37918c;
            g.a(str2, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            g.a(str2, "IssuerDN :" + x509Certificate.getIssuerDN());
            g.a(str2, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f37924a.size();
        for (int i16 = 0; i16 < size; i16++) {
            try {
                String str3 = f37918c;
                g.c(str3, "check server i : " + i16);
                X509TrustManager x509TrustManager = this.f37924a.get(i16);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    g.c(str3, "client root ca size is : " + acceptedIssuers.length);
                    for (int i17 = 0; i17 < acceptedIssuers.length; i17++) {
                        g.a(f37918c, "client root ca getIssuerDN :" + acceptedIssuers[i17].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                g.c(f37918c, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e16) {
                String str4 = f37918c;
                g.b(str4, "checkServerTrusted error :" + e16.getMessage() + " , time : " + i16);
                if (i16 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        g.b(str4, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e16;
                }
            }
        }
        g.a(f37918c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f37924a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e16) {
            g.b(f37918c, "getAcceptedIssuers exception : " + e16.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.f37925b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f37924a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.f37925b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.f37924a = list;
    }

    public SecureX509TrustManager(Context context, boolean z16) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f37924a = new ArrayList();
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.a(context);
            if (z16) {
                a();
            }
            a(context);
            if (this.f37924a.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.f37924a = new ArrayList();
        a(inputStream, str);
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    private void a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        boolean z16;
        String str = f37918c;
        g.c(str, "loadBksCA");
        long currentTimeMillis = System.currentTimeMillis();
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                g.c(str, "get bks not from assets");
                a(filesBksIS);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e16) {
                g.b(f37918c, "loadBksCA: exception : " + e16.getMessage());
                z16 = false;
            }
        }
        z16 = true;
        if (!z16 || filesBksIS == null) {
            g.c(f37918c, " get bks from assets ");
            a(context.getAssets().open("hmsrootcas.bks"));
        }
        g.a(f37918c, "loadBksCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public SecureX509TrustManager(String str, boolean z16) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.f37924a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a(fileInputStream, "");
                f.a((InputStream) fileInputStream);
                if (z16) {
                    a();
                }
            } catch (Throwable th5) {
                th = th5;
                f.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z16) throws IllegalArgumentException {
        this.f37924a = new ArrayList();
        if (z16) {
            a();
        }
        a(inputStream, str);
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f37921f);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f37924a.add((X509TrustManager) trustManager);
                }
            }
        } finally {
            f.a(inputStream);
        }
    }

    private void a(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f37921f);
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (TrustManager trustManager : trustManagers) {
                        if (trustManager instanceof X509TrustManager) {
                            this.f37924a.add((X509TrustManager) trustManager);
                        }
                    }
                    f.a(inputStream);
                } catch (IOException | NegativeArraySizeException | KeyStoreException | NoSuchAlgorithmException | CertificateException e16) {
                    g.b(f37918c, "loadInputStream: exception : " + e16.getMessage());
                }
                g.a(f37918c, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return;
            } finally {
                f.a(inputStream);
            }
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }
}
