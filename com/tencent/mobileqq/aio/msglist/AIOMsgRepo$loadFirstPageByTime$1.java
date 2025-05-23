package com.tencent.mobileqq.aio.msglist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RoamDatemsg;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/r;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadFirstPageByTime$1", f = "AIOMsgRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMsgRepo$loadFirstPageByTime$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.aio.msg.service.r, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $ignoreErrCode;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMsgRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo$loadFirstPageByTime$1(boolean z16, AIOMsgRepo aIOMsgRepo, Continuation<? super AIOMsgRepo$loadFirstPageByTime$1> continuation) {
        super(2, continuation);
        this.$ignoreErrCode = z16;
        this.this$0 = aIOMsgRepo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), aIOMsgRepo, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMsgRepo$loadFirstPageByTime$1 aIOMsgRepo$loadFirstPageByTime$1 = new AIOMsgRepo$loadFirstPageByTime$1(this.$ignoreErrCode, this.this$0, continuation);
        aIOMsgRepo$loadFirstPageByTime$1.L$0 = obj;
        return aIOMsgRepo$loadFirstPageByTime$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.aio.msg.service.r rVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMsgRepo$loadFirstPageByTime$1) create(rVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) rVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Long l3;
        Long l16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.aio.msg.service.r rVar = (com.tencent.mobileqq.aio.msg.service.r) this.L$0;
                int b16 = rVar.b();
                String a16 = rVar.a();
                RoamDatemsg c16 = rVar.c();
                Long l17 = null;
                if (c16 != null) {
                    l3 = Boxing.boxLong(c16.msgSeq);
                } else {
                    l3 = null;
                }
                RoamDatemsg c17 = rVar.c();
                if (c17 != null) {
                    l16 = Boxing.boxLong(c17.clientSeq);
                } else {
                    l16 = null;
                }
                RoamDatemsg c18 = rVar.c();
                if (c18 != null) {
                    l17 = Boxing.boxLong(c18.msgTime);
                }
                QLog.i("AIOMsgRepo", 1, "[loadFirstPageByTime rsp]: result is " + b16 + ", errMsg is " + a16 + ", msgSeq is " + l3 + ", clienSeq is " + l16 + ", msgTime is " + l17 + ", ignoreErrCode is " + this.$ignoreErrCode);
                if ((rVar.b() == 0 || this.$ignoreErrCode) && rVar.c() != null) {
                    this.this$0.k1(rVar.c(), this.$ignoreErrCode);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
