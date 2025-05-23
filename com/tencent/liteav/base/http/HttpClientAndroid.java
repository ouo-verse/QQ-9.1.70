package com.tencent.liteav.base.http;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.HttpDnsUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLException;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class HttpClientAndroid {
    private static final int ERROR_CODE_INVALID_REQUEST = 0;
    private static final String HTTPS_PREFIX = "https://";
    private static final String HTTP_PREFIX = "http://";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final int READ_STREAM_SIZE = 8192;
    private static final int REDIRECT_REQUEST_MAX = 3;
    private static final String TAG = "HttpClientAndroid";
    private static final Object mLock = new Object();
    private HttpURLConnection mConnection;
    private b mHttpConfig;
    private final Handler mHttpHandler;
    private String mLastRequestURL;
    private long mNativeHttpClientAndroidJni;
    private final ConcurrentHashMap<Long, d> mRunningRequestMap = new ConcurrentHashMap<>();
    private final Object mLocker = new Object();
    private volatile c mInternalState = c.NONE;
    private long mTotalReadBytes = 0;
    private long mStartReadTime = 0;
    byte[] mReadDataBytes = new byte[8192];
    private boolean mPausedRepeatDownloading = false;
    private g mRepeatDownloadingStatusCode = g.kUnknownError;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a extends Authenticator {

        /* renamed from: a, reason: collision with root package name */
        String f118900a;

        /* renamed from: b, reason: collision with root package name */
        String f118901b;

        a(String str, String str2) {
            this.f118900a = str;
            this.f118901b = str2;
        }

        @Override // java.net.Authenticator
        protected final PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.f118900a, this.f118901b.toCharArray());
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f118902a;

        /* renamed from: b, reason: collision with root package name */
        int f118903b;

        /* renamed from: c, reason: collision with root package name */
        int f118904c;

        /* renamed from: d, reason: collision with root package name */
        boolean f118905d;

        /* renamed from: e, reason: collision with root package name */
        int f118906e;

        /* renamed from: f, reason: collision with root package name */
        int f118907f;

        /* renamed from: g, reason: collision with root package name */
        String f118908g;

        /* renamed from: h, reason: collision with root package name */
        String f118909h;

        /* renamed from: i, reason: collision with root package name */
        String f118910i;

        b(int i3, int i16, int i17, boolean z16, int i18, int i19, String str, String str2, String str3) {
            this.f118902a = i3;
            this.f118903b = i16;
            this.f118904c = i17;
            this.f118905d = z16;
            this.f118906e = i18;
            this.f118907f = i19;
            this.f118908g = str;
            this.f118909h = str2;
            this.f118910i = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum c {
        NONE,
        RUNNING_REPEAT,
        RUNNING_ONCE
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        long f118915a;

        /* renamed from: b, reason: collision with root package name */
        String f118916b;

        /* renamed from: c, reason: collision with root package name */
        String f118917c;

        /* renamed from: d, reason: collision with root package name */
        byte[] f118918d;

        /* renamed from: e, reason: collision with root package name */
        Map<String, String> f118919e;

        /* renamed from: f, reason: collision with root package name */
        int f118920f;

        /* renamed from: g, reason: collision with root package name */
        String f118921g;

        /* renamed from: h, reason: collision with root package name */
        boolean f118922h;

        /* renamed from: i, reason: collision with root package name */
        String f118923i;

        /* renamed from: j, reason: collision with root package name */
        byte[] f118924j;

        /* renamed from: k, reason: collision with root package name */
        byte[] f118925k;

        d(String str, String str2, byte[] bArr, Map<String, String> map, boolean z16) {
            this(str, str2, bArr, map, z16, "", null, null);
        }

        final boolean a() {
            if (TextUtils.isEmpty(this.f118916b)) {
                return false;
            }
            if (!this.f118916b.startsWith("http://") && !this.f118916b.startsWith("https://")) {
                return false;
            }
            return true;
        }

        final boolean b() {
            byte[] bArr = this.f118918d;
            if (bArr != null && bArr.length > 0) {
                return true;
            }
            return false;
        }

        final boolean c() {
            if (!"POST".equals(d()) && !"PUT".equals(d())) {
                return false;
            }
            return true;
        }

        final String d() {
            if (TextUtils.isEmpty(this.f118917c)) {
                return "";
            }
            if ("POST".equalsIgnoreCase(this.f118917c)) {
                return "POST";
            }
            if ("GET".equalsIgnoreCase(this.f118917c)) {
                return "GET";
            }
            if (!"PUT".equalsIgnoreCase(this.f118917c)) {
                return "";
            }
            return "PUT";
        }

        public final String toString() {
            int i3;
            StringBuilder sb5 = new StringBuilder("Request{requestId=");
            sb5.append(this.f118915a);
            sb5.append(", url='");
            sb5.append(this.f118916b);
            sb5.append('\'');
            sb5.append(", method='");
            sb5.append(this.f118917c);
            sb5.append('\'');
            sb5.append(", body.size=");
            if (b()) {
                i3 = this.f118918d.length;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append(", headers=");
            sb5.append(this.f118919e);
            sb5.append(", autoRedirect=");
            sb5.append(this.f118922h);
            sb5.append('}');
            return sb5.toString();
        }

        d(String str, String str2, byte[] bArr, Map<String, String> map, boolean z16, String str3, byte[] bArr2, byte[] bArr3) {
            this.f118916b = str;
            this.f118917c = str2;
            this.f118918d = bArr;
            this.f118919e = map;
            this.f118920f = 0;
            this.f118921g = "";
            this.f118922h = z16;
            this.f118923i = str3;
            this.f118924j = bArr2;
            this.f118925k = bArr3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: c, reason: collision with root package name */
        ByteBuffer f118928c;

        /* renamed from: a, reason: collision with root package name */
        g f118926a = g.kUnknownError;

        /* renamed from: b, reason: collision with root package name */
        String f118927b = "";

        /* renamed from: d, reason: collision with root package name */
        int f118929d = 0;

        /* renamed from: e, reason: collision with root package name */
        String f118930e = "";

        /* renamed from: f, reason: collision with root package name */
        Map<String, String> f118931f = null;

        /* renamed from: g, reason: collision with root package name */
        int f118932g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f118933h = 0;

        /* renamed from: i, reason: collision with root package name */
        String f118934i = "";
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum f {
        CONNECTED(0),
        DISCONNECTED(1),
        FINISHED(2);

        int nativeValue;

        f(int i3) {
            this.nativeValue = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum g {
        kHTTP200OK(200),
        kHTTP204NoContent(204),
        kHTTP206PartialContent(206),
        kHTTP301MovedPermanently(301),
        kHTTP302Found(302),
        kHTTP303SeeOther(303),
        kHTTP304NotModified(304),
        kHTTP307TemporaryRedirect(307),
        kHTTP308PermanentRedirect(308),
        kHTTP403Forbidden(403),
        kHTTP404NotFound(404),
        kHTTP405MethodNotAllowed(405),
        kHTTP503ServiceUnavailable(503),
        kSystemFileOpenFailed(1001),
        kSystemFileWriteFailed(1002),
        kSystemUnknownHost(1003),
        kSystemConnectHostFailed(1004),
        kSystemCreateSocketFailed(1005),
        kSystemNetworkDisabled(1006),
        kSystemConnectTimeout(1007),
        kSystemConnectRefused(1008),
        kSystemProtocolError(1009),
        kSystemSSLError(1010),
        kUnknownError(1999);

        final int nativeValue;

        g(int i3) {
            this.nativeValue = i3;
        }
    }

    public HttpClientAndroid(int i3, int i16, int i17, boolean z16, int i18, int i19, String str, String str2, String str3, long j3) {
        this.mHttpConfig = new b(i3, i16, i17, z16, i18, i19, str, str2, str3);
        this.mNativeHttpClientAndroidJni = j3;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HttpClient_" + hashCode());
        baseHandlerThread.start();
        LiteavLog.i(TAG, "Create http client(" + hashCode() + "). [ThreadName:" + baseHandlerThread.getName() + "][ThreadId:" + baseHandlerThread.getId() + "]");
        this.mHttpHandler = new Handler(baseHandlerThread.getLooper());
    }

    private boolean checkNativeValid() {
        boolean z16;
        synchronized (this.mLocker) {
            if (this.mNativeHttpClientAndroidJni != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    private boolean checkRequestValid(long j3) {
        return this.mRunningRequestMap.containsKey(Long.valueOf(j3));
    }

    private void closeConnectionSafely(HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection != null) {
                try {
                    closeIO(httpURLConnection.getInputStream());
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                }
            }
        } catch (Throwable th5) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e19) {
                e19.printStackTrace();
            }
            throw th5;
        }
    }

    private void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private HttpURLConnection createConnection(d dVar) throws Exception {
        Proxy proxy;
        HttpURLConnection createConnectionUseCustomHttpDNS;
        String replace = dVar.f118916b.replace(" ", "%20");
        URL url = new URL(replace);
        if (!TextUtils.isEmpty(this.mHttpConfig.f118908g) && this.mHttpConfig.f118907f > 0) {
            Proxy.Type type = Proxy.Type.SOCKS;
            b bVar = this.mHttpConfig;
            proxy = new Proxy(type, new InetSocketAddress(bVar.f118908g, bVar.f118907f));
            b bVar2 = this.mHttpConfig;
            Authenticator.setDefault(new a(bVar2.f118909h, bVar2.f118910i));
        } else if (!"127.0.0.1".equals(url.getHost()) && !"localhost".equals(url.getHost())) {
            proxy = null;
        } else {
            proxy = Proxy.NO_PROXY;
        }
        if (proxy != null) {
            createConnectionUseCustomHttpDNS = (HttpURLConnection) url.openConnection(proxy);
        } else {
            if (HttpDnsUtil.verifyCustomHttpDNS(url.getHost())) {
                try {
                    createConnectionUseCustomHttpDNS = HttpDnsUtil.createConnectionUseCustomHttpDNS(replace, url.getHost());
                } catch (Exception e16) {
                    LiteavLog.w(TAG, "(" + hashCode() + ")createConnectionUseCustomHttpDNS failed. error: " + Log.getStackTraceString(e16));
                }
            }
            createConnectionUseCustomHttpDNS = (HttpURLConnection) url.openConnection();
        }
        createConnectionUseCustomHttpDNS.setInstanceFollowRedirects(false);
        createConnectionUseCustomHttpDNS.setConnectTimeout(this.mHttpConfig.f118902a);
        createConnectionUseCustomHttpDNS.setReadTimeout(this.mHttpConfig.f118903b);
        createConnectionUseCustomHttpDNS.setRequestProperty("Accept-Encoding", "identity");
        createConnectionUseCustomHttpDNS.setRequestMethod(dVar.d());
        if (dVar.c()) {
            createConnectionUseCustomHttpDNS.setDoOutput(true);
        }
        if (this.mHttpConfig.f118905d) {
            createConnectionUseCustomHttpDNS.setRequestProperty("Connection", "Keep-Alive");
        } else {
            createConnectionUseCustomHttpDNS.setRequestProperty("Connection", "close");
        }
        Map<String, String> map = dVar.f118919e;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : dVar.f118919e.entrySet()) {
                createConnectionUseCustomHttpDNS.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return createConnectionUseCustomHttpDNS;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0079
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #1 {all -> 0x0079, blocks: (B:4:0x0007, B:6:0x000f, B:10:0x001e, B:13:0x0027, B:15:0x0038, B:28:0x007a), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doCallbackAndResetState(com.tencent.liteav.base.http.HttpClientAndroid.f r22, long r23, com.tencent.liteav.base.http.HttpClientAndroid.e r25, boolean r26) {
        /*
            r21 = this;
            r1 = r21
            r0 = r25
            java.lang.Object r2 = r1.mLocker
            monitor-enter(r2)
            boolean r3 = r21.checkNativeValid()     // Catch: java.lang.Throwable -> L79
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L1b
            r10 = r23
            boolean r3 = r1.checkRequestValid(r10)     // Catch: java.lang.Throwable -> L79
            if (r3 == 0) goto L1d
            if (r0 == 0) goto L1d
            r3 = r4
            goto L1e
        L1b:
            r10 = r23
        L1d:
            r3 = r5
        L1e:
            com.tencent.liteav.base.http.HttpClientAndroid$c r6 = com.tencent.liteav.base.http.HttpClientAndroid.c.RUNNING_REPEAT     // Catch: java.lang.Throwable -> L79
            com.tencent.liteav.base.http.HttpClientAndroid$c r7 = r1.mInternalState     // Catch: java.lang.Throwable -> L79
            if (r6 != r7) goto L26
            r8 = r4
            goto L27
        L26:
            r8 = r5
        L27:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r4 = r1.mRunningRequestMap     // Catch: java.lang.Throwable -> L79
            java.lang.Long r5 = java.lang.Long.valueOf(r23)     // Catch: java.lang.Throwable -> L79
            r4.remove(r5)     // Catch: java.lang.Throwable -> L79
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r4 = r1.mRunningRequestMap     // Catch: java.lang.Throwable -> L79
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L79
            if (r4 != 0) goto L3c
            com.tencent.liteav.base.http.HttpClientAndroid$c r4 = com.tencent.liteav.base.http.HttpClientAndroid.c.NONE     // Catch: java.lang.Throwable -> L79
            r1.mInternalState = r4     // Catch: java.lang.Throwable -> L79
        L3c:
            if (r3 == 0) goto L67
            long r6 = r1.mNativeHttpClientAndroidJni     // Catch: java.lang.Throwable -> L75
            r3 = r22
            int r9 = r3.nativeValue     // Catch: java.lang.Throwable -> L75
            com.tencent.liteav.base.http.HttpClientAndroid$g r3 = r0.f118926a     // Catch: java.lang.Throwable -> L75
            int r12 = r3.nativeValue     // Catch: java.lang.Throwable -> L75
            java.lang.String r13 = r0.f118927b     // Catch: java.lang.Throwable -> L75
            int r14 = r0.f118932g     // Catch: java.lang.Throwable -> L75
            java.nio.ByteBuffer r15 = r0.f118928c     // Catch: java.lang.Throwable -> L75
            java.lang.String r3 = r0.f118930e     // Catch: java.lang.Throwable -> L75
            java.util.Map<java.lang.String, java.lang.String> r4 = r0.f118931f     // Catch: java.lang.Throwable -> L75
            int r5 = r0.f118929d     // Catch: java.lang.Throwable -> L75
            int r1 = r0.f118933h     // Catch: java.lang.Throwable -> L75
            java.lang.String r0 = r0.f118934i     // Catch: java.lang.Throwable -> L75
            r10 = r23
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r1
            r20 = r0
            nativeOnCallback(r6, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch: java.lang.Throwable -> L75
        L67:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
            r1 = r21
            if (r26 == 0) goto L74
            java.net.HttpURLConnection r0 = r1.mConnection
            r1.closeConnectionSafely(r0)
            r0 = 0
            r1.mConnection = r0
        L74:
            return
        L75:
            r0 = move-exception
            r1 = r21
            goto L7a
        L79:
            r0 = move-exception
        L7a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L79
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.doCallbackAndResetState(com.tencent.liteav.base.http.HttpClientAndroid$f, long, com.tencent.liteav.base.http.HttpClientAndroid$e, boolean):void");
    }

    private boolean doOnCallback(f fVar, long j3, e eVar) {
        synchronized (this.mLocker) {
            boolean z16 = false;
            if (!checkNativeValid() || !checkRequestValid(j3) || eVar == null) {
                return false;
            }
            if (c.RUNNING_REPEAT == this.mInternalState) {
                z16 = true;
            }
            return nativeOnCallback(this.mNativeHttpClientAndroidJni, z16, fVar.nativeValue, j3, eVar.f118926a.nativeValue, eVar.f118927b, eVar.f118932g, eVar.f118928c, eVar.f118930e, eVar.f118931f, eVar.f118929d, eVar.f118933h, eVar.f118934i);
        }
    }

    private void doReadData(long j3, e eVar) {
        boolean z16;
        boolean z17;
        long j16;
        long j17;
        if (!checkRequestValid(j3)) {
            closeConnectionSafely(this.mConnection);
            LiteavLog.w(TAG, "(" + hashCode() + ")Do read data failed. Invalid request id. id:" + j3);
            return;
        }
        try {
            InputStream inputStream = this.mConnection.getInputStream();
            synchronized (this.mLocker) {
                if (this.mInternalState == c.RUNNING_ONCE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            long j18 = 0;
            if (z16) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    do {
                        int read = inputStream.read(this.mReadDataBytes);
                        if (read > 0) {
                            byteArrayOutputStream.write(this.mReadDataBytes, 0, read);
                        }
                        if (read > 0 && checkRequestValid(j3)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                    } while (z17);
                    int size = byteArrayOutputStream.size();
                    if (size > 0) {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size);
                        eVar.f118928c = allocateDirect;
                        allocateDirect.put(byteArrayOutputStream.toByteArray(), 0, size);
                        eVar.f118929d = size;
                    }
                    j16 = 0;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Catch error when reading.");
                    eVar.f118926a = getStatusCode(th5);
                    eVar.f118927b = th5.toString();
                    doCallbackAndResetState(f.DISCONNECTED, j3, eVar, true);
                    return;
                }
            } else {
                try {
                    int read2 = inputStream.read(this.mReadDataBytes);
                    this.mTotalReadBytes += read2;
                    j16 = SystemClock.elapsedRealtime();
                    if (read2 > 0) {
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(read2);
                        eVar.f118928c = allocateDirect2;
                        allocateDirect2.put(this.mReadDataBytes, 0, read2);
                        eVar.f118929d = read2;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Catch error when reading.");
                    eVar.f118926a = getStatusCode(e16);
                    eVar.f118927b = e16.toString();
                    doCallbackAndResetState(f.DISCONNECTED, j3, eVar, true);
                    return;
                }
            }
            if (eVar.f118929d == 0 && !z16) {
                LiteavLog.w(TAG, "(" + hashCode() + ")Do read data failed. Rsp size is 0.");
                doCallbackAndResetState(f.FINISHED, j3, eVar, this.mHttpConfig.f118905d ^ true);
                return;
            }
            if (z16) {
                doCallbackAndResetState(f.FINISHED, j3, eVar, !this.mHttpConfig.f118905d);
                return;
            }
            boolean doOnCallback = doOnCallback(f.CONNECTED, j3, eVar);
            this.mPausedRepeatDownloading = doOnCallback;
            this.mRepeatDownloadingStatusCode = eVar.f118926a;
            if (!doOnCallback) {
                int i3 = this.mHttpConfig.f118906e;
                if (i3 > 0) {
                    long j19 = this.mStartReadTime;
                    if (j16 - j19 == 0) {
                        j17 = 1;
                    } else {
                        j17 = j16 - j19;
                    }
                    long j26 = this.mTotalReadBytes;
                    if (j26 / j17 > i3 / 1000) {
                        j18 = ((j26 * 1000) / i3) - j17;
                    }
                }
                this.mHttpHandler.postDelayed(com.tencent.liteav.base.http.f.a(this, eVar, j3), j18);
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Fail to get InputStream.");
            eVar.f118926a = getStatusCode(e17);
            eVar.f118927b = e17.toString();
            doCallbackAndResetState(f.DISCONNECTED, j3, eVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequest(d dVar) {
        g gVar;
        e eVar = null;
        for (int i3 = 0; i3 < 4; i3++) {
            eVar = internalRequest(dVar);
            if (eVar == null) {
                return;
            }
            if (!dVar.f118922h || ((gVar = eVar.f118926a) != g.kHTTP301MovedPermanently && gVar != g.kHTTP302Found)) {
                break;
            }
            String headerField = this.mConnection.getHeaderField("Location");
            dVar.f118916b = headerField;
            dVar.f118920f++;
            dVar.f118921g = headerField;
        }
        this.mTotalReadBytes = 0L;
        this.mStartReadTime = SystemClock.elapsedRealtime();
        doReadData(dVar.f118915a, eVar);
    }

    public static HashMap getJavaHashMap(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            if (strArr.length != strArr2.length) {
                LiteavLog.w(TAG, "Invalid parameter, keys and values do not match.");
                return new HashMap();
            }
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                hashMap.put(strArr[i3], strArr2[i3]);
            }
            return hashMap;
        }
        return new HashMap();
    }

    public static String[] getMapKeys(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            Set<String> keySet = map.keySet();
            return (String[]) keySet.toArray(new String[keySet.size()]);
        }
        return new String[0];
    }

    public static String[] getMapValue(Map<String, String> map, String[] strArr) {
        if (map != null && !map.isEmpty() && strArr != null && strArr.length != 0) {
            String[] strArr2 = new String[strArr.length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                strArr2[i3] = map.get(strArr[i3]);
            }
            return strArr2;
        }
        return new String[0];
    }

    private Map<String, String> getResponseHeaders(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return hashMap;
    }

    private g getStatusCode(int i3) {
        g gVar = g.kUnknownError;
        if (i3 == 200) {
            return g.kHTTP200OK;
        }
        if (i3 == 204) {
            return g.kHTTP204NoContent;
        }
        if (i3 == 206) {
            return g.kHTTP206PartialContent;
        }
        if (i3 == 301) {
            return g.kHTTP301MovedPermanently;
        }
        if (i3 == 302) {
            return g.kHTTP302Found;
        }
        if (i3 == 303) {
            return g.kHTTP303SeeOther;
        }
        if (i3 == 304) {
            return g.kHTTP304NotModified;
        }
        if (i3 == 307) {
            return g.kHTTP307TemporaryRedirect;
        }
        if (i3 == 308) {
            return g.kHTTP308PermanentRedirect;
        }
        if (i3 == 403) {
            return g.kHTTP403Forbidden;
        }
        if (i3 == 404) {
            return g.kHTTP404NotFound;
        }
        if (i3 == 405) {
            return g.kHTTP405MethodNotAllowed;
        }
        if (i3 == 503) {
            return g.kHTTP503ServiceUnavailable;
        }
        Log.w(TAG, "(" + hashCode() + ")Failed to convert status code\uff1a" + i3, new Object[0]);
        return gVar;
    }

    private e internalRequest(d dVar) {
        boolean z16;
        if (!dVar.a()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid request url(" + dVar.f118916b + ").");
            return null;
        }
        if (!checkRequestValid(dVar.f118915a)) {
            LiteavLog.w(TAG, "(" + hashCode() + ")Do send failed. ignore request when cancelled. request:" + dVar);
            return null;
        }
        e eVar = new e();
        eVar.f118933h = dVar.f118920f;
        eVar.f118934i = dVar.f118921g;
        synchronized (this.mLocker) {
            if (this.mInternalState == c.RUNNING_ONCE) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (z16 && this.mConnection != null && !dVar.f118916b.equals(this.mLastRequestURL)) {
            closeConnectionSafely(this.mConnection);
            this.mConnection = null;
        }
        this.mLastRequestURL = dVar.f118916b;
        try {
            this.mConnection = createConnection(dVar);
            writeRequestBody(dVar);
            try {
                eVar.f118926a = getStatusCode(this.mConnection.getResponseCode());
                eVar.f118927b = this.mConnection.getResponseMessage();
                eVar.f118930e = parseHostAddress(this.mConnection.getURL().getHost());
                eVar.f118932g = this.mConnection.getURL().getPort();
                eVar.f118931f = getResponseHeaders(this.mConnection.getHeaderFields());
                if (!checkRequestValid(dVar.f118915a)) {
                    closeConnectionSafely(this.mConnection);
                    LiteavLog.w(TAG, "(" + hashCode() + ")Do send failed. Invalid request, abort request.");
                    return null;
                }
                return eVar;
            } catch (Exception e16) {
                e16.printStackTrace();
                LiteavLog.e(TAG, "(" + hashCode() + ")Do send failed. Catch error. ex= " + Log.getStackTraceString(e16));
                eVar.f118926a = getStatusCode(e16);
                eVar.f118927b = e16.toString();
                doCallbackAndResetState(f.DISCONNECTED, dVar.f118915a, eVar, true);
                return null;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            LiteavLog.e(TAG, "(" + hashCode() + ")Do send failed. Fail to create http connection. ex= " + Log.getStackTraceString(e17));
            eVar.f118926a = getStatusCode(e17);
            eVar.f118927b = e17.toString();
            doCallbackAndResetState(f.DISCONNECTED, dVar.f118915a, eVar, true);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$cancelAll$1(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$destroy$4(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            httpClientAndroid.mHttpHandler.getLooper().quitSafely();
        } else {
            httpClientAndroid.mHttpHandler.getLooper().quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$doReadData$5(HttpClientAndroid httpClientAndroid, e eVar, long j3) {
        e eVar2 = new e();
        eVar2.f118926a = eVar.f118926a;
        httpClientAndroid.doReadData(j3, eVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$resumeRepeatDownload$2(HttpClientAndroid httpClientAndroid, Long l3) {
        e eVar = new e();
        eVar.f118926a = httpClientAndroid.mRepeatDownloadingStatusCode;
        httpClientAndroid.doReadData(l3.longValue(), eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$resumeRepeatDownload$3(HttpClientAndroid httpClientAndroid, long j3) {
        e eVar = new e();
        eVar.f118926a = httpClientAndroid.mRepeatDownloadingStatusCode;
        httpClientAndroid.doReadData(j3, eVar);
    }

    private static native boolean nativeOnCallback(long j3, boolean z16, int i3, long j16, int i16, String str, int i17, ByteBuffer byteBuffer, String str2, Map map, int i18, int i19, String str3);

    private static native void nativeOnUploadProgress(long j3, long j16, long j17, long j18);

    private String parseHostAddress(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception unused) {
            LiteavLog.w(TAG, "(" + hashCode() + ")Parse host error. host:" + str);
            return "";
        }
    }

    private long sendInternal(long j3, d dVar, boolean z16) {
        c cVar;
        if (dVar != null && dVar.a()) {
            boolean z17 = true;
            if (!(!TextUtils.isEmpty(dVar.d()))) {
                LiteavLog.e(TAG, "(" + hashCode() + ")upload file failed. Request method(" + dVar.f118917c + ") is not supported.");
                return 0L;
            }
            synchronized (this.mLocker) {
                if (this.mInternalState == c.NONE) {
                    if (z16) {
                        cVar = c.RUNNING_REPEAT;
                    } else {
                        cVar = c.RUNNING_ONCE;
                    }
                    this.mInternalState = cVar;
                } else if (this.mInternalState != c.RUNNING_ONCE) {
                    z17 = false;
                }
                if (z17) {
                    dVar.f118915a = j3;
                    this.mRunningRequestMap.put(Long.valueOf(j3), dVar);
                    this.mHttpHandler.post(com.tencent.liteav.base.http.a.a(this, dVar));
                    return dVar.f118915a;
                }
                LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid state:" + this.mInternalState);
                return 0L;
            }
        }
        LiteavLog.e(TAG, "(" + hashCode() + ")upload file failed. Invalid request url(" + dVar.f118916b + ").");
        return 0L;
    }

    private void uploadFileByPath(d dVar, OutputStream outputStream) throws Exception {
        long j3;
        if (TextUtils.isEmpty(dVar.f118923i)) {
            return;
        }
        Closeable closeable = null;
        try {
            File file = new File(dVar.f118923i);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[524288];
                long length = file.length();
                long j16 = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    synchronized (this.mLocker) {
                        if (!checkRequestValid(dVar.f118915a) || !checkNativeValid()) {
                            break;
                        }
                        j3 = j16 + read;
                        outputStream.write(bArr, 0, read);
                        nativeOnUploadProgress(this.mNativeHttpClientAndroidJni, dVar.f118915a, j3, length);
                    }
                    j16 = j3;
                }
                closeIO(fileInputStream);
            } catch (Throwable th5) {
                th = th5;
                closeable = fileInputStream;
                closeIO(closeable);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void writeRequestBody(d dVar) {
        OutputStream outputStream = null;
        try {
            if (dVar.c() && dVar.b()) {
                outputStream = this.mConnection.getOutputStream();
                outputStream.write(dVar.f118918d);
                outputStream.flush();
            } else if (dVar.c() && (!TextUtils.isEmpty(dVar.f118923i))) {
                outputStream = this.mConnection.getOutputStream();
                byte[] bArr = dVar.f118924j;
                if (bArr != null && bArr.length > 0) {
                    outputStream.write(bArr);
                }
                uploadFileByPath(dVar, outputStream);
                byte[] bArr2 = dVar.f118925k;
                if (bArr2 != null && bArr2.length > 0) {
                    outputStream.write(bArr2);
                }
                outputStream.flush();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            LiteavLog.w(TAG, "(" + hashCode() + ")Do write request body failed.");
        } finally {
            closeIO(null);
        }
    }

    public void cancel(long j3) {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "(" + hashCode() + ")Cancel request failed. Invalid native handle.");
                return;
            }
            if (this.mRunningRequestMap.size() == 0) {
                return;
            }
            LiteavLog.i(TAG, "(" + hashCode() + ")Cancel request. request:" + this.mRunningRequestMap.remove(Long.valueOf(j3)));
            if (this.mRunningRequestMap.size() == 0) {
                this.mInternalState = c.NONE;
            }
        }
    }

    public void cancelAll() {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "(" + hashCode() + ")Cancel all request failed. Invalid native handle.");
                return;
            }
            c cVar = this.mInternalState;
            c cVar2 = c.NONE;
            if (cVar == cVar2) {
                return;
            }
            this.mInternalState = cVar2;
            LiteavLog.i(TAG, "(" + hashCode() + ")Cancel all. size:" + this.mRunningRequestMap.size());
            this.mRunningRequestMap.clear();
            this.mHttpHandler.post(com.tencent.liteav.base.http.b.a(this));
        }
    }

    public void destroy() {
        synchronized (this.mLocker) {
            this.mRunningRequestMap.clear();
            this.mNativeHttpClientAndroidJni = -1L;
            this.mHttpHandler.post(com.tencent.liteav.base.http.e.a(this));
        }
    }

    public void resumeRepeatDownload(long j3) {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "(" + hashCode() + ")Cancel request failed. Invalid native handle.");
                return;
            }
            if (this.mRunningRequestMap.size() == 0) {
                return;
            }
            if (this.mInternalState == c.RUNNING_REPEAT && this.mPausedRepeatDownloading) {
                this.mPausedRepeatDownloading = false;
                if (j3 == 0) {
                    Iterator<Long> it = this.mRunningRequestMap.keySet().iterator();
                    while (it.hasNext()) {
                        this.mHttpHandler.post(com.tencent.liteav.base.http.c.a(this, it.next()));
                    }
                } else if (checkRequestValid(j3)) {
                    if (this.mRunningRequestMap.get(Long.valueOf(j3)) == null) {
                    } else {
                        this.mHttpHandler.post(com.tencent.liteav.base.http.d.a(this, j3));
                    }
                }
            }
        }
    }

    public long send(long j3, String str, String str2, byte[] bArr, Map<String, String> map, boolean z16, boolean z17) {
        if (!checkNativeValid()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid native handle.");
            return 0L;
        }
        return sendInternal(j3, new d(str, str2, bArr, map, z17), z16);
    }

    public void updateConfig(final int i3, final int i16, final int i17, final boolean z16, final int i18, final int i19, final String str, final String str2, final String str3, long j3) {
        this.mHttpHandler.post(new Runnable() { // from class: com.tencent.liteav.base.http.HttpClientAndroid.1
            @Override // java.lang.Runnable
            public final void run() {
                HttpClientAndroid.this.mHttpConfig = new b(i3, i16, i17, z16, i18, i19, str, str2, str3);
                if (i18 > 0) {
                    HttpClientAndroid.this.mTotalReadBytes = 0L;
                    HttpClientAndroid.this.mStartReadTime = SystemClock.elapsedRealtime();
                }
            }
        });
    }

    public long uploadFile(long j3, String str, String str2, byte[] bArr, Map<String, String> map, boolean z16, boolean z17, String str3, byte[] bArr2, byte[] bArr3) {
        if (!checkNativeValid()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")upload file failed. Invalid native handle.");
            return 0L;
        }
        if (str3.isEmpty()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")upload file failed. Invalid file path(" + str3 + ").");
            return 0L;
        }
        return sendInternal(j3, new d(str, str2, bArr, map, z17, str3, bArr2, bArr3), z16);
    }

    private g getStatusCode(Throwable th5) {
        g gVar = g.kUnknownError;
        if (th5 instanceof FileNotFoundException) {
            return g.kSystemFileOpenFailed;
        }
        if (th5 instanceof EOFException) {
            return g.kSystemFileWriteFailed;
        }
        if (th5 instanceof UnknownHostException) {
            return g.kSystemUnknownHost;
        }
        if (th5 instanceof NoRouteToHostException) {
            return g.kSystemConnectHostFailed;
        }
        if (!(th5 instanceof SocketException) && !(th5 instanceof MalformedURLException)) {
            if (th5 instanceof SocketTimeoutException) {
                return g.kSystemConnectTimeout;
            }
            if (th5 instanceof ConnectException) {
                return g.kSystemConnectRefused;
            }
            if (th5 instanceof ProtocolException) {
                return g.kSystemProtocolError;
            }
            if (th5 instanceof SSLException) {
                return g.kSystemSSLError;
            }
            Log.w(TAG, "(" + hashCode() + ")Failed to convert status code, exception\uff1a", th5.toString());
            return gVar;
        }
        return g.kSystemCreateSocketFailed;
    }
}
