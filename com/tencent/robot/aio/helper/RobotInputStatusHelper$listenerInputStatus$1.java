package com.tencent.robot.aio.helper;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "inputStatusInfo", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.helper.RobotInputStatusHelper$listenerInputStatus$1", f = "RobotInputStatusHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotInputStatusHelper$listenerInputStatus$1 extends SuspendLambda implements Function2<InputStatusInfo, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotInputStatusHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotInputStatusHelper$listenerInputStatus$1(RobotInputStatusHelper robotInputStatusHelper, Continuation<? super RobotInputStatusHelper$listenerInputStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = robotInputStatusHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotInputStatusHelper$listenerInputStatus$1 robotInputStatusHelper$listenerInputStatus$1 = new RobotInputStatusHelper$listenerInputStatus$1(this.this$0, continuation);
        robotInputStatusHelper$listenerInputStatus$1.L$0 = obj;
        return robotInputStatusHelper$listenerInputStatus$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull InputStatusInfo inputStatusInfo, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotInputStatusHelper$listenerInputStatus$1) create(inputStatusInfo, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.aio.api.runtime.a aVar;
        boolean z16;
        String str;
        long j3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            InputStatusInfo inputStatusInfo = (InputStatusInfo) this.L$0;
            aVar = this.this$0.mAIOContext;
            String str2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            if (Intrinsics.areEqual(aVar.g().r().c().j(), inputStatusInfo.fromUin)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    str2 = peekAppRuntime.getCurrentUid();
                }
                if (Intrinsics.areEqual(str2, inputStatusInfo.toUin)) {
                    QLog.d("RobotInputStatusHelper", 1, "ListenerInputStatus: " + inputStatusInfo);
                    this.this$0.mTimeStamp = inputStatusInfo.timestamp;
                    if (inputStatusInfo.eventType != 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        str = this.this$0.j(inputStatusInfo);
                    } else {
                        str = "";
                    }
                    String str3 = inputStatusInfo.statusText;
                    j3 = this.this$0.mTimeStamp;
                    QLog.d("RobotInputStatusHelper", 1, "isShow:" + z16 + ", finalStatusText:" + str + ", statusText:" + str3 + ", mTimeStamp: " + j3);
                    this.this$0.p(z16, str);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
