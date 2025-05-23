package com.tencent.mobileqq.aio.msglist;

import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.event.AIOMsgEvent;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/n;", "rsp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$getFirstUnreadMsgSeq$1", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgRepo$getFirstUnreadMsgSeq$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.aio.msg.service.n, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$getFirstUnreadMsgSeq$1(AIOMsgRepo aIOMsgRepo, Continuation<? super AIOMsgRepo$getFirstUnreadMsgSeq$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOMsgRepo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgRepo, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgRepo$getFirstUnreadMsgSeq$1 aIOMsgRepo$getFirstUnreadMsgSeq$1 = new AIOMsgRepo$getFirstUnreadMsgSeq$1(this.this$0, continuation);
        aIOMsgRepo$getFirstUnreadMsgSeq$1.L$0 = obj;
        return aIOMsgRepo$getFirstUnreadMsgSeq$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.aio.msg.service.n nVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$getFirstUnreadMsgSeq$1) create(nVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) nVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.b bVar;
        long j3;
        com.tencent.aio.api.runtime.a D;
        long j16;
        com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.b bVar2;
        long j17;
        com.tencent.aio.data.msglist.a aVar;
        long j18;
        com.tencent.aio.api.runtime.a D2;
        WeakReference weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.aio.msg.service.n nVar = (com.tencent.mobileqq.aio.msg.service.n) this.L$0;
                QLog.d("AIOMsgRepo", 1, "getFirstUnreadMsgSeq result=" + nVar.c() + ", errMsg=" + nVar.a() + ", seq=" + nVar.b());
                if (nVar.c() == 0) {
                    this.this$0.mFirstUnreadSeq = nVar.b();
                    bVar = this.this$0.mNewMsgTipHelper;
                    j3 = this.this$0.mFirstUnreadSeq;
                    bVar.a(j3);
                    D = this.this$0.D();
                    com.tencent.mvi.base.route.j e16 = D.e();
                    j16 = this.this$0.mFirstUnreadSeq;
                    e16.h(new AIOMsgEvent.FirstUnreadSeqUpdateEvent(j16));
                    bVar2 = this.this$0.mNewMsgTipHelper;
                    MsgList M = this.this$0.M();
                    j17 = this.this$0.mFirstUnreadSeq;
                    aVar = this.this$0.mEnterLatestMsg;
                    if (aVar != null) {
                        j18 = aVar.getMsgSeq();
                    } else {
                        j18 = -1;
                    }
                    D2 = this.this$0.D();
                    int b16 = bVar2.b(M, j17, j18, D2.g().r().c());
                    if (b16 >= 0 && b16 < this.this$0.M().size()) {
                        weakReference = this.this$0.weakMsgListVMApi;
                        y yVar = (y) weakReference.get();
                        if (yVar != null) {
                            yVar.f(b16, 1, new com.tencent.mobileqq.aio.msglist.payload.b().b(AIOMsgItemPayloadType.NEW_MSG_TIP_LINE, a.af.f192621a).a());
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
