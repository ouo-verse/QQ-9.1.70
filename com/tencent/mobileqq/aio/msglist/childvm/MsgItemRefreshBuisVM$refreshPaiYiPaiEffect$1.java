package com.tencent.mobileqq.aio.msglist.childvm;

import android.text.TextUtils;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.refresher.am;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.MsgItemRefreshBuisVM$refreshPaiYiPaiEffect$1", f = "MsgItemRefreshBuisVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgItemRefreshBuisVM$refreshPaiYiPaiEffect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ am $rsp;
    int label;
    final /* synthetic */ MsgItemRefreshBuisVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgItemRefreshBuisVM$refreshPaiYiPaiEffect$1(MsgItemRefreshBuisVM msgItemRefreshBuisVM, am amVar, Continuation<? super MsgItemRefreshBuisVM$refreshPaiYiPaiEffect$1> continuation) {
        super(2, continuation);
        this.this$0 = msgItemRefreshBuisVM;
        this.$rsp = amVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItemRefreshBuisVM, amVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgItemRefreshBuisVM$refreshPaiYiPaiEffect$1(this.this$0, this.$rsp, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int lastIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MsgList M = this.this$0.d().m().M();
                boolean z16 = true;
                if (M.isEmpty()) {
                    QLog.i("MsgItemRefreshBuisVM", 1, "[refreshPaiYiPaiEffect]: displayList size is 0");
                }
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(M);
                while (true) {
                    if (-1 < lastIndex) {
                        com.tencent.aio.data.msglist.a aVar = M.get(lastIndex);
                        if (aVar instanceof AIOMsgItem) {
                            AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                            int i3 = aIOMsgItem.getMsgRecord().msgType;
                            if (i3 != 5 && i3 != 23 && TextUtils.equals(aIOMsgItem.getMsgRecord().senderUid, this.$rsp.a())) {
                                aIOMsgItem.I1(1);
                                QLog.d("MsgItemRefreshBuisVM", 1, "[refreshPaiYiPaiEffect] msgItem " + aVar);
                                break;
                            }
                        }
                        lastIndex--;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    e.a(this.this$0, M, "pai_yi_pai");
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgItemRefreshBuisVM$refreshPaiYiPaiEffect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
