package com.tencent.smtt.utils;

import com.tencent.biz.common.util.HttpUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        void a(int i3);
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z16) {
        String b16;
        try {
            if (z16) {
                b16 = j.a().c();
            } else {
                b16 = i.a().b();
            }
            String str2 = str + b16;
            try {
                if (z16) {
                    bArr = j.a().a(bArr);
                } else {
                    bArr = i.a().a(bArr);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                TbsLog.e("HttpUtils", "rsaKey exception #2: " + e16);
            }
            if (bArr == null) {
                TbsLog.e("HttpUtils", "postData is null");
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(bArr.length));
            HttpURLConnection a16 = a(str2, hashMap);
            if (a16 == null) {
                return null;
            }
            a(a16, bArr);
            return a(a16, aVar, z16);
        } catch (Exception e17) {
            e17.printStackTrace();
            TbsLog.e("HttpUtils", "rsaKey exception #1: " + e17);
            return null;
        }
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e16) {
            e = e16;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setRequestProperty("Connection", "close");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            return httpURLConnection;
        } catch (Exception e17) {
            e = e17;
            httpURLConnection2 = httpURLConnection;
            TbsLog.e(HttpUtil.TAG, "initHttpPostURLConnection exception: " + e);
            return httpURLConnection2;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
            } catch (Exception e16) {
                TbsLog.e(HttpUtil.TAG, "writePostData exception: " + e16);
            }
        } finally {
            a(outputStream);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:8|(6:(9:(1:46)|14|15|16|17|18|(2:19|(1:21)(1:22))|(1:24)(1:29)|25)(1:12)|17|18|(3:19|(0)(0)|21)|(0)(0)|25)|13|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
    
        r4 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
    
        r0 = r5;
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: all -> 0x0078, LOOP:0: B:19:0x0048->B:21:0x004f, LOOP_END, TryCatch #1 {all -> 0x0078, blocks: (B:18:0x0046, B:19:0x0048, B:21:0x004f, B:24:0x0056, B:29:0x0066), top: B:17:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[EDGE_INSN: B:22:0x0054->B:23:0x0054 BREAK  A[LOOP:0: B:19:0x0048->B:21:0x004f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056 A[Catch: all -> 0x0078, TryCatch #1 {all -> 0x0078, blocks: (B:18:0x0046, B:19:0x0048, B:21:0x004f, B:24:0x0056, B:29:0x0066), top: B:17:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:18:0x0046, B:19:0x0048, B:21:0x004f, B:24:0x0056, B:29:0x0066), top: B:17:0x0046 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z16) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str;
        InputStream inflaterInputStream;
        byte[] bArr;
        int read;
        String str2;
        InputStream inputStream = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                try {
                    if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                        inflaterInputStream = new GZIPInputStream(inputStream2);
                    } else {
                        if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                            inflaterInputStream = new InflaterInputStream(inputStream2, new Inflater(true));
                        }
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        bArr = new byte[128];
                        while (true) {
                            read = inputStream2.read(bArr);
                            if (read != -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        if (!z16) {
                            str2 = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                        } else {
                            str2 = new String(i.a().c(byteArrayOutputStream2.toByteArray()));
                        }
                        String str3 = str2;
                        inputStream = inputStream2;
                        str = str3;
                    }
                    bArr = new byte[128];
                    while (true) {
                        read = inputStream2.read(bArr);
                        if (read != -1) {
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    if (!z16) {
                    }
                    String str32 = str2;
                    inputStream = inputStream2;
                    str = str32;
                } catch (Throwable th5) {
                    inputStream = inputStream2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th5;
                    try {
                        th.printStackTrace();
                        TbsLog.e(HttpUtil.TAG, "httpPost exception: " + th);
                        return "[HttpError] " + th.getMessage();
                    } finally {
                        a(inputStream);
                        a(byteArrayOutputStream);
                    }
                }
                inputStream2 = inflaterInputStream;
                byteArrayOutputStream2 = new ByteArrayOutputStream();
            } else {
                byteArrayOutputStream2 = null;
                str = null;
            }
            a(inputStream);
            a(byteArrayOutputStream2);
            return str;
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
