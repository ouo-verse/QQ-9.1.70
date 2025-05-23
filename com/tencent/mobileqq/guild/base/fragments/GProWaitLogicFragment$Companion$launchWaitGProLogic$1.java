package com.tencent.mobileqq.guild.base.fragments;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment$Companion$launchWaitGProLogic$1", f = "GProWaitLogicFragment.kt", i = {0}, l = {136}, m = "invokeSuspend", n = {"updateUiJob"}, s = {"L$0"})
/* loaded from: classes12.dex */
public final class GProWaitLogicFragment$Companion$launchWaitGProLogic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextView $loadingView;
    final /* synthetic */ Function0<Unit> $onRefreshCallback;
    final /* synthetic */ Fragment $this_launchWaitGProLogic;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $waitBlock;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment$Companion$launchWaitGProLogic$1$4", f = "GProWaitLogicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment$Companion$launchWaitGProLogic$1$4, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $loadingView;
        final /* synthetic */ Function0<Unit> $onRefreshCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(TextView textView, Function0<Unit> function0, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$loadingView = textView;
            this.$onRefreshCallback = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass4(this.$loadingView, this.$onRefreshCallback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$loadingView.setText("\u91cd\u65b0\u52a0\u8f7d\u9875\u9762\uff0c\u8bf7\u7b49\u5f85...");
                this.$onRefreshCallback.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GProWaitLogicFragment$Companion$launchWaitGProLogic$1(Fragment fragment, TextView textView, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function0<Unit> function0, Continuation<? super GProWaitLogicFragment$Companion$launchWaitGProLogic$1> continuation) {
        super(2, continuation);
        this.$this_launchWaitGProLogic = fragment;
        this.$loadingView = textView;
        this.$waitBlock = function1;
        this.$onRefreshCallback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GProWaitLogicFragment$Companion$launchWaitGProLogic$1 gProWaitLogicFragment$Companion$launchWaitGProLogic$1 = new GProWaitLogicFragment$Companion$launchWaitGProLogic$1(this.$this_launchWaitGProLogic, this.$loadingView, this.$waitBlock, this.$onRefreshCallback, continuation);
        gProWaitLogicFragment$Companion$launchWaitGProLogic$1.L$0 = obj;
        return gProWaitLogicFragment$Companion$launchWaitGProLogic$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        Job launch$default;
        Job job;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                job = (Job) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Logger.f235387a.d().i("GProWaitLogicFragment", 1, "[launchWaitGProLogic] launch");
            r rVar = r.f214743a;
            IRuntimeService S0 = ch.S0(IGProSession.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            if (((IGProSession) S0).getGproStartCountDownLatch().getCount() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GProWaitLogicFragment$Companion$launchWaitGProLogic$1$updateUiJob$1(this.$loadingView, null), 3, null);
                GProWaitLogicFragment$Companion$launchWaitGProLogic$1$result$1 gProWaitLogicFragment$Companion$launchWaitGProLogic$1$result$1 = new GProWaitLogicFragment$Companion$launchWaitGProLogic$1$result$1(this.$waitBlock, null);
                this.L$0 = launch$default;
                this.label = 1;
                Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(20000L, gProWaitLogicFragment$Companion$launchWaitGProLogic$1$result$1, this);
                if (withTimeoutOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                job = launch$default;
                obj = withTimeoutOrNull;
            }
            Lifecycle lifecycle = this.$this_launchWaitGProLogic.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifecycleKt.getCoroutineScope(lifecycle).launchWhenStarted(new AnonymousClass4(this.$loadingView, this.$onRefreshCallback, null));
            return Unit.INSTANCE;
        }
        Unit unit = (Unit) obj;
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        if (unit == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[launchWaitGProLogic] GPro SDK \u521d\u59cb\u5316\u8d85\u65f6!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GProWaitLogicFragment", 1, (String) it.next(), null);
            }
        } else {
            Logger.f235387a.d().i("GProWaitLogicFragment", 1, "[launchWaitGProLogic] GPro SDK is ready now!");
        }
        Lifecycle lifecycle2 = this.$this_launchWaitGProLogic.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle2).launchWhenStarted(new AnonymousClass4(this.$loadingView, this.$onRefreshCallback, null));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GProWaitLogicFragment$Companion$launchWaitGProLogic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
