package com.tencent.mobileqq.troop.troopgame;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopListTempApi;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.j;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/g;", "", "", "troopUin", "memberUin", "Lcom/tencent/mobileqq/troop/troopgame/MemberGradeLevelInfo;", "gradeLevelInfo", "", "gameCardSwitch", "", "e", "", h.f248218g, "c", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f300288a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f300288a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, String str2, Object obj) {
        MemberGradeLevelInfo memberGradeLevelInfo;
        if (obj instanceof MemberGradeLevelInfo) {
            memberGradeLevelInfo = (MemberGradeLevelInfo) obj;
        } else {
            memberGradeLevelInfo = null;
        }
        if (memberGradeLevelInfo != null) {
            QLog.i("TroopGameSwitchUpdateHandler", 1, "[onMemberHOKSwitchUpdate] callback, gradeLevelInfo = " + obj);
            f300288a.e(str, str2, (MemberGradeLevelInfo) obj, 1);
        }
    }

    private final void e(String troopUin, String memberUin, MemberGradeLevelInfo gradeLevelInfo, int gameCardSwitch) {
        int i3;
        int i16;
        IBusManager iBusManager = (IBusManager) QRoute.api(IBusManager.class);
        if (gradeLevelInfo != null) {
            i3 = gradeLevelInfo.gradeLevel;
        } else {
            i3 = 0;
        }
        if (gradeLevelInfo != null) {
            i16 = gradeLevelInfo.gameCardId;
        } else {
            i16 = 0;
        }
        iBusManager.sendEvent(new j(troopUin, memberUin, i3, i16, gameCardSwitch));
    }

    public final boolean b(@Nullable String troopUin) {
        boolean z16;
        TroopInfo troopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin)).booleanValue();
        }
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
        return troopInfo.isTroopHOKGameCardEnabled();
    }

    public final void c(@Nullable final String troopUin, @Nullable final String memberUin, boolean isOpen) {
        boolean z16;
        boolean z17;
        MemberGradeLevelInfo tryGetMemberGradeLevelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, memberUin, Boolean.valueOf(isOpen));
            return;
        }
        QLog.i("TroopGameSwitchUpdateHandler", 1, "[onHOKSwitchUpdate] isUserOpen = " + isOpen + " troopUin = " + troopUin + " memberUin = " + memberUin);
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (memberUin != null && memberUin.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (!isOpen) {
                    e(troopUin, memberUin, null, 0);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null && (tryGetMemberGradeLevelInfo = ((ITroopGameCardService) peekAppRuntime.getRuntimeService(ITroopGameCardService.class, "")).tryGetMemberGradeLevelInfo(memberUin, new ITroopGameCardService.a() { // from class: com.tencent.mobileqq.troop.troopgame.f
                    @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.a
                    public final void onResult(Object obj) {
                        g.d(troopUin, memberUin, obj);
                    }
                })) != null) {
                    QLog.i("TroopGameSwitchUpdateHandler", 1, "[onMemberHOKSwitchUpdate] cache, gradeLevelInfo = " + tryGetMemberGradeLevelInfo);
                    f300288a.e(troopUin, memberUin, tryGetMemberGradeLevelInfo, 1);
                }
            }
        }
    }
}
