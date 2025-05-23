package com.sina.weibo.sdk.net;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b implements a {
    @Override // com.sina.weibo.sdk.net.a
    public final f a(d dVar) {
        InputStream errorStream;
        String url = dVar.getUrl();
        Bundle params = dVar.getParams();
        if (params != null && params.size() != 0 && !TextUtils.isEmpty(url)) {
            Uri parse = Uri.parse(url);
            if (!params.isEmpty()) {
                Uri.Builder buildUpon = parse.buildUpon();
                for (String str : params.keySet()) {
                    buildUpon.appendQueryParameter(str, String.valueOf(params.get(str)));
                }
                parse = buildUpon.build();
            }
            if (parse != null) {
                url = parse.toString();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                Bundle bundle = new Bundle();
                bundle.putString("Content-Type", "application/x-www-form-urlencoded");
                a(httpURLConnection, bundle);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(dVar.getReadTimeout());
                httpURLConnection.setConnectTimeout(dVar.getConnectTimeout());
                httpURLConnection.connect();
                a(httpURLConnection.getOutputStream(), dVar);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                g gVar = new g(responseCode, errorStream);
                httpURLConnection.disconnect();
                return gVar;
            } catch (Exception e16) {
                throw new Throwable(e16.getMessage());
            }
        } catch (Throwable th5) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th5;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Bundle bundle) {
        for (String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
        }
    }

    private static void a(OutputStream outputStream, d dVar) {
        Bundle h16 = dVar.h();
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str : h16.keySet()) {
            if (z16) {
                z16 = false;
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            String valueOf = String.valueOf(h16.get(str));
            try {
                sb5.append(URLEncoder.encode(str, "UTF-8"));
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(URLEncoder.encode(valueOf, "UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb5.toString().getBytes("UTF-8"));
            dataOutputStream.close();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }
}
