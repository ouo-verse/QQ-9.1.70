package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.refresher.as;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.MsgItemRefreshBuisVM$refreshShootBubble$1", f = "MsgItemRefreshBuisVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgItemRefreshBuisVM$refreshShootBubble$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ as $rsp;
    int label;
    final /* synthetic */ MsgItemRefreshBuisVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgItemRefreshBuisVM$refreshShootBubble$1(MsgItemRefreshBuisVM msgItemRefreshBuisVM, as asVar, Continuation<? super MsgItemRefreshBuisVM$refreshShootBubble$1> continuation) {
        super(2, continuation);
        this.this$0 = msgItemRefreshBuisVM;
        this.$rsp = asVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItemRefreshBuisVM, asVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgItemRefreshBuisVM$refreshShootBubble$1(this.this$0, this.$rsp, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                MsgList M = this.this$0.d().m().M();
                if (M.isEmpty()) {
                    QLog.i("MsgItemRefreshBuisVM", 1, "[refreshShootBubble]: displayList size is 0");
                }
                as asVar = this.$rsp;
                int i3 = 0;
                for (com.tencent.aio.data.msglist.a aVar : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar2 = aVar;
                    if (aVar2 instanceof AIOMsgItem) {
                        AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar2;
                        if (Intrinsics.areEqual(asVar.b(), String.valueOf(aIOMsgItem.getMsgRecord().senderUin))) {
                            booleanRef.element = true;
                            if (QLog.isDevelopLevel()) {
                                QLog.i("MsgItemRefreshBuisVM", 4, "[refreshBubble]: msgId is  " + aVar2.getMsgId() + ", data is  " + asVar.a().b());
                            }
                            aIOMsgItem.R1(asVar.a());
                        }
                    }
                    i3 = i16;
                }
                if (booleanRef.element) {
                    e.a(this.this$0, M, "shoot_bubble");
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgItemRefreshBuisVM$refreshShootBubble$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
