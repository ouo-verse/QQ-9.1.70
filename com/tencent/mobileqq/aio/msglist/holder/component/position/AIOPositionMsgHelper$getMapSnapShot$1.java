package com.tencent.mobileqq.aio.msglist.holder.component.position;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.position.AIOPositionMsgHelper", f = "AIOPositionMsgHelper.kt", i = {}, l = {156}, m = "getMapSnapShot", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOPositionMsgHelper$getMapSnapShot$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIOPositionMsgHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOPositionMsgHelper$getMapSnapShot$1(AIOPositionMsgHelper aIOPositionMsgHelper, Continuation<? super AIOPositionMsgHelper$getMapSnapShot$1> continuation) {
        super(continuation);
        this.this$0 = aIOPositionMsgHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOPositionMsgHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        r16 = this.this$0.r(0.0d, 0.0d, false, this);
        return r16;
    }
}
