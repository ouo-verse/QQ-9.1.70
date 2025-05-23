package com.tencent.mobileqq.aio.robot.msgrepo;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/aio/data/msglist/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.robot.msgrepo.RobotReportAbility$registerNotification$1", f = "RobotReportAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class RobotReportAbility$registerNotification$1 extends SuspendLambda implements Function2<List<? extends com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotReportAbility this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotReportAbility$registerNotification$1(RobotReportAbility robotReportAbility, Continuation<? super RobotReportAbility$registerNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = robotReportAbility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotReportAbility$registerNotification$1 robotReportAbility$registerNotification$1 = new RobotReportAbility$registerNotification$1(this.this$0, continuation);
        robotReportAbility$registerNotification$1.L$0 = obj;
        return robotReportAbility$registerNotification$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.t((List) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotReportAbility$registerNotification$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
