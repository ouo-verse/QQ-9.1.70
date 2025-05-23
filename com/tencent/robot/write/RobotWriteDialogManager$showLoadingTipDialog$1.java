package com.tencent.robot.write;

import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w64.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.write.RobotWriteDialogManager$showLoadingTipDialog$1", f = "RobotWriteDialogManager.kt", i = {0}, l = {211}, m = "invokeSuspend", n = {"$this$qLaunch"}, s = {"L$0"})
/* loaded from: classes25.dex */
public final class RobotWriteDialogManager$showLoadingTipDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotWriteDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotWriteDialogManager$showLoadingTipDialog$1(RobotWriteDialogManager robotWriteDialogManager, Continuation<? super RobotWriteDialogManager$showLoadingTipDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = robotWriteDialogManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotWriteDialogManager$showLoadingTipDialog$1 robotWriteDialogManager$showLoadingTipDialog$1 = new RobotWriteDialogManager$showLoadingTipDialog$1(this.this$0, continuation);
        robotWriteDialogManager$showLoadingTipDialog$1.L$0 = obj;
        return robotWriteDialogManager$showLoadingTipDialog$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        o i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            i3 = this.this$0.i();
            if (!i3.r()) {
                i3.showDialog();
            }
            i3.c().a(SlashDialogMsgIntent.ShowLoadingState.f368549e);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotWriteDialogManager$showLoadingTipDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
