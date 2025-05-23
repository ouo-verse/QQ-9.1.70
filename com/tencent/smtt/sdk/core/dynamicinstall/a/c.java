package com.tencent.smtt.sdk.core.dynamicinstall.a;

import android.util.Log;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c {
    public static String a(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.trim()).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpURLConnection.setRequestProperty("Content-Length", str2.length() + "");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(str2.getBytes());
            if (200 == httpURLConnection.getResponseCode()) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 != read) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        byteArrayOutputStream.flush();
                    } else {
                        return byteArrayOutputStream.toString("utf-8");
                    }
                }
            } else {
                return null;
            }
        } catch (Exception e16) {
            return "Error: " + Log.getStackTraceString(e16);
        }
    }
}
