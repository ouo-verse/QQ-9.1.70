package org.apache.httpcore.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface TrustStrategy {
    boolean isTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException;
}
