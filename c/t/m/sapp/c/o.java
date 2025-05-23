package c.t.m.sapp.c;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: P */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static int f30185a = 20000;

    public static byte[] a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(f30185a);
                httpURLConnection.setReadTimeout(f30185a);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                httpURLConnection.getOutputStream().write(bArr);
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[128];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            httpURLConnection.disconnect();
                            return byteArray;
                        }
                    }
                } else {
                    httpURLConnection.disconnect();
                    f30185a = 20000;
                    return null;
                }
            } catch (Throwable unused) {
                try {
                    f30185a = 20000;
                    return null;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable unused2) {
            httpURLConnection = null;
        }
    }

    public static byte[] a(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.connect();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openConnection.getInputStream().read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
