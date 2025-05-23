package hynb.u;

import hynb.p.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b {
    public static byte[] a(String str, Map<String, String> map, byte[] bArr, a aVar) {
        return a(str, map, bArr, true, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, Map<String, String> map, byte[] bArr, boolean z16, a aVar) {
        int length;
        HttpURLConnection httpURLConnection;
        int a16;
        int i3 = 0;
        HttpURLConnection httpURLConnection2 = null;
        if (bArr != null) {
            try {
                length = bArr.length;
            } catch (Exception e16) {
                e = e16;
                httpURLConnection = null;
                try {
                    g.f406799a.a("Network", "httpRequest", e);
                    if (httpURLConnection != null) {
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                if (httpURLConnection2 != null) {
                }
                throw th;
            }
        } else {
            length = 0;
        }
        HttpURLConnection httpURLConnection3 = a(str, length, 10000, z16, aVar);
        if (length > 0) {
            if (aVar != null) {
                try {
                    a16 = aVar.a();
                } catch (Exception e17) {
                    httpURLConnection = httpURLConnection3;
                    e = e17;
                    g.f406799a.a("Network", "httpRequest", e);
                    if (httpURLConnection != null) {
                        httpURLConnection3 = httpURLConnection;
                        httpURLConnection3.disconnect();
                    }
                    return null;
                } catch (Throwable th7) {
                    httpURLConnection2 = httpURLConnection3;
                    th = th7;
                    if (httpURLConnection2 != null) {
                    }
                    throw th;
                }
            } else {
                a16 = 1024;
            }
            if (length > a16) {
                bArr = a(bArr);
                length = bArr.length;
                httpURLConnection3.setRequestProperty("Content-Encoding", "gzip");
            }
            httpURLConnection3.setRequestProperty("Content-Length", String.valueOf(length));
            if (aVar == null || !aVar.d()) {
                i3 = length;
            } else {
                httpURLConnection3.setRequestProperty("Content-Encrypt", "yyencrypt");
                String b16 = aVar.b();
                if (b16 == null || b16.isEmpty()) {
                    b16 = "ABCDEFGHIJKLMNOP";
                }
                bArr = hynb.q.a.b(null, b16, bArr);
                if (bArr != null) {
                    i3 = bArr.length;
                }
            }
            httpURLConnection3.setRequestProperty("Content-Length", String.valueOf(i3));
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (str2 != null && !str2.isEmpty() && map.get(str2) != null) {
                        httpURLConnection3.setRequestProperty(str2, map.get(str2));
                    }
                }
            }
            httpURLConnection3.getOutputStream().write(bArr);
        }
        int responseCode = httpURLConnection3.getResponseCode();
        g.f406799a.debug("Network", "httpRequest response code : " + responseCode);
        if (responseCode == 200) {
            byte[] a17 = a(httpURLConnection3.getInputStream());
            httpURLConnection3.disconnect();
            return a17;
        }
        httpURLConnection3.disconnect();
        return null;
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static HttpURLConnection a(String str, int i3, int i16, boolean z16, a aVar) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(i16);
        if (aVar != null && aVar.c() != 0) {
            httpURLConnection.setReadTimeout(aVar.c());
        }
        httpURLConnection.setUseCaches(false);
        if (i3 > 0) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", z16 ? "application/multipart-formdata" : "application/x-www-form-urlencoded");
        } else {
            httpURLConnection.setRequestMethod("GET");
        }
        httpURLConnection.setRequestProperty("ns_v", "1.7.213-statistics-reduce20");
        httpURLConnection.setRequestProperty("ns_pf", "adr");
        return httpURLConnection;
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
