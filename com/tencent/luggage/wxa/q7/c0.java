package com.tencent.luggage.wxa.q7;

import com.tencent.luggage.wxa.q5.a;
import com.tencent.luggage.wxa.z4.f;
import com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f137935a = new c0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements a.InterfaceC6617a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.q5.a f137936a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f137937b;

        public a(com.tencent.luggage.wxa.q5.a aVar, Continuation continuation) {
            this.f137936a = aVar;
            this.f137937b = continuation;
        }

        @Override // com.tencent.luggage.wxa.q5.a.InterfaceC6617a
        public final void onReady() {
            if (this.f137936a.a() != null) {
                Continuation continuation = this.f137937b;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(PreloadWxaProcessEnvResult.Preload_OK));
            } else {
                Continuation continuation2 = this.f137937b;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(PreloadWxaProcessEnvResult.Preload_Fail));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/va/b;", "kotlin.jvm.PlatformType", "enTypeOrdinal", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxaapi/PreloadWxaProcessEnvResult;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/va/b;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final b f137938a = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137939a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.z4.i f137940b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ka.i f137941c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.q5.a f137942d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.z4.i iVar, com.tencent.luggage.wxa.ka.i iVar2, com.tencent.luggage.wxa.q5.a aVar, Continuation continuation) {
                super(2, continuation);
                this.f137940b = iVar;
                this.f137941c = iVar2;
                this.f137942d = aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f137940b, this.f137941c, this.f137942d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f137939a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (com.tencent.luggage.wxa.tn.z.c() == null) {
                        com.tencent.luggage.wxa.tn.w.b("WxaProcessPreloaderService", "preloadNextProcess(wxa) type:" + this.f137940b + ", MMApplicationContext.getContext()==NULL");
                        com.tencent.luggage.wxa.ka.i iVar = this.f137941c;
                        if (iVar != null) {
                            iVar.a(PreloadWxaProcessEnvResult.Preload_Fail);
                        }
                        return Unit.INSTANCE;
                    }
                    c0 c0Var = c0.f137935a;
                    com.tencent.luggage.wxa.q5.a aVar = this.f137942d;
                    this.f137939a = 1;
                    obj = c0Var.a(aVar, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                PreloadWxaProcessEnvResult preloadWxaProcessEnvResult = (PreloadWxaProcessEnvResult) obj;
                com.tencent.luggage.wxa.tn.w.d("WxaProcessPreloaderService", "preloadNextProcess(wxa) type:" + this.f137940b + ", result:" + preloadWxaProcessEnvResult);
                com.tencent.luggage.wxa.ka.i iVar2 = this.f137941c;
                if (iVar2 != null) {
                    iVar2.a(preloadWxaProcessEnvResult);
                }
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q7.c0$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public /* synthetic */ class C6625b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f137943a;

            static {
                int[] iArr = new int[com.tencent.luggage.wxa.z4.i.values().length];
                iArr[com.tencent.luggage.wxa.z4.i.WASERVICE.ordinal()] = 1;
                iArr[com.tencent.luggage.wxa.z4.i.WAGAME.ordinal()] = 2;
                f137943a = iArr;
            }
        }

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.b bVar, com.tencent.luggage.wxa.ka.i iVar) {
            com.tencent.luggage.wxa.q5.a aVar;
            com.tencent.luggage.wxa.z4.i iVar2 = com.tencent.luggage.wxa.z4.i.values()[bVar.f143313a];
            int i3 = C6625b.f137943a[iVar2.ordinal()];
            if (i3 == 1) {
                aVar = com.tencent.luggage.wxa.g7.a.f126576i;
            } else {
                if (i3 != 2) {
                    com.tencent.luggage.wxa.tn.w.b("WxaProcessPreloaderService", "preloadNextProcess(wxa) invalid type");
                    if (iVar != null) {
                        iVar.a(PreloadWxaProcessEnvResult.Preload_Fail);
                        return;
                    }
                    return;
                }
                aVar = com.tencent.luggage.wxa.g7.c.f126580a;
            }
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new a(iVar2, iVar, aVar, null), 3, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.ka.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f137944a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z4.i f137945b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxaapi.g f137946c;

        public c(String str, com.tencent.luggage.wxa.z4.i iVar, com.tencent.luggage.wxaapi.g gVar) {
            this.f137944a = str;
            this.f137945b = iVar;
            this.f137946c = gVar;
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(PreloadWxaProcessEnvResult preloadWxaProcessEnvResult) {
            com.tencent.luggage.wxa.tn.w.d("WxaProcessPreloaderService", "preloadNextProcess(main) process:" + this.f137944a + " type:" + this.f137945b.name() + " result:" + preloadWxaProcessEnvResult);
            com.tencent.luggage.wxaapi.g gVar = this.f137946c;
            if (gVar != null) {
                gVar.onPreloadResult(preloadWxaProcessEnvResult);
            }
        }
    }

    public final void a(int i3, com.tencent.luggage.wxaapi.g gVar) {
        com.tencent.luggage.wxa.z4.i iVar;
        if (i3 == 1) {
            iVar = com.tencent.luggage.wxa.z4.i.WASERVICE;
        } else if (i3 != 2) {
            return;
        } else {
            iVar = com.tencent.luggage.wxa.z4.i.WAGAME;
        }
        f.a aVar = com.tencent.luggage.wxa.z4.f.f146283b;
        com.tencent.luggage.wxa.z4.e a16 = aVar.a().a(iVar);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.d("WxaProcessPreloaderService", "preloadNextProcess(main), available process not found from ProcessManager, use fallback instance");
            a16 = aVar.a().a(0);
        }
        String e16 = a16.e();
        if (e16 == null) {
            com.tencent.luggage.wxa.tn.w.b("WxaProcessPreloaderService", "preloadNextProcess(main) get invalid process name");
            if (gVar != null) {
                gVar.onPreloadResult(PreloadWxaProcessEnvResult.Preload_Fail);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("WxaProcessPreloaderService", "preloadNextProcess(main) process:" + e16 + " type:" + iVar.name());
        a16.a(iVar);
        com.tencent.luggage.wxa.ka.o.a(e16, new com.tencent.luggage.wxa.va.b(iVar.ordinal()), b.f137938a.getClass(), new c(e16, iVar, gVar));
    }

    public final Object a(com.tencent.luggage.wxa.q5.a aVar, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.luggage.wxa.wd.a.a();
        com.tencent.luggage.wxa.mc.w.f134403a.b();
        a aVar2 = new a(aVar, safeContinuation);
        if (!aVar.a(aVar2)) {
            if (aVar.a() != null) {
                Result.Companion companion = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(PreloadWxaProcessEnvResult.Preload_OK));
            } else if (aVar.c()) {
                aVar.a(aVar2, true, false);
            } else if (aVar.b()) {
                Result.Companion companion2 = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(PreloadWxaProcessEnvResult.Preload_HitFrequencyLimit));
            } else {
                aVar.a(aVar2, false, false);
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
