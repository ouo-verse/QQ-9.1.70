package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes33.dex */
public class Monitor {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f238243a = true;

    public static boolean a() {
        return f238243a;
    }

    public static void b(String str) {
        final String replace = "https://cgi.pub.qq.com/report/report_vm?monitors=[$ID$]&t=$TIMESTAMP$".replace("$ID$", str).replace("$TIMESTAMP$", String.valueOf(System.currentTimeMillis()));
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.Monitor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(replace).openConnection();
                    if (httpURLConnection != null) {
                        httpURLConnection.setConnectTimeout(8000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        if (httpURLConnection.getResponseCode() == 200) {
                            if (QLog.isColorLevel()) {
                                QLog.i("Monitor", 2, " report to monitor success,URL = " + replace);
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.i("Monitor", 2, " report to monitor failed,URL = " + replace);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Monitor", 2, e16, new Object[0]);
                    }
                }
            }
        });
    }

    public static void c(boolean z16) {
        f238243a = z16;
    }

    public static void d(String str) {
        if (f238243a) {
            b(str);
        }
    }
}
