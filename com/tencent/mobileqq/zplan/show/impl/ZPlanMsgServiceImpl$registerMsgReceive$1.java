package com.tencent.mobileqq.zplan.show.impl;

import com.tencent.qqnt.msg.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/msg/d;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.show.impl.ZPlanMsgServiceImpl$registerMsgReceive$1", f = "ZPlanMsgServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanMsgServiceImpl$registerMsgReceive$1 extends SuspendLambda implements Function2<List<? extends d>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZPlanMsgServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMsgServiceImpl$registerMsgReceive$1(ZPlanMsgServiceImpl zPlanMsgServiceImpl, Continuation<? super ZPlanMsgServiceImpl$registerMsgReceive$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanMsgServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZPlanMsgServiceImpl$registerMsgReceive$1 zPlanMsgServiceImpl$registerMsgReceive$1 = new ZPlanMsgServiceImpl$registerMsgReceive$1(this.this$0, continuation);
        zPlanMsgServiceImpl$registerMsgReceive$1.L$0 = obj;
        return zPlanMsgServiceImpl$registerMsgReceive$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.onMsgReceive((List) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(List<? extends d> list, Continuation<? super Unit> continuation) {
        return ((ZPlanMsgServiceImpl$registerMsgReceive$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
