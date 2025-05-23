package com.tencent.ecommerce.biz.live.ui;

import com.tencent.ecommerce.biz.live.ui.viewholder.ItemPayload;
import com.tencent.ecommerce.biz.live.ui.viewholder.PayloadType;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveProduct;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/h;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/live/ui/ECLiveWindowSubFragment$updateActivityCountdown$1$$special$$inlined$run$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$updateActivityCountdown$1$1$1$payload$1", f = "ECLiveWindowSubFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ItemPayload>, Object> {
    final /* synthetic */ LiveProduct $it$inlined;
    int label;
    final /* synthetic */ ECLiveWindowSubFragment$updateActivityCountdown$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1(Continuation continuation, LiveProduct liveProduct, ECLiveWindowSubFragment$updateActivityCountdown$1 eCLiveWindowSubFragment$updateActivityCountdown$1) {
        super(2, continuation);
        this.$it$inlined = liveProduct;
        this.this$0 = eCLiveWindowSubFragment$updateActivityCountdown$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1(continuation, this.$it$inlined, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ItemPayload> continuation) {
        return ((ECLiveWindowSubFragment$updateActivityCountdown$1$invokeSuspend$$inlined$forEach$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveActivity liveActivity = this.$it$inlined.getLiveActivity();
            return new ItemPayload(PayloadType.OnlyUpdateCountdown, liveActivity != null ? liveActivity.a(this.this$0.$context) : null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
