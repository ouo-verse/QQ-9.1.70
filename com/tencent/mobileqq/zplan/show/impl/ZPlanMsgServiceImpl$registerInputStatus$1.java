package com.tencent.mobileqq.zplan.show.impl;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.zplan.show.MsgData;
import com.tencent.mobileqq.zplan.show.MsgType;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "inputStatusInfo", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.show.impl.ZPlanMsgServiceImpl$registerInputStatus$1", f = "ZPlanMsgServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanMsgServiceImpl$registerInputStatus$1 extends SuspendLambda implements Function2<InputStatusInfo, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZPlanMsgServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMsgServiceImpl$registerInputStatus$1(ZPlanMsgServiceImpl zPlanMsgServiceImpl, Continuation<? super ZPlanMsgServiceImpl$registerInputStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanMsgServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZPlanMsgServiceImpl$registerInputStatus$1 zPlanMsgServiceImpl$registerInputStatus$1 = new ZPlanMsgServiceImpl$registerInputStatus$1(this.this$0, continuation);
        zPlanMsgServiceImpl$registerInputStatus$1.L$0 = obj;
        return zPlanMsgServiceImpl$registerInputStatus$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(InputStatusInfo inputStatusInfo, Continuation<? super Unit> continuation) {
        return ((ZPlanMsgServiceImpl$registerInputStatus$1) create(inputStatusInfo, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WeakReference weakReference;
        AIOParam aIOParam;
        MsgType msgType;
        List list;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            InputStatusInfo inputStatusInfo = (InputStatusInfo) this.L$0;
            weakReference = this.this$0.aioParam;
            if (weakReference != null && (aIOParam = (AIOParam) weakReference.get()) != null) {
                ZPlanMsgServiceImpl zPlanMsgServiceImpl = this.this$0;
                if (Intrinsics.areEqual(aIOParam.r().c().j(), inputStatusInfo.fromUin) && Intrinsics.areEqual(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid(), inputStatusInfo.toUin)) {
                    if (inputStatusInfo.eventType == 2) {
                        msgType = MsgType.MSG_INPUTCANCEL;
                    } else {
                        msgType = MsgType.MSG_INPUTTING;
                    }
                    list = zPlanMsgServiceImpl.listenerList;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mobileqq.zplan.show.a) it.next()).a(new MsgData(msgType, null, 2, null));
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
