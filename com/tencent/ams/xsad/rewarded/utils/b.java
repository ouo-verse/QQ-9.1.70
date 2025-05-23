package com.tencent.ams.xsad.rewarded.utils;

import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(String str, String str2, String str3, boolean z16) {
        HttpURLConnection httpURLConnection;
        URL url;
        int responseCode;
        URL url2 = null;
        try {
            url = new URL(str);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                if (Method.POST.equalsIgnoreCase(str2)) {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Accept", "application/json");
                    httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    if (str3 != null) {
                        httpURLConnection.setDoOutput(true);
                        if (z16) {
                            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                        }
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        c.a("post:", str3);
                        if (z16) {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(dataOutputStream);
                            gZIPOutputStream.write(str3.getBytes());
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                        } else {
                            dataOutputStream.write(str3.getBytes());
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        }
                    }
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
            } catch (Throwable th6) {
                th = th6;
                url2 = url;
                try {
                    c.b("HttpUtils", "ping failed: " + url2 + ", with exception", th);
                    if (httpURLConnection == null) {
                        return false;
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused) {
                        return false;
                    }
                } catch (Throwable th7) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
        }
        if (responseCode > -1 && responseCode < 400) {
            c.a("HttpUtils", "ping success: " + url);
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
            return true;
        }
        c.a("HttpUtils", "ping failed: " + url);
        httpURLConnection.disconnect();
    }
}
