package com.tencent.qmethod.pandoraex.core.collector;

import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.raft.measure.report.ATTAReporter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f344029a;

    /* renamed from: b, reason: collision with root package name */
    private final String f344030b;

    public a(String str, String str2) {
        this.f344029a = str;
        this.f344030b = str2;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                o.d("CollectAppInfo.ATTAReporter", "closeQuietly error", e16);
            }
        }
    }

    private void b(String str, String str2) {
        byte[] bArr;
        Closeable closeable;
        o.a("CollectAppInfo.ATTAReporter", "Req " + str + " msg " + str2);
        try {
            bArr = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = new byte[0];
        }
        Closeable closeable2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(300000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT);
            httpURLConnection.setRequestProperty("Content-Type", ATTAReporter.VAL_TEXT_PLAIN_CHARSET_UTF_8);
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                closeable2 = httpURLConnection.getInputStream();
                o.a("CollectAppInfo.ATTAReporter", "code = " + httpURLConnection.getResponseCode() + ", resp=" + httpURLConnection.getResponseMessage());
                httpURLConnection.disconnect();
                a(outputStream);
                a(closeable2);
            } catch (Exception e16) {
                e = e16;
                closeable = closeable2;
                closeable2 = outputStream;
                try {
                    o.d("CollectAppInfo.ATTAReporter", "doPost error", e);
                    a(closeable2);
                    a(closeable);
                } catch (Throwable th5) {
                    th = th5;
                    a(closeable2);
                    a(closeable);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                closeable = closeable2;
                closeable2 = outputStream;
                a(closeable2);
                a(closeable);
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            closeable = null;
        } catch (Throwable th7) {
            th = th7;
            closeable = null;
        }
    }

    public final void c(JSONArray jSONArray) {
        if (jSONArray == null) {
            o.a("CollectAppInfo.ATTAReporter", "doPostBatchReport data is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("attaid", this.f344029a);
            jSONObject.put("token", this.f344030b);
            jSONObject.put("type", "batch");
            jSONObject.put("version", "v1.0.0");
            jSONObject.put("datas", jSONArray);
            b("https://h.trace.qq.com/kv", jSONObject.toString());
        } catch (JSONException e16) {
            o.d("CollectAppInfo.ATTAReporter", "doPostBatchReport error", e16);
        }
    }
}
