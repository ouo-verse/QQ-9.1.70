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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2$handleChangeScene$1", f = "ZPlanEmoticonAdapter2.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonAdapter2$handleChangeScene$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ le3.b $sceneConfig;
    int label;
    final /* synthetic */ ZPlanEmoticonAdapter2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonAdapter2$handleChangeScene$1(ZPlanEmoticonAdapter2 zPlanEmoticonAdapter2, le3.b bVar, Continuation<? super ZPlanEmoticonAdapter2$handleChangeScene$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanEmoticonAdapter2;
        this.$sceneConfig = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonAdapter2$handleChangeScene$1(this.this$0, this.$sceneConfig, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SessionInfo sessionInfo;
        boolean s16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            sessionInfo = this.this$0.sessionInfo;
            String friendUin = sessionInfo.f179557e;
            ZPlanEmoticonAdapter2 zPlanEmoticonAdapter2 = this.this$0;
            Intrinsics.checkNotNullExpressionValue(friendUin, "friendUin");
            s16 = zPlanEmoticonAdapter2.s(friendUin);
            if (s16) {
                return Boxing.boxBoolean(false);
            }
            QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
            i a16 = IZPlanCoupleSceneHelper.a.a((IZPlanCoupleSceneHelper) api, friendUin, null, 2, null);
            if (a16 != null) {
                le3.b bVar = this.$sceneConfig;
                this.label = 1;
                if (a16.b(bVar, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((ZPlanEmoticonAdapter2$handleChangeScene$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
