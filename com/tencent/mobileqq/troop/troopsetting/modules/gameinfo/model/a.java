package com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/a;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f301168a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301168a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a(@Nullable TroopInfo troopInfo) {
        boolean z16 = false;
        if (troopInfo == null) {
            QLog.e("TroopGameInfoConfig", 1, "[enableShowGameCard] invalid params");
            return false;
        }
        if (!troopInfo.isHomeworkTroop() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            z16 = true;
        }
        QLog.d("TroopGameInfoConfig", 2, "[enableShowGameCard] enableShow = " + z16);
        return z16;
    }
}
