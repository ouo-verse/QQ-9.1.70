package com.tencent.luggage.wxa.i3;

import android.os.SystemClock;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.d6;
import com.tencent.luggage.wxa.hn.eh;
import com.tencent.luggage.wxa.hn.h6;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.hn.vd;
import com.tencent.luggage.wxa.hn.xe;
import com.tencent.luggage.wxa.hn.z0;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.n3.f0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.l0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements com.tencent.luggage.wxa.uo.b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f129301b = new a(null);

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
    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f129302a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129304c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n0 f129305d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129306e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.p5.f fVar, n0 n0Var, com.tencent.luggage.wxa.xo.b bVar, Continuation continuation) {
            super(2, continuation);
            this.f129304c = fVar;
            this.f129305d = n0Var;
            this.f129306e = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f129304c, this.f129305d, this.f129306e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f129302a;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    l lVar = l.this;
                    com.tencent.luggage.wxa.p5.f rt5 = this.f129304c;
                    Intrinsics.checkNotNullExpressionValue(rt5, "rt");
                    n0 wxaAttributes = this.f129305d;
                    Intrinsics.checkNotNullExpressionValue(wxaAttributes, "wxaAttributes");
                    this.f129302a = 1;
                    obj = lVar.a(rt5, wxaAttributes, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.f129306e.a((i6) obj);
            } catch (Throwable th5) {
                this.f129306e.a(th5);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f129307a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129309c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f129310d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f129311e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f129312f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Continuation f129313g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f129314h;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f129315a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l f129316b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129317c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f129318d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f129319e;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.l$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class RunnableC6279a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129320a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ z0 f129321b;

                public RunnableC6279a(com.tencent.luggage.wxa.p5.f fVar, z0 z0Var) {
                    this.f129320a = fVar;
                    this.f129321b = z0Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f129320a.B1().b(new com.tencent.luggage.wxa.rj.b(this.f129321b));
                }
            }

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class b implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129322a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f129323b;

                public b(com.tencent.luggage.wxa.p5.f fVar, String str) {
                    this.f129322a = fVar;
                    this.f129323b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.ic.l h06 = this.f129322a.h0();
                    if (h06 != null) {
                        h06.a("onThirdPlatformApiPermissionBytesUpdate", this.f129323b);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(l lVar, com.tencent.luggage.wxa.p5.f fVar, String str, String str2, Continuation continuation) {
                super(2, continuation);
                this.f129316b = lVar;
                this.f129317c = fVar;
                this.f129318d = str;
                this.f129319e = str2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f129316b, this.f129317c, this.f129318d, this.f129319e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                String str;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f129315a;
                try {
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        l lVar = this.f129316b;
                        com.tencent.luggage.wxa.p5.f fVar = this.f129317c;
                        this.f129315a = 1;
                        obj = l.a(lVar, fVar, false, false, this, 4, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    i6 i6Var = (i6) obj;
                    com.tencent.luggage.wxa.ii.t.a().a(this.f129317c.getAppId(), i6Var);
                    o a16 = o.f129343b.a(this.f129318d, i6Var.f127858e, i6Var.f127867n);
                    if (a16 != null) {
                        a16.a(this.f129317c);
                    } else {
                        z0 z0Var = i6Var.f127859f;
                        if (z0Var != null) {
                            com.tencent.luggage.wxa.p5.f fVar2 = this.f129317c;
                            fVar2.c(new RunnableC6279a(fVar2, z0Var));
                        }
                        eh ehVar = i6Var.f127867n;
                        if (ehVar != null && (str = ehVar.f127580f) != null) {
                            com.tencent.luggage.wxa.p5.f fVar3 = this.f129317c;
                            fVar3.c(new b(fVar3, str));
                        }
                    }
                } catch (Throwable th5) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.SubProcessLaunchWxaApp", "getLaunchPBFromCGI async, get invoke exception:" + th5 + ", instanceId:" + this.f129319e);
                }
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f129324a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(CoroutineExceptionHandler.Companion companion, String str) {
                super(companion);
                this.f129324a = str;
            }

            @Override // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(CoroutineContext coroutineContext, Throwable th5) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.SubProcessLaunchWxaApp", "getLaunchPBFromCGI async, get co exception:" + th5 + ", instanceId:" + this.f129324a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.p5.f fVar, String str, long j3, long j16, Continuation continuation, String str2, Continuation continuation2) {
            super(2, continuation2);
            this.f129309c = fVar;
            this.f129310d = str;
            this.f129311e = j3;
            this.f129312f = j16;
            this.f129313g = continuation;
            this.f129314h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f129309c, this.f129310d, this.f129311e, this.f129312f, this.f129313g, this.f129314h, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0133 A[Catch: Exception -> 0x0029, TryCatch #0 {Exception -> 0x0029, blocks: (B:6:0x0022, B:8:0x0108, B:10:0x0133, B:14:0x0182, B:29:0x00fb), top: B:2:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0182 A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #0 {Exception -> 0x0029, blocks: (B:6:0x0022, B:8:0x0108, B:10:0x0133, B:14:0x0182, B:29:0x00fb), top: B:2:0x001c }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Object a16;
            boolean z16;
            Object a17;
            d6 d6Var;
            o a18;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f129307a;
            try {
            } catch (Exception e16) {
                x xVar = x.f129431a;
                String wxaLaunchInstanceId = this.f129310d;
                Intrinsics.checkNotNullExpressionValue(wxaLaunchInstanceId, "wxaLaunchInstanceId");
                xVar.a(wxaLaunchInstanceId, x.e.GET_LAUNCH, x.d.FAIL, "SYNC");
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.SubProcessLaunchWxaApp", "call --ERROR-- use cgi get " + e16 + ", appId:" + this.f129309c.getAppId() + ", versionType:" + this.f129309c.l0() + ", ts:" + w0.c() + ", cost:" + (w0.a() - this.f129311e));
                Continuation continuation = this.f129313g;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        a17 = obj;
                        i6 i6Var = (i6) a17;
                        com.tencent.luggage.wxa.ii.t.a().a(this.f129309c.getAppId(), i6Var);
                        x xVar2 = x.f129431a;
                        String wxaLaunchInstanceId2 = this.f129310d;
                        Intrinsics.checkNotNullExpressionValue(wxaLaunchInstanceId2, "wxaLaunchInstanceId");
                        xVar2.a(wxaLaunchInstanceId2, x.e.GET_LAUNCH, x.d.OK, "SYNC");
                        a18 = o.f129343b.a(this.f129314h, i6Var.f127858e, i6Var.f127867n);
                        if (a18 == null) {
                            com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.SubProcessLaunchWxaApp", "call --END-- use cgi get errorAction, appId:" + this.f129309c.getAppId() + ", versionType:" + this.f129309c.l0() + ", ts:" + w0.c() + ", cost:" + (w0.a() - this.f129311e));
                            Continuation continuation2 = this.f129313g;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(a18)));
                        } else {
                            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.SubProcessLaunchWxaApp", "call --END-- use cgi, appId:" + this.f129309c.getAppId() + ", versionType:" + this.f129309c.l0() + ", ts:" + w0.c() + ", cost:" + (w0.a() - this.f129311e));
                            com.tencent.luggage.wxa.gi.b.a(this.f129309c.getAppId(), com.tencent.luggage.wxa.ik.a.f130635p, "", this.f129312f, w0.c());
                            this.f129313g.resumeWith(Result.m476constructorimpl(i6Var));
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                a16 = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                l lVar = l.this;
                com.tencent.luggage.wxa.p5.f fVar = this.f129309c;
                this.f129307a = 1;
                a16 = lVar.a(fVar, this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            i6 i6Var2 = (i6) a16;
            if (i6Var2 != null && (d6Var = i6Var2.f127858e) != null && d6Var.f127477d == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && l.this.a(i6Var2)) {
                x xVar3 = x.f129431a;
                String wxaLaunchInstanceId3 = this.f129310d;
                Intrinsics.checkNotNullExpressionValue(wxaLaunchInstanceId3, "wxaLaunchInstanceId");
                xVar3.a(wxaLaunchInstanceId3, x.e.GET_LAUNCH, x.d.OK, "ASYNC");
                com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.SubProcessLaunchWxaApp", "call --END-- use cache, appId:" + this.f129309c.getAppId() + ", versionType:" + this.f129309c.l0() + ", ts:" + w0.c() + ", cost:" + (w0.a() - this.f129311e));
                com.tencent.luggage.wxa.gi.b.a(this.f129309c.getAppId(), com.tencent.luggage.wxa.ik.a.f130634o, "", this.f129312f, w0.c());
                this.f129313g.resumeWith(Result.m476constructorimpl(i6Var2));
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO().plus(new b(CoroutineExceptionHandler.INSTANCE, this.f129310d)), null, new a(l.this, this.f129309c, this.f129314h, this.f129310d, null), 2, null);
                return Unit.INSTANCE;
            }
            l lVar2 = l.this;
            com.tencent.luggage.wxa.p5.f fVar2 = this.f129309c;
            this.f129307a = 2;
            a17 = lVar2.a(fVar2, true, true, this);
            if (a17 == coroutine_suspended) {
                return coroutine_suspended;
            }
            i6 i6Var3 = (i6) a17;
            com.tencent.luggage.wxa.ii.t.a().a(this.f129309c.getAppId(), i6Var3);
            x xVar22 = x.f129431a;
            String wxaLaunchInstanceId22 = this.f129310d;
            Intrinsics.checkNotNullExpressionValue(wxaLaunchInstanceId22, "wxaLaunchInstanceId");
            xVar22.a(wxaLaunchInstanceId22, x.e.GET_LAUNCH, x.d.OK, "SYNC");
            a18 = o.f129343b.a(this.f129314h, i6Var3.f127858e, i6Var3.f127867n);
            if (a18 == null) {
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f129325a;

        /* renamed from: b, reason: collision with root package name */
        public Object f129326b;

        /* renamed from: c, reason: collision with root package name */
        public Object f129327c;

        /* renamed from: d, reason: collision with root package name */
        public int f129328d;

        /* renamed from: e, reason: collision with root package name */
        public int f129329e;

        /* renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f129330f;

        /* renamed from: h, reason: collision with root package name */
        public int f129332h;

        public d(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f129330f = obj;
            this.f129332h |= Integer.MIN_VALUE;
            return l.this.a(null, false, false, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends com.tencent.luggage.wxa.i3.d {
        public e(com.tencent.luggage.wxa.p5.f fVar, h6 h6Var) {
            a(fVar.getAppId());
            a(h6Var);
            a((com.tencent.luggage.wxa.bj.c) fVar.f(com.tencent.luggage.wxa.bj.c.class));
        }
    }

    public final boolean a(i6 i6Var) {
        return (i6Var != null ? i6Var.f127859f : null) != null;
    }

    public final Object a(com.tencent.luggage.wxa.p5.f fVar, n0 n0Var, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        String wxaLaunchInstanceId = fVar.S().k();
        String appId = fVar.getAppId();
        x xVar = x.f129431a;
        Intrinsics.checkNotNullExpressionValue(wxaLaunchInstanceId, "wxaLaunchInstanceId");
        x.a(xVar, wxaLaunchInstanceId, x.e.GET_LAUNCH, x.d.START, null, 8, null);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.SubProcessLaunchWxaApp", "call --START-- appId:" + fVar.getAppId() + " versionType:" + fVar.l0() + ", ts:" + w0.c());
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new c(fVar, wxaLaunchInstanceId, w0.a(), w0.c(), safeContinuation, appId, null), 2, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.luggage.wxa.uo.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i6 call(com.tencent.luggage.wxa.ap.b tuple) {
        Intrinsics.checkNotNullParameter(tuple, "tuple");
        com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new b((com.tencent.luggage.wxa.p5.f) tuple.b(), (n0) tuple.c(), b16, null), 2, null);
        return null;
    }

    public final Object a(com.tencent.luggage.wxa.p5.f fVar, Continuation continuation) {
        Continuation intercepted;
        i6 i6Var;
        Object coroutine_suspended;
        String str;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        try {
            String str2 = "SubProcessLaunchWxaApp.getLaunchPBFromDB(" + fVar.getAppId() + ')';
            com.tencent.luggage.wxa.e5.g gVar = com.tencent.luggage.wxa.e5.g.f124544a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            i6Var = com.tencent.luggage.wxa.ii.t.a().a(fVar.getAppId());
            if (i6Var == null || (str = i6Var.toString()) == null) {
                str = "";
            }
            boolean a16 = l0.a();
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 > 32 && a16) {
                com.tencent.luggage.wxa.tn.w.f("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + str2 + " cost " + elapsedRealtime2 + " ms result:" + str + " isMainThread: " + a16 + TokenParser.SP);
            } else {
                com.tencent.luggage.wxa.tn.w.d("Luggage.Utils.Profile", "runProfiled:log:" + str2 + " cost " + elapsedRealtime2 + " ms result:" + str + " isMainThread: " + a16 + TokenParser.SP);
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.SubProcessLaunchWxaApp", "getLaunchPBFromDB appId:" + fVar.getAppId() + ", exception:" + e16);
            i6Var = null;
        }
        safeContinuation.resumeWith(Result.m476constructorimpl(i6Var));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(com.tencent.luggage.wxa.p5.f fVar, boolean z16, boolean z17, Continuation continuation) {
        d dVar;
        Object coroutine_suspended;
        int i3;
        String appId;
        String str;
        int i16;
        String str2;
        int i17;
        d6 d6Var;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i18 = dVar.f129332h;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                dVar.f129332h = i18 - Integer.MIN_VALUE;
                Object obj = dVar.f129330f;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = dVar.f129332h;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.SubProcessLaunchWxaApp", "getLaunchPBFromCGI appId:" + fVar.getAppId() + ", isSync:" + z16 + ", isFirstLaunch:" + z17);
                    String str3 = fVar.S().G;
                    appId = fVar.getAppId();
                    int l06 = fVar.l0();
                    String j3 = fVar.S().j();
                    int i19 = fVar.L1().f122984c;
                    String k3 = fVar.S().k();
                    h6 h6Var = new h6();
                    h6Var.f127761e = fVar.getAppId();
                    vd vdVar = new vd();
                    vdVar.f128912d = fVar.l0();
                    vdVar.f128913e = fVar.S().V;
                    vdVar.f128914f = fVar.L1().f122984c;
                    vdVar.f128917i = fVar.L1().f122982a;
                    vdVar.f128915g = fVar.O();
                    vdVar.f128916h = 0;
                    h6Var.f127762f = vdVar;
                    h6Var.f127763g = z16 ? 1 : 2;
                    xe xeVar = new xe();
                    com.tencent.luggage.wxa.rc.q b26 = fVar.b2();
                    xeVar.f129038d = b26 != null ? b26.w() : 0;
                    h6Var.f127765i = xeVar;
                    h6Var.f127769m = -1;
                    h6Var.f127766j = com.tencent.luggage.wxa.ji.a.b(fVar.S().N);
                    h6Var.f127767k = com.tencent.luggage.wxa.ji.a.a(fVar.S().N);
                    h6Var.f127770n = k3;
                    h6Var.f127771o = str3;
                    h6Var.f127772p = false;
                    h6Var.f127773q = false;
                    h6Var.A = z17;
                    e eVar = new e(fVar, h6Var);
                    dVar.f129325a = str3;
                    dVar.f129326b = appId;
                    dVar.f129327c = j3;
                    dVar.f129328d = l06;
                    dVar.f129329e = i19;
                    dVar.f129332h = 1;
                    Object a16 = eVar.a(dVar);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = str3;
                    i16 = l06;
                    str2 = j3;
                    obj = a16;
                    i17 = i19;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i17 = dVar.f129329e;
                    i16 = dVar.f129328d;
                    str2 = (String) dVar.f129327c;
                    appId = (String) dVar.f129326b;
                    str = (String) dVar.f129325a;
                    ResultKt.throwOnFailure(obj);
                }
                d6Var = ((i6) obj).f127858e;
                if (d6Var == null && d6Var.f127479f) {
                    f0.a(str, appId, i16, str2, i17);
                }
                return obj;
            }
        }
        dVar = new d(continuation);
        Object obj2 = dVar.f129330f;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = dVar.f129332h;
        if (i3 != 0) {
        }
        d6Var = ((i6) obj2).f127858e;
        if (d6Var == null && d6Var.f127479f) {
        }
        return obj2;
    }

    public static /* synthetic */ Object a(l lVar, com.tencent.luggage.wxa.p5.f fVar, boolean z16, boolean z17, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return lVar.a(fVar, z16, z17, continuation);
    }
}
