package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes5.dex */
public class PreConnectManager {
    private static final String CONNECTION_KEEP_ALIVE = "keep-alive";
    private static final String HEADER_CONNECTION = "Connection";

    public static void connectHost(OkHttpClient okHttpClient, ArrayList<String> arrayList, String str) {
        if (okHttpClient != null && arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                tryConnectHost(okHttpClient, it.next(), str);
            }
        }
    }

    private static void tryConnectHost(OkHttpClient okHttpClient, final String str, String str2) {
        if (okHttpClient != null && !TextUtils.isEmpty(str)) {
            QDLog.i(QDLog.TAG_DOWNLOAD, "pre-connect:" + str + " method:" + str2);
            final long currentTimeMillis = System.currentTimeMillis();
            if (!str2.equals("HEAD") && !str2.equals("GET")) {
                str2 = "HEAD";
            }
            okHttpClient.newCall(new Request.Builder().url(str).method(str2, null).addHeader("Connection", CONNECTION_KEEP_ALIVE).build()).enqueue(new Callback() { // from class: com.tencent.component.network.downloader.PreConnectManager.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    QDLog.e(QDLog.TAG_DOWNLOAD, "pre-connect onFailure: " + str);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    response.close();
                    QDLog.i(QDLog.TAG_DOWNLOAD, "pre-connect onResponse [timecost: " + (currentTimeMillis2 - currentTimeMillis) + "] [url: " + str + "] [code: " + response.code() + "]");
                }
            });
            return;
        }
        QDLog.e(QDLog.TAG_DOWNLOAD, "pre-connect fail, url:" + str);
    }
}
