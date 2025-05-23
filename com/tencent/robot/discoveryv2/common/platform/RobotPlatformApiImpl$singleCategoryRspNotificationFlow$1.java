package com.tencent.robot.discoveryv2.common.platform;

import com.tencent.robot.discoveryv2.common.data.SingleCategoryRsp;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/robot/discoveryv2/common/data/j;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discoveryv2.common.platform.RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1", f = "RobotPlatformApiImpl.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super SingleCategoryRsp>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotPlatformApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1(RobotPlatformApiImpl robotPlatformApiImpl, Continuation<? super RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = robotPlatformApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1 robotPlatformApiImpl$singleCategoryRspNotificationFlow$1 = new RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1(this.this$0, continuation);
        robotPlatformApiImpl$singleCategoryRspNotificationFlow$1.L$0 = obj;
        return robotPlatformApiImpl$singleCategoryRspNotificationFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Function1<SingleCategoryRsp, Unit> function1 = new Function1<SingleCategoryRsp, Unit>() { // from class: com.tencent.robot.discoveryv2.common.platform.RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1$listener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SingleCategoryRsp singleCategoryRsp) {
                    invoke2(singleCategoryRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SingleCategoryRsp it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo2003trySendJP2dKIU(it);
                }
            };
            concurrentHashMap = this.this$0.mSingleCategoryRspListener;
            concurrentHashMap.put(Boxing.boxInt(function1.hashCode()), function1);
            final RobotPlatformApiImpl robotPlatformApiImpl = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.robot.discoveryv2.common.platform.RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConcurrentHashMap concurrentHashMap2;
                    concurrentHashMap2 = RobotPlatformApiImpl.this.mSingleCategoryRspListener;
                    concurrentHashMap2.remove(Integer.valueOf(function1.hashCode()));
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super SingleCategoryRsp> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
