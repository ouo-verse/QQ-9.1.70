package com.tencent.mobileqq.mini.entry.expDesktop.part;

import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopNotificationPart$initView$3", f = "MiniAppExpDesktopNotificationPart.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class MiniAppExpDesktopNotificationPart$initView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppExpDesktopNotificationPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppExpDesktopNotificationPart$initView$3(MiniAppExpDesktopNotificationPart miniAppExpDesktopNotificationPart, Continuation<? super MiniAppExpDesktopNotificationPart$initView$3> continuation) {
        super(2, continuation);
        this.this$0 = miniAppExpDesktopNotificationPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppExpDesktopNotificationPart$initView$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<MiniAppExpDesktopEffect> effect = this.this$0.getMMiniAppDesktopViewModel().getEffect();
            final MiniAppExpDesktopNotificationPart miniAppExpDesktopNotificationPart = this.this$0;
            FlowCollector<MiniAppExpDesktopEffect> flowCollector = new FlowCollector<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopNotificationPart$initView$3$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(MiniAppExpDesktopEffect miniAppExpDesktopEffect, Continuation<? super Unit> continuation) {
                    MiniAppExpDesktopEffect miniAppExpDesktopEffect2 = miniAppExpDesktopEffect;
                    QLog.i(MiniAppExpDesktopNotificationPart.this.getTAG(), 1, "mSubLayoutRv, effect:" + miniAppExpDesktopEffect2);
                    if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.SetMiniAppNotificationData) {
                        MiniAppExpDesktopNotificationPart.this.openSubPage();
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (effect.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
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
        return ((MiniAppExpDesktopNotificationPart$initView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
