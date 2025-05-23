package com.tencent.mobileqq.aio.robot.sendmsg;

import android.view.View;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.robot.sendmsg.RobotAIOSendMsgVBDelegate$onViewParentPrepared$1", f = "RobotAIOSendMsgVBDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class RobotAIOSendMsgVBDelegate$onViewParentPrepared$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RobotAIOSendMsgVBDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotAIOSendMsgVBDelegate$onViewParentPrepared$1(RobotAIOSendMsgVBDelegate robotAIOSendMsgVBDelegate, Continuation<? super RobotAIOSendMsgVBDelegate$onViewParentPrepared$1> continuation) {
        super(2, continuation);
        this.this$0 = robotAIOSendMsgVBDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotAIOSendMsgVBDelegate robotAIOSendMsgVBDelegate) {
        robotAIOSendMsgVBDelegate.t();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotAIOSendMsgVBDelegate$onViewParentPrepared$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.mobileqq.aio.input.adorn.e eVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            eVar = this.this$0.mBinding;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            View mRv = eVar.getMRv();
            final RobotAIOSendMsgVBDelegate robotAIOSendMsgVBDelegate = this.this$0;
            mRv.post(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.sendmsg.c
                @Override // java.lang.Runnable
                public final void run() {
                    RobotAIOSendMsgVBDelegate$onViewParentPrepared$1.b(RobotAIOSendMsgVBDelegate.this);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotAIOSendMsgVBDelegate$onViewParentPrepared$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
