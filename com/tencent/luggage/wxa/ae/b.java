package com.tencent.luggage.wxa.ae;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.a;
import com.tencent.luggage.wxa.xd.f1;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.uk.a implements com.tencent.luggage.wxa.ae.d {

    /* renamed from: d, reason: collision with root package name */
    public static final C5994b f121051d = new C5994b(null);

    /* renamed from: e, reason: collision with root package name */
    public static final Lazy f121052e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f121053a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.ae.d invoke() {
            return (com.tencent.luggage.wxa.ae.d) com.tencent.luggage.wxa.uk.o.a("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", com.tencent.luggage.wxa.ae.d.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a.InterfaceC6804a {

        /* renamed from: a, reason: collision with root package name */
        public final k f121054a;

        /* renamed from: b, reason: collision with root package name */
        public final f1 f121055b;

        /* renamed from: c, reason: collision with root package name */
        public final String f121056c;

        /* renamed from: d, reason: collision with root package name */
        public final f f121057d;

        public c(k api, f1 context, String key, f authWithTimeoutListener) {
            Intrinsics.checkNotNullParameter(api, "api");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(authWithTimeoutListener, "authWithTimeoutListener");
            this.f121054a = api;
            this.f121055b = context;
            this.f121056c = key;
            this.f121057d = authWithTimeoutListener;
        }

        public final k a() {
            return this.f121054a;
        }

        public final f b() {
            return this.f121057d;
        }

        public final f1 c() {
            return this.f121055b;
        }

        public final String d() {
            return this.f121056c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (Intrinsics.areEqual(this.f121054a, cVar.f121054a) && Intrinsics.areEqual(this.f121055b, cVar.f121055b) && Intrinsics.areEqual(this.f121056c, cVar.f121056c) && Intrinsics.areEqual(this.f121057d, cVar.f121057d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f121054a.hashCode() * 31) + this.f121055b.hashCode()) * 31) + this.f121056c.hashCode()) * 31) + this.f121057d.hashCode();
        }

        public String toString() {
            return "Task(api=" + this.f121054a + ", context=" + this.f121055b + ", key=" + this.f121056c + ", authWithTimeoutListener=" + this.f121057d + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f121058a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f121059b;

        public d(String str, Function0 function0) {
            this.f121058a = str;
            this.f121059b = function0;
        }

        @Override // com.tencent.luggage.wxa.ae.g
        public final void b() {
            w.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "runTask() done, " + this.f121058a);
            this.f121059b.invoke();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f121053a);
        f121052e = lazy;
    }

    public b(int i3) {
        super(i3);
    }

    public static final com.tencent.luggage.wxa.ae.d a(com.tencent.luggage.wxa.xd.d dVar) {
        return f121051d.a(dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.d
    public void a(k api, f1 invokeContext) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        com.tencent.luggage.wxa.xd.d a16 = invokeContext.a();
        JSONObject b16 = invokeContext.b();
        String str = "name[" + api.getName() + "], callbackId[" + invokeContext.c() + "], appId[" + a16.getAppId() + "] component[" + a16.getComponentId() + ']';
        int d16 = d();
        int c16 = c();
        long optLong = b16.optLong("timeout", -1L);
        w.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch " + str + ", queueLength:" + d16 + ", inFlightTasksCount:" + c16 + ", timeout:" + optLong);
        b16.put("queueLength", d16);
        super.b(new c(api, invokeContext, str, new f(api, invokeContext, optLong)));
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ae.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C5994b {
        public C5994b() {
        }

        public /* synthetic */ C5994b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.luggage.wxa.ae.d a(com.tencent.luggage.wxa.xd.d dVar) {
            if (dVar == null) {
                com.tencent.luggage.wxa.ae.d DUMMY_IMPL = a();
                Intrinsics.checkNotNullExpressionValue(DUMMY_IMPL, "DUMMY_IMPL");
                return DUMMY_IMPL;
            }
            if (dVar instanceof com.tencent.luggage.wxa.ic.d) {
                com.tencent.luggage.wxa.ic.g runtime = ((com.tencent.luggage.wxa.ic.d) dVar).getRuntime();
                com.tencent.luggage.wxa.c5.e eVar = runtime instanceof com.tencent.luggage.wxa.c5.e ? (com.tencent.luggage.wxa.c5.e) runtime : null;
                b c16 = eVar != null ? eVar.c() : null;
                if (c16 != null) {
                    return c16;
                }
                com.tencent.luggage.wxa.ae.d DUMMY_IMPL2 = a();
                Intrinsics.checkNotNullExpressionValue(DUMMY_IMPL2, "DUMMY_IMPL");
                return DUMMY_IMPL2;
            }
            if (dVar instanceof com.tencent.luggage.wxa.ae.c) {
                com.tencent.luggage.wxa.ae.d c17 = ((com.tencent.luggage.wxa.ae.c) dVar).c();
                if (c17 != null) {
                    return c17;
                }
                com.tencent.luggage.wxa.ae.d DUMMY_IMPL3 = a();
                Intrinsics.checkNotNullExpressionValue(DUMMY_IMPL3, "DUMMY_IMPL");
                return DUMMY_IMPL3;
            }
            com.tencent.luggage.wxa.ae.d DUMMY_IMPL4 = a();
            Intrinsics.checkNotNullExpressionValue(DUMMY_IMPL4, "DUMMY_IMPL");
            return DUMMY_IMPL4;
        }

        public final com.tencent.luggage.wxa.ae.d a() {
            return (com.tencent.luggage.wxa.ae.d) b.f121052e.getValue();
        }
    }

    @Override // com.tencent.luggage.wxa.uk.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean c(c task) {
        Intrinsics.checkNotNullParameter(task, "task");
        return task.b().c();
    }

    @Override // com.tencent.luggage.wxa.uk.a
    public void a(c task, Function0 onEnd) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        k a16 = task.a();
        f1 c16 = task.c();
        String d16 = task.d();
        task.b().a(new com.tencent.luggage.wxa.ae.a(new d(d16, onEnd)));
        w.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "runTask " + d16);
        if (c16.f().isRunning()) {
            a16.b(c16, task.b());
        } else {
            onEnd.invoke();
        }
    }

    @Override // com.tencent.luggage.wxa.uk.a, com.tencent.luggage.wxa.ae.d
    public void a() {
        super.a();
    }
}
