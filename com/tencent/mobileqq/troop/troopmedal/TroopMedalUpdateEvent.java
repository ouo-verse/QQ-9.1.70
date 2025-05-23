package com.tencent.mobileqq.troop.troopmedal;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtMedalData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmedal/TroopMedalUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "troopUin", "", "medalData", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtMedalData;", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtMedalData;)V", "getMedalData", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtMedalData;", "getTroopUin", "()Ljava/lang/String;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopMedalUpdateEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final GroupExtMedalData medalData;

    @NotNull
    private final String troopUin;

    public TroopMedalUpdateEvent(@NotNull String troopUin, @Nullable GroupExtMedalData groupExtMedalData) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin, (Object) groupExtMedalData);
        } else {
            this.troopUin = troopUin;
            this.medalData = groupExtMedalData;
        }
    }

    @Nullable
    public final GroupExtMedalData getMedalData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (GroupExtMedalData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.medalData;
    }

    @NotNull
    public final String getTroopUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }
}
