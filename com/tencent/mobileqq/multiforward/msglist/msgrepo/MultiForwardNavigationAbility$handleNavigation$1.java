package com.tencent.mobileqq.multiforward.msglist.msgrepo;

import com.tencent.aio.data.msglist.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ws.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.multiforward.msglist.msgrepo.MultiForwardNavigationAbility$handleNavigation$1", f = "MultiForwardNavigationAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class MultiForwardNavigationAbility$handleNavigation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MsgNavigationEvent.NavigateForMultiForward $intent;
    int label;
    final /* synthetic */ MultiForwardNavigationAbility this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiForwardNavigationAbility$handleNavigation$1(MultiForwardNavigationAbility multiForwardNavigationAbility, MsgNavigationEvent.NavigateForMultiForward navigateForMultiForward, Continuation<? super MultiForwardNavigationAbility$handleNavigation$1> continuation) {
        super(2, continuation);
        this.this$0 = multiForwardNavigationAbility;
        this.$intent = navigateForMultiForward;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, multiForwardNavigationAbility, navigateForMultiForward, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MultiForwardNavigationAbility$handleNavigation$1(this.this$0, this.$intent, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0084 A[LOOP:0: B:23:0x0050->B:33:0x0084, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[EDGE_INSN: B:34:0x00b0->B:35:0x00b0 BREAK  A[LOOP:0: B:23:0x0050->B:33:0x0084], SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        AIOMsgItem aIOMsgItem;
        int i3;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MsgList M = this.this$0.e().M();
                if (M.isEmpty()) {
                    return Unit.INSTANCE;
                }
                a aVar = M.get(0);
                if (aVar instanceof AIOMsgItem) {
                    aIOMsgItem = (AIOMsgItem) aVar;
                } else {
                    aIOMsgItem = null;
                }
                if (aIOMsgItem == null) {
                    return Unit.INSTANCE;
                }
                int i16 = aIOMsgItem.getMsgRecord().chatType;
                if (i16 == 1) {
                    MsgNavigationEvent.NavigateForMultiForward navigateForMultiForward = this.$intent;
                    i3 = 0;
                    for (a aVar2 : M) {
                        if (aVar2 instanceof AIOMsgItem) {
                            AIOMsgItem aIOMsgItem2 = (AIOMsgItem) aVar2;
                            if (aIOMsgItem2.getMsgRecord().clientSeq == navigateForMultiForward.a() && aIOMsgItem2.getMsgRecord().msgTime == navigateForMultiForward.c()) {
                                z17 = true;
                                if (!z17) {
                                    break;
                                }
                                i3++;
                            }
                        }
                        z17 = false;
                        if (!z17) {
                        }
                    }
                    i3 = -1;
                } else {
                    MsgNavigationEvent.NavigateForMultiForward navigateForMultiForward2 = this.$intent;
                    Iterator<a> it = M.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        if (it.next().getMsgSeq() == navigateForMultiForward2.b()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    }
                    i3 = -1;
                }
                QLog.i("MultiForwardNavigationAbility", 1, "[handleNavigation]: originChatType is " + i16 + ", clientSeq is " + this.$intent.a() + ", msgTime is " + this.$intent.c() + ", msgSeq is " + this.$intent.b() + ", pos is " + i3);
                if (i3 == -1) {
                    this.this$0.q();
                } else {
                    a.C11505a.b(this.this$0.e(), IMsgListRepository.MsgListRepoOpType.OtherOperation, null, this.this$0.o(i3, true), 2, null);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MultiForwardNavigationAbility$handleNavigation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
