package com.tencent.luggage.wxa.rg;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.qg.k;
import com.tencent.luggage.wxa.qg.l;
import com.tencent.luggage.wxa.tg.m;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.oskplayer.report.VideoResultCode;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: o, reason: collision with root package name */
    public static AtomicInteger f139680o = new AtomicInteger(10000);

    /* renamed from: p, reason: collision with root package name */
    public static AtomicInteger f139681p = new AtomicInteger(10000);

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.pg.a f139684c;

    /* renamed from: d, reason: collision with root package name */
    public int f139685d;

    /* renamed from: e, reason: collision with root package name */
    public ServerSocket f139686e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f139687f;

    /* renamed from: g, reason: collision with root package name */
    public Thread f139688g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorService f139689h;

    /* renamed from: i, reason: collision with root package name */
    public final n f139690i;

    /* renamed from: a, reason: collision with root package name */
    public int f139682a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f139683b = true;

    /* renamed from: j, reason: collision with root package name */
    public Map f139691j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap f139692k = new ConcurrentHashMap(8, 0.75f, 2);

    /* renamed from: l, reason: collision with root package name */
    public Map f139693l = new ConcurrentHashMap();

    /* renamed from: m, reason: collision with root package name */
    public Map f139694m = new ConcurrentHashMap();

    /* renamed from: n, reason: collision with root package name */
    public Map f139695n = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f139696a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f139697b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.pg.h f139698c;

        public a(String str, long j3, com.tencent.luggage.wxa.pg.h hVar) {
            this.f139696a = str;
            this.f139697b = j3;
            this.f139698c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                j3 = com.tencent.luggage.wxa.tg.h.b(this.f139696a);
            } catch (OutOfMemoryError unused) {
                com.tencent.luggage.wxa.tg.h.a(5, "VideoProxy", "initCache, calculate cacheSize OOM usedSpace set to 0");
                j3 = 0;
            }
            long min = Math.min(this.f139697b + j3, com.tencent.luggage.wxa.og.a.a().e());
            this.f139698c.a(min);
            com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", "initCache, update cacheSize=" + min + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.qg.k {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.qg.k, com.tencent.luggage.wxa.qg.e
        public com.tencent.luggage.wxa.rg.b getFileType() {
            return com.tencent.luggage.wxa.rg.b.d(com.tencent.luggage.wxa.tg.c.f141295g);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Socket f139706a;

        /* renamed from: b, reason: collision with root package name */
        public Future f139707b;

        /* renamed from: c, reason: collision with root package name */
        public CountDownLatch f139708c;

        /* renamed from: d, reason: collision with root package name */
        public l f139709d;

        public d(Socket socket, CountDownLatch countDownLatch) {
            this.f139706a = socket;
            this.f139708c = countDownLatch;
        }

        public void a(Future future) {
            this.f139707b = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f139708c.await();
            } catch (InterruptedException e16) {
                com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "SocketHandler run exception, reason " + com.tencent.luggage.wxa.tg.h.a((Throwable) e16));
            }
            l lVar = new l();
            this.f139709d = lVar;
            lVar.a(this.f139707b);
            k.this.a(this.f139706a, this.f139709d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public CountDownLatch f139711a;

        public e(CountDownLatch countDownLatch) {
            this.f139711a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f139711a.countDown();
            k.this.e();
        }
    }

    public k() {
        c();
        this.f139690i = new n();
        this.f139689h = new m.b(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        d();
    }

    public String b() {
        return "http://127.0.0.1:" + this.f139685d;
    }

    public final void c() {
        String c16 = com.tencent.luggage.wxa.og.a.a().c();
        com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", "initCache, cache dir:" + com.tencent.luggage.wxa.og.a.a().c());
        if (TextUtils.isEmpty(c16)) {
            this.f139684c = null;
            com.tencent.luggage.wxa.og.a.a().m().a(-1);
            com.tencent.luggage.wxa.og.a.a().k().a(-1);
        } else {
            long min = Math.min(com.tencent.luggage.wxa.tg.h.a(c16), com.tencent.luggage.wxa.og.a.a().e());
            com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", "initCache, cache availableSpace=" + min);
            com.tencent.luggage.wxa.pg.h hVar = new com.tencent.luggage.wxa.pg.h(min);
            com.tencent.luggage.wxa.tg.m.a(new a(c16, min, hVar), "VideoProxy");
            this.f139684c = new com.tencent.luggage.wxa.pg.i(new v(c16), hVar);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initCache, cache:");
        Object obj = this.f139684c;
        if (obj == null) {
            obj = "null";
        }
        sb5.append(obj);
        com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", sb5.toString());
    }

    public final void d() {
        try {
            ServerSocket serverSocket = new ServerSocket(com.tencent.luggage.wxa.tg.h.a(5), 10, InetAddress.getByName("0.0.0.0"));
            this.f139686e = serverSocket;
            this.f139685d = serverSocket.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            BaseThread baseThread = new BaseThread(new e(countDownLatch), "video_proxy_wait_for_connection_thread");
            this.f139688g = baseThread;
            baseThread.start();
            countDownLatch.await();
            com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", "proxy server start success, port:" + this.f139685d);
            com.tencent.luggage.wxa.og.a.a().m().a(0);
            com.tencent.luggage.wxa.og.a.a().k().a(0);
        } catch (IOException | IllegalStateException | InterruptedException e16) {
            this.f139689h.shutdown();
            com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "proxy server start failed " + com.tencent.luggage.wxa.tg.h.a(e16));
            com.tencent.luggage.wxa.og.a.a().m().a(-2);
            com.tencent.luggage.wxa.og.a.a().k().a(-2);
        }
    }

    public final void e() {
        com.tencent.luggage.wxa.tg.h.a(3, "VideoProxy", "proxy server wait for request");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                try {
                    Socket accept = this.f139686e.accept();
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    d dVar = new d(accept, countDownLatch);
                    Future<?> submit = this.f139689h.submit(dVar);
                    ((ThreadPoolExecutor) this.f139689h).setCorePoolSize(((m.b) this.f139689h).a() + 2);
                    dVar.a(submit);
                    countDownLatch.countDown();
                } catch (IOException e16) {
                    com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "proxy server is quit, reason IO:" + com.tencent.luggage.wxa.tg.h.a((Throwable) e16));
                    return;
                } catch (OutOfMemoryError e17) {
                    com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "proxy server is quit, reason OOM:" + com.tencent.luggage.wxa.tg.h.a((Throwable) e17));
                    return;
                } catch (SocketException e18) {
                    if (this.f139686e.isClosed()) {
                        com.tencent.luggage.wxa.tg.h.a(3, "VideoProxy", "proxy server is closed");
                    } else {
                        com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "proxy server is quit, reason SOCKET:" + com.tencent.luggage.wxa.tg.h.a((Throwable) e18));
                    }
                }
            } finally {
                com.tencent.luggage.wxa.tg.h.a(3, "VideoProxy", "shutdown thread pool");
                this.f139689h.shutdownNow();
                com.tencent.luggage.wxa.tg.h.a(3, "VideoProxy", "proxy server stopped");
            }
        }
    }

    public String b(String str) {
        return a(str, true, true, "video/mp4", 90);
    }

    public final void a(Socket socket, l lVar) {
        String str;
        long j3;
        String str2 = VideoProxy.LOG_TAG_PREFIX + lVar.m();
        String str3 = str2 + "/";
        com.tencent.luggage.wxa.tg.h.a(3, str2, "process socket start");
        try {
            InputStream inputStream = socket.getInputStream();
            if (inputStream == null) {
                com.tencent.luggage.wxa.tg.h.a(6, str2, "socket inputstream is null");
                return;
            }
            com.tencent.luggage.wxa.tg.f fVar = new com.tencent.luggage.wxa.tg.f(inputStream, str3);
            String c16 = fVar.c();
            String a16 = fVar.a("url");
            String a17 = fVar.a("priority");
            String a18 = fVar.a("id");
            String a19 = fVar.a("secret");
            String a26 = fVar.a(VideoProxy.PARAM_ENABLE_CACHE);
            String a27 = fVar.a("contentType");
            if (a16 == null) {
                com.tencent.luggage.wxa.tg.h.a(6, str2, "invalid request detected, sourceUrl is null");
                return;
            }
            if (this.f139683b) {
                if (a19 == null) {
                    com.tencent.luggage.wxa.tg.h.a(6, str2, "invalid request detected, token is null");
                    return;
                }
                try {
                    String a28 = com.tencent.luggage.wxa.tg.l.a(SecretUtils.DES, com.tencent.luggage.wxa.tg.l.b(), a19);
                    String h16 = com.tencent.luggage.wxa.tg.h.h(a16);
                    if (a28 == null || !a28.equals(h16)) {
                        com.tencent.luggage.wxa.tg.h.a(6, str2, "invalid request detected, key is illegal");
                        return;
                    }
                } catch (Throwable unused) {
                    com.tencent.luggage.wxa.tg.h.a(5, str2, "decode token error");
                    return;
                }
            }
            String b16 = fVar.b();
            com.tencent.luggage.wxa.tg.h.a(4, str2, com.tencent.luggage.wxa.tg.h.c("requestHeader:" + b16, null));
            OutputStream outputStream = socket.getOutputStream();
            if (outputStream == null) {
                com.tencent.luggage.wxa.tg.h.a(6, str2, "socket outputstream is null");
                return;
            }
            long[] b17 = com.tencent.luggage.wxa.tg.f.b(b16);
            lVar.c(c16);
            lVar.d(a16);
            lVar.b(b17[0]);
            lVar.a(b17[1]);
            lVar.e(a18);
            lVar.b(a27);
            lVar.a(str3);
            if (!TextUtils.isEmpty(a26) && a26.equals("1")) {
                lVar.b(true);
            } else {
                lVar.b(false);
            }
            if (TextUtils.isEmpty(a17)) {
                lVar.d(-1);
            } else if (a17.equals(String.valueOf(90))) {
                lVar.d(90);
            } else if (a17.equals(String.valueOf(10))) {
                lVar.d(10);
            } else {
                lVar.d(-1);
            }
            if (lVar.i() == -1) {
                com.tencent.luggage.wxa.tg.h.a(5, str2, "videoRequest priority is not specified");
            }
            com.tencent.luggage.wxa.tg.h.a(4, str2, "processSocket, videoRequest=" + lVar);
            if (lVar.i() == 90) {
                this.f139690i.b(lVar.r(), lVar);
            }
            this.f139690i.a(a16, lVar);
            a(socket, a16, outputStream, lVar, inputStream);
        } catch (Exception e16) {
            this.f139682a++;
            com.tencent.luggage.wxa.tg.h.a(5, str2, "processSocket, proxyExceptionCount=" + this.f139682a);
            if (e16 instanceof com.tencent.luggage.wxa.qg.m) {
                str = "IllegalDataSpecException";
                j3 = -99799;
            } else if (e16 instanceof ArrayIndexOutOfBoundsException) {
                str = "ArrayIndexOutOfBoundsException";
                j3 = -99699;
            } else {
                str = "";
                j3 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
            }
            long b18 = com.tencent.luggage.wxa.tg.h.b(4L, j3);
            com.tencent.luggage.wxa.og.a.a().m().a(lVar.q(), lVar.n(), lVar.i(), lVar.k(), lVar.j(), lVar.p(), lVar.d(), lVar.l(), lVar.f(), b18, j3, com.tencent.luggage.wxa.tg.h.a(b18, j3), str, (int) (System.currentTimeMillis() - lVar.o()));
            com.tencent.luggage.wxa.tg.h.a(6, str2, "processSocket, unexpected proxy error " + e16.getMessage() + com.tencent.luggage.wxa.tg.h.a((Throwable) e16), e16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public long f139701a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f139702b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.qg.e f139703c;

        /* renamed from: d, reason: collision with root package name */
        public v f139704d;

        public c() {
            this.f139701a = -1L;
            this.f139702b = false;
            this.f139703c = null;
            this.f139704d = null;
        }

        public /* synthetic */ c(k kVar, a aVar) {
            this();
        }
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str) || this.f139684c == null) {
            return false;
        }
        return this.f139684c.a(com.tencent.luggage.wxa.tg.h.h(str));
    }

    public com.tencent.luggage.wxa.pg.a a() {
        return this.f139684c;
    }

    public String a(String str, boolean z16, boolean z17, String str2, int i3) {
        String str3;
        String str4;
        if (com.tencent.luggage.wxa.og.a.a().r() && this.f139682a <= 3 && !this.f139689h.isShutdown() && !this.f139689h.isTerminated()) {
            if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
                String i16 = com.tencent.luggage.wxa.tg.h.i(str);
                if (com.tencent.luggage.wxa.tg.h.c(i16)) {
                    str = i16;
                } else if (!com.tencent.luggage.wxa.tg.h.e(i16)) {
                    return i16;
                }
                z17 = false;
            }
            if (com.tencent.luggage.wxa.mg.n.a(str)) {
                if (!com.tencent.luggage.wxa.og.a.a().q()) {
                    com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", "getUrl, hls proxy disabled");
                    return str;
                }
                str2 = VideoProxy.VALUE_CONTENT_TYPE_VIDEO_M3U8;
                z17 = false;
            }
            try {
                str3 = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "invalid url " + com.tencent.luggage.wxa.tg.h.a((Throwable) e16));
                str3 = "";
            }
            if (TextUtils.isEmpty(str3)) {
                com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "url is empty " + str3);
                return str;
            }
            String str5 = b() + "/" + Uri.parse(str).getLastPathSegment() + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "url" + ContainerUtils.KEY_VALUE_DELIMITER + str3;
            if (z17) {
                str5 = str5 + "&enableCache=1";
            }
            if (i3 == 90 || i3 == 10 || i3 == -1) {
                str5 = str5 + "&priority=" + i3;
            }
            String str6 = null;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    str4 = URLEncoder.encode(str2, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "unable to encode contentType " + str2);
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4)) {
                    str5 = str5 + "&contentType=" + str4;
                }
            }
            if (z16) {
                str6 = System.currentTimeMillis() + "" + f139680o.getAndIncrement();
            }
            if (str6 != null) {
                str5 = str5 + "&id=" + str6;
            }
            if (this.f139683b) {
                try {
                    str5 = str5 + "&secret=" + com.tencent.luggage.wxa.tg.l.b(SecretUtils.DES, com.tencent.luggage.wxa.tg.l.b(), com.tencent.luggage.wxa.tg.h.h(str));
                } catch (Exception e17) {
                    com.tencent.luggage.wxa.tg.h.a(6, "VideoProxy", "encode failed:" + com.tencent.luggage.wxa.tg.h.a((Throwable) e17));
                    this.f139683b = false;
                }
            }
            com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", "getUrl, url:" + str + ", proxyUrl:" + str5);
            return str5;
        }
        com.tencent.luggage.wxa.tg.h.a(4, "VideoProxy", "getUrl, proxy disabled or server shutdown");
        com.tencent.luggage.wxa.og.a.a().k().a();
        return com.tencent.luggage.wxa.tg.h.i(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:441:0x05da, code lost:
    
        r44 = r1;
        r34 = r2;
        r9 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0ab4  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0a96 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0a78 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0934 A[Catch: all -> 0x09c4, TRY_LEAVE, TryCatch #22 {all -> 0x09c4, blocks: (B:129:0x092e, B:131:0x0934), top: B:128:0x092e }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x09a3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01e6 A[Catch: all -> 0x01d0, Exception -> 0x01d3, e -> 0x01d6, TRY_ENTER, TRY_LEAVE, TryCatch #45 {e -> 0x01d6, Exception -> 0x01d3, all -> 0x01d0, blocks: (B:173:0x0157, B:178:0x01ae, B:179:0x01c0, B:183:0x01e6, B:187:0x0200, B:190:0x0211, B:193:0x0222, B:195:0x0233), top: B:172:0x0157 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0200 A[Catch: all -> 0x01d0, Exception -> 0x01d3, e -> 0x01d6, TRY_ENTER, TRY_LEAVE, TryCatch #45 {e -> 0x01d6, Exception -> 0x01d3, all -> 0x01d0, blocks: (B:173:0x0157, B:178:0x01ae, B:179:0x01c0, B:183:0x01e6, B:187:0x0200, B:190:0x0211, B:193:0x0222, B:195:0x0233), top: B:172:0x0157 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0211 A[Catch: all -> 0x01d0, Exception -> 0x01d3, e -> 0x01d6, TRY_ENTER, TRY_LEAVE, TryCatch #45 {e -> 0x01d6, Exception -> 0x01d3, all -> 0x01d0, blocks: (B:173:0x0157, B:178:0x01ae, B:179:0x01c0, B:183:0x01e6, B:187:0x0200, B:190:0x0211, B:193:0x0222, B:195:0x0233), top: B:172:0x0157 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x024d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x09e2 A[Catch: all -> 0x0a6e, TRY_LEAVE, TryCatch #48 {all -> 0x0a6e, blocks: (B:73:0x09dc, B:75:0x09e2), top: B:72:0x09dc }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0a4f A[Catch: all -> 0x0a69, TRY_ENTER, TryCatch #42 {all -> 0x0a69, blocks: (B:152:0x09a5, B:153:0x09c3, B:95:0x0a4f, B:96:0x0a68), top: B:16:0x00ce }] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v100 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v96 */
    /* JADX WARN: Type inference failed for: r3v99 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.luggage.wxa.cp.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v74 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final v a(com.tencent.luggage.wxa.qg.e eVar, com.tencent.luggage.wxa.qg.g gVar, String str, l lVar) {
        Throwable th5;
        BufferedReader bufferedReader;
        boolean z16;
        v vVar;
        String str2;
        String str3;
        String str4;
        ?? r36;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        ?? r37;
        String str12;
        String str13;
        String str14;
        String str15;
        int i3;
        Exception exc;
        OutputStream outputStream;
        String str16;
        String str17;
        String str18;
        int i16;
        com.tencent.luggage.wxa.rg.e eVar2;
        String str19;
        String str20;
        String str21;
        char c16;
        String str22;
        String str23;
        String str24;
        int i17;
        String str25;
        String str26;
        String str27;
        char c17;
        int i18;
        int i19;
        StringBuilder sb5;
        v vVar2;
        boolean z17;
        ArrayList arrayList;
        StringBuilder sb6;
        String str28;
        String str29;
        String str30;
        int i26;
        boolean z18;
        boolean z19;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String str43;
        String str44;
        String str45;
        String str46;
        int i27;
        String str47;
        String str48;
        String str49;
        String str50;
        int i28;
        String str51;
        StringBuilder sb7;
        String str52;
        Pattern pattern;
        int i29;
        String str53;
        Pattern pattern2;
        String str54;
        String str55;
        ArrayList arrayList4;
        String str56;
        int i36;
        ArrayList arrayList5;
        String str57 = str;
        l lVar2 = lVar;
        String str58 = "generateLocalPlaylistFile, finally deletePlayListFile ";
        String str59 = "generateLocalPlaylistFile, error close PlayListFile: ";
        String str60 = "generateLocalPlaylistFile, error close reader: ";
        String str61 = ", deleteSuccess:";
        String str62 = VideoProxy.LOG_TAG_PREFIX + lVar.m();
        String l3 = com.tencent.luggage.wxa.og.a.a().l();
        OutputStream outputStream2 = null;
        if (l3 == null) {
            com.tencent.luggage.wxa.tg.h.a(6, str62, "generateLocalPlaylistFile error: dirPath is null");
            return null;
        }
        v vVar3 = new v(l3);
        if (!vVar3.e()) {
            vVar3.w();
        }
        ?? vVar4 = new v(l3 + "/" + (System.currentTimeMillis() + f139681p.incrementAndGet()) + ".m3u8");
        ?? sb8 = new StringBuilder();
        sb8.append("generateLocalPlaylistFile:");
        sb8.append(vVar4);
        com.tencent.luggage.wxa.tg.h.a(4, str62, sb8.toString());
        boolean z26 = lVar.i() == 10;
        String q16 = lVar.q();
        ?? r65 = lVar.i() == 10 ? 1 : 3;
        com.tencent.luggage.wxa.tg.h.a(4, str62, "generateLocalPlaylistFile, preloadTsMaxCount=" + r65);
        lVar2.b(lVar.d() | 5);
        ?? compile = Pattern.compile("URI=\"(.+?)\"", 34);
        try {
            try {
                try {
                    eVar.a(gVar);
                    try {
                        boolean z27 = z26;
                        int i37 = r65;
                        BufferedReader bufferedReader2 = new BufferedReader(new com.tencent.luggage.wxa.qg.f(eVar, "UTF-8"));
                        try {
                            outputStream = x.b((v) vVar4);
                            try {
                                sb5 = new StringBuilder();
                                vVar2 = vVar4;
                            } catch (com.tencent.luggage.wxa.rg.e e16) {
                                e = e16;
                                bufferedReader = bufferedReader2;
                                vVar = vVar4;
                                str12 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                                str25 = "generateLocalPlaylistFile, error close PlayListFile: ";
                                str26 = "generateLocalPlaylistFile, error close reader: ";
                                str27 = ", deleteSuccess:";
                            } catch (Exception e17) {
                                e = e17;
                                bufferedReader = bufferedReader2;
                                vVar = vVar4;
                                str12 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                                str25 = "generateLocalPlaylistFile, error close PlayListFile: ";
                                str26 = "generateLocalPlaylistFile, error close reader: ";
                                str27 = ", deleteSuccess:";
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedReader = bufferedReader2;
                                vVar = vVar4;
                                str12 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                                str25 = "generateLocalPlaylistFile, error close PlayListFile: ";
                                str26 = "generateLocalPlaylistFile, error close reader: ";
                                str27 = ", deleteSuccess:";
                            }
                        } catch (com.tencent.luggage.wxa.rg.e e18) {
                            bufferedReader = bufferedReader2;
                            vVar = vVar4;
                            str12 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                            str22 = "generateLocalPlaylistFile, error close PlayListFile: ";
                            str23 = "generateLocalPlaylistFile, error close reader: ";
                            str24 = ", deleteSuccess:";
                            i17 = 6;
                            z16 = false;
                            eVar2 = e18;
                            outputStream = null;
                        } catch (Exception e19) {
                            bufferedReader = bufferedReader2;
                            vVar = vVar4;
                            str12 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                            str13 = "generateLocalPlaylistFile, error close PlayListFile: ";
                            str14 = "generateLocalPlaylistFile, error close reader: ";
                            str15 = ", deleteSuccess:";
                            i3 = 6;
                            z16 = false;
                            exc = e19;
                            outputStream = null;
                        } catch (Throwable th7) {
                            bufferedReader = bufferedReader2;
                            vVar = vVar4;
                            str12 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                            str19 = "generateLocalPlaylistFile, error close PlayListFile: ";
                            str20 = "generateLocalPlaylistFile, error close reader: ";
                            str21 = ", deleteSuccess:";
                            c16 = 6;
                            z16 = false;
                            th5 = th7;
                        }
                        try {
                            com.tencent.luggage.wxa.tg.h.a(4, str62, "====================== start original m3u8 content ======================");
                            ArrayList arrayList6 = null;
                            boolean z28 = true;
                            int i38 = -1;
                            int i39 = -1;
                            boolean z29 = false;
                            int i46 = 0;
                            String str63 = q16;
                            Pattern pattern3 = compile;
                            while (true) {
                                z17 = !Thread.interrupted();
                                if (!z17) {
                                    break;
                                }
                                try {
                                    if (!lVar.w()) {
                                        StringBuilder sb9 = sb5;
                                        String readLine = bufferedReader2.readLine();
                                        if (readLine == null) {
                                            sb6 = sb9;
                                            arrayList = arrayList6;
                                            bufferedReader = bufferedReader2;
                                            break;
                                        }
                                        com.tencent.luggage.wxa.tg.h.a(4, str62, readLine);
                                        str12 = str58;
                                        str30 = str61;
                                        str28 = str59;
                                        if (readLine.startsWith("#")) {
                                            try {
                                                arrayList2 = arrayList6;
                                            } catch (com.tencent.luggage.wxa.rg.e e26) {
                                                e = e26;
                                                bufferedReader = bufferedReader2;
                                            } catch (Exception e27) {
                                                e = e27;
                                                bufferedReader = bufferedReader2;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                bufferedReader = bufferedReader2;
                                            }
                                            try {
                                                if (readLine.toUpperCase().equals("#EXTM3U")) {
                                                    try {
                                                        if (!this.f139693l.containsKey(str63)) {
                                                            arrayList3 = new ArrayList();
                                                            bufferedReader = bufferedReader2;
                                                            try {
                                                                this.f139693l.put(str63, new f());
                                                                if (readLine.toUpperCase().startsWith("#EXT-X-STREAM-INF")) {
                                                                    if (!z29) {
                                                                        com.tencent.luggage.wxa.tg.h.a(4, str62, "find master play list");
                                                                        com.tencent.luggage.wxa.og.a.a().m().a();
                                                                    }
                                                                    lVar2.b(lVar.d() & (-5));
                                                                    z27 = true;
                                                                    z28 = false;
                                                                    z29 = true;
                                                                }
                                                                if (readLine.toUpperCase().startsWith("#EXT-X-ENDLIST")) {
                                                                    lVar2.b(lVar.d() & (-5));
                                                                    z27 = true;
                                                                    z28 = false;
                                                                }
                                                                if (readLine.toUpperCase().startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                                                                    i38 = com.tencent.luggage.wxa.tg.h.f(readLine);
                                                                }
                                                                if (readLine.toUpperCase().startsWith("#EXT-X-TARGETDURATION")) {
                                                                    i39 = com.tencent.luggage.wxa.tg.h.f(readLine);
                                                                }
                                                                if (readLine.toUpperCase().startsWith("#EXT-X-PLAYLIST-TYPE") && com.tencent.luggage.wxa.tg.h.g(readLine).toUpperCase().equals("VOD")) {
                                                                    lVar2.b(lVar.d() & (-5));
                                                                    z27 = true;
                                                                    z28 = false;
                                                                }
                                                                if (!readLine.toUpperCase().startsWith("#EXT-X-KEY")) {
                                                                    try {
                                                                        try {
                                                                            Matcher matcher = pattern3.matcher(readLine);
                                                                            if (matcher.matches() && matcher.groupCount() > 0) {
                                                                                try {
                                                                                    int start = matcher.start(1);
                                                                                    int end = matcher.end(1);
                                                                                    Pattern pattern4 = pattern3;
                                                                                    try {
                                                                                        String substring = readLine.substring(0, start);
                                                                                        String substring2 = readLine.substring(start, end);
                                                                                        String substring3 = readLine.substring(end);
                                                                                        str52 = str63;
                                                                                        pattern = pattern4;
                                                                                        vVar = vVar2;
                                                                                        sb7 = sb9;
                                                                                        str29 = str60;
                                                                                        i29 = i37;
                                                                                        str53 = readLine;
                                                                                        try {
                                                                                            String a16 = a(com.tencent.luggage.wxa.tg.h.a(str57, substring2), false, false, "application/octet-stream;charset=utf-8", 90);
                                                                                            if (lVar.q() != null) {
                                                                                                a16 = (a16 + "&id=" + lVar.q()) + "&enableCache=0";
                                                                                            }
                                                                                            sb7.append(substring);
                                                                                            sb7.append(a16);
                                                                                            sb7.append(substring3);
                                                                                            sb7.append("\n");
                                                                                        } catch (com.tencent.luggage.wxa.rg.e e28) {
                                                                                            eVar2 = e28;
                                                                                            str51 = str29;
                                                                                            str48 = str30;
                                                                                            str49 = str28;
                                                                                            i28 = 6;
                                                                                            z16 = false;
                                                                                            str50 = str51;
                                                                                            i17 = i28;
                                                                                            str23 = str50;
                                                                                            str22 = str49;
                                                                                            str24 = str48;
                                                                                            str57 = str12;
                                                                                            i3 = i17;
                                                                                            str14 = str23;
                                                                                            str13 = str22;
                                                                                            str15 = str24;
                                                                                            try {
                                                                                                if (lVar.w()) {
                                                                                                }
                                                                                            } catch (Throwable th9) {
                                                                                                th = th9;
                                                                                                th5 = th;
                                                                                                outputStream2 = outputStream;
                                                                                                r37 = i3;
                                                                                                str10 = str14;
                                                                                                str9 = str13;
                                                                                                str11 = str15;
                                                                                                boolean z36 = z16;
                                                                                                str8 = r37;
                                                                                                str7 = str10;
                                                                                                str6 = str9;
                                                                                                str5 = str11;
                                                                                                z16 = z36;
                                                                                                r36 = str8;
                                                                                                str4 = str7;
                                                                                                str3 = str6;
                                                                                                str2 = str5;
                                                                                                if (bufferedReader != null) {
                                                                                                }
                                                                                                if (outputStream2 != null) {
                                                                                                }
                                                                                                if (!z16) {
                                                                                                }
                                                                                            }
                                                                                        } catch (Exception e29) {
                                                                                            exc = e29;
                                                                                            str47 = str29;
                                                                                            str44 = str30;
                                                                                            str45 = str28;
                                                                                            i27 = 6;
                                                                                            z16 = false;
                                                                                            str46 = str47;
                                                                                            i3 = i27;
                                                                                            str14 = str46;
                                                                                            str13 = str45;
                                                                                            str15 = str44;
                                                                                            try {
                                                                                                if (!lVar.w()) {
                                                                                                }
                                                                                            } catch (Throwable th10) {
                                                                                                th = th10;
                                                                                                str57 = str12;
                                                                                                th5 = th;
                                                                                                outputStream2 = outputStream;
                                                                                                r37 = i3;
                                                                                                str10 = str14;
                                                                                                str9 = str13;
                                                                                                str11 = str15;
                                                                                                boolean z362 = z16;
                                                                                                str8 = r37;
                                                                                                str7 = str10;
                                                                                                str6 = str9;
                                                                                                str5 = str11;
                                                                                                z16 = z362;
                                                                                                r36 = str8;
                                                                                                str4 = str7;
                                                                                                str3 = str6;
                                                                                                str2 = str5;
                                                                                                if (bufferedReader != null) {
                                                                                                    try {
                                                                                                        bufferedReader.close();
                                                                                                    } catch (IOException e36) {
                                                                                                        com.tencent.luggage.wxa.tg.h.a((int) r36, str62, str4 + com.tencent.luggage.wxa.tg.h.a((Throwable) e36));
                                                                                                    }
                                                                                                }
                                                                                                if (outputStream2 != null) {
                                                                                                    try {
                                                                                                        outputStream2.close();
                                                                                                    } catch (IOException e37) {
                                                                                                        com.tencent.luggage.wxa.tg.h.a((int) r36, str62, str3 + com.tencent.luggage.wxa.tg.h.a((Throwable) e37));
                                                                                                    }
                                                                                                }
                                                                                                if (!z16) {
                                                                                                    if (!vVar.e()) {
                                                                                                        throw th5;
                                                                                                    }
                                                                                                    if (vVar.q()) {
                                                                                                        com.tencent.luggage.wxa.tg.h.a(4, str62, str57 + vVar.toString() + str2 + vVar.d());
                                                                                                        throw th5;
                                                                                                    }
                                                                                                    throw th5;
                                                                                                }
                                                                                                throw th5;
                                                                                            }
                                                                                        } catch (Throwable th11) {
                                                                                            th5 = th11;
                                                                                            outputStream2 = outputStream;
                                                                                            str43 = str29;
                                                                                            str21 = str30;
                                                                                            str19 = str28;
                                                                                            c16 = 6;
                                                                                            z16 = false;
                                                                                            str20 = str43;
                                                                                            str57 = str12;
                                                                                            r36 = c16;
                                                                                            str4 = str20;
                                                                                            str3 = str19;
                                                                                            str2 = str21;
                                                                                            if (bufferedReader != null) {
                                                                                            }
                                                                                            if (outputStream2 != null) {
                                                                                            }
                                                                                            if (!z16) {
                                                                                            }
                                                                                        }
                                                                                    } catch (com.tencent.luggage.wxa.rg.e e38) {
                                                                                        vVar = vVar2;
                                                                                        eVar2 = e38;
                                                                                        z16 = false;
                                                                                        str50 = str60;
                                                                                        str48 = str30;
                                                                                        str49 = str28;
                                                                                        i28 = 6;
                                                                                        i17 = i28;
                                                                                        str23 = str50;
                                                                                        str22 = str49;
                                                                                        str24 = str48;
                                                                                        str57 = str12;
                                                                                        i3 = i17;
                                                                                        str14 = str23;
                                                                                        str13 = str22;
                                                                                        str15 = str24;
                                                                                        if (lVar.w()) {
                                                                                        }
                                                                                    } catch (Exception e39) {
                                                                                        vVar = vVar2;
                                                                                        exc = e39;
                                                                                        z16 = false;
                                                                                        str46 = str60;
                                                                                        str44 = str30;
                                                                                        str45 = str28;
                                                                                        i27 = 6;
                                                                                        i3 = i27;
                                                                                        str14 = str46;
                                                                                        str13 = str45;
                                                                                        str15 = str44;
                                                                                        if (!lVar.w()) {
                                                                                        }
                                                                                    } catch (Throwable th12) {
                                                                                        vVar = vVar2;
                                                                                        th5 = th12;
                                                                                        outputStream2 = outputStream;
                                                                                        z16 = false;
                                                                                        str34 = str60;
                                                                                        str31 = str30;
                                                                                        str32 = str28;
                                                                                        str33 = str34;
                                                                                        c16 = 6;
                                                                                        str20 = str33;
                                                                                        str19 = str32;
                                                                                        str21 = str31;
                                                                                        str57 = str12;
                                                                                        r36 = c16;
                                                                                        str4 = str20;
                                                                                        str3 = str19;
                                                                                        str2 = str21;
                                                                                        if (bufferedReader != null) {
                                                                                        }
                                                                                        if (outputStream2 != null) {
                                                                                        }
                                                                                        if (!z16) {
                                                                                        }
                                                                                    }
                                                                                } catch (com.tencent.luggage.wxa.rg.e e46) {
                                                                                    vVar = vVar2;
                                                                                    eVar2 = e46;
                                                                                    str23 = str60;
                                                                                    str24 = str30;
                                                                                    str22 = str28;
                                                                                    i17 = 6;
                                                                                    z16 = false;
                                                                                    str57 = str12;
                                                                                    i3 = i17;
                                                                                    str14 = str23;
                                                                                    str13 = str22;
                                                                                    str15 = str24;
                                                                                    if (lVar.w()) {
                                                                                    }
                                                                                } catch (Exception e47) {
                                                                                    vVar = vVar2;
                                                                                    exc = e47;
                                                                                    str14 = str60;
                                                                                    str15 = str30;
                                                                                    str13 = str28;
                                                                                    i3 = 6;
                                                                                    z16 = false;
                                                                                    if (!lVar.w()) {
                                                                                        lVar.a();
                                                                                        if (bufferedReader != null) {
                                                                                            try {
                                                                                                bufferedReader.close();
                                                                                            } catch (IOException e48) {
                                                                                                com.tencent.luggage.wxa.tg.h.a(i3, str62, str14 + com.tencent.luggage.wxa.tg.h.a((Throwable) e48));
                                                                                            }
                                                                                        }
                                                                                        if (outputStream != null) {
                                                                                            try {
                                                                                                outputStream.close();
                                                                                            } catch (IOException e49) {
                                                                                                com.tencent.luggage.wxa.tg.h.a(i3, str62, str13 + com.tencent.luggage.wxa.tg.h.a((Throwable) e49));
                                                                                            }
                                                                                        }
                                                                                        if (vVar.e() && vVar.q()) {
                                                                                            com.tencent.luggage.wxa.tg.h.a(4, str62, str12 + vVar.toString() + str15 + vVar.d());
                                                                                        }
                                                                                        return null;
                                                                                    }
                                                                                    com.tencent.luggage.wxa.tg.h.a(i3, str62, "generateLocalPlaylistFile Exception:" + com.tencent.luggage.wxa.tg.h.a((Throwable) exc));
                                                                                    throw new com.tencent.luggage.wxa.rg.e(exc);
                                                                                }
                                                                            } else {
                                                                                sb7 = sb9;
                                                                                str52 = str63;
                                                                                pattern = pattern3;
                                                                                str29 = str60;
                                                                                i29 = i37;
                                                                                vVar = vVar2;
                                                                                str53 = readLine;
                                                                                sb7.append(str53);
                                                                                sb7.append("\n");
                                                                            }
                                                                            pattern2 = pattern;
                                                                            z16 = false;
                                                                            str54 = str52;
                                                                        } catch (com.tencent.luggage.wxa.rg.e e56) {
                                                                            vVar = vVar2;
                                                                            eVar2 = e56;
                                                                            str51 = str60;
                                                                        } catch (Exception e57) {
                                                                            vVar = vVar2;
                                                                            exc = e57;
                                                                            str47 = str60;
                                                                        }
                                                                    } catch (Throwable th13) {
                                                                        vVar = vVar2;
                                                                        th5 = th13;
                                                                        outputStream2 = outputStream;
                                                                        str43 = str60;
                                                                    }
                                                                } else {
                                                                    sb7 = sb9;
                                                                    String str64 = str63;
                                                                    Pattern pattern5 = pattern3;
                                                                    str29 = str60;
                                                                    i29 = i37;
                                                                    vVar = vVar2;
                                                                    str53 = readLine;
                                                                    try {
                                                                        try {
                                                                            if (str53.toUpperCase().startsWith("#EXT-X-MAP")) {
                                                                                Matcher matcher2 = pattern5.matcher(str53);
                                                                                if (matcher2.matches() && matcher2.groupCount() > 0) {
                                                                                    try {
                                                                                        int start2 = matcher2.start(1);
                                                                                        int end2 = matcher2.end(1);
                                                                                        try {
                                                                                            String substring4 = str53.substring(0, start2);
                                                                                            String substring5 = str53.substring(start2, end2);
                                                                                            String substring6 = str53.substring(end2);
                                                                                            z16 = false;
                                                                                            pattern2 = pattern5;
                                                                                            String a17 = a(com.tencent.luggage.wxa.tg.h.a(str57, substring5), false, false, VideoProxy.VALUE_CONTENT_TYPE_VIDEO_MPEG_TS, 90);
                                                                                            if (lVar.q() != null) {
                                                                                                a17 = (a17 + "&id=" + lVar.q()) + "&enableCache=[VALUE_CACHE_PLACEHOLDER]";
                                                                                            }
                                                                                            sb7.append(substring4);
                                                                                            sb7.append(a17);
                                                                                            sb7.append(substring6);
                                                                                            sb7.append("\n");
                                                                                            str54 = str64;
                                                                                        } catch (com.tencent.luggage.wxa.rg.e e58) {
                                                                                            e = e58;
                                                                                            z16 = false;
                                                                                            eVar2 = e;
                                                                                            str42 = str29;
                                                                                            str39 = str30;
                                                                                            str40 = str28;
                                                                                            str41 = str42;
                                                                                            i17 = 6;
                                                                                            str23 = str41;
                                                                                            str22 = str40;
                                                                                            str24 = str39;
                                                                                            str57 = str12;
                                                                                            i3 = i17;
                                                                                            str14 = str23;
                                                                                            str13 = str22;
                                                                                            str15 = str24;
                                                                                            if (lVar.w()) {
                                                                                            }
                                                                                        } catch (Exception e59) {
                                                                                            e = e59;
                                                                                            z16 = false;
                                                                                            exc = e;
                                                                                            str38 = str29;
                                                                                            str35 = str30;
                                                                                            str36 = str28;
                                                                                            str37 = str38;
                                                                                            i3 = 6;
                                                                                            str14 = str37;
                                                                                            str13 = str36;
                                                                                            str15 = str35;
                                                                                            if (!lVar.w()) {
                                                                                            }
                                                                                        } catch (Throwable th14) {
                                                                                            th = th14;
                                                                                            z16 = false;
                                                                                            th5 = th;
                                                                                            outputStream2 = outputStream;
                                                                                            str34 = str29;
                                                                                            str31 = str30;
                                                                                            str32 = str28;
                                                                                            str33 = str34;
                                                                                            c16 = 6;
                                                                                            str20 = str33;
                                                                                            str19 = str32;
                                                                                            str21 = str31;
                                                                                            str57 = str12;
                                                                                            r36 = c16;
                                                                                            str4 = str20;
                                                                                            str3 = str19;
                                                                                            str2 = str21;
                                                                                            if (bufferedReader != null) {
                                                                                            }
                                                                                            if (outputStream2 != null) {
                                                                                            }
                                                                                            if (!z16) {
                                                                                            }
                                                                                        }
                                                                                    } catch (com.tencent.luggage.wxa.rg.e e65) {
                                                                                        e = e65;
                                                                                        z16 = false;
                                                                                    } catch (Exception e66) {
                                                                                        e = e66;
                                                                                        z16 = false;
                                                                                    }
                                                                                } else {
                                                                                    pattern2 = pattern5;
                                                                                    z16 = false;
                                                                                    sb7.append(str53);
                                                                                    sb7.append("\n");
                                                                                    str54 = str64;
                                                                                }
                                                                            } else {
                                                                                pattern2 = pattern5;
                                                                                z16 = false;
                                                                                sb7.append(str53);
                                                                                sb7.append("\n");
                                                                                str54 = str64;
                                                                            }
                                                                        } catch (com.tencent.luggage.wxa.rg.e e67) {
                                                                            e = e67;
                                                                            z16 = false;
                                                                        } catch (Exception e68) {
                                                                            e = e68;
                                                                            z16 = false;
                                                                        }
                                                                    } catch (Throwable th15) {
                                                                        th = th15;
                                                                        z16 = false;
                                                                    }
                                                                }
                                                                str55 = null;
                                                                arrayList4 = arrayList3;
                                                                str56 = str54;
                                                            } catch (com.tencent.luggage.wxa.rg.e e69) {
                                                                eVar2 = e69;
                                                                str51 = str60;
                                                                vVar = vVar2;
                                                                str48 = str30;
                                                                str49 = str28;
                                                                i28 = 6;
                                                                z16 = false;
                                                                str50 = str51;
                                                                i17 = i28;
                                                                str23 = str50;
                                                                str22 = str49;
                                                                str24 = str48;
                                                                str57 = str12;
                                                                i3 = i17;
                                                                str14 = str23;
                                                                str13 = str22;
                                                                str15 = str24;
                                                                if (lVar.w()) {
                                                                }
                                                            } catch (Exception e75) {
                                                                exc = e75;
                                                                str47 = str60;
                                                                vVar = vVar2;
                                                                str44 = str30;
                                                                str45 = str28;
                                                                i27 = 6;
                                                                z16 = false;
                                                                str46 = str47;
                                                                i3 = i27;
                                                                str14 = str46;
                                                                str13 = str45;
                                                                str15 = str44;
                                                                if (!lVar.w()) {
                                                                }
                                                            } catch (Throwable th16) {
                                                                th5 = th16;
                                                                outputStream2 = outputStream;
                                                                str43 = str60;
                                                                vVar = vVar2;
                                                                str21 = str30;
                                                                str19 = str28;
                                                                c16 = 6;
                                                                z16 = false;
                                                                str20 = str43;
                                                                str57 = str12;
                                                                r36 = c16;
                                                                str4 = str20;
                                                                str3 = str19;
                                                                str2 = str21;
                                                                if (bufferedReader != null) {
                                                                }
                                                                if (outputStream2 != null) {
                                                                }
                                                                if (!z16) {
                                                                }
                                                            }
                                                        }
                                                    } catch (com.tencent.luggage.wxa.rg.e e76) {
                                                        eVar2 = e76;
                                                        bufferedReader = bufferedReader2;
                                                    } catch (Exception e77) {
                                                        exc = e77;
                                                        bufferedReader = bufferedReader2;
                                                    } catch (Throwable th17) {
                                                        th5 = th17;
                                                        bufferedReader = bufferedReader2;
                                                    }
                                                }
                                                if (readLine.toUpperCase().startsWith("#EXT-X-STREAM-INF")) {
                                                }
                                                if (readLine.toUpperCase().startsWith("#EXT-X-ENDLIST")) {
                                                }
                                                if (readLine.toUpperCase().startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                                                }
                                                if (readLine.toUpperCase().startsWith("#EXT-X-TARGETDURATION")) {
                                                }
                                                if (readLine.toUpperCase().startsWith("#EXT-X-PLAYLIST-TYPE")) {
                                                    lVar2.b(lVar.d() & (-5));
                                                    z27 = true;
                                                    z28 = false;
                                                }
                                                if (!readLine.toUpperCase().startsWith("#EXT-X-KEY")) {
                                                }
                                                str55 = null;
                                                arrayList4 = arrayList3;
                                                str56 = str54;
                                            } catch (com.tencent.luggage.wxa.rg.e e78) {
                                                e = e78;
                                                vVar = vVar2;
                                                z16 = false;
                                                eVar2 = e;
                                                str42 = str60;
                                                str39 = str30;
                                                str40 = str28;
                                                str41 = str42;
                                                i17 = 6;
                                                str23 = str41;
                                                str22 = str40;
                                                str24 = str39;
                                                str57 = str12;
                                                i3 = i17;
                                                str14 = str23;
                                                str13 = str22;
                                                str15 = str24;
                                                if (lVar.w()) {
                                                }
                                            } catch (Exception e79) {
                                                e = e79;
                                                vVar = vVar2;
                                                z16 = false;
                                                exc = e;
                                                str38 = str60;
                                                str35 = str30;
                                                str36 = str28;
                                                str37 = str38;
                                                i3 = 6;
                                                str14 = str37;
                                                str13 = str36;
                                                str15 = str35;
                                                if (!lVar.w()) {
                                                }
                                            } catch (Throwable th18) {
                                                th = th18;
                                                vVar = vVar2;
                                                z16 = false;
                                                th5 = th;
                                                outputStream2 = outputStream;
                                                str34 = str60;
                                                str31 = str30;
                                                str32 = str28;
                                                str33 = str34;
                                                c16 = 6;
                                                str20 = str33;
                                                str19 = str32;
                                                str21 = str31;
                                                str57 = str12;
                                                r36 = c16;
                                                str4 = str20;
                                                str3 = str19;
                                                str2 = str21;
                                                if (bufferedReader != null) {
                                                }
                                                if (outputStream2 != null) {
                                                }
                                                if (!z16) {
                                                }
                                            }
                                            bufferedReader = bufferedReader2;
                                            arrayList3 = arrayList2;
                                        } else {
                                            sb7 = sb9;
                                            ArrayList arrayList7 = arrayList6;
                                            bufferedReader = bufferedReader2;
                                            str56 = str63;
                                            str29 = str60;
                                            i29 = i37;
                                            vVar = vVar2;
                                            z16 = false;
                                            pattern2 = pattern3;
                                            str53 = readLine;
                                            if (!"".equalsIgnoreCase(str53)) {
                                                String a18 = com.tencent.luggage.wxa.tg.h.a(str57, str53);
                                                arrayList5 = arrayList7;
                                                String a19 = a(a18, false, false, VideoProxy.VALUE_CONTENT_TYPE_VIDEO_MPEG_TS, 90);
                                                if (lVar.q() != null) {
                                                    a19 = (a19 + "&id=" + lVar.q()) + "&enableCache=[VALUE_CACHE_PLACEHOLDER]";
                                                }
                                                sb7.append(a19);
                                                sb7.append("\n");
                                                str55 = a18;
                                            } else {
                                                arrayList5 = arrayList7;
                                                sb7.append(str53);
                                                sb7.append("\n");
                                                str55 = null;
                                            }
                                            arrayList4 = arrayList5;
                                        }
                                        try {
                                            if (str53.startsWith("#") || !(str53.contains(".ts") || str53.contains(DefaultHlsExtractorFactory.AAC_FILE_EXTENSION))) {
                                                i36 = i29;
                                                sb5 = sb7;
                                                arrayList6 = arrayList4;
                                                i46 = i46;
                                            } else {
                                                int i47 = i46;
                                                i36 = i29;
                                                if (arrayList4 != null && i47 < i36 && !TextUtils.isEmpty(str55)) {
                                                    String a26 = a(str55, true, true, VideoProxy.VALUE_CONTENT_TYPE_VIDEO_MPEG_TS, 10);
                                                    com.tencent.luggage.wxa.tg.h.a(4, str62, "generateLocalPlaylistFile, preloadTs:" + a26);
                                                    g gVar2 = new g();
                                                    gVar2.f139672b = a26;
                                                    gVar2.f139671a = str55;
                                                    arrayList4.add(gVar2);
                                                }
                                                i46 = i47 + 1;
                                                sb5 = sb7;
                                                arrayList6 = arrayList4;
                                            }
                                            str60 = str29;
                                            vVar2 = vVar;
                                            pattern3 = pattern2;
                                            str58 = str12;
                                            str59 = str28;
                                            bufferedReader2 = bufferedReader;
                                            str63 = str56;
                                            lVar2 = lVar;
                                            i37 = i36;
                                            str61 = str30;
                                        } catch (com.tencent.luggage.wxa.rg.e e85) {
                                            e = e85;
                                            eVar2 = e;
                                            str42 = str29;
                                            str39 = str30;
                                            str40 = str28;
                                            str41 = str42;
                                            i17 = 6;
                                            str23 = str41;
                                            str22 = str40;
                                            str24 = str39;
                                            str57 = str12;
                                            i3 = i17;
                                            str14 = str23;
                                            str13 = str22;
                                            str15 = str24;
                                            if (lVar.w()) {
                                            }
                                        } catch (Exception e86) {
                                            e = e86;
                                            exc = e;
                                            str38 = str29;
                                            str35 = str30;
                                            str36 = str28;
                                            str37 = str38;
                                            i3 = 6;
                                            str14 = str37;
                                            str13 = str36;
                                            str15 = str35;
                                            if (!lVar.w()) {
                                            }
                                        } catch (Throwable th19) {
                                            th = th19;
                                            th5 = th;
                                            outputStream2 = outputStream;
                                            str34 = str29;
                                            str31 = str30;
                                            str32 = str28;
                                            str33 = str34;
                                            c16 = 6;
                                            str20 = str33;
                                            str19 = str32;
                                            str21 = str31;
                                            str57 = str12;
                                            r36 = c16;
                                            str4 = str20;
                                            str3 = str19;
                                            str2 = str21;
                                            if (bufferedReader != null) {
                                            }
                                            if (outputStream2 != null) {
                                            }
                                            if (!z16) {
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (com.tencent.luggage.wxa.rg.e e87) {
                                    bufferedReader = bufferedReader2;
                                    str12 = str58;
                                    vVar = vVar2;
                                    z16 = false;
                                    eVar2 = e87;
                                    str40 = str59;
                                    str41 = str60;
                                    str39 = str61;
                                    i17 = 6;
                                    str23 = str41;
                                    str22 = str40;
                                    str24 = str39;
                                    str57 = str12;
                                    i3 = i17;
                                    str14 = str23;
                                    str13 = str22;
                                    str15 = str24;
                                    if (lVar.w()) {
                                    }
                                } catch (Exception e88) {
                                    bufferedReader = bufferedReader2;
                                    str12 = str58;
                                    vVar = vVar2;
                                    z16 = false;
                                    exc = e88;
                                    str36 = str59;
                                    str37 = str60;
                                    str35 = str61;
                                    i3 = 6;
                                    str14 = str37;
                                    str13 = str36;
                                    str15 = str35;
                                    if (!lVar.w()) {
                                    }
                                } catch (Throwable th20) {
                                    bufferedReader = bufferedReader2;
                                    str12 = str58;
                                    vVar = vVar2;
                                    z16 = false;
                                    th5 = th20;
                                    outputStream2 = outputStream;
                                    str32 = str59;
                                    str33 = str60;
                                    str31 = str61;
                                    c16 = 6;
                                    str20 = str33;
                                    str19 = str32;
                                    str21 = str31;
                                    str57 = str12;
                                    r36 = c16;
                                    str4 = str20;
                                    str3 = str19;
                                    str2 = str21;
                                    if (bufferedReader != null) {
                                    }
                                    if (outputStream2 != null) {
                                    }
                                    if (!z16) {
                                    }
                                }
                            }
                            str12 = str58;
                            str28 = str59;
                            str29 = str60;
                            str30 = str61;
                            vVar = vVar2;
                            z16 = false;
                            try {
                                if (!lVar.w()) {
                                    ArrayList arrayList8 = arrayList;
                                    if (arrayList8 != null && com.tencent.luggage.wxa.og.a.a().r() && !lVar.w()) {
                                        j.a().a(arrayList8, "preloadTs");
                                    }
                                    if (z28) {
                                        String q17 = lVar.q();
                                        try {
                                            if (!this.f139694m.containsKey(q17)) {
                                                this.f139694m.put(q17, new f());
                                            }
                                            f fVar = (f) this.f139694m.get(q17);
                                            int i48 = i38;
                                            if (i48 == -1) {
                                                throw new com.tencent.luggage.wxa.rg.e("error parse media sequence");
                                            }
                                            int i49 = i39;
                                            if (i49 != -1) {
                                                int i56 = fVar.f139669a;
                                                if (i56 == -1) {
                                                    if (this.f139695n.get(str57) != null) {
                                                    }
                                                    com.tencent.luggage.wxa.tg.h.a(3, str62, "set MaxMediaSequence " + i48);
                                                    fVar.f139669a = i48;
                                                    fVar.f139670b = System.currentTimeMillis();
                                                } else {
                                                    if (i48 < i56) {
                                                        throw new com.tencent.luggage.wxa.rg.e("mediaSequence can not be less than " + fVar.f139669a + ", current is " + i48 + ", url=" + str57);
                                                    }
                                                    if (i48 == i56) {
                                                        long currentTimeMillis = System.currentTimeMillis() - fVar.f139670b;
                                                        if (currentTimeMillis > i49 * 1000) {
                                                            this.f139695n.put(str57, fVar);
                                                            throw new com.tencent.luggage.wxa.rg.e("MaxMediaSequence not updated in " + currentTimeMillis + "ms, targetDuration=" + i49);
                                                        }
                                                    } else {
                                                        fVar.f139669a = i48;
                                                        fVar.f139670b = System.currentTimeMillis();
                                                    }
                                                }
                                            } else {
                                                throw new com.tencent.luggage.wxa.rg.e("error parse target duration");
                                            }
                                        } catch (com.tencent.luggage.wxa.rg.e e89) {
                                            e = e89;
                                            eVar2 = e;
                                            str42 = str29;
                                            str39 = str30;
                                            str40 = str28;
                                            str41 = str42;
                                            i17 = 6;
                                            str23 = str41;
                                            str22 = str40;
                                            str24 = str39;
                                            str57 = str12;
                                            i3 = i17;
                                            str14 = str23;
                                            str13 = str22;
                                            str15 = str24;
                                            if (lVar.w()) {
                                            }
                                        } catch (Exception e95) {
                                            e = e95;
                                            exc = e;
                                            str38 = str29;
                                            str35 = str30;
                                            str36 = str28;
                                            str37 = str38;
                                            i3 = 6;
                                            str14 = str37;
                                            str13 = str36;
                                            str15 = str35;
                                            if (!lVar.w()) {
                                            }
                                        } catch (Throwable th21) {
                                            th = th21;
                                            th5 = th;
                                            outputStream2 = outputStream;
                                            str34 = str29;
                                            str31 = str30;
                                            str32 = str28;
                                            str33 = str34;
                                            c16 = 6;
                                            str20 = str33;
                                            str19 = str32;
                                            str21 = str31;
                                            str57 = str12;
                                            r36 = c16;
                                            str4 = str20;
                                            str3 = str19;
                                            str2 = str21;
                                            if (bufferedReader != null) {
                                            }
                                            if (outputStream2 != null) {
                                            }
                                            if (!z16) {
                                            }
                                        }
                                    }
                                    try {
                                        com.tencent.luggage.wxa.tg.h.a(4, str62, "====================== end original m3u8 content ======================");
                                        String replaceAll = sb6.toString().replaceAll(VideoProxy.VALUE_CACHE_PLACEHOLDER_REG, (z27 && com.tencent.luggage.wxa.og.a.a().p()) ? "1" : "0");
                                        com.tencent.luggage.wxa.tg.h.a(4, str62, "====================== start local m3u8 content ======================");
                                        com.tencent.luggage.wxa.tg.h.a(4, str62, replaceAll);
                                        com.tencent.luggage.wxa.tg.h.a(4, str62, "====================== end local m3u8 content ======================");
                                        outputStream.write(replaceAll.getBytes());
                                        try {
                                            bufferedReader.close();
                                            z18 = false;
                                            i26 = 6;
                                        } catch (IOException e96) {
                                            i26 = 6;
                                            com.tencent.luggage.wxa.tg.h.a(6, str62, str29 + com.tencent.luggage.wxa.tg.h.a((Throwable) e96));
                                            z18 = true;
                                        }
                                        try {
                                            outputStream.close();
                                            z19 = z18;
                                        } catch (IOException e97) {
                                            com.tencent.luggage.wxa.tg.h.a(i26, str62, str28 + com.tencent.luggage.wxa.tg.h.a((Throwable) e97));
                                            z19 = true;
                                        }
                                        if (z17) {
                                            if (!z19) {
                                                return vVar;
                                            }
                                            if (vVar.e() && vVar.q()) {
                                                com.tencent.luggage.wxa.tg.h.a(4, str62, "generateLocalPlaylistFile, hasError deletePlayListFile " + vVar.toString() + str30 + vVar.d());
                                            }
                                            return null;
                                        }
                                        if (lVar.w()) {
                                            lVar.a();
                                        }
                                        if (vVar.e() && vVar.q()) {
                                            com.tencent.luggage.wxa.tg.h.a(4, str62, "generateLocalPlaylistFile, interrupt deletePlayListFile " + vVar.toString() + str30 + vVar.d());
                                        }
                                        return null;
                                    } catch (com.tencent.luggage.wxa.rg.e e98) {
                                        e = e98;
                                        str26 = str29;
                                        str27 = str30;
                                        str25 = str28;
                                        i19 = 6;
                                        eVar2 = e;
                                        i17 = i19;
                                        str23 = str26;
                                        str22 = str25;
                                        str24 = str27;
                                        str57 = str12;
                                        i3 = i17;
                                        str14 = str23;
                                        str13 = str22;
                                        str15 = str24;
                                        if (lVar.w()) {
                                        }
                                    } catch (Exception e99) {
                                        e = e99;
                                        str26 = str29;
                                        str27 = str30;
                                        str25 = str28;
                                        i18 = 6;
                                        exc = e;
                                        i3 = i18;
                                        str14 = str26;
                                        str13 = str25;
                                        str15 = str27;
                                        if (!lVar.w()) {
                                        }
                                    } catch (Throwable th22) {
                                        th = th22;
                                        str26 = str29;
                                        str27 = str30;
                                        str25 = str28;
                                        c17 = 6;
                                        th5 = th;
                                        outputStream2 = outputStream;
                                        c16 = c17;
                                        str20 = str26;
                                        str19 = str25;
                                        str21 = str27;
                                        str57 = str12;
                                        r36 = c16;
                                        str4 = str20;
                                        str3 = str19;
                                        str2 = str21;
                                        if (bufferedReader != null) {
                                        }
                                        if (outputStream2 != null) {
                                        }
                                        if (!z16) {
                                        }
                                    }
                                } else {
                                    str26 = str29;
                                    str27 = str30;
                                    str25 = str28;
                                    c17 = 6;
                                    i19 = 6;
                                    i18 = 6;
                                    try {
                                        throw new com.tencent.luggage.wxa.rg.e(HttpMsg.ERR_User_Cancelled);
                                    } catch (com.tencent.luggage.wxa.rg.e e100) {
                                        e = e100;
                                        eVar2 = e;
                                        i17 = i19;
                                        str23 = str26;
                                        str22 = str25;
                                        str24 = str27;
                                        str57 = str12;
                                        i3 = i17;
                                        str14 = str23;
                                        str13 = str22;
                                        str15 = str24;
                                        if (lVar.w()) {
                                        }
                                    } catch (Exception e101) {
                                        e = e101;
                                        exc = e;
                                        i3 = i18;
                                        str14 = str26;
                                        str13 = str25;
                                        str15 = str27;
                                        if (!lVar.w()) {
                                        }
                                    } catch (Throwable th23) {
                                        th = th23;
                                        th5 = th;
                                        outputStream2 = outputStream;
                                        c16 = c17;
                                        str20 = str26;
                                        str19 = str25;
                                        str21 = str27;
                                        str57 = str12;
                                        r36 = c16;
                                        str4 = str20;
                                        str3 = str19;
                                        str2 = str21;
                                        if (bufferedReader != null) {
                                        }
                                        if (outputStream2 != null) {
                                        }
                                        if (!z16) {
                                        }
                                    }
                                }
                            } catch (com.tencent.luggage.wxa.rg.e e102) {
                                e = e102;
                            } catch (Exception e103) {
                                e = e103;
                            } catch (Throwable th24) {
                                th = th24;
                            }
                        } catch (com.tencent.luggage.wxa.rg.e e104) {
                            e = e104;
                            bufferedReader = bufferedReader2;
                            str12 = str58;
                            str25 = str59;
                            str26 = str60;
                            str27 = str61;
                            vVar = vVar2;
                            i19 = 6;
                            z16 = false;
                            eVar2 = e;
                            i17 = i19;
                            str23 = str26;
                            str22 = str25;
                            str24 = str27;
                            str57 = str12;
                            i3 = i17;
                            str14 = str23;
                            str13 = str22;
                            str15 = str24;
                            if (lVar.w()) {
                            }
                        } catch (Exception e105) {
                            e = e105;
                            bufferedReader = bufferedReader2;
                            str12 = str58;
                            str25 = str59;
                            str26 = str60;
                            str27 = str61;
                            vVar = vVar2;
                            i18 = 6;
                            z16 = false;
                            exc = e;
                            i3 = i18;
                            str14 = str26;
                            str13 = str25;
                            str15 = str27;
                            if (!lVar.w()) {
                            }
                        } catch (Throwable th25) {
                            th = th25;
                            bufferedReader = bufferedReader2;
                            str12 = str58;
                            str25 = str59;
                            str26 = str60;
                            str27 = str61;
                            vVar = vVar2;
                            c17 = 6;
                            z16 = false;
                            th5 = th;
                            outputStream2 = outputStream;
                            c16 = c17;
                            str20 = str26;
                            str19 = str25;
                            str21 = str27;
                            str57 = str12;
                            r36 = c16;
                            str4 = str20;
                            str3 = str19;
                            str2 = str21;
                            if (bufferedReader != null) {
                            }
                            if (outputStream2 != null) {
                            }
                            if (!z16) {
                            }
                        }
                    } catch (com.tencent.luggage.wxa.rg.e e106) {
                        vVar = vVar4;
                        str16 = "generateLocalPlaylistFile, error close PlayListFile: ";
                        str17 = "generateLocalPlaylistFile, error close reader: ";
                        str18 = ", deleteSuccess:";
                        i16 = 6;
                        z16 = false;
                        eVar2 = e106;
                        str57 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                        outputStream = null;
                        bufferedReader = null;
                        i3 = i16;
                        str14 = str17;
                        str13 = str16;
                        str15 = str18;
                        if (lVar.w()) {
                            lVar.a();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e107) {
                                    com.tencent.luggage.wxa.tg.h.a(i3, str62, str14 + com.tencent.luggage.wxa.tg.h.a((Throwable) e107));
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e108) {
                                    com.tencent.luggage.wxa.tg.h.a(i3, str62, str13 + com.tencent.luggage.wxa.tg.h.a((Throwable) e108));
                                }
                            }
                            if (vVar.e() && vVar.q()) {
                                com.tencent.luggage.wxa.tg.h.a(4, str62, str57 + vVar.toString() + str15 + vVar.d());
                            }
                            return null;
                        }
                        com.tencent.luggage.wxa.tg.h.a(i3, str62, "generateLocalPlaylistFile LivePlayListException:" + com.tencent.luggage.wxa.tg.h.a((Throwable) eVar2));
                        throw eVar2;
                    }
                } catch (Exception e109) {
                    vVar = vVar4;
                    str12 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                    str13 = "generateLocalPlaylistFile, error close PlayListFile: ";
                    str14 = "generateLocalPlaylistFile, error close reader: ";
                    str15 = ", deleteSuccess:";
                    i3 = 6;
                    z16 = false;
                    exc = e109;
                    outputStream = null;
                    bufferedReader = null;
                } catch (Throwable th26) {
                    vVar = vVar4;
                    str9 = "generateLocalPlaylistFile, error close PlayListFile: ";
                    str10 = "generateLocalPlaylistFile, error close reader: ";
                    str11 = ", deleteSuccess:";
                    r37 = 6;
                    z16 = false;
                    th5 = th26;
                    str57 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                    bufferedReader = null;
                    boolean z3622 = z16;
                    str8 = r37;
                    str7 = str10;
                    str6 = str9;
                    str5 = str11;
                    z16 = z3622;
                    r36 = str8;
                    str4 = str7;
                    str3 = str6;
                    str2 = str5;
                    if (bufferedReader != null) {
                    }
                    if (outputStream2 != null) {
                    }
                    if (!z16) {
                    }
                }
            } catch (com.tencent.luggage.wxa.rg.e e110) {
                vVar = vVar4;
                str57 = "generateLocalPlaylistFile, finally deletePlayListFile ";
                str16 = "generateLocalPlaylistFile, error close PlayListFile: ";
                str17 = "generateLocalPlaylistFile, error close reader: ";
                str18 = ", deleteSuccess:";
                i16 = 6;
                z16 = false;
                eVar2 = e110;
            }
        } catch (Throwable th27) {
            th5 = th27;
            outputStream2 = 4;
            str8 = q16;
            str7 = compile;
            str6 = vVar4;
            str5 = r65;
        }
    }

    public final c a(com.tencent.luggage.wxa.qg.e eVar, com.tencent.luggage.wxa.qg.g gVar, String str, String str2, l lVar, Socket socket, String str3, long j3, long j16, long j17) {
        int i3;
        c cVar = new c(this, null);
        cVar.f139701a = j3;
        com.tencent.luggage.wxa.tg.h.a(4, str2, "openDataSource, dataSpec=" + gVar.toString());
        if (!com.tencent.luggage.wxa.tg.h.d(str)) {
            eVar.a(gVar);
        } else {
            try {
                com.tencent.luggage.wxa.og.a.a().j();
                v a16 = a(eVar, gVar, str, lVar);
                cVar.f139704d = a16;
                if (a16 != null) {
                    com.tencent.luggage.wxa.tg.h.a(4, str2, "openDataSource, localPlaylist generate success:" + cVar.f139704d.toString());
                    b bVar = new b();
                    bVar.a(new com.tencent.luggage.wxa.qg.g(Uri.fromFile(new File(x.b(cVar.f139704d.m(), false))), gVar.f138704b, gVar.f138705c, gVar.f138706d, gVar.f138707e, gVar.f138708f, gVar.f138709g, gVar.f138710h));
                    cVar.f139703c = bVar;
                } else {
                    if (lVar.i() == 90) {
                        cVar.f139701a = com.tencent.luggage.wxa.tg.h.b(18, j16);
                        com.tencent.luggage.wxa.k0.d.a(this.f139691j.get(str3));
                    }
                    com.tencent.luggage.wxa.tg.h.a(4, str2, "openDataSource, localPlaylist generate fail, see previous logs");
                    try {
                        socket.close();
                    } catch (IOException e16) {
                        com.tencent.luggage.wxa.tg.h.a(6, str2, "openDataSource, socket close exception", e16);
                    }
                    this.f139690i.a(lVar);
                    if (lVar.t()) {
                        lVar.e(256);
                        com.tencent.luggage.wxa.tg.h.a(4, str2, "openDataSource, videoRequest is interrupted:" + lVar);
                        lVar.c();
                    } else {
                        lVar.e(257);
                    }
                    lVar.c(true);
                    cVar.f139702b = true;
                    return cVar;
                }
            } catch (com.tencent.luggage.wxa.rg.e e17) {
                com.tencent.luggage.wxa.tg.h.a(6, VideoProxy.LOG_TAG_PREFIX + lVar.m(), "openDataSource, localPlaylist generate livePlayListException " + e17);
                if (e17.getCause() != null) {
                    i3 = ((e17.getCause() instanceof l.b) || (e17.getCause() instanceof l.c)) ? 0 : 17;
                } else {
                    i3 = 16;
                }
                if (lVar.i() == 90 && i3 != 0) {
                    cVar.f139701a = com.tencent.luggage.wxa.tg.h.b(i3, j16);
                    com.tencent.luggage.wxa.k0.d.a(this.f139691j.get(str3));
                }
                try {
                    socket.close();
                } catch (IOException e18) {
                    com.tencent.luggage.wxa.tg.h.a(6, str2, "openDataSource, socket close exception", e18);
                }
                this.f139690i.a(lVar);
                if (lVar.t()) {
                    lVar.e(256);
                    com.tencent.luggage.wxa.tg.h.a(4, str2, "openDataSource, videoRequest is interrupted:" + lVar);
                    lVar.c();
                } else {
                    lVar.e(257);
                }
                lVar.c(true);
                cVar.f139702b = true;
                return cVar;
            }
        }
        return cVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:6|(1:700)(1:10)|11|(1:13)(1:699)|(1:15)(1:698)|16|17|18|20|21|(11:23|24|25|26|27|28|29|30|31|32|34)(63:368|369|370|371|372|374|375|(1:377)(58:623|624|625|(4:636|637|638|(2:640|(3:642|643|644)(1:646))(1:647))(3:627|628|629)|379|380|381|382|383|384|385|386|387|388|(4:390|391|392|393)(1:591)|394|395|396|397|398|399|400|401|402|403|404|405|406|407|408|(4:409|410|411|(3:413|414|(4:416|417|418|(8:422|423|(6:425|426|427|428|429|430)(1:476)|431|(4:435|(1:437)(2:452|(1:454)(1:455))|438|(2:440|(2:442|(1:444)(1:445))(3:449|450|451)))|456|450|451)(1:531))(1:536))(1:545))|479|480|(3:482|483|484)(1:530)|485|486|(1:488)|490|491|492|493|494|495|496|497|498|(2:504|(1:508))|509|358|111|(1:113)(1:(1:154))|114|(1:116)(2:123|(1:125)(2:126|(1:128)(2:129|(1:131)(2:132|(1:134)(2:135|(1:137)(2:138|(1:140)(2:141|(1:143)(2:144|(2:149|(1:151)(1:152))(1:148)))))))))|117|118|(1:120)|121|122)|378|379|380|381|382|383|384|385|386|387|388|(0)(0)|394|395|396|397|398|399|400|401|402|403|404|405|406|407|408|(5:409|410|411|(0)(0)|451)|479|480|(0)(0)|485|486|(0)|490|491|492|493|494|495|496|497|498|(4:500|502|504|(2:506|508))|509|358|111|(0)(0)|114|(0)(0)|117|118|(0)|121|122)|338|339|340|(1:342)|344|345|346|(2:352|(1:356))|357|358|111|(0)(0)|114|(0)(0)|117|118|(0)|121|122) */
    /* JADX WARN: Can't wrap try/catch for region: R(55:(1:377)(58:623|624|625|(4:636|637|638|(2:640|(3:642|643|644)(1:646))(1:647))(3:627|628|629)|379|380|381|382|383|384|385|386|387|388|(4:390|391|392|393)(1:591)|394|395|396|397|398|399|400|401|402|403|404|405|406|407|408|(4:409|410|411|(3:413|414|(4:416|417|418|(8:422|423|(6:425|426|427|428|429|430)(1:476)|431|(4:435|(1:437)(2:452|(1:454)(1:455))|438|(2:440|(2:442|(1:444)(1:445))(3:449|450|451)))|456|450|451)(1:531))(1:536))(1:545))|479|480|(3:482|483|484)(1:530)|485|486|(1:488)|490|491|492|493|494|495|496|497|498|(2:504|(1:508))|509|358|111|(1:113)(1:(1:154))|114|(1:116)(2:123|(1:125)(2:126|(1:128)(2:129|(1:131)(2:132|(1:134)(2:135|(1:137)(2:138|(1:140)(2:141|(1:143)(2:144|(2:149|(1:151)(1:152))(1:148)))))))))|117|118|(1:120)|121|122)|379|380|381|382|383|384|385|386|387|388|(0)(0)|394|395|396|397|398|399|400|401|402|403|404|405|406|407|408|(5:409|410|411|(0)(0)|451)|479|480|(0)(0)|485|486|(0)|490|491|492|493|494|495|496|497|498|(4:500|502|504|(2:506|508))|509|358|111|(0)(0)|114|(0)(0)|117|118|(0)|121|122) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0ed7, code lost:
    
        if (r26 != null) goto L548;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0ee5, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, r56 + r26.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0f0e, code lost:
    
        if (r26.g().startsWith(com.tencent.luggage.wxa.og.a.a().l()) != false) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0f16, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, r57 + r26.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0f2f, code lost:
    
        r14 = r28;
        r5 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0ecc, code lost:
    
        r61.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0ed0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0ed1, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(r5, r2, r50, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0ec4, code lost:
    
        r5 = 5;
        com.tencent.luggage.wxa.tg.h.a(5, r2, r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x1009, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x100a, code lost:
    
        r16 = r1;
        r9 = r31;
        r3 = r34;
        r6 = r45;
        r14 = r46;
        r15 = r47;
        r4 = r50;
        r12 = r52;
        r1 = r57;
        r17 = r0;
        r5 = r11;
        r11 = r56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0bd6, code lost:
    
        r11 = com.tencent.luggage.wxa.tg.h.a(r6.f138761c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0be2, code lost:
    
        r29 = com.tencent.luggage.wxa.tg.h.b(3, r11);
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0be5, code lost:
    
        r11 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0bfe, code lost:
    
        if ((r5 instanceof com.tencent.luggage.wxa.qg.l.d) != false) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0c00, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, "uri:" + r64.n() + ", InvalidContent");
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0c23, code lost:
    
        if (r64.i() == 90) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0c25, code lost:
    
        r13 = com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
        r11 = com.tencent.luggage.wxa.tg.h.b(10, com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0c2e, code lost:
    
        r29 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0c32, code lost:
    
        r13 = com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0c37, code lost:
    
        if ((r5 instanceof com.tencent.luggage.wxa.qg.l.g) != false) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0c39, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, "uri:" + r64.n() + ", MalformedResponse");
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0c5c, code lost:
    
        if (r64.i() == 90) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0c5e, code lost:
    
        r11 = com.tencent.luggage.wxa.tg.h.b(12, com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0c67, code lost:
    
        if ((r5 instanceof com.tencent.luggage.wxa.qg.l.b) != false) goto L453;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0c6b, code lost:
    
        r4.e(256);
        com.tencent.luggage.wxa.tg.h.a(5, r2, "uri:" + r64.n() + " connect to server interrupted");
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0c8b, code lost:
    
        r11 = r5;
        r12 = -99999;
        r28 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0c93, code lost:
    
        if ((r5 instanceof com.tencent.luggage.wxa.qg.l.c) != false) goto L458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0c97, code lost:
    
        r4.e(256);
        com.tencent.luggage.wxa.tg.h.a(5, r2, "uri:" + r64.n() + " read interrupted");
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0cba, code lost:
    
        if ((r5 instanceof com.tencent.luggage.wxa.qg.l.h) != false) goto L463;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0cbc, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "uri:" + r64.n() + ", unable to connect server: " + com.tencent.luggage.wxa.tg.h.a((java.lang.Throwable) r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0ce6, code lost:
    
        if (r64.i() == 90) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0cea, code lost:
    
        if ((r1 instanceof com.tencent.luggage.wxa.pg.c) != false) goto L467;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0cec, code lost:
    
        r3 = ((com.tencent.luggage.wxa.pg.c) r1).f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0cf5, code lost:
    
        if ((r3 instanceof com.tencent.luggage.wxa.qg.j) != false) goto L469;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0cf7, code lost:
    
        r3 = ((com.tencent.luggage.wxa.qg.j) r3).h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0d20, code lost:
    
        r11 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0d23, code lost:
    
        if (r11 == null) goto L484;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0d3c, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0d3f, code lost:
    
        if (r12 != false) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0d41, code lost:
    
        r12 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0d4e, code lost:
    
        r11 = com.tencent.luggage.wxa.tg.h.b(r12, com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0d48, code lost:
    
        if (com.tencent.luggage.wxa.tg.h.c() != false) goto L489;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0d4a, code lost:
    
        r12 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0d4c, code lost:
    
        r12 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0d3e, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0cfe, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, "write response, cacheDataSource error:" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0d22, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0d17, code lost:
    
        if ((r1 instanceof com.tencent.luggage.wxa.qg.j) != false) goto L473;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0d19, code lost:
    
        r3 = ((com.tencent.luggage.wxa.qg.j) r1).h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0d57, code lost:
    
        if ((r5 instanceof com.tencent.luggage.wxa.qg.l.a) != false) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0d59, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "uri:" + r64.n() + ", read upstream error1: " + com.tencent.luggage.wxa.tg.h.a((java.lang.Throwable) r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0d83, code lost:
    
        if (r64.i() == 90) goto L497;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0d85, code lost:
    
        r11 = com.tencent.luggage.wxa.tg.h.b(r10.a(r5), com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0d92, code lost:
    
        if ((r1 instanceof com.tencent.luggage.wxa.qg.k) == false) goto L507;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0d98, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "uri:" + r64.n() + ", read upstream error2: " + com.tencent.luggage.wxa.tg.h.a((java.lang.Throwable) r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0dc2, code lost:
    
        if (r64.i() == 90) goto L505;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0dc4, code lost:
    
        r11 = com.tencent.luggage.wxa.tg.h.b(1404, com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0dce, code lost:
    
        if ((r5 instanceof java.net.NoRouteToHostException) != false) goto L509;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0dd0, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "uri:" + r64.n() + ", read upstream error3: " + com.tencent.luggage.wxa.tg.h.a((java.lang.Throwable) r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0dfa, code lost:
    
        if (r64.i() == 90) goto L511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0dfc, code lost:
    
        r11 = com.tencent.luggage.wxa.tg.h.b(1, com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0e06, code lost:
    
        if ((r5 instanceof java.io.InterruptedIOException) != false) goto L515;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0e0a, code lost:
    
        r4.e(256);
        com.tencent.luggage.wxa.tg.h.a(4, r2, "uri:" + r64.n() + " is interrupted by system");
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0e2e, code lost:
    
        if (r10.f139687f != false) goto L520;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0e30, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "response interrupted, proxy server has shutdown");
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0e43, code lost:
    
        if (r5.getMessage().matches("(?i)^.*((ECONNRESET)|(EPIPE)|(reset)).*$") != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0e45, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "response interrupted, client closed connection");
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0e58, code lost:
    
        if (r5.toString().contains("write byteCount err") != false) goto L528;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0e5a, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "response interrupted, socket write byteCount err");
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0e62, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, "uri:" + r4 + ", error occurred while sending data " + com.tencent.luggage.wxa.tg.h.a((java.lang.Throwable) r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x1022, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x1023, code lost:
    
        r16 = r1;
        r9 = r31;
        r3 = r34;
        r6 = r45;
        r14 = r46;
        r15 = r47;
        r4 = r50;
        r12 = r52;
        r11 = r56;
        r1 = r57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x1048, code lost:
    
        r17 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0a20, code lost:
    
        r9 = (com.tencent.luggage.wxa.qg.l.f) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0a23, code lost:
    
        r47 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0a29, code lost:
    
        r46 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0a2d, code lost:
    
        if (r64.i() == 90) goto L654;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0b53, code lost:
    
        r10 = r60;
        r45 = r4;
        r31 = r6;
        r52 = r12;
        r4 = r64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0a33, code lost:
    
        if (r9.f138762b == 416) goto L372;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0a35, code lost:
    
        r10 = r60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0a39, code lost:
    
        r45 = r4;
        r31 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0a40, code lost:
    
        r4 = r10.f139690i.a(r27, -1).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0a4c, code lost:
    
        if (r4.hasNext() != false) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0a4e, code lost:
    
        r11 = (com.tencent.luggage.wxa.rg.l) r4.next();
        r63 = r4;
        r4 = r64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0a5c, code lost:
    
        if (r11.equals(r4) != false) goto L727;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0a66, code lost:
    
        r16 = r11.p();
        r11 = r11.g();
        r20 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0a7c, code lost:
    
        if (r20 == (-1)) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0a86, code lost:
    
        r27 = r27;
        r6 = com.tencent.luggage.wxa.tg.f.a(r7, r12, r20, r11.toString(), !com.tencent.luggage.wxa.tg.h.d(r62));
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0a9c, code lost:
    
        r52 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0aa4, code lost:
    
        if (r11.equals(com.tencent.luggage.wxa.rg.b.f139662c) != false) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0aa6, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(6, r2, "file type should not be unknown");
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0aad, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, "write response, responseCode 416, totalLength=" + r14 + r59 + com.tencent.luggage.wxa.tg.h.c(r6, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0ad0, code lost:
    
        r11 = r55;
        r11.write(r6.getBytes("UTF-8"));
        r11.flush();
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0ae2, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0b0d, code lost:
    
        if (r11 != null) goto L697;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0b48, code lost:
    
        r12 = com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0b0f, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, "uri:" + r64.n() + ", InvalidResponseCode: \r\n" + com.tencent.luggage.wxa.tg.f.a(r9.f138763c));
        r5 = com.tencent.luggage.wxa.tg.h.a(r9.f138763c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0b42, code lost:
    
        r29 = com.tencent.luggage.wxa.tg.h.b(r9.f138762b, r5);
        r12 = r5;
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0ae4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0ae6, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, "write response, workaround 416 error ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0b0c, code lost:
    
        r11 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0aee, code lost:
    
        r27 = r27;
        r52 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x0a71, code lost:
    
        r4 = r63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0a74, code lost:
    
        r4 = r64;
        r11 = r16;
        r20 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0af3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0af4, code lost:
    
        r17 = r0;
        r16 = r1;
        r9 = r31;
        r3 = r34;
        r6 = r45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0b72, code lost:
    
        r14 = r46;
        r15 = r47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0b8a, code lost:
    
        r4 = r50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0b00, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0b50, code lost:
    
        r31 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0b69, code lost:
    
        r17 = r0;
        r16 = r1;
        r6 = r4;
        r9 = r31;
        r3 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0b02, code lost:
    
        r10 = r60;
        r45 = r4;
        r31 = r6;
        r52 = r12;
        r4 = r64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0b4d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0b62, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0b63, code lost:
    
        r31 = r6;
        r46 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0b77, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0b78, code lost:
    
        r31 = r6;
        r17 = r0;
        r16 = r1;
        r6 = r4;
        r15 = r11;
        r9 = r31;
        r3 = r34;
        r14 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x096c, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x0480, code lost:
    
        throw new com.tencent.luggage.wxa.qg.l.d("invalid content", r54);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0b92, code lost:
    
        r45 = r4;
        r31 = r6;
        r46 = r10;
        r47 = r11;
        r52 = r12;
        r10 = r60;
        r4 = r64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x05a8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x05a9, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(r3, r2, r50, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x059e, code lost:
    
        r3 = 5;
        com.tencent.luggage.wxa.tg.h.a(5, r2, r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:0x060f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x0610, code lost:
    
        r10 = r46;
        r11 = r47;
        r12 = r52;
        r9 = "write response, delete PlayListFile failed:";
        r19 = r1;
        r15 = r3;
        r17 = r14;
        r6 = r34;
        r1 = r50;
        r3 = "write response, delete PlayListFile:";
     */
    /* JADX WARN: Code restructure failed: missing block: B:519:0x0652, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:520:0x0653, code lost:
    
        r65 = r1;
        r16 = r3;
        r17 = r14;
        r6 = r34;
        r10 = r46;
        r11 = r47;
        r1 = r50;
        r12 = r52;
        r3 = "write response, delete PlayListFile:";
        r9 = "write response, delete PlayListFile failed:";
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x06b6, code lost:
    
        r20 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x0644, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:523:0x0645, code lost:
    
        r65 = r1;
        r16 = r3;
        r17 = r14;
        r6 = r34;
        r10 = r46;
        r11 = r47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:524:0x068e, code lost:
    
        r1 = r50;
        r12 = r52;
        r3 = "write response, delete PlayListFile:";
        r9 = "write response, delete PlayListFile failed:";
        r19 = r65;
        r14 = r0;
        r15 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:525:0x0625, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x0626, code lost:
    
        r65 = r1;
        r17 = r0;
        r6 = r4;
        r9 = r3;
        r3 = r34;
        r14 = r46;
        r15 = r47;
        r4 = r50;
        r12 = r52;
        r11 = "write response, delete PlayListFile:";
        r1 = "write response, delete PlayListFile failed:";
        r5 = null;
        r16 = r65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x050c, code lost:
    
        r46 = r6;
        r47 = r9;
        r59 = r10;
        r18 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0ba3, code lost:
    
        if ((r5 instanceof com.tencent.luggage.wxa.qg.l.e) != false) goto L430;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0ba5, code lost:
    
        r6 = (com.tencent.luggage.wxa.qg.l.e) r5;
        com.tencent.luggage.wxa.tg.h.a(4, r2, "uri:" + r64.n() + ", InvalidContentType: \r\n" + com.tencent.luggage.wxa.tg.f.a(r6.f138761c));
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x06ba, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x06bb, code lost:
    
        r65 = r1;
        r11 = r9;
        r59 = r10;
        r18 = r12;
        r1 = r50;
        r12 = r52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x06d5, code lost:
    
        r3 = "write response, delete PlayListFile:";
        r9 = "write response, delete PlayListFile failed:";
        r10 = r6;
        r6 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x0780, code lost:
    
        r20 = r0;
        r16 = 0;
        r17 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x06c7, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0bd4, code lost:
    
        if (r64.i() == 90) goto L432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x06c8, code lost:
    
        r65 = r1;
        r11 = r9;
        r59 = r10;
        r18 = r12;
        r1 = r50;
        r12 = r52;
        r15 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x06ff, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0700, code lost:
    
        r65 = r1;
        r10 = r6;
        r11 = r9;
        r18 = r12;
        r6 = r34;
        r1 = r50;
        r12 = r52;
        r15 = r12;
        r3 = "write response, delete PlayListFile:";
        r9 = "write response, delete PlayListFile failed:";
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x06f0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:565:0x06f1, code lost:
    
        r65 = r1;
        r10 = r6;
        r11 = r9;
        r6 = r34;
        r1 = r50;
        r12 = r52;
        r3 = "write response, delete PlayListFile:";
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x07d3, code lost:
    
        r9 = "write response, delete PlayListFile failed:";
        r19 = r65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x06e0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x06e1, code lost:
    
        r16 = r1;
        r17 = r0;
        r14 = r6;
        r15 = r9;
        r3 = r34;
        r12 = r52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0b5d, code lost:
    
        r13 = com.tencent.oskplayer.report.VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x0728, code lost:
    
        r11 = "write response, delete PlayListFile:";
        r1 = "write response, delete PlayListFile failed:";
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x0716, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:574:0x0717, code lost:
    
        r65 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:575:0x0742, code lost:
    
        r18 = r12;
        r1 = r50;
        r15 = r12;
        r3 = "write response, delete PlayListFile:";
        r12 = r52;
        r10 = r6;
        r11 = r9;
        r6 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x077e, code lost:
    
        r9 = "write response, delete PlayListFile failed:";
     */
    /* JADX WARN: Code restructure failed: missing block: B:578:0x073d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x073e, code lost:
    
        r65 = r1;
        r63 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0e82, code lost:
    
        r11 = r5;
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x072f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x0730, code lost:
    
        r65 = r1;
        r12 = r52;
        r1 = r50;
        r3 = "write response, delete PlayListFile:";
        r10 = r6;
        r11 = r9;
        r6 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x071a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:583:0x071b, code lost:
    
        r12 = r52;
        r16 = r1;
        r17 = r0;
        r14 = r6;
        r15 = r9;
        r3 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:593:0x075e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:594:0x075f, code lost:
    
        r65 = r1;
        r63 = r3;
        r18 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x0772, code lost:
    
        r1 = r50;
        r3 = "write response, delete PlayListFile:";
        r12 = r52;
        r10 = r6;
        r11 = r9;
        r6 = "write response, dataSource close failed";
        r15 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x0758, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:597:0x0759, code lost:
    
        r65 = r1;
        r12 = r52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x07cc, code lost:
    
        r1 = r50;
        r3 = "write response, delete PlayListFile:";
        r10 = r6;
        r11 = r9;
        r6 = "write response, dataSource close failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x0752, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:600:0x0753, code lost:
    
        r65 = r1;
        r12 = r52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x07be, code lost:
    
        r16 = r65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x0836, code lost:
    
        r17 = r0;
        r14 = r6;
        r3 = "write response, dataSource close failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0769, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x076a, code lost:
    
        r65 = r1;
        r63 = r3;
        r18 = r12;
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x0766, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:609:0x07c7, code lost:
    
        r65 = r1;
        r12 = r52;
        r26 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0e88, code lost:
    
        if (r64.w() != false) goto L534;
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x079e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x079f, code lost:
    
        r18 = r12;
        r26 = r14;
        r3 = "write response, delete PlayListFile:";
        r16 = r11;
        r12 = r52;
        r10 = r6;
        r11 = r9;
        r6 = "write response, dataSource close failed";
        r15 = r12;
        r9 = "write response, delete PlayListFile failed:";
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x07d9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0e8a, code lost:
    
        r64.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:621:0x07c4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0e8e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0e8f, code lost:
    
        r17 = r0;
        r16 = r1;
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x1083, code lost:
    
        if (r26.q() != false) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x1089, code lost:
    
        if (r26.e() != false) goto L623;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x108b, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, r11 + r26.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x10b2, code lost:
    
        if (r26.g().startsWith(com.tencent.luggage.wxa.og.a.a().l()) != false) goto L625;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x10b8, code lost:
    
        if (r26.d() == false) goto L627;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x10ba, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(5, r2, r1 + r26.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x10d1, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:?, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        throw r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x1074, code lost:
    
        r61.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x1078, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x1079, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(r6, r2, r4, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0e96, code lost:
    
        com.tencent.luggage.wxa.tg.h.a(4, r2, r45 + (r31 == true ? 1 : 0) + r46 + r7 + r47 + r52);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0ebf, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0ec2, code lost:
    
        r5 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0eca, code lost:
    
        if (r11 == null) goto L693;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0ed9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0f3e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0f6a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0fce  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0f72  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0f42  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0ecc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0a20 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0b48  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0b0f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0946 A[Catch: all -> 0x09d4, TRY_LEAVE, TryCatch #35 {all -> 0x09d4, blocks: (B:340:0x0926, B:342:0x0946), top: B:339:0x0926 }] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x03c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x056b A[Catch: all -> 0x0524, Exception -> 0x053e, IOException -> 0x054b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0524, blocks: (B:430:0x03fb, B:431:0x0446, B:435:0x0450, B:437:0x0454, B:438:0x0463, B:440:0x0467, B:442:0x046f, B:446:0x0476, B:447:0x0480, B:449:0x0481, B:450:0x048d, B:452:0x045c, B:484:0x0519, B:488:0x056b, B:492:0x0571), top: B:429:0x03fb }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0b92  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:545:0x050c A[EDGE_INSN: B:545:0x050c->B:537:0x050c BREAK  A[LOOP:1: B:409:0x03be->B:451:0x0498], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:591:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0e8a A[Catch: all -> 0x0e8e, TRY_ENTER, TRY_LEAVE, TryCatch #71 {all -> 0x0e8e, blocks: (B:299:0x0b0f, B:61:0x0e8a), top: B:298:0x0b0f }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x107f  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x1074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 10 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 15 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Socket socket, String str, OutputStream outputStream, l lVar, InputStream inputStream) {
        long j3;
        long j16;
        String str2;
        long j17;
        Throwable th5;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        long j18;
        String str8;
        String str9;
        Exception exc;
        int i3;
        String str10;
        com.tencent.luggage.wxa.qg.e eVar;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        com.tencent.luggage.wxa.qg.e eVar2;
        String str17;
        String str18;
        BufferedOutputStream bufferedOutputStream;
        String str19;
        String str20;
        com.tencent.luggage.wxa.rg.b bVar;
        String str21;
        Exception exc2;
        long j19;
        int i16;
        boolean z16;
        v vVar;
        com.tencent.luggage.wxa.qg.e eVar3;
        long j26;
        boolean z17;
        Exception exc3;
        k kVar;
        long j27;
        l lVar2;
        String str22;
        int i17;
        String str23;
        BufferedOutputStream bufferedOutputStream2;
        String str24;
        long j28;
        boolean z18;
        long j29;
        int i18;
        c a16;
        long j36;
        v vVar2;
        long c16;
        com.tencent.luggage.wxa.rg.b fileType;
        com.tencent.luggage.wxa.qg.e eVar4;
        com.tencent.luggage.wxa.rg.b bVar2;
        long j37;
        String str25;
        String str26;
        BufferedOutputStream bufferedOutputStream3;
        String str27;
        IOException iOException;
        int i19;
        boolean z19;
        String str28;
        String str29;
        char c17;
        byte[] bArr;
        com.tencent.luggage.wxa.qg.g gVar;
        com.tencent.luggage.wxa.qg.e eVar5;
        StringBuilder sb5;
        int i26;
        String str30 = VideoProxy.LOG_TAG_PREFIX + lVar.m();
        String r16 = lVar.r();
        com.tencent.luggage.wxa.k0.d.a(this.f139692k.get(r16));
        com.tencent.luggage.wxa.qg.e a17 = new com.tencent.luggage.wxa.qg.i(this.f139684c, null, lVar).a(str, str30 + "/");
        if (a17 == null) {
            com.tencent.luggage.wxa.tg.h.a(6, str30, "write response, dataSource is null, return");
            return;
        }
        com.tencent.luggage.wxa.rg.b bVar3 = com.tencent.luggage.wxa.rg.b.f139662c;
        byte[] bArr2 = new byte[65536];
        long j38 = lVar.j();
        long k3 = lVar.k();
        if (j38 == -1 || j38 == -2) {
            j3 = j38;
            j16 = -1;
        } else {
            j3 = j38;
            j16 = (j38 - k3) + 1;
        }
        com.tencent.luggage.wxa.qg.g gVar2 = new com.tencent.luggage.wxa.qg.g(Uri.parse(str), k3 == -1 ? 0L : k3, k3 == -1 ? 0L : k3, j16, r16, 0, lVar.q(), lVar.i());
        BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(outputStream);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.qg.e eVar6 = a17;
        String str31 = r16;
        String str32 = "write response, total send ";
        String str33 = " bytes, rangeStart=";
        String str34 = ", rangeEnd=";
        String str35 = "write response, socket close failed";
        com.tencent.luggage.wxa.qg.g gVar3 = gVar2;
        byte[] bArr3 = bArr2;
        long j39 = j3;
        String str36 = ", send response headers: ";
        try {
            try {
                a16 = a(a17, gVar2, str, str30, lVar, socket, str31, 0L, VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE, currentTimeMillis);
                try {
                } catch (IOException e16) {
                    e = e16;
                    str16 = "write response, dataSource close failed";
                    eVar2 = eVar6;
                    str2 = str30;
                    str11 = str32;
                    str17 = str33;
                    str18 = str34;
                    j17 = k3;
                    j18 = j39;
                    bufferedOutputStream = bufferedOutputStream4;
                    str19 = "write response, delete PlayListFile:";
                    str20 = "write response, delete PlayListFile failed:";
                    bVar = bVar3;
                    exc = e;
                    j19 = 0;
                    eVar3 = eVar2;
                    j26 = -1;
                    vVar = null;
                    str24 = str16;
                    str23 = str20;
                    bufferedOutputStream2 = bufferedOutputStream;
                    j29 = j26;
                    j28 = j19;
                    i18 = 0;
                    z18 = true;
                    try {
                        String str37 = str19;
                        try {
                            if (!(exc instanceof l.f)) {
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            eVar6 = eVar3;
                            i3 = bArr2;
                            str3 = str24;
                            str4 = str32;
                            str5 = str33;
                            str6 = str34;
                            str7 = str35;
                            j18 = j39;
                            str8 = str37;
                            str9 = str23;
                            com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                            try {
                                eVar6.close();
                                i17 = 5;
                            } catch (IOException unused) {
                                i17 = 5;
                                com.tencent.luggage.wxa.tg.h.a(5, str2, str3);
                            }
                            if (exc == null) {
                            }
                            if (vVar != null) {
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        eVar6 = eVar3;
                        i3 = i18;
                        str5 = str17;
                        str6 = str18;
                        str9 = str23;
                        str8 = str19;
                        str4 = str11;
                        str3 = str24;
                        str7 = str35;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str10 = "write response, dataSource close failed";
                eVar = eVar6;
                str2 = str30;
                str11 = str32;
                str12 = str33;
                str13 = str34;
                j17 = k3;
                str14 = str35;
                j18 = j39;
                str15 = "write response, delete PlayListFile:";
            } catch (Throwable th8) {
                str2 = str30;
                j17 = k3;
                th5 = th8;
                str3 = "write response, dataSource close failed";
                str4 = str32;
                str5 = str33;
                str6 = str34;
                str7 = str35;
                j18 = j39;
                str8 = "write response, delete PlayListFile:";
                str9 = "write response, delete PlayListFile failed:";
                exc = null;
                i3 = 0;
            }
        } catch (IOException e18) {
            e = e18;
        }
        try {
            if (a16.f139702b) {
                str2 = str30;
                try {
                    com.tencent.luggage.wxa.tg.h.a(4, str2, "write response, isHandled");
                    com.tencent.luggage.wxa.tg.h.a(4, str2, str32 + 0 + str33 + k3 + str34 + j39);
                    try {
                        eVar6.close();
                        i26 = 5;
                    } catch (IOException unused2) {
                        i26 = 5;
                        com.tencent.luggage.wxa.tg.h.a(5, str2, "write response, dataSource close failed");
                    }
                    try {
                        socket.close();
                        return;
                    } catch (IOException e19) {
                        com.tencent.luggage.wxa.tg.h.a(i26, str2, str35, e19);
                        return;
                    }
                } catch (IOException e26) {
                    str11 = str32;
                    j17 = k3;
                    exc = e26;
                    str16 = "write response, dataSource close failed";
                    eVar3 = eVar6;
                    j19 = 0;
                    j26 = -1;
                    str17 = str33;
                    str18 = str34;
                    j18 = j39;
                    bufferedOutputStream = bufferedOutputStream4;
                    str19 = "write response, delete PlayListFile:";
                    str20 = "write response, delete PlayListFile failed:";
                    bVar = bVar3;
                    vVar = null;
                    str24 = str16;
                    str23 = str20;
                    bufferedOutputStream2 = bufferedOutputStream;
                    j29 = j26;
                    j28 = j19;
                    i18 = 0;
                    z18 = true;
                    String str372 = str19;
                    if (!(exc instanceof l.f)) {
                    }
                } catch (Exception e27) {
                    str11 = str32;
                    j17 = k3;
                    exc2 = e27;
                    str10 = "write response, dataSource close failed";
                    eVar = eVar6;
                    j19 = 0;
                    str12 = str33;
                    str13 = str34;
                    str14 = str35;
                    j18 = j39;
                    str15 = "write response, delete PlayListFile:";
                    str21 = "write response, delete PlayListFile failed:";
                    z16 = true;
                    vVar = null;
                    i16 = 0;
                } catch (Throwable th9) {
                    j17 = k3;
                    th5 = th9;
                    i3 = 0;
                    str3 = "write response, dataSource close failed";
                    str4 = str32;
                    str5 = str33;
                    str6 = str34;
                    str7 = str35;
                    j18 = j39;
                    str8 = "write response, delete PlayListFile:";
                    str9 = "write response, delete PlayListFile failed:";
                    exc = null;
                    vVar = null;
                    com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                    eVar6.close();
                    i17 = 5;
                    if (exc == null) {
                    }
                    if (vVar != null) {
                    }
                }
            } else {
                str2 = str30;
                str11 = str32;
                String str38 = str33;
                String str39 = str34;
                j17 = k3;
                try {
                    try {
                        j36 = a16.f139701a;
                    } catch (IOException e28) {
                        e = e28;
                        j18 = j39;
                        eVar2 = eVar6;
                        str19 = "write response, delete PlayListFile:";
                        bVar = bVar3;
                        str17 = str38;
                        str18 = str39;
                        str16 = "write response, dataSource close failed";
                        bufferedOutputStream = bufferedOutputStream4;
                        str20 = "write response, delete PlayListFile failed:";
                        exc = e;
                        j19 = 0;
                        eVar3 = eVar2;
                        j26 = -1;
                        vVar = null;
                        str24 = str16;
                        str23 = str20;
                        bufferedOutputStream2 = bufferedOutputStream;
                        j29 = j26;
                        j28 = j19;
                        i18 = 0;
                        z18 = true;
                        String str3722 = str19;
                        if (!(exc instanceof l.f)) {
                        }
                    } catch (Exception e29) {
                        e = e29;
                        j18 = j39;
                        eVar = eVar6;
                        str14 = str35;
                        str15 = "write response, delete PlayListFile:";
                        str12 = str38;
                        str13 = str39;
                        str10 = "write response, dataSource close failed";
                        str21 = "write response, delete PlayListFile failed:";
                        exc2 = e;
                        j19 = 0;
                        i16 = 0;
                        z16 = true;
                        vVar = null;
                        str35 = str14;
                        com.tencent.luggage.wxa.tg.h.a(4, str2, "other exception " + com.tencent.luggage.wxa.tg.h.a((Throwable) exc2));
                        if (lVar.w()) {
                        }
                        com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i16 + str12 + j17 + str13 + j18);
                        eVar.close();
                        if (vVar != null) {
                        }
                        kVar = this;
                        lVar2 = lVar;
                        exc3 = exc2;
                        z17 = z16;
                        eVar3 = eVar;
                        j27 = j19;
                        long j46 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                        kVar.f139690i.a(lVar2);
                        if (!lVar.t()) {
                        }
                        lVar2.c(true);
                        String q16 = lVar.q();
                        lVar.i();
                        int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                        if (!(exc3 instanceof l.f)) {
                        }
                        String str40 = str22;
                        if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                        }
                        com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                        return;
                    }
                    try {
                        vVar2 = a16.f139704d;
                        try {
                            eVar3 = a16.f139703c;
                        } catch (IOException e36) {
                            j19 = j36;
                            vVar = vVar2;
                            str19 = "write response, delete PlayListFile:";
                            bVar = bVar3;
                            j18 = j39;
                            str17 = str38;
                            str18 = str39;
                            str16 = "write response, dataSource close failed";
                            bufferedOutputStream = bufferedOutputStream4;
                            str20 = "write response, delete PlayListFile failed:";
                            exc = e36;
                            eVar3 = eVar6;
                        } catch (Exception e37) {
                            e = e37;
                            j19 = j36;
                            vVar = vVar2;
                            eVar = eVar6;
                        } catch (Throwable th10) {
                            th = th10;
                            j18 = j39;
                            vVar = vVar2;
                        }
                    } catch (IOException e38) {
                        j19 = j36;
                        eVar2 = eVar6;
                        str19 = "write response, delete PlayListFile:";
                        bVar = bVar3;
                        j18 = j39;
                        str17 = str38;
                        str18 = str39;
                        str16 = "write response, dataSource close failed";
                        bufferedOutputStream = bufferedOutputStream4;
                        str20 = "write response, delete PlayListFile failed:";
                        exc = e38;
                        eVar3 = eVar2;
                        j26 = -1;
                        vVar = null;
                        str24 = str16;
                        str23 = str20;
                        bufferedOutputStream2 = bufferedOutputStream;
                        j29 = j26;
                        j28 = j19;
                        i18 = 0;
                        z18 = true;
                        String str37222 = str19;
                        if (!(exc instanceof l.f)) {
                        }
                    } catch (Exception e39) {
                        j19 = j36;
                        eVar = eVar6;
                        str14 = str35;
                        str15 = "write response, delete PlayListFile:";
                        j18 = j39;
                        str12 = str38;
                        str13 = str39;
                        str10 = "write response, dataSource close failed";
                        str21 = "write response, delete PlayListFile failed:";
                        exc2 = e39;
                        i16 = 0;
                        z16 = true;
                        vVar = null;
                        str35 = str14;
                        com.tencent.luggage.wxa.tg.h.a(4, str2, "other exception " + com.tencent.luggage.wxa.tg.h.a((Throwable) exc2));
                        if (lVar.w()) {
                        }
                        com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i16 + str12 + j17 + str13 + j18);
                        eVar.close();
                        if (vVar != null) {
                        }
                        kVar = this;
                        lVar2 = lVar;
                        exc3 = exc2;
                        z17 = z16;
                        eVar3 = eVar;
                        j27 = j19;
                        long j462 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                        kVar.f139690i.a(lVar2);
                        if (!lVar.t()) {
                        }
                        lVar2.c(true);
                        String q162 = lVar.q();
                        lVar.i();
                        int currentTimeMillis22 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                        if (!(exc3 instanceof l.f)) {
                        }
                        String str402 = str22;
                        if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                        }
                        com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                        return;
                    }
                    try {
                        if (eVar3 != null) {
                            j19 = j36;
                        } else {
                            eVar3 = eVar6;
                            try {
                                try {
                                    if (eVar3 instanceof com.tencent.luggage.wxa.pg.c) {
                                        try {
                                            try {
                                                com.tencent.luggage.wxa.qg.e f16 = ((com.tencent.luggage.wxa.pg.c) eVar3).f();
                                                try {
                                                    if (f16 instanceof com.tencent.luggage.wxa.qg.l) {
                                                        String uri = ((com.tencent.luggage.wxa.qg.l) f16).getUri();
                                                        if (uri != null) {
                                                            StringBuilder sb6 = new StringBuilder();
                                                            j19 = j36;
                                                            sb6.append("write response, firstTimeOpenFinish:");
                                                            sb6.append(uri);
                                                            com.tencent.luggage.wxa.tg.h.a(4, str2, sb6.toString());
                                                        } else {
                                                            j19 = j36;
                                                            com.tencent.luggage.wxa.tg.h.a(4, str2, "write response, upstreamDataSource:" + f16);
                                                        }
                                                    } else {
                                                        j19 = j36;
                                                        com.tencent.luggage.wxa.tg.h.a(6, str2, "write response, abnormal upstreamDataSource " + f16);
                                                    }
                                                } catch (IOException e46) {
                                                    e = e46;
                                                    exc = e;
                                                    j18 = j39;
                                                    vVar = vVar2;
                                                    j26 = -1;
                                                    str19 = "write response, delete PlayListFile:";
                                                    bVar = bVar3;
                                                    str17 = str38;
                                                    str18 = str39;
                                                    str16 = "write response, dataSource close failed";
                                                    bufferedOutputStream = bufferedOutputStream4;
                                                    str20 = "write response, delete PlayListFile failed:";
                                                    str24 = str16;
                                                    str23 = str20;
                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                    j29 = j26;
                                                    j28 = j19;
                                                    i18 = 0;
                                                    z18 = true;
                                                    String str372222 = str19;
                                                    if (!(exc instanceof l.f)) {
                                                    }
                                                } catch (Exception e47) {
                                                    e = e47;
                                                    eVar = eVar3;
                                                    j18 = j39;
                                                    vVar = vVar2;
                                                    str14 = str35;
                                                    str15 = "write response, delete PlayListFile:";
                                                    z16 = true;
                                                    exc2 = e;
                                                    str12 = str38;
                                                    str13 = str39;
                                                    str10 = "write response, dataSource close failed";
                                                    str21 = "write response, delete PlayListFile failed:";
                                                    i16 = 0;
                                                    str35 = str14;
                                                    com.tencent.luggage.wxa.tg.h.a(4, str2, "other exception " + com.tencent.luggage.wxa.tg.h.a((Throwable) exc2));
                                                    if (lVar.w()) {
                                                    }
                                                    com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i16 + str12 + j17 + str13 + j18);
                                                    eVar.close();
                                                    if (vVar != null) {
                                                    }
                                                    kVar = this;
                                                    lVar2 = lVar;
                                                    exc3 = exc2;
                                                    z17 = z16;
                                                    eVar3 = eVar;
                                                    j27 = j19;
                                                    long j4622 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                                    kVar.f139690i.a(lVar2);
                                                    if (!lVar.t()) {
                                                    }
                                                    lVar2.c(true);
                                                    String q1622 = lVar.q();
                                                    lVar.i();
                                                    int currentTimeMillis222 = (int) (System.currentTimeMillis() - currentTimeMillis);
                                                    com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                                                    if (!(exc3 instanceof l.f)) {
                                                    }
                                                    String str4022 = str22;
                                                    if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                                                    }
                                                    com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                                                    return;
                                                }
                                            } catch (IOException e48) {
                                                e = e48;
                                                j19 = j36;
                                            } catch (Exception e49) {
                                                e = e49;
                                                j19 = j36;
                                            }
                                        } catch (Throwable th11) {
                                            th5 = th11;
                                            eVar6 = eVar3;
                                            j18 = j39;
                                            vVar = vVar2;
                                            str3 = "write response, dataSource close failed";
                                            str8 = "write response, delete PlayListFile:";
                                            str9 = "write response, delete PlayListFile failed:";
                                            exc = null;
                                            str5 = str38;
                                            str6 = str39;
                                            i3 = 0;
                                            str4 = str11;
                                            str7 = str35;
                                            com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                                            eVar6.close();
                                            i17 = 5;
                                            if (exc == null) {
                                            }
                                            if (vVar != null) {
                                            }
                                        }
                                    } else {
                                        j19 = j36;
                                        try {
                                            com.tencent.luggage.wxa.tg.h.a(4, str2, "write response, dataSource:" + eVar3);
                                        } catch (IOException e56) {
                                            e = e56;
                                            j18 = j39;
                                            vVar = vVar2;
                                            str19 = "write response, delete PlayListFile:";
                                            bVar = bVar3;
                                            str17 = str38;
                                            str18 = str39;
                                            str16 = "write response, dataSource close failed";
                                            bufferedOutputStream = bufferedOutputStream4;
                                            str20 = "write response, delete PlayListFile failed:";
                                            exc = e;
                                            j26 = -1;
                                            str24 = str16;
                                            str23 = str20;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            j29 = j26;
                                            j28 = j19;
                                            i18 = 0;
                                            z18 = true;
                                            String str3722222 = str19;
                                            if (!(exc instanceof l.f)) {
                                            }
                                        } catch (Exception e57) {
                                            e = e57;
                                            eVar = eVar3;
                                            j18 = j39;
                                            vVar = vVar2;
                                            str14 = str35;
                                            str15 = "write response, delete PlayListFile:";
                                            str12 = str38;
                                            str13 = str39;
                                            str10 = "write response, dataSource close failed";
                                            str21 = "write response, delete PlayListFile failed:";
                                            exc2 = e;
                                            i16 = 0;
                                            z16 = true;
                                            str35 = str14;
                                            com.tencent.luggage.wxa.tg.h.a(4, str2, "other exception " + com.tencent.luggage.wxa.tg.h.a((Throwable) exc2));
                                            if (lVar.w()) {
                                            }
                                            com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i16 + str12 + j17 + str13 + j18);
                                            eVar.close();
                                            if (vVar != null) {
                                            }
                                            kVar = this;
                                            lVar2 = lVar;
                                            exc3 = exc2;
                                            z17 = z16;
                                            eVar3 = eVar;
                                            j27 = j19;
                                            long j46222 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                            kVar.f139690i.a(lVar2);
                                            if (!lVar.t()) {
                                            }
                                            lVar2.c(true);
                                            String q16222 = lVar.q();
                                            lVar.i();
                                            int currentTimeMillis2222 = (int) (System.currentTimeMillis() - currentTimeMillis);
                                            com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                                            if (!(exc3 instanceof l.f)) {
                                            }
                                            String str40222 = str22;
                                            if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                                            }
                                            com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                                            return;
                                        }
                                    }
                                    c16 = eVar3.c();
                                    fileType = eVar3.getFileType();
                                    lVar.a(c16, fileType);
                                    vVar = vVar2;
                                    if (fileType.equals(bVar3)) {
                                        str28 = "write response, dataSource close failed";
                                    } else {
                                        str28 = "write response, dataSource close failed";
                                        try {
                                            com.tencent.luggage.wxa.tg.h.a(6, str2, "write response, file type should not be unknown");
                                        } catch (IOException e58) {
                                            iOException = e58;
                                            eVar4 = eVar3;
                                            bVar2 = fileType;
                                            j37 = c16;
                                            str25 = str35;
                                            bufferedOutputStream3 = bufferedOutputStream4;
                                            str19 = "write response, delete PlayListFile:";
                                            i19 = 0;
                                            z19 = true;
                                            j18 = j39;
                                            str17 = str38;
                                            str18 = str39;
                                            str26 = str28;
                                            str27 = "write response, delete PlayListFile failed:";
                                            str35 = str25;
                                            str24 = str26;
                                            str23 = str27;
                                            bufferedOutputStream2 = bufferedOutputStream3;
                                            i18 = i19;
                                            j29 = j37;
                                            exc = iOException;
                                            j28 = j19;
                                            bVar = bVar2;
                                            eVar3 = eVar4;
                                            z18 = z19;
                                            String str37222222 = str19;
                                            if (!(exc instanceof l.f)) {
                                            }
                                        } catch (Exception e59) {
                                            exc2 = e59;
                                            eVar = eVar3;
                                            j18 = j39;
                                            str14 = str35;
                                            str15 = "write response, delete PlayListFile:";
                                            i16 = 0;
                                            z16 = true;
                                            str12 = str38;
                                            str13 = str39;
                                            str10 = str28;
                                            str21 = "write response, delete PlayListFile failed:";
                                        } catch (Throwable th12) {
                                            th5 = th12;
                                            eVar6 = eVar3;
                                            str5 = str38;
                                            str6 = str39;
                                            j18 = j39;
                                            str3 = str28;
                                            str8 = "write response, delete PlayListFile:";
                                            str9 = "write response, delete PlayListFile failed:";
                                            exc = null;
                                            i3 = 0;
                                            str4 = str11;
                                            str7 = str35;
                                            com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                                            eVar6.close();
                                            i17 = 5;
                                            if (exc == null) {
                                            }
                                            if (vVar != null) {
                                            }
                                        }
                                    }
                                    String a18 = com.tencent.luggage.wxa.tg.f.a(j17, j39, c16, fileType.toString(), !com.tencent.luggage.wxa.tg.h.d(str));
                                    StringBuilder sb7 = new StringBuilder();
                                    bVar2 = fileType;
                                    sb7.append("write response, dataSource open costTimeMs:");
                                    j39 = j39;
                                    sb7.append(System.currentTimeMillis() - currentTimeMillis);
                                    com.tencent.luggage.wxa.tg.h.a(4, str2, sb7.toString());
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("write response, totalLength=");
                                    sb8.append(c16);
                                    str29 = str36;
                                    sb8.append(str29);
                                    sb8.append(com.tencent.luggage.wxa.tg.h.c(a18, null));
                                    com.tencent.luggage.wxa.tg.h.a(4, str2, sb8.toString());
                                    bufferedOutputStream3 = bufferedOutputStream4;
                                    bufferedOutputStream3.write(a18.getBytes("UTF-8"));
                                    bufferedOutputStream3.flush();
                                    long currentTimeMillis3 = System.currentTimeMillis();
                                    int i27 = 0;
                                    z17 = true;
                                    while (true) {
                                        try {
                                            z17 = !Thread.interrupted();
                                            if (z17) {
                                                break;
                                            }
                                            try {
                                                try {
                                                    if (lVar.w()) {
                                                        break;
                                                    }
                                                    str36 = str29;
                                                    j37 = c16;
                                                    bArr = bArr3;
                                                    try {
                                                        int read = eVar3.read(bArr, 0, 65536);
                                                        if (read == -1 || lVar.u()) {
                                                            break;
                                                        }
                                                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                                                        if (currentTimeMillis4 > 1000) {
                                                            str34 = str39;
                                                            try {
                                                                sb5 = new StringBuilder();
                                                                str33 = str38;
                                                            } catch (IOException e65) {
                                                                iOException = e65;
                                                                eVar4 = eVar3;
                                                                i19 = i27;
                                                                str17 = str38;
                                                                z19 = z17;
                                                                str26 = str28;
                                                                str18 = str34;
                                                                str25 = str35;
                                                                j18 = j39;
                                                                str19 = "write response, delete PlayListFile:";
                                                                str27 = "write response, delete PlayListFile failed:";
                                                                str35 = str25;
                                                                str24 = str26;
                                                                str23 = str27;
                                                                bufferedOutputStream2 = bufferedOutputStream3;
                                                                i18 = i19;
                                                                j29 = j37;
                                                                exc = iOException;
                                                                j28 = j19;
                                                                bVar = bVar2;
                                                                eVar3 = eVar4;
                                                                z18 = z19;
                                                                String str372222222 = str19;
                                                                if (!(exc instanceof l.f)) {
                                                                }
                                                            } catch (Exception e66) {
                                                                e = e66;
                                                                eVar = eVar3;
                                                                i16 = i27;
                                                                str12 = str38;
                                                                z16 = z17;
                                                                str10 = str28;
                                                            } catch (Throwable th13) {
                                                                th5 = th13;
                                                                eVar6 = eVar3;
                                                                i3 = i27;
                                                                str5 = str38;
                                                                str3 = str28;
                                                                str6 = str34;
                                                                j18 = j39;
                                                                str8 = "write response, delete PlayListFile:";
                                                                str9 = "write response, delete PlayListFile failed:";
                                                                exc = null;
                                                                str4 = str11;
                                                                str7 = str35;
                                                                com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                                                                eVar6.close();
                                                                i17 = 5;
                                                                if (exc == null) {
                                                                }
                                                                if (vVar != null) {
                                                                }
                                                            }
                                                            try {
                                                                try {
                                                                    try {
                                                                        sb5.append("write response, not receive data over ");
                                                                        sb5.append(currentTimeMillis4);
                                                                        sb5.append("ms");
                                                                        com.tencent.luggage.wxa.tg.h.a(5, str2, sb5.toString());
                                                                    } catch (Exception e67) {
                                                                        e = e67;
                                                                        eVar = eVar3;
                                                                        i16 = i27;
                                                                        z16 = z17;
                                                                        str10 = str28;
                                                                        str12 = str33;
                                                                        str13 = str34;
                                                                        str14 = str35;
                                                                        j18 = j39;
                                                                        str15 = "write response, delete PlayListFile:";
                                                                        str21 = "write response, delete PlayListFile failed:";
                                                                        exc2 = e;
                                                                        str35 = str14;
                                                                        com.tencent.luggage.wxa.tg.h.a(4, str2, "other exception " + com.tencent.luggage.wxa.tg.h.a((Throwable) exc2));
                                                                        if (lVar.w()) {
                                                                        }
                                                                        com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i16 + str12 + j17 + str13 + j18);
                                                                        eVar.close();
                                                                        if (vVar != null) {
                                                                        }
                                                                        kVar = this;
                                                                        lVar2 = lVar;
                                                                        exc3 = exc2;
                                                                        z17 = z16;
                                                                        eVar3 = eVar;
                                                                        j27 = j19;
                                                                        long j462222 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                                                        kVar.f139690i.a(lVar2);
                                                                        if (!lVar.t()) {
                                                                        }
                                                                        lVar2.c(true);
                                                                        String q162222 = lVar.q();
                                                                        lVar.i();
                                                                        int currentTimeMillis22222 = (int) (System.currentTimeMillis() - currentTimeMillis);
                                                                        com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                                                                        if (!(exc3 instanceof l.f)) {
                                                                        }
                                                                        String str402222 = str22;
                                                                        if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                                                                        }
                                                                        com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                                                                        return;
                                                                    }
                                                                } catch (IOException e68) {
                                                                    iOException = e68;
                                                                    eVar4 = eVar3;
                                                                    i19 = i27;
                                                                    z19 = z17;
                                                                    str26 = str28;
                                                                    str17 = str33;
                                                                    str18 = str34;
                                                                    str25 = str35;
                                                                    j18 = j39;
                                                                    str19 = "write response, delete PlayListFile:";
                                                                    str27 = "write response, delete PlayListFile failed:";
                                                                    str35 = str25;
                                                                    str24 = str26;
                                                                    str23 = str27;
                                                                    bufferedOutputStream2 = bufferedOutputStream3;
                                                                    i18 = i19;
                                                                    j29 = j37;
                                                                    exc = iOException;
                                                                    j28 = j19;
                                                                    bVar = bVar2;
                                                                    eVar3 = eVar4;
                                                                    z18 = z19;
                                                                    String str3722222222 = str19;
                                                                    if (!(exc instanceof l.f)) {
                                                                    }
                                                                }
                                                            } catch (Throwable th14) {
                                                                th5 = th14;
                                                                eVar6 = eVar3;
                                                                i3 = i27;
                                                                str4 = str11;
                                                                str3 = str28;
                                                                str5 = str33;
                                                                str6 = str34;
                                                                str7 = str35;
                                                                j18 = j39;
                                                                str8 = "write response, delete PlayListFile:";
                                                                str9 = "write response, delete PlayListFile failed:";
                                                                exc = null;
                                                                com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                                                                eVar6.close();
                                                                i17 = 5;
                                                                if (exc == null) {
                                                                }
                                                                if (vVar != null) {
                                                                }
                                                            }
                                                        } else {
                                                            str33 = str38;
                                                            str34 = str39;
                                                        }
                                                        currentTimeMillis3 = System.currentTimeMillis();
                                                        if (i27 == 0 && j17 == 0) {
                                                            if (eVar3 instanceof com.tencent.luggage.wxa.pg.c) {
                                                                eVar5 = ((com.tencent.luggage.wxa.pg.c) eVar3).f();
                                                            } else {
                                                                eVar5 = eVar3 instanceof com.tencent.luggage.wxa.qg.l ? eVar3 : null;
                                                            }
                                                            if (eVar5 instanceof com.tencent.luggage.wxa.qg.l) {
                                                                com.tencent.luggage.wxa.tg.i b16 = ((com.tencent.luggage.wxa.qg.l) eVar5).b();
                                                                if (b16 != null) {
                                                                    if (!b16.a(bArr)) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    gVar = gVar3;
                                                                    com.tencent.luggage.wxa.tg.h.a(6, str2, "write response, predicator is null");
                                                                    bufferedOutputStream3.write(bArr, 0, read);
                                                                    i27 += read;
                                                                    lVar.f(read);
                                                                    lVar.c(i27);
                                                                    bArr3 = bArr;
                                                                    gVar3 = gVar;
                                                                    c16 = j37;
                                                                    str38 = str33;
                                                                    str39 = str34;
                                                                    str29 = str36;
                                                                }
                                                            }
                                                        }
                                                        gVar = gVar3;
                                                        bufferedOutputStream3.write(bArr, 0, read);
                                                        i27 += read;
                                                        lVar.f(read);
                                                        lVar.c(i27);
                                                        bArr3 = bArr;
                                                        gVar3 = gVar;
                                                        c16 = j37;
                                                        str38 = str33;
                                                        str39 = str34;
                                                        str29 = str36;
                                                    } catch (IOException e69) {
                                                        e = e69;
                                                        str33 = str38;
                                                        iOException = e;
                                                        eVar4 = eVar3;
                                                        i19 = i27;
                                                        str18 = str39;
                                                        z19 = z17;
                                                        str26 = str28;
                                                        str17 = str33;
                                                        str25 = str35;
                                                        j18 = j39;
                                                        str19 = "write response, delete PlayListFile:";
                                                        str27 = "write response, delete PlayListFile failed:";
                                                        str35 = str25;
                                                        str24 = str26;
                                                        str23 = str27;
                                                        bufferedOutputStream2 = bufferedOutputStream3;
                                                        i18 = i19;
                                                        j29 = j37;
                                                        exc = iOException;
                                                        j28 = j19;
                                                        bVar = bVar2;
                                                        eVar3 = eVar4;
                                                        z18 = z19;
                                                        String str37222222222 = str19;
                                                        if (!(exc instanceof l.f)) {
                                                        }
                                                    }
                                                } catch (Exception e75) {
                                                    e = e75;
                                                    eVar = eVar3;
                                                    i16 = i27;
                                                    str12 = str38;
                                                    str13 = str39;
                                                    z16 = z17;
                                                    str10 = str28;
                                                } catch (Throwable th15) {
                                                    th5 = th15;
                                                    eVar6 = eVar3;
                                                    str5 = str38;
                                                    str6 = str39;
                                                    j18 = j39;
                                                    str8 = "write response, delete PlayListFile:";
                                                    str9 = "write response, delete PlayListFile failed:";
                                                    exc = null;
                                                    i3 = i27;
                                                    str4 = str11;
                                                    str3 = str28;
                                                    str7 = str35;
                                                    com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                                                    eVar6.close();
                                                    i17 = 5;
                                                    if (exc == null) {
                                                    }
                                                    if (vVar != null) {
                                                    }
                                                }
                                            } catch (IOException e76) {
                                                e = e76;
                                                str33 = str38;
                                                str36 = str29;
                                                j37 = c16;
                                            }
                                        } catch (IOException e77) {
                                            e = e77;
                                            eVar4 = eVar3;
                                            i19 = i27;
                                            str18 = str39;
                                            str36 = str29;
                                            j37 = c16;
                                            z19 = z17;
                                            str25 = str35;
                                            j18 = j39;
                                            str19 = "write response, delete PlayListFile:";
                                            str27 = "write response, delete PlayListFile failed:";
                                            str17 = str38;
                                            str26 = str28;
                                        } catch (Exception e78) {
                                            e = e78;
                                            com.tencent.luggage.wxa.qg.e eVar7 = eVar3;
                                            int i28 = i27;
                                            str12 = str38;
                                            str13 = str39;
                                            z16 = z17;
                                            str10 = str28;
                                        } catch (Throwable th16) {
                                            com.tencent.luggage.wxa.qg.e eVar8 = eVar3;
                                            th5 = th16;
                                            str5 = str38;
                                            str6 = str39;
                                            i3 = i27;
                                            str3 = str28;
                                            j18 = j39;
                                            str8 = "write response, delete PlayListFile:";
                                            str9 = "write response, delete PlayListFile failed:";
                                            exc = null;
                                            eVar6 = eVar8;
                                        }
                                    }
                                    str33 = str38;
                                    str34 = str39;
                                    if (z17) {
                                        c17 = '\u0100';
                                        try {
                                            lVar.e(256);
                                            com.tencent.luggage.wxa.tg.h.a(4, str2, "write response, videoRequest is interrupted");
                                        } catch (IOException e79) {
                                            iOException = e79;
                                            eVar4 = eVar3;
                                            i19 = i27;
                                            z19 = z17;
                                            str26 = str28;
                                            str17 = str33;
                                            str18 = str34;
                                            str25 = str35;
                                            j18 = j39;
                                            str19 = "write response, delete PlayListFile:";
                                            str27 = "write response, delete PlayListFile failed:";
                                            str35 = str25;
                                            str24 = str26;
                                            str23 = str27;
                                            bufferedOutputStream2 = bufferedOutputStream3;
                                            i18 = i19;
                                            j29 = j37;
                                            exc = iOException;
                                            j28 = j19;
                                            bVar = bVar2;
                                            eVar3 = eVar4;
                                            z18 = z19;
                                            String str372222222222 = str19;
                                            if (!(exc instanceof l.f)) {
                                            }
                                        }
                                    } else {
                                        c17 = '\u0100';
                                    }
                                    if (lVar.w()) {
                                        lVar.a();
                                    }
                                    bufferedOutputStream3.flush();
                                    bufferedOutputStream3.close();
                                    com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i27 + str33 + j17 + str34 + j39);
                                    eVar3.close();
                                    int i29 = 5;
                                    socket.close();
                                    if (vVar != null && vVar.q() && vVar.e()) {
                                        com.tencent.luggage.wxa.tg.h.a(4, str2, "write response, delete PlayListFile:" + vVar.toString());
                                        if (vVar.g().startsWith(com.tencent.luggage.wxa.og.a.a().l()) && !vVar.d()) {
                                            com.tencent.luggage.wxa.tg.h.a(5, str2, "write response, delete PlayListFile failed:" + vVar.toString());
                                        }
                                    }
                                    kVar = this;
                                    lVar2 = lVar;
                                    j27 = j19;
                                    exc3 = null;
                                } catch (IOException e85) {
                                    e = e85;
                                    j19 = j36;
                                    vVar = vVar2;
                                    str19 = "write response, delete PlayListFile:";
                                    bVar = bVar3;
                                    j18 = j39;
                                    str17 = str38;
                                    str18 = str39;
                                    str16 = "write response, dataSource close failed";
                                    bufferedOutputStream = bufferedOutputStream4;
                                    str20 = "write response, delete PlayListFile failed:";
                                    exc = e;
                                    j26 = -1;
                                    str24 = str16;
                                    str23 = str20;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    j29 = j26;
                                    j28 = j19;
                                    i18 = 0;
                                    z18 = true;
                                    String str3722222222222 = str19;
                                    if (!(exc instanceof l.f)) {
                                    }
                                } catch (Exception e86) {
                                    e = e86;
                                    eVar = eVar3;
                                    j19 = j36;
                                    vVar = vVar2;
                                    str14 = str35;
                                    str15 = "write response, delete PlayListFile:";
                                    j18 = j39;
                                    str12 = str38;
                                    str13 = str39;
                                    str10 = "write response, dataSource close failed";
                                    str21 = "write response, delete PlayListFile failed:";
                                    exc2 = e;
                                    i16 = 0;
                                    z16 = true;
                                    str35 = str14;
                                    com.tencent.luggage.wxa.tg.h.a(4, str2, "other exception " + com.tencent.luggage.wxa.tg.h.a((Throwable) exc2));
                                    if (lVar.w()) {
                                    }
                                    com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i16 + str12 + j17 + str13 + j18);
                                    eVar.close();
                                    if (vVar != null) {
                                    }
                                    kVar = this;
                                    lVar2 = lVar;
                                    exc3 = exc2;
                                    z17 = z16;
                                    eVar3 = eVar;
                                    j27 = j19;
                                    long j4622222 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                    kVar.f139690i.a(lVar2);
                                    if (!lVar.t()) {
                                    }
                                    lVar2.c(true);
                                    String q1622222 = lVar.q();
                                    lVar.i();
                                    int currentTimeMillis222222 = (int) (System.currentTimeMillis() - currentTimeMillis);
                                    com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                                    if (!(exc3 instanceof l.f)) {
                                    }
                                    String str4022222 = str22;
                                    if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                                    }
                                    com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                                    return;
                                }
                                long j46222222 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                                kVar.f139690i.a(lVar2);
                                if (!lVar.t()) {
                                    lVar.c();
                                } else if (z17) {
                                    lVar2.e(16);
                                }
                                lVar2.c(true);
                                String q16222222 = lVar.q();
                                lVar.i();
                                int currentTimeMillis2222222 = (int) (System.currentTimeMillis() - currentTimeMillis);
                                com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                                if (!(exc3 instanceof l.f)) {
                                    str22 = "HttpDataSource.InvalidResponseCodeException";
                                } else if (exc3 instanceof l.e) {
                                    str22 = "HttpDataSource.InvalidContentTypeException";
                                } else if (exc3 instanceof l.d) {
                                    str22 = "HttpDataSource.InvalidContentException";
                                } else if (exc3 instanceof l.g) {
                                    str22 = "HttpDataSource.MalformedResponseException";
                                } else if (exc3 instanceof l.b) {
                                    str22 = "HttpDataSource.InterruptConnectServerException";
                                } else if (exc3 instanceof l.c) {
                                    str22 = "HttpDataSource.InterruptReadException";
                                } else if (exc3 instanceof l.h) {
                                    str22 = "HttpDataSource.UnableConnectServerException";
                                } else if (exc3 instanceof l.a) {
                                    str22 = "HttpDataSource.HttpDataSourceException";
                                } else if ((eVar3 instanceof com.tencent.luggage.wxa.qg.k) && (exc3 instanceof k.a)) {
                                    str22 = "FileDataSource.FileDataSourceException";
                                } else {
                                    str22 = exc3 instanceof NoRouteToHostException ? "NoRouteToHostException" : "";
                                }
                                String str40222222 = str22;
                                if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                                    com.tencent.luggage.wxa.og.a.a().m().a(q16222222, str, lVar.i(), lVar.k(), lVar.j(), lVar.p(), lVar.d(), lVar.l(), lVar.f(), j27, j46222222, com.tencent.luggage.wxa.tg.h.a(j27, j46222222), str40222222, currentTimeMillis2222222);
                                }
                                com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                                return;
                            } catch (Throwable th17) {
                                j18 = j39;
                                vVar = vVar2;
                                th5 = th17;
                                str5 = str38;
                                str3 = "write response, dataSource close failed";
                                eVar6 = eVar3;
                                str8 = "write response, delete PlayListFile:";
                                str9 = "write response, delete PlayListFile failed:";
                                exc = null;
                                str4 = str11;
                                str6 = str39;
                                str7 = str35;
                                i3 = 0;
                                com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
                                eVar6.close();
                                i17 = 5;
                                if (exc == null) {
                                }
                                if (vVar != null) {
                                }
                            }
                        }
                        c16 = eVar3.c();
                        fileType = eVar3.getFileType();
                        lVar.a(c16, fileType);
                        vVar = vVar2;
                        if (fileType.equals(bVar3)) {
                        }
                        String a182 = com.tencent.luggage.wxa.tg.f.a(j17, j39, c16, fileType.toString(), !com.tencent.luggage.wxa.tg.h.d(str));
                        StringBuilder sb72 = new StringBuilder();
                        bVar2 = fileType;
                        sb72.append("write response, dataSource open costTimeMs:");
                        j39 = j39;
                        sb72.append(System.currentTimeMillis() - currentTimeMillis);
                        com.tencent.luggage.wxa.tg.h.a(4, str2, sb72.toString());
                        StringBuilder sb82 = new StringBuilder();
                        sb82.append("write response, totalLength=");
                        sb82.append(c16);
                        str29 = str36;
                        sb82.append(str29);
                        sb82.append(com.tencent.luggage.wxa.tg.h.c(a182, null));
                        com.tencent.luggage.wxa.tg.h.a(4, str2, sb82.toString());
                        bufferedOutputStream3 = bufferedOutputStream4;
                        bufferedOutputStream3.write(a182.getBytes("UTF-8"));
                        bufferedOutputStream3.flush();
                        long currentTimeMillis32 = System.currentTimeMillis();
                        int i272 = 0;
                        z17 = true;
                        while (true) {
                            z17 = !Thread.interrupted();
                            if (z17) {
                            }
                            bArr3 = bArr;
                            gVar3 = gVar;
                            c16 = j37;
                            str38 = str33;
                            str39 = str34;
                            str29 = str36;
                        }
                        str33 = str38;
                        str34 = str39;
                        if (z17) {
                        }
                        if (lVar.w()) {
                        }
                        bufferedOutputStream3.flush();
                        bufferedOutputStream3.close();
                        com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i272 + str33 + j17 + str34 + j39);
                        eVar3.close();
                        int i292 = 5;
                        socket.close();
                        if (vVar != null) {
                            com.tencent.luggage.wxa.tg.h.a(4, str2, "write response, delete PlayListFile:" + vVar.toString());
                            if (vVar.g().startsWith(com.tencent.luggage.wxa.og.a.a().l())) {
                                com.tencent.luggage.wxa.tg.h.a(5, str2, "write response, delete PlayListFile failed:" + vVar.toString());
                            }
                        }
                        kVar = this;
                        lVar2 = lVar;
                        j27 = j19;
                        exc3 = null;
                        long j462222222 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
                        kVar.f139690i.a(lVar2);
                        if (!lVar.t()) {
                        }
                        lVar2.c(true);
                        String q162222222 = lVar.q();
                        lVar.i();
                        int currentTimeMillis22222222 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
                        if (!(exc3 instanceof l.f)) {
                        }
                        String str402222222 = str22;
                        if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                        }
                        com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
                        return;
                    } catch (Throwable th18) {
                        th = th18;
                        com.tencent.luggage.wxa.qg.e eVar9 = eVar3;
                        j18 = j39;
                        vVar = vVar2;
                    }
                } catch (Throwable th19) {
                    j18 = j39;
                    th5 = th19;
                    str5 = str38;
                    str3 = "write response, dataSource close failed";
                    str8 = "write response, delete PlayListFile:";
                    str9 = "write response, delete PlayListFile failed:";
                    exc = null;
                    vVar = null;
                }
            }
            com.tencent.luggage.wxa.tg.h.a(4, str2, "other exception " + com.tencent.luggage.wxa.tg.h.a((Throwable) exc2));
            if (lVar.w()) {
                lVar.a();
            }
            com.tencent.luggage.wxa.tg.h.a(4, str2, str11 + i16 + str12 + j17 + str13 + j18);
            eVar.close();
            if (vVar != null && vVar.q() && vVar.e()) {
                com.tencent.luggage.wxa.tg.h.a(4, str2, str15 + vVar.toString());
                if (vVar.g().startsWith(com.tencent.luggage.wxa.og.a.a().l()) && !vVar.d()) {
                    com.tencent.luggage.wxa.tg.h.a(5, str2, str21 + vVar.toString());
                }
            }
            kVar = this;
            lVar2 = lVar;
            exc3 = exc2;
            z17 = z16;
            eVar3 = eVar;
            j27 = j19;
            long j4622222222 = VideoResultCode.ERROR_DOWNLOAD_INVALID_SUB_RET_CODE;
            kVar.f139690i.a(lVar2);
            if (!lVar.t()) {
            }
            lVar2.c(true);
            String q1622222222 = lVar.q();
            lVar.i();
            int currentTimeMillis222222222 = (int) (System.currentTimeMillis() - currentTimeMillis);
            com.tencent.luggage.wxa.k0.d.a(kVar.f139691j.get(str31));
            if (!(exc3 instanceof l.f)) {
            }
            String str4022222222 = str22;
            if (com.tencent.luggage.wxa.og.a.a().m() != null) {
            }
            com.tencent.luggage.wxa.tg.h.a(4, str2, "write response finish");
            return;
        } catch (Throwable th20) {
            th5 = th20;
            str9 = str21;
            exc = exc2;
            i3 = i16;
            eVar6 = eVar;
            str5 = str12;
            str6 = str13;
            str8 = str15;
            str3 = str10;
            str4 = str11;
            str7 = str35;
            com.tencent.luggage.wxa.tg.h.a(4, str2, str4 + i3 + str5 + j17 + str6 + j18);
            eVar6.close();
            i17 = 5;
            if (exc == null) {
            }
            if (vVar != null) {
            }
        }
        str35 = str14;
    }

    public final int a(Throwable th5) {
        if (th5.toString().toLowerCase().contains("unexpected end of stream")) {
            return 6;
        }
        return (th5.getCause() == null || !(th5.getCause() instanceof SocketTimeoutException)) ? 7 : 14;
    }

    public long a(String str) {
        if (TextUtils.isEmpty(str) || this.f139684c == null) {
            return 0L;
        }
        return this.f139684c.b(com.tencent.luggage.wxa.tg.h.h(str));
    }
}
