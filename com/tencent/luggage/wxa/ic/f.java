package com.tencent.luggage.wxa.ic;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f implements com.tencent.luggage.wxa.xd.m {

    /* renamed from: a, reason: collision with root package name */
    public final g f129738a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ok.c f129739b;

    /* renamed from: c, reason: collision with root package name */
    public int f129740c;

    /* renamed from: d, reason: collision with root package name */
    public final long f129741d;

    /* renamed from: e, reason: collision with root package name */
    public final long f129742e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnAttachStateChangeListener {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ic.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6295a extends SuspendLambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public long f129744a;

            /* renamed from: b, reason: collision with root package name */
            public int f129745b;

            /* renamed from: c, reason: collision with root package name */
            public int f129746c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f129747d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6295a(f fVar, Continuation continuation) {
                super(2, continuation);
                this.f129747d = fVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C6295a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C6295a(this.f129747d, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0095 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0096  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x009f  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                long j3;
                long j16;
                int i3;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i16 = this.f129746c;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 == 3) {
                                i3 = this.f129745b;
                                ResultKt.throwOnFailure(obj);
                                if (this.f129747d.f129740c == i3) {
                                    this.f129747d.f129739b.v();
                                }
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        int i17 = this.f129747d.f129740c;
                        j16 = this.f129747d.f129742e;
                        this.f129745b = i17;
                        this.f129746c = 3;
                        if (DelayKt.delay(j16, this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i17;
                        if (this.f129747d.f129740c == i3) {
                        }
                        return Unit.INSTANCE;
                    }
                    j3 = this.f129744a;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    long millis = TimeUnit.SECONDS.toMillis(com.tencent.luggage.wxa.fd.h.b().S);
                    this.f129744a = millis;
                    this.f129746c = 1;
                    if (DelayKt.delay(millis, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = millis;
                }
                if (ViewCompat.isAttachedToWindow(this.f129747d.f129739b.getView()) && this.f129747d.a()) {
                    this.f129747d.f129739b.w();
                    long max = Math.max(0L, this.f129747d.f129741d - j3);
                    this.f129746c = 2;
                    if (DelayKt.delay(max, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i172 = this.f129747d.f129740c;
                    j16 = this.f129747d.f129742e;
                    this.f129745b = i172;
                    this.f129746c = 3;
                    if (DelayKt.delay(j16, this) != coroutine_suspended) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            LifecycleScope U = f.this.f129738a.U();
            Intrinsics.checkNotNull(U);
            BuildersKt__Builders_commonKt.launch$default(U, Dispatchers.getMain().getImmediate(), null, new C6295a(f.this, null), 2, null);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements m0 {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public /* synthetic */ void a() {
            as.a(this);
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public /* synthetic */ void b() {
            as.d(this);
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public /* synthetic */ void a(String str) {
            as.c(this, str);
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public void a(int i3) {
            f.this.f129740c = i3;
        }
    }

    public f(g runtime, com.tencent.luggage.wxa.ok.c splash) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(splash, "splash");
        this.f129738a = runtime;
        this.f129739b = splash;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f129741d = timeUnit.toMillis(20L);
        this.f129742e = timeUnit.toMillis(10L);
        splash.getView().addOnAttachStateChangeListener(new a());
        runtime.a((m0) new b());
    }

    public abstract boolean a();
}
