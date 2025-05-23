package com.tencent.luggage.wxa.c7;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.j4.i;
import com.tencent.luggage.wxa.lj.k;
import com.tencent.luggage.wxa.lj.m;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mobileqq.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f123350a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f123351b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6100a {

        /* renamed from: a, reason: collision with root package name */
        public static final C6100a f123352a = new C6100a();

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f123353b = {"\u6b63\u5728\u4f7f\u7528 \u5c0f\u7a0b\u5e8f", "\u6b63\u5728\u4f7f\u7528 \u5c0f\u6e38\u620f"};

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f123354c = {"Using    Mini Program", "Using    Mini Game"};

        public final SpannableString a(boolean z16) {
            String[] strArr;
            int i3;
            int i16;
            int i17;
            String str;
            if (u.b()) {
                strArr = f123353b;
                i3 = 4;
                i16 = 5;
            } else {
                strArr = f123354c;
                i3 = 6;
                i16 = 8;
            }
            int a16 = com.tencent.luggage.wxa.kn.a.a(z.c(), 16);
            Context c16 = z.c();
            if (z16) {
                i17 = R.drawable.m8u;
            } else {
                i17 = R.drawable.m8v;
            }
            Drawable drawable = ContextCompat.getDrawable(c16, i17);
            if (drawable != null) {
                drawable.setBounds(0, 0, a16, a16);
                if (!z16) {
                    drawable.setColorFilter(z.j().getColor(R.color.ap9), PorterDuff.Mode.SRC_ATOP);
                }
            } else {
                drawable = null;
            }
            if (z16) {
                str = strArr[1];
            } else {
                str = strArr[0];
            }
            SpannableString spannableString = new SpannableString(str);
            if (drawable != null) {
                spannableString.setSpan(new ImageSpan(drawable, 2), i3, i16, 17);
            }
            return spannableString;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f123355a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.g7.d f123356b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.g7.d dVar, Continuation continuation) {
            super(2, continuation);
            this.f123356b = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f123356b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f123355a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                a aVar = a.f123350a;
                com.tencent.luggage.wxa.g7.d dVar = this.f123356b;
                this.f123355a = 1;
                if (aVar.a(dVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            a aVar2 = a.f123350a;
            com.tencent.luggage.wxa.g7.d dVar2 = this.f123356b;
            this.f123355a = 2;
            if (aVar2.b(dVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f123357a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return f0.c("MicroMsg.CapsuleTisLogic", 2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f123358a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f123359b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.g7.d f123360c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(boolean z16, com.tencent.luggage.wxa.g7.d dVar, Continuation continuation) {
            super(2, continuation);
            this.f123359b = z16;
            this.f123360c = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.f123359b, this.f123360c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.f123358a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                a aVar = a.f123350a;
                boolean z16 = this.f123359b;
                com.tencent.luggage.wxa.g7.d dVar = this.f123360c;
                this.f123358a = 1;
                if (aVar.a(z16, dVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            a.f123350a.c(this.f123360c);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.lj.e f123361a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.tencent.luggage.wxa.lj.e eVar) {
            super(0);
            this.f123361a = eVar;
        }

        public final void a() {
            this.f123361a.g().performClick();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final f f123362a = new f();

        public f() {
            super(0);
        }

        public final void a() {
            w.d("MicroMsg.CapsuleTisLogic", "onAnimationStart");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f123363a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(CancellableContinuation cancellableContinuation) {
            super(0);
            this.f123363a = cancellableContinuation;
        }

        public final void a() {
            w.d("MicroMsg.CapsuleTisLogic", "onAnimationEnd");
            this.f123363a.resume(Unit.INSTANCE, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public int f123364a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.g7.d f123365b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.c7.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6101a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.lj.e f123366a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6101a(com.tencent.luggage.wxa.lj.e eVar) {
                super(0);
                this.f123366a = eVar;
            }

            public final void a() {
                this.f123366a.g().performClick();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(com.tencent.luggage.wxa.g7.d dVar, Continuation continuation) {
            super(2, continuation);
            this.f123365b = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new h(this.f123365b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String string;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f123364a == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.luggage.wxa.lj.e I = this.f123365b.I();
                Intrinsics.checkNotNullExpressionValue(I, "runtime.capsuleBarManager");
                if (this.f123365b.Q1()) {
                    string = z.j().getString(R.string.z2j, this.f123365b.G());
                } else {
                    string = z.j().getString(R.string.z2i, this.f123365b.G());
                }
                String str = string;
                Intrinsics.checkNotNullExpressionValue(str, "if (runtime.isGame) {\n  \u2026  )\n                    }");
                I.f().a(new m(str, 0L, null, null, k.b.TIPS.b(), true, new C6101a(I), null, null, 398, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(c.f123357a);
        f123351b = lazy;
    }

    public final String a(boolean z16) {
        return z16 ? "MicroMsg.CapsuleTisLogic_ShowBrand_GAME" : "MicroMsg.CapsuleTisLogic_ShowBrand_NORMAL";
    }

    public final void c(com.tencent.luggage.wxa.g7.d dVar) {
        a().putBoolean(a(dVar.S().l()), false);
    }

    public final void b(com.tencent.luggage.wxa.g7.d runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        LifecycleScope U = runtime.U();
        if (U != null) {
            BuildersKt__Builders_commonKt.launch$default(U, null, null, new b(runtime, null), 3, null);
        }
    }

    public final Object b(com.tencent.luggage.wxa.g7.d dVar, Continuation continuation) {
        Object coroutine_suspended;
        if (dVar.j0() != null && dVar.j0().J != null) {
            i iVar = dVar.j0().J;
            Intrinsics.checkNotNullExpressionValue(iVar, "runtime.sysConfig.launchWxaAppInfo");
            w.d("MicroMsg.CapsuleTisLogic", "showThirdBusinessTipsAfterLaunch: %b", Boxing.boxBoolean(iVar.f130846g));
            if (iVar.f130846g) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new h(dVar, null), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final f0 a() {
        return (f0) f123351b.getValue();
    }

    public final boolean a(com.tencent.luggage.wxa.g7.d dVar) {
        return a().getBoolean(a(dVar.S().l()), true);
    }

    public final Object a(com.tencent.luggage.wxa.g7.d dVar, Continuation continuation) {
        Object coroutine_suspended;
        boolean a16 = a(dVar);
        boolean l3 = dVar.S().l();
        w.d("MicroMsg.CapsuleTisLogic", "showBrandIfNeed appId:" + dVar.getAppId() + " canShow:" + a16 + " isGame:" + l3);
        if (a16) {
            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new d(l3, dVar, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object a(boolean z16, com.tencent.luggage.wxa.g7.d dVar, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.luggage.wxa.lj.e I = dVar.I();
        Intrinsics.checkNotNullExpressionValue(I, "runtime.capsuleBarManager");
        I.f().a(new m(C6100a.f123352a.a(z16), 0L, null, null, 0, true, new e(I), f.f123362a, new g(cancellableContinuationImpl), 30, null));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : Unit.INSTANCE;
    }
}
