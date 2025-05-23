package com.tencent.luggage.wxa.zi;

import android.net.http.Headers;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.af.i;
import com.tencent.luggage.wxa.bo.e;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.luggage.wxa.yi.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements Runnable {
    public volatile long C;
    public long D;
    public String E;
    public HttpURLConnection F;
    public String G;
    public String H;
    public final String I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;

    /* renamed from: b, reason: collision with root package name */
    public d f146705b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.zi.a f146706c;

    /* renamed from: f, reason: collision with root package name */
    public String f146709f;

    /* renamed from: g, reason: collision with root package name */
    public String f146710g;

    /* renamed from: h, reason: collision with root package name */
    public String f146711h;

    /* renamed from: j, reason: collision with root package name */
    public Map f146713j;

    /* renamed from: l, reason: collision with root package name */
    public SSLContext f146715l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f146716m;

    /* renamed from: a, reason: collision with root package name */
    public int f146704a = 15;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f146707d = false;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f146708e = false;

    /* renamed from: i, reason: collision with root package name */
    public String f146712i = QzoneWebMusicJsPlugin.EVENT_UNKOWN;

    /* renamed from: k, reason: collision with root package name */
    public int f146714k = 60000;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends com.tencent.luggage.wxa.jq.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "AppBrandDownloadWorker#TimerTask";
        }

        @Override // java.lang.Runnable
        public void run() {
            w.b("MicroMsg.AppBrandDownloadWorker", "call cronet time out taskid:%s,timeout:%d,url:%s", b.this.f(), Integer.valueOf(b.this.f146714k), b.this.g());
            if (!b.this.f146708e) {
                b.this.f146708e = true;
                com.tencent.luggage.wxa.zi.a aVar = b.this.f146706c;
                String str = b.this.f146710g;
                String str2 = b.this.f146709f;
                com.tencent.luggage.wxa.af.c cVar = e.f121310f;
                aVar.a(str, str2, cVar.f121278b, cVar.f121277a);
            } else {
                w.b("MicroMsg.AppBrandDownloadWorker", "call cronet time out already callback");
            }
            q.a(1197L, 6L, 1L);
            if (!w0.c(b.this.G)) {
                CronetLogic.cancelCronetTask(b.this.G);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f146723a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f146724b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f146725c = -1;

        public c() {
        }
    }

    public b(d dVar, String str, String str2, String str3, String str4, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, com.tencent.luggage.wxa.zi.a aVar) {
        this.f146705b = dVar;
        this.f146709f = str;
        this.f146710g = str2;
        this.f146711h = str3;
        this.f146706c = aVar;
        this.I = str4;
        this.J = z16;
        this.K = z17;
        this.L = z18;
        this.M = z19;
        this.N = z26;
    }

    public static /* synthetic */ int d(b bVar) {
        int i3 = bVar.f146704a;
        bVar.f146704a = i3 - 1;
        return i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (!URLUtil.isHttpsUrl(this.f146709f) && !URLUtil.isHttpUrl(this.f146709f)) {
            this.f146706c.a(this.f146710g, this.f146709f, "downloadFile protocol must be http or https", i.f121360f.f121277a);
            return;
        }
        ArrayList arrayList = this.f146716m;
        if (arrayList != null && !q.c(arrayList, this.f146709f)) {
            try {
                str = new URL(this.f146709f).getHost();
            } catch (MalformedURLException e16) {
                w.a("MicroMsg.AppBrandDownloadWorker", e16, "get redirect url host fail Exception", new Object[0]);
                str = null;
            }
            if (!w0.c(str)) {
                this.f146706c.a(this.f146710g, this.f146709f, "redirect url not in domain list:" + str, i.f121357c.f121277a);
            } else {
                this.f146706c.a(this.f146710g, this.f146709f, "redirect url not in domain list", i.f121357c.f121277a);
            }
            w.d("MicroMsg.AppBrandDownloadWorker", "not in domain url %s", this.f146709f);
            return;
        }
        if (this.J) {
            b();
        } else {
            c();
        }
    }

    public void b(boolean z16) {
        this.f146707d = z16;
    }

    public void c(int i3) {
        this.C = i3 * 1048576;
    }

    public void d(int i3) {
        this.f146714k = i3;
    }

    public String e() {
        return this.H;
    }

    public String f() {
        return this.E;
    }

    public String g() {
        return this.f146709f;
    }

    public final void b() {
        this.D = System.currentTimeMillis();
        c cVar = new c();
        if (!this.f146707d) {
            this.f146706c.a(this.f146710g, this.f146709f, "force stop", i.f121359e.f121277a);
            if (w0.c(this.f146711h)) {
                ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(this.f146705b.getAppId(), e(), "GET", g(), 0L, 0L, 0, 2, d(), System.currentTimeMillis(), this.f146710g, this.f146712i);
                return;
            } else {
                ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(this.f146705b.getAppId(), e(), "GET", g(), 0L, 0L, 0, 2, d(), System.currentTimeMillis(), this.f146711h, this.f146712i);
                return;
            }
        }
        this.f146706c.a(this.f146710g, this.f146709f);
        q.a(1197L, 0L, 1L);
        a aVar = new a();
        C6989b c6989b = new C6989b(aVar, cVar);
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.url = this.f146709f;
        cronetRequestParams.taskId = this.E;
        cronetRequestParams.followRedirect = false;
        cronetRequestParams.savePath = this.f146710g;
        cronetRequestParams.method = "GET";
        cronetRequestParams.needWriteLocal = true;
        cronetRequestParams.useHttp2 = this.K;
        cronetRequestParams.useQuic = this.L;
        cronetRequestParams.useMemoryCache = this.M;
        Map<String, String> map = this.f146713j;
        cronetRequestParams.miniPrograms = true;
        cronetRequestParams.maxRetryCount = 0;
        if (map.containsKey("Accept-Encoding")) {
            w.d("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest Accept-Encoding:%s", map.get("Accept-Encoding"));
        } else {
            map.put("Accept-Encoding", "gzip,compress,br,deflate");
        }
        map.put("User-Agent", this.I);
        cronetRequestParams.makeRequestHeader(map);
        this.f146706c.a(q.a(q.b(map), 1));
        cronetRequestParams.taskType = 2;
        h.f146825d.a(aVar, this.f146714k);
        CronetLogic.CronetHttpsCreateResult startCronetDownloadTask = CronetLogic.startCronetDownloadTask(cronetRequestParams, c6989b);
        w.d("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest createRet is %d, taskId %s,CronetRequestId:%s,url:%s,filename:%s", Integer.valueOf(startCronetDownloadTask.createRet), this.E, startCronetDownloadTask.taskId, this.f146709f, this.f146710g);
        if (startCronetDownloadTask.createRet != 0) {
            if (this.f146708e) {
                return;
            }
            this.f146708e = true;
            this.f146706c.a(this.f146710g, this.f146709f, "call request error:" + startCronetDownloadTask.createRet, i.f121359e.f121277a);
            return;
        }
        this.G = startCronetDownloadTask.taskId;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final void c() {
        /*
            Method dump skipped, instructions count: 8781
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.wxa.zi.b.c():void");
    }

    public int d() {
        return (int) (System.currentTimeMillis() - this.D);
    }

    public void a(Map map) {
        this.f146713j = map;
    }

    public void a(ArrayList arrayList) {
        this.f146716m = arrayList;
    }

    public void a(SSLContext sSLContext) {
        this.f146715l = sSLContext;
    }

    public void a() {
        this.f146707d = false;
        HttpURLConnection httpURLConnection = this.F;
        if (httpURLConnection != null) {
            try {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException e16) {
                    w.b("MicroMsg.AppBrandDownloadWorker", e16.getMessage());
                }
                this.F.disconnect();
            } catch (Exception e17) {
                w.a("MicroMsg.AppBrandDownloadWorker", e17, "abortTask Exception", new Object[0]);
            }
        }
        if (w0.c(this.G)) {
            return;
        }
        CronetLogic.cancelCronetTask(this.G);
    }

    public final String a(String str, String str2) {
        e.a a16 = e.a.a(str);
        if (a16 == null) {
            return com.tencent.luggage.wxa.bo.e.d(str2);
        }
        if (a16.f123092a.contains("application/octet-stream")) {
            String d16 = com.tencent.luggage.wxa.bo.e.d(str2);
            return w0.c(d16) ? a16.f123092a : d16;
        }
        return a16.f123092a;
    }

    public final void a(int i3) {
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(1197L, (i3 < 100 || i3 >= 200) ? 200 == i3 ? 21 : (i3 <= 200 || i3 >= 300) ? 302 == i3 ? 23 : (i3 < 300 || i3 >= 400) ? 404 == i3 ? 25 : (i3 < 400 || i3 >= 500) ? i3 >= 500 ? 27 : 28 : 26 : 24 : 22 : 20, 1L, false);
    }

    public final void a(long j3, long j16) {
        int i3;
        if (j3 <= 0 || j16 <= 0) {
            w.d("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d return", Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        double d16 = (j3 / j16) * 0.9765625d;
        if (h0.f(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 30;
        } else if (h0.g(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 31;
        } else if (h0.h(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 32;
        } else {
            i3 = h0.l(com.tencent.luggage.wxa.tn.z.c()) ? 33 : 34;
        }
        q.a(1197L, i3, (long) d16);
        w.a("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(j3), Long.valueOf(j16), Double.valueOf(d16), Integer.valueOf(i3));
    }

    public void a(String str) {
        this.H = str;
    }

    public final void b(int i3) {
        int i16 = (i3 < 100 || i3 >= 200) ? 200 == i3 ? 21 : (i3 <= 200 || i3 >= 300) ? 302 == i3 ? 23 : (i3 < 300 || i3 >= 400) ? 404 == i3 ? 25 : (i3 < 400 || i3 >= 500) ? i3 >= 500 ? 27 : 28 : 26 : 24 : 22 : 20;
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(437L, i16, 1L, false);
        w.a("MicroMsg.AppBrandDownloadWorker", "reportStatusCode:%d, key:%d", Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public final void b(long j3, long j16) {
        int i3;
        if (j3 <= 0 || j16 <= 0) {
            w.d("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d return", Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        double d16 = (j3 / j16) * 0.9765625d;
        if (h0.f(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 30;
        } else if (h0.g(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 31;
        } else if (h0.h(com.tencent.luggage.wxa.tn.z.c())) {
            i3 = 32;
        } else {
            i3 = h0.l(com.tencent.luggage.wxa.tn.z.c()) ? 33 : 34;
        }
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(437L, i3, (long) d16, false);
        w.a("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(j3), Long.valueOf(j16), Double.valueOf(d16), Integer.valueOf(i3));
    }

    public void b(String str) {
        this.E = str;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zi.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6989b implements CronetLogic.CronetTaskCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.jq.b f146718a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f146719b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zi.b$b$a */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CronetLogic.CronetTaskResult f146721a;

            public a(CronetLogic.CronetTaskResult cronetTaskResult) {
                this.f146721a = cronetTaskResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                CronetLogic.CronetTaskResult cronetTaskResult = this.f146721a;
                int i3 = (int) cronetTaskResult.totalReceiveByte;
                int i16 = cronetTaskResult.statusCode;
                String str2 = "";
                CronetLogic.CronetTaskResult cronetTaskResult2 = this.f146721a;
                w.d("MicroMsg.AppBrandDownloadWorker", "onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s", Integer.valueOf(cronetTaskResult.errorCode), cronetTaskResult2.errorMsg, Integer.valueOf(cronetTaskResult2.statusCode), Long.valueOf(this.f146721a.totalReceiveByte), b.this.E, b.this.G);
                if (this.f146721a.errorCode == 0) {
                    b.this.a(i16);
                    for (Map.Entry<String, String> entry : this.f146721a.getHeaderMap().entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key.equalsIgnoreCase("Content-Type") || key.equalsIgnoreCase("content-type")) {
                            b bVar = b.this;
                            str2 = bVar.a(value, bVar.f146709f);
                        }
                    }
                    if (i16 != 200 && q.e(i16)) {
                        String str3 = this.f146721a.newLocation;
                        if (!TextUtils.isEmpty(str3)) {
                            if (b.d(b.this) <= 0) {
                                w.h("MicroMsg.AppBrandDownloadWorker", "reach the max redirect count(%d)", 15);
                                if (!b.this.f146708e) {
                                    b.this.f146708e = true;
                                    if (b.this.N) {
                                        b.this.f146706c.a(b.this.f146710g, str2, b.this.f146709f, i16, 0L, q.a(this.f146721a.webPageProfile));
                                    } else {
                                        b.this.f146706c.a(b.this.f146710g, str2, b.this.f146709f, i16, 0L, null);
                                    }
                                    ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(b.this.f146705b.getAppId(), b.this.e(), "GET", b.this.g(), 0L, i3, i16, 1, b.this.d(), System.currentTimeMillis(), b.this.f146710g, str2);
                                    q.a(1197L, 10L, 1L);
                                    q.a(1197L, 12L, System.currentTimeMillis() - b.this.D);
                                    return;
                                }
                                w.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted max redirect already callback");
                                return;
                            }
                            w.d("MicroMsg.AppBrandDownloadWorker", "redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(b.this.f146704a), b.this.f146709f, str3);
                            b.this.f146709f = str3;
                            b.this.run();
                            return;
                        }
                    }
                    if (!b.this.f146708e) {
                        b.this.f146708e = true;
                        if (!b.this.f146707d) {
                            str = "MicroMsg.AppBrandDownloadWorker";
                            b.this.f146706c.a(b.this.f146710g, b.this.f146709f, "force stop", i.f121359e.f121277a);
                        } else {
                            if (b.this.N) {
                                str = "MicroMsg.AppBrandDownloadWorker";
                                b.this.f146706c.a(b.this.f146710g, str2, b.this.f146709f, i16, i3, q.a(this.f146721a.webPageProfile));
                            } else {
                                str = "MicroMsg.AppBrandDownloadWorker";
                                b.this.f146706c.a(b.this.f146710g, str2, b.this.f146709f, i16, i3, null);
                            }
                            b.this.a(this.f146721a.totalReceiveByte, r1.d());
                            C6989b.this.f146719b.f146723a = true;
                        }
                        w.d(str, "cronet download file finished taskid:%s,CronetRequestId:%s,contentType:%s", b.this.E, b.this.G, str2);
                        b.this.f146706c.a(b.this.f());
                        ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(b.this.f146705b.getAppId(), b.this.e(), "GET", b.this.g(), 0L, i3, i16, 1, b.this.d(), System.currentTimeMillis(), b.this.f146710g, str2);
                        q.a(1197L, 10L, 1L);
                        q.a(1197L, 12L, System.currentTimeMillis() - b.this.D);
                        return;
                    }
                    w.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted already callback");
                    return;
                }
                if (!b.this.f146708e) {
                    b.this.f146708e = true;
                    b.this.f146706c.a(b.this.f146710g, b.this.f146709f, "download fail:" + this.f146721a.errorCode + ":" + this.f146721a.errorMsg, i.f121356b.f121277a);
                    ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(b.this.f146705b.getAppId(), b.this.e(), "GET", b.this.g(), 0L, (long) i3, i16, 2, b.this.d(), System.currentTimeMillis(), b.this.f146710g, "");
                    q.a(1197L, 11L, 1L);
                    q.a(1197L, 13L, System.currentTimeMillis() - b.this.D);
                    return;
                }
                w.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted downloadFile fail already callback");
            }
        }

        public C6989b(com.tencent.luggage.wxa.jq.b bVar, c cVar) {
            this.f146718a = bVar;
            this.f146719b = cVar;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i3, String str) {
            long j3;
            w.d("MicroMsg.AppBrandDownloadWorker", "cronet file download onCronetReceiveHeader status %d,protocol %s,taskid:%s,CronetRequestId:%s", Integer.valueOf(i3), str, b.this.E, b.this.G);
            Map<String, List<String>> headerList = CronetLogic.getHeaderList(responseHeader);
            JSONObject a16 = q.a(headerList, 2);
            try {
                if (!w0.c(str)) {
                    a16.put(AudienceReportConst.PROTOCOL, str);
                }
            } catch (JSONException e16) {
                w.a("MicroMsg.AppBrandDownloadWorker", e16, "JSONException: download onCronetReceiveHeader put protocol error", new Object[0]);
            }
            b.this.f146706c.a(a16);
            Iterator<Map.Entry<String, List<String>>> it = headerList.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, List<String>> next = it.next();
                    String key = next.getKey();
                    List<String> value = next.getValue();
                    if (!w0.c(key) && value != null && !value.isEmpty()) {
                        if (key.equals("Content-Length")) {
                            w.d("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader Content-Length:%s", value.get(0));
                            j3 = Long.parseLong(value.get(0));
                            break;
                        }
                        if (key.equals(Headers.CONTENT_LEN)) {
                            w.d("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader content-length:%s", value.get(0));
                            j3 = Long.parseLong(value.get(0));
                            break;
                        }
                    }
                } else {
                    j3 = 0;
                    break;
                }
            }
            if (j3 > 0) {
                q.a(1197L, 16L, j3);
            } else {
                w.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader contentLength fail");
            }
            if (j3 <= 0 || b.this.C <= 0 || j3 <= b.this.C) {
                return 0;
            }
            w.d("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader, contentLength %d exceed limit", Long.valueOf(j3));
            if (!b.this.f146708e) {
                b.this.f146708e = true;
                CronetLogic.cancelCronetTask(b.this.G);
                com.tencent.luggage.wxa.zi.a aVar = b.this.f146706c;
                String str2 = b.this.f146710g;
                String str3 = b.this.f146709f;
                com.tencent.luggage.wxa.af.c cVar = i.H;
                aVar.a(str2, str3, cVar.f121278b, cVar.f121277a);
            } else {
                w.b("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader max file size already callback");
            }
            com.tencent.luggage.wxa.jq.b bVar = this.f146718a;
            if (bVar != null) {
                bVar.b();
                w.d("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader exceed max file size TimerTask cancel");
                return -1;
            }
            return -1;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult, String str2) {
            com.tencent.luggage.wxa.jq.b bVar = this.f146718a;
            if (bVar != null) {
                bVar.b();
            }
            h.f146825d.execute(new a(cronetTaskResult));
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
            if (q.a(b.this.f146705b)) {
                w.h("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged shouldStopTask taskid %s,CronetRequestId:%s", b.this.E, b.this.G);
                if (!b.this.f146708e) {
                    b.this.f146708e = true;
                    CronetLogic.cancelCronetTask(b.this.G);
                    com.tencent.luggage.wxa.zi.a aVar = b.this.f146706c;
                    String str2 = b.this.f146710g;
                    String str3 = b.this.f146709f;
                    com.tencent.luggage.wxa.af.c cVar = i.f121358d;
                    aVar.a(str2, str3, cVar.f121278b, cVar.f121277a);
                } else {
                    w.b("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged already callback");
                }
                com.tencent.luggage.wxa.jq.b bVar = this.f146718a;
                if (bVar != null) {
                    bVar.b();
                    w.d("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged shouldStopTask TimerTask cancel");
                    return;
                }
                return;
            }
            if (cronetDownloadProgress.currentWriteByte > 0 && b.this.C > 0 && (cronetDownloadProgress.currentWriteByte > b.this.C || cronetDownloadProgress.totalByte > b.this.C)) {
                if (!b.this.f146708e) {
                    w.d("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged writeByte %d or totalByte %d exceed limit,taskid %s,CronetRequestId:%s", Long.valueOf(cronetDownloadProgress.currentWriteByte), Long.valueOf(cronetDownloadProgress.totalByte), b.this.E, b.this.G);
                    b.this.f146708e = true;
                    CronetLogic.cancelCronetTask(b.this.G);
                    com.tencent.luggage.wxa.zi.a aVar2 = b.this.f146706c;
                    String str4 = b.this.f146710g;
                    String str5 = b.this.f146709f;
                    com.tencent.luggage.wxa.af.c cVar2 = i.H;
                    aVar2.a(str4, str5, cVar2.f121278b, cVar2.f121277a);
                    com.tencent.luggage.wxa.jq.b bVar2 = this.f146718a;
                    if (bVar2 != null) {
                        bVar2.b();
                        w.d("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged exceed max file size TimerTask cancel");
                        return;
                    }
                    return;
                }
                w.b("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged max file size already callback");
                return;
            }
            if (cronetDownloadProgress.totalByte > 0 && b.this.f146707d) {
                long j3 = cronetDownloadProgress.totalByte;
                if (j3 > 0) {
                    long j16 = cronetDownloadProgress.currentWriteByte;
                    if (j16 > j3) {
                        this.f146719b.f146724b = 100;
                    } else {
                        this.f146719b.f146724b = (int) ((j16 * 100) / j3);
                    }
                    c cVar3 = this.f146719b;
                    if (cVar3.f146725c != cVar3.f146724b) {
                        b.this.f146706c.a(b.this.f146710g, b.this.f146709f, this.f146719b.f146724b, cronetDownloadProgress.currentWriteByte, cronetDownloadProgress.totalByte);
                        c cVar4 = this.f146719b;
                        cVar4.f146725c = cVar4.f146724b;
                    }
                } else {
                    b.this.f146706c.a(b.this.f146710g, b.this.f146709f, this.f146719b.f146724b, cronetDownloadProgress.currentWriteByte, 0L);
                }
                if (this.f146719b.f146724b == 100) {
                    w.d("MicroMsg.AppBrandDownloadWorker", "cronet download size %d, totalSize %d, percent = %d", Long.valueOf(cronetDownloadProgress.currentWriteByte), Long.valueOf(cronetDownloadProgress.totalByte), Integer.valueOf(this.f146719b.f146724b));
                }
            }
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveChunkedData(CronetLogic.ChunkedData chunkedData, long j3) {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveUploadProgress(long j3, long j16) {
        }
    }
}
