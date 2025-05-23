package com.tencent.luggage.wxa.dj;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ej.b;
import com.tencent.luggage.wxa.ej.d;
import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.h6.f;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.h;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements e.b, b.a {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f124288f = true;

    /* renamed from: a, reason: collision with root package name */
    public final l f124289a;

    /* renamed from: b, reason: collision with root package name */
    public final j f124290b;

    /* renamed from: c, reason: collision with root package name */
    public final e.a f124291c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f124292d;

    /* renamed from: e, reason: collision with root package name */
    public final c f124293e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f124294a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ej.b f124295b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f124296c;

        public a(int i3, com.tencent.luggage.wxa.ej.b bVar, String str) {
            this.f124294a = i3;
            this.f124295b = bVar;
            this.f124296c = str;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "MicroMsg.NodeJavaBroker~CMD~" + this.f124295b.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f124295b.a(this.f124296c, new com.tencent.luggage.wxa.ej.c(b.this.f124289a, this.f124294a, b.this));
        }
    }

    public b(l lVar, j jVar, e.a aVar) {
        Objects.requireNonNull(lVar);
        this.f124289a = lVar;
        Objects.requireNonNull(jVar);
        this.f124290b = jVar;
        Objects.requireNonNull(aVar);
        this.f124291c = aVar;
        this.f124293e = c.a(this, lVar);
        this.f124292d = new ConcurrentHashMap();
    }

    public void b() {
        ((com.tencent.luggage.wxa.hj.a) this.f124293e.a(1)).e();
    }

    public void c() {
        w.d("MicroMsg.NodeJavaBroker", "shutdown");
        Iterator it = this.f124292d.entrySet().iterator();
        while (it.hasNext()) {
            unListen(((Integer) ((Map.Entry) it.next()).getKey()).intValue());
        }
        this.f124292d.clear();
    }

    @Override // com.tencent.luggage.wxa.ej.e.b
    public j getJsRuntime() {
        return this.f124290b;
    }

    @JavascriptInterface
    public String jsGetEnvType() {
        return a().toString();
    }

    @JavascriptInterface
    public void listen(int i3, int i16) {
        e a16 = this.f124293e.a(i3);
        if (a16 == null) {
            w.b("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
        } else {
            a16.a(i16);
            this.f124292d.put(Integer.valueOf(i16), Integer.valueOf(i3));
        }
    }

    @JavascriptInterface
    public void req(int i3, String str, int i16) {
        w.g("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", Integer.valueOf(i3), str, Integer.valueOf(i16));
        com.tencent.luggage.wxa.ej.a a16 = com.tencent.luggage.wxa.dj.a.a(i3);
        if (!f124288f && a16 == null) {
            throw new AssertionError();
        }
        if (a16 instanceof com.tencent.luggage.wxa.ej.b) {
            com.tencent.luggage.wxa.ej.b bVar = (com.tencent.luggage.wxa.ej.b) a16;
            a aVar = new a(i16, bVar, str);
            if (bVar.b()) {
                aVar.run();
                return;
            } else if (bVar.c()) {
                h.f146825d.a(aVar);
                return;
            } else {
                h.f146825d.execute(aVar);
                return;
            }
        }
        throw new IllegalStateException("req asynchronously, but target cmd not async!");
    }

    @JavascriptInterface
    public String reqSync(int i3, String str) {
        w.g("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", Integer.valueOf(i3), str);
        com.tencent.luggage.wxa.ej.a a16 = com.tencent.luggage.wxa.dj.a.a(i3);
        if (!f124288f && a16 == null) {
            throw new AssertionError();
        }
        if (a16 instanceof d) {
            return ((d) a16).a(str, new com.tencent.luggage.wxa.ej.c(this.f124289a));
        }
        throw new IllegalStateException("req synchronously, but target cmd not sync!");
    }

    @JavascriptInterface
    public void unListen(int i3) {
        Integer num = (Integer) this.f124292d.get(Integer.valueOf(i3));
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        w.g("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", Integer.valueOf(intValue), Integer.valueOf(i3));
        e a16 = this.f124293e.a(intValue);
        if (a16 == null) {
            w.b("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
        } else {
            a16.b(i3);
            this.f124292d.remove(Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.luggage.wxa.ej.b.a
    public void a(int i3, String str) {
        if (i3 <= 0) {
            return;
        }
        this.f124290b.evaluateJavascript(String.format(Locale.ENGLISH, "typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", Integer.valueOf(i3), str), null);
    }

    @Override // com.tencent.luggage.wxa.ej.e.b
    public void a(int i3, Map map) {
        f.a(map);
        this.f124290b.evaluateJavascript(String.format(Locale.ENGLISH, "typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", Integer.valueOf(i3), new com.tencent.luggage.wxa.xa.h(map).toString()), null);
    }

    @Override // com.tencent.luggage.wxa.ej.e.b
    public e.a a() {
        return this.f124291c;
    }
}
