package com.tencent.tgpa.lite.g;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g {
    private static String a(InputStream inputStream) {
        StringBuilder sb5 = new StringBuilder();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return sb5.toString();
            }
            sb5.append(new String(bArr, 0, read));
        }
    }

    public static String a(String str, String str2, String str3, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        if (str != null) {
            httpURLConnection.setRequestMethod(str);
        }
        if (map != null) {
            for (String str4 : map.keySet()) {
                httpURLConnection.addRequestProperty(str4, map.get(str4));
            }
        }
        if (str3 != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str3.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        String a16 = a(inputStream);
        inputStream.close();
        return httpURLConnection.getResponseCode() == 301 ? a(str, httpURLConnection.getHeaderField("Location"), str3, map) : a16;
    }

    public static String a(String str, String str2, Map<String, String> map) {
        return a("POST", str, str2, map);
    }

    public static String a(String str, Map<String, String> map) {
        return a(str, map, (Map<String, String>) null);
    }

    public static String a(String str, Map<String, String> map, Map<String, String> map2) {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        StringBuilder sb5 = new StringBuilder();
        if (map != null) {
            boolean z16 = true;
            for (String str2 : map.keySet()) {
                if (z16) {
                    z16 = false;
                } else {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                String str3 = map.get(str2);
                sb5.append(URLEncoder.encode(str2, "UTF-8"));
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(URLEncoder.encode(str3, "UTF-8"));
            }
        }
        return a(str, sb5.toString(), map2);
    }
}
