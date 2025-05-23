package com.tencent.mobileqq.troop.troopcard.reborn.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart", f = "TroopInfoCardBottomPart.kt", i = {0, 0}, l = {PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE, 578}, m = "joinTroopDirectly", n = {"this", "troopInfoWrapper"}, s = {"L$0", "L$1"})
/* loaded from: classes19.dex */
public final class TroopInfoCardBottomPart$joinTroopDirectly$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TroopInfoCardBottomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoCardBottomPart$joinTroopDirectly$1(TroopInfoCardBottomPart troopInfoCardBottomPart, Continuation<? super TroopInfoCardBottomPart$joinTroopDirectly$1> continuation) {
        super(continuation);
        this.this$0 = troopInfoCardBottomPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfoCardBottomPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Aa;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Aa = this.this$0.Aa(null, this);
        return Aa;
    }
}
