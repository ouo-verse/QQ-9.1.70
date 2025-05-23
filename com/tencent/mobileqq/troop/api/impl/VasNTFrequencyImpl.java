package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IVasNTFrequency;
import com.tencent.mobileqq.vip.api.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/VasNTFrequencyImpl;", "Lcom/tencent/mobileqq/troop/api/IVasNTFrequency;", "()V", "refreshRecentColorNameFrequency", "", "requestTroopColorNameFrequency", "friendUin", "", "troopColorNameId", "", "troopUin", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class VasNTFrequencyImpl implements IVasNTFrequency {
    static IPatchRedirector $redirector_;

    public VasNTFrequencyImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IVasNTFrequency
    public void refreshRecentColorNameFrequency() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            new i.C8957i(0).d(false, 1);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IVasNTFrequency
    public void requestTroopColorNameFrequency(@NotNull String friendUin, int troopColorNameId, @NotNull String troopUin) {
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, friendUin, Integer.valueOf(troopColorNameId), troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        i.n nVar = new i.n(troopColorNameId);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(friendUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        nVar.e(true, j3, troopUin);
    }
}
