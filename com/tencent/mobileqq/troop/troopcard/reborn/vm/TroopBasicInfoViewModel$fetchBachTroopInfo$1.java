package com.tencent.mobileqq.troop.troopcard.reborn.vm;

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
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel", f = "TroopBasicInfoViewModel.kt", i = {0, 0}, l = {425, 431}, m = "fetchBachTroopInfo", n = {"this", "troopInfoWrapper"}, s = {"L$0", "L$1"})
/* loaded from: classes19.dex */
public final class TroopBasicInfoViewModel$fetchBachTroopInfo$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TroopBasicInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBasicInfoViewModel$fetchBachTroopInfo$1(TroopBasicInfoViewModel troopBasicInfoViewModel, Continuation<? super TroopBasicInfoViewModel$fetchBachTroopInfo$1> continuation) {
        super(continuation);
        this.this$0 = troopBasicInfoViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopBasicInfoViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object p26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        p26 = this.this$0.p2(null, this);
        return p26;
    }
}
