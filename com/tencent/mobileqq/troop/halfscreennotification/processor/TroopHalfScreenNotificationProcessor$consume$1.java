package com.tencent.mobileqq.troop.halfscreennotification.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.troop.halfscreennotification.processor.TroopHalfScreenNotificationProcessor", f = "TroopHalfScreenNotificationProcessor.kt", i = {0, 0, 0}, l = {113}, m = "consume", n = {"this", "data", "dialog"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes19.dex */
public final class TroopHalfScreenNotificationProcessor$consume$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TroopHalfScreenNotificationProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHalfScreenNotificationProcessor$consume$1(TroopHalfScreenNotificationProcessor troopHalfScreenNotificationProcessor, Continuation<? super TroopHalfScreenNotificationProcessor$consume$1> continuation) {
        super(continuation);
        this.this$0 = troopHalfScreenNotificationProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopHalfScreenNotificationProcessor, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
