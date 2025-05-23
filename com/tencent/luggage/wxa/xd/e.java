package com.tencent.luggage.wxa.xd;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.luggage.wxa.i1.a;
import com.tencent.luggage.wxa.rc.h;
import com.tencent.luggage.wxa.so.a;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.xd.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.joor.Reflect;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e implements com.tencent.luggage.wxa.xd.d {

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.dq.a f144757c;

    /* renamed from: e, reason: collision with root package name */
    public volatile d.c f144759e;

    /* renamed from: k, reason: collision with root package name */
    public boolean f144765k;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ei.j[] f144755a = {null};

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.so.a f144758d = new com.tencent.luggage.wxa.so.a();

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.so.c f144760f = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: q41.d
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            return new h();
        }
    });

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentLinkedDeque f144761g = new ConcurrentLinkedDeque();

    /* renamed from: j, reason: collision with root package name */
    public final g1 f144764j = new g1();

    /* renamed from: l, reason: collision with root package name */
    public final SparseArray f144766l = new SparseArray(5);

    /* renamed from: m, reason: collision with root package name */
    public d.a f144767m = new d();
    public boolean C = false;
    public final ConcurrentHashMap D = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f144762h = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    public n f144756b = f();

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ya.d f144763i = new com.tencent.luggage.wxa.ya.d();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.i1.a.d
        public void a(Class cls, com.tencent.luggage.wxa.h1.d dVar) {
        }

        @Override // com.tencent.luggage.wxa.i1.a.d
        public void a(Class cls, com.tencent.luggage.wxa.h1.b bVar) {
            if (cls != null && bVar != null) {
                e.this.f144763i.a(cls, bVar);
            } else {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandComponentImpl", "registerCustomize failed, clazz(%s) or customize(%s) is null.", cls, bVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f144769a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144770b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f144771c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f144772d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f144773e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f144774f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.p f144775g;

        public b(int i3, String str, o oVar, String str2, String str3, int i16, com.tencent.luggage.wxa.ei.p pVar) {
            this.f144769a = i3;
            this.f144770b = str;
            this.f144771c = oVar;
            this.f144772d = str2;
            this.f144773e = str3;
            this.f144774f = i16;
            this.f144775g = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f144764j.a(this.f144769a, this.f144770b);
            e eVar = e.this;
            eVar.a(this.f144771c, this.f144772d, this.f144773e, this.f144774f, this.f144775g, eVar.l().a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c extends g0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144777b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f144778c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f144779d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f144780e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.p f144781f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Looper f144782g;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g0 f144784a;

            public a(g0 g0Var) {
                this.f144784a = g0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                g1 g1Var = e.this.f144764j;
                c cVar = c.this;
                g1Var.a(cVar.f144780e, cVar.f144778c.getName());
                this.f144784a.proceed();
            }
        }

        public c(String str, o oVar, String str2, int i3, com.tencent.luggage.wxa.ei.p pVar, Looper looper) {
            this.f144777b = str;
            this.f144778c = oVar;
            this.f144779d = str2;
            this.f144780e = i3;
            this.f144781f = pVar;
            this.f144782g = looper;
        }

        @Override // com.tencent.luggage.wxa.xd.d.b
        public void a(String str) {
            if (TextUtils.isEmpty(a()) && !TextUtils.isEmpty(str)) {
                c(str);
            }
        }

        public final String b() {
            JSONObject jSONObject;
            String a16;
            boolean z16 = true;
            try {
                JSONObject d16 = e.this.d(this.f144777b);
                try {
                    if (!TextUtils.isEmpty(this.f144779d)) {
                        jSONObject = e.this.d(this.f144779d.trim());
                    } else {
                        jSONObject = null;
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (d16 == null || !d16.optBoolean("noCallback", false)) {
                        z16 = false;
                    }
                    if (z16) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentImpl", "callbackId: %d, add noCallbackIds");
                        e.this.D.put(Integer.valueOf(this.f144780e), Boolean.TRUE);
                    }
                    if (d16 == null) {
                        a16 = this.f144778c.makeReturnJson("fail:invalid data");
                    } else {
                        a16 = e.this.a(this.f144778c, d16, jSONObject2, this.f144780e, this.f144781f);
                    }
                    e.this.a(this.f144778c, this.f144777b, this.f144779d, this.f144780e, a16);
                    return a16;
                } catch (OutOfMemoryError e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "invokeImpl() parsePrivateDataStr, api[%s], privateData.length[%d]", this.f144778c.getName(), Integer.valueOf(com.tencent.luggage.wxa.tn.w0.d(this.f144779d).length()));
                    throw e16;
                }
            } catch (OutOfMemoryError e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "invokeImpl() parseDataStr oom, api[%s], data_length[%d]", this.f144778c.getName(), Integer.valueOf(com.tencent.luggage.wxa.tn.w0.d(this.f144777b).length()));
                throw e17;
            }
        }

        public final void c(String str) {
            b(str);
            if (this.f144778c instanceof v) {
                return;
            }
            e eVar = e.this;
            int i3 = this.f144780e;
            com.tencent.luggage.wxa.ei.p pVar = this.f144781f;
            if (pVar == null) {
                pVar = eVar.getJsRuntime();
            }
            eVar.a(i3, str, pVar);
        }

        @Override // com.tencent.luggage.wxa.xd.g0, com.tencent.luggage.wxa.xd.d.b
        public void proceed() {
            String makeReturnJson;
            if (!TextUtils.isEmpty(a())) {
                return;
            }
            Looper looper = this.f144782g;
            if (looper != null && looper != Looper.myLooper()) {
                e.this.f144764j.a(this.f144780e);
                new Handler(this.f144782g).post(new a(this));
                return;
            }
            boolean a16 = e.this.a(this.f144778c.getName(), this.f144781f);
            if (!a16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "invoke handler.proceed() log[%s] api[%s], callbackId[%d], component not running", e.this.c(), this.f144778c, Integer.valueOf(this.f144780e));
            }
            if (a16) {
                makeReturnJson = b();
            } else {
                makeReturnJson = this.f144778c.makeReturnJson("fail:interrupted");
            }
            if (!TextUtils.isEmpty(makeReturnJson)) {
                c(makeReturnJson);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements d.a {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.xd.d.a
        public boolean a(String str, com.tencent.luggage.wxa.ei.p pVar) {
            return e.this.isRunning();
        }
    }

    public e() {
        com.tencent.luggage.wxa.i1.a.a(new a());
        b(com.tencent.luggage.wxa.tn.e.f141559a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map s() {
        com.tencent.luggage.wxa.so.h.a("AppBrandComponentImpl.installJsApis");
        try {
            try {
                return new ConcurrentHashMap(g());
            } catch (NullPointerException unused) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "!! get NULL jsApiPool when createJsApiPool() called, make sure your logic !!");
                com.tencent.luggage.wxa.so.h.a();
                return null;
            }
        } finally {
            com.tencent.luggage.wxa.so.h.a();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public abstract void a(String str, String str2, int[] iArr);

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ void b(Runnable runnable) {
        q41.a.b(this, runnable);
    }

    public abstract String c();

    public l d(Class cls) {
        return null;
    }

    public n f() {
        return new n(this);
    }

    public abstract Map g();

    @Override // com.tencent.luggage.wxa.xd.d
    public final com.tencent.luggage.wxa.dq.a getAsyncHandler() {
        return l();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public int getComponentId() {
        return hashCode();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.ml.r getDialogContainer() {
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "getDialogContainer return dummy impl");
        return com.tencent.luggage.wxa.ml.r.f134778z;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.rc.r getFileSystem() {
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "getFileSystem return dummy impl");
        return (com.tencent.luggage.wxa.rc.r) this.f144760f.b();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public d.c getInterceptor() {
        return this.f144759e;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public g1 getInvokeCostManager() {
        return this.f144764j;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public final com.tencent.luggage.wxa.ei.j getJsRuntime() {
        com.tencent.luggage.wxa.ei.j jVar;
        com.tencent.luggage.wxa.ei.j[] jVarArr = this.f144755a;
        com.tencent.luggage.wxa.ei.j jVar2 = jVarArr[0];
        if (jVar2 == null) {
            synchronized (jVarArr) {
                jVar = this.f144755a[0];
            }
            return jVar;
        }
        return jVar2;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ LifecycleOwner getLifecycleOwner() {
        return q41.a.e(this);
    }

    public boolean h() {
        return false;
    }

    public abstract com.tencent.luggage.wxa.ei.j j();

    public final void k() {
        com.tencent.luggage.wxa.ei.j jVar;
        synchronized (this.f144755a) {
            com.tencent.luggage.wxa.ei.j[] jVarArr = this.f144755a;
            jVar = jVarArr[0];
            jVarArr[0] = null;
        }
        if (jVar != null) {
            jVar.destroy();
        }
    }

    public final com.tencent.luggage.wxa.dq.a l() {
        if (this.f144757c == null) {
            u();
        }
        return this.f144757c;
    }

    public String[] m() {
        ArrayList arrayList = new ArrayList(500);
        Map map = (Map) this.f144758d.a();
        if (map == null) {
            if (b() && isRunning()) {
                throw null;
            }
            return new String[0];
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((entry.getValue() instanceof com.tencent.luggage.wxa.xd.a) && !((com.tencent.luggage.wxa.xd.a) entry.getValue()).dispatchInJsThread()) {
                arrayList.add((String) entry.getKey());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final String n() {
        return "WeixinJSCoreAndroid";
    }

    /* JADX WARN: Finally extract failed */
    public final boolean o() {
        if (this.C) {
            return true;
        }
        try {
            ThreadLocal threadLocal = (ThreadLocal) Reflect.on((Class<?>) Looper.class).get("sThreadLocal");
            if (threadLocal.get() == null) {
                threadLocal.set(getAsyncHandler().a());
            }
            this.C = true;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandComponentImpl", "[+] hookLooper succeed");
            return true;
        } catch (Throwable th5) {
            try {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "hookLooper, t=%s", th5);
                if (this.C) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandComponentImpl", "[+] hookLooper succeed");
                }
                return false;
            } catch (Throwable th6) {
                if (this.C) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandComponentImpl", "[+] hookLooper succeed");
                }
                throw th6;
            }
        }
    }

    public void p() {
        r();
        q();
    }

    public final void q() {
        a.b bVar = new a.b() { // from class: q41.b
            @Override // com.tencent.luggage.wxa.so.a.b
            public final Object call() {
                Map s16;
                s16 = com.tencent.luggage.wxa.xd.e.this.s();
                return s16;
            }
        };
        if (h()) {
            this.f144758d.c(bVar);
        } else {
            this.f144758d.a(bVar);
        }
    }

    public final void r() {
        synchronized (this.f144755a) {
            com.tencent.luggage.wxa.ei.j[] jVarArr = this.f144755a;
            if (jVarArr[0] == null) {
                jVarArr[0] = j();
                this.f144755a[0].addJavascriptInterface(this.f144756b, "WeixinJSCore");
                if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
                    this.f144755a[0].evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
                }
                t();
            }
        }
    }

    public final void u() {
        HandlerThread d16 = com.tencent.luggage.wxa.cq.d.d("AppBrandAsyncJSThread", 5);
        d16.start();
        this.f144757c = new com.tencent.luggage.wxa.tn.b0(d16.getLooper());
    }

    public final void v() {
        com.tencent.luggage.wxa.dq.a aVar = this.f144757c;
        if (aVar != null) {
            aVar.a((Object) null);
            this.f144757c.a().quit();
        }
    }

    public final boolean c(String str) {
        d.a aVar = this.f144767m;
        if (aVar != null) {
            return aVar.a(str, getJsRuntime());
        }
        return true;
    }

    public void e() {
        v();
        try {
            n nVar = this.f144756b;
            if (nVar != null) {
                nVar.a();
            }
            this.f144756b = null;
            this.f144758d.a(new a.c() { // from class: q41.c
                @Override // com.tencent.luggage.wxa.so.a.c
                public final void a(Object obj) {
                    com.tencent.luggage.wxa.xd.e.this.a((Map) obj);
                }
            });
            this.f144759e = e1.f144787a;
            this.f144767m = z.f144896a;
            k();
        } catch (Throwable th5) {
            this.f144756b = null;
            throw th5;
        }
    }

    public final boolean b() {
        return this.f144765k;
    }

    public final JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", e16.getMessage());
            return null;
        }
    }

    public final void b(boolean z16) {
        this.f144765k = z16;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public m c(Class cls) {
        if (cls == null) {
            return null;
        }
        synchronized (this.f144762h) {
            Iterator it = this.f144762h.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (cls.isInstance(mVar)) {
                    return mVar;
                }
            }
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public final o a(String str) {
        Map map = (Map) this.f144758d.a();
        if (map == null) {
            if (b() && isRunning()) {
                throw null;
            }
            return null;
        }
        return (o) map.get(str);
    }

    public final void b(int i3, String str) {
        d.c cVar = this.f144759e;
        if (cVar == null) {
            return;
        }
        cVar.a(i3, str);
    }

    public String b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }

    public void a(d.a aVar) {
        this.f144767m = aVar;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public final boolean a(String str, com.tencent.luggage.wxa.ei.p pVar) {
        if (pVar == null) {
            pVar = getJsRuntime();
        }
        d.a aVar = this.f144767m;
        if (aVar != null) {
            return aVar.a(str, pVar);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.h1.b b(Class cls) {
        if (cls == null) {
            return null;
        }
        com.tencent.luggage.wxa.h1.b bVar = (com.tencent.luggage.wxa.h1.b) this.f144763i.a(cls);
        if (bVar != null || (bVar = com.tencent.luggage.wxa.h1.e.a(cls)) == null || cls.isAssignableFrom(bVar.getClass())) {
            return bVar;
        }
        return null;
    }

    public final void e(Class cls) {
        this.f144763i.c(cls);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public final void a(k0 k0Var) {
        k0Var.setContext(this).dispatch();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public final void a(String str, String str2) {
        a(str, str2, 0);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2, int i3) {
        if (c(str)) {
            h1.a(getJsRuntime(), str, str2, i3);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(k0 k0Var, int[] iArr) {
        a(k0Var.getName(), k0Var.getData(), iArr);
    }

    public final String a(String str, String str2, String str3, int i3) {
        return a(str, str2, str3, i3, false, (com.tencent.luggage.wxa.ei.p) null, -1);
    }

    public String a(String str, String str2, String str3, int i3, boolean z16, com.tencent.luggage.wxa.ei.p pVar, int i16) {
        char c16;
        String str4 = "";
        o a16 = a(str);
        if (a16 == null) {
            a(i3, b(str, "fail:not supported"));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "invokeHandler, api: %s not support", str);
            return "fail:not supported";
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = a16 instanceof com.tencent.luggage.wxa.xd.a;
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentImpl", "invokeHandler[start] tag: %s, api:%s, async:%b", c(), str, Boolean.valueOf(z17));
        com.tencent.luggage.wxa.ei.p jsRuntime = pVar == null ? getJsRuntime() : pVar;
        if (z17) {
            if (pVar != null) {
                synchronized (this.f144766l) {
                    this.f144766l.put(i3, pVar);
                }
            }
            if (((com.tencent.luggage.wxa.xd.a) a16).dispatchInJsThread()) {
                if (z16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "hy: should be called in js thread but called in async thread");
                    return "";
                }
                a(a16, str2, str3, i3, jsRuntime, (Looper) null);
                str4 = "";
            } else if (z16 && o()) {
                this.f144764j.a(str, i16);
                a(a16, str2, str3, i3, jsRuntime, l().a());
            } else {
                this.f144764j.a(i3);
                c16 = 3;
                l().a((Runnable) new b(i3, str, a16, str2, str3, i3, jsRuntime));
            }
            c16 = 3;
        } else {
            c16 = 3;
            if (z16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "hy: is sync but called in async thread");
                return "";
            }
            str4 = a(a16, str2, str3, i3, jsRuntime, (Looper) null);
        }
        Object[] objArr = new Object[4];
        objArr[0] = c();
        objArr[1] = str;
        objArr[2] = Integer.valueOf(str2 == null ? 0 : str2.length());
        objArr[c16] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentImpl", "invokeHandler[end] tag: %s, api: %s, data size: %d, time: %d", objArr);
        return str4;
    }

    public void t() {
    }

    public final String a(o oVar, String str, String str2, int i3, com.tencent.luggage.wxa.ei.p pVar, Looper looper) {
        if (!a(oVar.getName(), pVar)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "invoke log[%s] api[%s], callbackId[%d], component not running", c(), oVar.getName(), Integer.valueOf(i3));
            return b(oVar.getName(), "fail:interrupted");
        }
        c cVar = new c(str, oVar, str2, i3, pVar, looper);
        d.c cVar2 = this.f144759e;
        if (!(cVar2 != null && cVar2.a(oVar, str, str2, i3, cVar))) {
            cVar.proceed();
        }
        return !TextUtils.isEmpty(cVar.a()) ? cVar.a() : "";
    }

    public String a(o oVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, com.tencent.luggage.wxa.ei.p pVar) {
        try {
            if (oVar instanceof v) {
                if (oVar.canHandleVarianceExecutable()) {
                    return ((v) oVar).a(this, jSONObject, pVar);
                }
                return ((v) oVar).a(this, jSONObject);
            }
            if (!(oVar instanceof com.tencent.luggage.wxa.xd.a)) {
                return "";
            }
            String a16 = a(oVar, jSONObject);
            if (a16 == null) {
                if (oVar instanceof com.tencent.luggage.wxa.xd.b) {
                    ((com.tencent.luggage.wxa.xd.b) oVar).a(new f1(pVar, this, jSONObject, jSONObject2, i3));
                } else if (oVar.canHandleVarianceExecutable()) {
                    ((com.tencent.luggage.wxa.xd.a) oVar).invoke(this, jSONObject, i3, pVar);
                } else {
                    ((com.tencent.luggage.wxa.xd.a) oVar).invoke(this, jSONObject, i3);
                }
            }
            return a16;
        } catch (ClassCastException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentImpl", e16, e16.getMessage(), new Object[0]);
            return oVar.makeReturnJson("fail:internal error invalid js component");
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "invokeTheJsApi with name[%s], get exception %s", oVar, th5);
            throw th5;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(int i3, String str) {
        a(i3, str, (com.tencent.luggage.wxa.ei.p) null);
    }

    public void a(int i3, String str, com.tencent.luggage.wxa.ei.p pVar) {
        com.tencent.luggage.wxa.ei.p pVar2;
        if (pVar == null) {
            synchronized (this.f144766l) {
                int indexOfKey = this.f144766l.indexOfKey(i3);
                if (indexOfKey >= 0) {
                    pVar2 = (com.tencent.luggage.wxa.ei.p) this.f144766l.valueAt(indexOfKey);
                    this.f144766l.removeAt(indexOfKey);
                } else {
                    pVar2 = null;
                }
            }
            pVar = pVar2 != null ? pVar2 : getJsRuntime();
        }
        if (pVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "callback but get NULL JsRuntime, callbackId:%d", Integer.valueOf(i3));
            return;
        }
        if (!a((String) null, pVar)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "callback but destroyed, callbackId %d", Integer.valueOf(i3));
            return;
        }
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentImpl", "callbackId: %d, data size: %d", Integer.valueOf(i3), Integer.valueOf(com.tencent.luggage.wxa.tn.w0.d(str).length()));
        if (com.tencent.luggage.wxa.tn.w0.c(str)) {
            str = "{}";
        }
        if (this.D.containsKey(Integer.valueOf(i3))) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandComponentImpl", "callbackId: %d, no Callback");
            b(i3, str);
            return;
        }
        com.tencent.luggage.wxa.ei.o oVar = pVar instanceof com.tencent.luggage.wxa.ei.j ? (com.tencent.luggage.wxa.ei.o) ((com.tencent.luggage.wxa.ei.j) pVar).a(com.tencent.luggage.wxa.ei.o.class) : null;
        if (oVar != null) {
            oVar.a(i3, str, h1.a());
        } else {
            a(pVar, i3, str);
        }
        b(i3, str);
    }

    public final void a(com.tencent.luggage.wxa.ei.p pVar, int i3, String str) {
        pVar.evaluateJavascript(String.format(Locale.US, "typeof %s !== 'undefined' && %s.invokeCallbackHandler(%d, %s, %s)", n(), n(), Integer.valueOf(i3), str, h1.a()), null);
    }

    public void a(d.c cVar) {
        this.f144759e = cVar;
    }

    public final void a(o oVar, String str, String str2, int i3, String str3) {
        d.c cVar = this.f144759e;
        if (cVar == null) {
            return;
        }
        cVar.a(oVar, str, str2, i3, str3);
    }

    public final String a(o oVar, JSONObject jSONObject) {
        if (com.tencent.luggage.wxa.uk.c0.a(getJsRuntime(), oVar, jSONObject, (c0.a) a(c0.a.class)) == c0.b.FAIL_SIZE_EXCEED_LIMIT) {
            return oVar.makeReturnJson("fail:convert native buffer parameter fail. native buffer exceed size limit.");
        }
        return null;
    }

    public void a(Map map) {
        map.clear();
    }

    public final void a(Collection collection) {
        this.f144761g.clear();
        this.f144761g.addAll(collection);
    }

    public void a(l lVar) {
        this.f144761g.add(lVar);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public l a(Class cls) {
        l lVar;
        Iterator descendingIterator = this.f144761g.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                lVar = null;
                break;
            }
            lVar = (l) descendingIterator.next();
            if (cls.isInstance(lVar)) {
                break;
            }
        }
        if (lVar == null && (lVar = d(cls)) != null) {
            this.f144761g.add(lVar);
        }
        if (lVar != null) {
            return lVar;
        }
        try {
            l lVar2 = (l) Reflect.on((Class<?>) cls).create().get();
            if (lVar2 != null) {
                try {
                    a(lVar2);
                } catch (Exception unused) {
                    lVar = lVar2;
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandComponentImpl", "Make sure %s has default constructor", cls.getName());
                    return lVar;
                }
            }
            return lVar2;
        } catch (Exception unused2) {
        }
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean a(m mVar) {
        if (mVar == null) {
            return false;
        }
        synchronized (this.f144762h) {
            this.f144762h.add(mVar);
        }
        return true;
    }

    public final void a(Class cls, com.tencent.luggage.wxa.h1.b bVar) {
        this.f144763i.a(cls, bVar);
    }
}
