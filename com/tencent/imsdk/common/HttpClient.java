package com.tencent.imsdk.common;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HttpClient {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final int HTTP_ACTION_REQUEST = 0;
    public static final int HTTP_ACTION_RESPONSE = 1;
    private static final long KEEP_ALIVE = 5;
    private static final int MAX_POOL_SIZE;
    private static final String TAG = "HttpClient";
    private static HttpsHostnameVerifier mHostnameVerifier;
    private static boolean mNeedRollbackHttps2Http;
    private static String mRollbackHttps2Http;
    private static final Executor mThreadPoolExecutor;
    private static TrustManager[] mTrustManagers;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface HttpRequestListener {
        void onCompleted(int i3, Map<String, String> map, byte[] bArr);

        void onProgress(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class HttpsHostnameVerifier implements HostnameVerifier {
        private boolean enableHostVerify;

        HttpsHostnameVerifier() {
            this.enableHostVerify = false;
        }

        public void setEnableHostVerify(boolean z16) {
            this.enableHostVerify = z16;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (!this.enableHostVerify || str.contains(Constants.Configs.CLOUD) || str.contains("tim") || str.contains("qq.com")) {
                return true;
            }
            return false;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i3 = availableProcessors + 1;
        CORE_POOL_SIZE = i3;
        int i16 = (availableProcessors * 2) + 1;
        MAX_POOL_SIZE = i16;
        mRollbackHttps2Http = "";
        mNeedRollbackHttps2Http = false;
        mTrustManagers = new TrustManager[]{new X509TrustManager() { // from class: com.tencent.imsdk.common.HttpClient.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                try {
                    x509CertificateArr[0].checkValidity();
                } catch (CertificateExpiredException e16) {
                    e16.printStackTrace();
                } catch (CertificateNotYetValidException e17) {
                    e17.printStackTrace();
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                try {
                    x509CertificateArr[0].checkValidity();
                } catch (CertificateExpiredException e16) {
                    e16.printStackTrace();
                } catch (CertificateNotYetValidException e17) {
                    e17.printStackTrace();
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        mHostnameVerifier = new HttpsHostnameVerifier();
        mThreadPoolExecutor = new BaseThreadPoolExecutor(i3, i16, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    private static void httpRequest(final String str, final String str2, final Map<String, String> map, final byte[] bArr, final String str3, final String str4, final HttpRequestListener httpRequestListener, final String str5, final int i3, final int i16, final int i17, final int i18, final String str6) {
        mThreadPoolExecutor.execute(new Runnable() { // from class: com.tencent.imsdk.common.HttpClient.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:101:0x024d  */
            /* JADX WARN: Removed duplicated region for block: B:104:0x0254  */
            /* JADX WARN: Removed duplicated region for block: B:105:0x0242 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:116:0x02a3  */
            /* JADX WARN: Removed duplicated region for block: B:119:0x02aa  */
            /* JADX WARN: Removed duplicated region for block: B:121:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:122:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:133:0x0173  */
            /* JADX WARN: Removed duplicated region for block: B:140:0x0183 A[Catch: all -> 0x01e9, Exception -> 0x01ed, UnknownHostException -> 0x01f0, TRY_LEAVE, TryCatch #16 {UnknownHostException -> 0x01f0, Exception -> 0x01ed, all -> 0x01e9, blocks: (B:73:0x015e, B:131:0x016d, B:134:0x0174, B:136:0x0178, B:140:0x0183), top: B:72:0x015e }] */
            /* JADX WARN: Removed duplicated region for block: B:162:0x01e4  */
            /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:165:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:180:0x01d1  */
            /* JADX WARN: Removed duplicated region for block: B:183:0x016c  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0115 A[Catch: all -> 0x0205, Exception -> 0x020a, UnknownHostException -> 0x020e, TryCatch #18 {UnknownHostException -> 0x020e, Exception -> 0x020a, all -> 0x0205, blocks: (B:17:0x0070, B:19:0x0078, B:22:0x0091, B:24:0x00a5, B:26:0x00be, B:27:0x00c6, B:29:0x00cc, B:31:0x00e2, B:33:0x00e6, B:36:0x00ec, B:38:0x00f0, B:45:0x0101, B:48:0x0110, B:50:0x0115, B:51:0x0124, B:52:0x012e, B:62:0x0134, B:54:0x0138, B:57:0x0144, B:63:0x011d, B:64:0x0148), top: B:16:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0138 A[Catch: all -> 0x0205, Exception -> 0x020a, UnknownHostException -> 0x020e, TryCatch #18 {UnknownHostException -> 0x020e, Exception -> 0x020a, all -> 0x0205, blocks: (B:17:0x0070, B:19:0x0078, B:22:0x0091, B:24:0x00a5, B:26:0x00be, B:27:0x00c6, B:29:0x00cc, B:31:0x00e2, B:33:0x00e6, B:36:0x00ec, B:38:0x00f0, B:45:0x0101, B:48:0x0110, B:50:0x0115, B:51:0x0124, B:52:0x012e, B:62:0x0134, B:54:0x0138, B:57:0x0144, B:63:0x011d, B:64:0x0148), top: B:16:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0134 A[EDGE_INSN: B:61:0x0134->B:62:0x0134 BREAK  A[LOOP:1: B:52:0x012e->B:59:0x012e], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:63:0x011d A[Catch: all -> 0x0205, Exception -> 0x020a, UnknownHostException -> 0x020e, TryCatch #18 {UnknownHostException -> 0x020e, Exception -> 0x020a, all -> 0x0205, blocks: (B:17:0x0070, B:19:0x0078, B:22:0x0091, B:24:0x00a5, B:26:0x00be, B:27:0x00c6, B:29:0x00cc, B:31:0x00e2, B:33:0x00e6, B:36:0x00ec, B:38:0x00f0, B:45:0x0101, B:48:0x0110, B:50:0x0115, B:51:0x0124, B:52:0x012e, B:62:0x0134, B:54:0x0138, B:57:0x0144, B:63:0x011d, B:64:0x0148), top: B:16:0x0070 }] */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0156 A[Catch: all -> 0x01f3, Exception -> 0x01fa, UnknownHostException -> 0x01ff, TRY_LEAVE, TryCatch #13 {UnknownHostException -> 0x01ff, Exception -> 0x01fa, all -> 0x01f3, blocks: (B:67:0x014c, B:69:0x0156), top: B:66:0x014c }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x0287  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x028e  */
            /* JADX WARN: Removed duplicated region for block: B:88:0x027c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r0v18, types: [com.tencent.imsdk.common.HttpClient$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r0v42, types: [com.tencent.imsdk.common.HttpClient$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r0v48, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r0v49 */
            /* JADX WARN: Type inference failed for: r0v50, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r0v8, types: [com.tencent.imsdk.common.HttpClient$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v19, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r2v36 */
            /* JADX WARN: Type inference failed for: r3v12, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r3v30 */
            /* JADX WARN: Type inference failed for: r3v31 */
            /* JADX WARN: Type inference failed for: r3v41 */
            /* JADX WARN: Type inference failed for: r3v42 */
            /* JADX WARN: Type inference failed for: r3v43 */
            /* JADX WARN: Type inference failed for: r3v6, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v10 */
            /* JADX WARN: Type inference failed for: r5v11, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r5v12 */
            /* JADX WARN: Type inference failed for: r5v13 */
            /* JADX WARN: Type inference failed for: r5v14 */
            /* JADX WARN: Type inference failed for: r5v15 */
            /* JADX WARN: Type inference failed for: r5v16 */
            /* JADX WARN: Type inference failed for: r5v17 */
            /* JADX WARN: Type inference failed for: r5v19 */
            /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r5v4 */
            /* JADX WARN: Type inference failed for: r5v5, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r5v6 */
            /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r5v8 */
            /* JADX WARN: Type inference failed for: r5v9 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Throwable th5;
                String str7;
                HttpURLConnection httpURLConnection;
                HashMap hashMap;
                String str8;
                Object obj;
                ?? r36;
                ?? r06;
                String str9;
                HttpRequestListener httpRequestListener2;
                ?? r37;
                String str10;
                ?? r07;
                boolean z16;
                int responseCode;
                Object obj2;
                String str11;
                Object obj3;
                String str12;
                String str13;
                int size;
                int contentLength;
                ?? r26;
                ?? r08;
                OutputStream byteArrayOutputStream;
                InputStream byteArrayInputStream;
                byte[] bArr2;
                int read;
                String str14 = "http request failed.";
                String str15 = str2;
                String str16 = "https";
                if (str15.startsWith("https")) {
                    if (!HttpClient.mRollbackHttps2Http.equals(str6)) {
                        String unused = HttpClient.mRollbackHttps2Http = str6;
                        boolean unused2 = HttpClient.mNeedRollbackHttps2Http = HttpClient.needRollbackHttps2Http(str6);
                    }
                    if (HttpClient.mNeedRollbackHttps2Http) {
                        str15 = str2.replaceFirst("https", "http");
                    }
                }
                int i19 = -1;
                ?? r56 = null;
                int i26 = 200;
                try {
                    try {
                        if (!str5.isEmpty() && i3 != 0) {
                            httpURLConnection = (HttpURLConnection) new URL(str15).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str5, i3)));
                        } else {
                            httpURLConnection = (HttpURLConnection) new URL(str15).openConnection();
                        }
                    } catch (UnknownHostException e16) {
                        e = e16;
                        obj = null;
                        httpURLConnection = null;
                        hashMap = null;
                    } catch (Exception e17) {
                        e = e17;
                        str8 = null;
                        httpURLConnection = null;
                        hashMap = null;
                        str9 = str14;
                    } catch (Throwable th6) {
                        th5 = th6;
                        str7 = null;
                        httpURLConnection = null;
                        hashMap = null;
                    }
                    try {
                        if (str15.startsWith("https")) {
                            SSLContext sSLContext = SSLContext.getInstance("TLS");
                            sSLContext.init(null, HttpClient.mTrustManagers, null);
                            HttpClient.mHostnameVerifier.setEnableHostVerify(i18 == 1);
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                            httpsURLConnection.setHostnameVerifier(HttpClient.mHostnameVerifier);
                        }
                        httpURLConnection.setRequestMethod(str);
                        httpURLConnection.setConnectTimeout(i16);
                        httpURLConnection.setReadTimeout(i17);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        Map map2 = map;
                        if (map2 != null) {
                            for (Map.Entry entry : map2.entrySet()) {
                                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        byte[] bArr3 = bArr;
                        boolean z17 = bArr3 != null && bArr3.length > 0;
                        String str17 = str3;
                        boolean z18 = (str17 == null || str17.length() == 0) ? false : true;
                        try {
                            if (!z17 && !z18) {
                                z16 = false;
                                if (!str.equalsIgnoreCase("GET") && z16) {
                                    httpURLConnection.setDoOutput(true);
                                    if (!z18) {
                                        byteArrayInputStream = new FileInputStream(str3);
                                    } else {
                                        byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    }
                                    int available = byteArrayInputStream.available();
                                    httpURLConnection.setFixedLengthStreamingMode(available);
                                    bArr2 = new byte[4096];
                                    int i27 = 0;
                                    while (true) {
                                        read = byteArrayInputStream.read(bArr2);
                                        if (read >= 0) {
                                            break;
                                        }
                                        i27 += read;
                                        httpURLConnection.getOutputStream().write(bArr2, 0, read);
                                        HttpRequestListener httpRequestListener3 = httpRequestListener;
                                        if (httpRequestListener3 != null) {
                                            httpRequestListener3.onProgress(0, i27, available);
                                        }
                                    }
                                    byteArrayInputStream.close();
                                }
                                responseCode = httpURLConnection.getResponseCode();
                                size = httpURLConnection.getHeaderFields().size();
                                if (size <= 0) {
                                    hashMap = new HashMap();
                                    for (int i28 = 0; i28 < size; i28++) {
                                        try {
                                            hashMap.put(httpURLConnection.getHeaderFieldKey(i28), httpURLConnection.getHeaderField(i28));
                                        } catch (UnknownHostException e18) {
                                            e = e18;
                                            obj3 = null;
                                            str13 = str14;
                                            i19 = responseCode;
                                            str10 = str13;
                                            r37 = obj3;
                                            IMLog.e(HttpClient.TAG, str10 + e.getLocalizedMessage());
                                            if (r56 != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            r07 = httpRequestListener;
                                            str16 = r37;
                                            if (r07 != 0) {
                                            }
                                        } catch (Exception e19) {
                                            e = e19;
                                            str11 = null;
                                            str12 = str14;
                                            i26 = responseCode;
                                            str9 = str12;
                                            str8 = str11;
                                            try {
                                                IMLog.e(HttpClient.TAG, str9 + e.getLocalizedMessage());
                                                byte[] bytes = Log.getStackTraceString(e).getBytes();
                                                String str18 = str8;
                                                if (r56 != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                httpRequestListener2 = httpRequestListener;
                                                str16 = str18;
                                                if (httpRequestListener2 != null) {
                                                }
                                            } catch (Throwable th7) {
                                                th5 = th7;
                                                str7 = str8;
                                                i19 = i26;
                                                r36 = str7;
                                                if (r56 != null) {
                                                    try {
                                                        r56.close();
                                                    } catch (IOException e26) {
                                                        e26.printStackTrace();
                                                    }
                                                }
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                r06 = httpRequestListener;
                                                if (r06 == 0) {
                                                    r06.onCompleted(i19, hashMap, r36);
                                                    throw th5;
                                                }
                                                throw th5;
                                            }
                                        } catch (Throwable th8) {
                                            th5 = th8;
                                            obj2 = null;
                                            i19 = responseCode;
                                            r36 = obj2;
                                            if (r56 != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            r06 = httpRequestListener;
                                            if (r06 == 0) {
                                            }
                                        }
                                    }
                                } else {
                                    hashMap = null;
                                }
                                contentLength = httpURLConnection.getContentLength();
                                if (contentLength == -1) {
                                    contentLength = 0;
                                }
                                String str19 = str4;
                                boolean z19 = str19 == null && str19.length() != 0;
                                if (responseCode != 200) {
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                    try {
                                        if (z19) {
                                            byteArrayOutputStream = new FileOutputStream(str4);
                                        } else {
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                        }
                                        byte[] bArr4 = new byte[4096];
                                        int i29 = 0;
                                        while (true) {
                                            int read2 = bufferedInputStream.read(bArr4);
                                            if (read2 < 0) {
                                                break;
                                            }
                                            i29 += read2;
                                            byteArrayOutputStream.write(bArr4, 0, read2);
                                            HttpRequestListener httpRequestListener4 = httpRequestListener;
                                            if (httpRequestListener4 != null) {
                                                httpRequestListener4.onProgress(1, i29, contentLength);
                                            }
                                        }
                                        String byteArray = z19 ? new byte[0] : ((ByteArrayOutputStream) byteArrayOutputStream).toByteArray();
                                        byteArrayOutputStream.close();
                                        str14 = byteArray;
                                        r56 = bufferedInputStream;
                                        r26 = str14;
                                    } catch (UnknownHostException e27) {
                                        e = e27;
                                        obj3 = r56;
                                        r56 = bufferedInputStream;
                                        str13 = str14;
                                        i19 = responseCode;
                                        str10 = str13;
                                        r37 = obj3;
                                        IMLog.e(HttpClient.TAG, str10 + e.getLocalizedMessage());
                                        if (r56 != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        r07 = httpRequestListener;
                                        str16 = r37;
                                        if (r07 != 0) {
                                        }
                                    } catch (Exception e28) {
                                        e = e28;
                                        str11 = r56;
                                        r56 = bufferedInputStream;
                                        str12 = str14;
                                        i26 = responseCode;
                                        str9 = str12;
                                        str8 = str11;
                                        IMLog.e(HttpClient.TAG, str9 + e.getLocalizedMessage());
                                        byte[] bytes2 = Log.getStackTraceString(e).getBytes();
                                        String str182 = str8;
                                        if (r56 != null) {
                                            try {
                                                r56.close();
                                                str182 = str8;
                                            } catch (IOException e29) {
                                                ?? r38 = e29;
                                                r38.printStackTrace();
                                                str182 = r38;
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        httpRequestListener2 = httpRequestListener;
                                        str16 = str182;
                                        if (httpRequestListener2 != null) {
                                            httpRequestListener2.onCompleted(-1, hashMap, bytes2);
                                            str16 = str182;
                                        }
                                    } catch (Throwable th9) {
                                        th5 = th9;
                                        obj2 = r56;
                                        r56 = bufferedInputStream;
                                        i19 = responseCode;
                                        r36 = obj2;
                                        if (r56 != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        r06 = httpRequestListener;
                                        if (r06 == 0) {
                                        }
                                    }
                                } else {
                                    r26 = 0;
                                }
                                if (r56 != null) {
                                    try {
                                        r56.close();
                                    } catch (IOException e36) {
                                        e36.printStackTrace();
                                    }
                                }
                                httpURLConnection.disconnect();
                                r08 = httpRequestListener;
                                if (r08 == 0) {
                                    r08.onCompleted(responseCode, hashMap, r26);
                                    return;
                                }
                                return;
                            }
                            size = httpURLConnection.getHeaderFields().size();
                            if (size <= 0) {
                            }
                            contentLength = httpURLConnection.getContentLength();
                            if (contentLength == -1) {
                            }
                            String str192 = str4;
                            if (str192 == null) {
                            }
                            if (responseCode != 200) {
                            }
                            if (r56 != null) {
                            }
                            httpURLConnection.disconnect();
                            r08 = httpRequestListener;
                            if (r08 == 0) {
                            }
                        } catch (UnknownHostException e37) {
                            e = e37;
                            obj3 = null;
                            hashMap = null;
                            str13 = str14;
                        } catch (Exception e38) {
                            e = e38;
                            str11 = null;
                            hashMap = null;
                            str12 = str14;
                        } catch (Throwable th10) {
                            th5 = th10;
                            obj2 = null;
                            hashMap = null;
                        }
                        z16 = true;
                        if (!str.equalsIgnoreCase("GET")) {
                            httpURLConnection.setDoOutput(true);
                            if (!z18) {
                            }
                            int available2 = byteArrayInputStream.available();
                            httpURLConnection.setFixedLengthStreamingMode(available2);
                            bArr2 = new byte[4096];
                            int i272 = 0;
                            while (true) {
                                read = byteArrayInputStream.read(bArr2);
                                if (read >= 0) {
                                }
                            }
                            byteArrayInputStream.close();
                        }
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (UnknownHostException e39) {
                        e = e39;
                        obj = null;
                        hashMap = null;
                        i19 = 200;
                        str10 = str14;
                        r37 = obj;
                        IMLog.e(HttpClient.TAG, str10 + e.getLocalizedMessage());
                        if (r56 != null) {
                            try {
                                r56.close();
                            } catch (IOException e46) {
                                e46.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        r07 = httpRequestListener;
                        str16 = r37;
                        if (r07 != 0) {
                            r07.onCompleted(404, hashMap, r37);
                            str16 = r37;
                        }
                    } catch (Exception e47) {
                        e = e47;
                        str8 = null;
                        hashMap = null;
                        str9 = str14;
                    } catch (Throwable th11) {
                        th5 = th11;
                        str7 = null;
                        hashMap = null;
                        i19 = i26;
                        r36 = str7;
                        if (r56 != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        r06 = httpRequestListener;
                        if (r06 == 0) {
                        }
                    }
                } catch (Throwable th12) {
                    th5 = th12;
                    r36 = str16;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProgressCallback(int i3, int i16, int i17, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeResponseCallback(int i3, String[] strArr, String[] strArr2, byte[] bArr, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needRollbackHttps2Http(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            String str2 = "";
            if (SystemUtil.isBrandOppo()) {
                str2 = "oppo";
            } else if (SystemUtil.isBrandVivo()) {
                str2 = CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO;
            } else if (SystemUtil.isBrandHuawei()) {
                str2 = CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI;
            } else if (SystemUtil.isBrandXiaoMi()) {
                str2 = "xiaomi";
            } else if (SystemUtil.isBrandMeizu()) {
                str2 = "meizu";
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String string = jSONObject.getString("brand");
                int i16 = jSONObject.getInt("below_version");
                if (str2.equals(string)) {
                    if (SystemUtil.getSDKVersion() > i16) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static void httpRequest(String str, String str2, String[] strArr, String[] strArr2, byte[] bArr, String str3, String str4, final long j3, final long j16, String str5, int i3, int i16, int i17, int i18, String str6) {
        HashMap hashMap;
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            for (int i19 = 0; i19 < strArr.length; i19++) {
                hashMap.put(strArr[i19], strArr2[i19]);
            }
        }
        httpRequest(str, str2, hashMap, bArr, str3, str4, new HttpRequestListener() { // from class: com.tencent.imsdk.common.HttpClient.3
            @Override // com.tencent.imsdk.common.HttpClient.HttpRequestListener
            public void onCompleted(int i26, Map<String, String> map, byte[] bArr2) {
                String[] strArr3;
                String[] strArr4;
                if (j16 != 0) {
                    if (map != null) {
                        String[] strArr5 = new String[map.size()];
                        String[] strArr6 = new String[map.size()];
                        int i27 = 0;
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            strArr5[i27] = entry.getKey();
                            strArr6[i27] = entry.getValue();
                            i27++;
                        }
                        strArr3 = strArr5;
                        strArr4 = strArr6;
                    } else {
                        strArr3 = null;
                        strArr4 = null;
                    }
                    HttpClient.nativeResponseCallback(i26, strArr3, strArr4, bArr2, j16);
                }
            }

            @Override // com.tencent.imsdk.common.HttpClient.HttpRequestListener
            public void onProgress(int i26, int i27, int i28) {
                long j17 = j3;
                if (j17 != 0) {
                    HttpClient.nativeProgressCallback(i26, i27, i28, j17);
                }
            }
        }, str5, i3, i16, i17, i18, str6);
    }
}
