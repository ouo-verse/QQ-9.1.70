package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import com.tencent.qphone.base.util.QLog;
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
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppBannerViewHolder$2$1", f = "MiniAppBannerAdapter.kt", i = {}, l = {437}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppBannerViewHolder$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppBannerViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppBannerViewHolder$2$1(MiniAppBannerViewHolder miniAppBannerViewHolder, Continuation<? super MiniAppBannerViewHolder$2$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppBannerViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppBannerViewHolder$2$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MiniAppDeskTopViewModel mMiniAppDesktopViewModel;
        SharedFlow<MiniAppDesktopEffect> effect;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
            if (mMiniAppDesktopViewModel != null && (effect = mMiniAppDesktopViewModel.getEffect()) != null) {
                final MiniAppBannerViewHolder miniAppBannerViewHolder = this.this$0;
                FlowCollector<MiniAppDesktopEffect> flowCollector = new FlowCollector<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppBannerViewHolder$2$1$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(MiniAppDesktopEffect miniAppDesktopEffect, Continuation<? super Unit> continuation) {
                        MiniAppDesktopEffect miniAppDesktopEffect2 = miniAppDesktopEffect;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MiniAppDesktopPart.MiniAppBannerViewHolder", 1, "effect=" + miniAppDesktopEffect2);
                        }
                        if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OuterRvPartOnResume) {
                            try {
                                MiniAppBannerViewHolder.this.showBanner();
                            } catch (Exception e16) {
                                QLog.e("MiniAppDesktopPart.MiniAppBannerViewHolder", 1, "OuterRvPartOnResume, showBanner, error", e16);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (effect.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppBannerViewHolder$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
