package com.tenpay.sdk.net.http.tls;

import android.annotation.SuppressLint;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J7\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0002\u0010\u0010J)\u0010\u0011\u001a\u00020\u00122\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0017\u00a2\u0006\u0002\u0010\u0013J)\u0010\u0014\u001a\u00020\u00122\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u0016\u00a2\u0006\u0002\u0010\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tenpay/sdk/net/http/tls/PayTrustManager;", "Ljavax/net/ssl/X509TrustManager;", "customCerts", "", "", "([Ljava/lang/String;)V", "customTrust", "", "Ljavax/net/ssl/TrustManager;", "systemTrust", "checkCertServerTrusted", "", "trustManagerList", "chain", "Ljava/security/cert/X509Certificate;", "authType", "(Ljava/util/List;[Ljava/security/cert/X509Certificate;Ljava/lang/String;)Z", "checkClientTrusted", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"CustomX509TrustManager"})
/* loaded from: classes27.dex */
public final class PayTrustManager implements X509TrustManager {

    @NotNull
    public static final String TAG = "QWalletHttp-PayTrustManager";

    @NotNull
    private final List<TrustManager> customTrust;

    @NotNull
    private final List<TrustManager> systemTrust;

    public PayTrustManager(@Nullable String[] strArr) {
        List<TrustManager> emptyList;
        List<TrustManager> listOf;
        List<TrustManager> listOf2;
        if (strArr == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.customTrust = emptyList;
        } else {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                byte[] bytes = strArr[i3].getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                try {
                    keyStore.setCertificateEntry("ca" + i3, certificateFactory.generateCertificate(byteArrayInputStream));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                } finally {
                }
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            Intrinsics.checkNotNullExpressionValue(trustManagers, "tmf.trustManagers");
            listOf2 = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(trustManagers, trustManagers.length));
            this.customTrust = listOf2;
        }
        TrustManagerFactory trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory2.init((KeyStore) null);
        TrustManager[] trustManagers2 = trustManagerFactory2.getTrustManagers();
        Intrinsics.checkNotNullExpressionValue(trustManagers2, "systemTmf.trustManagers");
        listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(trustManagers2, trustManagers2.length));
        this.systemTrust = listOf;
    }

    private final boolean checkCertServerTrusted(List<? extends TrustManager> trustManagerList, X509Certificate[] chain, String authType) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : trustManagerList) {
            if (obj instanceof X509TrustManager) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((X509TrustManager) it.next()).checkServerTrusted(chain, authType);
                return true;
            } catch (CertificateException e16) {
                QLog.d(TAG, 2, "cert not trusted:" + e16);
            }
        }
        return false;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(@Nullable X509Certificate[] chain, @Nullable String authType) {
        if (!checkCertServerTrusted(this.systemTrust, chain, authType) && !checkCertServerTrusted(this.customTrust, chain, authType)) {
            QLog.w(TAG, 1, "no trust cert found: " + chain + " , " + authType);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    @NotNull
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    @Override // javax.net.ssl.X509TrustManager
    @SuppressLint({"TrustAllX509TrustManager"})
    public void checkClientTrusted(@Nullable X509Certificate[] chain, @Nullable String authType) {
    }
}
