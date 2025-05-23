package com.tencent.robot.aio.helper;

import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import com.tencent.robot.api.IRobotPersonalInfoService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.helper.RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1", f = "RobotProfileHelper.kt", i = {}, l = {517}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RobotFeature>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RobotProfileHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1(RobotProfileHelper robotProfileHelper, Continuation<? super RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1> continuation) {
        super(2, continuation);
        this.this$0 = robotProfileHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        IRuntimeService iRuntimeService;
        String p16;
        Object coroutine_suspended2;
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
            RobotProfileHelper robotProfileHelper = this.this$0;
            this.L$0 = robotProfileHelper;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRobotPersonalInfoService iRobotPersonalInfoService = (IRobotPersonalInfoService) iRuntimeService;
            if (iRobotPersonalInfoService != null) {
                p16 = robotProfileHelper.p();
                iRobotPersonalInfoService.getRobotPersonalInfoAsync(p16, new Function2<Boolean, RobotFeature, Unit>() { // from class: com.tencent.robot.aio.helper.RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, RobotFeature robotFeature) {
                        invoke(bool.booleanValue(), robotFeature);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @Nullable RobotFeature robotFeature) {
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(robotFeature));
                    }
                });
            } else {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
            }
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super RobotFeature> continuation) {
        return ((RobotProfileHelper$updateRobotPersonalInfo$1$robotFeature$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
