package com.tencent.luggage.wxa.pf;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.af.i;
import com.tencent.luggage.wxa.ee.h;
import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.p9.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.yi.d;
import com.tencent.luggage.wxa.yi.f;
import com.tencent.luggage.wxa.yi.g;
import com.tencent.luggage.wxa.yi.j;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.luggage.wxa.yi.z;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements h {

    /* renamed from: g, reason: collision with root package name */
    public static int f137501g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static int f137502h = 1;

    /* renamed from: a, reason: collision with root package name */
    public int f137503a;

    /* renamed from: b, reason: collision with root package name */
    public d.f f137504b;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.ee.a f137507e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f137505c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f137506d = false;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f137508f = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends k0 {
        public static final int CTRL_INDEX = 244;
        public static final String NAME = "onRequestTaskStateChange";
    }

    public a(int i3, d.f fVar, com.tencent.luggage.wxa.ee.a aVar) {
        this.f137503a = f137501g;
        w.d("MicroMsg.BaseCreateRequestTask", "BaseCreateRequestTask<init>, programType:%d", Integer.valueOf(i3));
        this.f137503a = i3;
        this.f137504b = fVar;
        this.f137507e = aVar;
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return f.b().a() + "";
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return "requestTaskId";
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar) {
        d.f fVar = this.f137504b;
        if (fVar != null) {
            this.f137505c = fVar.a(dVar.getAppId());
            this.f137506d = this.f137504b.b(dVar.getAppId());
        }
        if (this.f137505c || this.f137506d) {
            com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
            CronetLogic.initializeNativeLib();
            if (aVar == null) {
                w.b("MicroMsg.BaseCreateRequestTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", dVar.getAppId());
                CronetLogic.setUserCertVerify(false);
            } else {
                w.d("MicroMsg.BaseCreateRequestTask", "setupRequestMode(%b),appId(%s)", Boolean.valueOf(aVar.Q), dVar.getAppId());
                CronetLogic.setUserCertVerify(aVar.Q);
            }
        }
    }

    public com.tencent.luggage.wxa.yi.d a(g gVar) {
        return new com.tencent.luggage.wxa.yi.d(gVar, this.f137503a, this.f137505c, this.f137506d);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6599a implements d.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f137509a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137510b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f137511c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f137512d;

        public C6599a(WeakReference weakReference, long j3, String str, com.tencent.luggage.wxa.xd.d dVar) {
            this.f137509a = weakReference;
            this.f137510b = j3;
            this.f137511c = str;
            this.f137512d = dVar;
        }

        @Override // com.tencent.luggage.wxa.yi.d.e
        public void a(String str, String str2, int i3, Map map) {
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f137509a.get();
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(System.currentTimeMillis() - this.f137510b);
            objArr[1] = Integer.valueOf(str2 == null ? 0 : str2.length());
            objArr[2] = this.f137511c;
            w.d("MicroMsg.BaseCreateRequestTask", "onRequestResult, time: %d, data size: %d,requestTaskId %s", objArr);
            if (dVar == null) {
                return;
            }
            if ("fail".equals(str)) {
                w.b("MicroMsg.BaseCreateRequestTask", "onRequestResult taskId[%s] reason[%s] data[%s] errno[%d]", this.f137511c, str, str2, Integer.valueOf(i3));
            }
            com.tencent.luggage.wxa.yi.d a16 = f.b().a(dVar);
            if (a16 != null && a16.d(this.f137511c)) {
                w.b("MicroMsg.BaseCreateRequestTask", "request abort %s", this.f137511c);
            } else {
                a.this.a(dVar, this.f137511c, str2, i3, map);
                ((z) e.c(z.class)).a(dVar.getAppId());
            }
        }

        @Override // com.tencent.luggage.wxa.yi.d.e
        public void a(String str, Object obj, int i3, JSONObject jSONObject, Map map, Map map2) {
            int length;
            if (obj != null && (obj instanceof ByteBuffer)) {
                length = ((ByteBuffer) obj).array().length;
            } else {
                length = (obj == null || !(obj instanceof String)) ? 0 : ((String) obj).length();
            }
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f137509a.get();
            w.d("MicroMsg.BaseCreateRequestTask", "onRequestResultWithCode, time: %d, data size: %d,requestTaskId %s", Long.valueOf(System.currentTimeMillis() - this.f137510b), Integer.valueOf(length), this.f137511c);
            if (dVar == null) {
                return;
            }
            com.tencent.luggage.wxa.yi.d a16 = f.b().a(dVar);
            if (a16 != null && a16.d(this.f137511c)) {
                w.a("MicroMsg.BaseCreateRequestTask", "request abort %s", this.f137511c);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", this.f137511c);
            if (str.equalsIgnoreCase(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS)) {
                hashMap.put("state", "success");
                hashMap.put("data", obj);
                if (map != null && map.size() > 0) {
                    hashMap.put("profile", map);
                }
            } else {
                hashMap.put("state", "fail");
            }
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i3));
            if (jSONObject != null) {
                hashMap.put("header", jSONObject);
            }
            if (map2 != null && map2.size() > 0) {
                map2.put("invokeTime", Long.valueOf(this.f137510b));
                map2.put("wxlibCallbackTimestamp", Long.valueOf(System.currentTimeMillis()));
                hashMap.put("clientInfo", map2);
            }
            b bVar = new b();
            c0.b a17 = c0.a(dVar.getJsRuntime(), hashMap, (c0.a) dVar.a(c0.a.class));
            if ((obj != null && (obj instanceof String)) || a17 == c0.b.OK) {
                bVar.setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f137507e.a(this.f137511c));
            } else if (a17 == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
                c0.a(dVar, b.NAME);
            }
            a.this.f137507e.b(this.f137511c);
        }

        @Override // com.tencent.luggage.wxa.yi.d.e
        public void a(JSONObject jSONObject, int i3) {
            com.tencent.luggage.wxa.xd.d dVar;
            if (jSONObject == null || (dVar = (com.tencent.luggage.wxa.xd.d) this.f137509a.get()) == null) {
                return;
            }
            if (jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                if (((com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class)).O) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    com.tencent.luggage.wxa.p9.a aVar = new com.tencent.luggage.wxa.p9.a();
                    a.C6597a c6597a = aVar.f137423d;
                    c6597a.f137424a = Const.BUNDLE_KEY_REQUEST;
                    c6597a.f137426c = jSONObject;
                    c6597a.f137425b = this.f137511c;
                    aVar.c();
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", this.f137511c);
            hashMap.put("state", "headersReceived");
            hashMap.put("header", jSONObject);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i3));
            new b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f137507e.a(this.f137511c));
        }

        @Override // com.tencent.luggage.wxa.yi.d.e
        public void a(Object obj, long j3) {
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f137509a.get();
            w.a("MicroMsg.BaseCreateRequestTask", "onChunkResult, data size: %d, requestTaskId %s, service:%s", Long.valueOf(j3), this.f137511c, dVar);
            if (dVar == null) {
                return;
            }
            com.tencent.luggage.wxa.yi.d a16 = f.b().a(dVar);
            if (a16 != null && a16.d(this.f137511c)) {
                w.a("MicroMsg.BaseCreateRequestTask", "request abort %s", this.f137511c);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", this.f137511c);
            hashMap.put("state", "chunked");
            hashMap.put("data", obj);
            b bVar = new b();
            c0.b a17 = c0.a(dVar.getJsRuntime(), hashMap, (c0.a) dVar.a(c0.a.class));
            if (a17 == c0.b.OK) {
                bVar.setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f137507e.a(this.f137511c));
            } else if (a17 == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
                c0.a(dVar, b.NAME);
            }
        }

        @Override // com.tencent.luggage.wxa.yi.d.e
        public void a(String str, String str2, int i3, long j3, long j16) {
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", this.f137511c);
            hashMap.put("state", "progressUpdate");
            hashMap.put("progress", Integer.valueOf(i3));
            hashMap.put("totalBytesWritten", Long.valueOf(j3));
            hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j16));
            b bVar = new b();
            bVar.setContext(this.f137512d).setData(new JSONObject(hashMap).toString()).dispatch(a.this.f137507e.a(this.f137511c));
        }
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        String str2;
        w.a("MicroMsg.BaseCreateRequestTask", "JsApiCreateRequestTask");
        if (!this.f137508f.getAndSet(true)) {
            a(dVar);
        }
        C6599a c6599a = new C6599a(new WeakReference(dVar), System.currentTimeMillis(), str, dVar);
        String optString = jSONObject.optString("url");
        if (w0.c(optString)) {
            w.b("MicroMsg.BaseCreateRequestTask", "url is null");
            a(dVar, str, "url is null or nil", i.f121360f.f121277a, null);
            return;
        }
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
        int optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = q.a(aVar, 0);
        }
        int i3 = optInt > 0 ? optInt : 60000;
        if (aVar.f145797g <= 0) {
            w.d("MicroMsg.BaseCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a16 = q.a(jSONObject, aVar);
        boolean z16 = jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar.f145792b;
        if (z16 && !q.c(aVar.f145801k, optString)) {
            w.d("MicroMsg.BaseCreateRequestTask", "not in domain url %s", optString);
            try {
                str2 = new URL(optString).getHost();
            } catch (MalformedURLException e16) {
                w.a("MicroMsg.BaseCreateRequestTask", e16, "get url host fail Exception", new Object[0]);
                str2 = null;
            }
            if (!w0.c(str2)) {
                a(dVar, str, "url not in domain list:" + str2, i.f121357c.f121277a, null);
                return;
            }
            a(dVar, str, "url not in domain list", i.f121357c.f121277a, null);
            return;
        }
        com.tencent.luggage.wxa.yi.d a17 = f.b().a(dVar, new j() { // from class: u31.a
            @Override // com.tencent.luggage.wxa.yi.j
            public final com.tencent.luggage.wxa.yi.i a(g gVar) {
                return com.tencent.luggage.wxa.pf.a.this.a(gVar);
            }
        });
        if (jSONObject.optBoolean("useHttpdnsRetry", false)) {
            w.d("MicroMsg.BaseCreateRequestTask", "use httpdns retry taskId:%s", str);
        }
        w.d("MicroMsg.BaseCreateRequestTask", "request requestTaskId:%s,configTimeout: %d,timeout: %d,inputTimeout: %d,url:%s", str, Integer.valueOf(optInt), Integer.valueOf(i3), Integer.valueOf(jSONObject.optInt("timeout", 0)), optString);
        if (a17 == null) {
            a(dVar, str, "create request error", i.f121359e.f121277a, null);
        } else if (!z16) {
            w.d("MicroMsg.BaseCreateRequestTask", "debug type, do not verify domains");
            a17.a(dVar, i3, jSONObject, a16, (ArrayList) null, c6599a, str, com.tencent.luggage.wxa.pf.b.NAME);
        } else {
            a17.a(dVar, i3, jSONObject, a16, aVar.f145801k, c6599a, str, com.tencent.luggage.wxa.pf.b.NAME);
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2, int i3, Map map) {
        w.h("MicroMsg.BaseCreateRequestTask", "sendFailMsg, requestTaskId = %s, errMsg = %s, errno = %d", str, str2, Integer.valueOf(i3));
        HashMap hashMap = new HashMap();
        hashMap.put("requestTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put(o.ERRNO_TAG, Integer.valueOf(i3));
        hashMap.put("errMsg", str2);
        if (map != null && map.size() > 0) {
            hashMap.put("clientInfo", map);
        }
        new b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(this.f137507e.a(str));
    }
}
