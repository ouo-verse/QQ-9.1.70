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
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static final String f37990b = "X509CertificateUtil";

    /* renamed from: c, reason: collision with root package name */
    public static final String f37991c = "hmsrootcas.bks";

    /* renamed from: d, reason: collision with root package name */
    public static final String f37992d = "";

    /* renamed from: e, reason: collision with root package name */
    public static final String f37993e = "bks";

    /* renamed from: f, reason: collision with root package name */
    public static final String f37994f = "052root";

    /* renamed from: g, reason: collision with root package name */
    private static final String f37995g = "hmsincas.bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f37996h = "huawei cbg application integration ca";

    /* renamed from: a, reason: collision with root package name */
    private Context f37997a;

    public j(Context context) {
        this.f37997a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate a(String str, String str2) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(f37993e);
                inputStream = this.f37997a.getAssets().open(str);
            } catch (IOException e16) {
                e = e16;
                inputStream = null;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            } catch (KeyStoreException e17) {
                e = e17;
                inputStream = null;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e18) {
                e = e18;
                inputStream = null;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            } catch (CertificateException e19) {
                e = e19;
                inputStream = null;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            } catch (Throwable th5) {
                th = th5;
                f.a(inputStream2);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                str = inputStream;
            } catch (IOException e26) {
                e = e26;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            } catch (KeyStoreException e27) {
                e = e27;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e28) {
                e = e28;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            } catch (CertificateException e29) {
                e = e29;
                g.b(f37990b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                f.a((InputStream) str);
                return x509Certificate;
            }
            f.a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = str;
            f.a(inputStream2);
            throw th;
        }
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f37994f);
    }

    public X509Certificate a() {
        return a(f37995g, f37996h);
    }
}
