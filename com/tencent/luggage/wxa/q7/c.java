package com.tencent.luggage.wxa.q7;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.n2;
import com.tencent.luggage.wxa.k3.a;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.luggage.wxaapi.internal.ui.WxaScanResultDelegateActivity;
import com.tencent.mobileqq.R;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f137897a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static WxaApi f137898b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q7.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6623a extends a {

            /* renamed from: a, reason: collision with root package name */
            public final LaunchWxaAppResult f137899a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6623a(LaunchWxaAppResult cause) {
                super(null);
                boolean z16;
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.f137899a = cause;
                if (cause != LaunchWxaAppResult.OK) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }

            public final LaunchWxaAppResult a() {
                return this.f137899a;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends a {

            /* renamed from: a, reason: collision with root package name */
            public static final b f137900a = new b();

            public b() {
                super(null);
            }
        }

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
        public int f137901a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137902b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f137903c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f137904d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f137905e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137906a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f137907b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f137908c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map f137909d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ long f137910e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, String str, Map map, long j3, Continuation continuation) {
                super(2, continuation);
                this.f137907b = context;
                this.f137908c = str;
                this.f137909d = map;
                this.f137910e = j3;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f137907b, this.f137908c, this.f137909d, this.f137910e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f137906a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c cVar = c.f137897a;
                    Context context = this.f137907b;
                    String str = this.f137908c;
                    Map map = this.f137909d;
                    long j3 = this.f137910e;
                    this.f137906a = 1;
                    obj = c.a(cVar, context, str, 0, 0, map, j3, this, 12, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j3, Context context, String str, Map map, Continuation continuation) {
            super(2, continuation);
            this.f137902b = j3;
            this.f137903c = context;
            this.f137904d = str;
            this.f137905e = map;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f137902b, this.f137903c, this.f137904d, this.f137905e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f137901a;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    a aVar = new a(this.f137903c, this.f137904d, this.f137905e, this.f137902b, null);
                    this.f137901a = 1;
                    obj = BuildersKt.withContext(io5, aVar, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                a aVar2 = (a) obj;
                if (aVar2 instanceof a.C6623a) {
                    com.tencent.luggage.wxa.u7.b.f142127a.a(this.f137902b, ((a.C6623a) aVar2).a());
                } else {
                    boolean z16 = aVar2 instanceof a.b;
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.DemoScan", "byQRRawData, get exception:" + e16);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q7.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6624c extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f137911a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f137912b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f137913c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f137914d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q7.c$c$a */
        /* loaded from: classes8.dex */
        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public int f137915a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f137916b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f137917c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f137918d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f137919e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Map f137920f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ long f137921g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, String str, int i3, int i16, Map map, long j3, Continuation continuation) {
                super(2, continuation);
                this.f137916b = context;
                this.f137917c = str;
                this.f137918d = i3;
                this.f137919e = i16;
                this.f137920f = map;
                this.f137921g = j3;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f137916b, this.f137917c, this.f137918d, this.f137919e, this.f137920f, this.f137921g, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.f137915a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    c cVar = c.f137897a;
                    Context context = this.f137916b;
                    String str = this.f137917c;
                    int i16 = this.f137918d;
                    int i17 = this.f137919e;
                    Map map = this.f137920f;
                    long j3 = this.f137921g;
                    this.f137915a = 1;
                    obj = cVar.a(context, str, i16, i17, map, j3, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6624c(Context context, long j3, Map map, Continuation continuation) {
            super(2, continuation);
            this.f137912b = context;
            this.f137913c = j3;
            this.f137914d = map;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C6624c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C6624c(this.f137912b, this.f137913c, this.f137914d, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x006b A[Catch: Exception -> 0x006e, TRY_LEAVE, TryCatch #0 {Exception -> 0x006e, blocks: (B:6:0x000e, B:7:0x0057, B:9:0x005d, B:13:0x006b, B:16:0x001b, B:17:0x002f, B:21:0x0022), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005d A[Catch: Exception -> 0x006e, TryCatch #0 {Exception -> 0x006e, blocks: (B:6:0x000e, B:7:0x0057, B:9:0x005d, B:13:0x006b, B:16:0x001b, B:17:0x002f, B:21:0x0022), top: B:2:0x0008 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            a aVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f137911a;
            try {
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.DemoScan", "byQRScanner, get exception:" + e16);
                com.tencent.luggage.wxa.u7.b.f142127a.a(this.f137913c, "byQRScanner:fail:interrupted by " + e16, false);
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        aVar = (a) obj;
                        if (!(aVar instanceof a.C6623a)) {
                            com.tencent.luggage.wxa.u7.b.f142127a.a(this.f137913c, ((a.C6623a) aVar).a());
                        } else {
                            boolean z16 = aVar instanceof a.b;
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                c cVar = c.f137897a;
                Context context = this.f137912b;
                this.f137911a = 1;
                obj = cVar.a(context, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            WxaScanResultDelegateActivity.b bVar = (WxaScanResultDelegateActivity.b) obj;
            String a16 = bVar.a();
            int b16 = bVar.b();
            int c16 = bVar.c();
            CoroutineDispatcher io5 = Dispatchers.getIO();
            a aVar2 = new a(this.f137912b, a16, b16, c16, this.f137914d, this.f137913c, null);
            this.f137911a = 2;
            obj = BuildersKt.withContext(io5, aVar2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar = (a) obj;
            if (!(aVar instanceof a.C6623a)) {
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f137922a;

        public d(int i3) {
            this.f137922a = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(com.tencent.luggage.wxa.tn.z.c(), this.f137922a, 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f137923a;

        public e(Continuation continuation) {
            this.f137923a = continuation;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            if (i3 == -1 && intent != null && intent.getExtras() != null) {
                try {
                    this.f137923a.resumeWith(Result.m476constructorimpl(WxaScanResultDelegateActivity.b.f146888d.a(intent)));
                    return;
                } catch (Exception e16) {
                    Continuation continuation = this.f137923a;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
                    return;
                }
            }
            Continuation continuation2 = this.f137923a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalArgumentException("ResultCode:" + i3))));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f137924a;

        /* renamed from: b, reason: collision with root package name */
        public Object f137925b;

        /* renamed from: c, reason: collision with root package name */
        public Object f137926c;

        /* renamed from: d, reason: collision with root package name */
        public long f137927d;

        /* renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f137928e;

        /* renamed from: g, reason: collision with root package name */
        public int f137930g;

        public f(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f137928e = obj;
            this.f137930g |= Integer.MIN_VALUE;
            return c.this.a(null, null, 0, 0, null, 0L, this);
        }
    }

    public final boolean b() {
        WxaApi wxaApi = f137898b;
        if (wxaApi != null) {
            return wxaApi.getDebugApi().isMultiTaskModeEnabledForWxaApp();
        }
        return false;
    }

    public final void a(WxaApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        f137898b = api;
    }

    public final CoroutineScope a() {
        CoroutineScope a16;
        WxaApi wxaApi = f137898b;
        if (wxaApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("API");
            wxaApi = null;
        }
        s sVar = wxaApi instanceof s ? (s) wxaApi : null;
        return (sVar == null || (a16 = sVar.a()) == null) ? CoroutineScopeKt.MainScope() : a16;
    }

    public final void a(Context context, String rawData, long j3, Map map) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        BuildersKt__Builders_commonKt.launch$default(a(), null, null, new b(j3, context, rawData, map, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Context context, String str, int i3, int i16, Map map, long j3, Continuation continuation) {
        f fVar;
        Object coroutine_suspended;
        int i17;
        n2 n2Var;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof f) {
            fVar = (f) continuation;
            int i18 = fVar.f137930g;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                fVar.f137930g = i18 - Integer.MIN_VALUE;
                Object obj = fVar.f137928e;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = fVar.f137930g;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.luggage.wxa.n3.z zVar = new com.tencent.luggage.wxa.n3.z(str, i3, i16);
                    fVar.f137924a = context;
                    fVar.f137925b = str;
                    fVar.f137926c = map;
                    fVar.f137927d = j3;
                    fVar.f137930g = 1;
                    obj = zVar.a(fVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i17 != 1) {
                        if (i17 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    j3 = fVar.f137927d;
                    map = (Map) fVar.f137926c;
                    str = (String) fVar.f137925b;
                    context = (Context) fVar.f137924a;
                    ResultKt.throwOnFailure(obj);
                }
                n2Var = (n2) obj;
                com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.DemoScan", "waitForQRCodeHandler, code(" + str + ") -> a8keyResponse(ActionCode:" + n2Var.f128233g + ", FullURL:" + n2Var.f128231e + ')');
                if (n2Var.f128233g != 26) {
                    fVar.f137924a = context;
                    fVar.f137925b = map;
                    fVar.f137926c = n2Var;
                    fVar.f137927d = j3;
                    fVar.f137930g = 2;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(fVar);
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                    cancellableContinuationImpl.initCancellability();
                    new g(cancellableContinuationImpl, j3, map).a(context, n2Var.f128231e, 0);
                    if (!cancellableContinuationImpl.isCompleted()) {
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(a.b.f137900a));
                    }
                    obj = cancellableContinuationImpl.getResult();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(fVar);
                    }
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                return new a.C6623a(LaunchWxaAppResult.FailQRCodeInvalid);
            }
        }
        fVar = new f(continuation);
        Object obj2 = fVar.f137928e;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = fVar.f137930g;
        if (i17 != 0) {
        }
        n2Var = (n2) obj2;
        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.DemoScan", "waitForQRCodeHandler, code(" + str + ") -> a8keyResponse(ActionCode:" + n2Var.f128233g + ", FullURL:" + n2Var.f128231e + ')');
        if (n2Var.f128233g != 26) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends com.tencent.luggage.wxa.k3.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f137931a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f137932b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f137933c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f137934a;

            static {
                int[] iArr = new int[a.EnumC6356a.values().length];
                iArr[a.EnumC6356a.ERR_URL_INVALID.ordinal()] = 1;
                iArr[a.EnumC6356a.ERR_UIN_INVALID.ordinal()] = 2;
                iArr[a.EnumC6356a.ERR_DEV_CODE_EXPIRED.ordinal()] = 3;
                f137934a = iArr;
            }
        }

        public g(CancellableContinuation cancellableContinuation, long j3, Map map) {
            this.f137931a = cancellableContinuation;
            this.f137932b = j3;
            this.f137933c = map;
        }

        @Override // com.tencent.luggage.wxa.k3.a
        public void a(Context context, String str, String str2, String str3, int i3, int i16, com.tencent.luggage.wxa.bk.e eVar, com.tencent.luggage.wxa.fd.n nVar, com.tencent.luggage.wxa.ob.b bVar) {
            String str4 = str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("waitForQRCodeDataHandle AbsLinkOpener handle(appId:");
            sb5.append(str);
            sb5.append(", username:");
            sb5.append(str2);
            sb5.append(", enterPath:");
            sb5.append(str3 == null ? "" : str3);
            sb5.append(", versionType:");
            sb5.append(i3);
            sb5.append(", version:");
            sb5.append(i16);
            sb5.append(')');
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.DemoScan", sb5.toString());
            if (str4 == null || str.length() == 0) {
                if (!(str2 == null || str2.length() == 0)) {
                    str4 = c.f137897a.a(str2);
                    if (str4 == null || str4.length() == 0) {
                        CancellableContinuation cancellableContinuation = this.f137931a;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(new a.C6623a(LaunchWxaAppResult.FailWxaAppIdSync)));
                        return;
                    }
                } else {
                    CancellableContinuation cancellableContinuation2 = this.f137931a;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m476constructorimpl(new a.C6623a(LaunchWxaAppResult.FailQRCodeInvalid)));
                    return;
                }
            }
            String str5 = str4;
            com.tencent.luggage.wxa.d6.b bVar2 = new com.tencent.luggage.wxa.d6.b();
            long j3 = this.f137932b;
            Map map = this.f137933c;
            bVar2.f124086d = str5;
            bVar2.f124089g = str3;
            bVar2.f124090h = i3;
            bVar2.f124095m = j3;
            bVar2.f124098p = !c.f137897a.b();
            if ((map == null || map.isEmpty()) ? false : true) {
                bVar2.f124100r = new com.tencent.luggage.wxa.i3.n(map, false, 2, (DefaultConstructorMarker) null).c();
            }
            com.tencent.luggage.wxa.bk.e eVar2 = new com.tencent.luggage.wxa.bk.e();
            eVar2.f122984c = 1011;
            Intrinsics.checkNotNull(str5);
            u.f138189a.a(str5);
            com.tencent.luggage.wxa.u7.b.f142127a.a(this.f137932b, (r16 & 2) != 0 ? null : str5, (r16 & 4) != 0 ? null : "", (r16 & 8) != 0 ? 0 : i3, (r16 & 16) != 0 ? null : null);
            com.tencent.luggage.wxa.i3.t.a(context, bVar2, eVar2, null, false, 24, null);
        }

        @Override // com.tencent.luggage.wxa.k3.a
        public void a(String str, Uri uri, int i3, a.EnumC6356a result) {
            Intrinsics.checkNotNullParameter(result, "result");
            int i16 = a.f137934a[result.ordinal()];
            if (i16 == 1) {
                c.f137897a.a(R.string.yzp);
                CancellableContinuation cancellableContinuation = this.f137931a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new a.C6623a(LaunchWxaAppResult.FailQRCodeRespFullUrlInvalid)));
                return;
            }
            if (i16 == 2) {
                c.f137897a.a(R.string.yzs);
                CancellableContinuation cancellableContinuation2 = this.f137931a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(new a.C6623a(LaunchWxaAppResult.FailQRCodeDevCodeAccessDenied)));
                return;
            }
            if (i16 != 3) {
                return;
            }
            c.f137897a.a(R.string.f170369z10);
            CancellableContinuation cancellableContinuation3 = this.f137931a;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuation3.resumeWith(Result.m476constructorimpl(new a.C6623a(LaunchWxaAppResult.FailQRCodeDevCodeExpired)));
        }
    }

    public static /* synthetic */ Object a(c cVar, Context context, String str, int i3, int i16, Map map, long j3, Continuation continuation, int i17, Object obj) {
        return cVar.a(context, str, (i17 & 4) != 0 ? 19 : i3, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) != 0 ? null : map, j3, continuation);
    }

    public final void a(Context context, long j3, Map map) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(a(), null, null, new C6624c(context, j3, map, null), 3, null);
    }

    public final Object a(Context context, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        try {
            WxaScanResultDelegateActivity.INSTANCE.a(context, new e(safeContinuation));
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.DemoScan", "waitForQBarScanResult get exception:" + th5);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final String a(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return null;
        }
        n0 b16 = o0.a().b(str, "appId");
        if (b16 != null && (str2 = b16.f138467f) != null) {
            return str2;
        }
        try {
            o0.a().a(str, com.tencent.luggage.wxa.n3.g0.f135177a.a(null, str));
            String str3 = o0.a().b(str, "appId").f138467f;
            Intrinsics.checkNotNull(str3);
            return str3;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(int i3) {
        com.tencent.luggage.wxa.zp.h.f146825d.a(new d(i3));
    }
}
