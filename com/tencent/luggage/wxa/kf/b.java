package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.kf.c;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.luggage.wxa.xi.a;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends v implements com.tencent.luggage.wxa.kf.e {
    public static final int CTRL_INDEX = 467;

    @NotNull
    public static final String NAME = "batchCreateLoadSubPackageTask";

    /* renamed from: a, reason: collision with root package name */
    public static final a f131936a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kf.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ExecutorC6379b implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedList f131937a = new LinkedList();

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f131938b = new AtomicBoolean(true);

        public final void a() {
            LinkedList linkedList;
            if (this.f131938b.getAndSet(false)) {
                synchronized (this.f131937a) {
                    linkedList = new LinkedList(this.f131937a);
                    this.f131937a.clear();
                    Unit unit = Unit.INSTANCE;
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            if (this.f131938b.get()) {
                synchronized (this.f131937a) {
                    this.f131937a.offer(command);
                }
                return;
            }
            command.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExecutorC6379b f131939a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f131940b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131941c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f131942d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f131943e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131944a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f131945b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f131946c;

            public a(com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
                this.f131944a = dVar;
                this.f131945b = i3;
                this.f131946c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.d.a(this.f131944a, String.valueOf(this.f131945b), "success", this.f131946c);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kf.b$c$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6380b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131947a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f131948b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f131949c;

            public RunnableC6380b(com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
                this.f131947a = dVar;
                this.f131948b = i3;
                this.f131949c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.d.a(this.f131947a, String.valueOf(this.f131948b), "fail", this.f131949c);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kf.b$c$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6381c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131950a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f131951b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f131952c;

            public RunnableC6381c(com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
                this.f131950a = dVar;
                this.f131951b = i3;
                this.f131952c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.d.a(this.f131950a, String.valueOf(this.f131951b), "fail", this.f131952c);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class d {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f131953a;

            static {
                int[] iArr = new int[a.e.values().length];
                iArr[a.e.OK.ordinal()] = 1;
                iArr[a.e.FAIL.ordinal()] = 2;
                iArr[a.e.MODULE_NOT_FOUND.ordinal()] = 3;
                iArr[a.e.CANCEL.ordinal()] = 4;
                f131953a = iArr;
            }
        }

        public c(ExecutorC6379b executorC6379b, boolean[] zArr, com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
            this.f131939a = executorC6379b;
            this.f131940b = zArr;
            this.f131941c = dVar;
            this.f131942d = i3;
            this.f131943e = str;
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public /* synthetic */ void a(List list) {
            s41.a.a(this, list);
        }

        @Override // com.tencent.luggage.wxa.xi.a.c
        public final void a(a.e eVar) {
            int i3 = eVar == null ? -1 : d.f131953a[eVar.ordinal()];
            if (i3 == 1) {
                this.f131939a.execute(new a(this.f131941c, this.f131942d, this.f131943e));
                return;
            }
            if (i3 == 2 || i3 == 3) {
                this.f131940b[0] = true;
                this.f131939a.execute(new RunnableC6380b(this.f131941c, this.f131942d, this.f131943e));
            } else {
                if (i3 != 4) {
                    return;
                }
                this.f131939a.execute(new RunnableC6381c(this.f131941c, this.f131942d, this.f131943e));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131954a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f131955b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f131956c;

        public d(com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
            this.f131954a = dVar;
            this.f131955b = i3;
            this.f131956c = str;
        }

        @Override // com.tencent.luggage.wxa.xi.a.b
        public final void a(g0 progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            c.d.a(this.f131954a, String.valueOf(this.f131955b), "progressUpdate", this.f131956c, progress.a(), progress.c(), progress.b());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExecutorC6379b f131957a;

        public e(ExecutorC6379b executorC6379b) {
            this.f131957a = executorC6379b;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f131957a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExecutorC6379b f131958a;

        public f(ExecutorC6379b executorC6379b) {
            this.f131958a = executorC6379b;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f131958a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedList f131959a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(LinkedList linkedList) {
            super(1);
            this.f131959a = linkedList;
        }

        public final void a(String str) {
            boolean z16;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.f131959a.add(str);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d env, JSONObject data) {
        LinkedList linkedList;
        Map<String, ? extends Object> mapOf;
        q qVar;
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONArray optJSONArray = data.optJSONArray("moduleNameList");
        Object obj = null;
        if (optJSONArray != null) {
            linkedList = new LinkedList();
            com.tencent.luggage.wxa.e5.f.a(optJSONArray, new g(linkedList));
        } else {
            linkedList = null;
        }
        if (linkedList == null || linkedList.isEmpty()) {
            String makeReturnJson = makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson, "makeReturnJson(AppBrandE\u2026ral.INVALID_REQUEST_DATA)");
            return makeReturnJson;
        }
        com.tencent.luggage.wxa.ic.g runtime = env.getRuntime();
        com.tencent.luggage.wxa.xi.a W = runtime != null ? runtime.W() : null;
        if (W == null) {
            String makeReturnJson2 = makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson2, "makeReturnJson(AppBrandE\u2026s.General.INTERNAL_ERROR)");
            return makeReturnJson2;
        }
        if (!W.b()) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!Intrinsics.areEqual((String) next, ModulePkgInfo.MAIN_MODULE_NAME)) {
                    obj = next;
                    break;
                }
            }
            if (obj != null) {
                String makeReturnJson3 = makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
                Intrinsics.checkNotNullExpressionValue(makeReturnJson3, "makeReturnJson(AppBrandE\u2026ral.INVALID_REQUEST_DATA)");
                return makeReturnJson3;
            }
        }
        a.InterfaceC6911a a16 = W.a();
        Intrinsics.checkNotNullExpressionValue(a16, "modularizingHelper.creat\u2026chLoadModuleTransaction()");
        int[] iArr = new int[linkedList.size()];
        boolean[] zArr = new boolean[1];
        ExecutorC6379b executorC6379b = new ExecutorC6379b();
        Iterator it5 = linkedList.iterator();
        int i3 = 0;
        while (it5.hasNext()) {
            Object next2 = it5.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next2;
            int a17 = a31.a.a();
            iArr[i3] = a17;
            a16.a(str, new c(executorC6379b, zArr, env, a17, str), new d(env, a17, str), false);
            it5 = it5;
            i3 = i16;
        }
        a16.commit();
        if (zArr[0]) {
            String makeReturnJson4 = makeReturnJson("fail");
            Intrinsics.checkNotNullExpressionValue(makeReturnJson4, "{\n            makeReturnJson(\"fail\")\n        }");
            return makeReturnJson4;
        }
        com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121305a;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("loadTaskIdList", iArr));
        String makeReturnJson5 = makeReturnJson(cVar, mapOf);
        j jsRuntime = env.getJsRuntime();
        if (jsRuntime != null && (qVar = (q) jsRuntime.a(q.class)) != null) {
            qVar.a(new e(executorC6379b));
        } else {
            env.getAsyncHandler().a((Runnable) new f(executorC6379b));
        }
        Intrinsics.checkNotNullExpressionValue(makeReturnJson5, "{\n            makeReturn\u2026              }\n        }");
        return makeReturnJson5;
    }
}
