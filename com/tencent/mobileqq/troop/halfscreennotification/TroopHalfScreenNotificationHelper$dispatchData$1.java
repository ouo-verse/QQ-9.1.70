package com.tencent.mobileqq.troop.halfscreennotification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationHelper", f = "TroopHalfScreenNotificationHelper.kt", i = {0, 0, 0, 0}, l = {141}, m = "dispatchData", n = {"this", "data", "it", "cancelled"}, s = {"L$0", "L$1", "L$3", "I$0"})
/* loaded from: classes19.dex */
public final class TroopHalfScreenNotificationHelper$dispatchData$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TroopHalfScreenNotificationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHalfScreenNotificationHelper$dispatchData$1(TroopHalfScreenNotificationHelper troopHalfScreenNotificationHelper, Continuation<? super TroopHalfScreenNotificationHelper$dispatchData$1> continuation) {
        super(continuation);
        this.this$0 = troopHalfScreenNotificationHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopHalfScreenNotificationHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c16 = this.this$0.c(null, this);
        return c16;
    }
}
