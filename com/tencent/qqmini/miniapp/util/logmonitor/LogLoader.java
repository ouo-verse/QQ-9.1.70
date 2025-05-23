package com.tencent.qqmini.miniapp.util.logmonitor;

import android.os.AsyncTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LogLoader {
    public static final String TAG = "LogLoader";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface LoadHandler {
        void handLine(String str);

        void onComplete();
    }

    public static void load(final Process process, final LoadHandler loadHandler) {
        new AsyncTask<Void, Void, BufferedReader>() { // from class: com.tencent.qqmini.miniapp.util.logmonitor.LogLoader.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // android.os.AsyncTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public BufferedReader doInBackground(Void... voidArr) {
                BufferedReader bufferedReader;
                Throwable th5;
                Exception e16;
                StringBuilder sb5;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    loadHandler.handLine(readLine);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e17) {
                                        e = e17;
                                        sb5 = new StringBuilder();
                                        sb5.append("load - doInBackground bufferedReader.close get an exception:");
                                        sb5.append(e);
                                        QMLog.e(LogLoader.TAG, sb5.toString());
                                        return bufferedReader;
                                    }
                                }
                            } catch (Throwable th6) {
                                th5 = th6;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e18) {
                                        QMLog.e(LogLoader.TAG, "load - doInBackground bufferedReader.close get an exception:" + e18);
                                    }
                                }
                                throw th5;
                            }
                        } catch (Exception e19) {
                            e16 = e19;
                            QMLog.e(LogLoader.TAG, "load - doInBackground get an exception:" + e16);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e26) {
                                    e = e26;
                                    sb5 = new StringBuilder();
                                    sb5.append("load - doInBackground bufferedReader.close get an exception:");
                                    sb5.append(e);
                                    QMLog.e(LogLoader.TAG, sb5.toString());
                                    return bufferedReader;
                                }
                            }
                            return bufferedReader;
                        }
                    }
                    bufferedReader.close();
                } catch (Exception e27) {
                    bufferedReader = null;
                    e16 = e27;
                } catch (Throwable th7) {
                    bufferedReader = null;
                    th5 = th7;
                    if (bufferedReader != null) {
                    }
                    throw th5;
                }
                return bufferedReader;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(BufferedReader bufferedReader) {
                loadHandler.onComplete();
            }
        }.execute(new Void[0]);
    }
}
