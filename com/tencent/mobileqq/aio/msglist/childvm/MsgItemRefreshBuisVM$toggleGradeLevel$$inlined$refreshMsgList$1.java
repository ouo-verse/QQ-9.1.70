package com.tencent.mobileqq.aio.msglist.childvm;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.refresher.t;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.childvm.MsgItemRefreshBuisVM$toggleGradeLevel$$inlined$refreshMsgList$1", f = "MsgItemRefreshBuisVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class MsgItemRefreshBuisVM$toggleGradeLevel$$inlined$refreshMsgList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $from;
    final /* synthetic */ t $rsp$inlined;
    final /* synthetic */ MsgListVMWrapper $this_refreshMsgList;
    int label;
    final /* synthetic */ MsgItemRefreshBuisVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgItemRefreshBuisVM$toggleGradeLevel$$inlined$refreshMsgList$1(MsgListVMWrapper msgListVMWrapper, MsgItemRefreshBuisVM msgItemRefreshBuisVM, String str, Continuation continuation, t tVar) {
        super(2, continuation);
        this.$this_refreshMsgList = msgListVMWrapper;
        this.this$0 = msgItemRefreshBuisVM;
        this.$from = str;
        this.$rsp$inlined = tVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgListVMWrapper, msgItemRefreshBuisVM, str, continuation, tVar);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgItemRefreshBuisVM$toggleGradeLevel$$inlined$refreshMsgList$1(this.$this_refreshMsgList, this.this$0, this.$from, continuation, this.$rsp$inlined);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        com.tencent.qqnt.aio.nick.gradelevel.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                MsgList M = this.$this_refreshMsgList.m().M();
                if (M.isEmpty()) {
                    QLog.i("MsgItemRefreshBuisVM", 1, "[refreshMsgList]: displayList size is 0");
                }
                MsgItemRefreshBuisVM msgItemRefreshBuisVM = this.this$0;
                String str = this.$from;
                int i3 = 0;
                for (Object obj2 : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a msgItem = (com.tencent.aio.data.msglist.a) obj2;
                    Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
                    if (msgItem instanceof AIOMsgItem) {
                        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
                        if (!com.tencent.mobileqq.aio.utils.d.s(aIOMsgItem)) {
                            com.tencent.qqnt.aio.nick.gradelevel.a E = aIOMsgItem.E();
                            if (E != null && E.d() == this.$rsp$inlined.b()) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (!z18) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MsgItemRefreshBuisVM", 4, "[toggleGradeLevel]: memberUin= " + this.$rsp$inlined.a());
                                }
                                com.tencent.qqnt.aio.nick.gradelevel.a E2 = aIOMsgItem.E();
                                if (E2 != null) {
                                    aVar = com.tencent.qqnt.aio.nick.gradelevel.a.b(E2, 0, 0, this.$rsp$inlined.b(), 3, null);
                                } else {
                                    aVar = null;
                                }
                                AIOMsgItem cloneNewInstance = aIOMsgItem.cloneNewInstance();
                                cloneNewInstance.n1(aVar);
                                Unit unit = Unit.INSTANCE;
                                M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                                z16 = true;
                                if (z16 && !booleanRef.element) {
                                    z17 = false;
                                } else {
                                    z17 = true;
                                }
                                booleanRef.element = z17;
                                i3 = i16;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                    z17 = true;
                    booleanRef.element = z17;
                    i3 = i16;
                }
                if (booleanRef.element) {
                    e.a(msgItemRefreshBuisVM, M, str);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgItemRefreshBuisVM$toggleGradeLevel$$inlined$refreshMsgList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
