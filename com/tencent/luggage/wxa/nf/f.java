package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.kh.d;
import com.tencent.luggage.wxa.p9.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.uk.d0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.luggage.wxa.yi.r;
import com.tencent.luggage.wxa.yi.s;
import com.tencent.websocket.WcWss;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.nf.b {
    public static final int CTRL_INDEX = 346;
    public static final String NAME = "createSocketTask";

    /* renamed from: g, reason: collision with root package name */
    public static r.d f135777g = null;

    /* renamed from: h, reason: collision with root package name */
    public static int f135778h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static int f135779i = 1;

    /* renamed from: b, reason: collision with root package name */
    public r.f f135780b;

    /* renamed from: c, reason: collision with root package name */
    public int f135781c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f135782d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f135783e = false;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f135784f = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends k0 {
        public static final int CTRL_INDEX = 348;
        public static final String NAME = "onSocketTaskStateChange";
    }

    public f(int i3, r.f fVar) {
        this.f135781c = f135778h;
        w.d("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", Integer.valueOf(i3));
        this.f135781c = i3;
        this.f135780b = fVar;
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String d() {
        return "socketTaskId";
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public String b() {
        return s.b().a() + "";
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar) {
        r.f fVar = this.f135780b;
        if (fVar != null) {
            this.f135782d = fVar.a(dVar.getAppId());
            this.f135783e = this.f135780b.b(dVar.getAppId());
        }
        WcWss.c();
    }

    public static void a(r.d dVar) {
        f135777g = dVar;
    }

    public static void a(com.tencent.luggage.wxa.xd.d dVar, String str, com.tencent.luggage.wxa.qc.b bVar, String str2, f fVar) {
        com.tencent.luggage.wxa.kh.d a16;
        if ((bVar == com.tencent.luggage.wxa.qc.b.SUSPEND || bVar == com.tencent.luggage.wxa.qc.b.DESTROYED) && (a16 = s.b().a(str)) != null) {
            a16.a(a16.a(str2));
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "interrupted");
            hashMap.put("socketTaskId", str2);
            hashMap.put("state", "close");
            new b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(fVar.e().a(str2));
            fVar.e().b(str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f135785a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f135786b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f135787c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f135788d;

        public a(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16) {
            this.f135786b = dVar;
            this.f135787c = str;
            this.f135788d = z16;
        }

        @Override // com.tencent.luggage.wxa.kh.d.a
        public void a(com.tencent.luggage.wxa.gl.h hVar, Map map) {
            if (f.f135777g != null) {
                f.f135777g.b(this.f135786b, this.f135787c, f.this);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("socketTaskId", this.f135787c);
            hashMap.put("state", "open");
            hashMap.put("header", f.this.a(hVar));
            if (map != null && map.size() > 0 && this.f135788d) {
                hashMap.put("profile", map);
            }
            new b().setContext(this.f135786b).setData(new JSONObject(hashMap).toString()).dispatch(f.this.e().a(this.f135787c));
        }

        @Override // com.tencent.luggage.wxa.kh.d.a
        public void b(String str) {
            if (this.f135785a) {
                w.d("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
                return;
            }
            this.f135785a = true;
            HashMap hashMap = new HashMap();
            hashMap.put("socketTaskId", this.f135787c);
            hashMap.put("state", "error");
            hashMap.put("errMsg", str);
            new b().setContext(this.f135786b).setData(new JSONObject(hashMap).toString()).dispatch(f.this.e().a(this.f135787c));
            f.this.e().b(this.f135787c);
            if (!f.this.f135782d && !f.this.f135783e) {
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 1L, 1L, false);
            } else {
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 2L, 1L, false);
            }
        }

        @Override // com.tencent.luggage.wxa.kh.d.a
        public void c(String str) {
            f.this.a(this.f135786b, this.f135787c, str);
        }

        @Override // com.tencent.luggage.wxa.kh.d.a
        public void a(com.tencent.luggage.wxa.gl.a aVar) {
            if (aVar == null || !((com.tencent.luggage.wxa.yi.a) this.f135786b.a(com.tencent.luggage.wxa.yi.a.class)).O) {
                return;
            }
            com.tencent.luggage.wxa.p9.a aVar2 = new com.tencent.luggage.wxa.p9.a();
            a.C6597a c6597a = aVar2.f137423d;
            c6597a.f137424a = com.tencent.mobileqq.msf.core.d.f247918u;
            c6597a.f137426c = f.this.a(aVar);
            aVar2.f137423d.f137425b = this.f135787c;
            aVar2.c();
        }

        @Override // com.tencent.luggage.wxa.kh.d.a
        public void a(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("data", d0.a(str));
            hashMap.put("isBuffer", Boolean.FALSE);
            hashMap.put("socketTaskId", this.f135787c);
            hashMap.put("state", "message");
            new b().setContext(this.f135786b).setData(new JSONObject(hashMap).toString()).dispatch(f.this.e().a(this.f135787c));
        }

        @Override // com.tencent.luggage.wxa.kh.d.a
        public void a(ByteBuffer byteBuffer) {
            HashMap hashMap = new HashMap();
            hashMap.put("socketTaskId", this.f135787c);
            hashMap.put("data", byteBuffer);
            hashMap.put("isBuffer", Boolean.TRUE);
            hashMap.put("state", "message");
            c0.b a16 = c0.a(this.f135786b.getJsRuntime(), hashMap, (c0.a) this.f135786b.a(c0.a.class));
            if (a16 == c0.b.OK) {
                new b().setContext(this.f135786b).setData(new JSONObject(hashMap).toString()).dispatch(f.this.e().a(this.f135787c));
            } else if (a16 == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
                c0.a(this.f135786b, b.NAME);
            }
        }

        @Override // com.tencent.luggage.wxa.kh.d.a
        public void a(int i3, String str) {
            if (f.f135777g != null) {
                f.f135777g.a(this.f135786b, this.f135787c, f.this);
            }
            HashMap hashMap = new HashMap();
            if (q.a(this.f135786b.getAppState())) {
                hashMap.put("reason", "interrupted");
            } else if (!w0.c(str)) {
                hashMap.put("reason", str);
            }
            hashMap.put("code", Integer.valueOf(i3));
            hashMap.put("socketTaskId", this.f135787c);
            hashMap.put("state", "close");
            new b().setContext(this.f135786b).setData(new JSONObject(hashMap).toString()).dispatch(f.this.e().a(this.f135787c));
            f.this.e().b(this.f135787c);
        }
    }

    @Override // com.tencent.luggage.wxa.ee.h
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, String str) {
        if (!this.f135784f.getAndSet(true)) {
            b(dVar);
        }
        com.tencent.luggage.wxa.kh.d a16 = s.b().a(dVar.getAppId());
        if (a16 == null) {
            int i3 = this.f135781c;
            if (((i3 == f135778h && this.f135782d) || (i3 == f135779i && this.f135783e)) && (e().a(str) == null || (e().a(str) instanceof j))) {
                a16 = new com.tencent.luggage.wxa.kh.a((com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class));
            } else {
                w.a("MicroMsg.JsApiCreateSocketTask", "hy: trigger use legacy ws");
                a16 = new r((com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class));
            }
            s.b().a(dVar.getAppId(), a16);
        }
        boolean optBoolean = jSONObject.optBoolean("enableProfile", true);
        a aVar = new a(dVar, str, optBoolean);
        String optString = jSONObject.optString("url");
        if (w0.c(optString)) {
            w.d("MicroMsg.JsApiCreateSocketTask", "url is null");
            a(dVar, str, "url is null");
            return;
        }
        w.d("MicroMsg.JsApiCreateSocketTask", "useProfile:%b,url is:%s", Boolean.valueOf(optBoolean), optString);
        com.tencent.luggage.wxa.yi.a aVar2 = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
        Map a17 = q.a(jSONObject, aVar2);
        if ((jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar2.f145792b) && !q.b(aVar2.f145802l, optString, aVar2.J)) {
            w.d("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", optString);
            a(dVar, str, "url not in domain list");
            return;
        }
        int optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = q.a(aVar2, 1);
        }
        a16.a(dVar.getAppId(), str, this.f135781c, optInt > 0 ? optInt : 60000, jSONObject, a17, aVar);
        if (!this.f135782d && !this.f135783e) {
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 0L, 1L, false);
        } else {
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 10L, 1L, false);
        }
        w.d("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", optString, Integer.valueOf(dVar.getComponentId()));
    }

    public final JSONObject a(com.tencent.luggage.wxa.gl.f fVar) {
        JSONObject jSONObject = new JSONObject();
        Iterator d16 = fVar.d();
        while (d16.hasNext()) {
            try {
                String str = (String) d16.next();
                jSONObject.put(str, fVar.d(str));
            } catch (JSONException e16) {
                w.a("MicroMsg.JsApiCreateSocketTask", e16, "JSONExceptions ", new Object[0]);
            }
        }
        return jSONObject;
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2) {
        String str3;
        if (w0.c(str2)) {
            str3 = "fail";
        } else {
            str3 = "fail:" + str2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("socketTaskId", str);
        hashMap.put("state", "error");
        hashMap.put("errMsg", str3);
        String jSONObject = new JSONObject(hashMap).toString();
        new b().setContext(dVar).setData(jSONObject).dispatch(e().a(str));
        w.a("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", jSONObject);
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 3L, 1L, false);
    }
}
