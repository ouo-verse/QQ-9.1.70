package com.tencent.mobileqq.troop.troopidentity.processor;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopListTempApi;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.k;
import com.tencent.qqnt.bus.event.x;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/processor/b;", "", "", "troopUin", "", "d", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "e", "b", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "troopMemberInfoExt", "", "f", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "a", "memberUin", "appIconBindData", "g", h.F, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f300409a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f300409a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(TroopInfo troopInfo) {
        GroupExt groupExt;
        if (troopInfo == null || (groupExt = troopInfo.groupExt) == null || groupExt.appIdentifierSwitch != 0 || !e(troopInfo)) {
            return false;
        }
        return true;
    }

    private final boolean d(String troopUin) {
        boolean z16;
        TroopInfo troopInfo;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        Object troopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache instanceof TroopInfo) {
            troopInfo = (TroopInfo) troopInfoFromCache;
        } else {
            troopInfo = null;
        }
        if (troopInfo == null) {
            return false;
        }
        return c(troopInfo);
    }

    private final boolean e(TroopInfo troopInfo) {
        return troopInfo.isTroopHOKGameCardEnabled();
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c a(@NotNull TroopInfo troopInfo, @Nullable TroopMemberInfoExt troopMemberInfoExt) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopInfo, (Object) troopMemberInfoExt);
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        if (troopMemberInfoExt != null) {
            long j3 = troopMemberInfoExt.flagEx3;
            boolean z19 = false;
            if (((int) (16 & j3)) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (((int) (64 & j3)) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (((int) (j3 & 128)) == 128) {
                z18 = true;
            } else {
                z18 = false;
            }
            com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c cVar = new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c(false, false, false, 0, 15, null);
            cVar.f(((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).getGlobalSwitch());
            cVar.h(!c(troopInfo));
            if (cVar.b() && cVar.d()) {
                if (b(troopInfo)) {
                    i3 = 1;
                } else {
                    i3 = troopInfo.groupExt.appIdentifierType;
                }
                cVar.e(i3);
                GroupExt groupExt = troopInfo.groupExt;
                if ((groupExt.appIdentifierSwitch == 1 && groupExt.appIdentifierType == 1) || b(troopInfo)) {
                    if (!z18) {
                        cVar.g(z16);
                    } else {
                        cVar.g(z17);
                    }
                } else {
                    if (!z18 || z17) {
                        z19 = true;
                    }
                    cVar.g(z19);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("TroopIdentityIconHandler", 4, "[getAppIconBindData] troopUin = " + troopInfo.getTroopUin() + " memberUin = " + troopMemberInfoExt.memberUin + " data = " + cVar + " isPersonalSwitchSet = " + z18);
                }
            }
            return cVar;
        }
        return null;
    }

    public final boolean c(@Nullable TroopInfo troopInfo) {
        GroupExt groupExt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo)).booleanValue();
        }
        if (troopInfo == null || (groupExt = troopInfo.groupExt) == null) {
            return false;
        }
        int i3 = groupExt.appIdentifierSwitch;
        if (i3 != 2 && (i3 != 0 || e(troopInfo))) {
            return false;
        }
        return true;
    }

    public final void f(@NotNull String troopUin, @NotNull TroopMemberInfoExt troopMemberInfoExt) {
        String str;
        TroopInfo troopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) troopMemberInfoExt);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopMemberInfoExt, "troopMemberInfoExt");
        QLog.i("TroopIdentityIconHandler", 1, "[onTroopMemberFlagEx3Change] troopUin = " + troopUin + " memberUin = " + troopMemberInfoExt.memberUin + " flag3 = " + troopMemberInfoExt.flagEx3);
        if (d(troopUin) || (str = troopMemberInfoExt.memberUin) == null) {
            return;
        }
        Object troopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache instanceof TroopInfo) {
            troopInfo = (TroopInfo) troopInfoFromCache;
        } else {
            troopInfo = null;
        }
        if (troopInfo == null) {
            return;
        }
        g(troopUin, str, a(troopInfo, troopMemberInfoExt));
    }

    public final void g(@NotNull String troopUin, @NotNull String memberUin, @Nullable com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c appIconBindData) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, memberUin, appIconBindData);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        IBusManager iBusManager = (IBusManager) QRoute.api(IBusManager.class);
        if (appIconBindData != null) {
            z16 = appIconBindData.b();
        } else {
            z16 = true;
        }
        boolean z19 = z16;
        if (appIconBindData != null) {
            z17 = appIconBindData.d();
        } else {
            z17 = false;
        }
        if (appIconBindData != null) {
            z18 = appIconBindData.c();
        } else {
            z18 = false;
        }
        if (appIconBindData != null) {
            i3 = appIconBindData.a();
        } else {
            i3 = 0;
        }
        iBusManager.sendEvent(new k(troopUin, memberUin, z19, z17, z18, i3));
    }

    public final void h(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new x(troopUin));
        }
    }
}
