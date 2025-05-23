package com.tencent.luggage.wxa.yi;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.hn.pi;
import com.tencent.luggage.wxa.hn.r6;
import com.tencent.luggage.wxa.hn.s6;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.uk.d0;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.oskplayer.proxy.VideoProxy;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.net.ssl.SSLContext;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class d implements i {

    /* renamed from: n, reason: collision with root package name */
    public static String f145855n = "";

    /* renamed from: o, reason: collision with root package name */
    public static int f145856o;

    /* renamed from: e, reason: collision with root package name */
    public int f145860e;

    /* renamed from: f, reason: collision with root package name */
    public SSLContext f145861f;

    /* renamed from: g, reason: collision with root package name */
    public final String f145862g;

    /* renamed from: h, reason: collision with root package name */
    public final WeakReference f145863h;

    /* renamed from: i, reason: collision with root package name */
    public final String f145864i;

    /* renamed from: j, reason: collision with root package name */
    public int f145865j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f145866k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f145867l;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f145857b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Set f145858c = new ConcurrentSkipListSet();

    /* renamed from: d, reason: collision with root package name */
    public final Set f145859d = new ConcurrentSkipListSet();

    /* renamed from: m, reason: collision with root package name */
    public boolean f145868m = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends com.tencent.luggage.wxa.jq.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.yi.e f145874b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f145875c;

        public b(com.tencent.luggage.wxa.yi.e eVar, e eVar2) {
            this.f145874b = eVar;
            this.f145875c = eVar2;
        }

        @Override // com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "AppBrandNetworkRequest@" + this.f145874b.t();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "call cronet time out taskid:%s,timeout:%d,url:%s", this.f145874b.t(), Integer.valueOf(this.f145874b.u()), this.f145874b.v());
            if (!this.f145874b.j()) {
                this.f145874b.a(true);
                HashMap hashMap = new HashMap();
                hashMap.put("requestURL", this.f145874b.v());
                d dVar = d.this;
                e eVar = this.f145875c;
                com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121310f;
                dVar.a(eVar, "fail", cVar.f121278b, this.f145874b.t(), null, cVar.f121277a, hashMap);
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "call cronet time out already callback");
            }
            q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 6L, 1L);
            if (!w0.c(this.f145874b.e())) {
                CronetLogic.cancelCronetTask(this.f145874b.e());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f145877a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f145878b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145879c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f145880d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f145881e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f145882f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f145883g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Map f145884h;

        public c(String str, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, e eVar, int i3, ArrayList arrayList, String str2, Map map) {
            this.f145877a = str;
            this.f145878b = dVar;
            this.f145879c = jSONObject;
            this.f145880d = eVar;
            this.f145881e = i3;
            this.f145882f = arrayList;
            this.f145883g = str2;
            this.f145884h = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            byte[] bArr;
            byte[] a16;
            if (d.this.d(this.f145877a)) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandNetworkRequest", "try request but already abort, taskId:%s, appId:%s", this.f145877a, d.this.f145864i);
                return;
            }
            if (c0.a(this.f145878b.getJsRuntime(), this.f145879c, (c0.a) this.f145878b.a(c0.a.class)) == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
                e eVar = this.f145880d;
                com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.i.f121379y;
                eVar.a("fail", cVar.f121278b, cVar.f121277a, null);
                return;
            }
            String a17 = q.a(this.f145879c.optString("url"));
            Object opt = this.f145879c.opt("data");
            String optString = this.f145879c.optString("method");
            if (w0.c(optString)) {
                optString = "GET";
            }
            String str = optString;
            if (TextUtils.isEmpty(a17)) {
                this.f145880d.a("fail", "url is null", com.tencent.luggage.wxa.af.i.f121360f.f121277a, null);
                return;
            }
            if (!URLUtil.isHttpsUrl(a17) && !URLUtil.isHttpUrl(a17)) {
                this.f145880d.a("fail", "request protocol must be http or https", com.tencent.luggage.wxa.af.i.f121360f.f121277a, null);
                return;
            }
            byte[] bArr2 = new byte[0];
            if (opt != null && d.this.c(str)) {
                if (opt instanceof String) {
                    a16 = ((String) opt).getBytes(StandardCharsets.UTF_8);
                } else if (opt instanceof ByteBuffer) {
                    a16 = com.tencent.luggage.wxa.tk.c.a((ByteBuffer) opt);
                }
                bArr = a16;
                synchronized (d.this.f145857b) {
                    if (d.this.f145857b.size() >= d.this.f145860e) {
                        e eVar2 = this.f145880d;
                        com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.i.f121362h;
                        eVar2.a("fail", cVar2.f121278b, cVar2.f121277a, null);
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "exceed max task count mRequestTaskList.size():%d,mMaxRequestConcurrent:%d", Integer.valueOf(d.this.f145857b.size()), Integer.valueOf(d.this.f145860e));
                        return;
                    }
                    boolean optBoolean = this.f145879c.optBoolean("enableHttp2", false);
                    boolean optBoolean2 = this.f145879c.optBoolean("enableQuic", false);
                    boolean optBoolean3 = this.f145879c.optBoolean(VideoProxy.PARAM_ENABLE_CACHE, false);
                    boolean optBoolean4 = this.f145879c.optBoolean("enableProfile", true);
                    boolean optBoolean5 = this.f145879c.optBoolean("enableChunked", false);
                    String optString2 = this.f145879c.optString("ip", "");
                    String optString3 = this.f145879c.optString("host", "");
                    int optInt = this.f145879c.optInt("port", -1);
                    boolean optBoolean6 = this.f145879c.optBoolean("forbidReuse", false);
                    boolean optBoolean7 = this.f145879c.optBoolean("forceCellularNetwork", false);
                    boolean equalsIgnoreCase = this.f145879c.optString("redirect", "follow").equalsIgnoreCase(QCircleDaTongConstant.ElementParamValue.MANUAL);
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "request taskId %s, method %s,timeout %s, useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b, ip %s, port %d, host %s, forbidReuse %b, forceCellularNetwork %b, redirect %b, url %s ", this.f145877a, str, Integer.valueOf(this.f145881e), Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean3), Boolean.valueOf(optBoolean4), optString2, Integer.valueOf(optInt), optString3, Boolean.valueOf(optBoolean6), Boolean.valueOf(optBoolean7), Boolean.valueOf(equalsIgnoreCase), a17);
                    com.tencent.luggage.wxa.yi.e eVar3 = new com.tencent.luggage.wxa.yi.e(a17, bArr, this.f145881e, this.f145880d, str, optBoolean, optBoolean2, optBoolean3, optBoolean5, optString2, optInt, optString3, optBoolean6, optBoolean7, equalsIgnoreCase);
                    eVar3.a(this.f145882f);
                    eVar3.b(this.f145883g);
                    eVar3.d(this.f145879c.optString("responseType", "text"));
                    eVar3.d(optBoolean);
                    eVar3.g(optBoolean2);
                    eVar3.e(optBoolean3);
                    eVar3.f(optBoolean4);
                    eVar3.c(optBoolean5);
                    d.a(this.f145884h);
                    eVar3.a(this.f145884h);
                    if (!w0.c(d.f145855n)) {
                        eVar3.c(d.f145855n);
                    }
                    int i3 = d.f145856o;
                    if (i3 != 0) {
                        eVar3.b(i3);
                    }
                    synchronized (d.this.f145857b) {
                        d.this.f145857b.add(eVar3);
                    }
                    eVar3.e(this.f145877a);
                    if ((d.this.f145865j != com.tencent.luggage.wxa.pf.a.f137501g || !d.this.f145866k) && (d.this.f145865j != com.tencent.luggage.wxa.pf.a.f137502h || !d.this.f145867l)) {
                        d.this.c(eVar3);
                        return;
                    } else {
                        d.this.b(eVar3);
                        return;
                    }
                }
            }
            bArr = bArr2;
            synchronized (d.this.f145857b) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yi.d$d, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC6958d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f145886a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f145887b;

        public RunnableC6958d(Runnable runnable, String str) {
            this.f145886a = runnable;
            this.f145887b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f145886a.run();
            } finally {
                d.this.f145859d.remove(this.f145887b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        void a(Object obj, long j3);

        void a(String str, Object obj, int i3, JSONObject jSONObject, Map map, Map map2);

        void a(String str, String str2, int i3, long j3, long j16);

        void a(String str, String str2, int i3, Map map);

        void a(JSONObject jSONObject, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
        boolean a(String str);

        boolean b(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public boolean f145889a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f145890b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f145891c = -1;

        /* renamed from: d, reason: collision with root package name */
        public long f145892d = 0;
    }

    public d(com.tencent.luggage.wxa.yi.g gVar, int i3, boolean z16, boolean z17) {
        this.f145865j = com.tencent.luggage.wxa.pf.a.f137501g;
        this.f145866k = false;
        this.f145867l = false;
        this.f145863h = new WeakReference(gVar);
        this.f145864i = w0.d(gVar.getAppId());
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) gVar.a(com.tencent.luggage.wxa.yi.a.class);
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "<init> hy: config not found, appId(%s)", gVar.getAppId());
            this.f145862g = "";
            return;
        }
        this.f145860e = aVar.f145797g;
        this.f145862g = aVar.K;
        this.f145861f = q.a(aVar);
        this.f145865j = i3;
        this.f145866k = z16;
        this.f145867l = z17;
    }

    public void finalize() {
        release();
        super.finalize();
    }

    @Override // com.tencent.luggage.wxa.yi.i
    public void release() {
        synchronized (this.f145857b) {
            this.f145857b.clear();
        }
        this.f145859d.clear();
        this.f145858c.clear();
    }

    public final void d(com.tencent.luggage.wxa.yi.e eVar) {
        Runnable s16;
        if (eVar == null || eVar.k() || (s16 = eVar.s()) == null) {
            return;
        }
        if (s16 instanceof com.tencent.luggage.wxa.jq.b) {
            ((com.tencent.luggage.wxa.jq.b) s16).b();
        }
        eVar.b(true);
        eVar.a((Runnable) null);
    }

    public final synchronized void e(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.f145857b) {
            Iterator it = this.f145857b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.luggage.wxa.yi.e eVar = (com.tencent.luggage.wxa.yi.e) it.next();
                if (str.equals(eVar.t())) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "lm:real removeTask %s", eVar.t());
                    this.f145857b.remove(eVar);
                    break;
                }
            }
        }
    }

    public final void b(com.tencent.luggage.wxa.yi.e eVar) {
        String str;
        e a16 = eVar.a();
        ArrayList g16 = eVar.g();
        long currentTimeMillis = System.currentTimeMillis();
        if (g16 != null && !q.c(g16, eVar.v())) {
            try {
                str = new URL(eVar.v()).getHost();
            } catch (MalformedURLException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkRequest", e16, "get redirect url host fail Exception", new Object[0]);
                str = null;
            }
            if (!w0.c(str)) {
                a(a16, "fail", "redirect url not in domain list:" + str, eVar.t(), null, com.tencent.luggage.wxa.af.i.f121357c.f121277a, null);
            } else {
                a(a16, "fail", "redirect url not in domain list", eVar.t(), null, com.tencent.luggage.wxa.af.i.f121357c.f121277a, null);
            }
            ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(this.f145864i, eVar.i(), eVar.o(), eVar.v(), 0L, 0L, 0, 2, eVar.d(), System.currentTimeMillis(), "", "");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "sendCronetRequest not in domain url:%s,host:%s", eVar.v(), str);
            return;
        }
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkRequest", "sendCronetRequest cronet http request matchurl time " + (System.currentTimeMillis() - currentTimeMillis));
        g gVar = new g();
        q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 0L, 1L);
        a aVar = new a(eVar, a16, currentTimeMillis, gVar);
        CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
        cronetRequestParams.url = eVar.v();
        cronetRequestParams.taskId = eVar.t();
        cronetRequestParams.followRedirect = false;
        cronetRequestParams.bodyData = eVar.q();
        cronetRequestParams.method = eVar.o();
        cronetRequestParams.useHttp2 = eVar.x();
        cronetRequestParams.useQuic = eVar.A();
        cronetRequestParams.useMemoryCache = eVar.y();
        cronetRequestParams.miniPrograms = true;
        cronetRequestParams.maxRetryCount = 0;
        cronetRequestParams.forceBindMobileNetwork = eVar.B();
        if (!w0.c(eVar.n()) && !w0.c(eVar.m())) {
            CronetLogic.HostIPHint hostIPHint = new CronetLogic.HostIPHint();
            cronetRequestParams.hostIPHint = hostIPHint;
            hostIPHint.hostMap = new CronetLogic.HostIpMap[1];
            CronetLogic.HostIpMap hostIpMap = new CronetLogic.HostIpMap();
            hostIpMap.host = eVar.m();
            hostIpMap.f151360ip = eVar.n();
            hostIpMap.port = eVar.p();
            cronetRequestParams.forbidSocketReuse = eVar.h();
            cronetRequestParams.hostIPHint.hostMap[0] = hostIpMap;
        }
        Map<String, String> l3 = eVar.l();
        if (l3.containsKey("Accept-Encoding")) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "startCronetHttpsRequest Accept-Encoding:%s", l3.get("Accept-Encoding"));
        } else {
            l3.put("Accept-Encoding", "gzip,compress,br,deflate");
        }
        l3.put(HttpMsg.CHARSET, "utf-8");
        l3.put("User-Agent", this.f145862g);
        if (c(eVar.o())) {
            l3.put("Content-Length", Integer.toString(eVar.q().length));
        }
        cronetRequestParams.makeRequestHeader(l3);
        a16.a(q.a(q.b(l3), 1), 0);
        b bVar = new b(eVar, a16);
        eVar.a(bVar);
        com.tencent.luggage.wxa.zp.h.f146825d.a(bVar, eVar.u());
        if (eVar.w()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "startCronetHttpsRequest with chunked");
            cronetRequestParams.taskType = 10;
        } else {
            cronetRequestParams.taskType = 1;
        }
        CronetLogic.CronetHttpsCreateResult startCronetHttpTask = CronetLogic.startCronetHttpTask(cronetRequestParams, aVar);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "sendCronetRequest prepare to send https request taskid:%s,requestid:%s,timeout:%d,url:%s", eVar.t(), startCronetHttpTask.taskId, Integer.valueOf(eVar.u()), eVar.v());
        if (startCronetHttpTask.createRet != 0) {
            if (!eVar.j()) {
                eVar.a(true);
                a(a16, "fail", "call request error:" + startCronetHttpTask.createRet, eVar.t(), null, com.tencent.luggage.wxa.af.i.f121359e.f121277a, null);
            }
            q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 2L, 1L);
            return;
        }
        eVar.a(startCronetHttpTask.taskId);
        q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 7L, 1L);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    public final void c(com.tencent.luggage.wxa.yi.e r85) {
        /*
            Method dump skipped, instructions count: 11144
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.wxa.yi.d.c(com.tencent.luggage.wxa.yi.e):void");
    }

    public final void a(e eVar, String str, String str2, String str3, HttpURLConnection httpURLConnection, int i3, Map map) {
        a(str3, httpURLConnection);
        eVar.a(str, str2, i3, map);
    }

    public final void a(e eVar, String str, Object obj, int i3, JSONObject jSONObject, String str2, HttpURLConnection httpURLConnection, Map map, Map map2) {
        a(str2, httpURLConnection);
        eVar.a(str, obj, i3, jSONObject, map, map2);
    }

    public final boolean d(String str) {
        return this.f145858c.contains(str);
    }

    public void a(com.tencent.luggage.wxa.yi.e eVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "lm:try to abortTask taskId:%s, appId:%s", eVar.t(), this.f145864i);
        this.f145858c.add(eVar.t());
        a(eVar.t(), eVar.c());
        if (w0.c(eVar.e())) {
            return;
        }
        CronetLogic.cancelCronetTask(eVar.e());
    }

    public final boolean a(String str) {
        if (!this.f145859d.contains(str)) {
            return false;
        }
        this.f145858c.add(str);
        return true;
    }

    public final void a(String str, HttpURLConnection httpURLConnection) {
        e(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
                httpURLConnection.disconnect();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkRequest", e16, "removeTask Exception: id %s", str);
            }
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, int i3, JSONObject jSONObject, Map map, ArrayList arrayList, e eVar, String str, String str2) {
        this.f145859d.add(str);
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new RunnableC6958d(new c(str, dVar, jSONObject, eVar, i3, arrayList, str2, map), str));
    }

    public static boolean a(Map map) {
        try {
            if (!com.tencent.luggage.wxa.tn.e.f141565g && !com.tencent.luggage.wxa.tn.e.f141566h && !com.tencent.luggage.wxa.tn.e.f141559a && !x0.a()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "setProxyOverride, not debug or red or purple environment");
                return false;
            }
            f0 c16 = f0.c("weixin_mini_program_debug_info", 2);
            if (c16 != null) {
                f145855n = c16.getString("weixin_mini_program_debug_host", "");
                int i3 = c16.getInt("weixin_mini_program_debug_port", 0);
                f145856o = i3;
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "get mmkvName:%s, customIp:%s, customPort:%d", "weixin_mini_program_debug_info", f145855n, Integer.valueOf(i3));
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "mmkv is null,mmkvName:%s", "weixin_mini_program_debug_info");
            }
            Map a16 = a();
            if (a16 != null && map != null) {
                map.put("Wxp-Test", (String) a16.get("Wxp-Test"));
                map.put("Wxp-Test-environmentId", (String) a16.get("Wxp-Test-environmentId"));
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "getWxpTestHeader, Wxp-Test:%s, Wxp-Test-environmentId:%s", map.get("Wxp-Test"), map.get("Wxp-Test-environmentId"));
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "setDebugProxy, exception", e16);
            return false;
        }
    }

    public static Map a() {
        Context c16;
        if (!com.tencent.luggage.wxa.tn.e.f141565g && !com.tencent.luggage.wxa.tn.e.f141566h && !com.tencent.luggage.wxa.tn.e.f141559a && !x0.a()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "getWxpTestHeader, not debug or red or purple environment");
            return null;
        }
        try {
            c16 = com.tencent.luggage.wxa.tn.z.c();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "getWxPayTestTransferHeader, exception", e16);
        }
        if (c16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "getWxpTestHeader() MMApplicationContext.getContext() get a null context!");
            return null;
        }
        int i3 = c16.getSharedPreferences(com.tencent.luggage.wxa.tn.z.f(), 0).getInt("pay_uat_test_environment_id", 0);
        if (i3 != 0) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "testId: $testId");
            pi e17 = pi.e();
            e17.f128464d = i3;
            byte[] b16 = e17.b();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "getWxPayTestTransferHeader, info: ${infoByteArray.toString()}");
            s6 e18 = s6.e();
            e18.a("WXPAY_TEST_ENV_INFO");
            e18.a(new com.tencent.luggage.wxa.fn.c(b16));
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "getWxPayTestTransferHeader, item: ${item.toJSON()}");
            LinkedList linkedList = new LinkedList();
            linkedList.add(e18);
            r6 e19 = r6.e();
            e19.a(0);
            e19.a(linkedList);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "getWxPayTestTransferHeader, header: ${header.toJSON()}");
            String b17 = com.tencent.luggage.wxa.yb.a.b(e19.b(), 2);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "getWxPayTestTransferHeader, base64String: $base64String");
            HashMap hashMap = new HashMap();
            hashMap.put("Wxp-Test", b17);
            hashMap.put("Wxp-Test-environmentId", String.valueOf(i3));
            return hashMap;
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements CronetLogic.CronetTaskCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.yi.e f145869a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f145870b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f145871c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f145872d;

        public a(com.tencent.luggage.wxa.yi.e eVar, e eVar2, long j3, g gVar) {
            this.f145869a = eVar;
            this.f145870b = eVar2;
            this.f145871c = j3;
            this.f145872d = gVar;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveChunkedData(CronetLogic.ChunkedData chunkedData, long j3) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkRequest", "onCronetReceiveChunkedData length:%d,taskid is %s,cronettaskid is %s", Long.valueOf(j3), this.f145869a.t(), this.f145869a.e());
            if (chunkedData != null && chunkedData.data != null && j3 > 0) {
                d.this.d(this.f145869a);
                this.f145870b.a(c0.a(chunkedData.data), j3);
            } else {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandNetworkRequest", "onCronetReceiveChunkedData invaild length length:%d,taskid is %s,cronettaskid is %s", Long.valueOf(j3), this.f145869a.t(), this.f145869a.e());
            }
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i3, String str) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "cronet file request onCronetReceiveHeader status %d,protocol %s,taskid:%s,CronetRequestId:%s", Integer.valueOf(i3), str, this.f145869a.t(), this.f145869a.e());
            JSONObject a16 = q.a(CronetLogic.getHeaderList(responseHeader), 2);
            try {
                if (!w0.c(str)) {
                    a16.put(AudienceReportConst.PROTOCOL, str);
                }
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkRequest", e16, "JSONException: request onCronetReceiveHeader put protocol error", new Object[0]);
            }
            this.f145870b.a(a16, i3);
            return 0;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult, String str2) {
            int i3;
            JSONObject jSONObject;
            Object a16;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "cronet onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s", Integer.valueOf(cronetTaskResult.errorCode), cronetTaskResult.errorMsg, Integer.valueOf(cronetTaskResult.statusCode), Long.valueOf(cronetTaskResult.totalReceiveByte), this.f145869a.t(), this.f145869a.e());
            CronetLogic.WebPageProfile webPageProfile = cronetTaskResult.webPageProfile;
            if (webPageProfile != null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "cronet onCronetTaskCompleted profile, protocol:%s, ip:%s, port:%d", webPageProfile.f151362protocol, webPageProfile.peerIP, Integer.valueOf(webPageProfile.port));
            } else {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "cronet profile is empty");
            }
            d.this.d(this.f145869a);
            if (cronetTaskResult.errorCode == 0) {
                JSONObject a17 = q.a(cronetTaskResult.getHeaderMapList(), 2);
                int i16 = cronetTaskResult.statusCode;
                if (i16 != 200) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "cronet failed code: %d,url is %s", Integer.valueOf(i16), this.f145869a.v());
                    if (q.e(i16)) {
                        String str3 = cronetTaskResult.newLocation;
                        if (this.f145869a.C()) {
                            try {
                                a17.put("Location", str3);
                            } catch (JSONException e16) {
                                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkRequest", e16, "JSONException: request onCronetReceiveHeader put Location error", new Object[0]);
                            }
                            this.f145870b.a(a17, i16);
                            if (!this.f145869a.j()) {
                                this.f145869a.a(true);
                                if (this.f145869a.z()) {
                                    i3 = i16;
                                    jSONObject = a17;
                                    d.this.a(this.f145870b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "", i16, a17, this.f145869a.t(), null, q.a(cronetTaskResult.webPageProfile), null);
                                } else {
                                    i3 = i16;
                                    jSONObject = a17;
                                    d.this.a(this.f145870b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "", i3, jSONObject, this.f145869a.t(), null, null, null);
                                }
                            } else {
                                i3 = i16;
                                jSONObject = a17;
                                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "cronet onC2CDownloadCompleted manual redirect already callback");
                            }
                        } else {
                            i3 = i16;
                            jSONObject = a17;
                            int b16 = this.f145869a.b();
                            if (!TextUtils.isEmpty(str3)) {
                                if (b16 <= 0) {
                                    com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandNetworkRequest", "cronet reach the max redirect count(%d)", 15);
                                    if (!this.f145869a.j()) {
                                        this.f145869a.a(true);
                                        if (this.f145869a.z()) {
                                            d.this.a(this.f145870b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "reach the max redirect count 15", i3, jSONObject, this.f145869a.t(), null, q.a(cronetTaskResult.webPageProfile), null);
                                        } else {
                                            d.this.a(this.f145870b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "reach the max redirect count 15", i3, jSONObject, this.f145869a.t(), null, null, null);
                                        }
                                    } else {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "cronet onC2CDownloadCompleted max redirect already callback");
                                    }
                                    q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 1L, 1L);
                                    return;
                                }
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "cronet redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(b16), this.f145869a.v(), str3);
                                this.f145869a.f(str3);
                                this.f145869a.a(b16 - 1);
                                d.this.b(this.f145869a);
                                return;
                            }
                        }
                    } else {
                        i3 = i16;
                        jSONObject = a17;
                    }
                    q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 3L, 1L);
                } else {
                    i3 = i16;
                    jSONObject = a17;
                }
                if ("arraybuffer".equals(this.f145869a.r())) {
                    a16 = c0.a(cronetTaskResult.data);
                } else {
                    a16 = d0.a(cronetTaskResult.getDataString());
                }
                Object obj = a16;
                if (!this.f145869a.j()) {
                    this.f145869a.a(true);
                    HashMap hashMap = new HashMap();
                    hashMap.put("beginCGITimestamp", Long.valueOf(this.f145871c));
                    hashMap.put("CGICallbackTimestamp", Long.valueOf(System.currentTimeMillis()));
                    if (this.f145869a.z()) {
                        d.this.a(this.f145870b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, obj, cronetTaskResult.statusCode, jSONObject, this.f145869a.t(), null, q.a(cronetTaskResult.webPageProfile), hashMap);
                    } else {
                        d.this.a(this.f145870b, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, obj, cronetTaskResult.statusCode, jSONObject, this.f145869a.t(), null, null, hashMap);
                    }
                } else {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "cronet onC2CDownloadCompleted if already callback");
                }
                com.tencent.luggage.wxa.tn.w.a("cronet request time", "request time is " + (System.currentTimeMillis() - this.f145871c));
                q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 8L, 1L);
                ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(d.this.f145864i, this.f145869a.i(), this.f145869a.o(), this.f145869a.v(), this.f145869a.f(), cronetTaskResult.totalReceiveByte, i3, 1, this.f145869a.d(), System.currentTimeMillis(), "", "");
            } else {
                if (!this.f145869a.j()) {
                    this.f145869a.a(true);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("requestURL", this.f145869a.v());
                    d.this.a(this.f145870b, "fail", cronetTaskResult.errorCode + ":" + cronetTaskResult.errorMsg, this.f145869a.t(), null, com.tencent.luggage.wxa.af.i.f121356b.f121277a, hashMap2);
                } else {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "onC2CDownloadCompleted else already callback");
                }
                ((z) com.tencent.luggage.wxa.h1.e.c(z.class)).a(d.this.f145864i, this.f145869a.i(), this.f145869a.o(), this.f145869a.v(), this.f145869a.f(), 0L, 0, 2, this.f145869a.d(), System.currentTimeMillis(), "", "");
                q.a(QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, 5L, 1L);
            }
            d.this.f145858c.remove(this.f145869a.t());
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
            com.tencent.luggage.wxa.yi.g gVar = (com.tencent.luggage.wxa.yi.g) d.this.f145863h.get();
            if (gVar != null && !q.a(gVar)) {
                if (!this.f145869a.j()) {
                    long j3 = cronetDownloadProgress.totalByte;
                    if (j3 > 0) {
                        long j16 = cronetDownloadProgress.currentWriteByte;
                        if (j16 > j3) {
                            this.f145872d.f145890b = 100;
                        } else {
                            this.f145872d.f145890b = (int) ((j16 * 100) / j3);
                        }
                        g gVar2 = this.f145872d;
                        if (gVar2.f145891c != gVar2.f145890b) {
                            this.f145870b.a(this.f145869a.t(), this.f145869a.v(), this.f145872d.f145890b, cronetDownloadProgress.currentWriteByte, cronetDownloadProgress.totalByte);
                            g gVar3 = this.f145872d;
                            gVar3.f145891c = gVar3.f145890b;
                        }
                    } else if (this.f145872d.f145892d != cronetDownloadProgress.currentWriteByte) {
                        this.f145870b.a(this.f145869a.t(), this.f145869a.v(), 0, cronetDownloadProgress.currentWriteByte, 0L);
                        this.f145872d.f145892d = cronetDownloadProgress.currentWriteByte;
                    }
                    if (this.f145872d.f145890b == 100) {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "cronet request size %d, totalSize %d, percent = %d", Long.valueOf(cronetDownloadProgress.currentWriteByte), Long.valueOf(cronetDownloadProgress.totalByte), Integer.valueOf(this.f145872d.f145890b));
                        return;
                    }
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkRequest", "onDownloadProgressChanged shouldStopTask fileKey:%s,taskid is %s,cronettaskid is %s", str, this.f145869a.t(), this.f145869a.e());
            CronetLogic.cancelCronetTask(this.f145869a.e());
            if (!this.f145869a.j()) {
                this.f145869a.a(true);
                d dVar = d.this;
                e eVar = this.f145870b;
                com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.i.f121358d;
                dVar.a(eVar, "fail", cVar.f121278b, this.f145869a.t(), null, cVar.f121277a, null);
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkRequest", "onDownloadProgressChanged already callback");
            }
            d.this.d(this.f145869a);
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public void onCronetReceiveUploadProgress(long j3, long j16) {
        }
    }

    public com.tencent.luggage.wxa.yi.e b(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.f145857b) {
            Iterator it = this.f145857b.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.yi.e eVar = (com.tencent.luggage.wxa.yi.e) it.next();
                if (str.equals(eVar.t())) {
                    return eVar;
                }
            }
            return null;
        }
    }

    public final boolean c(String str) {
        int i3 = this.f145865j;
        return ((i3 == com.tencent.luggage.wxa.pf.a.f137501g && this.f145866k) || (i3 == com.tencent.luggage.wxa.pf.a.f137502h && this.f145867l)) ? str.equalsIgnoreCase("POST") || str.equalsIgnoreCase(HttpPut.METHOD_NAME) || str.equalsIgnoreCase("DELETE") || str.equalsIgnoreCase("PATCH") : str.equalsIgnoreCase("POST") || str.equalsIgnoreCase(HttpPut.METHOD_NAME) || str.equalsIgnoreCase("DELETE");
    }
}
