package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqperf.reporter.api.IDownloaderReporter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.UtilApi;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.java_websocket.WebSocketImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HttpDownloadUtil {
    public static final DefaultHttpClient CLIENT;
    public static final int DOWNLOAD_CONNECT_EXCEPTION = 17;
    public static final int DOWNLOAD_DATA_LOSSY = 8;

    @Deprecated
    public static final int DOWNLOAD_ENCRYPT_EXCEPTION = 7;
    public static final int DOWNLOAD_EOF_EXCEPTION = 19;
    public static final int DOWNLOAD_EXCEPTION = 5;
    public static final int DOWNLOAD_HEADER_XERRNO_PARSE_FAILED = 32;
    public static final int DOWNLOAD_HTTP_CONNECT_TIMEOUT = 2;
    public static final int DOWNLOAD_HTTP_RETRY_EXCEPTION = 18;
    public static final int DOWNLOAD_HTTP_SO_TIMEOUT = 3;
    public static final int DOWNLOAD_IS_HTML = 15;
    public static final int DOWNLOAD_LOCAL_FILESYSTEM_FAIL = 12;
    public static final int DOWNLOAD_NETWORK_FAIL = 1;
    public static final int DOWNLOAD_NETWORK_UNUSABLE = 9;
    public static final int DOWNLOAD_REDIRECT_ERROR = 20;
    public static final int DOWNLOAD_SAVE_FILE_FAIL = 4;
    public static final int DOWNLOAD_SC_NOT_MODIFIED = 16;
    public static final int DOWNLOAD_SOCKET_EXCEPTION = 11;
    public static final int DOWNLOAD_STORGE_EXCEPTION = 33;
    public static final int DOWNLOAD_SUCCESS = 0;
    public static final int DOWNLOAD_UNKNOWN_HOST = 10;
    public static final int DOWNLOAD_URL_RESP_NO_OK = 14;
    public static final int DOWNLOAD_URL_STRING_ILLEGAL = 13;
    public static final int DOWNLOAD_USER_CANCEL = 6;
    public static final int DOWNLOAD_VERIFY_LOST_KEY = 30;
    public static final int DOWNLOAD_VERIFY_UNMATCH_KEY = 31;
    public static final int FRIEND_PROFILE_IMAGE_AVATAR_HTTP_DOWNLOAD_ACTION = 10001;
    public static final int MAX_RETRY_DOWNLOAD_COUNT = 2;
    public static final int MAX_RETRY_DOWNLOAD_COUNT_EMOSM = 2;
    public static String PROTOCOL_HTTPS = null;
    public static final int RESOURCE_EXIST = 19;
    public static final String TAG = "HttpDownloadUtil";
    public static final int UNZIP_FAIL = 17;
    public static final int UNZIP_SUCCESS = 18;
    private static boolean forceDirect;
    private static boolean forceDomain;
    static IdleConnectionMonitorThread idleConnectionMonitorThread;
    private static String lastApn;
    static long lastUseTime = System.currentTimeMillis();
    private static boolean sShutdownSniSupport;
    private static boolean sShutdownSniSupportInited;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class IdleConnectionMonitorThread extends BaseThread {
        private final ClientConnectionManager C;
        private volatile boolean D;

        public IdleConnectionMonitorThread(ClientConnectionManager clientConnectionManager) {
            this.C = clientConnectionManager;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.D) {
                synchronized (this) {
                    try {
                        wait(30000L);
                    } catch (InterruptedException unused) {
                    }
                }
                try {
                    this.C.closeExpiredConnections();
                    this.C.closeIdleConnections(60L, TimeUnit.SECONDS);
                } catch (Throwable th5) {
                    QLog.e("HttpDownloadUtil", 1, "", th5);
                }
                if (System.currentTimeMillis() - HttpDownloadUtil.lastUseTime > MiniBoxNoticeInfo.MIN_5) {
                    shutdown();
                }
            }
        }

        public void shutdown() {
            this.D = true;
            synchronized (this) {
                notifyAll();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        boolean onRespDownloadInfo(DownloadInfo downloadInfo);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(String str, int i3);

        void b(String str, long j3, long j16);

        void c(String str, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static int f306957a = 40000;

        /* renamed from: b, reason: collision with root package name */
        public static int f306958b = 30000;

        /* renamed from: c, reason: collision with root package name */
        public static int f306959c = 20000;

        /* renamed from: d, reason: collision with root package name */
        public static int f306960d = 20000;

        /* renamed from: e, reason: collision with root package name */
        public static int f306961e = 15000;

        /* renamed from: f, reason: collision with root package name */
        public static int f306962f = 10000;

        /* renamed from: g, reason: collision with root package name */
        public static int f306963g;

        public static int a(int i3) {
            int i16;
            int i17;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4 && i3 != 5) {
                        i16 = f306960d;
                        i17 = f306963g;
                    }
                } else {
                    i16 = f306961e;
                    i17 = f306963g;
                }
                return i16 + i17;
            }
            i16 = f306962f;
            i17 = f306963g;
            return i16 + i17;
        }

        public static int b(int i3) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4 && i3 != 5) {
                        return f306957a;
                    }
                } else {
                    return f306958b;
                }
            }
            return f306959c;
        }
    }

    static {
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
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        CLIENT = defaultHttpClient;
        defaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
        IdleConnectionMonitorThread idleConnectionMonitorThread2 = new IdleConnectionMonitorThread(threadSafeClientConnManager);
        idleConnectionMonitorThread = idleConnectionMonitorThread2;
        idleConnectionMonitorThread2.setName("IdleConnectionMonitorThread");
        idleConnectionMonitorThread.start();
        lastApn = null;
        forceDirect = false;
        forceDomain = false;
        PROTOCOL_HTTPS = "https://";
    }

    private static boolean checkValid(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("HttpDownloadUtil", 2, "DownloadInfo is null.");
            }
            return false;
        }
        if (downloadInfo.file == null) {
            if (QLog.isColorLevel()) {
                QLog.d("HttpDownloadUtil", 2, "DownloadInfo.file is null.");
            }
            return false;
        }
        return true;
    }

    static void copyRespHeader(HttpURLConnection httpURLConnection, DownloadInfo downloadInfo) {
        if (httpURLConnection != null && downloadInfo != null) {
            if (httpURLConnection.getHeaderField(DownloadInfo.XFAIL_NO) != null) {
                downloadInfo.respXFailNo = httpURLConnection.getHeaderField(DownloadInfo.XFAIL_NO);
            }
            if (httpURLConnection.getHeaderField("X-ErrNo") != null) {
                downloadInfo.respXErrNo = httpURLConnection.getHeaderField("X-ErrNo");
            }
        }
    }

    public static boolean download(AppRuntime appRuntime, String str, File file) {
        return downloadData(appRuntime, str, file) == 0;
    }

    public static int downloadData(AppRuntime appRuntime, String str, File file) {
        return downloadData(appRuntime, str, file, 2);
    }

    private static boolean emoNeed2Try(DownloadInfo downloadInfo, int i3, int i16) {
        if (downloadInfo == null) {
            if (i3 <= i16) {
                return true;
            }
            return false;
        }
        int i17 = downloadInfo.resultCode;
        if (i17 != 0 && i3 <= i16 && i17 != 16 && i17 != 6 && NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return true;
        }
        return false;
    }

    public static String getEscapeSequence(String str) {
        return str.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
    }

    @NotNull
    private static HttpParams getHttpParams(NetworkInfo networkInfo) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        int i3 = 20000;
        int i16 = 60000;
        if (networkInfo != null) {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            String netGetExInfo = NetworkMonitor.netGetExInfo(networkInfo);
            if (NetworkUtil.isMobileNetworkInfo(networkInfo) && ((netGetExInfo == null || netGetExInfo.endsWith("wap")) && defaultHost != null && defaultPort > 0)) {
                basicHttpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(defaultHost, defaultPort));
            }
            if (NetworkUtil.isMobileNetworkInfo(networkInfo)) {
                basicHttpParams.setIntParameter("http.socket.buffer-size", 2048);
            } else {
                basicHttpParams.setIntParameter("http.socket.buffer-size", 4096);
                i3 = 10000;
                i16 = 30000;
            }
        }
        basicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(i3));
        basicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(i16));
        return basicHttpParams;
    }

    private static int getResultForIOException(URL url, int i3, IOException iOException) {
        if (QLog.isColorLevel()) {
            QLog.d("HttpDownloadUtil", 2, "Download fail 1. url=" + url, iOException);
        }
        if (iOException instanceof UnknownHostException) {
            return 10;
        }
        if ((iOException instanceof ConnectTimeoutException) || (iOException instanceof SocketTimeoutException)) {
            return 2;
        }
        if (iOException instanceof SocketException) {
            return 11;
        }
        return 4;
    }

    private static void handleAddHeaders(List<Header> list, String str) throws MalformedURLException {
        if (list != null) {
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                Header header = list.get(i3);
                if (header.getName().equals("Host")) {
                    list.remove(header);
                    break;
                }
                i3++;
            }
            list.add(new BasicHeader("Host", new URL(str).getHost()));
        }
    }

    private static void handleFinally(int i3, OutputStream outputStream, File file, HttpEntity httpEntity) {
        if (httpEntity != null) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
        if (i3 != 0) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (file.exists()) {
                    QLog.d("HttpDownloadUtil", 1, "delete file in finally: " + file.delete());
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b A[Catch: all -> 0x015a, Exception -> 0x015f, IOException -> 0x0165, TRY_LEAVE, TryCatch #16 {IOException -> 0x0165, Exception -> 0x015f, all -> 0x015a, blocks: (B:31:0x0125, B:33:0x012b), top: B:30:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ec A[EDGE_INSN: B:49:0x01ec->B:46:0x01ec BREAK  A[LOOP:0: B:2:0x0010->B:48:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b2 A[Catch: all -> 0x01cc, TRY_LEAVE, TryCatch #9 {all -> 0x01cc, blocks: (B:58:0x01ac, B:60:0x01b2), top: B:57:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018a A[Catch: all -> 0x01a5, TRY_LEAVE, TryCatch #4 {all -> 0x01a5, blocks: (B:68:0x0184, B:70:0x018a), top: B:67:0x0184 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int handleHttpRequest(URL url, int i3, long j3, Object obj, OutputStream outputStream, HttpGet httpGet, HttpParams httpParams, File file) {
        int i16;
        HttpEntity httpEntity;
        OutputStream outputStream2;
        int i17;
        int i18;
        int i19;
        long j16;
        int i26;
        OutputStream outputStream3;
        int i27 = -1;
        HttpEntity httpEntity2 = null;
        OutputStream outputStream4 = outputStream;
        do {
            if (i27 == 0) {
                httpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(url.getHost(), url.getPort()));
                httpGet.setParams(httpParams);
            }
            try {
                try {
                    try {
                        try {
                            try {
                                HttpResponse execute = CLIENT.execute(new HttpHost(url.getHost()), httpGet);
                                int statusCode = execute.getStatusLine().getStatusCode();
                                httpEntity2 = execute.getEntity();
                                if (200 == statusCode) {
                                    long contentLength = httpEntity2.getContentLength();
                                    ((IDownloaderReporter) QRoute.api(IDownloaderReporter.class)).downloaderReport("HttpDownloadUtil", url.toString(), contentLength);
                                    try {
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                        try {
                                            httpEntity2.writeTo(bufferedOutputStream);
                                            bufferedOutputStream.flush();
                                            j16 = file.length();
                                            outputStream3 = bufferedOutputStream;
                                        } catch (FileNotFoundException unused) {
                                            outputStream3 = bufferedOutputStream;
                                            j16 = 0;
                                        } catch (IOException e16) {
                                            e = e16;
                                            outputStream3 = bufferedOutputStream;
                                            j16 = 0;
                                        } catch (Exception e17) {
                                            e = e17;
                                            outputStream3 = bufferedOutputStream;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            outputStream3 = bufferedOutputStream;
                                        }
                                        try {
                                            file.setLastModified(System.currentTimeMillis());
                                            if (QLog.isColorLevel()) {
                                                QLog.i("HttpDownloadUtil", 2, "Download success. cost " + (System.currentTimeMillis() - j3) + ", size is " + j16 + " for " + url);
                                            }
                                            i26 = 0;
                                        } catch (FileNotFoundException unused2) {
                                            outputStream4 = outputStream3;
                                            QLog.d("HttpDownloadUtil", 1, "FileNotFoundException file exist=" + file.exists() + ", dir exist=" + file.getParentFile().exists());
                                            outputStream3 = outputStream4;
                                            i17 = 5;
                                            if (contentLength > 0) {
                                                try {
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    i17 = 8;
                                                } catch (IOException e18) {
                                                    e = e18;
                                                    i16 = i17;
                                                    outputStream4 = outputStream3;
                                                    try {
                                                        i19 = getResultForIOException(url, i16, e);
                                                        handleFinally(i19, outputStream4, file, httpEntity2);
                                                        i27++;
                                                        waitBeforeRetry(url, obj, i19, i27);
                                                        if (i19 == 0) {
                                                        }
                                                        return i19;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        HttpEntity httpEntity3 = httpEntity2;
                                                        outputStream2 = outputStream4;
                                                        i17 = i16;
                                                        httpEntity = httpEntity3;
                                                        handleFinally(i17, outputStream2, file, httpEntity);
                                                        throw th;
                                                    }
                                                } catch (Exception e19) {
                                                    e = e19;
                                                    httpEntity = httpEntity2;
                                                    i18 = i17;
                                                    outputStream4 = outputStream3;
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        handleFinally(5, outputStream4, file, httpEntity);
                                                        httpEntity2 = httpEntity;
                                                        i19 = 5;
                                                        i27++;
                                                        waitBeforeRetry(url, obj, i19, i27);
                                                        if (i19 == 0) {
                                                        }
                                                        return i19;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        int i28 = i18;
                                                        outputStream2 = outputStream4;
                                                        i17 = i28;
                                                        handleFinally(i17, outputStream2, file, httpEntity);
                                                        throw th;
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    httpEntity = httpEntity2;
                                                    outputStream2 = outputStream3;
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        handleFinally(5, outputStream2, file, httpEntity);
                                                        outputStream4 = outputStream2;
                                                        httpEntity2 = httpEntity;
                                                        i19 = 5;
                                                        i27++;
                                                        waitBeforeRetry(url, obj, i19, i27);
                                                        if (i19 == 0) {
                                                        }
                                                        return i19;
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        handleFinally(i17, outputStream2, file, httpEntity);
                                                        throw th;
                                                    }
                                                }
                                            }
                                            i19 = i17;
                                            outputStream4 = outputStream3;
                                            handleFinally(i19, outputStream4, file, httpEntity2);
                                            i27++;
                                            waitBeforeRetry(url, obj, i19, i27);
                                            if (i19 == 0) {
                                            }
                                            return i19;
                                        } catch (IOException e26) {
                                            e = e26;
                                            outputStream4 = outputStream3;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("HttpDownloadUtil", 2, e.getMessage(), e);
                                            }
                                            i26 = 4;
                                            outputStream3 = outputStream4;
                                            i17 = i26;
                                            if (contentLength > 0) {
                                            }
                                            i19 = i17;
                                            outputStream4 = outputStream3;
                                            handleFinally(i19, outputStream4, file, httpEntity2);
                                            i27++;
                                            waitBeforeRetry(url, obj, i19, i27);
                                            if (i19 == 0) {
                                            }
                                            return i19;
                                        } catch (Exception e27) {
                                            e = e27;
                                            httpEntity = httpEntity2;
                                            outputStream4 = outputStream3;
                                            i18 = 5;
                                            if (QLog.isColorLevel()) {
                                            }
                                            handleFinally(5, outputStream4, file, httpEntity);
                                            httpEntity2 = httpEntity;
                                            i19 = 5;
                                            i27++;
                                            waitBeforeRetry(url, obj, i19, i27);
                                            if (i19 == 0) {
                                            }
                                            return i19;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            httpEntity = httpEntity2;
                                            outputStream2 = outputStream3;
                                            i17 = 5;
                                            if (QLog.isColorLevel()) {
                                            }
                                            handleFinally(5, outputStream2, file, httpEntity);
                                            outputStream4 = outputStream2;
                                            httpEntity2 = httpEntity;
                                            i19 = 5;
                                            i27++;
                                            waitBeforeRetry(url, obj, i19, i27);
                                            if (i19 == 0) {
                                            }
                                            return i19;
                                        }
                                    } catch (FileNotFoundException unused3) {
                                        j16 = 0;
                                    } catch (IOException e28) {
                                        e = e28;
                                        j16 = 0;
                                    }
                                    i17 = i26;
                                    if (contentLength > 0 && j16 < contentLength) {
                                        if (QLog.isColorLevel()) {
                                            QLog.w("HttpDownloadUtil", 2, "Download fail. contentLen=" + contentLength + ", fileLen=" + file.length() + ", url=" + url);
                                        }
                                        i17 = 8;
                                    }
                                    i19 = i17;
                                    outputStream4 = outputStream3;
                                } else {
                                    i19 = statusCode;
                                }
                            } catch (Exception e29) {
                                e = e29;
                                httpEntity = httpEntity2;
                                i18 = 5;
                                if (QLog.isColorLevel()) {
                                    QLog.d("HttpDownloadUtil", 2, "Download fail 2. url=" + url, e);
                                }
                                handleFinally(5, outputStream4, file, httpEntity);
                                httpEntity2 = httpEntity;
                                i19 = 5;
                                i27++;
                                waitBeforeRetry(url, obj, i19, i27);
                                if (i19 == 0) {
                                }
                                return i19;
                            } catch (Throwable th11) {
                                th = th11;
                                httpEntity = httpEntity2;
                                outputStream2 = outputStream4;
                                i17 = 5;
                                if (QLog.isColorLevel()) {
                                    QLog.d("HttpDownloadUtil", 2, "Download fail 2. url=" + url, th);
                                }
                                handleFinally(5, outputStream2, file, httpEntity);
                                outputStream4 = outputStream2;
                                httpEntity2 = httpEntity;
                                i19 = 5;
                                i27++;
                                waitBeforeRetry(url, obj, i19, i27);
                                if (i19 == 0) {
                                }
                                return i19;
                            }
                        } catch (IOException e36) {
                            e = e36;
                            i16 = 5;
                            i19 = getResultForIOException(url, i16, e);
                            handleFinally(i19, outputStream4, file, httpEntity2);
                            i27++;
                            waitBeforeRetry(url, obj, i19, i27);
                            if (i19 == 0) {
                            }
                            return i19;
                        }
                    } catch (IOException e37) {
                        e = e37;
                    }
                } catch (Exception e38) {
                    e = e38;
                } catch (Throwable th12) {
                    th = th12;
                }
            } catch (IOException e39) {
                e = e39;
                i16 = 5;
            }
            handleFinally(i19, outputStream4, file, httpEntity2);
            i27++;
            waitBeforeRetry(url, obj, i19, i27);
            if (i19 == 0) {
                break;
            }
        } while (i27 < i3);
        return i19;
    }

    private static int handleIOException(DownloadInfo downloadInfo, b bVar, URL url, int i3, IOException iOException) {
        iOException.printStackTrace();
        if (iOException instanceof UnknownHostException) {
            i3 = 10;
        } else if (!(iOException instanceof ConnectTimeoutException) && !(iOException instanceof SocketTimeoutException)) {
            if (iOException instanceof SocketException) {
                downloadInfo.resultCode = 11;
            } else {
                i3 = 4;
            }
        } else {
            i3 = 2;
        }
        QLog.w("HttpDownloadUtil", 2, "Download fail resultCode=" + i3 + ". url=" + downloadInfo.reqUrl + " exception:" + iOException.getMessage());
        if (bVar != null) {
            bVar.c(url.toString(), i3);
        }
        return i3;
    }

    private static int handleQueryDownloadInfoException(int i3, DownloadInfo downloadInfo, int i16, IOException iOException) {
        int i17;
        int i18;
        if (QLog.isColorLevel()) {
            iOException.printStackTrace();
        }
        if (iOException instanceof UnknownHostException) {
            i17 = 10;
        } else if (!(iOException instanceof ConnectTimeoutException) && !(iOException instanceof SocketTimeoutException)) {
            if (iOException instanceof SocketException) {
                downloadInfo.resultCode = 11;
                i18 = 5;
            } else if (iOException instanceof MalformedURLException) {
                i17 = 13;
            } else {
                i18 = 4;
            }
            i17 = i18;
            i3 = i16;
        } else {
            i3 = i16;
            i17 = 2;
        }
        downloadInfo.resultCode = i17;
        if (QLog.isColorLevel()) {
            QLog.w("HttpDownloadUtil", 2, "queryDownloadInfo fail resultCode=" + i17 + " http code: " + downloadInfo.httpRespCode + ". url=" + downloadInfo.reqUrl + " IOexception:" + iOException.toString());
        }
        return i3;
    }

    private static boolean handleResp200(a aVar, DownloadInfo downloadInfo) {
        if (aVar != null) {
            downloadInfo.resultCode = 0;
            if (aVar.onRespDownloadInfo(downloadInfo)) {
                downloadInfo.resultCode = 0;
                return true;
            }
            downloadInfo.resultCode = 4;
            return false;
        }
        downloadInfo.resultCode = 0;
        return true;
    }

    private static void handleTags(DownloadInfo downloadInfo, NetworkInfo networkInfo) {
        if (downloadInfo.action != 10001) {
            NetworkUtil.isMobileNetworkInfo(networkInfo);
        } else {
            NetworkUtil.isMobileNetworkInfo(networkInfo);
        }
    }

    private static boolean makeParentDirsFailed(DownloadInfo downloadInfo, b bVar, URL url) {
        try {
            File parentFile = downloadInfo.file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                if (bVar != null) {
                    bVar.c(url.toString(), 4);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("HttpDownloadUtil", 2, "save file fail,info.url=" + downloadInfo.reqUrl);
                }
                return true;
            }
            return false;
        } catch (Exception unused) {
            if (bVar != null) {
                bVar.c(url.toString(), 4);
            }
            if (QLog.isColorLevel()) {
                QLog.d("HttpDownloadUtil", 2, "save file fail,info.url=" + downloadInfo.reqUrl);
            }
            return true;
        }
    }

    public static DownloadInfo queryDownloadInfo(String str, a aVar) {
        return queryDownloadInfo(str, aVar, null, 2, true);
    }

    public static boolean shutdownSniSupport() {
        if (!sShutdownSniSupportInited) {
            sShutdownSniSupportInited = true;
            try {
                String featureValueAioConfig = UtilApi.util.getFeatureValueAioConfig();
                if (QLog.isColorLevel()) {
                    QLog.d("HttpDownloadUtil", 2, "shutdownSniSupport:" + featureValueAioConfig);
                }
                String[] split = featureValueAioConfig.split("\\|");
                if (split.length > 15) {
                    sShutdownSniSupport = split[15].equals("1");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("HttpDownloadUtil", 2, "shutdownSniSupport e:" + e16.toString());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("HttpDownloadUtil", 2, "shutdownSniSupport " + sShutdownSniSupport);
        }
        return sShutdownSniSupport;
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x02ba, code lost:
    
        if (r1 != null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02b2, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02b0, code lost:
    
        if (r1 == null) goto L165;
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0267 A[Catch: all -> 0x0251, TryCatch #15 {all -> 0x0251, blocks: (B:30:0x0045, B:32:0x0059, B:179:0x0061, B:185:0x0066, B:188:0x006f, B:183:0x007d, B:125:0x0261, B:127:0x0267, B:128:0x026a, B:130:0x0273, B:120:0x02b6, B:36:0x0092, B:38:0x009b, B:41:0x00a5, B:42:0x00a7, B:46:0x00af, B:48:0x00b7, B:50:0x00bf, B:53:0x00c8, B:55:0x00d0, B:56:0x00ec, B:58:0x00f1, B:60:0x00f7, B:61:0x00fb, B:63:0x0101, B:65:0x0113, B:159:0x014e, B:161:0x015e, B:164:0x0187, B:153:0x019e, B:155:0x01a2, B:69:0x01a9, B:71:0x01af, B:99:0x01c2, B:100:0x01cd, B:102:0x01da, B:105:0x01f0, B:106:0x01f5, B:143:0x01fb, B:108:0x0203, B:175:0x00d5, B:176:0x00da, B:177:0x00df), top: B:29:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0273 A[Catch: all -> 0x0251, TRY_LEAVE, TryCatch #15 {all -> 0x0251, blocks: (B:30:0x0045, B:32:0x0059, B:179:0x0061, B:185:0x0066, B:188:0x006f, B:183:0x007d, B:125:0x0261, B:127:0x0267, B:128:0x026a, B:130:0x0273, B:120:0x02b6, B:36:0x0092, B:38:0x009b, B:41:0x00a5, B:42:0x00a7, B:46:0x00af, B:48:0x00b7, B:50:0x00bf, B:53:0x00c8, B:55:0x00d0, B:56:0x00ec, B:58:0x00f1, B:60:0x00f7, B:61:0x00fb, B:63:0x0101, B:65:0x0113, B:159:0x014e, B:161:0x015e, B:164:0x0187, B:153:0x019e, B:155:0x01a2, B:69:0x01a9, B:71:0x01af, B:99:0x01c2, B:100:0x01cd, B:102:0x01da, B:105:0x01f0, B:106:0x01f5, B:143:0x01fb, B:108:0x0203, B:175:0x00d5, B:176:0x00da, B:177:0x00df), top: B:29:0x0045 }] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static DownloadInfo startQueryDownloadInfo(String str, a aVar, List<Header> list, int i3, boolean z16, int i16, int i17, int i18, DownloadInfo downloadInfo, String str2, Object obj, long j3, HttpURLConnection httpURLConnection, int i19) {
        int i26;
        long j16;
        HttpURLConnection httpURLConnection2;
        StringBuilder sb5;
        int i27;
        List<Header> list2 = list;
        long j17 = j3;
        HttpURLConnection httpURLConnection3 = httpURLConnection;
        int i28 = i19;
        while (true) {
            NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
            if (recentNetworkInfo == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("HttpDownloadUtil", 2, "queryDownloadInfo failed-----------activeNetworkInfo is null");
                }
                downloadInfo.resultCode = 1;
                i28++;
                if (i28 >= i3) {
                    if (aVar != null) {
                        aVar.onRespDownloadInfo(downloadInfo);
                    }
                    return downloadInfo;
                }
                synchronized (obj) {
                    try {
                        obj.wait(j17);
                        j17 *= 4;
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                try {
                    try {
                        try {
                            String netGetExInfo = NetworkMonitor.netGetExInfo(recentNetworkInfo);
                            int type = NetworkMonitor.getType(recentNetworkInfo);
                            String defaultHost = Proxy.getDefaultHost();
                            int defaultPort = Proxy.getDefaultPort();
                            String apnType = com.tencent.mobileqq.utils.httputils.PkgTools.getApnType(netGetExInfo);
                            try {
                                if (!apnType.equals(lastApn)) {
                                    try {
                                        try {
                                            lastApn = apnType;
                                            if (type != 1) {
                                                try {
                                                    if (!apnType.equals(com.tencent.mobileqq.utils.httputils.PkgTools.APN_TYPE_CMWAP)) {
                                                        forceDirect = true;
                                                    }
                                                } catch (IOException e16) {
                                                    e = e16;
                                                    j16 = j17;
                                                    i28 = handleQueryDownloadInfoException(i3, downloadInfo, i28, e);
                                                } catch (Exception e17) {
                                                    e = e17;
                                                    j16 = j17;
                                                    i26 = 2;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    downloadInfo.resultCode = 5;
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                }
                                            }
                                            forceDirect = false;
                                        } catch (IOException e18) {
                                            e = e18;
                                            j16 = j17;
                                            i28 = handleQueryDownloadInfoException(i3, downloadInfo, i28, e);
                                        }
                                    } catch (Exception e19) {
                                        e = e19;
                                        j16 = j17;
                                        i26 = 2;
                                        if (QLog.isColorLevel()) {
                                        }
                                        downloadInfo.resultCode = 5;
                                        if (QLog.isColorLevel()) {
                                        }
                                    }
                                }
                                if (type == 1 && ("10.0.0.172".equals(defaultHost) || "10.0.0.200".equals(defaultHost))) {
                                    forceDirect = true;
                                }
                                if (!forceDirect && defaultHost != null && defaultPort > 0) {
                                    if (!apnType.equals(com.tencent.mobileqq.utils.httputils.PkgTools.APN_TYPE_CMWAP) && !apnType.equals(com.tencent.mobileqq.utils.httputils.PkgTools.APN_TYPE_UNIWAP) && !apnType.equals(com.tencent.mobileqq.utils.httputils.PkgTools.APN_TYPE_3GWAP)) {
                                        if (apnType.equals(com.tencent.mobileqq.utils.httputils.PkgTools.APN_TYPE_CTWAP)) {
                                            httpURLConnection2 = com.tencent.mobileqq.utils.httputils.PkgTools.getConnectionWithDefaultProxy(str2, defaultHost, defaultPort);
                                        } else {
                                            httpURLConnection2 = com.tencent.mobileqq.utils.httputils.PkgTools.getConnectionWithDefaultProxy(str2, defaultHost, defaultPort);
                                        }
                                    }
                                    httpURLConnection2 = com.tencent.mobileqq.utils.httputils.PkgTools.getConnectionWithXOnlineHost(str2, defaultHost, defaultPort);
                                } else {
                                    httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection(java.net.Proxy.NO_PROXY);
                                }
                                httpURLConnection3 = httpURLConnection2;
                                downloadInfo.conn = httpURLConnection3;
                                if (list2 != null && !list.isEmpty()) {
                                    for (Header header : list) {
                                        httpURLConnection3.addRequestProperty(header.getName(), header.getValue());
                                    }
                                }
                                httpURLConnection3.setRequestProperty("Accept-Encoding", "identity");
                                httpURLConnection3.setConnectTimeout(i17);
                                httpURLConnection3.setReadTimeout(i18);
                                httpURLConnection3.setInstanceFollowRedirects(false);
                                httpURLConnection3.connect();
                                downloadInfo.httpRespCode = httpURLConnection3.getResponseCode();
                                downloadInfo.respContentLength = httpURLConnection3.getContentLength();
                                downloadInfo.respContentType = httpURLConnection3.getContentType();
                                downloadInfo.respContentEncoding = httpURLConnection3.getContentEncoding();
                                copyRespHeader(httpURLConnection3, downloadInfo);
                                if (QLog.isColorLevel()) {
                                    try {
                                        sb5 = new StringBuilder();
                                        sb5.append("url : ");
                                        sb5.append(str);
                                        sb5.append(" respCode: ");
                                        sb5.append(downloadInfo.httpRespCode);
                                        sb5.append(" contentLength: ");
                                        sb5.append(downloadInfo.respContentLength);
                                        sb5.append(" contentType: ");
                                        sb5.append(downloadInfo.respContentType);
                                    } catch (IOException e26) {
                                        e = e26;
                                        j16 = j17;
                                        i28 = handleQueryDownloadInfoException(i3, downloadInfo, i28, e);
                                    } catch (Exception e27) {
                                        e = e27;
                                        j16 = j17;
                                        i26 = 2;
                                        if (QLog.isColorLevel()) {
                                        }
                                        downloadInfo.resultCode = 5;
                                        if (QLog.isColorLevel()) {
                                        }
                                    }
                                    try {
                                        QLog.i("HttpDownloadUtil", 2, sb5.toString());
                                    } catch (Exception e28) {
                                        e = e28;
                                        i26 = 2;
                                        j16 = j17;
                                        if (QLog.isColorLevel()) {
                                            e.printStackTrace();
                                        }
                                        downloadInfo.resultCode = 5;
                                        if (QLog.isColorLevel()) {
                                            QLog.w("HttpDownloadUtil", i26, "queryDownloadInfo fail resultCode=" + downloadInfo.resultCode + "http code: " + downloadInfo.httpRespCode + ". url=" + downloadInfo.reqUrl + " exception:" + e.toString());
                                        }
                                    }
                                }
                            } catch (Exception e29) {
                                e = e29;
                            }
                        } catch (IOException e36) {
                            e = e36;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e37) {
                    e = e37;
                    i26 = 2;
                    j16 = j17;
                }
                if (z16) {
                    downloadInfo.resultCode = 0;
                    if (aVar != null) {
                        aVar.onRespDownloadInfo(downloadInfo);
                    }
                    httpURLConnection3.disconnect();
                    return downloadInfo;
                }
                int i29 = downloadInfo.httpRespCode;
                if (i29 == 200) {
                    if (handleResp200(aVar, downloadInfo)) {
                        httpURLConnection3.disconnect();
                        return downloadInfo;
                    }
                } else if (i29 != 302 && i29 != 301) {
                    downloadInfo.resultCode = i29;
                } else {
                    String headerField = httpURLConnection3.getHeaderField("Location");
                    if (QLog.isColorLevel()) {
                        i27 = 2;
                        try {
                            QLog.w("HttpDownloadUtil", 2, "queryDownloadInfo new url is: " + headerField);
                        } catch (Exception e38) {
                            e = e38;
                            i26 = 2;
                            j16 = j17;
                            if (QLog.isColorLevel()) {
                            }
                            downloadInfo.resultCode = 5;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        i27 = 2;
                    }
                    if (TextUtils.isEmpty(headerField)) {
                        downloadInfo.resultCode = 20;
                        httpURLConnection3.disconnect();
                        return downloadInfo;
                    }
                    httpURLConnection3.disconnect();
                    try {
                        try {
                            handleAddHeaders(list2, headerField);
                            i26 = i27;
                            j16 = j17;
                        } catch (IOException e39) {
                            e = e39;
                            j16 = j17;
                        } catch (Exception e46) {
                            e = e46;
                            i26 = i27;
                            j16 = j17;
                        }
                        try {
                            return queryDownloadInfo(headerField, aVar, list, i3, z16, i16 + 1, i17, i18);
                        } catch (IOException e47) {
                            e = e47;
                            httpURLConnection3 = null;
                            i28 = handleQueryDownloadInfoException(i3, downloadInfo, i28, e);
                        } catch (Exception e48) {
                            e = e48;
                            httpURLConnection3 = null;
                            if (QLog.isColorLevel()) {
                            }
                            downloadInfo.resultCode = 5;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        httpURLConnection3 = null;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        throw th;
                    }
                }
                httpURLConnection3.disconnect();
                j16 = j17;
                i28++;
                if (i28 < i3) {
                    synchronized (obj) {
                        long j18 = j16;
                        try {
                            obj.wait(j18);
                            j17 = j18 * 4;
                        } catch (InterruptedException unused2) {
                            j17 = j18;
                        }
                    }
                } else {
                    long j19 = j16;
                    if (aVar != null) {
                        aVar.onRespDownloadInfo(downloadInfo);
                    }
                    j17 = j19;
                }
            }
            if (i28 >= i3) {
                return downloadInfo;
            }
            list2 = list;
        }
    }

    private static void waitBeforeRetry(URL url, Object obj, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("HttpDownloadUtil", 2, "Download. result=" + i3 + ", url=" + url);
        }
        if (i3 != 0) {
            QLog.d("HttpDownloadUtil", 1, "Download. result=" + i3 + ", url=" + url + ", tryCount=" + i16);
        }
        if (i3 != 0 && i16 < 2) {
            synchronized (obj) {
                try {
                    obj.wait(500L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static boolean download(AppRuntime appRuntime, URL url, File file) {
        return download(appRuntime, url, file, AppNetConnInfo.getRecentNetworkInfo(), 2) == 0;
    }

    public static int downloadData(AppRuntime appRuntime, String str, File file, int i3) {
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
            }
            return 1;
        }
        try {
            return download(appRuntime, new URL(str), file, recentNetworkInfo, i3);
        } catch (MalformedURLException e16) {
            QLog.e("HttpDownloadUtil", 1, "downloadData fail url:", str);
            QLog.e("HttpDownloadUtil", 1, "downloadData create URL exception", e16);
            return 5;
        }
    }

    public static DownloadInfo queryDownloadInfo(String str, a aVar, List<Header> list, int i3, boolean z16) {
        int netType = NetworkCenter.getInstance().getNetType();
        return queryDownloadInfo(str, aVar, list, i3, z16, 0, c.a(netType), c.b(netType));
    }

    public static int download(AppRuntime appRuntime, URL url, File file, NetworkInfo networkInfo) {
        return download(appRuntime, url, file, networkInfo, 2);
    }

    public static DownloadInfo queryDownloadInfo(String str, a aVar, List<Header> list, int i3, boolean z16, int i16, int i17) {
        return queryDownloadInfo(str, aVar, list, i3, z16, 0, i16, i17);
    }

    private static int download(AppRuntime appRuntime, URL url, File file, NetworkInfo networkInfo, int i3) {
        HttpGet httpGet;
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = new Object();
        if (file == null) {
            return 5;
        }
        if (i3 < 0) {
            i3 = 2;
        }
        int i16 = i3;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            String url2 = url.toString();
            try {
                try {
                    httpGet = new HttpGet(url2);
                } catch (IllegalArgumentException unused) {
                    httpGet = new HttpGet(getEscapeSequence(url2));
                }
                HttpParams httpParams = getHttpParams(networkInfo);
                httpGet.setParams(httpParams);
                if (file.exists()) {
                    file.delete();
                }
                return handleHttpRequest(url, i16, currentTimeMillis, obj, null, httpGet, httpParams, file);
            } catch (IllegalArgumentException unused2) {
                QLog.d("HttpDownloadUtil", 1, "Download. result=DOWNLOAD_URL_STRING_ILLEGAL as new HttpGet exception.");
                return 13;
            }
        } catch (Exception unused3) {
            QLog.d("HttpDownloadUtil", 1, "Download. result=DOWNLOAD_SAVE_FILE_FAIL as file exception.");
            return 4;
        }
    }

    private static DownloadInfo queryDownloadInfo(String str, a aVar, List<Header> list, int i3, boolean z16, int i16, int i17, int i18) {
        DownloadInfo downloadInfo = new DownloadInfo(str, null, 0);
        if (i16 >= 3) {
            if (QLog.isColorLevel()) {
                QLog.w("HttpDownloadUtil", 2, "download redirect times beyond.");
            }
            downloadInfo.resultCode = 20;
            return downloadInfo;
        }
        try {
            new URL(downloadInfo.reqUrl);
            String str2 = downloadInfo.reqUrl;
            try {
                try {
                    new HttpGet(str2);
                } catch (IllegalArgumentException unused) {
                    new HttpGet(getEscapeSequence(str2));
                    str2 = getEscapeSequence(str2);
                }
                return startQueryDownloadInfo(str, aVar, list, i3, z16, i16, i17, i18, downloadInfo, str2, new Object(), 5000L, null, 0);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("HttpDownloadUtil", 2, e16.toString());
                }
                downloadInfo.resultCode = 13;
                if (aVar != null) {
                    aVar.onRespDownloadInfo(downloadInfo);
                }
                return downloadInfo;
            }
        } catch (MalformedURLException e17) {
            if (QLog.isColorLevel()) {
                QLog.w("HttpDownloadUtil", 2, e17.toString());
            }
            downloadInfo.errorDetail = String.valueOf(e17);
            downloadInfo.resultCode = 13;
            if (aVar != null) {
                aVar.onRespDownloadInfo(downloadInfo);
            }
            return downloadInfo;
        }
    }

    public static int downloadData(AppRuntime appRuntime, DownloadInfo downloadInfo, b bVar) {
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo == null) {
            if (!QLog.isColorLevel()) {
                return 9;
            }
            QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
            return 9;
        }
        return download(appRuntime, downloadInfo, recentNetworkInfo, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x038a A[Catch: all -> 0x03b5, TryCatch #6 {all -> 0x03b5, blocks: (B:133:0x0386, B:135:0x038a, B:138:0x038f), top: B:132:0x0386 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03a6 A[Catch: IOException -> 0x03a0, all -> 0x03f9, Exception -> 0x03fb, TryCatch #21 {IOException -> 0x03a0, blocks: (B:148:0x039c, B:144:0x03a6, B:146:0x03ad), top: B:147:0x039c }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03ad A[Catch: IOException -> 0x03a0, all -> 0x03f9, Exception -> 0x03fb, TRY_LEAVE, TryCatch #21 {IOException -> 0x03a0, blocks: (B:148:0x039c, B:144:0x03a6, B:146:0x03ad), top: B:147:0x039c }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x039c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0426 A[Catch: all -> 0x0415, TRY_LEAVE, TryCatch #46 {all -> 0x0415, blocks: (B:35:0x00cc, B:305:0x00e8, B:37:0x00fb, B:85:0x0449, B:163:0x0421, B:165:0x0426), top: B:34:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x043b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0430 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x048d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x04ad A[ADDED_TO_REGION, EDGE_INSN: B:69:0x04ad->B:68:0x04ad BREAK  A[LOOP:0: B:32:0x00b4->B:66:0x04a2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x040f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0404 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x045a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x044f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int download(AppRuntime appRuntime, DownloadInfo downloadInfo, NetworkInfo networkInfo, b bVar) {
        HttpGet httpGet;
        int i3;
        Throwable th5;
        BasicHttpParams basicHttpParams;
        HttpGet httpGet2;
        File file;
        int i16;
        int i17;
        int i18;
        HttpEntity httpEntity;
        InputStream inputStream;
        int i19;
        int i26;
        long j3;
        long j16;
        File file2;
        int i27;
        int i28;
        InputStream inputStream2;
        b bVar2 = bVar;
        if (!checkValid(downloadInfo)) {
            return 5;
        }
        try {
            URL url = new URL(downloadInfo.reqUrl);
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = new Object();
            if (makeParentDirsFailed(downloadInfo, bVar2, url)) {
                return 4;
            }
            String str = downloadInfo.reqUrl;
            try {
                try {
                    httpGet = new HttpGet(str);
                } catch (IllegalArgumentException unused) {
                    return 13;
                }
            } catch (IllegalArgumentException unused2) {
                httpGet = new HttpGet(getEscapeSequence(str));
            }
            HttpGet httpGet3 = httpGet;
            BasicHttpParams basicHttpParams2 = new BasicHttpParams();
            basicHttpParams2.setParameter("http.connection.timeout", 60000);
            basicHttpParams2.setParameter("http.socket.timeout", 60000);
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (networkInfo != null) {
                String netGetExInfo = NetworkMonitor.netGetExInfo(networkInfo);
                if (NetworkUtil.isMobileNetworkInfo(networkInfo) && ((netGetExInfo == null || netGetExInfo.endsWith("wap")) && defaultHost != null && defaultPort > 0)) {
                    basicHttpParams2.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(defaultHost, defaultPort));
                }
                i3 = NetworkUtil.isMobileNetworkInfo(networkInfo) ? 2048 : 4096;
                basicHttpParams2.setIntParameter("http.socket.buffer-size", i3);
                httpGet3.setParams(basicHttpParams2);
            } else {
                i3 = 0;
            }
            File file3 = new File(downloadInfo.getLoadingTmpPath());
            if (file3.exists()) {
                file3.delete();
            }
            int i29 = -1;
            FileOutputStream fileOutputStream = null;
            HttpEntity httpEntity2 = null;
            int i36 = i3;
            while (true) {
                if (i29 == 0) {
                    basicHttpParams2.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(url.getHost(), url.getPort()));
                    httpGet3.setParams(basicHttpParams2);
                }
                try {
                    try {
                        try {
                            HttpResponse execute = CLIENT.execute(new HttpHost(url.getHost()), httpGet3);
                            StatusLine statusLine = execute.getStatusLine();
                            execute.getAllHeaders();
                            int i37 = statusLine.getStatusCode();
                            if (bVar2 != null) {
                                try {
                                    bVar2.a(url.toString(), i37);
                                } catch (IOException e16) {
                                    e = e16;
                                    basicHttpParams = basicHttpParams2;
                                    httpGet2 = httpGet3;
                                    i37 = 5;
                                    file = file3;
                                    i16 = handleIOException(downloadInfo, bVar2, url, i37, e);
                                    if (httpEntity2 != null) {
                                        try {
                                            httpEntity2.consumeContent();
                                        } catch (IOException e17) {
                                            e17.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    i17 = i29 + 1;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (i17 < i18) {
                                        synchronized (obj) {
                                        }
                                    }
                                    if (i16 != 0) {
                                        break;
                                    }
                                    break;
                                    return i16;
                                }
                            }
                            HttpEntity entity = execute.getEntity();
                            if (200 == i37) {
                                try {
                                    long contentLength = entity.getContentLength();
                                    try {
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                                        try {
                                            inputStream = entity.getContent();
                                            int i38 = i36 == 0 ? 2048 : i36;
                                            try {
                                                byte[] bArr = new byte[i38];
                                                int i39 = i38;
                                                File file4 = file3;
                                                int i46 = 0;
                                                while (true) {
                                                    j3 = i46;
                                                    if (j3 >= contentLength) {
                                                        break;
                                                    }
                                                    try {
                                                        int read = inputStream.read(bArr);
                                                        try {
                                                            fileOutputStream2.write(bArr, 0, read);
                                                            int i47 = read + i46;
                                                            long j17 = contentLength;
                                                            bVar2 = bVar;
                                                            if (bVar2 != null) {
                                                                try {
                                                                    httpEntity = entity;
                                                                    httpGet2 = httpGet3;
                                                                    i27 = i39;
                                                                    i28 = i47;
                                                                    File file5 = file4;
                                                                    inputStream2 = inputStream;
                                                                    basicHttpParams = basicHttpParams2;
                                                                    file2 = file5;
                                                                } catch (IOException e18) {
                                                                    e = e18;
                                                                    basicHttpParams = basicHttpParams2;
                                                                    httpEntity = entity;
                                                                    httpGet2 = httpGet3;
                                                                    file2 = file4;
                                                                    i27 = i39;
                                                                    fileOutputStream = fileOutputStream2;
                                                                    i36 = i27;
                                                                    file = file2;
                                                                    i19 = 5;
                                                                    try {
                                                                        if (!(e instanceof ConnectTimeoutException)) {
                                                                        }
                                                                        i26 = 3;
                                                                        i16 = i26;
                                                                        if (inputStream != null) {
                                                                        }
                                                                        if (i16 == 0) {
                                                                        }
                                                                        if (bVar2 != null) {
                                                                        }
                                                                        if (httpEntity != null) {
                                                                        }
                                                                        if (fileOutputStream != null) {
                                                                        }
                                                                        httpEntity2 = httpEntity;
                                                                        i17 = i29 + 1;
                                                                        if (QLog.isColorLevel()) {
                                                                        }
                                                                        if (i17 < i18) {
                                                                        }
                                                                        if (i16 != 0) {
                                                                        }
                                                                        return i16;
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                        if (inputStream != null) {
                                                                            try {
                                                                                try {
                                                                                    inputStream.close();
                                                                                } catch (Exception e19) {
                                                                                    e = e19;
                                                                                    httpEntity2 = httpEntity;
                                                                                    e.printStackTrace();
                                                                                    if (bVar2 != null) {
                                                                                        bVar2.c(url.toString(), 5);
                                                                                    }
                                                                                    if (httpEntity2 != null) {
                                                                                        try {
                                                                                            httpEntity2.consumeContent();
                                                                                        } catch (IOException e26) {
                                                                                            e26.printStackTrace();
                                                                                        }
                                                                                    }
                                                                                    if (fileOutputStream != null) {
                                                                                        try {
                                                                                            fileOutputStream.close();
                                                                                        } catch (IOException unused4) {
                                                                                        }
                                                                                    }
                                                                                    i16 = 5;
                                                                                    i17 = i29 + 1;
                                                                                    if (QLog.isColorLevel()) {
                                                                                    }
                                                                                    if (i17 < i18) {
                                                                                    }
                                                                                    if (i16 != 0) {
                                                                                    }
                                                                                    return i16;
                                                                                } catch (Throwable th7) {
                                                                                    th = th7;
                                                                                    th5 = th;
                                                                                    httpEntity2 = httpEntity;
                                                                                    if (httpEntity2 != null) {
                                                                                        try {
                                                                                            httpEntity2.consumeContent();
                                                                                        } catch (IOException e27) {
                                                                                            e27.printStackTrace();
                                                                                        }
                                                                                    }
                                                                                    if (fileOutputStream == null) {
                                                                                        try {
                                                                                            fileOutputStream.close();
                                                                                            throw th5;
                                                                                        } catch (IOException unused5) {
                                                                                            throw th5;
                                                                                        }
                                                                                    }
                                                                                    throw th5;
                                                                                }
                                                                            } catch (IOException e28) {
                                                                                e = e28;
                                                                                i37 = i19;
                                                                                httpEntity2 = httpEntity;
                                                                                i16 = handleIOException(downloadInfo, bVar2, url, i37, e);
                                                                                if (httpEntity2 != null) {
                                                                                }
                                                                                if (fileOutputStream != null) {
                                                                                }
                                                                                i17 = i29 + 1;
                                                                                if (QLog.isColorLevel()) {
                                                                                }
                                                                                if (i17 < i18) {
                                                                                }
                                                                                if (i16 != 0) {
                                                                                }
                                                                                return i16;
                                                                            }
                                                                        }
                                                                        throw th;
                                                                        break;
                                                                    }
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    basicHttpParams = basicHttpParams2;
                                                                    httpEntity = entity;
                                                                    httpGet2 = httpGet3;
                                                                    file2 = file4;
                                                                    i27 = i39;
                                                                    fileOutputStream = fileOutputStream2;
                                                                    i36 = i27;
                                                                    file = file2;
                                                                    i19 = 5;
                                                                    if (inputStream != null) {
                                                                    }
                                                                    throw th;
                                                                    break;
                                                                    break;
                                                                }
                                                                try {
                                                                    bVar.b(url.toString(), j17, i47);
                                                                } catch (IOException e29) {
                                                                    e = e29;
                                                                    fileOutputStream = fileOutputStream2;
                                                                    inputStream = inputStream2;
                                                                    i36 = i27;
                                                                    file = file2;
                                                                    i19 = 5;
                                                                    if (!(e instanceof ConnectTimeoutException)) {
                                                                    }
                                                                    i26 = 3;
                                                                    i16 = i26;
                                                                    if (inputStream != null) {
                                                                    }
                                                                    if (i16 == 0) {
                                                                    }
                                                                    if (bVar2 != null) {
                                                                    }
                                                                    if (httpEntity != null) {
                                                                    }
                                                                    if (fileOutputStream != null) {
                                                                    }
                                                                    httpEntity2 = httpEntity;
                                                                    i17 = i29 + 1;
                                                                    if (QLog.isColorLevel()) {
                                                                    }
                                                                    if (i17 < i18) {
                                                                    }
                                                                    if (i16 != 0) {
                                                                    }
                                                                    return i16;
                                                                } catch (Throwable th9) {
                                                                    th = th9;
                                                                    fileOutputStream = fileOutputStream2;
                                                                    inputStream = inputStream2;
                                                                    i36 = i27;
                                                                    file = file2;
                                                                    i19 = 5;
                                                                    if (inputStream != null) {
                                                                    }
                                                                    throw th;
                                                                    break;
                                                                    break;
                                                                }
                                                            } else {
                                                                basicHttpParams = basicHttpParams2;
                                                                httpEntity = entity;
                                                                httpGet2 = httpGet3;
                                                                file2 = file4;
                                                                i27 = i39;
                                                                i28 = i47;
                                                                inputStream2 = inputStream;
                                                            }
                                                            httpGet3 = httpGet2;
                                                            inputStream = inputStream2;
                                                            i46 = i28;
                                                            contentLength = j17;
                                                            entity = httpEntity;
                                                            i39 = i27;
                                                            basicHttpParams2 = basicHttpParams;
                                                            file4 = file2;
                                                        } catch (IOException e36) {
                                                            e = e36;
                                                            bVar2 = bVar;
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            bVar2 = bVar;
                                                        }
                                                    } catch (IOException e37) {
                                                        e = e37;
                                                        bVar2 = bVar;
                                                        basicHttpParams = basicHttpParams2;
                                                        httpEntity = entity;
                                                        httpGet2 = httpGet3;
                                                        file2 = file4;
                                                        i27 = i39;
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        bVar2 = bVar;
                                                        basicHttpParams = basicHttpParams2;
                                                        httpEntity = entity;
                                                        httpGet2 = httpGet3;
                                                        file2 = file4;
                                                        i27 = i39;
                                                    }
                                                }
                                                basicHttpParams = basicHttpParams2;
                                                long j18 = contentLength;
                                                httpEntity = entity;
                                                httpGet2 = httpGet3;
                                                File file6 = file4;
                                                int i48 = i39;
                                                bVar2 = bVar;
                                                InputStream inputStream3 = inputStream;
                                                if (j3 == contentLength) {
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("HttpDownloadUtil", 2, "download success,info.url=" + downloadInfo.reqUrl);
                                                        }
                                                        j16 = j18;
                                                        i19 = 0;
                                                    } catch (IOException e38) {
                                                        e = e38;
                                                        fileOutputStream = fileOutputStream2;
                                                        inputStream = inputStream3;
                                                        i36 = i48;
                                                        i19 = 0;
                                                        file = file6;
                                                        if (!(e instanceof ConnectTimeoutException) && !(e instanceof SocketTimeoutException)) {
                                                            if (!(e instanceof SocketException)) {
                                                                i26 = 11;
                                                                i16 = i26;
                                                                if (inputStream != null) {
                                                                    try {
                                                                        inputStream.close();
                                                                    } catch (IOException e39) {
                                                                        e = e39;
                                                                        i37 = i16;
                                                                        httpEntity2 = httpEntity;
                                                                        i16 = handleIOException(downloadInfo, bVar2, url, i37, e);
                                                                        if (httpEntity2 != null) {
                                                                        }
                                                                        if (fileOutputStream != null) {
                                                                        }
                                                                        i17 = i29 + 1;
                                                                        if (QLog.isColorLevel()) {
                                                                        }
                                                                        if (i17 < i18) {
                                                                        }
                                                                        if (i16 != 0) {
                                                                        }
                                                                        return i16;
                                                                    }
                                                                }
                                                                if (i16 == 0) {
                                                                }
                                                                if (bVar2 != null) {
                                                                }
                                                                if (httpEntity != null) {
                                                                }
                                                                if (fileOutputStream != null) {
                                                                }
                                                                httpEntity2 = httpEntity;
                                                                i17 = i29 + 1;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                if (i17 < i18) {
                                                                }
                                                                if (i16 != 0) {
                                                                }
                                                                return i16;
                                                            }
                                                            i16 = 4;
                                                            if (inputStream != null) {
                                                            }
                                                            if (i16 == 0) {
                                                            }
                                                            if (bVar2 != null) {
                                                            }
                                                            if (httpEntity != null) {
                                                            }
                                                            if (fileOutputStream != null) {
                                                            }
                                                            httpEntity2 = httpEntity;
                                                            i17 = i29 + 1;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (i17 < i18) {
                                                            }
                                                            if (i16 != 0) {
                                                            }
                                                            return i16;
                                                        }
                                                        i26 = 3;
                                                        i16 = i26;
                                                        if (inputStream != null) {
                                                        }
                                                        if (i16 == 0) {
                                                        }
                                                        if (bVar2 != null) {
                                                        }
                                                        if (httpEntity != null) {
                                                        }
                                                        if (fileOutputStream != null) {
                                                        }
                                                        httpEntity2 = httpEntity;
                                                        i17 = i29 + 1;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (i17 < i18) {
                                                        }
                                                        if (i16 != 0) {
                                                        }
                                                        return i16;
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        fileOutputStream = fileOutputStream2;
                                                        inputStream = inputStream3;
                                                        i36 = i48;
                                                        i19 = 0;
                                                        file = file6;
                                                        if (inputStream != null) {
                                                        }
                                                        throw th;
                                                        break;
                                                        break;
                                                    }
                                                } else {
                                                    i19 = 8;
                                                    if (QLog.isColorLevel()) {
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("download data is lossy,read=");
                                                        sb5.append(i46);
                                                        sb5.append(" contentLen=");
                                                        j16 = j18;
                                                        sb5.append(j16);
                                                        sb5.append(" info.url=");
                                                        sb5.append(downloadInfo.reqUrl);
                                                        QLog.d("HttpDownloadUtil", 2, sb5.toString());
                                                    } else {
                                                        j16 = j18;
                                                    }
                                                    if (file6.exists()) {
                                                        file6.delete();
                                                    }
                                                }
                                                try {
                                                    if (QLog.isColorLevel()) {
                                                        try {
                                                            QLog.d("TAG", 2, "download resource done.time:" + System.currentTimeMillis() + " url=" + downloadInfo.reqUrl);
                                                        } catch (IOException e46) {
                                                            e = e46;
                                                            fileOutputStream = fileOutputStream2;
                                                            inputStream = inputStream3;
                                                            i36 = i48;
                                                            file = file6;
                                                            if (!(e instanceof ConnectTimeoutException)) {
                                                            }
                                                            i26 = 3;
                                                            i16 = i26;
                                                            if (inputStream != null) {
                                                            }
                                                            if (i16 == 0) {
                                                            }
                                                            if (bVar2 != null) {
                                                            }
                                                            if (httpEntity != null) {
                                                            }
                                                            if (fileOutputStream != null) {
                                                            }
                                                            httpEntity2 = httpEntity;
                                                            i17 = i29 + 1;
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            if (i17 < i18) {
                                                            }
                                                            if (i16 != 0) {
                                                            }
                                                            return i16;
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                            fileOutputStream = fileOutputStream2;
                                                            inputStream = inputStream3;
                                                            i36 = i48;
                                                            file = file6;
                                                            if (inputStream != null) {
                                                            }
                                                            throw th;
                                                            break;
                                                            break;
                                                        }
                                                    }
                                                    handleTags(downloadInfo, networkInfo);
                                                    file = file6;
                                                    try {
                                                        file.setLastModified(System.currentTimeMillis());
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("HttpDownloadUtil", 2, "Download success. cost " + (System.currentTimeMillis() - currentTimeMillis) + ", contentLen is " + j16 + " for " + downloadInfo.reqUrl);
                                                        }
                                                        if (inputStream3 != null) {
                                                            try {
                                                                inputStream3.close();
                                                            } catch (IOException e47) {
                                                                e = e47;
                                                                fileOutputStream = fileOutputStream2;
                                                                httpEntity2 = httpEntity;
                                                                i36 = i48;
                                                                i37 = i19;
                                                                i16 = handleIOException(downloadInfo, bVar2, url, i37, e);
                                                                if (httpEntity2 != null) {
                                                                }
                                                                if (fileOutputStream != null) {
                                                                }
                                                                i17 = i29 + 1;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                if (i17 < i18) {
                                                                }
                                                                if (i16 != 0) {
                                                                }
                                                                return i16;
                                                            } catch (Exception e48) {
                                                                e = e48;
                                                                fileOutputStream = fileOutputStream2;
                                                                httpEntity2 = httpEntity;
                                                                i36 = i48;
                                                                e.printStackTrace();
                                                                if (bVar2 != null) {
                                                                }
                                                                if (httpEntity2 != null) {
                                                                }
                                                                if (fileOutputStream != null) {
                                                                }
                                                                i16 = 5;
                                                                i17 = i29 + 1;
                                                                if (QLog.isColorLevel()) {
                                                                }
                                                                if (i17 < i18) {
                                                                }
                                                                if (i16 != 0) {
                                                                }
                                                                return i16;
                                                            } catch (Throwable th14) {
                                                                th5 = th14;
                                                                fileOutputStream = fileOutputStream2;
                                                                httpEntity2 = httpEntity;
                                                                if (httpEntity2 != null) {
                                                                }
                                                                if (fileOutputStream == null) {
                                                                }
                                                            }
                                                        }
                                                        i16 = i19;
                                                        fileOutputStream = fileOutputStream2;
                                                        i36 = i48;
                                                    } catch (IOException e49) {
                                                        e = e49;
                                                        fileOutputStream = fileOutputStream2;
                                                        inputStream = inputStream3;
                                                        i36 = i48;
                                                        if (!(e instanceof ConnectTimeoutException)) {
                                                        }
                                                        i26 = 3;
                                                        i16 = i26;
                                                        if (inputStream != null) {
                                                        }
                                                        if (i16 == 0) {
                                                        }
                                                        if (bVar2 != null) {
                                                        }
                                                        if (httpEntity != null) {
                                                        }
                                                        if (fileOutputStream != null) {
                                                        }
                                                        httpEntity2 = httpEntity;
                                                        i17 = i29 + 1;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        if (i17 < i18) {
                                                        }
                                                        if (i16 != 0) {
                                                        }
                                                        return i16;
                                                    } catch (Throwable th15) {
                                                        th = th15;
                                                        fileOutputStream = fileOutputStream2;
                                                        inputStream = inputStream3;
                                                        i36 = i48;
                                                        if (inputStream != null) {
                                                        }
                                                        throw th;
                                                        break;
                                                        break;
                                                    }
                                                } catch (IOException e56) {
                                                    e = e56;
                                                    file = file6;
                                                } catch (Throwable th16) {
                                                    th = th16;
                                                    file = file6;
                                                }
                                            } catch (IOException e57) {
                                                e = e57;
                                                bVar2 = bVar;
                                                int i49 = i38;
                                                basicHttpParams = basicHttpParams2;
                                                httpEntity = entity;
                                                httpGet2 = httpGet3;
                                                file = file3;
                                                fileOutputStream = fileOutputStream2;
                                                i36 = i49;
                                            } catch (Throwable th17) {
                                                th = th17;
                                                bVar2 = bVar;
                                                int i56 = i38;
                                                basicHttpParams = basicHttpParams2;
                                                httpEntity = entity;
                                                httpGet2 = httpGet3;
                                                file = file3;
                                                fileOutputStream = fileOutputStream2;
                                                i36 = i56;
                                            }
                                        } catch (IOException e58) {
                                            e = e58;
                                            bVar2 = bVar;
                                            basicHttpParams = basicHttpParams2;
                                            httpEntity = entity;
                                            httpGet2 = httpGet3;
                                            file = file3;
                                            fileOutputStream = fileOutputStream2;
                                            inputStream = null;
                                            i19 = 5;
                                            if (!(e instanceof ConnectTimeoutException)) {
                                                if (!(e instanceof SocketException)) {
                                                }
                                            }
                                            i26 = 3;
                                            i16 = i26;
                                            if (inputStream != null) {
                                            }
                                            if (i16 == 0) {
                                            }
                                            if (bVar2 != null) {
                                            }
                                            if (httpEntity != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            httpEntity2 = httpEntity;
                                            i17 = i29 + 1;
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (i17 < i18) {
                                            }
                                            if (i16 != 0) {
                                            }
                                            return i16;
                                        } catch (Throwable th18) {
                                            th = th18;
                                            bVar2 = bVar;
                                            basicHttpParams = basicHttpParams2;
                                            httpEntity = entity;
                                            httpGet2 = httpGet3;
                                            file = file3;
                                            fileOutputStream = fileOutputStream2;
                                            inputStream = null;
                                            i19 = 5;
                                            if (inputStream != null) {
                                            }
                                            throw th;
                                            break;
                                            break;
                                        }
                                    } catch (IOException e59) {
                                        e = e59;
                                        bVar2 = bVar;
                                        basicHttpParams = basicHttpParams2;
                                        httpEntity = entity;
                                        httpGet2 = httpGet3;
                                        file = file3;
                                    } catch (Throwable th19) {
                                        th = th19;
                                        bVar2 = bVar;
                                        basicHttpParams = basicHttpParams2;
                                        httpEntity = entity;
                                        httpGet2 = httpGet3;
                                        file = file3;
                                    }
                                    if (i16 == 0) {
                                        file.renameTo(downloadInfo.file);
                                    }
                                    if (bVar2 != null) {
                                        bVar2.c(url.toString(), i16);
                                    }
                                } catch (IOException e65) {
                                    e = e65;
                                    bVar2 = bVar;
                                    basicHttpParams = basicHttpParams2;
                                    httpGet2 = httpGet3;
                                    file = file3;
                                    httpEntity2 = entity;
                                    i37 = 5;
                                    i16 = handleIOException(downloadInfo, bVar2, url, i37, e);
                                    if (httpEntity2 != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    i17 = i29 + 1;
                                    if (QLog.isColorLevel()) {
                                    }
                                    if (i17 < i18) {
                                    }
                                    if (i16 != 0) {
                                    }
                                    return i16;
                                } catch (Exception e66) {
                                    e = e66;
                                    bVar2 = bVar;
                                    basicHttpParams = basicHttpParams2;
                                    httpEntity = entity;
                                    httpGet2 = httpGet3;
                                    file = file3;
                                } catch (Throwable th20) {
                                    th = th20;
                                    httpEntity = entity;
                                }
                            } else {
                                basicHttpParams = basicHttpParams2;
                                httpEntity = entity;
                                httpGet2 = httpGet3;
                                file = file3;
                                if (bVar2 != null) {
                                    try {
                                        bVar2.c(url.toString(), i37);
                                    } catch (IOException e67) {
                                        e = e67;
                                        httpEntity2 = httpEntity;
                                        i16 = handleIOException(downloadInfo, bVar2, url, i37, e);
                                        if (httpEntity2 != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        i17 = i29 + 1;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (i17 < i18) {
                                        }
                                        if (i16 != 0) {
                                        }
                                        return i16;
                                    }
                                }
                                i16 = i37;
                            }
                            if (httpEntity != null) {
                                try {
                                    httpEntity.consumeContent();
                                } catch (IOException e68) {
                                    e68.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            httpEntity2 = httpEntity;
                        } catch (Throwable th21) {
                            th5 = th21;
                        }
                    } catch (IOException e69) {
                        e = e69;
                        basicHttpParams = basicHttpParams2;
                        httpGet2 = httpGet3;
                        file = file3;
                    }
                } catch (Exception e75) {
                    e = e75;
                    basicHttpParams = basicHttpParams2;
                    httpGet2 = httpGet3;
                    file = file3;
                }
                i17 = i29 + 1;
                if (QLog.isColorLevel()) {
                    i18 = 2;
                    QLog.d("HttpDownloadUtil", 2, "Download. result=" + i16 + ", url=" + downloadInfo.reqUrl);
                } else {
                    i18 = 2;
                }
                if (i17 < i18 && i16 != 0) {
                    synchronized (obj) {
                        try {
                            obj.wait(5000L);
                        } catch (InterruptedException unused7) {
                        }
                    }
                }
                if (i16 != 0 || i17 >= 2) {
                    break;
                }
                i29 = i17;
                file3 = file;
                httpGet3 = httpGet2;
                basicHttpParams2 = basicHttpParams;
            }
        } catch (MalformedURLException e76) {
            e76.printStackTrace();
            downloadInfo.errorDetail = String.valueOf(e76);
            return 5;
        }
    }
}
