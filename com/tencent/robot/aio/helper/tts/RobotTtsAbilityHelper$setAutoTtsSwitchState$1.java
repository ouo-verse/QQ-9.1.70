package com.tencent.robot.aio.helper.tts;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.helper.tts.RobotTtsAbilityHelper$setAutoTtsSwitchState$1", f = "RobotTtsAbilityHelper.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotTtsAbilityHelper$setAutoTtsSwitchState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $targetSwitchOpened;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotTtsAbilityHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotTtsAbilityHelper$setAutoTtsSwitchState$1(RobotTtsAbilityHelper robotTtsAbilityHelper, boolean z16, Continuation<? super RobotTtsAbilityHelper$setAutoTtsSwitchState$1> continuation) {
        super(2, continuation);
        this.this$0 = robotTtsAbilityHelper;
        this.$targetSwitchOpened = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotTtsAbilityHelper$setAutoTtsSwitchState$1 robotTtsAbilityHelper$setAutoTtsSwitchState$1 = new RobotTtsAbilityHelper$setAutoTtsSwitchState$1(this.this$0, this.$targetSwitchOpened, continuation);
        robotTtsAbilityHelper$setAutoTtsSwitchState$1.L$0 = obj;
        return robotTtsAbilityHelper$setAutoTtsSwitchState$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
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
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new RobotTtsAbilityHelper$setAutoTtsSwitchState$1$isSuccess$1(this.this$0, this.$targetSwitchOpened, null), 3, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.A(this.$targetSwitchOpened);
        } else {
            this.this$0.z(this.$targetSwitchOpened);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotTtsAbilityHelper$setAutoTtsSwitchState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
