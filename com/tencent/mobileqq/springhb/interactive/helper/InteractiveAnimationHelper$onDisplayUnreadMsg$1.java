package com.tencent.mobileqq.springhb.interactive.helper;

import com.tencent.aio.data.msglist.a;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.mobileqq.springhb.interactive.api.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.springhb.interactive.helper.InteractiveAnimationHelper$onDisplayUnreadMsg$1", f = "InteractiveAnimationHelper.kt", i = {0, 0, 0}, l = {277, 283}, m = "invokeSuspend", n = {"$this$flow", TabPreloadItem.TAB_NAME_MESSAGE, "aioMsgItem"}, s = {"L$0", "L$1", "L$3"})
/* loaded from: classes18.dex */
public final class InteractiveAnimationHelper$onDisplayUnreadMsg$1 extends SuspendLambda implements Function2<FlowCollector<? super InteractiveRecord>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ List<a> $msgItemList;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InteractiveAnimationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InteractiveAnimationHelper$onDisplayUnreadMsg$1(List<? extends a> list, InteractiveAnimationHelper interactiveAnimationHelper, Continuation<? super InteractiveAnimationHelper$onDisplayUnreadMsg$1> continuation) {
        super(2, continuation);
        this.$msgItemList = list;
        this.this$0 = interactiveAnimationHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, interactiveAnimationHelper, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        InteractiveAnimationHelper$onDisplayUnreadMsg$1 interactiveAnimationHelper$onDisplayUnreadMsg$1 = new InteractiveAnimationHelper$onDisplayUnreadMsg$1(this.$msgItemList, this.this$0, continuation);
        interactiveAnimationHelper$onDisplayUnreadMsg$1.L$0 = obj;
        return interactiveAnimationHelper$onDisplayUnreadMsg$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b3 -> B:18:0x00bb). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List reversed;
        Iterator it;
        FlowCollector flowCollector;
        List list;
        InteractiveAnimationHelper$onDisplayUnreadMsg$1 interactiveAnimationHelper$onDisplayUnreadMsg$1;
        long j3;
        Object k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AIOMsgItem aIOMsgItem = (AIOMsgItem) this.L$3;
                Iterator it5 = (Iterator) this.L$2;
                List list2 = (List) this.L$1;
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector3 = flowCollector2;
                List list3 = list2;
                Iterator it6 = it5;
                AIOMsgItem aIOMsgItem2 = aIOMsgItem;
                Object obj2 = coroutine_suspended;
                InteractiveAnimationHelper$onDisplayUnreadMsg$1 interactiveAnimationHelper$onDisplayUnreadMsg$12 = this;
                InteractiveRecord interactiveRecord = (InteractiveRecord) obj;
                if (interactiveRecord == null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("InteractiveAnimationHelper", 1, "Detected!!!!!");
                    }
                    interactiveAnimationHelper$onDisplayUnreadMsg$12.this$0.easterEggMsgSeq = aIOMsgItem2.getMsgRecord().msgSeq;
                    interactiveAnimationHelper$onDisplayUnreadMsg$12.L$0 = null;
                    interactiveAnimationHelper$onDisplayUnreadMsg$12.L$1 = null;
                    interactiveAnimationHelper$onDisplayUnreadMsg$12.L$2 = null;
                    interactiveAnimationHelper$onDisplayUnreadMsg$12.L$3 = null;
                    interactiveAnimationHelper$onDisplayUnreadMsg$12.label = 2;
                    if (flowCollector3.emit(interactiveRecord, interactiveAnimationHelper$onDisplayUnreadMsg$12) == obj2) {
                        return obj2;
                    }
                    return Unit.INSTANCE;
                }
                interactiveAnimationHelper$onDisplayUnreadMsg$1 = interactiveAnimationHelper$onDisplayUnreadMsg$12;
                coroutine_suspended = obj2;
                it = it6;
                list = list3;
                flowCollector = flowCollector3;
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        AIOMsgItem aIOMsgItem3 = (AIOMsgItem) aVar;
                        if (aIOMsgItem3.getMsgRecord() != null) {
                            long j16 = aIOMsgItem3.getMsgRecord().msgSeq;
                            j3 = interactiveAnimationHelper$onDisplayUnreadMsg$1.this$0.easterEggMsgSeq;
                            if (j16 <= j3) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.i("InteractiveAnimationHelper", 1, "It is old msg,return.");
                                }
                                return Unit.INSTANCE;
                            }
                            d a16 = c.INSTANCE.a(aIOMsgItem3.getMsgRecord());
                            InteractiveAnimationHelper interactiveAnimationHelper = interactiveAnimationHelper$onDisplayUnreadMsg$1.this$0;
                            interactiveAnimationHelper$onDisplayUnreadMsg$1.L$0 = flowCollector;
                            interactiveAnimationHelper$onDisplayUnreadMsg$1.L$1 = list;
                            interactiveAnimationHelper$onDisplayUnreadMsg$1.L$2 = it;
                            interactiveAnimationHelper$onDisplayUnreadMsg$1.L$3 = aIOMsgItem3;
                            interactiveAnimationHelper$onDisplayUnreadMsg$1.label = 1;
                            k3 = interactiveAnimationHelper.k(a16, interactiveAnimationHelper$onDisplayUnreadMsg$1);
                            if (k3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj3 = coroutine_suspended;
                            interactiveAnimationHelper$onDisplayUnreadMsg$12 = interactiveAnimationHelper$onDisplayUnreadMsg$1;
                            obj = k3;
                            flowCollector3 = flowCollector;
                            list3 = list;
                            it6 = it;
                            aIOMsgItem2 = aIOMsgItem3;
                            obj2 = obj3;
                            InteractiveRecord interactiveRecord2 = (InteractiveRecord) obj;
                            if (interactiveRecord2 == null) {
                            }
                        }
                    }
                }
                if (!list.isEmpty()) {
                    interactiveAnimationHelper$onDisplayUnreadMsg$1.this$0.easterEggMsgSeq = ((a) list.get(0)).getMsgSeq();
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector4 = (FlowCollector) this.L$0;
            reversed = CollectionsKt___CollectionsKt.reversed(this.$msgItemList);
            it = reversed.iterator();
            flowCollector = flowCollector4;
            list = reversed;
            interactiveAnimationHelper$onDisplayUnreadMsg$1 = this;
            while (it.hasNext()) {
            }
            if (!list.isEmpty()) {
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super InteractiveRecord> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((InteractiveAnimationHelper$onDisplayUnreadMsg$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) flowCollector, (Object) continuation);
    }
}
