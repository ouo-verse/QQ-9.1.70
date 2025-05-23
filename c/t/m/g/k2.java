package c.t.m.g;

import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes.dex */
public class k2 implements y2 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f29817a = new byte[512];

    @Override // c.t.m.g.y2
    public Pair<byte[], String> a(String str, byte[] bArr) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            a(bArr, httpURLConnection.getOutputStream());
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String a16 = a(httpURLConnection.getHeaderField("content-type"));
                byte[] a17 = a(httpURLConnection.getInputStream());
                if (a17 != null && a17.length != 0) {
                    return Pair.create(a17, a16);
                }
                return Pair.create("{}".getBytes(), "utf-8");
            }
            throw new IOException("net sdk error: " + responseCode);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public final void a(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public final byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        while (true) {
            int read = inputStream.read(this.f29817a);
            if (read != -1) {
                byteArrayOutputStream.write(this.f29817a, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String a(String str) {
        if (str != null) {
            for (String str2 : str.split(";")) {
                String trim = str2.trim();
                int indexOf = trim.indexOf("charset=");
                if (-1 != indexOf) {
                    return trim.substring(indexOf + 8, trim.length());
                }
            }
        }
        return "GBK";
    }
}
