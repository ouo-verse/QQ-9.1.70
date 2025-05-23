package com.tencent.robot.discoveryv2.common.platform;

import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import com.tencent.robot.discoveryv2.common.data.b;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/robot/discoveryv2/common/data/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discoveryv2.common.platform.RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1$serverRspData$1", f = "RobotPlatformApiImpl.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1$serverRspData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b>, Object> {
    final /* synthetic */ FirstScreenFetchArgs $fetchArgs;
    int label;
    final /* synthetic */ RobotPlatformApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1$serverRspData$1(RobotPlatformApiImpl robotPlatformApiImpl, FirstScreenFetchArgs firstScreenFetchArgs, Continuation<? super RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1$serverRspData$1> continuation) {
        super(2, continuation);
        this.this$0 = robotPlatformApiImpl;
        this.$fetchArgs = firstScreenFetchArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1$serverRspData$1(this.this$0, this.$fetchArgs, continuation);
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
            RobotPlatformApiImpl robotPlatformApiImpl = this.this$0;
            FirstScreenFetchArgs firstScreenFetchArgs = this.$fetchArgs;
            this.label = 1;
            obj = robotPlatformApiImpl.i(firstScreenFetchArgs, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super b> continuation) {
        return ((RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1$serverRspData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
