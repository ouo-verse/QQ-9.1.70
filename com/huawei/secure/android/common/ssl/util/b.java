package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37979a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static final int f37980b = 5;

    public static X509Certificate a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e16) {
            g.b(f37979a, "generateX509FromStr: CertificateException" + e16.getMessage());
            return null;
        }
    }

    public static boolean b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e16) {
                e = e16;
                g.b(f37979a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e17) {
                e = e17;
                g.b(f37979a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e18) {
                g.b(f37979a, "verifyCertificateDate : exception : " + e18.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return !a(x509Certificate, x509CertificateArr) && !a(x509CertificateArr, x509crl) && a(x509CertificateArr[x509CertificateArr.length - 1], str) && b(x509CertificateArr);
    }

    public static boolean a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                return true;
            }
            Iterator<? extends X509CRLEntry> it = revokedCertificates.iterator();
            while (it.hasNext()) {
                if (arrayList.contains(it.next().getSerialNumber())) {
                    g.b(f37979a, "verify: certificate revoked");
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            g.b(f37979a, "verify: revoked verify exception : " + e16.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        g.b(f37979a, "verify: subject name is error");
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            g.b(f37979a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e16) {
            g.b(f37979a, "verify: publickey InvalidKeyException " + e16.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e17) {
            g.b(f37979a, "verify: publickey NoSuchAlgorithmException " + e17.getMessage());
            return false;
        } catch (NoSuchProviderException e18) {
            g.b(f37979a, "verify: publickey NoSuchProviderException " + e18.getMessage());
            return false;
        } catch (SignatureException e19) {
            g.b(f37979a, "verify: publickey SignatureException " + e19.getMessage());
            return false;
        } catch (CertificateException e26) {
            g.b(f37979a, "verify: publickey CertificateException " + e26.getMessage());
            return false;
        } catch (Exception e27) {
            g.b(f37979a, "verify: Exception " + e27.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i3 = 0;
        while (i3 < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i3];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i3].verify(x509CertificateArr[i3 - 1].getPublicKey());
                } else {
                    g.b(f37979a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i3++;
            principal = subjectDN;
        }
        return a(x509Certificate, x509CertificateArr[0]) && b(x509CertificateArr) && a(x509Certificate) && a(x509CertificateArr);
    }

    public static X509Certificate a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e16) {
                g.a(f37979a, "exception", e16);
            }
        }
        return null;
    }

    public static boolean a(X509Certificate[] x509CertificateArr) {
        for (int i3 = 0; i3 < x509CertificateArr.length - 1; i3++) {
            if (!a(x509CertificateArr[i3])) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
