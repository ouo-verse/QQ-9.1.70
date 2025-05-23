package com.tencent.luggage.wxa.i3;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f129391a = new w();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(com.tencent.luggage.wxa.j4.g gVar);

        void onError(Throwable th5);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.p5.f f129392a;

        /* renamed from: b, reason: collision with root package name */
        public final a f129393b;

        /* renamed from: c, reason: collision with root package name */
        public final int f129394c;

        /* renamed from: d, reason: collision with root package name */
        public final String f129395d;

        /* renamed from: e, reason: collision with root package name */
        public final int f129396e;

        /* renamed from: f, reason: collision with root package name */
        public final String f129397f;

        /* renamed from: g, reason: collision with root package name */
        public final com.tencent.luggage.wxa.r5.a f129398g;

        /* renamed from: h, reason: collision with root package name */
        public final com.tencent.luggage.wxa.bk.e f129399h;

        /* renamed from: i, reason: collision with root package name */
        public final String f129400i;

        /* renamed from: j, reason: collision with root package name */
        public n0 f129401j;

        /* renamed from: k, reason: collision with root package name */
        public n0.g f129402k;

        /* renamed from: l, reason: collision with root package name */
        public final LifecycleCoroutineScope f129403l;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f129404a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(CoroutineExceptionHandler.Companion companion, b bVar) {
                super(companion);
                this.f129404a = bVar;
            }

            @Override // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(CoroutineContext coroutineContext, Throwable th5) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CoroutineExceptionHandler |instance:");
                sb5.append(this.f129404a.f129394c);
                sb5.append(" exception:");
                sb5.append(th5.getMessage());
                sb5.append(" cause:");
                Object cause = th5.getCause();
                if (cause == null) {
                    cause = "";
                }
                sb5.append(cause);
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", sb5.toString());
                a aVar = this.f129404a.f129393b;
                if (aVar != null) {
                    aVar.onError(th5);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i3.w$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6283b extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public Object f129405a;

            /* renamed from: b, reason: collision with root package name */
            public int f129406b;

            /* renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f129407c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f129408d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f129409e;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.w$b$b$a */
            /* loaded from: classes8.dex */
            public static final class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b f129410a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.j4.g f129411b;

                public a(b bVar, com.tencent.luggage.wxa.j4.g gVar) {
                    this.f129410a = bVar;
                    this.f129411b = gVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.a(this.f129410a.f129392a, this.f129410a.f129398g, this.f129411b);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.w$b$b$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6284b extends SuspendLambda implements Function2 {

                /* renamed from: a, reason: collision with root package name */
                public int f129412a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f129413b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6284b(b bVar, Continuation continuation) {
                    super(2, continuation);
                    this.f129413b = bVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((C6284b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C6284b(this.f129413b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.f129412a;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        b bVar = this.f129413b;
                        this.f129412a = 1;
                        obj = bVar.a(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return obj;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.w$b$b$c */
            /* loaded from: classes8.dex */
            public static final class c extends SuspendLambda implements Function2 {

                /* renamed from: a, reason: collision with root package name */
                public int f129414a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f129415b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(b bVar, Continuation continuation) {
                    super(2, continuation);
                    this.f129415b = bVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new c(this.f129415b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.f129414a;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        b bVar = this.f129415b;
                        this.f129414a = 1;
                        obj = bVar.b(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return obj;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.w$b$b$d */
            /* loaded from: classes8.dex */
            public static final class d extends SuspendLambda implements Function2 {

                /* renamed from: a, reason: collision with root package name */
                public int f129416a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f129417b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public d(b bVar, Continuation continuation) {
                    super(2, continuation);
                    this.f129417b = bVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new d(this.f129417b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.f129416a;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        b bVar = this.f129417b;
                        this.f129416a = 1;
                        obj = bVar.c(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6283b(AtomicBoolean atomicBoolean, b bVar, Continuation continuation) {
                super(2, continuation);
                this.f129408d = atomicBoolean;
                this.f129409e = bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C6283b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C6283b c6283b = new C6283b(this.f129408d, this.f129409e, continuation);
                c6283b.f129407c = obj;
                return c6283b;
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0220  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0230  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x027c  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0224  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x020d A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:34:0x020e  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                n0.g gVar;
                Deferred async$default;
                Deferred async$default2;
                Deferred async$default3;
                Object await;
                Deferred deferred;
                com.tencent.mm.plugin.appbrand.appcache.a aVar;
                Object await2;
                Object await3;
                i6 i6Var;
                com.tencent.mm.plugin.appbrand.appcache.a aVar2;
                Map map;
                n0 n0Var;
                a aVar3;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f129406b;
                n0 n0Var2 = null;
                try {
                    try {
                        try {
                            if (i3 == 0) {
                                ResultKt.throwOnFailure(obj);
                                CoroutineScope coroutineScope = (CoroutineScope) this.f129407c;
                                if (!this.f129408d.get()) {
                                    if (this.f129409e.f129392a.b2() == null) {
                                        com.tencent.luggage.wxa.gi.b.c(this.f129409e.f129395d, com.tencent.luggage.wxa.ik.a.f130639t);
                                        com.tencent.luggage.wxa.mc.w.f134403a.b();
                                        this.f129409e.f129392a.a(com.tencent.luggage.wxa.mc.w.a());
                                        com.tencent.luggage.wxa.gi.b.b(this.f129409e.f129395d, com.tencent.luggage.wxa.ik.a.f130639t);
                                    }
                                    b bVar = this.f129409e;
                                    n0 a16 = o0.a().a(this.f129409e.f129395d, new String[0]);
                                    if (a16 != null) {
                                        bVar.f129401j = a16;
                                        b bVar2 = this.f129409e;
                                        if (e.a.b(bVar2.f129396e)) {
                                            n0 n0Var3 = this.f129409e.f129401j;
                                            if (n0Var3 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("wxaAttributes");
                                                n0Var3 = null;
                                            }
                                            gVar = n0Var3.h();
                                            Intrinsics.checkNotNullExpressionValue(gVar, "{\n                    wx\u2026ionInfo\n                }");
                                        } else {
                                            gVar = this.f129409e.f129392a.S().X;
                                            Intrinsics.checkNotNullExpressionValue(gVar, "{\n                    ru\u2026extJson\n                }");
                                        }
                                        bVar2.f129402k = gVar;
                                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, coroutineScope.getCoroutineContext().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, new C6284b(this.f129409e, null), 2, null);
                                        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, coroutineScope.getCoroutineContext().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, new c(this.f129409e, null), 2, null);
                                        async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, coroutineScope.getCoroutineContext().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, new d(this.f129409e, null), 2, null);
                                        this.f129407c = async$default2;
                                        this.f129405a = async$default3;
                                        this.f129406b = 1;
                                        await = async$default.await(this);
                                        if (await == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        deferred = async$default2;
                                    } else {
                                        b bVar3 = this.f129409e;
                                        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --ERROR-- get NULL WxaAttributes |instance:" + bVar3.f129394c + ", appId:" + bVar3.f129395d + ", versionType:" + bVar3.f129396e + ", ts:" + w0.c());
                                        a aVar4 = bVar3.f129393b;
                                        if (aVar4 != null) {
                                            aVar4.onError(new NullPointerException("WxaAttributes is NULL"));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --ERROR-- runtime is destroyed |instance:" + this.f129409e.f129394c + ", appId:" + this.f129409e.f129395d + ", versionType:" + this.f129409e.f129396e + '}');
                                    return Unit.INSTANCE;
                                }
                            } else {
                                if (i3 != 1) {
                                    if (i3 != 2) {
                                        if (i3 == 3) {
                                            i6Var = (i6) this.f129405a;
                                            aVar2 = (com.tencent.mm.plugin.appbrand.appcache.a) this.f129407c;
                                            ResultKt.throwOnFailure(obj);
                                            await3 = obj;
                                            map = (Map) await3;
                                            String str = this.f129409e.f129395d;
                                            n0Var = this.f129409e.f129401j;
                                            if (n0Var != null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("wxaAttributes");
                                            } else {
                                                n0Var2 = n0Var;
                                            }
                                            com.tencent.luggage.wxa.j4.g sysConfig = g.a(str, n0Var2, aVar2, i6Var);
                                            if (!map.isEmpty()) {
                                                sysConfig.K = new HashMap(map);
                                            }
                                            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --END-- |instance:" + this.f129409e.f129394c + ", appId:" + this.f129409e.f129395d + ", versionType:" + this.f129409e.f129396e + ", ts:" + w0.c());
                                            aVar3 = this.f129409e.f129393b;
                                            if (aVar3 != null) {
                                                Intrinsics.checkNotNullExpressionValue(sysConfig, "sysConfig");
                                                aVar3.a(sysConfig);
                                            }
                                            com.tencent.luggage.wxa.zp.h.f146825d.execute(new a(this.f129409e, sysConfig));
                                            return Unit.INSTANCE;
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    com.tencent.mm.plugin.appbrand.appcache.a aVar5 = (com.tencent.mm.plugin.appbrand.appcache.a) this.f129405a;
                                    async$default3 = (Deferred) this.f129407c;
                                    ResultKt.throwOnFailure(obj);
                                    aVar = aVar5;
                                    await2 = obj;
                                    i6 i6Var2 = (i6) await2;
                                    this.f129407c = aVar;
                                    this.f129405a = i6Var2;
                                    this.f129406b = 3;
                                    await3 = async$default3.await(this);
                                    if (await3 != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i6Var = i6Var2;
                                    aVar2 = aVar;
                                    map = (Map) await3;
                                    String str2 = this.f129409e.f129395d;
                                    n0Var = this.f129409e.f129401j;
                                    if (n0Var != null) {
                                    }
                                    com.tencent.luggage.wxa.j4.g sysConfig2 = g.a(str2, n0Var2, aVar2, i6Var);
                                    if (!map.isEmpty()) {
                                    }
                                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --END-- |instance:" + this.f129409e.f129394c + ", appId:" + this.f129409e.f129395d + ", versionType:" + this.f129409e.f129396e + ", ts:" + w0.c());
                                    aVar3 = this.f129409e.f129393b;
                                    if (aVar3 != null) {
                                    }
                                    com.tencent.luggage.wxa.zp.h.f146825d.execute(new a(this.f129409e, sysConfig2));
                                    return Unit.INSTANCE;
                                }
                                Deferred deferred2 = (Deferred) this.f129405a;
                                deferred = (Deferred) this.f129407c;
                                ResultKt.throwOnFailure(obj);
                                await = obj;
                                async$default3 = deferred2;
                            }
                            aVar = (com.tencent.mm.plugin.appbrand.appcache.a) await;
                            this.f129407c = async$default3;
                            this.f129405a = aVar;
                            this.f129406b = 2;
                            await2 = deferred.await(this);
                            if (await2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i6 i6Var22 = (i6) await2;
                            this.f129407c = aVar;
                            this.f129405a = i6Var22;
                            this.f129406b = 3;
                            await3 = async$default3.await(this);
                            if (await3 != coroutine_suspended) {
                            }
                        } catch (Exception e16) {
                            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --ERROR-- get launchPB failed by " + e16 + " |instance:" + this.f129409e.f129394c + ", appId:" + this.f129409e.f129395d + ", versionType:" + this.f129409e.f129396e + ", ts:" + w0.c());
                            a aVar6 = this.f129409e.f129393b;
                            if (aVar6 != null) {
                                aVar6.onError(e16);
                                Unit unit2 = Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --ERROR-- get wxaPkgWrappingInfo failed by " + e17 + " |instance:" + this.f129409e.f129394c + ", appId:" + this.f129409e.f129395d + ", versionType:" + this.f129409e.f129396e + ", ts:" + w0.c());
                        a aVar7 = this.f129409e.f129393b;
                        if (aVar7 != null) {
                            aVar7.onError(e17);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                } catch (Exception e18) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --ERROR-- get PluginJsApiInfo failed by " + e18 + " |instance:" + this.f129409e.f129394c + ", appId:" + this.f129409e.f129395d + ", versionType:" + this.f129409e.f129396e + ", ts:" + w0.c());
                    a aVar8 = this.f129409e.f129393b;
                    if (aVar8 != null) {
                        aVar8.onError(e18);
                        Unit unit4 = Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f129418a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Job f129419b;

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f129420a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Job f129421b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(AtomicBoolean atomicBoolean, Job job) {
                    super(0);
                    this.f129420a = atomicBoolean;
                    this.f129421b = job;
                }

                public final void a() {
                    this.f129420a.set(true);
                    if (!this.f129421b.isCompleted()) {
                        JobKt__JobKt.cancel$default(this.f129421b, "Runtime finished", null, 2, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(AtomicBoolean atomicBoolean, Job job) {
                super(1);
                this.f129418a = atomicBoolean;
                this.f129419b = job;
            }

            public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
                Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
                lifecycle.b(new a(this.f129418a, this.f129419b));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((com.tencent.luggage.wxa.e5.h) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements com.tencent.luggage.wxa.uo.b {

            /* renamed from: b, reason: collision with root package name */
            public static final d f129422b = new d();

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.tencent.mm.plugin.appbrand.appcache.a call(com.tencent.luggage.wxa.ap.b it) {
                try {
                    j jVar = new j();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    return jVar.call(it);
                } catch (Throwable th5) {
                    com.tencent.luggage.wxa.xo.h.a().a(th5);
                    return null;
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e implements e.c {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f129424b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Continuation f129425c;

            public e(long j3, Continuation continuation) {
                this.f129424b = j3;
                this.f129425c = continuation;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(com.tencent.mm.plugin.appbrand.appcache.a aVar) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "|runProfiled| onSuccess appId:" + b.this.f129395d + ", ts:" + w0.c() + ", cost:" + (w0.a() - this.f129424b));
                x xVar = x.f129431a;
                String wxaInstanceId = b.this.f129400i;
                Intrinsics.checkNotNullExpressionValue(wxaInstanceId, "wxaInstanceId");
                x.a(xVar, wxaInstanceId, x.e.GET_WXA_PKG, x.d.OK, null, 8, null);
                Continuation continuation = this.f129425c;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNull(aVar);
                continuation.resumeWith(Result.m476constructorimpl(aVar));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class f implements e.a {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f129427b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Continuation f129428c;

            public f(long j3, Continuation continuation) {
                this.f129427b = j3;
                this.f129428c = continuation;
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public final void a(Object obj) {
                Throwable error;
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "|runProfiled| onError(" + obj + ") appId:" + b.this.f129395d + ", ts:" + w0.c() + ", cost:" + (w0.a() - this.f129427b));
                if (obj instanceof Throwable) {
                    error = (Throwable) obj;
                } else {
                    error = new Error(obj.toString());
                }
                x xVar = x.f129431a;
                String wxaInstanceId = b.this.f129400i;
                Intrinsics.checkNotNullExpressionValue(wxaInstanceId, "wxaInstanceId");
                xVar.a(wxaInstanceId, x.e.GET_WXA_PKG, x.d.FAIL, error.getMessage());
                Continuation continuation = this.f129428c;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(error)));
            }
        }

        public b(com.tencent.luggage.wxa.p5.f runtime, a aVar) {
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            this.f129392a = runtime;
            this.f129393b = aVar;
            this.f129394c = hashCode();
            this.f129395d = runtime.getAppId();
            this.f129396e = runtime.l0();
            this.f129397f = runtime.O();
            com.tencent.luggage.wxa.r5.a S = runtime.S();
            this.f129398g = S;
            this.f129399h = runtime.L1();
            this.f129400i = S.k();
            LifecycleOwner T = runtime.T();
            Intrinsics.checkNotNullExpressionValue(T, "runtime.lifecycleOwner");
            this.f129403l = LifecycleOwnerKt.getLifecycleScope(T);
        }

        public final Object b(Continuation continuation) {
            l lVar = new l();
            com.tencent.luggage.wxa.p5.f fVar = this.f129392a;
            n0 n0Var = this.f129401j;
            if (n0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaAttributes");
                n0Var = null;
            }
            return lVar.a(fVar, n0Var, continuation);
        }

        public final Object c(Continuation continuation) {
            k kVar = new k();
            com.tencent.luggage.wxa.p5.f fVar = this.f129392a;
            n0.g gVar = this.f129402k;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaVersionInfo");
                gVar = null;
            }
            return kVar.a(fVar, gVar, continuation);
        }

        public final void a() {
            Job launch$default;
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "execute --START-- |instance:" + this.f129394c + ", appId:" + this.f129395d + ", versionType:" + this.f129396e + ", ts:" + w0.c());
            a aVar = new a(CoroutineExceptionHandler.INSTANCE, this);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.f129403l, Dispatchers.getIO().plus(aVar), null, new C6283b(atomicBoolean, this, null), 2, null);
            com.tencent.luggage.wxa.e5.l.f124555a.a(this.f129392a, new c(atomicBoolean, launch$default));
        }

        public final Object a(Continuation continuation) {
            Continuation intercepted;
            Object coroutine_suspended;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            long a16 = w0.a();
            x xVar = x.f129431a;
            String wxaInstanceId = this.f129400i;
            Intrinsics.checkNotNullExpressionValue(wxaInstanceId, "wxaInstanceId");
            x.a(xVar, wxaInstanceId, x.e.GET_WXA_PKG, x.d.START, null, 8, null);
            com.tencent.luggage.wxa.p5.f fVar = this.f129392a;
            n0 n0Var = this.f129401j;
            if (n0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaAttributes");
                n0Var = null;
            }
            com.tencent.luggage.wxa.xo.h.a(fVar, n0Var).c(d.f129422b).a(new e(a16, safeContinuation)).a(new f(a16, safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f129429a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129430b;

        public c(a aVar, com.tencent.luggage.wxa.p5.f fVar) {
            this.f129429a = aVar;
            this.f129430b = fVar;
        }

        @Override // com.tencent.luggage.wxa.i3.w.a
        public void a(com.tencent.luggage.wxa.j4.g config) {
            Intrinsics.checkNotNullParameter(config, "config");
            a aVar = this.f129429a;
            if (aVar != null) {
                aVar.a(config);
            }
        }

        @Override // com.tencent.luggage.wxa.i3.w.a
        public void onError(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            a aVar = this.f129429a;
            if (aVar != null) {
                aVar.onError(throwable);
            }
            v.a(this.f129430b.getAppId(), null, "WxaLaunchPrepareProcess.waitForPrepared.onError(" + throwable + ')', 2, null);
        }
    }

    public static final void a(com.tencent.luggage.wxa.p5.f rt5, a aVar) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        new b(rt5, new c(aVar, rt5)).a();
    }
}
