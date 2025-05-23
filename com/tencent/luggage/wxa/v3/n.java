package com.tencent.luggage.wxa.v3;

import com.tencent.luggage.wxa.hn.wg;
import com.tencent.luggage.wxa.hn.xg;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xo.e;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    public static final a f143157f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Integer[] f143158g = {0, 1, 3, 5};

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.v3.d f143159a;

    /* renamed from: b, reason: collision with root package name */
    public final String f143160b;

    /* renamed from: c, reason: collision with root package name */
    public final Function1 f143161c;

    /* renamed from: d, reason: collision with root package name */
    public final Function1 f143162d;

    /* renamed from: e, reason: collision with root package name */
    public Job f143163e;

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
    public static final class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f143164a;

        public b(Continuation continuation) {
            this.f143164a = continuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(xg xgVar) {
            this.f143164a.resumeWith(Result.m476constructorimpl(xgVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f143165a;

        public c(Continuation continuation) {
            this.f143165a = continuation;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            this.f143165a.resumeWith(Result.m476constructorimpl(null));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.vo.a {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.vo.a
        public final void g() {
            boolean z16;
            if (n.this.f143163e != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            w.b("Luggage.WXA.OpenSDKTicketTransferResponseStepChecker", "kill checker, request:" + n.this.f143159a + " ticket:" + n.this.f143160b + " started:" + z16);
            if (z16) {
                Job job = n.this.f143163e;
                if (job == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("job");
                    job = null;
                }
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public Object f143167a;

        /* renamed from: b, reason: collision with root package name */
        public Object f143168b;

        /* renamed from: c, reason: collision with root package name */
        public int f143169c;

        /* renamed from: d, reason: collision with root package name */
        public int f143170d;

        /* renamed from: e, reason: collision with root package name */
        public int f143171e;

        /* renamed from: f, reason: collision with root package name */
        public int f143172f;

        /* renamed from: g, reason: collision with root package name */
        public /* synthetic */ Object f143173g;

        public e(Continuation continuation) {
            super(2, continuation);
        }

        public static final void b(n nVar, int i3, String str) {
            w.d("Luggage.WXA.OpenSDKTicketTransferResponseStepChecker", "check() with request:" + nVar.f143159a + " ticket:" + nVar.f143160b + " step:" + i3 + ", " + str);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            e eVar = new e(continuation);
            eVar.f143173g = obj;
            return eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00b9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b2 -> B:6:0x0028). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            Integer[] numArr;
            n nVar;
            int length;
            int i3;
            e eVar;
            e eVar2;
            CoroutineScope coroutineScope2;
            Integer[] numArr2;
            n nVar2;
            int i16;
            int i17;
            int i18;
            int i19;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i26 = this.f143172f;
            if (i26 != 0) {
                if (i26 != 1) {
                    if (i26 == 2) {
                        i18 = this.f143171e;
                        i17 = this.f143170d;
                        i16 = this.f143169c;
                        nVar2 = (n) this.f143168b;
                        numArr2 = (Integer[]) this.f143167a;
                        coroutineScope2 = (CoroutineScope) this.f143173g;
                        ResultKt.throwOnFailure(obj);
                        Object a16 = obj;
                        eVar2 = this;
                        Integer[] numArr3 = numArr2;
                        int i27 = i17;
                        numArr = numArr3;
                        n nVar3 = nVar2;
                        int i28 = i16;
                        nVar = nVar3;
                        xg xgVar = (xg) a16;
                        if (xgVar == null) {
                            i19 = xgVar.f129045e;
                        } else {
                            i19 = -1;
                        }
                        if (i19 != 2) {
                            if (i19 != 3) {
                                if (i19 != 4) {
                                    a(nVar, i18, "get UNKNOWN(" + i19 + ')');
                                } else {
                                    a(nVar, i18, "get EXPIRED");
                                    nVar.f143162d.invoke(new TimeoutException());
                                    return Unit.INSTANCE;
                                }
                            } else {
                                Intrinsics.checkNotNull(xgVar);
                                String it = xgVar.f129046f.d();
                                b(nVar, i18, "get FINISHED, callback data:" + it);
                                Function1 function1 = nVar.f143161c;
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                function1.invoke(it);
                                return Unit.INSTANCE;
                            }
                        } else {
                            b(nVar, i18, "get CONSUMED");
                        }
                        int i29 = i28 + 1;
                        length = i27;
                        i3 = i29;
                        coroutineScope = coroutineScope2;
                        eVar = eVar2;
                        if (i3 < length) {
                            int intValue = numArr[i3].intValue();
                            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                return Unit.INSTANCE;
                            }
                            eVar.f143173g = coroutineScope;
                            eVar.f143167a = numArr;
                            eVar.f143168b = nVar;
                            eVar.f143169c = i3;
                            eVar.f143170d = length;
                            eVar.f143171e = intValue;
                            eVar.f143172f = 1;
                            if (DelayKt.delay(intValue * 1000, eVar) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            e eVar3 = eVar;
                            coroutineScope2 = coroutineScope;
                            i18 = intValue;
                            eVar2 = eVar3;
                            int i36 = i3;
                            numArr2 = numArr;
                            i17 = length;
                            nVar2 = nVar;
                            i16 = i36;
                            if (CoroutineScopeKt.isActive(coroutineScope2)) {
                                return Unit.INSTANCE;
                            }
                            eVar2.f143173g = coroutineScope2;
                            eVar2.f143167a = numArr2;
                            eVar2.f143168b = nVar2;
                            eVar2.f143169c = i16;
                            eVar2.f143170d = i17;
                            eVar2.f143171e = i18;
                            eVar2.f143172f = 2;
                            a16 = nVar2.a(eVar2);
                            if (a16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Integer[] numArr32 = numArr2;
                            int i272 = i17;
                            numArr = numArr32;
                            n nVar32 = nVar2;
                            int i282 = i16;
                            nVar = nVar32;
                            xg xgVar2 = (xg) a16;
                            if (xgVar2 == null) {
                            }
                            if (i19 != 2) {
                            }
                            int i292 = i282 + 1;
                            length = i272;
                            i3 = i292;
                            coroutineScope = coroutineScope2;
                            eVar = eVar2;
                            if (i3 < length) {
                                w.d("Luggage.WXA.OpenSDKTicketTransferResponseStepChecker", "startCheck(), steps tried and timeout finally, request:" + n.this.f143159a + ", ticket:" + n.this.f143160b);
                                n.this.f143162d.invoke(new TimeoutException());
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    i18 = this.f143171e;
                    i17 = this.f143170d;
                    i16 = this.f143169c;
                    nVar2 = (n) this.f143168b;
                    numArr2 = (Integer[]) this.f143167a;
                    coroutineScope2 = (CoroutineScope) this.f143173g;
                    ResultKt.throwOnFailure(obj);
                    eVar2 = this;
                    if (CoroutineScopeKt.isActive(coroutineScope2)) {
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.f143173g;
                numArr = n.f143158g;
                nVar = n.this;
                length = numArr.length;
                i3 = 0;
                eVar = this;
                if (i3 < length) {
                }
            }
        }

        public static final void a(n nVar, int i3, String str) {
            w.b("Luggage.WXA.OpenSDKTicketTransferResponseStepChecker", "check() with request:" + nVar.f143159a + " ticket:" + nVar.f143160b + " step:" + i3 + ", " + str);
        }
    }

    public n(com.tencent.luggage.wxa.v3.d request, String ticket, Function1 onSuccess, Function1 onError) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.f143159a = request;
        this.f143160b = ticket;
        this.f143161c = onSuccess;
        this.f143162d = onError;
    }

    public final void b() {
        Job launch$default;
        this.f143159a.f143055a.b(new d());
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new e(null), 3, null);
        this.f143163e = launch$default;
    }

    public final Object a(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.luggage.wxa.h1.b b16 = this.f143159a.f143055a.b(com.tencent.luggage.wxa.bj.c.class);
        Intrinsics.checkNotNull(b16);
        String f140742c = this.f143159a.f143055a.getF140742c();
        wg wgVar = new wg();
        wgVar.f128979e = this.f143160b;
        Unit unit = Unit.INSTANCE;
        ((com.tencent.luggage.wxa.bj.c) b16).b("/cgi-bin/mmbiz-bin/wxaruntime/getdeeplinkinfo", f140742c, wgVar, xg.class).a(new b(safeContinuation)).a(new c(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
