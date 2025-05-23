package com.tencent.robot.profile.setting;

import android.content.Context;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.profile.setting.RobotSettingUtil$lookAtAdder$1", f = "RobotSettingUtil.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotSettingUtil$lookAtAdder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $adderUin;
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingUtil$lookAtAdder$1(String str, Context context, Continuation<? super RobotSettingUtil$lookAtAdder$1> continuation) {
        super(2, continuation);
        this.$adderUin = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotSettingUtil$lookAtAdder$1(this.$adderUin, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            RobotSettingUtil robotSettingUtil = RobotSettingUtil.f368093a;
            String str = this.$adderUin;
            this.label = 1;
            obj = robotSettingUtil.n(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCard(this.$context, new AllInOne(this.$adderUin, ((Number) obj).intValue()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotSettingUtil$lookAtAdder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
