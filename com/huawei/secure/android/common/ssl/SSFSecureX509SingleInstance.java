package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SSFSecureX509SingleInstance {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37876a = "SSFSecureX509SingleInstance";

    /* renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f37877b;

    SSFSecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.a(context);
            if (f37877b == null) {
                synchronized (SSFSecureX509SingleInstance.class) {
                    if (f37877b == null) {
                        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                        if (filesBksIS == null) {
                            g.c(f37876a, "get assets bks");
                            filesBksIS = context.getAssets().open("hmsrootcas.bks");
                        } else {
                            g.c(f37876a, "get files bks");
                        }
                        f37877b = new SecureX509TrustManager(filesBksIS, "", true);
                        new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                    }
                }
            }
            return f37877b;
        }
        throw new NullPointerException("context is null");
    }

    public static void updateBks(InputStream inputStream) {
        String str = f37876a;
        g.c(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f37877b != null) {
            f37877b = new SecureX509TrustManager(inputStream, "", true);
            g.a(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.a(f37877b);
            SASFCompatiableSystemCA.a(f37877b);
        }
        g.a(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
