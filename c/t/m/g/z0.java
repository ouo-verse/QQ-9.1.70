package c.t.m.g;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;

/* compiled from: P */
/* loaded from: classes.dex */
public class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static e0 f30126a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);

        void a(byte[] bArr);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i3, Map<String, Object> map);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface c {
        void a(String str);

        void b(String str);
    }

    public static void a(String str, byte[] bArr, Object obj) {
        if (bArr == null) {
            bArr = k0.f29815a;
        }
        a(str, bArr, 0, obj);
    }

    public static byte[] a(String str, Object obj) {
        c cVar = (obj == null || !(obj instanceof c)) ? null : (c) obj;
        a aVar = (obj == null || !(obj instanceof a)) ? null : (a) obj;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.connect();
            byte[] a16 = a(httpURLConnection.getInputStream());
            if (a16 != null) {
                int length = str.getBytes().length;
            }
            if (aVar != null) {
                aVar.a(a16);
            }
            if (cVar != null) {
                cVar.b(new String(a16, "UTF-8"));
            }
            httpURLConnection.disconnect();
            return a16;
        } catch (Throwable th5) {
            long length2 = str.getBytes().length;
            c1.a(HttpUtil.TAG, "getSync error.", th5);
            if (aVar != null) {
                aVar.a(th5.toString());
            }
            if (cVar != null) {
                cVar.a(th5.toString());
            }
            e0 e0Var = f30126a;
            if (e0Var != null) {
                e0Var.a(str, currentTimeMillis, length2, 0L, System.currentTimeMillis() - currentTimeMillis, false);
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01aa A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, byte[] bArr, int i3, Object obj) {
        Object obj2;
        long j3;
        long j16;
        String str2;
        boolean z16;
        boolean z17;
        long j17;
        long j18;
        e0 e0Var;
        long j19;
        c cVar = (obj == null || !(obj instanceof c)) ? null : (c) obj;
        a aVar = (obj == null || !(obj instanceof a)) ? null : (a) obj;
        b bVar = (obj == null || !(obj instanceof b)) ? null : (b) obj;
        HashMap hashMap = bVar != null ? new HashMap() : null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoOutput(true);
            j3 = currentTimeMillis;
            long length = bArr.length;
            try {
                httpURLConnection.setFixedLengthStreamingMode(length);
                httpURLConnection.setRequestProperty("Connection", "close");
                a(bArr, httpURLConnection.getOutputStream());
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    if (responseCode != 200) {
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            j16 = length;
                            sb5.append("net sdk error: ");
                            sb5.append(responseCode);
                            String sb6 = sb5.toString();
                            if (cVar != null) {
                                cVar.a(sb6);
                            }
                            if (aVar != null) {
                                aVar.a(sb6);
                            }
                            if (bVar != null && hashMap != null) {
                                hashMap.put("resp_code", Integer.valueOf(responseCode));
                                hashMap.put("msg_fail", sb6);
                                bVar.a(0, hashMap);
                            }
                            try {
                                httpURLConnection.getInputStream().close();
                            } catch (Throwable th5) {
                                c1.a(HttpUtil.TAG, "postSync close input stream error.", th5);
                            }
                            obj2 = "msg_fail";
                            z17 = false;
                            j19 = 4;
                        } catch (Throwable th6) {
                            th = th6;
                            j16 = length;
                            obj2 = "msg_fail";
                            String str3 = "postSync error.";
                            if (th instanceof UnknownHostException) {
                                str3 = "postSync error." + th.getMessage();
                            }
                            c1.a(HttpUtil.TAG, str3, th);
                            if (i3 >= 1 && ((th instanceof GeneralSecurityException) || (th instanceof SSLException))) {
                                a(str.replaceAll("https:", "http:"), bArr, i3 + 1, obj);
                            } else {
                                str2 = "tryTime=" + i3 + "," + str + "," + c1.a(th);
                                if (cVar != null) {
                                    cVar.a(str2);
                                }
                                if (aVar != null) {
                                    aVar.a(str2);
                                }
                                if (bVar != null && hashMap != null) {
                                    hashMap.put(obj2, str2);
                                    z16 = false;
                                    bVar.a(0, hashMap);
                                    z17 = z16;
                                    j17 = j16;
                                    j18 = 4;
                                    e0Var = f30126a;
                                    if (e0Var == null) {
                                    }
                                }
                            }
                            z16 = false;
                            z17 = z16;
                            j17 = j16;
                            j18 = 4;
                            e0Var = f30126a;
                            if (e0Var == null) {
                            }
                        }
                    } else {
                        j16 = length;
                        String a16 = a(httpURLConnection.getHeaderField("content-type"));
                        byte[] a17 = a(httpURLConnection.getInputStream());
                        if (a17 != null) {
                            obj2 = "msg_fail";
                            j19 = a17.length;
                        } else {
                            obj2 = "msg_fail";
                            j19 = 0;
                        }
                        if (aVar != null) {
                            try {
                                aVar.a(a17);
                            } catch (Throwable th7) {
                                th = th7;
                                String str32 = "postSync error.";
                                if (th instanceof UnknownHostException) {
                                }
                                c1.a(HttpUtil.TAG, str32, th);
                                if (i3 >= 1) {
                                }
                                str2 = "tryTime=" + i3 + "," + str + "," + c1.a(th);
                                if (cVar != null) {
                                }
                                if (aVar != null) {
                                }
                                if (bVar != null) {
                                    hashMap.put(obj2, str2);
                                    z16 = false;
                                    bVar.a(0, hashMap);
                                    z17 = z16;
                                    j17 = j16;
                                    j18 = 4;
                                    e0Var = f30126a;
                                    if (e0Var == null) {
                                    }
                                }
                                z16 = false;
                                z17 = z16;
                                j17 = j16;
                                j18 = 4;
                                e0Var = f30126a;
                                if (e0Var == null) {
                                }
                            }
                        }
                        if (cVar != null) {
                            cVar.b(new String(a17, a16));
                        }
                        if (bVar != null && hashMap != null) {
                            hashMap.put("resp_code", Integer.valueOf(responseCode));
                            hashMap.put(HttpMsg.CHARSET, a16);
                            hashMap.put("byte_data", a17);
                            bVar.a(1, hashMap);
                        }
                        z17 = true;
                    }
                    httpURLConnection.disconnect();
                    j18 = j19;
                    j17 = j16;
                } catch (Throwable th8) {
                    th = th8;
                    obj2 = "msg_fail";
                    String str322 = "postSync error.";
                    if (th instanceof UnknownHostException) {
                    }
                    c1.a(HttpUtil.TAG, str322, th);
                    if (i3 >= 1) {
                    }
                    str2 = "tryTime=" + i3 + "," + str + "," + c1.a(th);
                    if (cVar != null) {
                    }
                    if (aVar != null) {
                    }
                    if (bVar != null) {
                    }
                    z16 = false;
                    z17 = z16;
                    j17 = j16;
                    j18 = 4;
                    e0Var = f30126a;
                    if (e0Var == null) {
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                obj2 = "msg_fail";
                j16 = length;
            }
        } catch (Throwable th10) {
            th = th10;
            obj2 = "msg_fail";
            j3 = currentTimeMillis;
            j16 = 0;
        }
        e0Var = f30126a;
        if (e0Var == null) {
            e0Var.a(str, j3, j17, j18, System.currentTimeMillis() - j3, z17);
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        byte[] a16 = j0.a().a(512);
        while (true) {
            int read = inputStream.read(a16);
            if (read != -1) {
                byteArrayOutputStream.write(a16, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                j0.a().a(a16);
                return byteArray;
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
