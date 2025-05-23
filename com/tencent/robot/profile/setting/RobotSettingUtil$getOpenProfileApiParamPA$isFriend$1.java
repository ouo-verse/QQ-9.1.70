package com.tencent.robot.profile.setting;

import com.tencent.mobileqq.friend.api.IFriendDataService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.profile.setting.RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1", f = "RobotSettingUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $uin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1(String str, Continuation<? super RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1> continuation) {
        super(2, continuation);
        this.$uin = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1(this.$uin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IFriendDataService iFriendDataService;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            boolean z16 = false;
            if (peekAppRuntime != null && (iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "")) != null && iFriendDataService.isFriend(this.$uin)) {
                z16 = true;
            }
            return Boxing.boxBoolean(z16);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((RobotSettingUtil$getOpenProfileApiParamPA$isFriend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
