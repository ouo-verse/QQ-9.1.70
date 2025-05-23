package com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/TroopMultiGroupManageItemType;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "MULTI_GROUP_MANAGE_DATA", "MULTI_GROUP_MANAGE_OPERATION", "MULTI_GROUP_MANAGE_SETTING", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopMultiGroupManageItemType {
    private static final /* synthetic */ TroopMultiGroupManageItemType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopMultiGroupManageItemType MULTI_GROUP_MANAGE_DATA;
    public static final TroopMultiGroupManageItemType MULTI_GROUP_MANAGE_OPERATION;
    public static final TroopMultiGroupManageItemType MULTI_GROUP_MANAGE_SETTING;
    private final int index;

    private static final /* synthetic */ TroopMultiGroupManageItemType[] $values() {
        return new TroopMultiGroupManageItemType[]{MULTI_GROUP_MANAGE_DATA, MULTI_GROUP_MANAGE_OPERATION, MULTI_GROUP_MANAGE_SETTING};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        MULTI_GROUP_MANAGE_DATA = new TroopMultiGroupManageItemType("MULTI_GROUP_MANAGE_DATA", 0, 0);
        MULTI_GROUP_MANAGE_OPERATION = new TroopMultiGroupManageItemType("MULTI_GROUP_MANAGE_OPERATION", 1, 1);
        MULTI_GROUP_MANAGE_SETTING = new TroopMultiGroupManageItemType("MULTI_GROUP_MANAGE_SETTING", 2, 2);
        $VALUES = $values();
    }

    TroopMultiGroupManageItemType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.index = i16;
        }
    }

    public static TroopMultiGroupManageItemType valueOf(String str) {
        return (TroopMultiGroupManageItemType) Enum.valueOf(TroopMultiGroupManageItemType.class, str);
    }

    public static TroopMultiGroupManageItemType[] values() {
        return (TroopMultiGroupManageItemType[]) $VALUES.clone();
    }

    public final int getIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.index;
    }
}
