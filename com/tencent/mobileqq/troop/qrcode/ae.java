package com.tencent.mobileqq.troop.qrcode;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/ae;", "", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "", "a", "b", "", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ae {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ae f298175a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f298175a = new ae();
        }
    }

    ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfoData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopInfoData, "<this>");
        boolean hasPayPrivilege = TroopInfo.hasPayPrivilege(troopInfoData.mTroopPrivilegeFlag, 128);
        boolean hasPayPrivilege2 = TroopInfo.hasPayPrivilege(troopInfoData.mTroopPrivilegeFlag, 512);
        if (troopInfoData.cGroupOption == 3 && (!hasPayPrivilege || !hasPayPrivilege2)) {
            return true;
        }
        return false;
    }

    public final boolean b(@NotNull TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfoData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopInfoData, "<this>");
        if ((troopInfoData.dwGroupFlagExt & 128) != 0 && !troopInfoData.bAdmin && !troopInfoData.bOwner) {
            return true;
        }
        return false;
    }

    public final int c(@NotNull TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopInfoData)).intValue();
        }
        Intrinsics.checkNotNullParameter(troopInfoData, "<this>");
        if (troopInfoData.bOwner) {
            return 0;
        }
        if (troopInfoData.bAdmin) {
            return 1;
        }
        if (troopInfoData.isMember) {
            return 2;
        }
        return 3;
    }
}
