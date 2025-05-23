package com.tencent.ecommerce.biz.aftersale.ui.fragment;

import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.d;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1", f = "ECAfterSaleApplyFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ ECAfterSaleApplyFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1$1", f = "ECAfterSaleApplyFragment.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/ecommerce/biz/aftersale/ui/fragment/ECAfterSaleApplyFragment$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1$1$a */
        /* loaded from: classes31.dex */
        public static final class a implements FlowCollector<ECAfterSaleApplyViewModel.c> {
            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(ECAfterSaleApplyViewModel.c cVar, Continuation continuation) {
                Handler gi5;
                d dVar;
                Handler gi6;
                d dVar2;
                ECAfterSaleApplyViewModel.c cVar2 = cVar;
                if (cVar2 instanceof ECAfterSaleApplyViewModel.c.C1039c) {
                    IStateCenterView.a.c(ECAfterSaleApplyFragment.Ph(ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0), null, 1, null);
                } else if (cVar2 instanceof ECAfterSaleApplyViewModel.c.b) {
                    ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.mi(((ECAfterSaleApplyViewModel.c.b) cVar2).failReason);
                } else if (cVar2 instanceof ECAfterSaleApplyViewModel.c.e) {
                    ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.ni();
                } else if (cVar2 instanceof ECAfterSaleApplyViewModel.c.d) {
                    ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.ji();
                    ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.si(true);
                } else if (cVar2 instanceof ECAfterSaleApplyViewModel.c.g) {
                    ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.ti();
                } else if (cVar2 instanceof ECAfterSaleApplyViewModel.c.h) {
                    gi6 = ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.gi();
                    gi6.removeCallbacksAndMessages(null);
                    dVar2 = ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.loadingDialog;
                    if (dVar2 != null) {
                        dVar2.dismiss();
                    }
                    i.f101155b.c(R.string.wfk, ECToastIcon.ICON_SUCCESS, 0);
                    ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.ji();
                } else if (cVar2 instanceof ECAfterSaleApplyViewModel.c.f) {
                    gi5 = ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.gi();
                    gi5.removeCallbacksAndMessages(null);
                    dVar = ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.loadingDialog;
                    if (dVar != null) {
                        dVar.dismiss();
                    }
                    i.f101155b.c(((ECAfterSaleApplyViewModel.c.f) cVar2).exception instanceof ECAfterSaleApplyViewModel.b.a ? R.string.wfi : R.string.wfj, ECToastIcon.ICON_ERROR, 0);
                }
                return Unit.INSTANCE;
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
            ECAfterSaleApplyViewModel hi5;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                hi5 = ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.hi();
                StateFlow<ECAfterSaleApplyViewModel.c> T1 = hi5.T1();
                a aVar = new a();
                this.label = 1;
                if (T1.collect(aVar, this) == coroutine_suspended) {
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
    public ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1(Fragment fragment, Lifecycle.State state, Continuation continuation, ECAfterSaleApplyFragment eCAfterSaleApplyFragment) {
        super(2, continuation);
        this.$this_launchAndRepeatWithViewLifecycle = fragment;
        this.$minActiveState = state;
        this.this$0 = eCAfterSaleApplyFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
