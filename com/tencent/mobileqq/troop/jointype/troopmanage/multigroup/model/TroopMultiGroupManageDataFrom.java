package com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageDataFrom;", "", "(Ljava/lang/String;I)V", "MULTI_GROUP_MANAGE_DATA_FROM_LOCAL", "MULTI_GROUP_MANAGE_DATA_FROM_SERVER", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopMultiGroupManageDataFrom {
    private static final /* synthetic */ TroopMultiGroupManageDataFrom[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopMultiGroupManageDataFrom MULTI_GROUP_MANAGE_DATA_FROM_LOCAL;
    public static final TroopMultiGroupManageDataFrom MULTI_GROUP_MANAGE_DATA_FROM_SERVER;

    private static final /* synthetic */ TroopMultiGroupManageDataFrom[] $values() {
        return new TroopMultiGroupManageDataFrom[]{MULTI_GROUP_MANAGE_DATA_FROM_LOCAL, MULTI_GROUP_MANAGE_DATA_FROM_SERVER};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54400);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MULTI_GROUP_MANAGE_DATA_FROM_LOCAL = new TroopMultiGroupManageDataFrom("MULTI_GROUP_MANAGE_DATA_FROM_LOCAL", 0);
        MULTI_GROUP_MANAGE_DATA_FROM_SERVER = new TroopMultiGroupManageDataFrom("MULTI_GROUP_MANAGE_DATA_FROM_SERVER", 1);
        $VALUES = $values();
    }

    TroopMultiGroupManageDataFrom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TroopMultiGroupManageDataFrom valueOf(String str) {
        return (TroopMultiGroupManageDataFrom) Enum.valueOf(TroopMultiGroupManageDataFrom.class, str);
    }

    public static TroopMultiGroupManageDataFrom[] values() {
        return (TroopMultiGroupManageDataFrom[]) $VALUES.clone();
    }
}
