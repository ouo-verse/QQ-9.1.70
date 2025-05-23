package com.tencent.robot.menu;

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
@DebugMetadata(c = "com.tencent.robot.menu.RobotMenuDialogManager$showLoadingTipDialog$1", f = "RobotMenuDialogManager.kt", i = {0}, l = {187}, m = "invokeSuspend", n = {"$this$qLaunch"}, s = {"L$0"})
/* loaded from: classes25.dex */
public final class RobotMenuDialogManager$showLoadingTipDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotMenuDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotMenuDialogManager$showLoadingTipDialog$1(RobotMenuDialogManager robotMenuDialogManager, Continuation<? super RobotMenuDialogManager$showLoadingTipDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = robotMenuDialogManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotMenuDialogManager$showLoadingTipDialog$1 robotMenuDialogManager$showLoadingTipDialog$1 = new RobotMenuDialogManager$showLoadingTipDialog$1(this.this$0, continuation);
        robotMenuDialogManager$showLoadingTipDialog$1.L$0 = obj;
        return robotMenuDialogManager$showLoadingTipDialog$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        o g16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
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
            g16 = this.this$0.g();
            if (!g16.r()) {
                g16.showDialog();
            }
            g16.c().a(SlashDialogMsgIntent.ShowLoadingState.f368549e);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotMenuDialogManager$showLoadingTipDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
