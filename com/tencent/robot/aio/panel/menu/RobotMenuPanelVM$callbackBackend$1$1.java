package com.tencent.robot.aio.panel.menu;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommandCbRsp;
import com.tencent.qqnt.robot.api.IRobotExtApi;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.aio.panel.menu.RobotMenuPanelVM$callbackBackend$1$1", f = "RobotMenuPanelVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class RobotMenuPanelVM$callbackBackend$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ Job $loadingTimeoutJob;
    final /* synthetic */ CommandCbRsp $response;
    final /* synthetic */ int $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotMenuPanelVM$callbackBackend$1$1(int i3, String str, Context context, Job job, CommandCbRsp commandCbRsp, Continuation<? super RobotMenuPanelVM$callbackBackend$1$1> continuation) {
        super(2, continuation);
        this.$result = i3;
        this.$errorMsg = str;
        this.$context = context;
        this.$loadingTimeoutJob = job;
        this.$response = commandCbRsp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotMenuPanelVM$callbackBackend$1$1(this.$result, this.$errorMsg, this.$context, this.$loadingTimeoutJob, this.$response, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i3 = this.$result;
            if (i3 != 0) {
                QLog.e("RobotMenuPanelVM", 1, "[callbackBackend]: result=" + i3 + ", error=" + this.$errorMsg);
                QQToast.makeText(this.$context, this.$errorMsg, 0).show();
                Job job = this.$loadingTimeoutJob;
                String errorMsg = this.$errorMsg;
                Intrinsics.checkNotNullExpressionValue(errorMsg, "errorMsg");
                JobKt__JobKt.cancel$default(job, errorMsg, null, 2, null);
            } else {
                CommandCbRsp commandCbRsp = this.$response;
                if (commandCbRsp != null) {
                    QLog.i("RobotMenuPanelVM", 1, "[callbackBackend]: promptType=" + commandCbRsp.promptType);
                    IRobotExtApi iRobotExtApi = (IRobotExtApi) QRoute.api(IRobotExtApi.class);
                    Context context = this.$context;
                    CommandCbRsp commandCbRsp2 = this.$response;
                    int i16 = commandCbRsp2.status;
                    int i17 = commandCbRsp2.promptType;
                    String str = commandCbRsp2.promptText;
                    Intrinsics.checkNotNullExpressionValue(str, "response.promptText");
                    iRobotExtApi.handleOnBackendReply(context, i16, i17, str, this.$response.promptIcon);
                    Job.DefaultImpls.cancel$default(this.$loadingTimeoutJob, (CancellationException) null, 1, (Object) null);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotMenuPanelVM$callbackBackend$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
