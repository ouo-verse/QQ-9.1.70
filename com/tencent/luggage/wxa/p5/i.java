package com.tencent.luggage.wxa.p5;

import com.tencent.luggage.wxa.ei.u;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.q5.a;
import com.tencent.luggage.wxa.q5.e;
import com.tencent.luggage.wxa.tn.w;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends g.x {

    /* renamed from: m, reason: collision with root package name */
    public static final a f137312m = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final String f137313b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f137314c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f137315d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.q5.a f137316e;

    /* renamed from: f, reason: collision with root package name */
    public final Function0 f137317f;

    /* renamed from: g, reason: collision with root package name */
    public final Function0 f137318g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.a6.a f137319h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.p5.e f137320i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f137321j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f137322k;

    /* renamed from: l, reason: collision with root package name */
    public Job f137323l;

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
    /* loaded from: classes8.dex */
    public static final class b implements a.InterfaceC6617a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f137324a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f137325b;

        public b(Continuation continuation, Function0 function0) {
            this.f137324a = continuation;
            this.f137325b = function0;
        }

        @Override // com.tencent.luggage.wxa.q5.a.InterfaceC6617a
        public final void onReady() {
            Continuation continuation = this.f137324a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(this.f137325b.invoke()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f137326a;

        public c(Continuation continuation) {
            this.f137326a = continuation;
        }

        @Override // com.tencent.luggage.wxa.q5.e.c
        public void a() {
            Continuation continuation = this.f137326a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // com.tencent.luggage.wxa.q5.e.c
        public void b() {
            Continuation continuation = this.f137326a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f137327a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Continuation f137329c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f137330a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i iVar) {
                super(0);
                this.f137330a = iVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.tencent.luggage.wxa.p5.e invoke() {
                return (com.tencent.luggage.wxa.p5.e) this.f137330a.f137316e.b(this.f137330a.f137313b);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137331a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f137332b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(i iVar, Continuation continuation) {
                super(2, continuation);
                this.f137332b = iVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new b(this.f137332b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f137331a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    i iVar = this.f137332b;
                    this.f137331a = 1;
                    obj = iVar.a(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137333a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Continuation f137334b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ i f137335c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Continuation continuation, i iVar, Continuation continuation2) {
                super(2, continuation2);
                this.f137334b = continuation;
                this.f137335c = iVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new c(this.f137334b, this.f137335c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f137333a == 0) {
                    ResultKt.throwOnFailure(obj);
                    Continuation continuation = this.f137334b;
                    Object invoke = this.f137335c.f137318g.invoke();
                    com.tencent.luggage.wxa.p5.e eVar = (com.tencent.luggage.wxa.p5.e) invoke;
                    if (eVar != null) {
                        eVar.a(com.tencent.luggage.wxa.dk.a.PreloadBeforeRuntimeInit);
                    }
                    com.tencent.luggage.wxa.gi.b.b(this.f137335c.f137313b, com.tencent.luggage.wxa.ik.a.f130641v);
                    continuation.resumeWith(Result.m476constructorimpl(invoke));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Continuation continuation, Continuation continuation2) {
            super(2, continuation2);
            this.f137329c = continuation;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.f137329c, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00e6 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            MainCoroutineDispatcher main;
            c cVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f137327a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    com.tencent.luggage.wxa.gi.b.b(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130629j);
                    com.tencent.luggage.wxa.gi.b.c(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130641v);
                    w.d("WxaRuntimeBoostPrepareProcess", "not use preloadPage, shouldInitXWeb:" + i.this.j());
                    main = Dispatchers.getMain();
                    cVar = new c(this.f137329c, i.this, null);
                    this.f137327a = 3;
                    if (BuildersKt.withContext(main, cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                com.tencent.luggage.wxa.gi.b.c(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130640u);
                i iVar = i.this;
                a aVar = new a(iVar);
                this.f137327a = 1;
                obj = iVar.a(aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            com.tencent.luggage.wxa.p5.e eVar = (com.tencent.luggage.wxa.p5.e) obj;
            if (eVar != null) {
                i iVar2 = i.this;
                Continuation continuation = this.f137329c;
                w.d("WxaRuntimeBoostPrepareProcess", "use preloadPage");
                com.tencent.luggage.wxa.gi.b.b(iVar2.f137313b, com.tencent.luggage.wxa.ik.a.f130640u);
                iVar2.a(true);
                continuation.resumeWith(Result.m476constructorimpl(eVar));
                return Unit.INSTANCE;
            }
            com.tencent.luggage.wxa.gi.b.b(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130640u);
            if (i.this.j()) {
                com.tencent.luggage.wxa.gi.b.c(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130629j);
                CoroutineDispatcher io5 = Dispatchers.getIO();
                b bVar = new b(i.this, null);
                this.f137327a = 2;
                if (BuildersKt.withContext(io5, bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                com.tencent.luggage.wxa.gi.b.b(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130629j);
            }
            com.tencent.luggage.wxa.gi.b.c(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130641v);
            w.d("WxaRuntimeBoostPrepareProcess", "not use preloadPage, shouldInitXWeb:" + i.this.j());
            main = Dispatchers.getMain();
            cVar = new c(this.f137329c, i.this, null);
            this.f137327a = 3;
            if (BuildersKt.withContext(main, cVar, this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f137336a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Continuation f137338c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f137339a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i iVar) {
                super(0);
                this.f137339a = iVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.tencent.luggage.wxa.a6.a invoke() {
                return (com.tencent.luggage.wxa.a6.a) this.f137339a.f137316e.a(this.f137339a.f137313b);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Continuation f137340a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f137341b;

            public b(Continuation continuation, i iVar) {
                this.f137340a = continuation;
                this.f137341b = iVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Continuation continuation = this.f137340a;
                Object invoke = this.f137341b.f137317f.invoke();
                ((com.tencent.luggage.wxa.a6.a) invoke).Z();
                com.tencent.luggage.wxa.gi.b.b(this.f137341b.f137313b, com.tencent.luggage.wxa.ik.a.f130643x);
                continuation.resumeWith(Result.m476constructorimpl(invoke));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Continuation continuation, Continuation continuation2) {
            super(2, continuation2);
            this.f137338c = continuation;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new e(this.f137338c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f137336a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                com.tencent.luggage.wxa.gi.b.c(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130642w);
                i iVar = i.this;
                a aVar = new a(iVar);
                this.f137336a = 1;
                obj = iVar.a(aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            com.tencent.luggage.wxa.a6.a aVar2 = (com.tencent.luggage.wxa.a6.a) obj;
            if (aVar2 != null) {
                i iVar2 = i.this;
                Continuation continuation = this.f137338c;
                w.d("WxaRuntimeBoostPrepareProcess", "use preloadService");
                com.tencent.luggage.wxa.gi.b.b(iVar2.f137313b, com.tencent.luggage.wxa.ik.a.f130642w);
                u uVar = (u) aVar2.getJsRuntime().a(u.class);
                if (uVar != null) {
                    uVar.a();
                }
                iVar2.b(true);
                continuation.resumeWith(Result.m476constructorimpl(aVar2));
                return Unit.INSTANCE;
            }
            com.tencent.luggage.wxa.gi.b.b(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130642w);
            com.tencent.luggage.wxa.gi.b.c(i.this.f137313b, com.tencent.luggage.wxa.ik.a.f130643x);
            w.d("WxaRuntimeBoostPrepareProcess", "not use preloadService");
            com.tencent.luggage.wxa.zp.h.f146825d.c(new b(this.f137338c, i.this));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f137342a;

        /* renamed from: b, reason: collision with root package name */
        public int f137343b;

        /* renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f137344c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137346a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f137347b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i iVar, Continuation continuation) {
                super(2, continuation);
                this.f137347b = iVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f137347b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f137346a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    i iVar = this.f137347b;
                    this.f137346a = 1;
                    obj = iVar.b(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137348a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f137349b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(i iVar, Continuation continuation) {
                super(2, continuation);
                this.f137349b = iVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new b(this.f137349b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f137348a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    i iVar = this.f137349b;
                    this.f137348a = 1;
                    obj = iVar.c(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
        }

        public f(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            f fVar = new f(continuation);
            fVar.f137344c = obj;
            return fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Deferred async$default;
            Deferred async$default2;
            Deferred deferred;
            i iVar;
            i iVar2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f137343b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        iVar2 = (i) this.f137344c;
                        ResultKt.throwOnFailure(obj);
                        iVar2.f137320i = (com.tencent.luggage.wxa.p5.e) obj;
                        i.this.d();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                iVar = (i) this.f137342a;
                deferred = (Deferred) this.f137344c;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f137344c;
                com.tencent.luggage.wxa.mc.w.f134403a.b();
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(i.this, null), 3, null);
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a(i.this, null), 3, null);
                i iVar3 = i.this;
                this.f137344c = async$default2;
                this.f137342a = iVar3;
                this.f137343b = 1;
                Object await = async$default.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = async$default2;
                obj = await;
                iVar = iVar3;
            }
            iVar.f137319h = (com.tencent.luggage.wxa.a6.a) obj;
            i iVar4 = i.this;
            this.f137344c = iVar4;
            this.f137342a = null;
            this.f137343b = 2;
            Object await2 = deferred.await(this);
            if (await2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            iVar2 = iVar4;
            obj = await2;
            iVar2.f137320i = (com.tencent.luggage.wxa.p5.e) obj;
            i.this.d();
            return Unit.INSTANCE;
        }
    }

    public i(String appId, boolean z16, boolean z17, com.tencent.luggage.wxa.q5.a processSharedPreloader, Function0 serviceFactory, Function0 pageViewFactory) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(processSharedPreloader, "processSharedPreloader");
        Intrinsics.checkNotNullParameter(serviceFactory, "serviceFactory");
        Intrinsics.checkNotNullParameter(pageViewFactory, "pageViewFactory");
        this.f137313b = appId;
        this.f137314c = z16;
        this.f137315d = z17;
        this.f137316e = processSharedPreloader;
        this.f137317f = serviceFactory;
        this.f137318g = pageViewFactory;
    }

    @Override // com.tencent.luggage.wxa.ic.g.x
    public String b() {
        return "WxaRuntimeBoostPrepareProcess";
    }

    public final com.tencent.luggage.wxa.p5.e f() {
        return this.f137320i;
    }

    public final com.tencent.luggage.wxa.a6.a g() {
        return this.f137319h;
    }

    public final boolean h() {
        return this.f137322k;
    }

    public final boolean i() {
        return this.f137321j;
    }

    public final boolean j() {
        if (!this.f137314c && this.f137315d) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ic.g.x
    public void c() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new f(null), 3, null);
        this.f137323l = launch$default;
    }

    public final void b(boolean z16) {
        this.f137321j = z16;
    }

    public final Object c(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new e(safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object b(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new d(safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void a(boolean z16) {
        this.f137322k = z16;
    }

    @Override // com.tencent.luggage.wxa.ic.g.x
    public void a() {
        Job job = this.f137323l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final Object a(Function0 function0, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (!this.f137316e.a(new b(safeContinuation, function0))) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(function0.invoke()));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final Object a(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (com.tencent.luggage.wxa.q5.e.e()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        } else {
            com.tencent.luggage.wxa.q5.e.a(new c(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
