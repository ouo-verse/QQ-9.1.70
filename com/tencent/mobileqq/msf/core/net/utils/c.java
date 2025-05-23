package com.tencent.mobileqq.msf.core.net.utils;

import android.net.NetworkInfo;
import android.net.Proxy;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f249497a = "HttpDownloadUtil";

    /* renamed from: b, reason: collision with root package name */
    public static final int f249498b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f249499c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f249500d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249501e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249502f = 4;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249503g = 5;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final int f249504h = 7;

    /* renamed from: i, reason: collision with root package name */
    public static final int f249505i = 8;

    /* renamed from: j, reason: collision with root package name */
    public static final int f249506j = 10;

    /* renamed from: k, reason: collision with root package name */
    public static final int f249507k = 11;

    /* renamed from: l, reason: collision with root package name */
    public static final int f249508l = 13;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(String str, String str2) {
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        File file = new File(str2 + System.currentTimeMillis() + ".tmp");
        try {
            boolean z16 = a(new URL(str), file, recentNetworkInfo, 2) == 0;
            if (z16) {
                try {
                    file.renameTo(new File(str2));
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            return z16;
        } catch (MalformedURLException e17) {
            e17.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x046f A[ADDED_TO_REGION, EDGE_INSN: B:100:0x046f->B:99:0x046f BREAK  A[LOOP:0: B:32:0x00ae->B:97:0x0469], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x025e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03c7 A[Catch: Exception -> 0x03f9, TRY_ENTER, TryCatch #18 {Exception -> 0x03f9, blocks: (B:102:0x0263, B:104:0x0269, B:106:0x026f, B:107:0x0272, B:109:0x0278, B:111:0x027f, B:113:0x03f6, B:140:0x03c7, B:142:0x03cd, B:144:0x03d3, B:145:0x03d6, B:147:0x03dc, B:149:0x03e3), top: B:101:0x0263 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03a2 A[Catch: all -> 0x0470, TryCatch #30 {all -> 0x0470, blocks: (B:129:0x037b, B:132:0x0384, B:133:0x039a, B:159:0x03a2, B:161:0x03a6, B:164:0x03ab), top: B:128:0x037b }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0486 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0481 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0476 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x033c A[Catch: Exception -> 0x0369, TryCatch #2 {Exception -> 0x0369, blocks: (B:240:0x02cd, B:242:0x02d3, B:244:0x02d9, B:245:0x02dc, B:247:0x02e2, B:249:0x02e9, B:209:0x0336, B:211:0x033c, B:213:0x0342, B:214:0x0345, B:216:0x034b, B:218:0x0352), top: B:239:0x02cd }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x034b A[Catch: Exception -> 0x0369, TRY_LEAVE, TryCatch #2 {Exception -> 0x0369, blocks: (B:240:0x02cd, B:242:0x02d3, B:244:0x02d9, B:245:0x02dc, B:247:0x02e2, B:249:0x02e9, B:209:0x0336, B:211:0x033c, B:213:0x0342, B:214:0x0345, B:216:0x034b, B:218:0x0352), top: B:239:0x02cd }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0333 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0328 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x02d3 A[Catch: Exception -> 0x0369, TryCatch #2 {Exception -> 0x0369, blocks: (B:240:0x02cd, B:242:0x02d3, B:244:0x02d9, B:245:0x02dc, B:247:0x02e2, B:249:0x02e9, B:209:0x0336, B:211:0x033c, B:213:0x0342, B:214:0x0345, B:216:0x034b, B:218:0x0352), top: B:239:0x02cd }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02e2 A[Catch: Exception -> 0x0369, TRY_LEAVE, TryCatch #2 {Exception -> 0x0369, blocks: (B:240:0x02cd, B:242:0x02d3, B:244:0x02d9, B:245:0x02dc, B:247:0x02e2, B:249:0x02e9, B:209:0x0336, B:211:0x033c, B:213:0x0342, B:214:0x0345, B:216:0x034b, B:218:0x0352), top: B:239:0x02cd }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x02ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0453 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0464  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(URL url, File file, NetworkInfo networkInfo, int i3) {
        HttpGet httpGet;
        int i16;
        HttpEntity httpEntity;
        int i17;
        BufferedOutputStream bufferedOutputStream;
        int i18;
        HttpGet httpGet2;
        BasicHttpParams basicHttpParams;
        int i19;
        int i26;
        int i27;
        BufferedOutputStream bufferedOutputStream2;
        Throwable th5;
        File parentFile;
        String str;
        String str2;
        int i28;
        int i29;
        File parentFile2;
        int i36;
        long j3;
        long j16;
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = new Object();
        int i37 = i3 < 0 ? 2 : i3;
        try {
            File parentFile3 = file.getParentFile();
            if (parentFile3 != null && !parentFile3.exists()) {
                parentFile3.mkdirs();
            }
            String url2 = url.toString();
            try {
                try {
                    httpGet = new HttpGet(url2);
                } catch (IllegalArgumentException unused) {
                    QLog.d("HttpDownloadUtil", 1, "Download. result=DOWNLOAD_URL_STRING_ILLEGAL as new HttpGet exception.");
                    return 13;
                }
            } catch (IllegalArgumentException unused2) {
                httpGet = new HttpGet(a(url2));
            }
            BasicHttpParams basicHttpParams2 = new BasicHttpParams();
            int i38 = 20000;
            if (networkInfo != null) {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                String netGetExInfo = NetworkMonitor.netGetExInfo(networkInfo);
                if (NetConnInfoCenter.isMobileNetworkInfo(networkInfo) && ((netGetExInfo == null || netGetExInfo.endsWith("wap")) && defaultHost != null && defaultPort > 0)) {
                    basicHttpParams2.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(defaultHost, defaultPort));
                }
                if (NetConnInfoCenter.isMobileNetworkInfo(networkInfo)) {
                    basicHttpParams2.setIntParameter("http.socket.buffer-size", 2048);
                } else {
                    basicHttpParams2.setIntParameter("http.socket.buffer-size", 4096);
                    i38 = 10000;
                    i16 = 30000;
                    basicHttpParams2.setParameter("http.connection.timeout", Integer.valueOf(i38));
                    basicHttpParams2.setParameter("http.socket.timeout", Integer.valueOf(i16));
                    httpGet.setParams(basicHttpParams2);
                    if (file.exists()) {
                        file.delete();
                    }
                    httpEntity = null;
                    i17 = -1;
                    bufferedOutputStream = null;
                    while (true) {
                        if (i17 == 0) {
                            basicHttpParams2.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(url.getHost(), url.getPort()));
                            httpGet.setParams(basicHttpParams2);
                        }
                        try {
                            HttpResponse execute = a().execute(new HttpHost(url.getHost()), httpGet);
                            i28 = execute.getStatusLine().getStatusCode();
                            httpEntity = execute.getEntity();
                            if (200 != i28) {
                                httpGet2 = httpGet;
                                try {
                                    try {
                                        long contentLength = httpEntity.getContentLength();
                                        try {
                                            bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                                            try {
                                                httpEntity.writeTo(bufferedOutputStream2);
                                                bufferedOutputStream2.flush();
                                                i18 = i37;
                                                try {
                                                    j3 = file.length();
                                                    basicHttpParams = basicHttpParams2;
                                                } catch (FileNotFoundException unused3) {
                                                    basicHttpParams = basicHttpParams2;
                                                    i19 = i17;
                                                    j3 = 0;
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    QLog.d("HttpDownloadUtil", 1, "FileNotFoundException file exist=" + file.exists() + ", dir exist=" + file.getParentFile().exists());
                                                    j16 = j3;
                                                    i26 = 5;
                                                    if (contentLength > 0) {
                                                    }
                                                    i28 = i26;
                                                    if (httpEntity != null) {
                                                    }
                                                    if (bufferedOutputStream != null) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    i17 = i19 + 1;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    return i28;
                                                } catch (IOException e16) {
                                                    e = e16;
                                                    basicHttpParams = basicHttpParams2;
                                                    i19 = i17;
                                                    j3 = 0;
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("HttpDownloadUtil", 2, e.getMessage(), e);
                                                        }
                                                        j16 = j3;
                                                        i26 = 4;
                                                        if (contentLength > 0) {
                                                        }
                                                        i28 = i26;
                                                        if (httpEntity != null) {
                                                        }
                                                        if (bufferedOutputStream != null) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                    } catch (IOException e17) {
                                                        e = e17;
                                                        i27 = 5;
                                                        try {
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (!(e instanceof UnknownHostException)) {
                                                            }
                                                            i28 = i36;
                                                            if (httpEntity != null) {
                                                            }
                                                            if (bufferedOutputStream != null) {
                                                            }
                                                            if (i28 != 0) {
                                                            }
                                                            i17 = i19 + 1;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (i28 != 0) {
                                                            }
                                                            if (i28 != 0) {
                                                            }
                                                            if (i28 != 0) {
                                                            }
                                                            return i28;
                                                        } catch (Throwable th6) {
                                                            th5 = th6;
                                                            i26 = i27;
                                                            bufferedOutputStream2 = bufferedOutputStream;
                                                            if (httpEntity != null) {
                                                            }
                                                            if (bufferedOutputStream2 != null) {
                                                            }
                                                            if (i26 == 0) {
                                                            }
                                                        }
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        bufferedOutputStream2 = bufferedOutputStream;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (httpEntity != null) {
                                                        }
                                                        if (bufferedOutputStream2 != null) {
                                                        }
                                                        parentFile2 = file.getParentFile();
                                                        if (parentFile2 != null) {
                                                            parentFile2.mkdirs();
                                                        }
                                                        if (file.exists()) {
                                                        }
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        i28 = 5;
                                                        i17 = i19 + 1;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        return i28;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        i26 = 5;
                                                        bufferedOutputStream2 = bufferedOutputStream;
                                                        try {
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (httpEntity != null) {
                                                            }
                                                            if (bufferedOutputStream2 != null) {
                                                            }
                                                            try {
                                                                parentFile = file.getParentFile();
                                                                if (parentFile != null) {
                                                                    parentFile.mkdirs();
                                                                }
                                                                if (file.exists()) {
                                                                }
                                                            } catch (Exception unused4) {
                                                            }
                                                            bufferedOutputStream = bufferedOutputStream2;
                                                            i28 = 5;
                                                            i17 = i19 + 1;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (i28 != 0) {
                                                            }
                                                            if (i28 != 0) {
                                                            }
                                                            if (i28 != 0) {
                                                            }
                                                            return i28;
                                                        } catch (Throwable th8) {
                                                            th5 = th8;
                                                            if (httpEntity != null) {
                                                                try {
                                                                    httpEntity.consumeContent();
                                                                } catch (IOException e19) {
                                                                    e19.printStackTrace();
                                                                }
                                                            }
                                                            if (bufferedOutputStream2 != null) {
                                                                try {
                                                                    bufferedOutputStream2.close();
                                                                } catch (IOException unused5) {
                                                                }
                                                            }
                                                            if (i26 == 0) {
                                                                try {
                                                                    File parentFile4 = file.getParentFile();
                                                                    if (parentFile4 != null && !parentFile4.exists()) {
                                                                        parentFile4.mkdirs();
                                                                    }
                                                                    if (file.exists()) {
                                                                        QLog.d("HttpDownloadUtil", 1, "delete file in finally: " + file.delete());
                                                                        throw th5;
                                                                    }
                                                                    throw th5;
                                                                } catch (Exception unused6) {
                                                                    throw th5;
                                                                }
                                                            }
                                                            throw th5;
                                                        }
                                                    }
                                                    i17 = i19 + 1;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    return i28;
                                                } catch (Exception e26) {
                                                    e = e26;
                                                    basicHttpParams = basicHttpParams2;
                                                    i19 = i17;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (httpEntity != null) {
                                                    }
                                                    if (bufferedOutputStream2 != null) {
                                                    }
                                                    parentFile2 = file.getParentFile();
                                                    if (parentFile2 != null) {
                                                    }
                                                    if (file.exists()) {
                                                    }
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    i28 = 5;
                                                    i17 = i19 + 1;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    return i28;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    basicHttpParams = basicHttpParams2;
                                                    i19 = i17;
                                                    i26 = 5;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (httpEntity != null) {
                                                    }
                                                    if (bufferedOutputStream2 != null) {
                                                    }
                                                    parentFile = file.getParentFile();
                                                    if (parentFile != null) {
                                                    }
                                                    if (file.exists()) {
                                                    }
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    i28 = 5;
                                                    i17 = i19 + 1;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    if (i28 != 0) {
                                                    }
                                                    return i28;
                                                }
                                            } catch (FileNotFoundException unused7) {
                                                i18 = i37;
                                            } catch (IOException e27) {
                                                e = e27;
                                                i18 = i37;
                                            } catch (Exception e28) {
                                                e = e28;
                                                i18 = i37;
                                            } catch (Throwable th10) {
                                                th = th10;
                                                i18 = i37;
                                            }
                                            try {
                                                file.setLastModified(System.currentTimeMillis());
                                                if (QLog.isColorLevel()) {
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append("Download success. cost ");
                                                    i19 = i17;
                                                    try {
                                                        sb5.append(System.currentTimeMillis() - currentTimeMillis);
                                                        sb5.append(", size is ");
                                                        sb5.append(j3);
                                                        sb5.append(" for ");
                                                        sb5.append(url);
                                                        QLog.i("HttpDownloadUtil", 2, sb5.toString());
                                                    } catch (FileNotFoundException unused8) {
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        QLog.d("HttpDownloadUtil", 1, "FileNotFoundException file exist=" + file.exists() + ", dir exist=" + file.getParentFile().exists());
                                                        j16 = j3;
                                                        i26 = 5;
                                                        if (contentLength > 0) {
                                                        }
                                                        i28 = i26;
                                                        if (httpEntity != null) {
                                                        }
                                                        if (bufferedOutputStream != null) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        i17 = i19 + 1;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        return i28;
                                                    } catch (IOException e29) {
                                                        e = e29;
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        j16 = j3;
                                                        i26 = 4;
                                                        if (contentLength > 0) {
                                                        }
                                                        i28 = i26;
                                                        if (httpEntity != null) {
                                                        }
                                                        if (bufferedOutputStream != null) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        i17 = i19 + 1;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        return i28;
                                                    } catch (Exception e36) {
                                                        e = e36;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (httpEntity != null) {
                                                        }
                                                        if (bufferedOutputStream2 != null) {
                                                        }
                                                        parentFile2 = file.getParentFile();
                                                        if (parentFile2 != null) {
                                                        }
                                                        if (file.exists()) {
                                                        }
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        i28 = 5;
                                                        i17 = i19 + 1;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        return i28;
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        i26 = 5;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (httpEntity != null) {
                                                        }
                                                        if (bufferedOutputStream2 != null) {
                                                        }
                                                        parentFile = file.getParentFile();
                                                        if (parentFile != null) {
                                                        }
                                                        if (file.exists()) {
                                                        }
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        i28 = 5;
                                                        i17 = i19 + 1;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        if (i28 != 0) {
                                                        }
                                                        return i28;
                                                    }
                                                } else {
                                                    i19 = i17;
                                                }
                                                bufferedOutputStream = bufferedOutputStream2;
                                                j16 = j3;
                                                i26 = 0;
                                            } catch (FileNotFoundException unused9) {
                                                i19 = i17;
                                            } catch (IOException e37) {
                                                e = e37;
                                                i19 = i17;
                                            } catch (Exception e38) {
                                                e = e38;
                                                i19 = i17;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (httpEntity != null) {
                                                }
                                                if (bufferedOutputStream2 != null) {
                                                }
                                                parentFile2 = file.getParentFile();
                                                if (parentFile2 != null) {
                                                }
                                                if (file.exists()) {
                                                }
                                                bufferedOutputStream = bufferedOutputStream2;
                                                i28 = 5;
                                                i17 = i19 + 1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                return i28;
                                            } catch (Throwable th12) {
                                                th = th12;
                                                i19 = i17;
                                                i26 = 5;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (httpEntity != null) {
                                                }
                                                if (bufferedOutputStream2 != null) {
                                                }
                                                parentFile = file.getParentFile();
                                                if (parentFile != null) {
                                                }
                                                if (file.exists()) {
                                                }
                                                bufferedOutputStream = bufferedOutputStream2;
                                                i28 = 5;
                                                i17 = i19 + 1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                return i28;
                                            }
                                        } catch (FileNotFoundException unused10) {
                                            i18 = i37;
                                            basicHttpParams = basicHttpParams2;
                                            i19 = i17;
                                            j3 = 0;
                                        } catch (IOException e39) {
                                            e = e39;
                                            i18 = i37;
                                            basicHttpParams = basicHttpParams2;
                                            i19 = i17;
                                            j3 = 0;
                                        }
                                        if (contentLength > 0 || j16 >= contentLength) {
                                            i28 = i26;
                                        } else {
                                            try {
                                                if (QLog.isColorLevel()) {
                                                    QLog.w("HttpDownloadUtil", 2, "Download fail. contentLen=" + contentLength + ", fileLen=" + file.length() + ", url=" + url);
                                                }
                                                i28 = 8;
                                            } catch (IOException e46) {
                                                e = e46;
                                                i27 = i26;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (!(e instanceof UnknownHostException)) {
                                                }
                                                i28 = i36;
                                                if (httpEntity != null) {
                                                }
                                                if (bufferedOutputStream != null) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                i17 = i19 + 1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                return i28;
                                            } catch (Exception e47) {
                                                e = e47;
                                                bufferedOutputStream2 = bufferedOutputStream;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (httpEntity != null) {
                                                }
                                                if (bufferedOutputStream2 != null) {
                                                }
                                                parentFile2 = file.getParentFile();
                                                if (parentFile2 != null) {
                                                }
                                                if (file.exists()) {
                                                }
                                                bufferedOutputStream = bufferedOutputStream2;
                                                i28 = 5;
                                                i17 = i19 + 1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                return i28;
                                            } catch (Throwable th13) {
                                                th = th13;
                                                bufferedOutputStream2 = bufferedOutputStream;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (httpEntity != null) {
                                                }
                                                if (bufferedOutputStream2 != null) {
                                                }
                                                parentFile = file.getParentFile();
                                                if (parentFile != null) {
                                                }
                                                if (file.exists()) {
                                                }
                                                bufferedOutputStream = bufferedOutputStream2;
                                                i28 = 5;
                                                i17 = i19 + 1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                return i28;
                                            }
                                        }
                                    } catch (Exception e48) {
                                        e = e48;
                                        i18 = i37;
                                        basicHttpParams = basicHttpParams2;
                                        i19 = i17;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        if (QLog.isColorLevel()) {
                                            QLog.d("HttpDownloadUtil", 2, "Download fail 2. url=" + url, e);
                                        }
                                        if (httpEntity != null) {
                                            try {
                                                httpEntity.consumeContent();
                                            } catch (IOException e49) {
                                                e49.printStackTrace();
                                            }
                                        }
                                        if (bufferedOutputStream2 != null) {
                                            try {
                                                bufferedOutputStream2.close();
                                            } catch (IOException unused11) {
                                            }
                                        }
                                        parentFile2 = file.getParentFile();
                                        if (parentFile2 != null && !parentFile2.exists()) {
                                            parentFile2.mkdirs();
                                        }
                                        if (file.exists()) {
                                            str = "HttpDownloadUtil";
                                            str2 = "delete file in finally: " + file.delete();
                                            bufferedOutputStream = bufferedOutputStream2;
                                            i29 = 1;
                                            i28 = 5;
                                            QLog.d(str, i29, str2);
                                            i17 = i19 + 1;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (i28 != 0) {
                                            }
                                            if (i28 != 0) {
                                            }
                                            if (i28 != 0) {
                                            }
                                            return i28;
                                        }
                                        bufferedOutputStream = bufferedOutputStream2;
                                        i28 = 5;
                                        i17 = i19 + 1;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        return i28;
                                    } catch (Throwable th14) {
                                        th = th14;
                                        i18 = i37;
                                        basicHttpParams = basicHttpParams2;
                                        i19 = i17;
                                        i26 = 5;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        if (QLog.isColorLevel()) {
                                            QLog.d("HttpDownloadUtil", 2, "Download fail 2. url=" + url, th);
                                        }
                                        if (httpEntity != null) {
                                            try {
                                                httpEntity.consumeContent();
                                            } catch (IOException e56) {
                                                e56.printStackTrace();
                                            }
                                        }
                                        if (bufferedOutputStream2 != null) {
                                            try {
                                                bufferedOutputStream2.close();
                                            } catch (IOException unused12) {
                                            }
                                        }
                                        parentFile = file.getParentFile();
                                        if (parentFile != null && !parentFile.exists()) {
                                            parentFile.mkdirs();
                                        }
                                        if (file.exists()) {
                                            str = "HttpDownloadUtil";
                                            str2 = "delete file in finally: " + file.delete();
                                            bufferedOutputStream = bufferedOutputStream2;
                                            i29 = 1;
                                            i28 = 5;
                                            QLog.d(str, i29, str2);
                                            i17 = i19 + 1;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (i28 != 0) {
                                            }
                                            if (i28 != 0) {
                                            }
                                            if (i28 != 0) {
                                            }
                                            return i28;
                                        }
                                        bufferedOutputStream = bufferedOutputStream2;
                                        i28 = 5;
                                        i17 = i19 + 1;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        return i28;
                                    }
                                } catch (IOException e57) {
                                    e = e57;
                                    i18 = i37;
                                    basicHttpParams = basicHttpParams2;
                                    i19 = i17;
                                    i27 = 5;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("HttpDownloadUtil", 2, "Download fail 1. url=" + url, e);
                                    }
                                    if (!(e instanceof UnknownHostException)) {
                                        if (!(e instanceof ConnectTimeoutException) && !(e instanceof SocketTimeoutException)) {
                                            if (!(e instanceof SocketException)) {
                                                i28 = 4;
                                                if (httpEntity != null) {
                                                    try {
                                                        httpEntity.consumeContent();
                                                    } catch (IOException e58) {
                                                        e58.printStackTrace();
                                                    }
                                                }
                                                if (bufferedOutputStream != null) {
                                                    try {
                                                        bufferedOutputStream.close();
                                                    } catch (IOException unused13) {
                                                    }
                                                }
                                                if (i28 != 0) {
                                                    File parentFile5 = file.getParentFile();
                                                    if (parentFile5 != null && !parentFile5.exists()) {
                                                        parentFile5.mkdirs();
                                                    }
                                                    if (file.exists()) {
                                                        str = "HttpDownloadUtil";
                                                        str2 = "delete file in finally: " + file.delete();
                                                        i29 = 1;
                                                        QLog.d(str, i29, str2);
                                                    }
                                                }
                                                i17 = i19 + 1;
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                if (i28 != 0) {
                                                }
                                                return i28;
                                            }
                                            i36 = 11;
                                        }
                                        i28 = 2;
                                        if (httpEntity != null) {
                                        }
                                        if (bufferedOutputStream != null) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        i17 = i19 + 1;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        if (i28 != 0) {
                                        }
                                        return i28;
                                    }
                                    i36 = 10;
                                    i28 = i36;
                                    if (httpEntity != null) {
                                    }
                                    if (bufferedOutputStream != null) {
                                    }
                                    if (i28 != 0) {
                                    }
                                    i17 = i19 + 1;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (i28 != 0) {
                                    }
                                    if (i28 != 0) {
                                    }
                                    if (i28 != 0) {
                                    }
                                    return i28;
                                }
                            } else {
                                i18 = i37;
                                httpGet2 = httpGet;
                                basicHttpParams = basicHttpParams2;
                                i19 = i17;
                            }
                            if (httpEntity != null) {
                                try {
                                    httpEntity.consumeContent();
                                } catch (IOException e59) {
                                    e59.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused14) {
                                }
                            }
                        } catch (IOException e65) {
                            e = e65;
                            i18 = i37;
                            httpGet2 = httpGet;
                        } catch (Exception e66) {
                            e = e66;
                            i18 = i37;
                            httpGet2 = httpGet;
                        } catch (Throwable th15) {
                            th = th15;
                            i18 = i37;
                            httpGet2 = httpGet;
                        }
                        if (i28 != 0) {
                            try {
                                File parentFile6 = file.getParentFile();
                                if (parentFile6 != null && !parentFile6.exists()) {
                                    parentFile6.mkdirs();
                                }
                                if (file.exists()) {
                                    str = "HttpDownloadUtil";
                                    str2 = "delete file in finally: " + file.delete();
                                    i29 = 1;
                                    QLog.d(str, i29, str2);
                                }
                            } catch (Exception unused15) {
                            }
                        }
                        i17 = i19 + 1;
                        if (QLog.isColorLevel()) {
                            QLog.d("HttpDownloadUtil", 2, "Download. result=" + i28 + ", url=" + url);
                        }
                        if (i28 != 0) {
                            QLog.d("HttpDownloadUtil", 1, "Download. result=" + i28 + ", url=" + url + ", tryCount=" + i17);
                        }
                        if (i28 != 0 && i17 < 2) {
                            synchronized (obj) {
                                try {
                                    obj.wait(500L);
                                } catch (InterruptedException unused16) {
                                }
                            }
                        }
                        if (i28 != 0 || i17 >= (i37 = i18)) {
                            break;
                        }
                        httpGet = httpGet2;
                        basicHttpParams2 = basicHttpParams;
                    }
                    return i28;
                }
            }
            i16 = 60000;
            basicHttpParams2.setParameter("http.connection.timeout", Integer.valueOf(i38));
            basicHttpParams2.setParameter("http.socket.timeout", Integer.valueOf(i16));
            httpGet.setParams(basicHttpParams2);
            if (file.exists()) {
            }
            httpEntity = null;
            i17 = -1;
            bufferedOutputStream = null;
            while (true) {
                if (i17 == 0) {
                }
                HttpResponse execute2 = a().execute(new HttpHost(url.getHost()), httpGet);
                i28 = execute2.getStatusLine().getStatusCode();
                httpEntity = execute2.getEntity();
                if (200 != i28) {
                }
                if (httpEntity != null) {
                }
                if (bufferedOutputStream != null) {
                }
                if (i28 != 0) {
                }
                i17 = i19 + 1;
                if (QLog.isColorLevel()) {
                }
                if (i28 != 0) {
                }
                if (i28 != 0) {
                    synchronized (obj) {
                    }
                }
                if (i28 != 0) {
                    break;
                }
                break;
                httpGet = httpGet2;
                basicHttpParams2 = basicHttpParams;
            }
            return i28;
        } catch (Exception unused17) {
            QLog.d("HttpDownloadUtil", 1, "Download. result=DOWNLOAD_SAVE_FILE_FAIL as file exception.");
            return 4;
        }
    }

    private static HttpClient a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "ISO-8859-1");
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, true);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            schemeRegistry.register(new Scheme("https", socketFactory, WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("HttpDownloadUtil", 2, "createHttpClient():Can't support https on this devices.", e16);
            }
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        defaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
        return defaultHttpClient;
    }

    public static String a(String str) {
        return str.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
    }
}
