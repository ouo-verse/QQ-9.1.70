package com.tencent.gdtad.statistics;

import android.net.http.Headers;
import com.tencent.gdtad.log.GdtLog;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes6.dex */
class GdtCgiReportRunnable implements Runnable {
    private static final String TAG = "GdtCgiReportRunnable";
    private String cgiUrl;
    private GdtCgiReportRunnableCallback gdtCgiReportRunnableCallback;
    protected boolean mSuccess = false;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GdtCgiReportRunnableCallback {
        void callback(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtCgiReportRunnable(String str) {
        this.cgiUrl = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpURLConnection httpURLConnection;
        Throwable th5;
        GdtCgiReportRunnableCallback gdtCgiReportRunnableCallback;
        int i3 = -1;
        try {
            httpURLConnection = (HttpURLConnection) new URL(this.cgiUrl).openConnection();
            try {
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "Keep-Alive");
                httpURLConnection.connect();
                i3 = httpURLConnection.getResponseCode();
                if (i3 == 200) {
                    this.mSuccess = true;
                }
                httpURLConnection.disconnect();
                gdtCgiReportRunnableCallback = this.gdtCgiReportRunnableCallback;
                if (gdtCgiReportRunnableCallback == null) {
                    return;
                }
            } catch (Throwable th6) {
                th5 = th6;
                try {
                    GdtLog.e(TAG, String.format("run %s", this.cgiUrl), th5);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    gdtCgiReportRunnableCallback = this.gdtCgiReportRunnableCallback;
                    if (gdtCgiReportRunnableCallback == null) {
                        return;
                    }
                    gdtCgiReportRunnableCallback.callback(i3);
                } catch (Throwable th7) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    GdtCgiReportRunnableCallback gdtCgiReportRunnableCallback2 = this.gdtCgiReportRunnableCallback;
                    if (gdtCgiReportRunnableCallback2 != null) {
                        gdtCgiReportRunnableCallback2.callback(i3);
                    }
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            httpURLConnection = null;
            th5 = th8;
        }
        gdtCgiReportRunnableCallback.callback(i3);
    }

    public void setGdtCgiReportRunnableCallback(GdtCgiReportRunnableCallback gdtCgiReportRunnableCallback) {
        this.gdtCgiReportRunnableCallback = gdtCgiReportRunnableCallback;
    }
}
