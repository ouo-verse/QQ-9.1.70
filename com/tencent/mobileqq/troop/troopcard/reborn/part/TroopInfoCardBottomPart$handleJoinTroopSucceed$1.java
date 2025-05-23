package com.tencent.mobileqq.troop.troopcard.reborn.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart", f = "TroopInfoCardBottomPart.kt", i = {0, 0, 0}, l = {691}, m = "handleJoinTroopSucceed", n = {"troopInfoWrapper", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "app"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes19.dex */
public final class TroopInfoCardBottomPart$handleJoinTroopSucceed$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TroopInfoCardBottomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoCardBottomPart$handleJoinTroopSucceed$1(TroopInfoCardBottomPart troopInfoCardBottomPart, Continuation<? super TroopInfoCardBottomPart$handleJoinTroopSucceed$1> continuation) {
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
        Object qa5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        qa5 = this.this$0.qa(null, this);
        return qa5;
    }
}
