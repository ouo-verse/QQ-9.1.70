package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/TroopMemberDistinctResultListItemType;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "USER", "GROUP", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopMemberDistinctResultListItemType {
    private static final /* synthetic */ TroopMemberDistinctResultListItemType[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: GROUP, reason: collision with root package name */
    public static final TroopMemberDistinctResultListItemType f300565GROUP;
    public static final TroopMemberDistinctResultListItemType USER;
    private final int index;

    private static final /* synthetic */ TroopMemberDistinctResultListItemType[] $values() {
        return new TroopMemberDistinctResultListItemType[]{USER, f300565GROUP};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58324);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        USER = new TroopMemberDistinctResultListItemType("USER", 0, 0);
        f300565GROUP = new TroopMemberDistinctResultListItemType("GROUP", 1, 1);
        $VALUES = $values();
    }

    TroopMemberDistinctResultListItemType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.index = i16;
        }
    }

    public static TroopMemberDistinctResultListItemType valueOf(String str) {
        return (TroopMemberDistinctResultListItemType) Enum.valueOf(TroopMemberDistinctResultListItemType.class, str);
    }

    public static TroopMemberDistinctResultListItemType[] values() {
        return (TroopMemberDistinctResultListItemType[]) $VALUES.clone();
    }

    public final int getIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.index;
    }
}
