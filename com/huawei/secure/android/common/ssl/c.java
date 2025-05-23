package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import com.huawei.secure.android.common.ssl.util.j;
import com.tencent.component.media.image.ProgressTracer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements X509TrustManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f37948c = "WebViewX509TrustManger";

    /* renamed from: a, reason: collision with root package name */
    private X509Certificate f37949a;

    /* renamed from: b, reason: collision with root package name */
    private List<X509TrustManager> f37950b = new ArrayList();

    public c(Context context) {
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.a(context);
            X509Certificate b16 = new j(context).b();
            this.f37949a = b16;
            if (b16 != null) {
                return;
            } else {
                throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
            }
        }
        throw new NullPointerException("WebViewX509TrustManger context is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(f37948c, "checkClientTrusted");
        if (!this.f37950b.isEmpty()) {
            this.f37950b.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(f37948c, "checkServerTrusted");
        boolean z16 = false;
        for (int i3 = 0; i3 < x509CertificateArr.length; i3++) {
            g.a(f37948c, "checkServerTrusted " + i3 + ProgressTracer.SEPARATOR + x509CertificateArr[i3].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i16 = 0; i16 < x509CertificateArr.length; i16++) {
            x509CertificateArr2[i16] = x509CertificateArr[(x509CertificateArr.length - 1) - i16];
        }
        CertificateException e16 = new CertificateException("CBG root CA CertificateException");
        try {
            z16 = com.huawei.secure.android.common.ssl.util.b.a(this.f37949a, x509CertificateArr2);
        } catch (InvalidKeyException e17) {
            g.b(f37948c, "checkServerTrusted InvalidKeyException: " + e17.getMessage());
        } catch (NoSuchAlgorithmException e18) {
            g.b(f37948c, "checkServerTrusted NoSuchAlgorithmException: " + e18.getMessage());
        } catch (NoSuchProviderException e19) {
            g.b(f37948c, "checkServerTrusted NoSuchProviderException: " + e19.getMessage());
        } catch (SignatureException e26) {
            g.b(f37948c, "checkServerTrusted SignatureException: " + e26.getMessage());
        } catch (CertificateException e27) {
            e16 = e27;
            g.b(f37948c, "checkServerTrusted CertificateException: " + e16.getMessage());
        }
        if (!z16) {
            throw e16;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f37950b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e16) {
            g.b(f37948c, "getAcceptedIssuers exception : " + e16.getMessage());
            return new X509Certificate[0];
        }
    }
}
