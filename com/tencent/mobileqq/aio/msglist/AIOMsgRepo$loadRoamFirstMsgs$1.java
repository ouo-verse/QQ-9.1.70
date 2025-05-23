package com.tencent.mobileqq.aio.msglist;

import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/p;", "Lcom/tencent/aio/data/msglist/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadRoamFirstMsgs$1", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgRepo$loadRoamFirstMsgs$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.aio.msg.service.p<com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $startTime;
    final /* synthetic */ boolean $successDbMs;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$loadRoamFirstMsgs$1(AIOMsgRepo aIOMsgRepo, boolean z16, long j3, Continuation<? super AIOMsgRepo$loadRoamFirstMsgs$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOMsgRepo;
        this.$successDbMs = z16;
        this.$startTime = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOMsgRepo, Boolean.valueOf(z16), Long.valueOf(j3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgRepo$loadRoamFirstMsgs$1 aIOMsgRepo$loadRoamFirstMsgs$1 = new AIOMsgRepo$loadRoamFirstMsgs$1(this.this$0, this.$successDbMs, this.$startTime, continuation);
        aIOMsgRepo$loadRoamFirstMsgs$1.L$0 = obj;
        return aIOMsgRepo$loadRoamFirstMsgs$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.aio.msg.service.p<com.tencent.aio.data.msglist.a> pVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$loadRoamFirstMsgs$1) create(pVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) pVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.aio.api.runtime.a D;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.Z0((com.tencent.mobileqq.aio.msg.service.p) this.L$0, this.$successDbMs);
                D = this.this$0.D();
                D.e().h(new AIOMsgListEvent.LoadRoamFirstMsgEvent(4));
                com.tencent.qqnt.trace.perf.c.INSTANCE.a().d(new com.tencent.qqnt.trace.perf.data.c(0L, System.currentTimeMillis() - this.$startTime, 0L, 0L, 13, null));
                com.tencent.aio.pref.a.f69788j.c("requestService");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
