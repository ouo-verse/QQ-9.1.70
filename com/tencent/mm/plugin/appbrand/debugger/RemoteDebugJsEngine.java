package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.hn.bd;
import com.tencent.luggage.wxa.hn.c3;
import com.tencent.luggage.wxa.hn.cd;
import com.tencent.luggage.wxa.hn.d3;
import com.tencent.luggage.wxa.hn.ed;
import com.tencent.luggage.wxa.hn.fd;
import com.tencent.luggage.wxa.hn.gd;
import com.tencent.luggage.wxa.hn.hc;
import com.tencent.luggage.wxa.hn.hd;
import com.tencent.luggage.wxa.hn.id;
import com.tencent.luggage.wxa.hn.lc;
import com.tencent.luggage.wxa.hn.md;
import com.tencent.luggage.wxa.hn.oc;
import com.tencent.luggage.wxa.hn.sc;
import com.tencent.luggage.wxa.hn.vc;
import com.tencent.luggage.wxa.hn.yc;
import com.tencent.luggage.wxa.hn.zc;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.id.e;
import com.tencent.luggage.wxa.id.i;
import com.tencent.luggage.wxa.id.k;
import com.tencent.luggage.wxa.id.l;
import com.tencent.luggage.wxa.p9.a;
import com.tencent.luggage.wxa.r4.d;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.t9.g;
import com.tencent.luggage.wxa.tn.f;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.yi.r;
import com.tencent.mm.plugin.appbrand.debugger.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RemoteDebugJsEngine implements j, com.tencent.luggage.wxa.zj.c {

    /* renamed from: a, reason: collision with root package name */
    public e f151901a;

    /* renamed from: b, reason: collision with root package name */
    public String f151902b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f151903c;

    /* renamed from: d, reason: collision with root package name */
    public k f151904d;

    /* renamed from: f, reason: collision with root package name */
    public d f151906f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.mm.plugin.appbrand.debugger.a f151907g;

    /* renamed from: e, reason: collision with root package name */
    public final i f151905e = new i();

    /* renamed from: h, reason: collision with root package name */
    public boolean f151908h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f151909i = false;

    /* renamed from: j, reason: collision with root package name */
    public r.e f151910j = new b();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements a.l {
        public a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.debugger.a.l
        public void a() {
            RemoteDebugJsEngine.this.destroy();
            com.tencent.luggage.wxa.ic.e.a(RemoteDebugJsEngine.this.f151906f.getAppId(), e.d.CLOSE);
            if (RemoteDebugJsEngine.this.f151906f.getRuntime() != null) {
                RemoteDebugJsEngine.this.f151906f.getRuntime().D();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object call(d3 d3Var) {
            if (d3Var == null) {
                w.b("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, null response");
                return null;
            }
            int i3 = d3Var.f128743d.f127731d;
            if (i3 != 0) {
                w.b("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, errCode = %d, errMsg = %s, rr.resp = %b", Integer.valueOf(i3), d3Var.f128743d.f127732e, Boolean.FALSE);
                return null;
            }
            RemoteDebugJsEngine.this.f151901a.a(d3Var.f127452e);
            w.d("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", d3Var.f127452e);
            if (RemoteDebugJsEngine.this.f151904d.a()) {
                if (TextUtils.isEmpty(RemoteDebugJsEngine.this.f151901a.v())) {
                    RemoteDebugJsEngine.this.H();
                } else {
                    w.d("MicroMsg.RemoteDebugJsEngine", "connect with wsEndpoint");
                }
            }
            return null;
        }
    }

    public RemoteDebugJsEngine() {
        F();
    }

    public final void C() {
        if (this.f151904d == null) {
            k kVar = new k((com.tencent.luggage.wxa.yi.a) this.f151906f.a(com.tencent.luggage.wxa.yi.a.class));
            this.f151904d = kVar;
            this.f151905e.a(kVar, this.f151901a, this.f151907g);
        }
        this.f151908h = false;
        if (!TextUtils.isEmpty(this.f151901a.v())) {
            w.d("MicroMsg.RemoteDebugJsEngine", "connect wsEndpoint url:%s", this.f151901a.v());
            this.f151904d.a(this.f151901a.v(), this.f151910j);
        } else {
            if (this.f151901a.x()) {
                this.f151904d.a("ws://localhost:" + this.f151901a.c().f130056f, this.f151910j);
                return;
            }
            this.f151904d.a("wss://wxagame.weixin.qq.com/remote/", this.f151910j);
        }
    }

    public com.tencent.luggage.wxa.id.e D() {
        return this.f151901a;
    }

    public void E() {
        w.d("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
        ((com.tencent.luggage.wxa.bj.c) this.f151906f.b(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", this.f151906f.getAppId(), new c3(), d3.class).b(new c());
    }

    public boolean F() {
        new IListener<com.tencent.luggage.wxa.p9.a>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugJsEngine.4
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(com.tencent.luggage.wxa.p9.a aVar) {
                a.C6597a c6597a;
                if (aVar != null && (c6597a = aVar.f137423d) != null && c6597a.f137426c != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (RemoteDebugJsEngine.this.f151901a.c().f130059i == 1) {
                        w.a("MicroMsg.RemoteDebugJsEngine", "NEW_REMOTE_DEBUG_TYPE and do onReceiveNetworkHeader");
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("api_name", aVar.f137423d.f137424a);
                            jSONObject.put("task_id", aVar.f137423d.f137425b);
                            jSONObject.put("request_headers", aVar.f137423d.f137426c.toString());
                            jSONObject.put("timestamp", currentTimeMillis);
                            if (RemoteDebugJsEngine.this.f151905e != null) {
                                RemoteDebugJsEngine.this.f151905e.d(jSONObject.toString());
                            }
                        } catch (Exception e16) {
                            w.e("MicroMsg.RemoteDebugJsEngine", "", e16);
                        }
                    } else {
                        vc vcVar = new vc();
                        a.C6597a c6597a2 = aVar.f137423d;
                        vcVar.f128908d = c6597a2.f137424a;
                        vcVar.f128909e = c6597a2.f137425b;
                        vcVar.f128910f = c6597a2.f137426c.toString();
                        vcVar.f128911g = currentTimeMillis;
                        RemoteDebugJsEngine.this.a(l.a(vcVar, RemoteDebugJsEngine.this.f151901a, "networkDebugAPI"));
                    }
                }
                return true;
            }
        }.alive();
        return true;
    }

    public final void G() {
        w.d("MicroMsg.RemoteDebugJsEngine", "joinRoom");
        this.f151901a.b(2);
        fd fdVar = new fd();
        fdVar.f127632d = this.f151901a.b();
        fdVar.f127634f = this.f151901a.c().f130052b;
        fdVar.f127633e = "";
        fdVar.f127635g = this.f151901a.c().f130053c;
        this.f151904d.a(l.a(1003, fdVar));
    }

    public final void H() {
        w.d("MicroMsg.RemoteDebugJsEngine", "login");
        this.f151901a.b(1);
        hd hdVar = new hd();
        hdVar.f127799d = this.f151901a.b();
        hdVar.f127800e = this.f151901a.k();
        this.f151904d.a(l.a(1002, hdVar));
    }

    public final void I() {
        w.d("MicroMsg.RemoteDebugJsEngine", "onReady");
        this.f151901a.b(3);
        u();
        this.f151905e.b(this.f151901a.n(), Integer.MAX_VALUE);
        this.f151907g.e();
    }

    public void J() {
        this.f151907g.bringToFront();
    }

    public final void K() {
        q i3 = this.f151906f.i();
        cd cdVar = new cd();
        lc lcVar = new lc();
        cdVar.f127415e = lcVar;
        com.tencent.luggage.wxa.id.c cVar = (com.tencent.luggage.wxa.id.c) this.f151906f.h(com.tencent.luggage.wxa.id.c.class);
        if (cVar != null) {
            cdVar.f127416f = cVar.f();
        }
        cdVar.f127418h = this.f151906f.getRuntime().j0().f125966l.md5;
        cdVar.f127419i = 1;
        String g16 = this.f151906f.i().g("WAService.js");
        if (!w0.c(g16)) {
            cdVar.f127417g = com.tencent.luggage.wxa.y8.c.a(g16.getBytes());
        }
        lcVar.f128078h = i3.w();
        lcVar.f128075e = g.f141054c;
        lcVar.f128074d = g.f141055d;
        lcVar.f128077g = f.a(this.f151903c, com.tencent.luggage.wxa.tn.e.f141563e);
        lcVar.f128076f = g.f141057f;
        lcVar.f128080j = this.f151903c.getResources().getDisplayMetrics().density;
        lcVar.f128079i = this.f151903c.getResources().getDisplayMetrics().widthPixels / lcVar.f128080j;
        if (this.f151906f.f(com.tencent.luggage.wxa.m4.b.class) != null && ((com.tencent.luggage.wxa.m4.b) this.f151906f.f(com.tencent.luggage.wxa.m4.b.class)).D0() != null) {
            lcVar.f128081k = ((com.tencent.luggage.wxa.m4.b) this.f151906f.f(com.tencent.luggage.wxa.m4.b.class)).D0().getUserAgentString();
        }
        yc ycVar = new yc();
        this.f151905e.a(ycVar);
        cdVar.f127414d = ycVar;
        this.f151905e.a(l.a(cdVar, this.f151901a, DebugUtils.Command.SETUP_CONTEXT));
        w.a("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d, %s", cdVar.f127417g, cdVar.f127418h, Integer.valueOf(lcVar.f128078h), lcVar.f128081k);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public com.tencent.luggage.wxa.ei.k a(Class cls) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void destroy() {
        d dVar = this.f151906f;
        if (dVar != null && dVar.getRuntime() != null && this.f151906f.getRuntime().H && this.f151909i) {
            return;
        }
        this.f151905e.e();
        this.f151905e.j();
        com.tencent.luggage.wxa.id.g.b().a();
    }

    @Override // com.tencent.luggage.wxa.ei.p
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        com.tencent.luggage.wxa.id.e eVar = this.f151901a;
        if (eVar == null) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("FATAL");
            }
        } else {
            if (eVar.A()) {
                return;
            }
            if (!this.f151901a.C()) {
                this.f151901a.m().add(new Pair(str, valueCallback));
                this.f151902b = null;
                return;
            }
            oc ocVar = new oc();
            ocVar.f128370e = this.f151901a.e();
            ocVar.f128369d = str;
            this.f151905e.a(l.a(ocVar, this.f151901a, DebugUtils.Command.EVALUATE_JAVASCRIPT));
            a(ocVar.f128370e, str, valueCallback);
        }
    }

    public void u() {
        w.d("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
        Iterator it = this.f151901a.m().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.f151901a.m().clear();
    }

    public void b(String str, String str2) {
        this.f151905e.a(str, str2);
    }

    public void a(com.tencent.luggage.wxa.id.e eVar) {
        a(eVar, false, false);
    }

    public void a(com.tencent.luggage.wxa.id.e eVar, boolean z16, boolean z17) {
        this.f151909i = z17;
        this.f151905e.a(z17);
        this.f151901a = eVar;
        d t16 = eVar.t();
        this.f151906f = t16;
        this.f151903c = (Activity) t16.getContext();
        com.tencent.mm.plugin.appbrand.debugger.a aVar = new com.tencent.mm.plugin.appbrand.debugger.a(this.f151903c, this.f151901a, new a());
        this.f151907g = aVar;
        aVar.a(this.f151906f.getRuntime());
        if (this.f151904d == null) {
            k kVar = new k((com.tencent.luggage.wxa.yi.a) this.f151906f.a(com.tencent.luggage.wxa.yi.a.class));
            this.f151904d = kVar;
            this.f151905e.a(kVar, this.f151901a, this.f151907g);
        }
        if (z16) {
            this.f151907g.e();
            this.f151905e.e("relaunched");
        } else {
            C();
            if (w0.c(this.f151901a.k())) {
                E();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements r.e {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RemoteDebugJsEngine.this.C();
            }
        }

        public b() {
        }

        @Override // com.tencent.luggage.wxa.yi.r.e
        public void a(h hVar) {
            w.d("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
            RemoteDebugJsEngine.this.f151901a.G();
            RemoteDebugJsEngine.this.f151901a.D();
            if (TextUtils.isEmpty(RemoteDebugJsEngine.this.f151901a.v())) {
                if (!w0.c(RemoteDebugJsEngine.this.f151901a.k())) {
                    RemoteDebugJsEngine.this.H();
                }
                RemoteDebugJsEngine.this.f151905e.i();
            } else {
                w.d("MicroMsg.RemoteDebugJsEngine", "onSocketOpen with wsEndpoint");
                RemoteDebugJsEngine.this.f151908h = true;
                RemoteDebugJsEngine.this.K();
                RemoteDebugJsEngine.this.I();
            }
        }

        @Override // com.tencent.luggage.wxa.yi.r.e
        public void b(String str) {
            w.d("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", str);
            RemoteDebugJsEngine.this.f151907g.b(str);
            if (!TextUtils.isEmpty(RemoteDebugJsEngine.this.f151901a.v())) {
                w.d("MicroMsg.RemoteDebugJsEngine", "connect wsEndpoint %s fail, reset it empty", RemoteDebugJsEngine.this.f151901a.v());
                RemoteDebugJsEngine.this.f151907g.d(RemoteDebugJsEngine.this.f151901a.v());
                RemoteDebugJsEngine.this.f151901a.b("");
            }
        }

        @Override // com.tencent.luggage.wxa.yi.r.e
        public void c(String str) {
            w.d("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", str);
        }

        @Override // com.tencent.luggage.wxa.yi.r.e
        public void a(String str) {
            RemoteDebugJsEngine.this.f151901a.G();
        }

        @Override // com.tencent.luggage.wxa.yi.r.e
        public void a(ByteBuffer byteBuffer) {
            RemoteDebugJsEngine.this.f151901a.G();
            try {
                hc hcVar = (hc) new hc().a(com.tencent.luggage.wxa.tk.c.a(byteBuffer));
                com.tencent.luggage.wxa.fn.c cVar = hcVar.f127798f;
                if (cVar == null) {
                    w.f("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
                    return;
                }
                byte[] a16 = cVar.a();
                int i3 = hcVar.f127796d;
                if (i3 == 2006) {
                    RemoteDebugJsEngine.this.f151905e.a((sc) new sc().a(a16));
                } else if (i3 == 3001) {
                    RemoteDebugJsEngine.this.I();
                } else if (i3 != 3002) {
                    switch (i3) {
                        case 1001:
                            l.a(RemoteDebugJsEngine.this.f151901a, hcVar, ((ed) new ed().a(a16)).f127570d, RemoteDebugJsEngine.this.f151907g, RemoteDebugJsEngine.this.f151905e);
                            RemoteDebugJsEngine.this.f151901a.G();
                            break;
                        case 1002:
                            RemoteDebugJsEngine.this.a((id) new id().a(a16), hcVar);
                            break;
                        case 1003:
                            if (l.a(RemoteDebugJsEngine.this.f151901a, hcVar, ((gd) new gd().a(a16)).f127715d, RemoteDebugJsEngine.this.f151907g, RemoteDebugJsEngine.this.f151905e)) {
                                RemoteDebugJsEngine.this.K();
                                break;
                            }
                            break;
                        case 1004:
                            if (RemoteDebugJsEngine.this.f151906f.isRunning()) {
                                RemoteDebugJsEngine.this.f151905e.c();
                                break;
                            } else {
                                RemoteDebugJsEngine.this.f151905e.d();
                                break;
                            }
                        case 1005:
                            RemoteDebugJsEngine.this.f151905e.a((md) new md().a(a16), hcVar);
                            break;
                        case 1006:
                            RemoteDebugJsEngine.this.f151905e.a((bd) new bd().a(a16), hcVar);
                            com.tencent.luggage.wxa.id.j.a(hcVar, (com.tencent.luggage.wxa.id.d) RemoteDebugJsEngine.this.f151901a.q().get(hcVar.f127797e));
                            break;
                    }
                } else {
                    RemoteDebugJsEngine.this.f151901a.b(4);
                    RemoteDebugJsEngine.this.f151905e.e();
                }
                w.d("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", Integer.valueOf(hcVar.f127796d));
            } catch (Throwable th5) {
                w.b("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", Log.getStackTraceString(th5));
            }
        }

        @Override // com.tencent.luggage.wxa.yi.r.e
        public void a(int i3, String str) {
            w.d("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", Integer.valueOf(i3), str);
            if (TextUtils.isEmpty(RemoteDebugJsEngine.this.f151901a.v()) || !RemoteDebugJsEngine.this.f151908h) {
                if (RemoteDebugJsEngine.this.f151901a.a()) {
                    com.tencent.luggage.wxa.tk.l.a().b(new a(), 1000L);
                    RemoteDebugJsEngine.this.f151901a.w();
                }
            } else {
                w.d("MicroMsg.RemoteDebugJsEngine", "onSocketClose with ws lan");
                if (RemoteDebugJsEngine.this.f151906f.isRunning()) {
                    RemoteDebugJsEngine.this.f151907g.f();
                }
                RemoteDebugJsEngine.this.f151908h = false;
            }
            RemoteDebugJsEngine.this.f151905e.j();
            RemoteDebugJsEngine.this.f151901a.G();
            RemoteDebugJsEngine.this.f151907g.e();
            RemoteDebugJsEngine.this.f151901a.b(5);
            RemoteDebugJsEngine.this.f151907g.b(str);
        }
    }

    public void a(String str) {
        this.f151902b = str;
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, ValueCallback valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
        evaluateJavascript(str3, valueCallback);
    }

    public final void a(int i3, String str, ValueCallback valueCallback) {
        com.tencent.luggage.wxa.id.a aVar = new com.tencent.luggage.wxa.id.a();
        if (!w0.c(this.f151902b)) {
            aVar.f130021c = this.f151902b;
            this.f151902b = null;
        } else {
            aVar.f130021c = com.tencent.luggage.wxa.id.j.a(str);
        }
        aVar.f130020b = System.currentTimeMillis();
        aVar.f130022d = str.length();
        aVar.f130019a = valueCallback;
        this.f151901a.d().put(Integer.valueOf(i3), aVar);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(com.tencent.luggage.wxa.ei.i iVar) {
    }

    public final void a(id idVar, hc hcVar) {
        if (l.a(this.f151901a, hcVar, idVar.f127897d, this.f151907g, this.f151905e)) {
            w.d("MicroMsg.RemoteDebugJsEngine", "onLogin");
            zc zcVar = idVar.f127898e;
            if (zcVar == null) {
                w.b("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
            } else if (zcVar.f129147d) {
                this.f151901a.a(zcVar);
                I();
            } else {
                G();
            }
        }
    }

    public void a(int i3, String str) {
        this.f151905e.a(i3, str);
    }

    public void a(com.tencent.luggage.wxa.id.h hVar) {
        this.f151905e.a(hVar);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void addJavascriptInterface(Object obj, String str) {
    }
}
