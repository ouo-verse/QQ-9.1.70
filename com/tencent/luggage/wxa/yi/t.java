package com.tencent.luggage.wxa.yi;

import com.tencent.luggage.wxa.tn.w0;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class t implements X509TrustManager {

    /* renamed from: c, reason: collision with root package name */
    public KeyStore f145959c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f145960d;

    /* renamed from: g, reason: collision with root package name */
    public X509Certificate[] f145963g;

    /* renamed from: e, reason: collision with root package name */
    public List f145961e = null;

    /* renamed from: f, reason: collision with root package name */
    public KeyStore f145962f = null;

    /* renamed from: a, reason: collision with root package name */
    public LinkedList f145957a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public LinkedList f145958b = new LinkedList();

    public t(boolean z16) {
        this.f145960d = z16;
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            this.f145959c = keyStore;
            keyStore.load(null, null);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e16, "Exception: Local KeyStore init failed", new Object[0]);
        }
    }

    public void a(InputStream inputStream) {
        if (this.f145959c == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
            return;
        }
        try {
            try {
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                inputStream.close();
                this.f145959c.setCertificateEntry(((X509Certificate) generateCertificate).getSubjectDN() + "", generateCertificate);
            } catch (Throwable th5) {
                inputStream.close();
                throw th5;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e16, "Exception: initLocalSelfSignedCertificate", new Object[0]);
        }
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.f145957a.iterator();
        while (it.hasNext()) {
            X509Certificate[] acceptedIssuers = ((X509TrustManager) it.next()).getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Iterator it5 = this.f145958b.iterator();
        while (it5.hasNext()) {
            X509Certificate[] acceptedIssuers2 = ((X509TrustManager) it5.next()).getAcceptedIssuers();
            if (acceptedIssuers2 != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers2));
            }
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        X509Certificate[] x509CertificateArr = new X509Certificate[arrayList.size()];
        this.f145963g = x509CertificateArr;
        this.f145963g = (X509Certificate[]) arrayList.toArray(x509CertificateArr);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
    }

    public final void c() {
        if (this.f145959c == null) {
            return;
        }
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(this.f145959c);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int i3 = 0;
            while (trustManagers != null) {
                if (i3 < trustManagers.length) {
                    this.f145958b.add((X509TrustManager) trustManagers[i3]);
                    i3++;
                } else {
                    return;
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e16, "Exception: init LocalTrustManager", new Object[0]);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client Certification not supported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02d7  */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.Iterator] */
    @Override // javax.net.ssl.X509TrustManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 0L, 1L, false);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "trust manager size:" + this.f145957a.size());
        Iterator it = this.f145957a.iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                X509TrustManager x509TrustManager = (X509TrustManager) it.next();
                try {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "try system trust:" + x509TrustManager.toString());
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "system trust:" + x509TrustManager.toString());
                    z17 = true;
                    break;
                } catch (CertificateException e16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e16, "CertificateException: SystemTrustManagers checkServerTrusted", new Object[0]);
                }
            } else {
                z17 = false;
                break;
            }
        }
        if (z17) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted systemTrusted true");
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 1L, 1L, false);
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "try local trust size:%d", Integer.valueOf(this.f145958b.size()));
        ?? it5 = this.f145958b.iterator();
        while (true) {
            if (it5.hasNext()) {
                X509TrustManager x509TrustManager2 = (X509TrustManager) it5.next();
                try {
                    x509TrustManager2.checkServerTrusted(x509CertificateArr, str);
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "local trust:" + x509TrustManager2.toString());
                    z18 = true;
                    z19 = "local trust:";
                    break;
                } catch (CertificateException e17) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e17, "CertificateException: LocalTrustManagers checkServerTrusted", new Object[0]);
                }
            } else {
                z18 = false;
                z19 = it5;
                break;
            }
        }
        if (z18) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted localTrusted true");
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 2L, 1L, false);
            return;
        }
        if (this.f145960d) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted debug type");
            try {
                try {
                    if (this.f145962f == null) {
                        KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                        this.f145962f = keyStore;
                        keyStore.load(null, null);
                    }
                    if (this.f145961e == null) {
                        this.f145961e = new ArrayList();
                        Enumeration<String> aliases = this.f145962f.aliases();
                        while (aliases.hasMoreElements()) {
                            String nextElement = aliases.nextElement();
                            if (nextElement != null && nextElement.startsWith("user:")) {
                                this.f145961e.add(nextElement);
                            }
                        }
                    }
                    if (this.f145961e.size() > 0) {
                        Iterator it6 = this.f145961e.iterator();
                        z26 = false;
                        while (it6.hasNext()) {
                            try {
                                X509Certificate x509Certificate = (X509Certificate) this.f145962f.getCertificate((String) it6.next());
                                int length = x509CertificateArr.length;
                                int i3 = 0;
                                while (true) {
                                    if (i3 < length) {
                                        try {
                                            x509CertificateArr[i3].verify(x509Certificate.getPublicKey());
                                            z26 = true;
                                            break;
                                        } catch (Exception e18) {
                                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e18, "Exception: check user verify certificate", new Object[0]);
                                            i3++;
                                        }
                                    }
                                }
                            } catch (IOException e19) {
                                e = e19;
                                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e, "IOException: check user certificate", new Object[0]);
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 7L, 1L, false);
                                if (z26) {
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 3L, 1L, false);
                                    return;
                                }
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 10L, 1L, false);
                                throw new CertificateException("Server Certificate not trusted");
                            } catch (KeyStoreException e26) {
                                e = e26;
                                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e, "KeyStoreException: check user certificate", new Object[0]);
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 5L, 1L, false);
                                if (z26) {
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 3L, 1L, false);
                                    return;
                                }
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 10L, 1L, false);
                                throw new CertificateException("Server Certificate not trusted");
                            } catch (NoSuchAlgorithmException e27) {
                                e = e27;
                                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e, "NoSuchAlgorithmException: check user certificate", new Object[0]);
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 6L, 1L, false);
                                if (z26) {
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 3L, 1L, false);
                                    return;
                                }
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 10L, 1L, false);
                                throw new CertificateException("Server Certificate not trusted");
                            } catch (Exception e28) {
                                e = e28;
                                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e, "Exception: check user certificate", new Object[0]);
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 8L, 1L, false);
                                if (z26) {
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 3L, 1L, false);
                                    return;
                                }
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 10L, 1L, false);
                                throw new CertificateException("Server Certificate not trusted");
                            }
                        }
                        z16 = z26;
                    } else {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check aliasList null");
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 9L, 1L, false);
                    }
                    if (z16) {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 3L, 1L, false);
                        return;
                    }
                } catch (IOException e29) {
                    e = e29;
                    z26 = false;
                } catch (KeyStoreException e36) {
                    e = e36;
                    z26 = false;
                } catch (NoSuchAlgorithmException e37) {
                    e = e37;
                    z26 = false;
                } catch (Exception e38) {
                    e = e38;
                    z26 = false;
                } catch (Throwable th5) {
                    th = th5;
                    if (!z16) {
                    }
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 10L, 1L, false);
            } catch (Throwable th6) {
                th = th6;
                z16 = z19;
                if (!z16) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 3L, 1L, false);
                    return;
                } else {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
                    ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 10L, 1L, false);
                    throw th;
                }
            }
        } else {
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1011L, 4L, 1L, false);
        }
        throw new CertificateException("Server Certificate not trusted");
    }

    public final void d() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int i3 = 0;
            while (trustManagers != null) {
                if (i3 < trustManagers.length) {
                    this.f145957a.add((X509TrustManager) trustManagers[i3]);
                    i3++;
                } else {
                    return;
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", e16, "Exception: init SystemTrustManager", new Object[0]);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.f145963g;
    }

    public void a() {
        long c16 = w0.c();
        d();
        c();
        b();
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandX509TrustManager", "init() cost[%dms]", Long.valueOf(w0.c() - c16));
    }
}
