package com.tencent.qqnt.msgselect.msglist;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.msgselect.msglist.MsgSelectMsgListVM$handleUpdateCheckMode$1", f = "MsgSelectMsgListVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes24.dex */
final class MsgSelectMsgListVM$handleUpdateCheckMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ MsgSelectMsgListVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgSelectMsgListVM$handleUpdateCheckMode$1(MsgSelectMsgListVM msgSelectMsgListVM, Continuation<? super MsgSelectMsgListVM$handleUpdateCheckMode$1> continuation) {
        super(2, continuation);
        this.this$0 = msgSelectMsgListVM;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgSelectMsgListVM, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MsgSelectMsgListVM$handleUpdateCheckMode$1(this.this$0, continuation);
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MsgListRepo m3 = this.this$0.m();
                MsgList M = m3.M();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                int i3 = 0;
                for (com.tencent.aio.data.msglist.a aVar : M) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar2 = aVar;
                    if (aVar2 instanceof AIOMsgItem) {
                        ?? cloneNewInstance = ((AIOMsgItem) aVar2).cloneNewInstance();
                        cloneNewInstance.B1(cloneNewInstance.V() + 1);
                        objectRef.element = cloneNewInstance;
                        M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                    }
                    i3 = i16;
                }
                if (m3 instanceof AIOMsgRepo) {
                    BaseMsgRepo.o0((BaseMsgRepo) m3, M, "msg_multi_select", null, null, 12, null);
                } else {
                    m3.d(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, null);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MsgSelectMsgListVM$handleUpdateCheckMode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
