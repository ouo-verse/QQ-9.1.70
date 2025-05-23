package com.tencent.mobileqq.troop.homework.common.trooplist.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/TroopItemType;", "", "(Ljava/lang/String;I)V", "ITEM_TYPE_HEADER", "ITEM_TYPE_INFO", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopItemType {
    private static final /* synthetic */ TroopItemType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopItemType ITEM_TYPE_HEADER;
    public static final TroopItemType ITEM_TYPE_INFO;

    private static final /* synthetic */ TroopItemType[] $values() {
        return new TroopItemType[]{ITEM_TYPE_HEADER, ITEM_TYPE_INFO};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ITEM_TYPE_HEADER = new TroopItemType("ITEM_TYPE_HEADER", 0);
        ITEM_TYPE_INFO = new TroopItemType("ITEM_TYPE_INFO", 1);
        $VALUES = $values();
    }

    TroopItemType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TroopItemType valueOf(String str) {
        return (TroopItemType) Enum.valueOf(TroopItemType.class, str);
    }

    public static TroopItemType[] values() {
        return (TroopItemType[]) $VALUES.clone();
    }
}
