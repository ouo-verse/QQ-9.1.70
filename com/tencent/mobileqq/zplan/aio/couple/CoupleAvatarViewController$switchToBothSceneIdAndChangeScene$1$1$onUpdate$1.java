package com.tencent.mobileqq.zplan.aio.couple;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ku4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1$1$onUpdate$1", f = "CoupleAvatarViewController.kt", i = {}, l = {582}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1$1$onUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $sceneConfig;
    int label;
    final /* synthetic */ CoupleAvatarViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1$1$onUpdate$1(CoupleAvatarViewController coupleAvatarViewController, n nVar, Continuation<? super CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1$1$onUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarViewController;
        this.$sceneConfig = nVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1$1$onUpdate$1(this.this$0, this.$sceneConfig, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        le3.b g06;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoupleAvatarViewController coupleAvatarViewController = this.this$0;
            g06 = coupleAvatarViewController.g0(this.$sceneConfig);
            this.label = 1;
            if (coupleAvatarViewController.b(g06, false, this) == coroutine_suspended) {
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
        return ((CoupleAvatarViewController$switchToBothSceneIdAndChangeScene$1$1$onUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
