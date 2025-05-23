package com.tencent.qqnt.aio.troophistory.list;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.troophistory.list.TroopHistoryMsgAIORepo$loadPrePage$1", f = "TroopHistoryMsgAIORepo.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class TroopHistoryMsgAIORepo$loadPrePage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopHistoryMsgAIORepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHistoryMsgAIORepo$loadPrePage$1(TroopHistoryMsgAIORepo troopHistoryMsgAIORepo, Continuation<? super TroopHistoryMsgAIORepo$loadPrePage$1> continuation) {
        super(2, continuation);
        this.this$0 = troopHistoryMsgAIORepo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopHistoryMsgAIORepo, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopHistoryMsgAIORepo$loadPrePage$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object firstOrNull;
        AIOMsgItem aIOMsgItem;
        MsgRecord msgRecord;
        d z06;
        List reversed;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.this$0.M());
                if (firstOrNull instanceof AIOMsgItem) {
                    aIOMsgItem = (AIOMsgItem) firstOrNull;
                } else {
                    aIOMsgItem = null;
                }
                if (aIOMsgItem != null && (msgRecord = aIOMsgItem.getMsgRecord()) != null) {
                    z06 = this.this$0.z0();
                    long j3 = msgRecord.msgId;
                    long j16 = msgRecord.msgTime;
                    long j17 = msgRecord.msgSeq;
                    this.label = 1;
                    obj = z06.h(true, j3, j16, j17, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
            c cVar = (c) obj;
            if (cVar.c()) {
                TroopHistoryMsgAIORepo troopHistoryMsgAIORepo = this.this$0;
                reversed = CollectionsKt___CollectionsKt.reversed(cVar.b());
                troopHistoryMsgAIORepo.x0(reversed, IMsgListRepository.MsgListRepoOpType.LoadPrePage);
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopHistoryMsgAIORepo$loadPrePage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
