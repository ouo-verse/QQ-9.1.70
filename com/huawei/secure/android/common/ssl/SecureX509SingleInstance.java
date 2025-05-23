package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SecureX509SingleInstance {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37916a = "SecureX509SingleInstance";

    /* renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f37917b;

    SecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        long currentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.a(context);
            if (f37917b == null) {
                synchronized (SecureX509SingleInstance.class) {
                    if (f37917b == null) {
                        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                        if (filesBksIS == null) {
                            g.c(f37916a, "get assets bks");
                            filesBksIS = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            g.c(f37916a, "get files bks");
                        }
                        f37917b = new SecureX509TrustManager(filesBksIS, "");
                        new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                    }
                }
            }
            g.a(f37916a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return f37917b;
        }
        throw new NullPointerException("context is null");
    }

    public static void updateBks(InputStream inputStream) {
        String str = f37916a;
        g.c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f37917b != null) {
            f37917b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(f37917b);
            SecureApacheSSLSocketFactory.a(f37917b);
        }
        g.c(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
