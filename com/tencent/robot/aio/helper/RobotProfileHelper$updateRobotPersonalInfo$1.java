package com.tencent.robot.aio.helper;

import com.tencent.aio.data.AIOParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import com.tencent.robot.profile.RobotProfileMsgIntent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.helper.RobotProfileHelper$updateRobotPersonalInfo$1", f = "RobotProfileHelper.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotProfileHelper$updateRobotPersonalInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotProfileHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileHelper$updateRobotPersonalInfo$1(RobotProfileHelper robotProfileHelper, Continuation<? super RobotProfileHelper$updateRobotPersonalInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = robotProfileHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotProfileHelper$updateRobotPersonalInfo$1 robotProfileHelper$updateRobotPersonalInfo$1 = new RobotProfileHelper$updateRobotPersonalInfo$1(this.this$0, continuation);
        robotProfileHelper$updateRobotPersonalInfo$1.L$0 = obj;
        return robotProfileHelper$updateRobotPersonalInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        String q16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        com.tencent.aio.api.runtime.a aVar = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1(this.this$0, null), 3, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        RobotFeature robotFeature = (RobotFeature) obj;
        if (robotFeature == null) {
            q16 = this.this$0.q();
            QLog.e("RobotProfileHelper", 1, "updateRobotPersonalInfo robotFeature is null " + q16);
            return Unit.INSTANCE;
        }
        this.this$0.x(robotFeature);
        com.tencent.aio.api.runtime.a aVar2 = this.this$0.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar2.e();
        com.tencent.aio.api.runtime.a aVar3 = this.this$0.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar3;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        e16.h(new RobotProfileMsgIntent.OnRobotPersonalInfoUpdated(su3.c.b(g16), robotFeature));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotProfileHelper$updateRobotPersonalInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
