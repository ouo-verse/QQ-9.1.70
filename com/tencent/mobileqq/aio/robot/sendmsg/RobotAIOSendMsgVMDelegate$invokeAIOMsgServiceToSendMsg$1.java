package com.tencent.mobileqq.aio.robot.sendmsg;

import android.os.Bundle;
import com.tencent.aio.msgservice.j;
import com.tencent.aio.msgservice.k;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/j;", "", "msgServiceRsp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1", f = "RobotAIOSendMsgVMDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1 extends SuspendLambda implements Function2<j<String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $extData;
    final /* synthetic */ long $msgId;
    final /* synthetic */ k $sendMsgsReq;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotAIOSendMsgVMDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1(RobotAIOSendMsgVMDelegate robotAIOSendMsgVMDelegate, long j3, k kVar, Bundle bundle, Continuation<? super RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = robotAIOSendMsgVMDelegate;
        this.$msgId = j3;
        this.$sendMsgsReq = kVar;
        this.$extData = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1 robotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1 = new RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1(this.this$0, this.$msgId, this.$sendMsgsReq, this.$extData, continuation);
        robotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1.L$0 = obj;
        return robotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull j<String> jVar, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotAIOSendMsgVMDelegate$invokeAIOMsgServiceToSendMsg$1) create(jVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.qqnt.aio.interceptor.sendmsg.a aVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            j jVar = (j) this.L$0;
            aVar = this.this$0.mSendMsgInterceptor;
            if (aVar != null) {
                aVar.reportAfterKernelSend(jVar.d(), this.$msgId);
            }
            if (jVar.d()) {
                this.this$0.t0(this.$msgId, this.$sendMsgsReq, this.$extData);
            } else {
                this.this$0.s0(jVar.c(), jVar.b());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
