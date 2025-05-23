package com.tencent.luggage.wxa.b9;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8ScriptEvaluateRequest;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.b9.t;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c0 {

    /* renamed from: c, reason: collision with root package name */
    public d0 f122158c;

    /* renamed from: d, reason: collision with root package name */
    public String f122159d;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f122156a = new AtomicInteger(e());

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f122157b = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.b9.h f122160e = new h();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ei.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122161a;

        public a(t tVar) {
            this.f122161a = tVar;
        }

        @Override // com.tencent.luggage.wxa.ei.i
        public void a(String str, String str2) {
            c0.this.a(this.f122161a, str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f122163a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f122164b;

        public b(k kVar, long j3) {
            this.f122163a = kVar;
            this.f122164b = j3;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            k kVar = this.f122163a;
            if (kVar != null) {
                kVar.a(System.currentTimeMillis() - this.f122164b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements JavaVoidCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f122166a;

        public c(int i3) {
            this.f122166a = i3;
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 1 && v8Array.getType(0) == 4) {
                c0.this.f122158c.a(this.f122166a, v8Array.getString(0));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements JavaCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f122168a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f122169b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.p f122170c;

        public d(WeakReference weakReference, List list, com.tencent.luggage.wxa.ei.p pVar) {
            this.f122168a = weakReference;
            this.f122169b = list;
            this.f122170c = pVar;
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            String str;
            String string = v8Array.getString(0);
            String string2 = v8Array.getString(1);
            int integer = v8Array.getInteger(2);
            if (v8Array.length() < 4 || v8Array.getType(3) != 4) {
                str = "";
            } else {
                str = v8Array.getString(3);
            }
            if (this.f122168a.get() != null) {
                com.tencent.luggage.wxa.xd.e eVar = (com.tencent.luggage.wxa.xd.e) this.f122168a.get();
                List list = this.f122169b;
                if (list != null && list.contains(string)) {
                    return eVar.a(string, string2, str, integer, false, this.f122170c, -1);
                }
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", string);
                eVar.a(integer, eVar.b(string, "fail:not supported"), this.f122170c);
                return "fail:not supported";
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.ei.p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f122172a;

        public e(WeakReference weakReference) {
            this.f122172a = weakReference;
        }

        @Override // com.tencent.luggage.wxa.ei.p
        public void evaluateJavascript(String str, ValueCallback valueCallback) {
            c0.this.a((t) this.f122172a.get(), str, valueCallback);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f122174a;

        public f(ValueCallback valueCallback) {
            this.f122174a = valueCallback;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            this.f122174a.onReceiveValue(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122176a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122177b;

        public g(t tVar, String str) {
            this.f122176a = tVar;
            this.f122177b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.a(this.f122176a, this.f122177b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements com.tencent.luggage.wxa.b9.h {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.b9.h
        public ByteBuffer a(int i3, boolean z16) {
            return c0.this.f122158c.a(i3);
        }

        @Override // com.tencent.luggage.wxa.b9.h
        public boolean e() {
            return c0.this.f122158c.b();
        }

        @Override // com.tencent.luggage.wxa.b9.h
        public int f() {
            return c0.this.f122158c.a();
        }

        @Override // com.tencent.luggage.wxa.b9.h
        public void a(int i3, ByteBuffer byteBuffer) {
            c0.this.f122158c.a(i3, byteBuffer);
        }

        @Override // com.tencent.luggage.wxa.b9.h
        public void a(long j3, long j16) {
            c0.this.f122158c.a(j3, j16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum i {
        USER,
        COMMON
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public final String f122183a;

        /* renamed from: b, reason: collision with root package name */
        public final V8ScriptEvaluateRequest f122184b;

        public j(String str, String str2) {
            this(str, str2, "", "");
        }

        public boolean a() {
            V8ScriptEvaluateRequest v8ScriptEvaluateRequest = this.f122184b;
            if (v8ScriptEvaluateRequest == null) {
                return false;
            }
            if (3 == v8ScriptEvaluateRequest.scriptType && TextUtils.isEmpty(v8ScriptEvaluateRequest.scriptText)) {
                return false;
            }
            return true;
        }

        public j(String str, String str2, String str3, String str4) {
            this.f122183a = str;
            V8ScriptEvaluateRequest v8ScriptEvaluateRequest = new V8ScriptEvaluateRequest();
            this.f122184b = v8ScriptEvaluateRequest;
            v8ScriptEvaluateRequest.scriptType = 3;
            v8ScriptEvaluateRequest.scriptText = str2;
            v8ScriptEvaluateRequest.cacheCategory = str3;
            v8ScriptEvaluateRequest.cacheKey = str4;
        }

        public j(String str, V8ScriptEvaluateRequest v8ScriptEvaluateRequest) {
            this.f122183a = str;
            this.f122184b = v8ScriptEvaluateRequest;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface k {
        void a();

        void a(long j3);
    }

    public c0(d0 d0Var) {
        this.f122158c = d0Var;
    }

    public void b() {
    }

    public void c() {
        Iterator it = this.f122157b.values().iterator();
        while (it.hasNext()) {
            ((t) it.next()).h().pause();
        }
    }

    public void d() {
        Iterator it = this.f122157b.values().iterator();
        while (it.hasNext()) {
            ((t) it.next()).h().a();
        }
    }

    public int e() {
        return 0;
    }

    public final void b(int i3) {
        t tVar = (t) this.f122157b.remove(Integer.valueOf(i3));
        if (tVar != null) {
            a(i3, tVar);
        }
    }

    public void a(String str) {
        this.f122159d = str;
    }

    public final void a(t tVar, String str, String str2) {
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", str, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str);
            jSONObject.put("stack", str2);
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(e16));
        }
        tVar.a(String.format("WeixinWorker.errorHandler(%s)", jSONObject), (t.s) null);
    }

    public int a(ArrayList arrayList, com.tencent.luggage.wxa.xd.e eVar, List list, i iVar, int i3, k kVar) {
        if (i3 == -1) {
            i3 = this.f122156a.addAndGet(1);
        }
        d.a a16 = a(eVar);
        com.tencent.luggage.wxa.ei.w wVar = new com.tencent.luggage.wxa.ei.w(a16);
        t E = wVar.E();
        a(i3, arrayList, wVar, eVar);
        this.f122157b.put(Integer.valueOf(i3), E);
        a(eVar.getContext(), i3, eVar, list, iVar == i.COMMON);
        a(i3, E, a16.f122199o, list);
        E.a(1, new a(E));
        a(E, arrayList, kVar);
        return i3;
    }

    public void a(t tVar, ArrayList arrayList, k kVar) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                if (jVar != null && jVar.a()) {
                    arrayList2.add(jVar);
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (kVar != null) {
            kVar.a();
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(((j) it5.next()).f122184b);
        }
        tVar.a(arrayList3, this.f122159d, new b(kVar, currentTimeMillis));
    }

    public d.a a(com.tencent.luggage.wxa.xd.e eVar) {
        d.a aVar = new d.a();
        aVar.f122190f = "1";
        aVar.f122191g = true;
        aVar.f122193i = true;
        aVar.f122194j = true;
        aVar.f122199o = new WeakReference(eVar);
        aVar.f122200p = this.f122160e;
        return aVar;
    }

    public void a(int i3, ArrayList arrayList, com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.xd.e eVar) {
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8EngineWorkerManager", "hy: do noting in base worker manager");
    }

    public void a(Context context, int i3, com.tencent.luggage.wxa.xd.e eVar, List list, boolean z16) {
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.V8EngineWorkerManager", "hy: not support bind native in nano case");
    }

    public final void a(int i3, t tVar, WeakReference weakReference, List list) {
        WeakReference weakReference2 = new WeakReference(tVar);
        tVar.a("postMessage", (JavaVoidCallback) new c(i3));
        com.tencent.luggage.wxa.ei.p a16 = a(i3, weakReference2);
        if (weakReference != null) {
            tVar.a("workerInvokeJsApi", (JavaCallback) new d(weakReference, list, a16));
        }
    }

    public com.tencent.luggage.wxa.ei.p a(int i3, WeakReference weakReference) {
        return new e(weakReference);
    }

    public void a(t tVar, String str, ValueCallback valueCallback) {
        if (tVar == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8EngineWorkerManager", "hy: engine context released");
        } else if (valueCallback != null) {
            tVar.a(str, (t.s) new f(valueCallback));
        } else {
            tVar.a(str, (t.s) null);
        }
    }

    public void a(int i3, t tVar) {
        tVar.c();
        tVar.h().e();
    }

    public t a(int i3) {
        return (t) this.f122157b.get(Integer.valueOf(i3));
    }

    public void a(int i3, String str) {
        t tVar = (t) this.f122157b.get(Integer.valueOf(i3));
        if (tVar == null) {
            return;
        }
        tVar.h().a(new g(tVar, str));
    }

    public final void a(t tVar, String str) {
        if (tVar.j().getType("onmessage") != 7) {
            return;
        }
        try {
            V8Function v8Function = (V8Function) tVar.j().get("onmessage");
            V8Array newV8Array = tVar.j().newV8Array();
            newV8Array.push(str);
            v8Function.call(tVar.j().getGlobalObject(), newV8Array);
            v8Function.release();
            newV8Array.release();
        } catch (V8ScriptException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.V8EngineWorkerManager", e16, "hy: js exception in worker!", new Object[0]);
            a(tVar, e16.getMessage(), e16.getJSStackTrace());
        }
    }

    public void a() {
        for (Map.Entry entry : this.f122157b.entrySet()) {
            a(((Integer) entry.getKey()).intValue(), (t) entry.getValue());
        }
    }
}
