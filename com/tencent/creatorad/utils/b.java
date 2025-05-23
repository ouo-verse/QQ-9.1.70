package com.tencent.creatorad.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.connect();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (QLog.isColorLevel()) {
                        QLog.d("HttpsUtils", 4, "url=" + str + " rspCode= " + responseCode);
                    }
                    httpURLConnection2.disconnect();
                } catch (Exception e16) {
                    e = e16;
                    httpURLConnection = httpURLConnection2;
                    QLog.e("HttpsUtils", 2, e.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.creatorad.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b(str);
            }
        }, 128, null, true);
    }
}
