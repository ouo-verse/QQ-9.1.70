package com.tencent.luggage.wxa.ic;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.b9.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.h1;
import com.tencent.luggage.wxa.xd.l1;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o {

    /* renamed from: l, reason: collision with root package name */
    public static ReentrantLock f129949l = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public l f129950a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ei.l f129951b;

    /* renamed from: e, reason: collision with root package name */
    public String f129954e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.em.b f129955f = new com.tencent.luggage.wxa.em.b();

    /* renamed from: g, reason: collision with root package name */
    public final LinkedList f129956g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f129957h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f129958i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f129959j = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.d0 f129960k = new b();

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.b9.c0 f129952c = a();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f129953d = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c0.k {

        /* renamed from: a, reason: collision with root package name */
        public long f129961a = 0;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f129962b;

        public a(boolean z16) {
            this.f129962b = z16;
        }

        @Override // com.tencent.luggage.wxa.b9.c0.k
        public void a() {
            this.f129961a = System.currentTimeMillis();
        }

        @Override // com.tencent.luggage.wxa.b9.c0.k
        public void a(long j3) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "js inject cost[%d]", Long.valueOf(j3));
            if (this.f129962b) {
                synchronized (o.this.f129956g) {
                    o.this.f129955f.b(j3);
                    o.this.f129955f.d(this.f129961a);
                    Iterator it = new LinkedList(o.this.f129956g).iterator();
                    if (it.hasNext()) {
                        com.tencent.luggage.wxa.k0.d.a(it.next());
                        throw null;
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f129965a;

        static {
            int[] iArr = new int[c0.i.values().length];
            f129965a = iArr;
            try {
                iArr[c0.i.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f129965a[c0.i.COMMON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public o(l lVar) {
        this.f129950a = lVar;
        this.f129951b = (com.tencent.luggage.wxa.ei.l) lVar.getJsRuntime().a(com.tencent.luggage.wxa.ei.l.class);
        a(this.f129950a.K() + "wxa_library/bootstrap_j2v8_worker.js", com.tencent.luggage.wxa.tk.c.b("wxa_library/bootstrap_j2v8_worker.js"));
        lVar.getJsRuntime().addJavascriptInterface(this, MiniAppWorkerManager.OBJ_WEIXINWORKER);
    }

    @JavascriptInterface
    public int create(String str) {
        return createWithParams(str, null);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0260: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:149:0x0292 (LINE:609), block:B:132:0x0260 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f4 A[Catch: all -> 0x025f, TRY_ENTER, TryCatch #8 {all -> 0x025f, blocks: (B:122:0x01f4, B:123:0x01fd, B:124:0x020d, B:99:0x0213, B:100:0x021c), top: B:6:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0213 A[Catch: all -> 0x025f, TryCatch #8 {all -> 0x025f, blocks: (B:122:0x01f4, B:123:0x01fd, B:124:0x020d, B:99:0x0213, B:100:0x021c), top: B:6:0x000d }] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int createWXLibWorker(String str, String str2) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        if (this.f129959j.get()) {
            return -1;
        }
        boolean z19 = true;
        try {
            try {
                z16 = c(str2);
                try {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "[createWXLibWorker]  isAdWorker=" + z16);
                    if (z16) {
                        synchronized (this.f129956g) {
                            Iterator it = new LinkedList(this.f129956g).iterator();
                            if (it.hasNext()) {
                                com.tencent.luggage.wxa.k0.d.a(it.next());
                                throw null;
                            }
                        }
                        l lVar = this.f129950a;
                        if (lVar == null) {
                            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandWorkerContainer", "[createWXLibWorker] service is null");
                            if (z16 && f129949l.isHeldByCurrentThread()) {
                                f129949l.unlock();
                            }
                            return -1;
                        }
                        com.tencent.luggage.wxa.ei.j jsRuntime = lVar.getJsRuntime();
                        if (jsRuntime == null) {
                            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandWorkerContainer", "[createWXLibWorker] service jsRuntime is null");
                            if (z16 && f129949l.isHeldByCurrentThread()) {
                                f129949l.unlock();
                            }
                            return -1;
                        }
                        if (((com.tencent.luggage.wxa.ei.q) jsRuntime.a(com.tencent.luggage.wxa.ei.q.class)).g()) {
                            if (this.f129950a.getRuntime() != null && !a(this.f129950a.getRuntime())) {
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "[createWXLibWorker]  jsCreateWork not ad contact");
                                if (z16 && f129949l.isHeldByCurrentThread()) {
                                    f129949l.unlock();
                                }
                                return -1;
                            }
                            this.f129955f.a(w0.c());
                            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "[createWXLibWorker]  jsCreateWorkTime=" + this.f129955f.b());
                        } else {
                            this.f129955f.c(w0.c());
                            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "[createWXLibWorker]  serviceCreateWorkTime=" + this.f129955f.c());
                        }
                        if (!f129949l.tryLock(10L, TimeUnit.SECONDS)) {
                            if (z16 && f129949l.isHeldByCurrentThread()) {
                                f129949l.unlock();
                            }
                            return -1;
                        }
                        if (this.f129955f.d() != null) {
                            int a16 = this.f129955f.a();
                            if (z16 && f129949l.isHeldByCurrentThread()) {
                                f129949l.unlock();
                            }
                            return a16;
                        }
                        this.f129955f.a((String) null);
                    }
                    long c16 = w0.c();
                    if (z16) {
                        i3 = n.AD_WORKER_ID.ordinal();
                    } else {
                        i3 = -1;
                    }
                    int a17 = a(str, str2, c0.i.COMMON, i3, new a(z16));
                    if (z16) {
                        this.f129955f.a(a17);
                        e();
                        this.f129955f.a(this.f129952c.a(a17));
                        this.f129955f.a(this.f129950a);
                        this.f129955f.a(new Pair(Long.valueOf(c16), Long.valueOf(w0.c())));
                        this.f129955f.b(str2);
                        try {
                            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "createWXLibWorker done");
                        } catch (InterruptedException e16) {
                            e = e16;
                            z17 = true;
                            if (z16) {
                                this.f129955f.a(e.getMessage());
                            }
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandWorkerContainer", e, "", "");
                            if (z16) {
                                if (f129949l.isHeldByCurrentThread()) {
                                    f129949l.unlock();
                                }
                                if (z17) {
                                    synchronized (this.f129956g) {
                                        Iterator it5 = new LinkedList(this.f129956g).iterator();
                                        if (it5.hasNext()) {
                                            com.tencent.luggage.wxa.k0.d.a(it5.next());
                                            throw null;
                                        }
                                    }
                                }
                            }
                            return -1;
                        } catch (Throwable th5) {
                            th = th5;
                            if (z16) {
                                this.f129955f.a(th.getMessage());
                            }
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandWorkerContainer", th, "", "");
                            throw th;
                        }
                    } else {
                        z19 = false;
                    }
                    if (z16) {
                        if (f129949l.isHeldByCurrentThread()) {
                            f129949l.unlock();
                        }
                        if (z19) {
                            synchronized (this.f129956g) {
                                Iterator it6 = new LinkedList(this.f129956g).iterator();
                                if (it6.hasNext()) {
                                    com.tencent.luggage.wxa.k0.d.a(it6.next());
                                    throw null;
                                }
                            }
                        }
                    }
                    return a17;
                } catch (InterruptedException e17) {
                    e = e17;
                    z17 = false;
                    if (z16) {
                    }
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandWorkerContainer", e, "", "");
                    if (z16) {
                    }
                    return -1;
                } catch (Throwable th6) {
                    th = th6;
                    if (z16) {
                    }
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandWorkerContainer", th, "", "");
                    throw th;
                }
            } catch (InterruptedException e18) {
                e = e18;
                z17 = false;
                z16 = false;
            } catch (Throwable th7) {
                th = th7;
                z16 = false;
            }
        } catch (Throwable th8) {
            if (z18) {
                if (f129949l.isHeldByCurrentThread()) {
                    f129949l.unlock();
                }
                if (str2 != null) {
                    synchronized (this.f129956g) {
                        Iterator it7 = new LinkedList(this.f129956g).iterator();
                        if (it7.hasNext()) {
                            com.tencent.luggage.wxa.k0.d.a(it7.next());
                            throw null;
                        }
                    }
                }
            }
            throw th8;
        }
    }

    @JavascriptInterface
    public int createWithParams(String str, String str2) {
        return a(str, str2, c0.i.USER, -1, null);
    }

    public void g() {
        this.f129952c.c();
    }

    public void h() {
        this.f129952c.d();
    }

    @JavascriptInterface
    public void postMsgToWorker(int i3, String str) {
        this.f129952c.a(i3, str);
    }

    @JavascriptInterface
    public void terminate(int i3) {
        this.f129952c.b(i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.b9.d0 {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.b9.d0
        public int a() {
            if (o.this.f129951b != null) {
                return o.this.f129951b.p();
            }
            return 0;
        }

        @Override // com.tencent.luggage.wxa.b9.d0
        public boolean b() {
            if (o.this.f129951b != null) {
                return o.this.f129951b.e();
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.b9.d0
        public ByteBuffer a(int i3) {
            if (o.this.f129951b != null) {
                return o.this.f129951b.a(i3, false);
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.b9.d0
        public void a(int i3, ByteBuffer byteBuffer) {
            if (o.this.f129951b != null) {
                o.this.f129951b.a(i3, byteBuffer);
            }
        }

        @Override // com.tencent.luggage.wxa.b9.d0
        public void a(long j3, long j16) {
            if (o.this.f129951b != null) {
                o.this.f129951b.a(j3, j16);
            }
        }

        @Override // com.tencent.luggage.wxa.b9.d0
        public void a(int i3, String str) {
            l lVar;
            if (o.this.f129959j.get()) {
                lVar = null;
            } else {
                lVar = o.this.f129950a;
                Objects.requireNonNull(lVar);
            }
            com.tencent.luggage.wxa.ei.j jsRuntime = lVar != null ? lVar.getJsRuntime() : null;
            if (jsRuntime == null) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandWorkerContainer", "onWorkerMessage(appId:%s, id:%d, msg:%s), mService.getJsRuntime() is null", o.this.f129954e, Integer.valueOf(i3), str);
            } else {
                jsRuntime.evaluateJavascript(String.format(Locale.ENGLISH, "typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", Integer.valueOf(i3), str), null);
            }
        }
    }

    public com.tencent.luggage.wxa.b9.c0 a() {
        return new com.tencent.luggage.wxa.b9.c0(this.f129960k);
    }

    public void b() {
        this.f129959j.set(true);
        this.f129952c.a();
        this.f129950a = null;
        this.f129956g.clear();
    }

    public final boolean c(String str) {
        try {
            return "ad".equals(new JSONObject(str).optString("type"));
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandWorkerContainer", e16, "[createWXLibWorker] get type fail", new Object[0]);
            return false;
        }
    }

    public l d() {
        return this.f129950a;
    }

    public final void e() {
        if (this.f129957h.get() || !this.f129958i.get() || this.f129950a.getRuntime() == null || this.f129955f.d() == null) {
            return;
        }
        this.f129957h.set(true);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "dispatch OnWxConfigReady to worker %s", this.f129954e);
        com.tencent.luggage.wxa.ei.p a16 = com.tencent.luggage.wxa.ic.b.a(this.f129955f.d());
        if (a16 == null) {
            return;
        }
        a16.evaluateJavascript(String.format(Locale.ENGLISH, ";(function(global){if(typeof global.WXConfig==='undefined'){global.WXConfig={};};Object.assign(global.WXConfig, %s);})(this)", this.f129950a.I()), new ValueCallback() { // from class: com.tencent.luggage.wxa.ic.at
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "inject WXConfig result=" + ((String) obj));
            }
        });
        a16.evaluateJavascript(String.format(Locale.US, ";(function(global){ if(global.WXConfig.preload) { %s; return true; } else { return false; }})(this);", h1.a("onWxConfigReady", "", 0)), new ValueCallback() { // from class: com.tencent.luggage.wxa.ic.au
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "onWxConfigReady result=" + ((String) obj));
            }
        });
    }

    public void f() {
        this.f129958i.set(true);
        String appId = d().getAppId();
        this.f129954e = appId;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "onRuntimeReady %s", appId);
        this.f129952c.b();
        e();
    }

    public void a(String str, String str2) {
        this.f129953d.add(new c0.j(str, str2));
    }

    public final int a(String str, String str2, c0.i iVar, int i3, c0.k kVar) {
        JSONArray optJSONArray;
        ArrayList arrayList;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWorkerContainer", "createWorker: path:%s, params:%s, type:%s, destroyed?:%b", str, str2, iVar, Boolean.valueOf(this.f129959j.get()));
        if (this.f129959j.get()) {
            return -1;
        }
        ArrayList arrayList2 = new ArrayList(this.f129953d);
        int i16 = c.f129965a[iVar.ordinal()];
        if (i16 == 1) {
            a(arrayList2, str, false, "app");
            c0.j b16 = b(str);
            if (b16 == null) {
                return -1;
            }
            arrayList2.add(b16);
        } else if (i16 == 2) {
            a(arrayList2, str, true, "wxlib");
            arrayList2.add(a(str));
        }
        ArrayList arrayList3 = null;
        if (str2 != null) {
            try {
                optJSONArray = new JSONObject(str2).optJSONArray("APIList");
            } catch (JSONException e16) {
                e = e16;
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList4 = new ArrayList(10);
                for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                    try {
                        arrayList4.add(optJSONArray.getString(i17));
                    } catch (JSONException e17) {
                        e = e17;
                        arrayList3 = arrayList4;
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandWorkerContainer", e, "hy: json format error! %s", str2);
                        arrayList = arrayList3;
                        return this.f129952c.a(arrayList2, d(), arrayList, iVar, i3, kVar);
                    }
                }
                arrayList = arrayList4;
                return this.f129952c.a(arrayList2, d(), arrayList, iVar, i3, kVar);
            }
        }
        arrayList = arrayList3;
        return this.f129952c.a(arrayList2, d(), arrayList, iVar, i3, kVar);
    }

    public c0.j b(String str) {
        return new c0.j(this.f129950a.M() + str, com.tencent.luggage.wxa.mc.k0.c(this.f129950a.getRuntime(), str) + this.f129950a.e(str));
    }

    public com.tencent.luggage.wxa.b9.d0 c() {
        return this.f129960k;
    }

    public final boolean a(g gVar) {
        com.tencent.luggage.wxa.jc.e eVar = (com.tencent.luggage.wxa.jc.e) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.jc.e.class);
        return eVar != null && eVar.b(gVar);
    }

    public c0.j a(String str) {
        return new c0.j(d().K() + str, this.f129950a.i().g(str), str, "V" + this.f129950a.i().w());
    }

    public void a(ArrayList arrayList, String str, boolean z16, String str2) {
        arrayList.add(a(z16, str2));
    }

    public final c0.j a(boolean z16, String str) {
        JSONObject x16 = z16 ? this.f129950a.x() : this.f129950a.I();
        l1.a(x16, str);
        return new c0.j(this.f129950a.K() + DownloadInfo.spKey_Config, String.format("var __wxConfig = %s;", x16.toString()));
    }
}
