package com.tencent.mobileqq.troop.createtroopblacklist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/createtroopblacklist/CreateTroopUnblockType;", "", "(Ljava/lang/String;I)V", "FACE", "TIME", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class CreateTroopUnblockType {
    private static final /* synthetic */ CreateTroopUnblockType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final CreateTroopUnblockType FACE;
    public static final CreateTroopUnblockType TIME;

    private static final /* synthetic */ CreateTroopUnblockType[] $values() {
        return new CreateTroopUnblockType[]{FACE, TIME};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23250);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FACE = new CreateTroopUnblockType("FACE", 0);
        TIME = new CreateTroopUnblockType("TIME", 1);
        $VALUES = $values();
    }

    CreateTroopUnblockType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static CreateTroopUnblockType valueOf(String str) {
        return (CreateTroopUnblockType) Enum.valueOf(CreateTroopUnblockType.class, str);
    }

    public static CreateTroopUnblockType[] values() {
        return (CreateTroopUnblockType[]) $VALUES.clone();
    }
}
