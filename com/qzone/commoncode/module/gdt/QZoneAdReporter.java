package com.qzone.commoncode.module.gdt;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAdReporter {
    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.connect();
                QLog.i("QZoneAdReporter", 2, "[report] responseCode:" + httpURLConnection2.getResponseCode() + " url:" + str);
                httpURLConnection2.disconnect();
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                try {
                    QLog.e("QZoneAdReporter", 1, "[report]", th);
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void c(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.commoncode.module.gdt.QZoneAdReporter.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneAdReporter.b(str);
            }
        }, 128, null, true);
    }
}
