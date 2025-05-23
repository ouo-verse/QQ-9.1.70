package com.tencent.mobileqq.troopAddFrd.nt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/msg/d;", "list", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troopAddFrd.nt.NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1", f = "NtTroopMsgHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1 extends SuspendLambda implements Function2<List<? extends com.tencent.qqnt.msg.d>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NtTroopMsgHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1(NtTroopMsgHelper ntTroopMsgHelper, Continuation<? super NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ntTroopMsgHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ntTroopMsgHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1 ntTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1 = new NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1(this.this$0, continuation);
        ntTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1.L$0 = obj;
        return ntTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<com.tencent.qqnt.msg.d> list = (List) this.L$0;
                NtTroopMsgHelper ntTroopMsgHelper = this.this$0;
                for (com.tencent.qqnt.msg.d dVar : list) {
                    if ((dVar.a().atType & 4) != 0) {
                        ntTroopMsgHelper.d(dVar, false);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends com.tencent.qqnt.msg.d> list, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
    }
}
