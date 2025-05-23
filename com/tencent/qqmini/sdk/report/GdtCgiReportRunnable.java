package com.tencent.qqmini.sdk.report;

import android.net.http.Headers;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GdtCgiReportRunnable implements Runnable {
    private static final String TAG = "GdtCgiReportRunnable";
    private String cgiUrl;
    protected boolean mSuccess = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtCgiReportRunnable(String str) {
        this.cgiUrl = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpURLConnection httpURLConnection;
        Throwable th5;
        try {
            httpURLConnection = (HttpURLConnection) new URL(this.cgiUrl).openConnection();
        } catch (Throwable th6) {
            httpURLConnection = null;
            th5 = th6;
        }
        try {
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "Keep-Alive");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                this.mSuccess = true;
            }
        } catch (Throwable th7) {
            th5 = th7;
            try {
                QMLog.e(TAG, String.format("run %s", this.cgiUrl), th5);
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }
}
