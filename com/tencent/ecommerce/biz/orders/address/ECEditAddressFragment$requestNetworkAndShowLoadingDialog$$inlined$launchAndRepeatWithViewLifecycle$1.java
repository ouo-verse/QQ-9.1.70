package com.tencent.ecommerce.biz.orders.address;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1", f = "ECEditAddressFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ com.tencent.ecommerce.base.ui.d $dialog$inlined;
    final /* synthetic */ Flow $flow$inlined;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1$1", f = "ECEditAddressFragment.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/ecommerce/biz/orders/address/ECEditAddressFragment$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1$1$a */
        /* loaded from: classes31.dex */
        public static final class a<T> implements FlowCollector<T> {
            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation) {
                Object coroutine_suspended;
                if (ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1.this.$dialog$inlined.isShowing()) {
                    ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1.this.$dialog$inlined.dismiss();
                }
                Object invoke = ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1.this.$callback$inlined.invoke(obj);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return invoke == coroutine_suspended ? invoke : Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1.this.$flow$inlined;
                a aVar = new a();
                this.label = 1;
                if (flow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1(Fragment fragment, Lifecycle.State state, Continuation continuation, Flow flow, com.tencent.ecommerce.base.ui.d dVar, Function1 function1) {
        super(2, continuation);
        this.$this_launchAndRepeatWithViewLifecycle = fragment;
        this.$minActiveState = state;
        this.$flow$inlined = flow;
        this.$dialog$inlined = dVar;
        this.$callback$inlined = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, continuation, this.$flow$inlined, this.$dialog$inlined, this.$callback$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECEditAddressFragment$requestNetworkAndShowLoadingDialog$$inlined$launchAndRepeatWithViewLifecycle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Lifecycle lifecycle = this.$this_launchAndRepeatWithViewLifecycle.getViewLifecycleOwner().getLifecycle();
            Lifecycle.State state = this.$minActiveState;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
