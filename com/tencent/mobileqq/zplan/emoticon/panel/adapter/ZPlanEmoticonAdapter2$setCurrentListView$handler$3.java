package com.tencent.mobileqq.zplan.emoticon.panel.adapter;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\b\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$setCurrentListView$handler$3", f = "ZPlanEmoticonAdapter2.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ZPlanEmoticonAdapter2$setCurrentListView$handler$3 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ ZPlanEmoticonAdapter2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonAdapter2$setCurrentListView$handler$3(ZPlanEmoticonAdapter2 zPlanEmoticonAdapter2, Continuation<? super ZPlanEmoticonAdapter2$setCurrentListView$handler$3> continuation) {
        super(1, continuation);
        this.this$0 = zPlanEmoticonAdapter2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ZPlanEmoticonAdapter2$setCurrentListView$handler$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SessionInfo sessionInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
            sessionInfo = this.this$0.sessionInfo;
            String str = sessionInfo.f179557e;
            Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
            i a16 = IZPlanCoupleSceneHelper.a.a((IZPlanCoupleSceneHelper) api, str, null, 2, null);
            if (a16 == null) {
                return null;
            }
            this.label = 1;
            obj = a16.e(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (Integer) obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Integer> continuation) {
        return ((ZPlanEmoticonAdapter2$setCurrentListView$handler$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
