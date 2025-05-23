package com.tencent.luggage.wxa.b9;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.ExecuteDetails;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8RuntimeException;
import com.eclipsesource.mmv8.V8Value;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t {

    /* renamed from: k, reason: collision with root package name */
    public static boolean f122278k = false;

    /* renamed from: l, reason: collision with root package name */
    public static volatile w.b f122279l;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.d f122281b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.h f122282c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.g f122283d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b9.f f122284e;

    /* renamed from: g, reason: collision with root package name */
    public final FutureTask f122286g;

    /* renamed from: a, reason: collision with root package name */
    public final String f122280a = "MicroMsg.J2V8.V8ContextEngine#" + hashCode();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedList f122285f = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public V8Object f122287h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f122288i = true;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f122289j = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JavaCallback f122290a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122291b;

        public a(JavaCallback javaCallback, String str) {
            this.f122290a = javaCallback;
            this.f122291b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.j().registerJavaMethod(this.f122290a, this.f122291b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JavaVoidCallback f122293a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122294b;

        public b(JavaVoidCallback javaVoidCallback, String str) {
            this.f122293a = javaVoidCallback;
            this.f122294b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.j().registerJavaMethod(this.f122293a, this.f122294b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f122296a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122297b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Class f122298c;

        public c(Object obj, String str, Class cls) {
            this.f122296a = obj;
            this.f122297b = str;
            this.f122298c = cls;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.b(this.f122296a, this.f122297b, this.f122298c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.J2V8.V8ContextEngine", "destroy");
            Iterator it = t.this.f122285f.iterator();
            while (it.hasNext()) {
                ((v) it.next()).a();
            }
            t.this.f122285f.clear();
            V8Context j3 = t.this.j();
            if (j3 != null) {
                try {
                    j3.release();
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122301a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f122302b;

        public e(String str, t tVar) {
            this.f122301a = str;
            this.f122302b = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.j().shareObject(this.f122301a, this.f122302b.j());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122304a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f122305b;

        public f(String str, ValueCallback valueCallback) {
            this.f122304a = str;
            this.f122305b = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            V8Value object = t.this.j().getObject(this.f122304a);
            if (object == null) {
                object = V8.getUndefined();
            }
            this.f122305b.onReceiveValue(object);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122307a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f122308b;

        public g(String str, Object obj) {
            this.f122307a = str;
            this.f122308b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.j().add(this.f122307a, (V8Value) this.f122308b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f122310a;

        public h(Object obj) {
            this.f122310a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((Releasable) this.f122310a).release();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122312a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f122313b;

        public i(String str, boolean z16) {
            this.f122312a = str;
            this.f122313b = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.f122281b.a(this.f122312a, this.f122313b);
            if (t.this.f122287h != null) {
                com.tencent.luggage.wxa.tn.w.d(t.this.f122280a, "waitForDebugger, restore Inspector console");
                t.this.j().getGlobalObject().add(MosaicConstants$JsProperty.PROP_CONSOLE, t.this.f122287h);
                t.this.f122288i = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122315a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122316b;

        public j(String str, String str2) {
            this.f122315a = str;
            this.f122316b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.j().executeDebugScript(this.f122315a, this.f122316b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f122318a;

        public k(r rVar) {
            this.f122318a = rVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public V8Context call() {
            return this.f122318a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (t.this.j() != null) {
                try {
                    V8Object globalObject = t.this.j().getGlobalObject();
                    V8Object object = globalObject.getObject("v8Console");
                    if (object == null || object.isUndefined()) {
                        object = globalObject.getObject(MosaicConstants$JsProperty.PROP_CONSOLE);
                    }
                    String str2 = t.this.f122280a;
                    Object[] objArr = new Object[1];
                    if (object != null && !object.isUndefined()) {
                        str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                    } else {
                        str = "fail";
                    }
                    objArr[0] = str;
                    com.tencent.luggage.wxa.tn.w.d(str2, "initApi, save Inspector console %s", objArr);
                    t.this.f122287h = object;
                } catch (Throwable th5) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", th5.getMessage());
                }
            }
            if (t.this.f122281b.k().f122201q || t.f122279l != null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.J2V8.V8ContextEngine", "initApi, inject V8DirectApiConsole");
                t.this.f122285f.add(new x().a(t.this));
            }
            t.this.f122285f.add(new a0().a(t.this));
            t.this.f122285f.add(new z().a(t.this));
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", t.this.f122281b.k());
            if (t.this.f122282c.e()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
                t.this.f122282c.a(t.this.f122281b.f(), t.this.f());
            } else {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
                t.this.f122285f.add(new w(t.this.f122282c).a(t.this));
            }
            t.this.f122285f.add(new y(t.this.f122283d, t.this.f122284e).a(t.this));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public m(com.tencent.luggage.wxa.ei.y yVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = t.this.f122285f.iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                if (vVar instanceof x) {
                    ((x) vVar).a((com.tencent.luggage.wxa.ei.y) null);
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f122322a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122323b;

        public n(s sVar, String str) {
            this.f122322a = sVar;
            this.f122323b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = null;
            if (this.f122322a != null) {
                C6044t c6044t = new C6044t();
                c6044t.b();
                Object executeScript = t.this.j().executeScript(this.f122323b, c6044t);
                c6044t.a();
                s sVar = this.f122322a;
                if (executeScript != null) {
                    str = executeScript.toString();
                }
                sVar.a(str, c6044t);
                return;
            }
            t.this.j().executeVoidScript(this.f122323b, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f122325a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f122326b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f122327c;

        public o(s sVar, String str, String str2) {
            this.f122325a = sVar;
            this.f122326b = str;
            this.f122327c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = null;
            if (this.f122325a != null) {
                C6044t c6044t = new C6044t();
                c6044t.b();
                Object executeScript = t.this.j().executeScript(this.f122326b, t.this.a(this.f122327c), 0, c6044t);
                c6044t.a();
                s sVar = this.f122325a;
                if (executeScript != null) {
                    str = executeScript.toString();
                }
                sVar.a(str, c6044t);
                return;
            }
            t.this.j().executeVoidScript(this.f122326b, t.this.a(this.f122327c), 0, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f122329a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122330b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f122331c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f122332d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f122333e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f122334f;

        public p(s sVar, int i3, String str, String str2, String str3, String str4) {
            this.f122329a = sVar;
            this.f122330b = i3;
            this.f122331c = str;
            this.f122332d = str2;
            this.f122333e = str3;
            this.f122334f = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f122329a != null) {
                C6044t c6044t = new C6044t();
                c6044t.f122342c = this.f122330b;
                c6044t.b();
                String str = null;
                try {
                    Object executeScript = t.this.j().executeScript(this.f122331c, t.this.a(this.f122332d), 0, this.f122333e, this.f122334f, this.f122330b, c6044t);
                    c6044t.a();
                    s sVar = this.f122329a;
                    if (executeScript != null) {
                        str = executeScript.toString();
                    }
                    sVar.a(str, c6044t);
                    return;
                } catch (Throwable th5) {
                    c6044t.a();
                    this.f122329a.a(null, c6044t);
                    throw th5;
                }
            }
            t.this.j().executeVoidScript(this.f122331c, t.this.a(this.f122332d), 0, this.f122333e, this.f122334f, this.f122330b, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f122336a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f122337b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f122338c;

        public q(s sVar, ArrayList arrayList, String str) {
            this.f122336a = sVar;
            this.f122337b = arrayList;
            this.f122338c = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String message;
            String str = null;
            if (this.f122336a != null) {
                C6044t c6044t = new C6044t();
                c6044t.b();
                try {
                    try {
                        Object batchExecuteScripts = t.this.j().batchExecuteScripts(this.f122337b, this.f122338c, c6044t);
                        c6044t.a();
                        s sVar = this.f122336a;
                        if (batchExecuteScripts != null) {
                            str = batchExecuteScripts.toString();
                        }
                        sVar.a(str, c6044t);
                        return;
                    } catch (V8RuntimeException e16) {
                        message = e16.getMessage();
                        try {
                            throw e16;
                        } catch (Throwable th5) {
                            th = th5;
                            c6044t.a();
                            s sVar2 = this.f122336a;
                            if (message != null) {
                                str = message.toString();
                            }
                            sVar2.a(str, c6044t);
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    message = null;
                    c6044t.a();
                    s sVar22 = this.f122336a;
                    if (message != null) {
                    }
                    sVar22.a(str, c6044t);
                    throw th;
                }
            }
            t.this.j().batchExecuteScripts(this.f122337b, this.f122338c, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface r {
        V8Context a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface s {
        void a(String str, C6044t c6044t);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b9.t$t, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6044t extends ExecuteDetails {

        /* renamed from: a, reason: collision with root package name */
        public long f122340a;

        /* renamed from: b, reason: collision with root package name */
        public long f122341b;

        /* renamed from: c, reason: collision with root package name */
        public int f122342c;

        public String toString() {
            return "ExecuteDetails{evaluateJSStartTimestampMs=" + this.f122340a + ", evaluateJSEndTimestampMs=" + this.f122341b + ", cacheType=" + this.f122342c + ", codeCacheStatus=" + this.codeCacheStatus + ", flatJSCompileCost=" + this.flatJSCompileCost + ", flatJSRunCost=" + this.flatJSRunCost + ", sourceLength=" + this.sourceLength + '}';
        }

        public final void a() {
            this.f122341b = System.currentTimeMillis();
        }

        public final void b() {
            this.f122340a = System.currentTimeMillis();
        }
    }

    public t(com.tencent.luggage.wxa.b9.d dVar, com.tencent.luggage.wxa.b9.h hVar, r rVar) {
        this.f122281b = dVar;
        FutureTask futureTask = new FutureTask(new k(rVar));
        this.f122286g = futureTask;
        dVar.a(futureTask);
        this.f122282c = hVar == null ? new b0() : hVar;
        this.f122283d = new com.tencent.luggage.wxa.b9.q(this);
        this.f122284e = new com.tencent.luggage.wxa.b9.o();
        k();
    }

    public com.tencent.luggage.wxa.b9.d h() {
        return this.f122281b;
    }

    public com.tencent.luggage.wxa.b9.g i() {
        return this.f122283d;
    }

    public V8Context j() {
        try {
            return (V8Context) this.f122286g.get(10L, TimeUnit.SECONDS);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.J2V8.V8ContextEngine", e16, "getV8Context failed", new Object[0]);
            return null;
        }
    }

    public final void k() {
        this.f122281b.a((Runnable) new l(), false);
    }

    public boolean l() {
        return this.f122288i;
    }

    public static boolean d() {
        return f122279l != null;
    }

    public static w.b g() {
        return f122279l;
    }

    public final void b(Object obj, String str, Class cls) {
        List<Method> a16 = a(obj.getClass(), cls);
        V8Object newV8Object = j().newV8Object();
        for (Method method : a16) {
            newV8Object.registerJavaMethod(obj, method.getName(), method.getName(), method.getParameterTypes());
        }
        j().add(str, newV8Object);
        newV8Object.release();
    }

    public void c() {
        this.f122281b.c(new d());
    }

    public com.tencent.luggage.wxa.b9.h e() {
        return this.f122282c;
    }

    public long f() {
        return j().getPtr();
    }

    public void a(com.tencent.luggage.wxa.ei.y yVar) {
        this.f122281b.a(new m(yVar));
    }

    public void a(String str, s sVar) {
        this.f122281b.a(new n(sVar, str));
    }

    public void b(String str) {
        a(str, true);
    }

    public final String a(String str) {
        if (!f122278k) {
            return str;
        }
        if (str == null) {
            return null;
        }
        return str.startsWith("https://") ? str.substring(8) : str;
    }

    public void b() {
        this.f122281b.h();
    }

    public void a(String str, String str2, s sVar) {
        this.f122281b.a(new o(sVar, str2, str));
    }

    public void a(String str, String str2, s sVar, String str3, String str4, int i3) {
        this.f122281b.a(new p(sVar, i3, str2, str, str3, str4));
    }

    public final void a(ArrayList arrayList, String str, s sVar) {
        Objects.requireNonNull(arrayList);
        this.f122281b.a(new q(sVar, arrayList, str));
    }

    public void a(String str, JavaCallback javaCallback) {
        this.f122281b.a(new a(javaCallback, str));
    }

    public void a(String str, JavaVoidCallback javaVoidCallback) {
        this.f122281b.a(new b(javaVoidCallback, str));
    }

    public void a(Object obj, String str, Class cls) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f122281b.a(new c(obj, str, cls));
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f122281b.a(runnable, 0L);
    }

    public static List a(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        while (cls != Object.class) {
            for (Method method : new ArrayList(Arrays.asList(cls.getDeclaredMethods()))) {
                if (cls2 == null || method.isAnnotationPresent(cls2)) {
                    arrayList.add(method);
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public void a(int i3, com.tencent.luggage.wxa.ei.i iVar) {
        this.f122281b.a(i3, iVar);
    }

    public void a(String str, t tVar) {
        this.f122281b.a(new e(str, tVar));
    }

    public void a(String str, ValueCallback valueCallback) {
        this.f122281b.a(new f(str, valueCallback));
    }

    public void a(String str, Object obj) {
        if (obj instanceof V8Value) {
            this.f122281b.a(new g(str, obj));
        }
    }

    public void a(Object obj) {
        if (obj instanceof Releasable) {
            this.f122281b.a(new h(obj));
        }
    }

    public void a(String str, boolean z16) {
        this.f122281b.a(new i(str, z16));
    }

    public void a(String str, String str2) {
        this.f122281b.a(new j(str, str2));
    }
}
