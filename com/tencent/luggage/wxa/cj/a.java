package com.tencent.luggage.wxa.cj;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.g0;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.o4.a;
import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.xo.d;
import com.tencent.luggage.wxa.xo.h;
import com.tencent.mobileqq.mini.api.LaunchScene;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.bj.c {

    /* renamed from: h, reason: collision with root package name */
    public static final C6113a f123531h = new C6113a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final Map f123532i;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.c5.e f123533a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.bj.c f123534b;

    /* renamed from: c, reason: collision with root package name */
    public final String f123535c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f123536d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f123537e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f123538f;

    /* renamed from: g, reason: collision with root package name */
    public final f f123539g;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.cj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6113a {
        public C6113a() {
        }

        public /* synthetic */ C6113a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(i component) {
            Intrinsics.checkNotNullParameter(component, "component");
            g runtime = component.getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.sdk.runtime.AppBrandRuntimeLU");
            a F1 = ((com.tencent.luggage.wxa.c5.e) runtime).F1();
            Intrinsics.checkNotNullExpressionValue(F1, "component.runtime as App\u2026cgiServiceImplByLibServer");
            return F1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final CancellableContinuation f123540a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f123541b;

        public b(CancellableContinuation continuation, Class respClazz) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            Intrinsics.checkNotNullParameter(respClazz, "respClazz");
            this.f123540a = continuation;
            this.f123541b = respClazz;
        }

        public final CancellableContinuation a() {
            return this.f123540a;
        }

        public final Class b() {
            return this.f123541b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f123540a, bVar.f123540a) && Intrinsics.areEqual(this.f123541b, bVar.f123541b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f123540a.hashCode() * 31) + this.f123541b.hashCode();
        }

        public String toString() {
            return "RequestContext(continuation=" + this.f123540a + ", respClazz=" + this.f123541b + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke() {
            int i3;
            g0 g0Var = new g0();
            com.tencent.luggage.wxa.j4.d S = a.this.f123533a.S();
            if (S != null) {
                i3 = S.f130798j0;
            } else {
                i3 = 0;
            }
            g0Var.f127655e = i3;
            g0Var.f127657g = com.tencent.luggage.wxa.tn.e.f141563e;
            String e16 = l.e();
            Intrinsics.checkNotNullExpressionValue(e16, "getMMDeviceId()");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = e16.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            com.tencent.luggage.wxa.fn.c a16 = com.tencent.luggage.wxa.fn.c.a(bytes);
            a16.a(Math.min(a16.b(), 16));
            g0Var.f127656f = a16;
            String str = "android-" + Build.VERSION.SDK_INT;
            Charset UTF_82 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
            byte[] bytes2 = str.getBytes(UTF_82);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            com.tencent.luggage.wxa.fn.c a17 = com.tencent.luggage.wxa.fn.c.a(bytes2);
            a17.a(Math.min(a17.b(), 132));
            g0Var.f127658h = a17;
            g0Var.f127654d = com.tencent.luggage.wxa.fn.c.a(new byte[0]);
            g0Var.f127659i = 0;
            return g0Var;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f123543a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f123545c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fn.b f123546d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Class f123547e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, com.tencent.luggage.wxa.fn.b bVar, Class cls, Continuation continuation) {
            super(2, continuation);
            this.f123545c = str;
            this.f123546d = bVar;
            this.f123547e = cls;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.f123545c, this.f123546d, this.f123547e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f123543a;
            try {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return (t8) obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    a aVar = a.this;
                    String str = this.f123545c;
                    Intrinsics.checkNotNull(str);
                    com.tencent.luggage.wxa.fn.b bVar = this.f123546d;
                    Class cls = this.f123547e;
                    Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<in com.tencent.mm.protocal.protobuf.ResponseProtoBuf>");
                    this.f123543a = 1;
                    obj = aVar.a(str, bVar, cls, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return (t8) obj;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f123549c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fn.b f123550d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Class f123551e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f123552f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.cj.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6114a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f123553a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f123554b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f123555c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.fn.b f123556d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Class f123557e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f123558f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ String f123559g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6114a(a aVar, String str, com.tencent.luggage.wxa.fn.b bVar, Class cls, com.tencent.luggage.wxa.xo.b bVar2, String str2, Continuation continuation) {
                super(2, continuation);
                this.f123554b = aVar;
                this.f123555c = str;
                this.f123556d = bVar;
                this.f123557e = cls;
                this.f123558f = bVar2;
                this.f123559g = str2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C6114a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C6114a(this.f123554b, this.f123555c, this.f123556d, this.f123557e, this.f123558f, this.f123559g, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f123553a;
                try {
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        a aVar = this.f123554b;
                        String str = this.f123555c;
                        Intrinsics.checkNotNull(str);
                        com.tencent.luggage.wxa.fn.b bVar = this.f123556d;
                        Class cls = this.f123557e;
                        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<in com.tencent.mm.protocal.protobuf.ResponseProtoBuf>");
                        this.f123553a = 1;
                        obj = aVar.a(str, bVar, cls, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.f123558f.a((t8) obj);
                } catch (Exception e16) {
                    this.f123558f.a(e16);
                }
                return Unit.INSTANCE;
            }
        }

        public e(String str, com.tencent.luggage.wxa.fn.b bVar, Class cls, String str2) {
            this.f123549c = str;
            this.f123550d = bVar;
            this.f123551e = cls;
            this.f123552f = str2;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t8 call(Void r132) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new C6114a(a.this, this.f123549c, this.f123550d, this.f123551e, h.b(), this.f123552f, null), 2, null);
            return null;
        }
    }

    static {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("/cgi-bin/mmbiz-bin/js-authorize", Integer.valueOf(gdt_analysis_event.EVENT_GET_JAVA_VM_VERSION)), TuplesKt.to("/cgi-bin/mmbiz-bin/js-authorize-confirm", Integer.valueOf(gdt_analysis_event.EVENT_GET_QIMEI36)), TuplesKt.to("/cgi-bin/mmbiz-bin/js-operatewxdata", Integer.valueOf(LaunchScene.LAUNCH_SCENE_VM_NOTIFICATION)));
        f123532i = mapOf;
    }

    public a(com.tencent.luggage.wxa.c5.e runtime, com.tencent.luggage.wxa.bj.c originCgiService) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(originCgiService, "originCgiService");
        this.f123533a = runtime;
        this.f123534b = originCgiService;
        this.f123535c = "Luggage.CgiServiceImplByLibServer(" + hashCode() + ')';
        lazy = LazyKt__LazyJVMKt.lazy(new c());
        this.f123536d = lazy;
        this.f123537e = new AtomicInteger(1);
        this.f123538f = new ConcurrentHashMap();
        this.f123539g = new f(Looper.getMainLooper());
    }

    public static final a a(i iVar) {
        return f123531h.a(iVar);
    }

    public final void c() {
        this.f123539g.a((Object) null);
        Collection<b> values = this.f123538f.values();
        Intrinsics.checkNotNullExpressionValue(values, "pendingRequests.values");
        for (b bVar : values) {
            if (bVar.a().isActive()) {
                CancellableContinuation.DefaultImpls.cancel$default(bVar.a(), null, 1, null);
            }
        }
        this.f123538f.clear();
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public com.tencent.luggage.wxa.xo.d b(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class cls) {
        if (f123532i.keySet().contains(str == null ? "" : str) && bVar != null && cls != null) {
            com.tencent.luggage.wxa.xo.d b16 = h.c().b(new e(str, bVar, cls, str2));
            Intrinsics.checkNotNullExpressionValue(b16, "@Suppress(\"UNCHECKED_CAS\u2026next null\n        }\n    }");
            return b16;
        }
        com.tencent.luggage.wxa.xo.d a16 = h.a((d.a) null);
        Intrinsics.checkNotNullExpressionValue(a16, "pipeline(null)");
        return a16;
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public t8 a(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class cls) {
        Object runBlocking$default;
        if (!f123532i.keySet().contains(str == null ? "" : str) || bVar == null || cls == null) {
            return null;
        }
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new d(str, bVar, cls, null), 1, null);
        return (t8) runBlocking$default;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends b0 {

        /* renamed from: e, reason: collision with root package name */
        public final long f123560e;

        /* renamed from: f, reason: collision with root package name */
        public final int f123561f;

        public f(Looper looper) {
            super(looper);
            this.f123560e = 5000L;
            this.f123561f = 1;
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            super.d(message);
            if ((message != null ? message.what : 0) == this.f123561f) {
                Intrinsics.checkNotNull(message);
                Object obj = message.obj;
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                if (num != null) {
                    int intValue = num.intValue();
                    w.d(a.this.f123535c, "timeout for requestId:" + intValue);
                    a.this.a(intValue);
                }
            }
        }

        public final void e(int i3) {
            int i16 = this.f123561f;
            Intrinsics.checkNotNull(Integer.valueOf(i3), "null cannot be cast to non-null type kotlin.Any");
            a(a(i16, Integer.valueOf(i3)), this.f123560e);
        }

        public final void d(int i3) {
            int i16 = this.f123561f;
            Intrinsics.checkNotNull(Integer.valueOf(i3), "null cannot be cast to non-null type kotlin.Any");
            b(i16, Integer.valueOf(i3));
        }
    }

    public final void a(int i3) {
        CancellableContinuation a16;
        b bVar = (b) this.f123538f.remove(Integer.valueOf(i3));
        if (bVar != null && (a16 = bVar.a()) != null) {
            w.d(this.f123535c, "callback 'Unsupported cgi' for requestId:" + i3);
            Result.Companion companion = Result.INSTANCE;
            a16.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.TRANSFER, -1, "Unsupported cgi"))));
            return;
        }
        w.b(this.f123535c, "callbackUnsupported missing continuation for requestId:" + i3);
    }

    public final void a(int i3, boolean z16, Object obj) {
        w.d(this.f123535c, "handleLibServerResponse(requestId:" + i3 + ", support:" + z16 + ')');
        if (!z16) {
            a(i3);
            return;
        }
        b bVar = (b) this.f123538f.remove(Integer.valueOf(i3));
        if (bVar == null) {
            w.b(this.f123535c, "handleLibServerResponse supported but missing mario for requestId:" + i3);
            return;
        }
        if (obj instanceof ByteBuffer) {
            try {
                Object newInstance = bVar.b().newInstance();
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ResponseProtoBuf");
                com.tencent.luggage.wxa.fn.b a16 = ((t8) newInstance).a(com.tencent.luggage.wxa.tk.c.a((ByteBuffer) obj));
                Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ResponseProtoBuf");
                bVar.a().resumeWith(Result.m476constructorimpl((t8) a16));
                this.f123539g.d(i3);
                w.d(this.f123535c, "handleLibServerResponse succeed for requestId:" + i3);
                return;
            } catch (Exception e16) {
                w.b(this.f123535c, "handleLibServerResponse succeed but parse data failed for requestId:" + i3 + ", exception:" + e16);
                return;
            }
        }
        w.b(this.f123535c, "handleLibServerResponse succeed but responded data(" + obj + ") invalid for requestId:" + i3);
    }

    public final Object a(String str, com.tencent.luggage.wxa.fn.b bVar, Class cls, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        int andIncrement = this.f123537e.getAndIncrement();
        w.d(this.f123535c, "sendToLibServer cgiUrl:" + str + " requestId:" + andIncrement);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.f123538f.put(Boxing.boxInt(andIncrement), new b(cancellableContinuationImpl, cls));
        try {
            com.tencent.luggage.wxa.ic.l service = this.f123533a.h0();
            if (service != null) {
                Intrinsics.checkNotNullExpressionValue(service, "service");
                a.C6531a c6531a = com.tencent.luggage.wxa.o4.a.f136144a;
                Object obj = f123532i.get(str);
                Intrinsics.checkNotNull(obj);
                c6531a.a(service, andIncrement, ((Number) obj).intValue(), bVar);
            }
        } catch (com.tencent.luggage.wxa.bj.a e16) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
        }
        this.f123539g.e(andIncrement);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
