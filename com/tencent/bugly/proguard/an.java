package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    static an f98052a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f98053b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f98054c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(Context context) {
        this.f98053b = context;
    }

    private static byte[] b(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedInputStream.close();
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th7) {
            th = th7;
            try {
                if (!av.a(th)) {
                    th.printStackTrace();
                }
                return null;
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0183 A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #4 {all -> 0x0176, blocks: (B:23:0x00a0, B:25:0x00b8, B:28:0x00c9, B:38:0x00c7, B:79:0x00f2, B:97:0x00fb, B:85:0x0128, B:88:0x0133, B:51:0x0154, B:54:0x0161, B:67:0x017d, B:69:0x0183), top: B:22:0x00a0 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(String str, byte[] bArr, ar arVar, Map<String, String> map) {
        int i3;
        char c16;
        int i16;
        Throwable th5;
        byte[] bArr2 = null;
        int i17 = 0;
        if (str == null) {
            av.e("Failed for no URL.", new Object[0]);
            return null;
        }
        long length = bArr == null ? 0L : bArr.length;
        int i18 = 1;
        av.c("request: %s, send: %d (pid=%d | tid=%d)", str, Long.valueOf(length), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str2 = str;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i19 <= 0 && i26 <= 0) {
            if (i27 != 0) {
                i3 = i19;
                i27 = i17;
            } else {
                int i28 = i19 + 1;
                if (i28 > i18) {
                    av.c("try time: ".concat(String.valueOf(i28)), new Object[i17]);
                    SystemClock.sleep(new Random(System.currentTimeMillis()).nextInt(10000) + 10000);
                }
                i3 = i28;
            }
            String b16 = aj.b(this.f98053b);
            if (b16 == null) {
                av.d("Failed to request for network not avail", new Object[i17]);
                c16 = 2;
                i16 = 1;
            } else {
                arVar.a(length);
                HttpURLConnection a16 = a(str2, bArr, b16, map);
                if (a16 != null) {
                    try {
                        try {
                            int responseCode = a16.getResponseCode();
                            av.c("response code ".concat(String.valueOf(responseCode)), new Object[i17]);
                            if (responseCode == 200) {
                                this.f98054c = a(a16);
                                byte[] b17 = b(a16);
                                arVar.b(b17 == null ? 0L : b17.length);
                                try {
                                    a16.disconnect();
                                } catch (Throwable th6) {
                                    if (!av.a(th6)) {
                                        th6.printStackTrace();
                                    }
                                }
                                return b17;
                            }
                            if (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                                try {
                                    String headerField = a16.getHeaderField("Location");
                                    if (headerField == null) {
                                        try {
                                            av.e("Failed to redirect: %d".concat(String.valueOf(responseCode)), new Object[0]);
                                            try {
                                                a16.disconnect();
                                                return null;
                                            } catch (Throwable th7) {
                                                if (av.a(th7)) {
                                                    return null;
                                                }
                                                th7.printStackTrace();
                                                return null;
                                            }
                                        } catch (IOException e16) {
                                            e = e16;
                                            c16 = 2;
                                            i27 = 1;
                                            i16 = 1;
                                            if (!av.a(e)) {
                                            }
                                            try {
                                                a16.disconnect();
                                            } catch (Throwable th8) {
                                                th5 = th8;
                                                if (av.a(th5)) {
                                                }
                                                th5.printStackTrace();
                                            }
                                            i19 = i3;
                                            i18 = i16;
                                            bArr2 = null;
                                            i17 = 0;
                                        }
                                    } else {
                                        i26++;
                                        c16 = 2;
                                        try {
                                            Object[] objArr = new Object[2];
                                            objArr[0] = Integer.valueOf(responseCode);
                                            i16 = 1;
                                            try {
                                                objArr[1] = headerField;
                                                av.c("redirect code: %d ,to:%s", objArr);
                                                str2 = headerField;
                                                i27 = 1;
                                                i3 = 0;
                                            } catch (IOException e17) {
                                                e = e17;
                                                str2 = headerField;
                                                i27 = i16;
                                                i3 = 0;
                                                if (!av.a(e)) {
                                                }
                                                a16.disconnect();
                                                i19 = i3;
                                                i18 = i16;
                                                bArr2 = null;
                                                i17 = 0;
                                            }
                                        } catch (IOException e18) {
                                            e = e18;
                                            i16 = 1;
                                        }
                                    }
                                } catch (IOException e19) {
                                    e = e19;
                                    c16 = 2;
                                    i16 = 1;
                                    i27 = 1;
                                }
                            } else {
                                c16 = 2;
                                i16 = 1;
                            }
                            try {
                                long contentLength = a16.getContentLength();
                                if (contentLength < 0) {
                                    contentLength = 0;
                                }
                                arVar.b(contentLength);
                                try {
                                    a16.disconnect();
                                } catch (Throwable th9) {
                                    th5 = th9;
                                    if (av.a(th5)) {
                                    }
                                    th5.printStackTrace();
                                }
                            } catch (IOException e26) {
                                e = e26;
                                if (!av.a(e)) {
                                    e.printStackTrace();
                                }
                                a16.disconnect();
                                i19 = i3;
                                i18 = i16;
                                bArr2 = null;
                                i17 = 0;
                            }
                        } finally {
                        }
                    } catch (IOException e27) {
                        e = e27;
                        c16 = 2;
                    }
                } else {
                    c16 = 2;
                    i16 = 1;
                    av.c("Failed to execute post.", new Object[0]);
                    arVar.b(0L);
                }
            }
            i19 = i3;
            i18 = i16;
            bArr2 = null;
            i17 = 0;
        }
        return bArr2;
    }

    private static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    private static HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            av.e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection a16 = a(str2, str);
        if (a16 == null) {
            av.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a16.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    a16.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            a16.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            a16.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = a16.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a16;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            av.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            Proxy proxy = ax.f98120a;
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }
}
