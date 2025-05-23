package com.tencent.luggage.wxa.q7;

import com.tencent.luggage.wxa.oc.b;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.WxaPrefetchApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 implements WxaPrefetchApi {

    /* renamed from: a, reason: collision with root package name */
    public final s f137878a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineScope f137879b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f137881b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q7.b0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6621a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137882a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b0 f137883b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ CancellableContinuation f137884c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6621a(b0 b0Var, CancellableContinuation cancellableContinuation, Continuation continuation) {
                super(2, continuation);
                this.f137883b = b0Var;
                this.f137884c = cancellableContinuation;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C6621a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C6621a(this.f137883b, this.f137884c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f137882a;
                boolean z16 = true;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    s sVar = this.f137883b.f137878a;
                    this.f137882a = 1;
                    obj = sVar.a(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (obj != TdiAuthState.WechatTdi_Auth_State_OK) {
                    z16 = false;
                }
                if (this.f137884c.isActive()) {
                    this.f137884c.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(z16)));
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CancellableContinuation cancellableContinuation) {
            super(0);
            this.f137881b = cancellableContinuation;
        }

        public final void a() {
            BuildersKt__Builders_commonKt.launch$default(b0.this.a(), Dispatchers.getIO(), null, new C6621a(b0.this, this.f137881b, null), 2, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f137885a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WxaPrefetchApi.a f137887c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f137888d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f137889e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WxaPrefetchApi.a f137890a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f137891b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f137892c;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.q7.b0$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6622a implements com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.e {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ WxaPrefetchApi.a f137893a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ WxaPrefetchApi.WxaPrefetchResult f137894b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f137895c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f137896d;

                public C6622a(WxaPrefetchApi.a aVar, WxaPrefetchApi.WxaPrefetchResult wxaPrefetchResult, String str, String str2) {
                    this.f137894b = wxaPrefetchResult;
                    this.f137895c = str;
                    this.f137896d = str2;
                }

                @Override // com.tencent.luggage.wxa.jq.e
                public boolean a() {
                    return false;
                }

                @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
                public String getKey() {
                    return "";
                }

                @Override // java.lang.Runnable
                public void run() {
                    throw null;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(WxaPrefetchApi.a aVar, String str, String str2) {
                super(1);
                this.f137891b = str;
                this.f137892c = str2;
            }

            public final void a(b.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.luggage.wxa.zp.h.f146825d.d(new C6622a(null, WxaPrefetchApi.WxaPrefetchResult.values()[it.ordinal()], this.f137891b, this.f137892c));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((b.d) obj);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WxaPrefetchApi.a aVar, String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.f137888d = str;
            this.f137889e = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(null, this.f137888d, this.f137889e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Object a16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f137885a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    a16 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                b0 b0Var = b0.this;
                this.f137885a = 1;
                a16 = b0Var.a(this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (((Boolean) a16).booleanValue()) {
                com.tencent.luggage.wxa.oc.b.f136284a.a(this.f137888d, this.f137889e, (Function1) null);
                s.f.a(s.f.f138080a, "prefetchForAppIdAndPath", true, this.f137888d, 0, 8, null);
            } else {
                s.f.a(s.f.f138080a, "prefetchForAppIdAndPath", false, this.f137888d, 0, 8, null);
            }
            return Unit.INSTANCE;
        }
    }

    public b0(s API) {
        Intrinsics.checkNotNullParameter(API, "API");
        this.f137878a = API;
        this.f137879b = CoroutineScopeKt.MainScope();
    }

    public int getDownloadingPrefetchTaskCount() {
        int c16 = com.tencent.luggage.wxa.oc.b.f136284a.c();
        s.f.a(s.f.f138080a, "getDownloadingPrefetchTaskCount", true, null, 0, 12, null);
        return c16;
    }

    public long[] getDownloadingPrefetchTaskSpeed() {
        long[] d16 = com.tencent.luggage.wxa.oc.b.f136284a.d();
        s.f.a(s.f.f138080a, "getDownloadingPrefetchTaskSpeed", true, null, 0, 12, null);
        return d16;
    }

    public void prefetchForAppIdAndPath(String str, String str2) {
        prefetchForAppIdAndPath(str, str2, null);
    }

    public void prefetchForAppIdAndPath(String str, String str2, WxaPrefetchApi.a aVar) {
        if (str == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.f137879b, Dispatchers.getIO(), null, new b(aVar, str, str2, null), 2, null);
    }

    public final CoroutineScope a() {
        return this.f137879b;
    }

    public final Object a(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.luggage.wxa.v7.d.f143293b.a(new a(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
