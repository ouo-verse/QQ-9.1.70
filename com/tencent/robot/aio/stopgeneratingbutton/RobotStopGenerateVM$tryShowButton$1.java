package com.tencent.robot.aio.stopgeneratingbutton;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.stopgeneratingbutton.RobotStopGenerateUIState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.stopgeneratingbutton.RobotStopGenerateVM$tryShowButton$1", f = "RobotStopGenerateVM.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotStopGenerateVM$tryShowButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RobotStopGenerateVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotStopGenerateVM$tryShowButton$1(RobotStopGenerateVM robotStopGenerateVM, Continuation<? super RobotStopGenerateVM$tryShowButton$1> continuation) {
        super(2, continuation);
        this.this$0 = robotStopGenerateVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotStopGenerateVM$tryShowButton$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AIOMsgItem s16;
        boolean A;
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
            QLog.i("RobotStopGenerateVM", 1, "[tryShowButton]: delay task started");
            this.label = 1;
            if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        RobotStopGenerateVM robotStopGenerateVM = this.this$0;
        s16 = robotStopGenerateVM.s();
        A = robotStopGenerateVM.A(s16);
        if (A) {
            this.this$0.buttonVisible = true;
            this.this$0.updateUI(new RobotStopGenerateUIState.ButtonVisible(true));
            QLog.i("RobotStopGenerateVM", 1, "[tryShowButton]: show button");
        } else {
            this.this$0.buttonVisible = false;
            this.this$0.updateUI(new RobotStopGenerateUIState.ButtonVisible(false));
            QLog.i("RobotStopGenerateVM", 1, "[tryShowButton]: not need show button");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotStopGenerateVM$tryShowButton$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
