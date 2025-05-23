package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$jsEventListener$2$1$handleEvent$3", f = "CoupleAvatarLayout.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class CoupleAvatarLayout$jsEventListener$2$1$handleEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CoupleAvatarLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarLayout$jsEventListener$2$1$handleEvent$3(CoupleAvatarLayout coupleAvatarLayout, Continuation<? super CoupleAvatarLayout$jsEventListener$2$1$handleEvent$3> continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarLayout$jsEventListener$2$1$handleEvent$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
            String peerUin = this.this$0.getPeerUin();
            this.label = 1;
            if (iZPlanAvatarInfoHelper.fetchOtherAvatarInfoWithUin(peerUin, this) == coroutine_suspended) {
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
        return ((CoupleAvatarLayout$jsEventListener$2$1$handleEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
