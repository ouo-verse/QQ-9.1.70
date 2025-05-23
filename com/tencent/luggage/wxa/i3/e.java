package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.hn.d6;
import com.tencent.luggage.wxa.hn.eh;
import com.tencent.luggage.wxa.hn.h6;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.luggage.wxa.hn.li;
import com.tencent.luggage.wxa.hn.vd;
import com.tencent.luggage.wxa.hn.vf;
import com.tencent.luggage.wxa.hn.xe;
import com.tencent.luggage.wxa.hn.z0;
import com.tencent.luggage.wxa.n3.f0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f129218h = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.p5.f f129219g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i3.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6273a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoroutineScope f129220a;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.e$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6274a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CoroutineScope f129221a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6274a(CoroutineScope coroutineScope) {
                    super(0);
                    this.f129221a = coroutineScope;
                }

                public final void a() {
                    if (CoroutineScopeKt.isActive(this.f129221a)) {
                        CoroutineScopeKt.cancel$default(this.f129221a, null, 1, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6273a(CoroutineScope coroutineScope) {
                super(1);
                this.f129220a = coroutineScope;
            }

            public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
                Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
                lifecycle.b(new C6274a(this.f129220a));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((com.tencent.luggage.wxa.e5.h) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f129222a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129223b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.i3.e$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6275a extends SuspendLambda implements Function2 {

                /* renamed from: a, reason: collision with root package name */
                public Object f129224a;

                /* renamed from: b, reason: collision with root package name */
                public Object f129225b;

                /* renamed from: c, reason: collision with root package name */
                public Object f129226c;

                /* renamed from: d, reason: collision with root package name */
                public int f129227d;

                /* renamed from: e, reason: collision with root package name */
                public int f129228e;

                /* renamed from: f, reason: collision with root package name */
                public int f129229f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129230g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C6275a(com.tencent.luggage.wxa.p5.f fVar, Continuation continuation) {
                    super(2, continuation);
                    this.f129230g = fVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((C6275a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new C6275a(this.f129230g, continuation);
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x008f  */
                /* JADX WARN: Removed duplicated region for block: B:9:0x008c  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    String appId;
                    String str;
                    int l06;
                    String j3;
                    int i3;
                    int i16;
                    String str2;
                    String str3;
                    int i17;
                    String str4;
                    i6 i6Var;
                    String str5;
                    com.tencent.luggage.wxa.rj.c B1;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i18 = this.f129229f;
                    boolean z16 = true;
                    if (i18 != 0) {
                        if (i18 == 1) {
                            i16 = this.f129228e;
                            i17 = this.f129227d;
                            str4 = (String) this.f129226c;
                            str3 = (String) this.f129225b;
                            str2 = (String) this.f129224a;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Exception unused) {
                                appId = str2;
                                i3 = i16;
                                String str6 = str4;
                                l06 = i17;
                                str = str3;
                                j3 = str6;
                                int i19 = i3;
                                str2 = appId;
                                i6Var = null;
                                i16 = i19;
                                String str7 = j3;
                                str3 = str;
                                i17 = l06;
                                str4 = str7;
                                if (i6Var == null) {
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        appId = this.f129230g.getAppId();
                        Intrinsics.checkNotNull(appId);
                        str = this.f129230g.S().G;
                        Intrinsics.checkNotNull(str);
                        l06 = this.f129230g.l0();
                        j3 = this.f129230g.S().j();
                        i3 = this.f129230g.L1().f122984c;
                        try {
                            e eVar = new e(this.f129230g);
                            this.f129224a = appId;
                            this.f129225b = str;
                            this.f129226c = j3;
                            this.f129227d = l06;
                            this.f129228e = i3;
                            this.f129229f = 1;
                            Object a16 = eVar.a(this);
                            if (a16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i16 = i3;
                            str2 = appId;
                            obj = a16;
                            str3 = str;
                            i17 = l06;
                            str4 = j3;
                        } catch (Exception unused2) {
                            int i192 = i3;
                            str2 = appId;
                            i6Var = null;
                            i16 = i192;
                            String str72 = j3;
                            str3 = str;
                            i17 = l06;
                            str4 = str72;
                            if (i6Var == null) {
                            }
                        }
                    }
                    i6Var = (i6) obj;
                    if (i6Var == null) {
                        return Unit.INSTANCE;
                    }
                    com.tencent.luggage.wxa.ii.t.a().a(str2, i6Var);
                    z0 z0Var = i6Var.f127859f;
                    if (z0Var != null && (B1 = this.f129230g.B1()) != null) {
                        B1.b(new com.tencent.luggage.wxa.rj.b(z0Var));
                    }
                    eh ehVar = i6Var.f127867n;
                    if (ehVar != null && (str5 = ehVar.f127580f) != null) {
                        this.f129230g.h0().a("onThirdPlatformApiPermissionBytesUpdate", str5);
                    }
                    d6 d6Var = i6Var.f127858e;
                    if (d6Var == null || !d6Var.f127479f) {
                        z16 = false;
                    }
                    if (z16) {
                        f0.a(str3, str2, i17, str4, i16);
                    }
                    o a17 = o.f129343b.a(str2, i6Var.f127858e, i6Var.f127867n);
                    if (a17 != null) {
                        a17.a(this.f129230g);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(com.tencent.luggage.wxa.p5.f fVar, Continuation continuation) {
                super(2, continuation);
                this.f129223b = fVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new b(this.f129223b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f129222a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    C6275a c6275a = new C6275a(this.f129223b, null);
                    this.f129222a = 1;
                    if (BuildersKt.withContext(io5, c6275a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ CoroutineScope a(com.tencent.luggage.wxa.p5.f rt5) {
            Intrinsics.checkNotNullParameter(rt5, "rt");
            CoroutineScope MainScope = CoroutineScopeKt.MainScope();
            com.tencent.luggage.wxa.e5.l.f124555a.a(rt5, new C6273a(MainScope));
            return MainScope;
        }

        public final void b(com.tencent.luggage.wxa.p5.f rt5) {
            Intrinsics.checkNotNullParameter(rt5, "rt");
            BuildersKt__Builders_commonKt.launch$default(a(rt5), null, null, new b(rt5, null), 3, null);
        }
    }

    public e(com.tencent.luggage.wxa.p5.f rt5) {
        int i3;
        Intrinsics.checkNotNullParameter(rt5, "rt");
        this.f129219g = rt5;
        com.tencent.luggage.wxa.fd.n nVar = rt5.S().N;
        Intrinsics.checkNotNull(nVar);
        li b16 = com.tencent.luggage.wxa.ji.a.b(nVar);
        com.tencent.luggage.wxa.fd.n nVar2 = rt5.S().N;
        Intrinsics.checkNotNull(nVar2);
        vf a16 = com.tencent.luggage.wxa.ji.a.a(nVar2);
        vd vdVar = new vd();
        vdVar.f128912d = rt5.l0();
        vdVar.f128913e = rt5.C1();
        vdVar.f128914f = rt5.L1().f122984c;
        vdVar.f128917i = rt5.L1().f122982a;
        vdVar.f128915g = rt5.S().f125813f;
        vdVar.f128916h = 1;
        a(rt5.getAppId());
        h6 h6Var = new h6();
        h6Var.f127761e = rt5.getAppId();
        h6Var.f127762f = vdVar;
        h6Var.f127763g = 2;
        xe xeVar = new xe();
        com.tencent.luggage.wxa.rc.q b26 = rt5.b2();
        if (b26 != null) {
            i3 = b26.w();
        } else {
            i3 = 0;
        }
        xeVar.f129038d = i3;
        h6Var.f127765i = xeVar;
        h6Var.f127766j = b16;
        h6Var.f127767k = a16;
        h6Var.f127769m = -1;
        h6Var.f127770n = rt5.S().k();
        h6Var.f127771o = rt5.S().G;
        h6Var.f127772p = false;
        h6Var.f127773q = false;
        a(h6Var);
        a((com.tencent.luggage.wxa.bj.c) rt5.f(com.tencent.luggage.wxa.bj.c.class));
    }
}
