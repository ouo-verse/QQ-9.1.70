package com.tencent.sqshow.zootopia.friendsdressup.filament;

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
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lorg/json/JSONObject;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpAvatarHelper$requestAvatarInfoAsync$1", f = "FriendsDressUpAvatarHelper.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"start"}, s = {"J$0"})
/* loaded from: classes34.dex */
final class FriendsDressUpAvatarHelper$requestAvatarInfoAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ long $uin;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpAvatarHelper$requestAvatarInfoAsync$1(long j3, Continuation<? super FriendsDressUpAvatarHelper$requestAvatarInfoAsync$1> continuation) {
        super(2, continuation);
        this.$uin = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FriendsDressUpAvatarHelper$requestAvatarInfoAsync$1(this.$uin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            long currentTimeMillis = System.currentTimeMillis();
            IZPlanAvatarInfoHelper iZPlanAvatarInfoHelper = (IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class);
            String valueOf = String.valueOf(this.$uin);
            this.J$0 = currentTimeMillis;
            this.label = 1;
            obj = iZPlanAvatarInfoHelper.fetchOtherAvatarInfoWithUin(valueOf, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
        } else if (i3 == 1) {
            j3 = this.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject jSONObject = (JSONObject) obj;
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAvatarHelper", "requestAvatarInfoAsync, cost=" + (System.currentTimeMillis() - j3));
        return jSONObject;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JSONObject> continuation) {
        return ((FriendsDressUpAvatarHelper$requestAvatarInfoAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
