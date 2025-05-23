package com.tencent.bugly.proguard;

import android.util.Pair;
import com.tencent.bugly.GlobalConfig;
import com.tencent.raft.measure.report.ATTAReporter;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class al {
    public static Pair<Integer, String> a(List<String> list) {
        try {
            if (GlobalConfig.isInStandaloneMode()) {
                av.d("send atta fail for app in standalone mode.", new Object[0]);
                return new Pair<>(200, "app in standalone mode");
            }
            if (!z.a("crash_atta_ratio")) {
                return new Pair<>(200, "crash atta report disabled");
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attaid", "08e00055686").put("token", "8666841551").put("type", "batch").put("version", "v1.0.0");
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            jSONObject.put("datas", jSONArray);
            return a("https://h.trace.qq.com/kv", jSONObject.toString(), hashMap);
        } catch (Throwable th5) {
            av.b(th5);
            return new Pair<>(-1, th5.getMessage());
        }
    }

    private static Pair<Integer, String> a(String str, String str2, Map<String, String> map) {
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        String message;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection = null;
        int i3 = -1;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                a(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.connect();
                byte[] bytes = str2.getBytes("UTF-8");
                dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    i3 = httpURLConnection2.getResponseCode();
                    if (i3 >= 400) {
                        inputStream2 = httpURLConnection2.getErrorStream();
                    } else {
                        inputStream2 = httpURLConnection2.getInputStream();
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
                        StringBuilder sb5 = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                            sb5.append("\r\n");
                        }
                        bufferedReader.close();
                        message = sb5.toString();
                        a((Closeable) null);
                        a(inputStream2);
                        httpURLConnection2.disconnect();
                    } catch (Throwable th5) {
                        httpURLConnection = httpURLConnection2;
                        inputStream = inputStream2;
                        th = th5;
                        dataOutputStream = null;
                        try {
                            av.b(th);
                            message = th.getMessage();
                            return new Pair<>(Integer.valueOf(i3), message);
                        } finally {
                            a(dataOutputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                dataOutputStream = null;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            dataOutputStream = null;
        }
        return new Pair<>(Integer.valueOf(i3), message);
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e16) {
            av.b(e16);
        }
    }
}
