package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    public static String a(long j3, int i3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://tu.qq.com/wspeed.qq.com/w.cgi?appid=1000322&commandid=pitu.qqsdk.AutoAIScene&releaseversion=" + com.tencent.open.adapter.a.f().i() + "&touin=" + com.tencent.open.adapter.a.f().l() + "&frequency=1&resultcode=" + i3 + "&timecost=" + j3).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection.getInputStream().toString();
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static JSONObject b(String str, String str2) throws IOException, JSONException {
        String str3;
        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("content-type", "application/json");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.connect();
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(str2.getBytes("utf-8"));
        dataOutputStream.flush();
        dataOutputStream.close();
        if (200 == httpURLConnection.getResponseCode()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(new String(readLine.getBytes(), "utf-8"));
            }
            bufferedReader.close();
            str3 = sb5.toString();
        } else {
            str3 = null;
        }
        httpURLConnection.disconnect();
        if (str3 == null) {
            return null;
        }
        return new JSONObject(str3);
    }
}
