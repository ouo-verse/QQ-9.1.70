package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.view.FilterEnum;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$checkIfNeedToChangeScene$2", f = "CoupleAvatarViewController.kt", i = {}, l = {FilterEnum.MIC_PTU_TRANS_KONGCHENG}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class CoupleAvatarViewController$checkIfNeedToChangeScene$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $targetSceneId;
    int label;
    final /* synthetic */ CoupleAvatarViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarViewController$checkIfNeedToChangeScene$2(CoupleAvatarViewController coupleAvatarViewController, int i3, Continuation<? super CoupleAvatarViewController$checkIfNeedToChangeScene$2> continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarViewController;
        this.$targetSceneId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarViewController$checkIfNeedToChangeScene$2(this.this$0, this.$targetSceneId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoupleAvatarLayout coupleAvatarLayout;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            coupleAvatarLayout = this.this$0.coupleAvatarLayout;
            if (coupleAvatarLayout != null) {
                int i16 = this.$targetSceneId;
                this.label = 1;
                if (coupleAvatarLayout.H(i16, this) == coroutine_suspended) {
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
        return ((CoupleAvatarViewController$checkIfNeedToChangeScene$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
