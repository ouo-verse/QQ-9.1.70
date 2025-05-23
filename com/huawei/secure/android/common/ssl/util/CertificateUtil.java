package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CertificateUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37978a = "CertificateUtil";

    CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public static X509Certificate getHwCbgRootCA(Context context) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(j.f37993e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
            } catch (IOException e16) {
                e = e16;
                inputStream = null;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (RuntimeException e17) {
                e = e17;
                inputStream = null;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e18) {
                e = e18;
                inputStream = null;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e19) {
                e = e19;
                inputStream = null;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e26) {
                e = e26;
                inputStream = null;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (Throwable th5) {
                th = th5;
                f.a(inputStream2);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(j.f37994f);
                context = inputStream;
            } catch (IOException e27) {
                e = e27;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (RuntimeException e28) {
                e = e28;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e29) {
                e = e29;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e36) {
                e = e36;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e37) {
                e = e37;
                g.b(f37978a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                f.a((InputStream) context);
                return x509Certificate;
            }
            f.a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th6) {
            inputStream2 = context;
            th = th6;
            f.a(inputStream2);
            throw th;
        }
    }
}
